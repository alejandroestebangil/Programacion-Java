package Ej017;

import java.awt.*;

public class Nave extends Rectangle{
    public static final int ANCHURA = 20;
    public static final int ALTURA = 10;
    int velX, velY;
    Color colores[] = {Color.CYAN, Color.YELLOW, Color.BLUE, Color.MAGENTA, Color.GREEN, Color.ORANGE};
    Color color;

    public Nave(){
        super((int)(Math.random()*280), (int)(Math.random()*-100), ANCHURA, ALTURA);
        velX = (int)(Math.random()*6) -2; //valores positivos y negativos
        velY = (int)(Math.random()*1) +1; //asi siempre positivo y nunca 0
        color = colores[(int)(Math.random()*colores.length)];
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, this.width, this.height);
    }

    public void update(){
        if((int)(Math.random()*100) > 50){
            velX=0;
            velY=4;
        }
        if(x<=0 || x+20 >= 300)
            velX = -velX;
        x += velX;
        y += velY;
    }

    
}
