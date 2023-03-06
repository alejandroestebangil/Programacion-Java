/*
Modificar frase, transformandola de manera que el primer
y ultimo caracter de cada palabra se intercambien
*/
package ejercicios;

public class Ej062 {
    public static void main(String arg[]) {
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        int inicio = 0, fin = 0;
        while(inicio < frase.length) {
            while (frase[fin] != ' ')
                fin++;
            intercambio(frase, inicio, fin);
            inicio = fin = fin + 1;
        }
        System.out.println(frase);
    }
    public static void intercambio(char frase[], int inicio, int fin){
        char aux = frase[inicio];
        frase[inicio] = frase[fin-1];
        frase[fin-1] = aux;

    }

}
