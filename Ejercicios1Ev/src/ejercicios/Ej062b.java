//El mismo que el 65 pero hecho por el copilot
package ejercicios;

public class Ej062b {
    public static void main(String arg[]) {
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        int inicio = 0, fin = 0;
        for (int i = 0; i < frase.length; i++) {
            if (frase[i] == ' '){
                fin = i;
                intercambio(frase, inicio, fin);
                inicio = i + 1;
        }
    }
        System.out.println(frase);
}
    public static void intercambio(char frase[], int inicio, int fin){
        char aux = frase[inicio];
        frase[inicio] = frase[fin-1];
        //si quito el -1 lo tendre que poner en el for de arriba en el fin = i (-1)
        frase[fin-1] = aux;

    }
}
