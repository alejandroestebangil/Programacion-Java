/*
Escribir en cadena2 la frase pero sustituyendo las ocurrencias de subcad1 por el contenido de subcad2
 */

package ejercicios;

public class Ej066{
    public static void main(String[] args) {
        char frase[] = {'e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char subcad1[] = {'e', 'n', ' '};
        char subcad2[] = {'X', 'X', 'X', 'X', 'X'};
        char cadena2[] = new char[70];
        for (int i = 0, j = 0, z=0; i < frase.length; i++, z++) {
            if (frase[i] == subcad1[0]) {
                j = 1;
                while ((j < subcad1.length) && (subcad1[j] == frase[i + j]))
                    j++;
                if (j == subcad1.length) {
                    for (int k = 0; k < subcad2.length; k++, z++) {
                        cadena2[z] = subcad2[k];
                    }
                    i+= (subcad1.length-1);
                }
            } else {
                cadena2[z] = frase[i];
                j++;
            }
        }
        System.out.println(cadena2);
    }
}
