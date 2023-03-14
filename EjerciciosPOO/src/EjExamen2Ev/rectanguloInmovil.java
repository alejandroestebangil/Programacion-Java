
package EjExamen2Ev;

//Crear una clase para los rectángulos inmóviles de la parte inferior es un cuadrado fijo de 20x20 y le paso el color cada vez desde Juego

import java.awt.*;

public class rectanguloInmovil extends Rectangle {
    Color color;
    public rectanguloInmovil(int x, int y, Color color){
        super(x,y,35,35);
        this.color = color;
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, this.width, this.height);
    }

    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    //get color
    public Color getColor() {
        return color;
    }

}
