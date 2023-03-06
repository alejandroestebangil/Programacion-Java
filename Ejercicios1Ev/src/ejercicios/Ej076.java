/*
Mostrar por pantalla el numero de apariciones de la letra (caracter) a
dentro de un vector de strings
*/

package ejercicios;

public class Ej076 {
    public static void main(String[] args) {
        String[] frase = {"En un lugar", "de La Mancha", "de cuyo nombre", "no quiero acordarme"};
        int cont = 0;
        for (int i = 0; i < frase.length; i++) { //recorre frase que es un array de strings
            for (int j = 0; j < frase[i].length(); j++) { //recorre frase[i] que es un string
                if (frase[i].charAt(j) == 'a') { //si el caracter j de frase[i] == a
                    cont++;
                }
            }
        }
        System.out.println("La letra a aparece " + cont + " veces");
    }
}
