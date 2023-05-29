/*

 */
package EjExamen3Ev;

import java.awt.*;

public class Pedal extends Rectangle {
    private Image imagen;

    // Constructor
    public Pedal(Image imagen, int posX, int posY, int width, int height) {
        super (posX, posY, width, height);
        this.imagen = imagen;
        this.x = posX;
        this.y = posY;
    }

    public void dibujar(Graphics g) {
        g.drawImage(imagen, x, y, width, height, null);
    }


}



