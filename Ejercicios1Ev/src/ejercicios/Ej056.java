/*
Implementar una funcion a la que le paseis la frase
y devuelva otra frase en la que cada palabra termine en 'X' y luego el espacio ' '
Ejemplo: "Hola que tal" -> "HolaX queX talX "
Luego haz que todas las letras se impriman en mayusculas
*/
package ejercicios;

public class Ej056 {
    public static void main(String arg[]) {
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char fraseX[] = ponerX(frase);
        System.out.println(fraseX);
    }
    public static char[] ponerX(char frase[]){
        char fraseX[] = new char[31];
        for (int i=0, j=0; i < frase.length; i++, j++) {
            if (frase[i] == ' ') {
                fraseX[j] = 'X';
                j++;
            }
            fraseX[j] = frase[i];
        }
        return fraseX;
    }
}
