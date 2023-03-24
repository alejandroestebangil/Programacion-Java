package Ej101;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Pieza extends Rectangle{
    private Image image;
    public static final int SIZE = 60;
    private boolean ok = false;
    private boolean mover = true;
    private int posicion;
    
    public Pieza(Image imagen, int pos){
        super((int)(Math.random()*400)+500, (int)(Math.random()*450)+50, SIZE, SIZE);
        this.image = imagen;
        posicion = pos;
    }
    
    public void paint(Graphics g, Applet applet){
        g.drawImage(image, x, y, applet);
    }
    public void update(int x, int y){
        //if(!ok){
        if(mover){
            this.x = x - SIZE/2;
            this.y = y - SIZE/2;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isMover() {
        return mover;
    }

    public void setMover(boolean mover) {
        this.mover = mover;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
