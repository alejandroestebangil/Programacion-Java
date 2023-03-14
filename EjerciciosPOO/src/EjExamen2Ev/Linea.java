/*

 */
package EjExamen2Ev;

import java.awt.*;

public class Linea extends Rectangle {
    private int posX, posY, posFX, posFY;
    Color color;
    public Linea(int px1,int py1, Color color){
        posX = px1;
        posY = py1;
        posFX = px1;
        posFY = py1;
        this.color = color;
    }

    public void paint(Graphics g){
        g.setColor(color);
        g.drawLine(x, y, this.width, this.height);
    }

    public void update(){

    }

    //Haz los getters y setters
    public void setPosX(int posX) {this.posX = posX;}
    public void setPosY(int posY) {this.posY = posY;}
    public void setPosFX(int posFX) {this.posFX = posFX;}
    public void setPosFY(int posFY) {this.posFY = posFY;}
    public void setColor(Color color) {this.color = color;}
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public int getPosFX() {
        return posFX;
    }
    public int getPosFY() {
        return posFY;
    }
    public Color getColor() {return color;}
}
