/*
CLASE String

La clase String es una clase que representa cadenas de caracteres (que son un tipo de datos primitivo).
Ocurre lo mismo con Integer que es el equivalente a int, Double que es el equivalente a double, etc.
Tienen metodos que permiten realizar operaciones con cadenas de caracteres.
 */

package ejercicios;

public class Ej072 {
    public static void main(String[] args) {
        String frase = "En un lugar de La Mancha";
        char[] cadena = new char[30];
        for (int i = 0; i < frase.length(); i++)
            System.out.printf("%c ", frase.charAt(i)); //%c es caracter y frase.charAt(i) es el char de i

        for (int i = 0; i < frase.length(); i++) { //copiar frase en cadena[]
            cadena[i] = frase.charAt(i);
        }
        System.out.println();
        System.out.println(cadena);
    }
}
