package Ej005;

public class Bombo {
    private int[] bombo;
    public static final int NUMBOLAS = 48;
    public int bolasQuedan;

    public Bombo() { // Constructor
        bombo = new int[NUMBOLAS]; // Creamos el array
        bolasQuedan = NUMBOLAS; // Inicializamos el contador de bolas
        for (int i = 0; i < bombo.length; i++) {
            bombo[i] = i + 1; // Rellenamos el bombo con los números del 1 al 48
        }
    }

    public int sacarBola(){ // Método para sacar una bola
        int bola = (int) (Math.random() * bolasQuedan); // Generamos num aleatorio entre 0 y el numBolas que quedan
        int bolaSacada = bombo[bola]; // Guardamos la bola que vamos a sacar
        bombo[bola] = bombo[bolasQuedan-1]; // Intercambiamos la bola que vamos a sacar con la última bola del bombo
        bolasQuedan--; // Decrementamos el contador de bolas
        return bolaSacada; // Devolvemos la bola que hemos sacado
    }

    public int sacarBola2(){ //este metodo es mas largo
        int bola = (int) (Math.random() * bolasQuedan);
        int bolaSacada = bombo[bola];
        for (int i = bola; i < bolasQuedan-1; i++)
            bombo[i] = bombo[i + 1];
        bolasQuedan--;
        return bolaSacada;
    }
}
