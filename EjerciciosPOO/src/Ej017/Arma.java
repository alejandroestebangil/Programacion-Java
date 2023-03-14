package Ej017;

import java.awt.*;

public class Arma extends Rectangle{
    private int velX;
    public Arma(){
        super(145,275,15,20);
    }

    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x,y,width,height);
    }

    public void update(int posX){
        this.x = posX;
        if(x<=0)
            x = 0;
        if((x+15 >= 300))
            x = 260;
    }
    
}
