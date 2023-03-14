package Ej015;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Pelota extends Rectangle {
    int velX;
    int velY;
    Raqueta r;
    public int score;
    boolean gameOver = false;
    
    public Pelota(){
        super(150,100,10,10);
        velX = (int)(Math.random() * 2) + 2;
        velY = (int)(Math.random() * 2) + 2;
        score = 0;
    }
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, this.width, this.height);
    }
    
    public void update(Raqueta r, List<Ladrillo> lista){
        if((x<=0) || (x>=300-this.width)){
            velX = -velX;
        }
        if((y<=0)){
            velY = -velY;
        }
        x += velX;
        y += velY;

        if(this.intersects(r)) //cuando la pelota choque en la raqueta rebotara
            velY = -velY;

        for(int i=0; i<lista.size(); i++){
            //cuando la pelota choque con un ladrillo rebotara y se eliminara el ladrillo
            if(this.intersects(lista.get(i))){
                velY = -velY;
                lista.remove(i);
                addScore(1);
                break;
            }
        }
    }
    
    //SCOREBOARD
    public int getScore() {   return score; }
    public void setScore(int i) { score = i;  }
    public void addScore(int i) { score += i;  }

}

