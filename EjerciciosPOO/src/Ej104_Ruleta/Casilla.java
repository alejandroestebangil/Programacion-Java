//CASILLA RULETA
package Ej104_Ruleta;

import java.awt.*;

public class Casilla extends Rectangle {
    public static final int SIZE = 50;
    private Color color;
    public int valor;

    public Casilla(int posX, int posY, int v, Color c){
        super(posX, posY, SIZE, SIZE);
        color = c;
        valor = v;
    }

    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(Color.white);
        g.drawRect(x, y, width, height);
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString(""+valor, x+SIZE/5, y+30);
    }

    public Color getColor() {
        return color;
    }

}
