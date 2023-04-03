package Ej103;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Lugar extends Rectangle{
    public final static int SIZE = 48;
    private Image imagen;
    private int valor;

    public Lugar(int posX, int posY, Image img, int v){
        super(posX, posY, SIZE, SIZE);
        imagen = img;
        valor = v;
    }

    public void paint(Graphics g, Applet a){
        if(imagen == null)
            return;
        g.drawImage(imagen, x, y, a);
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

}