//Convertir la primera y ultima letra de cada palabra en mayuscula
package ejercicios;

public class Ej070 {
    public static void main(String[] args) {
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        int inicio = 0, fin = 0;
        while(inicio < frase.length) { //Recorre la frase
            while (frase[fin] != ' ') //Busca el espacio
                fin++; //Avanza hasta el espacio
            frase[inicio] = Character.toUpperCase(frase[inicio]); //Pone la primera letra en mayus
            frase[fin-1] = Character.toUpperCase(frase[fin-1]); //Pone la ultima letra en mayus (es fin-1 porque fin es el espacio)
            inicio = fin = fin + 1; //Avanza al siguiente espacio
        }
        System.out.println(frase);

    }
}
