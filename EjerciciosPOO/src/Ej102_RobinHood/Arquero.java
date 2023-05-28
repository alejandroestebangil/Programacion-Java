package Ej102_RobinHood;

import java.applet.Applet;
import java.awt.*;


public class Arquero {
    private static final int SIZEY = 120;
    private static final int SIZEX = 120;
    private Image imagen;
    private int posY;


    public Arquero(Image imagen){
        this.imagen = imagen;
        posY = 150;

    }
    public void paint(Graphics gg, Applet applet){
        gg.drawImage(imagen, 20, posY, SIZEX, SIZEY, applet);
    }

    public void update(int py){
        //solo se va a mover en el eje de la y (vertical)
        posY = py;
        if(posY < 10){
            posY = 0;
        } else if (posY > 600-SIZEY) {
            posY = 600-SIZEY;
        }
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}