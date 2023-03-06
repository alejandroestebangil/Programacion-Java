/*
Mostrar por pantalla el numero de apariciones del substring "en" dentro de un vector de strings
*/
package ejercicios;

public class Ej077 {
    public static void main(String[] args) {
        String[] frase = {"en un lugar", "de La Mancha", "de cuyo nombre", "no quiero acordarme"};
        String subcadena = "en";
        int cont = 0;
        for (int i = 0; i < frase.length; i++) { //recorre frase que es un array de strings
            int j = frase[i].indexOf(subcadena); //j es la posicion de la primera aparicion de "en" en frase[i]
            while (j != -1) { //mientras j sea distinto de -1 (no se ha encontrado "en")
                cont++;
                j = frase[i].indexOf(subcadena, j + 1); //busca la siguiente aparicion de "en"
            }
        }
        System.out.println("La palabra en aparece " + cont + " veces");
    }
}
