//Invertir los caracteres de la frase, copiando la frase en cadena2

package ejercicios;

public class Ej065 {
    public static void main(String[] args) {
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char cadena2[] = new char[40];
        for (int i= (frase.length-1), j=0; i>=0; i--, j++)
            cadena2[j] = frase[i];
        System.out.println(cadena2);
    }
}
