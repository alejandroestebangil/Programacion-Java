//Implementar una funcion que cambie las A por X
package ejercicios;

public class Ej058 {
    public static void main(String arg[]) {
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        System.out.println(frase);
        sustitucion(frase);
        System.out.println(frase);
    }

    public static void sustitucion(char frase[]){
        for (int i=0; i < frase.length; i++) {
            if (frase[i] == 'a')
                frase[i] = 'X';
        }
    }
}
