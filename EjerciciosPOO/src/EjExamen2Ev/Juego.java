package EjExamen2Ev;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Juego extends Applet implements Runnable {
    int delay = 20;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Color [] colores = {Color.RED, Color.ORANGE, Color.GREEN, Color.YELLOW, Color.MAGENTA};
    List<rectanguloInmovil> cuadradosAbajo = new ArrayList<rectanguloInmovil>();
    List<rectanguloMovil> cuadradosArriba = new ArrayList<rectanguloMovil>();
    List<Linea> lineas = new ArrayList<Linea>();
    Linea actual;

    public void init(){
        createWindow();

        for(int i = 0; i < colores.length; i++)
            cuadradosAbajo.add(new rectanguloInmovil(i, colores[i]));
        for(int i = 0; i < colores.length; i++)
            cuadradosArriba.add(new rectanguloMovil(i, colores[i]));
        this.setSize(600, 600);

        imagen = this.createImage(600, 600);
        noseve = imagen.getGraphics();
    }
    private void createWindow() {
        Frame title = (Frame) this.getParent().getParent(); //obtenemos la ventana para
        title.setTitle("Examen 2Ev"); //cambiamos el nombre de la ventana
        this.setSize(600, 600); //tamaño de la ventana
        title.setMenuBar(null); //elimina la barra de menu de applet
        this.setFocusable(true); //para poder usar el teclado directamente
        this.requestFocus();
    }
    public void start(){
        animacion = new Thread(this);//lo instanciamos y le pasamos this (el frame)
        animacion.start();//es el que llama a ejecutar el método run
    }
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 600, 600);

        for(rectanguloInmovil ci : cuadradosAbajo)
            ci.paint(noseve);

        for(rectanguloMovil cm : cuadradosArriba)
            cm.paint(noseve);

        if(actual != null)
            actual.paint(noseve);

        if(!lineas.isEmpty())
            for(Linea li : lineas)
                li.paint(noseve);


        g.drawImage(imagen, 0, 0, this);
    }

    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }

    public void run(){
        while(true){
            for(rectanguloMovil cm : cuadradosArriba){
                cm.update();
                if(!lineas.isEmpty())
                    for(Linea li : lineas){
                        li.update();
                    }

            }

            repaint();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex){
            }
        }
    }
    public boolean mouseDown(Event ev, int x, int y){
        for(rectanguloInmovil ci : cuadradosAbajo){
            if(ci.contains(x, y)){
                actual = new Linea(x, y, ci.color);
                repaint();
                return true;
            }
        }


        return false;
    }
    public boolean mouseDrag(Event ev, int x, int y){//cuando haces click y sin soltar, mueves
        if(actual != null){
            actual.setPosFinX(x);
            actual.setPosFinY(y);
            for(Linea li: lineas)
                if(li.getColor()==actual.getColor()){
                    actual = null;
                    break;
                }

            repaint();
        }

        return true;
    }
    public boolean mouseUp(Event ev, int x, int y){
        for(rectanguloMovil cm : cuadradosArriba){
            if(actual != null && cm.contains(x, y) && cm.color == actual.getColor()){
                lineas.add(new Linea(actual.getPosIniX(), actual.getPosIniY(), cm));
                actual = null;
                repaint();
                break;
            }
        }
        actual = null;
        return true;
    }
}
