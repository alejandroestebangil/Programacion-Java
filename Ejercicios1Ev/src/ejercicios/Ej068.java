/*
Eliminar de frase todas las letras 'n' y luego desplazando los elementos de la frase a la izquierda
 */
package ejercicios;

public class Ej068 {
    public static void main(String[] args) {
        char frase[]={'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char letra = 'n';
        int j = 0;
        for (int i = 0; i < frase.length; i++) {
            if (frase[i] != letra) //Si no es la letra que buscamos
                frase[j++] = frase[i]; //Copiamos el caracter en la posicion j y luego incrementamos j
                //se podria poner frase[j]=frase[i]; j++;
        }
        for (int i = j; i < frase.length; i++)//Ponemos en blanco los caracteres sobrantes
            frase[i] = ' ';
        System.out.println(frase);
    }
}
