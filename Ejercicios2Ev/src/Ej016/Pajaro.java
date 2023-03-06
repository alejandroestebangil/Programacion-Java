package Ej016;

import java.awt.*;

public class Pajaro extends Rectangle{
    public static final int RADIO = 10;
    double velY = 2;
    
    public Pajaro(){
        super(30,70,0,0);
        this.height = RADIO;
        this.width = RADIO;
        
    }
    public void paint(Graphics g){
        int[] xPoints = {x + width, x + width, x + width +10};
        int[] yPoints = {y+6+RADIO/2,y-6+RADIO/2,y+RADIO/2};
        
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, this.width, this.height);
        g.setColor(Color.RED);
        g.fillOval(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);
        g.fillRect(x + 2*width/3, y + height/4, width/8, height/8);
        g.drawPolygon(xPoints, yPoints, xPoints.length);
        g.setColor(Color.YELLOW);
        g.fillPolygon(xPoints, yPoints, xPoints.length);
    }
    public void update(){
        y+=velY;
        if(y < 0)
            y = 0;
    }
    public void subir(){
        y-=30;
    }
}
