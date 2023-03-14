package Ej020;

import java.awt.*;

public class Pelota extends Rectangle {
    Color colores[] = {Color.WHITE, Color.CYAN, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED, Color.MAGENTA};
    Color color;
    int velX;
    int velY;

    
    public Pelota(int posX, int posY, int diametro){
        super(posX, posY, diametro, diametro);
        this.color = colores[(int)(Math.random() * colores.length)];
        velX = (int)(Math.random()*7) - 3;
        velY = (int)(Math.random()*7) - 3;

    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, this.width, this.height);
    }
    
    public void update(){
        x += velX;
        y += velY;
        if((x<=0) || (x>=300-this.width)){
            velX = -velX;
        }
        if((y<=0) || (y>=300-this.height)){
            velY = -velY;
        }
    }

}

