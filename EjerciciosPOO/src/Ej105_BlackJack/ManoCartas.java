
package Ej105_BlackJack;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class ManoCartas {
    List<Carta> lista;

    public ManoCartas(){
        lista = new ArrayList<Carta>();
    }

    public void addCarta(Carta carta){
        lista.add(carta);
    }

    public int points(){
        int points = 0;
        boolean as = false;
        for(Carta carta:lista) {//for(int i=0; i<lista.size(); i++)
            points += carta.getValor();//points += lista.get(i).getValor();
            if(carta.isAs())
                as = true;
        }
        if(as && (points<12))
            points += 10;

        return points;
    }

    public boolean over21(){
        return points()>21;
    }

    public boolean reach17(){
        return points()>=17;
    }

    public void paint(Graphics gg, Applet applet, int posY, boolean finJugada){
        for(Carta carta:lista) {
            carta.setPosX(lista.indexOf(carta)*(carta.width/4));
            carta.setPosY(posY);
            carta.paint(gg, applet);
            if(carta.equals(lista.get(0)) && carta.getY() == Blackjack.croupierY && !finJugada)
                carta.paint(gg, applet);
            else
                carta.paint(gg, applet);
        }
    }
}
