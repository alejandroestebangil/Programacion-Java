// En este programa habra un boton y cada vez que lo pulses aparecera
// un ovalo en una posicion, color y tamaño aleatorio
package Ej006;

import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;

public class Ovalo {
    int posX, posY, ancho, alto;
    Color color; //color del ovalo
    Random r; //la declaro para luego instanciarla porque la voy a usar en varios metodos

    public Ovalo() {
        r = new Random(); //instancio el objeto r
        inicializar(); //esta funcion podria no usarse y llamar directamente al constructor pero asi se ve mejor
    }

    public void inicializar() {
        ancho = r.nextInt(300) + 100; //el ancho sera un numero aleatorio entre 100 y 400
        alto = r.nextInt(300) + 100;
        posX = r.nextInt(600);
        posY = r.nextInt(500);
        //el metodo color de la clase constuctor espera 3 parametros, R, G y B de un color aleatorio
        color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    }

    public void paint(Graphics g) { //graphics es un objeto que me permite pintar
        g.setColor(color); //le digo que el color del objeto g es el color del objeto color
        g.fillOval(posX, posY, ancho, alto); //pinta un ovalo con estas medidas
    }
}
