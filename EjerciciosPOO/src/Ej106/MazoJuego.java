
package Ej106;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class MazoJuego extends Rectangle {
    public ArrayList<Card> mazo;
    public static final int POSY = 200;

    public MazoJuego(int x){
        super(x, POSY, Card.WIDTH, Card.HEIGHT);
        mazo = new ArrayList<Card>();
    }

    public boolean anadir(Card card){
        if(mazo.size()==0){ //si no hay cartas en el mazo
            mazo.add(card);
            recolocar(card);
            return true;
        } else {
            if(mazo.get(mazo.size()-1).getColor()!=card.getColor()) {
                if (mazo.get(mazo.size()-1).getValue() == card.getValue() + 1) { //si es una carta menor a la que ya hay colocado
                    mazo.add(card);
                    recolocar(card);
                    return true;
                }
            }
        }
        return false;
    }

    public void mostrar(Graphics gg, Applet a){
        gg.setColor(Color.WHITE);
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
