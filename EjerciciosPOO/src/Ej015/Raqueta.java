package Ej015;

import java.awt.*;

public class Raqueta extends Rectangle{
    private int velX;
    public Raqueta(){
        super(110,260,80,Ladrillo.ALTURA);
        velX=5;
    }
    
    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void paint(Graphics g){
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,width,height);
    }

    public void update(int direccion){
        x += (velX*direccion);
        if(x<=0)
            x = 0;
        if((x+40 >= 300))
            x = 260;
    }
    
}
