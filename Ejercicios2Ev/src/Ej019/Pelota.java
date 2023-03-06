package Ej019;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Pelota extends Rectangle {
    int velX;
    int velY;
    Raqueta r;
    int score1;
    int score2;
    boolean winnerP1 = false;
    boolean winnerP2 = false;
    
    public Pelota(){
        super(150,150,7,7);
        velX = 2;
        velY = 1;
        score1 = 0;
        score2 = 0;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, this.width, this.height);
    }
    
    public void update(Raqueta r1, Raqueta r2){
        if((y<=0) || (y>=300-this.height)){
            velY = -velY;
        }
        if(x<=0){
            x = 150;
            y = 150;
            velX = -velX;
            score2++;
        }else if (x>=300-this.width){
            x = 150;
            y = 150;
            velX = -velX;
            score1++;
        }
        x += velX;
        y += velY;
        
        if(this.intersects(r1) || this.intersects(r2)) //cuando la pelota choque en la raqueta rebotara
            velX = -velX;
    }


    public int getScore1() {
        return score1;
    }
    public int getScore2() {
        return score2;
    }
}

