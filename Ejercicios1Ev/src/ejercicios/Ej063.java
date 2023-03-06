/*
Desplazar los caracteres de cada palabra una posicion a la derecha
y el ultimo caracer ponerlo al principio
Tambien hacer lo mismo pero a la izquierda
*/
package ejercicios;

public class Ej063 {
    public static void main(String[] args) {
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        int inicio = 0, fin = 0;
        while(inicio < frase.length) {
            while (frase[fin] != ' ')
                fin++;
            desplazarD(frase, inicio, fin);
            inicio = fin = fin + 1;
        }
        System.out.println(frase);
    }
    public static void desplazarD(char frase[], int inicio, int fin){
        char aux = frase[fin-1];
        for (int i = fin-1; i > inicio; i--)
            frase[i] = frase[i-1];
        frase[inicio] = aux;
    }
    public static void desplazarI(char frase[], int inicio, int fin){
        char aux = frase[inicio];
        for (int i = inicio; i < fin-1; i++)
            frase[i] = frase[i+1];
        frase[fin-1] = aux;
    }
}
