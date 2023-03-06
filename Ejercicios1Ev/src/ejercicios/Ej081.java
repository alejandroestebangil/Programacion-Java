/*
Ordena las palabras dentro de los strings frase1 y frase2 para formar en frase3 esto:
frase3= "Habia una vez un circo que alegraba siempre el corazon sin temer jamas"
Luego mostrar frase3 por pantalla
 */

package ejercicios;

public class Ej081 {
    public static void main(String[] args) {
        String frase1= "Habia vez circo alegraba el ";
        String frase2= "una un que siempre corazon sin temer jamas";
        String frase3= "";

        int inicioF1 = 0;
        int finF1 = frase1.indexOf(" ");
        int inicioF2 = 0;
        int finF2 = frase2.indexOf(" ");
        while ( (finF1 != -1) || (finF2 != -1) ) {
            if (finF1 != -1) {
                frase3 = frase3.concat(frase1.substring(inicioF1, finF1 + 1 ) );
                inicioF1 = finF1 +1;
                finF1 = frase1.indexOf(" ", inicioF1);
            }
            if (finF2 != -1) {
                frase3 = frase3.concat(frase2.substring(inicioF2, finF2 + 1 ) );
                inicioF2 = finF2 +1;
                finF2 = frase2.indexOf(" ", inicioF2);
            }
        }
        System.out.println(frase3);

        /* FORMA DAVID
        while ( fin1 != -1 && fin2 != -1 ) {
            frase3 += frase1.substring(inicio1, fin1+1) + frase2.substring(inicio2, fin2+1);

            inicio1 = fin1 +1;
            fin1 = frase1.indexOf(" ", fin1 + 1);
            inicio2 = fin2 +1;
            fin2 = frase2.indexOf(" ", fin2 + 1);
        }
        if (fin1 == -1)
            frase3 += frase2.substring(inicio2);
        else
            frase3 += frase1.substring(inicio1);
        System.out.println(frase3);
         */
    }
}
