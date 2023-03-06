// EXPLICACION FUNCION substring
package ejercicios;

public class Ej074 {
    public static void main(String[] args) {
        String frase = "En un lugar de La Mancha";

        for (int i = 0; i < frase.length(); i++) {
            System.out.printf("\n %s",frase.substring(0, i+1));
        }
        //devuelve una subcadena de la cadena original de 0 a i+1
    }
}
