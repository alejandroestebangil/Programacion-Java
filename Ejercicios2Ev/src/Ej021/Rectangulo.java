package Ej021;

import java.awt.*;

public class Rectangulo extends Rectangle{
    Color colores[] = {Color.GRAY, Color.DARK_GRAY, Color.LIGHT_GRAY};
    Color color;
    public Rectangulo(int altura){
        super(Dino.POSINICIAL, 250-altura, 8, altura);
        this.color = colores[(int)(Math.random() * colores.length)];
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, this.width, this.height);
    }
    public void update(){
        x -= 2;
    }
}
