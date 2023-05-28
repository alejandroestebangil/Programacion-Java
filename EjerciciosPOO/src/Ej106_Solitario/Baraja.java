
package Ej106_Solitario;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    private ArrayList<Card> mazoPrincipal;

    public Baraja(Image[] imagenes) {
        mazoPrincipal = new ArrayList<Card>();
        for (int i = 0; i < Solitario.NUMCARTAS; i++) {
            mazoPrincipal.add(new Card(imagenes[i], (i % Solitario.CARTASxPALO) + 1, ((i / Solitario.CARTASxPALO) == 0 || (i / Solitario.CARTASxPALO) == 3) ? Card.BLACK : Card.RED, (i / Solitario.CARTASxPALO)));
        }
    }

    public void barajar(){
        Collections.shuffle(mazoPrincipal);
        /* OTRO METODO PARA BARAJAR
        Card auxliar;
        for(int i = 0; i < 100; i++){
            int c1 = (int)(Math.random()*mazoPrincipal.size());
            int c2 = (int)(Math.random()*mazoPrincipal.size());
            auxliar = mazoPrincipal.get(c1);
            mazoPrincipal.set(c1, mazoPrincipal.get(c2));
            mazoPrincipal.set(c2, auxliar);
        }*/
    }
    public Card sacar(){
        Card auxiliar = mazoPrincipal.get(0);
        mazoPrincipal.remove(0);
        return auxiliar;
    }

}
