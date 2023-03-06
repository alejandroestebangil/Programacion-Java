/* Instruccion SWITCH
Convierte a mayus las vocales en minuscula y las que esten en mayuscula a minuscula
*/
package ejercicios;

public class Ej071 {
    public static void main(String[] args) {
        char cadena[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'A', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        for (int i = 0; i < cadena.length; i++) {
            switch (cadena[i]) {
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    cadena[i] = Character.toUpperCase(cadena[i]);
                    break;
                case 'A': case 'E': case 'I': case 'O': case 'U':
                    cadena[i] = Character.toLowerCase(cadena[i]);
                    break;
                default: //cualquier otro caracter que en este caso no sea una vocal
                    cadena[i] = '$';
                    break;
            }
        }
        System.out.println(cadena);
    }
}
