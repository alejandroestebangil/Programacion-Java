/*
Cada palabra que ocupe la primera posición en la frase, pasará a la última posición
en la siguiente iteración. Así hasta que vuelva a aparecer la frase original

Queremos que vaya apareciendo la frase en la pantalla, de la siguiente manera:
- un lugar de La Mancha de cuyo nombre no quiero acordarme En
- lugar de La Mancha de cuyo nombre no quiero acordarme En un
- de La Mancha de cuyo nombre no quiero acordarme En un lugar
- La Mancha de cuyo nombre no quiero acordarme En un lugar de
 */
package ejercicios;

public class Examen1TEj3 {
    public static void main(String arg[]) {
        String frase = "En un lugar de La Mancha de cuyo nombre no quiero acordarme ";

        //Vemos cuantas palabras tiene la frase mediante los espacios para saber cuantas veces imprimir
        int espacios = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                espacios++;
            }
        }

        //Sacamos cada vez la primera palabra de la frase y la ponemos al final, hasta llegar otra vez al orden inicial
        for (int i = 0; i < espacios; i++) {
            frase = frase.substring(frase.indexOf(" ") + 1, frase.length()).concat(frase.substring(0, frase.indexOf(" ")).concat(" "));
            System.out.println(frase);
        }
    }
}