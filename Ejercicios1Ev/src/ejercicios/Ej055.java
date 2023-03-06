//Implementa una funcion que devuelva el numero de palabras de una frase
package ejercicios;

public class Ej055 {
    public static void main(String arg[]) {
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a','r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        System.out.print("Numero de palabras: " + contarPalabras(frase));
    }
    public static int contarPalabras(char frase[]){
        int contar = 0;
        for (int i = 0; i < frase.length; i++) {
            if (frase[i] == ' '){
                contar++;
            }
        }
        return contar + 1; //+1 porque no cuenta la ultima palabra
    }

}
