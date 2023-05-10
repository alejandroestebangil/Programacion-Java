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
    private Image back;

    //constantes de cada color de carta
    public static final int RED = 0;
    public static final int BLACK = 1;
    //constantess de cada palo
    public static final int HEARTS = 0;
    public static final int DIAMONDS = 1;
    public static final int CLUBS = 2;
    public static final int SPADES = 3;
    public static final int WIDTH = 100;
    public static final int HEIGHT = 145;
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

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
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

    public Image getBack() {
        return back;
    }

    public void setBack(Image back) { this.back = back; }

    public int getSuit() {
        return suit;
    }
}
