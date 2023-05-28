
package Ej106_Solitario;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//Mazo de cartas que se van a ir sacando
public class MazoSecundario {
    List<Card> mazoB;
    public static final int POSX = 150;
    public static final int POSY = 20;
    public MazoSecundario(){
        mazoB = new ArrayList<Card>();
    }

    public void anadir(Card card){
        card.setPosition(POSX, POSY);
        mazoB.add(card);
    }

    public Card extraer(){
        return mazoB.get(mazoB.size()-1);
    }

    public void eliminar(){
        mazoB.remove(mazoB.size()-1);
    }

    public void recolocar(){
        mazoB.get(mazoB.size()-1).setPosition(POSX, POSY);
    }

    public void mostrar(Graphics gg, Applet a){
        for (Card carta : mazoB)
            carta.paint(gg, a);
    }

}
