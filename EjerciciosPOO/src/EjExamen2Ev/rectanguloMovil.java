package EjExamen2Ev;

import java.awt.*;

public class rectanguloMovil extends Rectangle{
    Color color;
    static final int ANCHURA = 50;
    static final int ALTURA = 50;
    static int[] posX = {50, 150, 250, 350, 450};
    int velX;
    int velY;

    public rectanguloMovil(int x, Color color){
        super(posX[x], 200, ANCHURA, ALTURA);
        this.color = color;
        velX = (int)(Math.random()*7)-3;
        velY = (int)(Math.random()*7)-3;
    }
    public void update(){
        x += velX;
        y += velY;
        if(y >= (450 - this.height)|| y <= 0)
            velY = -velY;
        if(x >= (600 - this.height)|| x <= 0)
            velX = -velX;
    }
    public void paint(Graphics gg){
        gg.setColor(color);
        gg.fillRect(x, y, width, height);
    }
}
