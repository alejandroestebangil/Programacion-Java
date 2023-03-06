//Forma profe de hacer el ejercicio 68
package ejercicios;

public class Ej068b {
    public static void main(String[] args) {
        char frase[]={'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char letra = 'n';
        for (int i = 0; i < frase.length; i++) {
            if (frase[i] == letra) {
                for (int j = i; j < frase.length-1; i++) {
                    frase[j] = frase[j + 1];
                    frase[j + 1] = ' ';
                }
            }
        }
        System.out.println(frase);
    }
}
