/*

 */
package Ej106;

import java.awt.*;
import java.applet.Applet;

public class Card extends Rectangle {
    private int value;
    private int color;
    private int suit;
    private Image image;
    //private Image back;

    //constantes de cada color de carta
    public static final int RED = 1;
    public static final int BLACK = 2;
    //constantes de cada palo
    public static final int SPADES = 0;
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int CLUBS = 3;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 150;
    public Card(Image image, int value, int color, int suit){
        super(-200, -200, WIDTH, HEIGHT);
        this.image = image;
        this.value = value;
        this.suit = suit;
        this.color = color;
    }

    public void paint(Graphics g, Applet applet){
        g.drawImage(image, x, y, WIDTH, HEIGHT, applet);
    }

    public void setPosition(int X, int Y){
        this.x = X;
        this.y = Y;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getSuit() {
        return suit;
    }

    //getters y setters de pos X e Y
    public int getPosX() {
        return x;
    }

    public void setPosX(int posX) {
        this.x = posX;
    }

    public int getPosY() {
        return y;
    }

    public void setPosY(int posY) {
        this.y = posY;
    }



}
