package Ej102_RobinHood;

import java.applet.Applet;
import java.awt.*;


public class Globo extends Rectangle {
    public static final int SIZE = 75;
    private Image imagen;
    private int velY;

    public Globo(Image imagen){
        super((int)(Math.random()*300)+500, 600, SIZE, SIZE);
        this.imagen = imagen;
        velY = (int)(Math.random()*4)+2;

    }
    public void paint(Graphics gg, Applet applet){
        gg.drawImage(imagen, x, y, SIZE, SIZE, applet);
    }

    public void update(){
        y -= velY;
    }
}