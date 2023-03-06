/*
Separar las palabras de frase1 alternativamente en fraseA y en fraseB
Meter la primera palabra en fraseA, la segunda en fraseB, la tercera en fraseA, la cuarta en fraseB, etc.
 */
package ejercicios;

public class Ej085 {
    public static void main(String[] args) {
        String frase1= "Habia una vez un circo "; //se pone el espacio al final para saber que separa la palabra
        String fraseA= "";
        String fraseB= "";
        boolean enFA = true;
        int pos = frase1.indexOf(" ");
        while (pos != -1) {
            if (enFA) {
                fraseA = fraseA.concat(frase1.substring(0, pos)).concat(" ");
                enFA = false;
            } else {
                fraseB = fraseB.concat(frase1.substring(0, pos)).concat(" ");
                enFA = true;
            }
            frase1 = frase1.substring(pos + 1, frase1.length());
            pos = frase1.indexOf(" ");
        }
        System.out.println("Frase A: " + fraseA);
        System.out.println("Frase B: " + fraseB);

        /* FORMA PROFE (En este caso no machacas la frase1)
        int inicio = 0;
        while (pos != -1) {
            if (enFA) {
                fraseA = fraseA.concat(frase1.substring(inicio, pos)).concat(" ");
                enFA = false;
            } else {
                fraseB = fraseB.concat(frase1.substring(inicio, pos)).concat(" ");
                enFA = true;
            }
            frase1 = frase1.substring(pos + 1, frase1.length());
            pos = frase1.indexOf(" ");
        }
         */
    }
}
