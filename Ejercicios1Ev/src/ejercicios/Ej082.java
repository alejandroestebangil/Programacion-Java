/*
Escribir frase1 sobre frase2, pero los caracteres deben estar invertidos.
Ejemplo de frase1: "nozaroc le erpmeis abargela euq ocric nu zev anu aibaH"
 */
package ejercicios;

public class Ej082 {
    public static void main(String[] args) {
        String frase1= "Habia una vez un circo que alegraba siempre el corazon";
        String frase2= "";
        char letra;

        System.out.println("Frase normal: "+ frase1);
        for (int i=0; i<frase1.length(); i++)
        {
            letra= frase1.charAt(i); //saca la letra de la posicion i
            frase2= letra+frase2; //añade el caracter al principio de frase2
        }
        System.out.println("Frase inversa: "+ frase2);

        /*
        FORMA DE HACERLO DAVID

        for (int i=frase1.length()-1; i>=0; i--){
            frase2+=frase1.charAt(i);
        }
        System.out.println("Frase inversa: "+ frase2);
        */

        /*
        FORMA DE HACERLO CLASE

        for(int i=frase1.length()-1; i>=0; i--){
            frase2= frase2.concat(Character.toString(frase1.charAt(i)));
         */
    }
}
