//Implementar una funcion que convierta los caracteres a mayusculas
package ejercicios;

public class Ej057 {
    public static void main(String arg[]) {
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        System.out.println(frase);
        aMayus(frase);
        System.out.println(frase);

    }
    public static void aMayus(char frase[]){
        for (int i=0; i < frase.length; i++) {
            frase[i] = Character.toUpperCase(frase[i]);
        }
    }
}
