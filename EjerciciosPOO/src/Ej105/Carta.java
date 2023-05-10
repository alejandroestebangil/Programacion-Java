/*

 */
package Ej105;

import java.awt.*;
import java.applet.Applet;

public class Carta extends Rectangle {
    private Image imagen;
    private int valor;
    private int posX, posY;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 145;
    public Carta(Image imagen, int v){
        x=150;
        y=100;
        this.imagen = imagen;
        valor = (v>10)?10:v;
    }

    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, posX, posY, WIDTH, HEIGHT, a);
    }
    public void paint(int x, Graphics g, Applet applet){
        g.drawImage(imagen, x, y, WIDTH, HEIGHT, applet);
    }
    public void paint(int x, int y, Graphics g, Applet applet){
        g.drawImage(imagen, x, y, WIDTH, HEIGHT, applet);
    }

    public boolean isAs(){
        if (valor == 1)
            return true;
        else
            return false;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Image getImagen() {
        return imagen;
    }
}
