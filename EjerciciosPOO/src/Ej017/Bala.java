package Ej017;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Bala extends Rectangle {
    int velX;
    public int score;

    public Bala(int posX){
        super(posX,270,3,5);
    }
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, this.width, this.height);
    }
    
    public void update(){
        //solo se mueve en el eje Y
        y -= 4;
    }
    
    public int getScore() {   return score; }
    public void setScore(int i) { score = i;  }
    public void addScore(int i) { score += i;  }

}

