/*
REEMPLAZAR EN UN STRING y

INDEXOF devuelve la posicion de la primera aparicion de un caracter en un string y -1 si no lo encuentra

Muestra el numero de apariciones de palabra en frase
 */
package ejercicios;

public class Ej075 {
    public static void main(String[] args) {
        String frase = "en un lugar lugar de lugar La Mancha";
        String subcadena = "lugar";

        frase = frase.replace('n', 'X'); //si no pusiese frase=, no se guardaria el cambio
        System.out.println(frase);

        frase = frase.replaceAll("X", "PPP");
        //hace lo mismo que el replace pero con una cadena
        System.out.println(frase);


        //muestra el numero de apariciones de palabra en frase

        int i=frase.indexOf(subcadena), cont=0; //i es la posicion de la primera aparicion de subcadena en frase
        while(i != -1){ //mientras i sea distinto de -1 (no se ha encontrado subcadena)
            cont++;
            i=frase.indexOf(subcadena, i+1); //busca la siguiente aparicion de subcadena
        }
        System.out.println("La palabra "+subcadena+" aparece "+cont+" veces");

    }
}
