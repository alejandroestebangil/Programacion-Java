//CLASE FICHA DE LA RULETA CON LAS IMAGENES DESCARGADAS
package Ej104;

import java.awt.*;
import java.applet.Applet;
import java.util.ArrayList;

public class Ficha extends Rectangle{
    public static final int SIZE = 50;
    public static final int POSX = 620;
    private int valor;
    private Image imagen;
    private ArrayList<Casilla> apuestas;

    public Ficha(int posY, Image img, int v){
        super(POSX, posY, SIZE, SIZE);
        valor = v;
        imagen = img;
        apuestas = new ArrayList<Casilla>();
    }

    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height, a);
        //for (Casilla casilla : apuestas)
            //g.drawString(""+valor, 100,200);
    }

    public void setApuestas(Casilla[][] cas){
        apuestas.clear();
        for (int i = 0; i < Ruleta.FILAS; i++) {
            for (int j = 0; j < Ruleta.COLUMNAS; j++) {
                if (this.intersects(cas[i][j]))
                    apuestas.add(cas[i][j]);
            }
        }
    }

    public void move(int posX, int posY){
        x = posX;
        y = posY;
    }

    public int getValor() {
        return valor;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public ArrayList<Casilla> getApuestas() {
        return apuestas;
    }



}
