
package Ej106_Solitario;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MazoPalo extends Rectangle{
    public List<Card> mazo;
    public static final int POSY = 20;
    private int palo;

    public MazoPalo(int px){
        super(px, POSY, Card.WIDTH, Card.HEIGHT);
        mazo = new ArrayList<Card>();
    }

    public boolean anadir(Card card){
        if(mazo.size()==0){ //si no hay cartas en el mazo
            if(card.getValue()==1) { //si es un as lo añade
                mazo.add(card);
                recolocar();
                palo = card.getSuit();
                return true;
            }
        } else {
            if(palo==card.getSuit()) //si es del mismo palo al que ya hay colocado
                if(mazo.get(mazo.size()-1).getValue() == card.getValue()-1){ //si es una carta menor a la que ya hay colocado
                    mazo.add(card);
                    recolocar();
                    return true;
                }
        }
        return false;
    }

    public void recolocar(){
        mazo.get(mazo.size()-1).setPosition(x, POSY);
    }

    public void mostrar(Graphics gg, Applet a){
        gg.setColor(Color.WHITE);
        gg.drawRect(x, y, width, height);
        if (!mazo.isEmpty())
            for (Card carta : mazo)
                carta.paint(gg, a);
    }

    public Card extraer(){
        return mazo.get(mazo.size()-1);
    }
    public void eliminar(){
        mazo.remove(mazo.size()-1);
    }

}
