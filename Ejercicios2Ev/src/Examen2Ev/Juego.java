package Examen2Ev;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Juego extends Applet implements Runnable {
    Thread animacion;
    Image imagen;
    Graphics noseve;

    public static int TIEMPO = 20;
    public static final int POSINICIAL = 300;
    public static final int TIEMPOMAX = 2300;
    public static final int TIEMPOMIN = 1000;
    public int espera;
    int milisegundos = 0;
    boolean gameOver = false;

    public void init(){
        Frame title = (Frame) this.getParent().getParent();
        title.setTitle("Google Dino"); //cambiamos el nombre de la ventana
        this.setSize(300, 300); //tamaño de la ventana
        title.setMenuBar(null); //elimina la barra de menu de applet

        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();

        this.setFocusable(true); //para poder usar el teclado directamente
        this.requestFocus();

    }

    public void start(){
        animacion = new Thread(this);
        animacion.start(); // llama al metodo run
    }

    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0,0,400,400);



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
            }

            repaint();
            try {
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){}
        } while (true);
    }

    public boolean keyDown(Event e, int key){
        if (key == 32) {
        }
        return true;
    }

    private void gameOver() {
    }
}