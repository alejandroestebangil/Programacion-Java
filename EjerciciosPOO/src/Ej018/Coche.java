package Ej018;

import java.awt.*;

public class Coche extends Rectangle {

    public static final int ANCHURA = 30;
    public static final int ALTURA = 20;
    int velX;
    Color colores[] = {Color.CYAN, Color.YELLOW, Color.BLUE, Color.MAGENTA, Color.GREEN, Color.ORANGE};
    Color color;
    private boolean inRoad = true;

    public Coche(int posX, int posY) {
        super(posX, posY, ANCHURA, ALTURA);
        this.color = colores[(int) (Math.random() * colores.length)];
        velX = (int) (Math.random() * 5) + 2;
        if (posX >= 300) velX = -velX;
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        //haz las ruedas con fillOval
        g.fillOval(x+1, y-3, 5, 5);
        g.fillOval(x+22, y-3, 5, 5);
        g.fillOval(x+1, y+17, 5, 5);
        g.fillOval(x+22, y+17, 5, 5);



        g.setColor(color);
        g.fillRect(x, y, this.width, this.height);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(x+7, y, 16, 20);
    }

    public void update() {
        this.x += velX;
        if(this.x > 330 || this.x < -30) {
            this.inRoad = false;
        }
    }

    public boolean isInRoad() {
        return inRoad;
    }
    public void setInRoad(boolean inRoad) {
        this.inRoad = inRoad;
    }

}
