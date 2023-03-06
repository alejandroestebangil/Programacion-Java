/*
Tenemos las siguientes líneas de código y sin crear ninguna función
y sobre la misma cadena de caracteres “frase2”, añadir una ‘A’ al final de cada palabra.
 */
package ejercicios;

public class Examen1TEj2 {
    public static void main(String arg[]) {
        char frase2[] = new char[33];
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};

        //Meto la frase en frase2
        for (int i = 0; i < frase.length; i++){
            frase2[i] = frase[i];
        }

        //Añado una A al final de cada palabra
        for (int i=0, j=0; i < frase.length; i++, j++) {
            if (frase[i] == ' ') {
                frase2[j] = 'A';
                j++;
            }
            frase2[j] = frase[i];
        }

        //Muestro frase2
        for (int i = 0; i < frase2.length; i++){
            System.out.print(frase2[i]);
        }
    }
}
