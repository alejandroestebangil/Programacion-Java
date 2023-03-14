package Ej021;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Dino extends Applet implements Runnable {
    public static int TIEMPO = 20;
    public static final int POSINICIAL = 300;
    public static final int TIEMPOMAX = 2300;
    public static final int TIEMPOMIN = 1000;
    public int espera;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    int milisegundos = 0;
    boolean gameOver = false;
    ArrayList<Rectangulo> rectangulos;
    Muneco muneco;

    public void init(){
        Frame title = (Frame) this.getParent().getParent();
        title.setTitle("Google Dino"); //cambiamos el nombre de la ventana
        this.setSize(300, 300); //tamaño de la ventana
        title.setMenuBar(null); //elimina la barra de menu de applet

        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();

        this.setFocusable(true); //para poder usar el teclado directamente
        this.requestFocus();

        rectangulos = new ArrayList<Rectangulo>();
        rectangulos.add(new Rectangulo((int)(Math.random()*6)+10));
        espera = (int)(Math.random()*(TIEMPOMAX-TIEMPOMIN))+TIEMPOMIN;
        muneco = new Muneco();
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start(); // llama al metodo run
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0,0,400,400);
        noseve.setColor(Color.WHITE);
        noseve.fillRect(0,250, 300, 2);

        for (int i=0; i<rectangulos.size(); i++) {
            rectangulos.get(i).paint(noseve);
        }
        muneco.paint(noseve);
        
        if (gameOver)
            gameOver();

        g.drawImage(imagen,0,0, this);
    }
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        do {
            milisegundos += TIEMPO;
            if (milisegundos > espera) {
                milisegundos = 0;
                espera = (int)(Math.random()*(TIEMPOMAX-TIEMPOMIN))+TIEMPOMIN;
                rectangulos.add(new Rectangulo((int)(Math.random()*6)+10));
            }
            if (rectangulos.get(0).x < -20) {
                rectangulos.remove(0);
            }
            if(rectangulos.get(0).intersects(muneco)){
                gameOver = true;
                repaint();
                animacion.suspend();
            }
            for (int i=0; i<rectangulos.size(); i++) {
                rectangulos.get(i).update();
            }
            muneco.update();
            repaint();
            try {
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){}
        } while (true);
    }
    
    public boolean keyDown(Event e, int key){
        if (key == 32) { //SALTO
            muneco.setSalto(true);
        }
        if (key == 114 && gameOver) { //REINICIO
            gameOver = false;
            //quita los rectangulos
            for (int i=rectangulos.size()-1; i>=0; i--) {
                rectangulos.remove(i);
            }
            rectangulos.add(new Rectangulo((int)(Math.random()*6)+10));
            espera = (int)(Math.random()*(TIEMPOMAX-TIEMPOMIN))+TIEMPOMIN;
            muneco = new Muneco();
            animacion.resume();
        }
        return true;
    }

    private void gameOver() {
        noseve.setFont(new Font("Arial", Font.BOLD, 40));
        noseve.setColor(Color.DARK_GRAY);
        noseve.drawString("GAME OVER", 26, 147);
        noseve.drawString("GAME OVER", 26, 149);
        noseve.drawString("GAME OVER", 24, 147);
        noseve.drawString("GAME OVER", 24, 149);
        noseve.setFont(new Font("Arial",Font.BOLD,14));
        noseve.drawString("Pulsa 'R' para reiniciar",76,167);
        noseve.drawString("Pulsa 'R' para reiniciar",76,169);
        noseve.drawString("Pulsa 'R' para reiniciar",74,167);
        noseve.drawString("Pulsa 'R' para reiniciar",74,169);

        noseve.setFont(new Font("Arial", Font.BOLD, 40));
        noseve.setColor(Color.LIGHT_GRAY);
        noseve.drawString("GAME OVER", 25, 148);
        noseve.setFont(new Font("Arial",Font.BOLD,14));
        noseve.drawString("Pulsa 'R' para reiniciar",75,168);
    }
}
