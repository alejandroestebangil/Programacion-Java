/*
Eliminar de frase todas las veces que se repita cadena y luego
desplazando los elementos de la frase a la izquierda
 */
package ejercicios;

public class Ej069 {
    public static void main(String[] args) {
        char frase[] = {' ', 'e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'e', 'n', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char cadena[] = {'e', 'n', ' '};
        int j = 0;
        for (int i = 0; i < frase.length; i++) {
            if (frase[i] != cadena[0]) //Si no es la letra que buscamos
                frase[j++] = frase[i]; //Copiamos el caracter en la posicion j y luego incrementamos j
            else {
                if (frase[i + 1] != cadena[1]) //comprobar si es la segunda letra ('n')
                    frase[j++] = frase[i];
                else {
                    if (frase[i + 2] != cadena[2]) //comprobar espacio ' ' despues de 'n'
                        frase[j++] = frase[i];
                    else
                        i += 2; //si es la cadena que buscamos, incrementamos i en 2
                }
            }
        }
        for (int i = j; i < frase.length; i++)//Ponemos en blanco los caracteres sobrantes
            frase[i] = ' '; //si no, se quedan los caracteres de la cadena que hemos eliminado
        System.out.println(frase);
    }
}
