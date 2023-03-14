package Ej100;

import java.applet.Applet;
import java.awt.Image;
import java.awt.*;

public class Personaje {
    private Image imagenes[];
    int actual = 0;
    public Personaje(Image img[]){
        this.imagenes = img;
    }
    public Image[] getImagenes() {
        return imagenes;
    }
    public void setImagenes(Image[] imagenes) {
        this.imagenes = imagenes;
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(imagenes[actual], 0, 0, 200, 300, a);
    }
    public void update(){
        actual = (actual + 1) % imagenes.length;
    }


}
