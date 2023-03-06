/*
Añadir una "a" al final de cada palabra de la frase1. Sin usar replace.
Hay que añadirla entre el final de la palabra y el espacio
HolaX queX talX
 */
package ejercicios;

public class Ej083 {
    public static void main(String[] args) {
        String frase1 = "Habia una vez un circo que alegraba siempre el corazon";

        //saca cada palabra de frase1 y la concatena a frase2 con una "a" al final
        System.out.println("Frase normal: " + frase1);
        int pos = frase1.indexOf(" ");
        while (pos != -1) {
            frase1 = frase1.substring(0, pos).concat("A").concat(frase1.substring(pos));
            //Primero: Habia ; Segundo:A ; Tercero: una;
            pos = frase1.indexOf(" ", pos + 2);
        }
        System.out.println("Frase con a al final: " + frase1);

        //ASÍ SE HUBIERA HECHO CON REPLACE
        //frase1=frase1.replace(" ", "a ");
        //System.out.println(frase1);
    }
}
