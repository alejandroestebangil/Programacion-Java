/*
Es un juego en el que parece que un coche se desplaza por una carretera.
Hay una lista de coches de colores arriba que haciendo click en ellos cambiará el coche que se ve en pantalla.
Se acelerará o se frenará clickando unos pedales, el de la derecha acelera, el de la izquierda frena.
El coche no se mueve, es la imagen de fondo la que se desplaza hacia la izquierda.
Se desplazará más rápido dependiendo de la velocidad, que también aparece en pantalla, la velocidad
se modifica pulsando los pedales.
 */
package EjExamen3Ev;

import java.applet.Applet;
import java.awt.*;

public class Fondo {
    private int velocidad;
    private int posX;
    private Image imagen;

    public Fondo(Image imagen, int velocidad) {
        this.posX = 0;
        this.velocidad = velocidad;
        this.imagen = imagen;
    }


    public int getVelocidad() {
        return velocidad;
    }

    public int getPosX() {
        return posX;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void mover() {
        this.posX -= this.velocidad;
        if (this.posX <= -imagen.getWidth(null)) {
            this.posX = 0;
        }
    }

    public void dibujar(Graphics g, Applet applet) {
        int anchoImagen = imagen.getWidth(null);
        int repetir = applet.getWidth() / anchoImagen + 2;
        for (int i = 0; i < repetir; i++) {
            g.drawImage(imagen, (this.posX + anchoImagen * i), 0, applet);
        }
    }
}
