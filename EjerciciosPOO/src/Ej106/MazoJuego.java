
package Ej106;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MazoJuego extends Rectangle {
    public List<Card> mazo;
    public static final int POSY = 200;

    public MazoJuego(int px){
        super(px, POSY, Card.WIDTH, Card.HEIGHT);
        mazo = new ArrayList<Card>();
    }

    public boolean anadir(Card card){
        if(mazo.size()==0){ //si no hay cartas en el mazo
            recolocar(card);
            mazo.add(card);
            return true;
        } else {
            if(card.getColor()!=mazo.get(mazo.size()-1).getColor()) {
                if (mazo.get(mazo.size()-1).getValue() == card.getValue() + 1) { //si es una carta menor a la que ya hay colocado
                    recolocar(card);
                    mazo.add(card);
                    return true;
                }
            }
        }
        return false;
    }

    public void mostrar(Graphics gg, Applet a){
        gg.setColor(Color.BLACK);
        gg.drawRect(x, y, width, height);
        /*for (int i = 0; i < mazo.size(); i++) {
            mazo.get(i).paint(gg, a);
        } PODRIA PINTARLO DE ESTA FORMA TAMBIEN*/
        if(!mazo.isEmpty())
            for(Card carta:mazo)
                carta.paint(gg, a);
    }

    public Card extraer(){
        return mazo.get(mazo.size()-1);
    }

    public void eliminar(Card carta){
        mazo.remove(carta);
    }

    public void recolocar(Card carta){
        carta.setPosition(x, POSY + (mazo.size()-1)*30);
    }
}
