//Quitar los espacios que hay dentro del string usando concat() y charAt()
//ESTA FORMA HACE LO MISMO QUE LA ANTERIOR PERO CON MAS BUCLES
package ejercicios;

public class Ej079b {
    public static void main(String[] args) {
        String frase = "Había una vez, un circo, que alegraba siempre el corazón";
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                frase = frase.substring(0, i).concat(frase.substring(i + 1, frase.length()));
                /*
                Concatena la subcadena de 0 a i (espacio)
                con la subcadena de i+1 a frase.length() (resto de la frase)
                */
            }
        }
        System.out.println(frase);
    }
}
