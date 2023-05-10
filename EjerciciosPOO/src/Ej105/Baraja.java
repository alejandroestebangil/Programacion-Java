/*

 */
package Ej105;

import java.util.ArrayList;
import java.awt.*;

public class Baraja {
    private ArrayList<Carta> lista;
    private Image[] cartaImagen;
    private Carta carta;

    public Baraja(Image[] imagenes) {
        lista = new ArrayList<Carta>();
        cartaImagen = imagenes;
        for (int i = 0; i < Blackjack.NUMCARTAS; i++) {
            lista.add(new Carta(imagenes[i], (i % Blackjack.CCP) + 1));
        }
    }

    public Carta sacarCarta(){
        if(!lista.isEmpty()){
            carta = lista.get(0);
            lista.remove(0);
        }else {
            carta = null;
            System.out.println("No hay cartas");
        }
        return carta;
    }

    public void barajar(){
        if(lista.isEmpty())
            return;
        for(int i = 0; i < 100; i++){
            int c1 = (int)(Math.random()*lista.size());
            int c2 = (int)(Math.random()*lista.size());
            Carta inter = lista.get(c1);
            lista.set(c1, lista.get(c2));
            lista.set(c2, inter);
        }
    }

    public ArrayList<Carta> getLista() {
        return lista;
    }
}

