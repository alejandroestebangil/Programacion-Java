//Quitar los espacios que hay dentro del string usando concat() y indexOf()
package ejercicios;

public class Ej079 {
    public static void main(String[] args) {
        String frase = "Había una vez, un circo, que alegraba siempre el corazón";
        int pos = frase.indexOf(" "); //aqui declaras pos con el valor de la posicion del primer espacio
        while (pos != -1) {
            frase = frase.substring(0, pos).concat(frase.substring(pos + 1, frase.length()));
            pos = frase.indexOf(" "); //aqui actualizas pos con el valor de la posicion del siguiente espacio
        }
        /*
        Concatena la subcadena de 0 a pos (espacio)
        con la subcadena de pos+1 a frase.length() (resto de la frase)
        */
        System.out.println(frase);

    }
}
