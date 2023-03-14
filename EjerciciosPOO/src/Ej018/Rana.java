package Ej018;

import java.awt.*;

public class Rana extends Rectangle{
    private int vel;
    private boolean meta = false;
    public Rana(int x, int y){
        super(x,y,30,20);
        vel = 5;
    }

    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillOval(x, y, this.width, this.height);
        g.fillOval(x-1, y-5, this.width-17, this.height-7);
        g.fillOval(x+12, y-5, this.width-17, this.height-7);
        g.setColor(Color.BLACK);
        g.fillOval(x+2, y-3, 5, 5);
        g.fillOval(x+15, y-3, 5, 5);
        g.drawArc(x+5, y+5, 10, 5, 180, 180);
    }

    public void update(int direccion){
        switch(direccion) {
            case Frogger.IZDA:
                x -= vel;
                break;
            case Frogger.DCHA:
                x += vel;
                break;
            case Frogger.ARRIBA:
                y -= vel;
                break;
            case Frogger.ABAJO:
                y += vel;
                break;
        }
        if(y<65 && (x>65 || x<235)){
            this.meta = true;
        }
    }

    public boolean isMeta() {
        return meta;
    }
    public void setMeta(boolean meta) {
        this.meta = meta;
    }
    
    
    
}
