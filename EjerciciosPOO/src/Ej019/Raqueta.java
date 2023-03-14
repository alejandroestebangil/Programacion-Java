package Ej019;

import java.awt.*;

public class Raqueta extends Rectangle{
    private int velY;
    public Raqueta(int x, int y){
        super(x,y,7,50);
        velY=5;
    }
    
    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    //si la pelota toca la raqueta se mueve en la direccion opuesta

    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(x,y,width,height);
    }

    public void update(int direccion){
        y += (velY*direccion);
        if(y<=0)
            y = 0;
        if((y >= 300-this.height))
            y = 300-this.height;
    }
    
}
