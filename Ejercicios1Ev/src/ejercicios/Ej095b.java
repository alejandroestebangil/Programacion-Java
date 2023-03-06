/*

 */
package ejercicios;

public class Ej095b {
    public static void main(String arg[]) {
        char frase[] = {'e','n',' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'm', 'a', 'n', 'c', 'h', 'a', ' '};
        int inicio = 0, fin = 0;
        while(inicio < frase.length) {
            while(frase[fin] != ' ') {
                fin++;
            }
            if(fin - inicio > 3) {
                for(int i = inicio; i < fin; i++) {
                    frase[i] = Character.toUpperCase(frase[i]);
                }
            }
            inicio = fin = fin + 1;
        }
        System.out.println(frase);
    }
}
