package Ej014b;

import java.awt.*;

//ahora en lugar de que haya solo una pelota que haya un array de pelotas

public class Pelota extends Rectangle {
    Color colores[] = {Color.WHITE, Color.CYAN, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED, Color.MAGENTA};
    Color color;
    int velX;
    int velY;

    
    public Pelota(int diametro){
        super( (int)(Math.random() * 350), (int)(Math.random() * 350), diametro, diametro);
        this.width = diametro;
        this.height = diametro;
        this.color = colores[(int)(Math.random() * colores.length)];
        velX = (int)(Math.random() * 5); //valor entre 1 y 4
        velY = (int)(Math.random() * 5);

    }
    
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, this.width, this.height);
    }
    
    public void update(){
        if((x<=0) || (x>=400-this.width)){
            velX = -velX;
        }
        if((y<=0) || (y>=400-this.height)){
            velY = -velY;
        }
        x += velX;
        y += velY;
    }

}

