package Ej013;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;


public class Mondrian extends Applet implements Runnable{
    public static final int DERECHA = 0;
    public static final int ABAJO = 1;
    public static final int IZQUIERDA = 2;
    public static final int ARRIBA = 3;
    public int direccion ;

    int posX = 80;
    int posY = 100;
    Thread animacion ;

    Image imagen;
    Graphics noseve;

    public void init(){
        this.setSize(350, 350);
        direccion = DERECHA;
        imagen = this.createImage(320, 350);
        noseve = imagen.getGraphics();
    }


    public void start(){
        animacion = new Thread(this);
        animacion.start();//LLama al metodo run
    }


    public void paint (Graphics g){
        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, 320, 350);

        noseve.setColor(Color.YELLOW);
        noseve.fillRect(0, 0, 90, 90);
        noseve.fillRect(250, 0, 40, 190);
        noseve.fillRect(80, 160, 100, 120);

        noseve.setColor(Color.BLUE);
        noseve.fillRect(80, 220, 220, 90);
        noseve.fillRect(100, 10, 90, 80);

        noseve.setColor(Color.LIGHT_GRAY);
        noseve.fillRect(posX, posY, 110, 90);

        noseve.setColor(Color.GREEN);
        noseve.fillRect(85, 85, 10, 10);

        noseve.setColor(Color.RED);
        noseve.fillRect(200, 0, 45, 45);
        noseve.fillRect(0, 110, 70, 200);

        noseve.setColor(Color.MAGENTA);
        noseve.fillRect(200, 55, 60, 135);

        g.drawImage(imagen, 0, 0, this);//g.drawImage(imagen, posX, posY, this);
    }

    public void update(Graphics g){
        paint(g);
    }

    public void run() {
        while (true) {
            switch (direccion) {
                case DERECHA:
                    posX++;
                    if (posX == 100) {
                        direccion = ABAJO;
                    }
                    break;
                case ABAJO:
                    posY++;
                    if (posY == 120) {
                        direccion = IZQUIERDA;
                    }
                    break;
                case IZQUIERDA:
                    posX--;
                    if (posX == 60) {
                        direccion = ARRIBA;
                    }
                    break;
                case ARRIBA:
                    posY--;
                    if (posY == 80) {
                        direccion = DERECHA;
                    }
                    break;
                default:
                    System.out.println("Syntax ERROR:");
            }
            repaint();
            try {
                Thread.sleep(7);
            } catch (InterruptedException ex) {}
        }
    }
}
