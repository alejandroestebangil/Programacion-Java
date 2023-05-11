/*

 */
package Ej107_Emparejar;

import java.awt.*;
import java.applet.Applet;

public class Casilla extends Rectangle{
    private boolean visible;
    private Image imagen;
    private Image reverso;
    public static final int SIZE = 128;

    public Casilla(int posX, int posY, Image img, Image rev){
        super(posX, posY, SIZE, SIZE);
        visible = false;
        imagen = img;
        reverso = rev;
    }

    public void paint(Graphics g, Applet a){
        if(visible){
            g.drawImage(imagen, x, y, width, height, a);
        }else{
            g.drawImage(reverso, x, y, width, height, a);
        }
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
}
