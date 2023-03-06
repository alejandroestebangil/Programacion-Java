package ejercicios;

public class Ej069b {
    public static void main(String[] args) {
        char frase[] = {' ', 'e', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char cadena[] = {'e', 'n', ' '};
        int j=0;
        for (int i = 0; i < frase.length; i++) {
            if (frase[i] == cadena[0]){ //Si es la letra que buscamos
                j=1; //Ponemos j a 1 para que entre en el bucle
                while ((j < cadena.length) && (frase[i + j] == cadena[j])) {
                    //Mientras no se acabe la cadena y la letra que buscamos sea igual a la letra de la frase

                    j++; //Incrementamos j
                }
                if (j == cadena.length) { //si j es igual a la longitud de la cadena, es que hemos encontrado la cadena
                    for (int k = 0; k < cadena.length; k++) { // Ponemos en blanco la cadena
                        for (int l = (i+j-k); l < frase.length; l++) { // Desplazamos los caracteres de la frase
                            frase[l-1] = frase[l]; // a la izquierda
                        }
                        frase[frase.length-1] = ' ';//Ponemos en blanco el ultimo caracter
                    }
                }
            }
        }
        System.out.println(frase);
    }
}
/*explicame cada linea de codigo del main
 */
