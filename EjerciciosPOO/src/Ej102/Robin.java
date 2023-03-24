/*
Hay que hacer un robin hood que se mueva en el eje de las y solo, y que cuando se
pulse la barra espaciadora, dispare una flecha que se mueva en el eje de las x.
Cuando la flecha toque a un globo, se elimine el globo y se sume un punto.
Cuando se eliminen todos los globos, se acabe el juego y se muestre el número de puntos conseguidos.
*/
package Ej102;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class Robin extends Applet implements Runnable {
    public static final int ROWS = 3;
    public static final int COLUMNS = 4;
    public static final int NUM_GLOBOS = 4;
    public static final int TIEMPO = 25;
    private static final int MAXFLECHAS = 5;
    private Thread animacion;
    private Image imagen;
    private Graphics noseve;
    public final static int SIZEX = 1000;
    public final static int SIZEY = 600;
    Image robin, fondo, flechaImg;
    Image[] globoImg;
    Arquero arquero;
    ArrayList<Globo> globos;
    ArrayList<Flecha> flechas;
    int contGlobos = 0;
    int score = 0;

    public void init(){
        Frame title = (Frame) this.getParent().getParent();
        title.setTitle("Robin Hood"); //cambiamos el nombre de la ventana
        this.setSize(SIZEX, SIZEY);
        title.setMenuBar(null); //elimina la barra de menu de applet
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics();
        this.setFocusable(true); //para poder usar el teclado directamente
        this.requestFocus();

        fondo = getImage(getCodeBase(), "Ej102/Robin/robinhoodFondo.jpg");
        robin = getImage(getCodeBase(), "Ej102/Robin/robin.png");
        flechaImg = getImage(getCodeBase(), "Ej102/Robin/flecha.png");
        globoImg = new Image[NUM_GLOBOS];
        for (int i = 0; i < NUM_GLOBOS; i++) {
            globoImg[i] = getImage(getCodeBase(), "Ej102/Robin/globo" + i + ".png");
        }

        arquero = new Arquero(robin);
        globos = new ArrayList<Globo>();
        globos.add(new Globo(globoImg[(int) (Math.random() * NUM_GLOBOS)-1]));
        flechas = new ArrayList<Flecha>();
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }

    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, SIZEX, SIZEY);
        noseve.drawImage(fondo, 0, 0, 1000, 600, this);

        arquero.paint(noseve, this);
        for (Globo g1 : globos) {
            g1.paint(noseve, this);
        }
        for (Flecha f1 : flechas) {
            f1.paint(noseve, this);
        }

        //SCOREBOARD
        noseve.setColor(Color.WHITE);
        noseve.setFont(new Font("Arial", Font.BOLD, 22));
        noseve.drawString("Score: " + score, 890, 587);

        g.drawImage(imagen, 0, 0, this);
    }

    public void update(Graphics g){
        paint(g);

    }

    public void run(){
        while(true){
            //Cada 3 segundos (3000ms) se crea un globo
            contGlobos += TIEMPO;
            if (contGlobos >= 3500) {
                contGlobos = 0;
                globos.add(new Globo(globoImg[(int) (Math.random() * NUM_GLOBOS)]));
            }

            //Se actualiza la posicion de los globos
            for (Globo g1 : globos) {
                g1.update();
            }

            //Se elimina el globo si se sale de la pantalla
            for (int i = 0; i < globos.size(); i++) {
                if (globos.get(i).y < -100) {
                    globos.remove(i);
                }
            }

            //Se actualiza la posicion de las flechas
            for(int i=0; i<flechas.size(); i++){
                flechas.get(i).update();
                if(flechas.get(i).x > 1100) //eliminar las flechas cuando salgan de pantalla
                    flechas.remove(i);
                    //podriamos hacerlo fuera del bucle y solo eliminar 0 al ser la primera cada vez
            }

            //Si una flecha intersecta con un globo, se elimina el globo y la flecha
            for (int i = 0; i < flechas.size(); i++) {
                for (int j = 0; j < globos.size(); j++) {
                    if (flechas.get(i).intersects(globos.get(j))) {
                        flechas.remove(i);
                        globos.remove(j);
                        score++;
                    }
                }
            }

            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException ex){
                System.out.println("Error en el thread");
            }
        }
    }

    //Metodo para detectar el movimiento del raton y actualizar la posicion del arquero
    public boolean mouseMove(Event ev, int x, int y){
        arquero.update(y-30);
        return true;
    }

    //Metodo para detectar cuando hacaes click y disparar una flecha
    public boolean mouseDown(Event ev, int x, int y){
        if(flechas.size() < MAXFLECHAS)
            flechas.add(new Flecha(flechaImg, y));
        return true;
    }
}
