package Ej021;

import java.awt.*;

public class Muneco extends Rectangle{
    private boolean salto = false;
    public int velY = -1;
    public static final int TOPE = 200;

    public Muneco(){
        super(30,230,30,20);
    }

    public boolean isSalto() {
        return salto;
    }

    public void setSalto(boolean salto) {
        this.salto = salto;
    }

    public void paint(Graphics g){
        g.setColor(Color.GRAY);
        g.fillOval(x, y, this.width, this.height);
        g.fillOval(x+7, y-5, this.width-17, this.height-7);
        g.fillOval(x+20, y-5, this.width-17, this.height-7);
        g.setColor(Color.BLACK);
        g.fillOval(x+10, y-3, 5, 5);
        g.fillOval(x+23, y-3, 5, 5);
        g.drawArc(x+15, y+5, 10, 5, 180, 180);
    }

    public void update(){
        if(salto){
            y += velY;
            if(y <= TOPE){
                velY = -velY;
            }
            if(y >= 250-this.height){
                this.setSalto(false);
                velY = -velY;
            }
        }
    }
}
