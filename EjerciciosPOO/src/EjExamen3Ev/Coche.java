/*
Es un juego en el que parece que un coche se desplaza por una carretera.
Hay una lista de coches de colores arriba que haciendo click en ellos cambiará el coche que se ve en pantalla.
Se acelerará o se frenará clickando unos pedales, el de la derecha acelera, el de la izquierda frena.
El coche no se mueve, es la imagen de fondo la que se desplaza hacia la izquierda.
Se desplazará más rápido dependiendo de la velocidad, que también aparece en pantalla, la velocidad
se modifica pulsando los pedales.
 */
package EjExamen3Ev;

import java.awt.*;

public class Coche extends Rectangle {
    private Image imagen;

    public Coche(Image imagen, int posX, int posY, int SIZEX, int SIZEY){
        super(posX, posY, SIZEX, SIZEY);
        this.imagen = imagen;
    }

    public void dibujar(Graphics g){
        g.drawImage(imagen, x, y, width, height, null);
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
}
