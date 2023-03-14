package Ej013;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangulo {
    public static final int DERECHA = 0;
    public static final int ABAJO = 1;
    public static final int IZQUIERDA = 2;
    public static final int ARRIBA = 3;
    public int direccion;
    public int posX, posY, ancho, alto;
    public int topeDer, topeIzq, topeArriba, topeAbajo;
    Color color;
    
    public Rectangulo(int x, int y, int an, int al, Color c){
        posX = x;
        posY = y;
        ancho = an;
        alto = al;
        color = c;
        direccion = DERECHA;
        topeDer = x + 20;
        topeIzq = x;
        topeArriba = y;
        topeAbajo = y + 20;
    }
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillRect(posX, posY, ancho, alto);
    }
    
    public void actualizar(){
         switch(direccion){
                case DERECHA:
                    posX++;
                    if(posX == topeDer){
                        direccion = ABAJO;
                    }
                    break;
                case ABAJO:
                    posY++;
                    if(posY == topeAbajo){
                        direccion = IZQUIERDA;
                    }
                    break;
                case IZQUIERDA:
                    posX--;
                    if(posY == topeIzq){
                        direccion = ARRIBA;
                    }
                    break;
                case ARRIBA:
                    posY--;
                    if(posY == topeArriba){
                        direccion = DERECHA;
                    }
        }
    }

}
