//Sustituir un caracter por una subcadena y hacerlo usando una nueva cadena de caracteres
//ES PARECIDO AL EJERCICIO 59 PERO SIN USAR UNA FUNCION
package ejercicios;

public class Ej064 {
    public static void main(String[] args) {
        char frase[]= {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char caracter = 'a';
        char subcadena[] = {'A', 'B', 'C', 'D', 'E'};
        char cadena2[] = new char[60];
        for (int i = 0, j=0; i < frase.length; i++, j++)
            if (frase[i] != caracter)
                cadena2[j] = frase[i];
            else
                for(int k = 0; k < subcadena.length; k++, j++)
                    cadena2[j] = subcadena[k];
        System.out.println(cadena2);

    }
}
