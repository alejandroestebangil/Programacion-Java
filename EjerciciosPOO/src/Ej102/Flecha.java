package Ej102;

import java.applet.Applet;
import java.awt.*;
//TAMBIEN SE PUEDE HACER CON POINT EN VEZ DE RECTANGLE ASI QUE LOS COMENTARIOS SE VE LA DIFERENCIA

public class Flecha extends Rectangle {
//public class Flecha extends Point {
    public static final int SIZEX = 55;
    public static final int SIZEY = 20;
    private Image imagen;
    private int velX;

    public Flecha(Image imagen, int py){
        super(20, py, SIZEX, SIZEY);
        //super(20, py);
        this.imagen = imagen;
        velX = (int)(Math.random()*7)+10;
    }
    public void paint(Graphics gg, Applet applet){
        gg.drawImage(imagen, x, y, SIZEX, SIZEY, applet);
        //gg.drawImage(imagen, x, y, applet);
    }

    public void update(){
        x += velX;
    }
}