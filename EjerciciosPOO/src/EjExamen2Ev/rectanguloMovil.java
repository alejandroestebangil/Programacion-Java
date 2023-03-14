package EjExamen2Ev;

import java.awt.*;

public class rectanguloMovil extends Rectangle{
    int x, y;
    int velX, velY;
    Color color;
    public rectanguloMovil(Color color){
        super((int) (Math.random() * 250)+10, (int) (Math.random() * 150)+10,35,35);
        this.color = color;
        velX = (int)(Math.random() * 5);
        velY = (int)(Math.random() * 5);
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, this.width, this.height);
    }
    public void update(){
        x += velX;
        y += velY;
        if (x < 0 || x > 265) {
            velX = -velX;
        }
        if (y < 0 || y > 200) {
            velY = -velY;
        }
    }

    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}
    public Color getColor() {return color;}
    public void setLinea(Linea linea){
        this.x = linea.getPosX();
        this.y = linea.getPosY();
    }

}
