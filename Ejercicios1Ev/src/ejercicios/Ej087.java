//Recursividad: multiplicacion mediante sumas
package ejercicios;

public class Ej087 {
    public static void main(String[] args) {
        int n = 6;
        int m = 4;
        System.out.println("La multiplicacion de " + n + " * " + m + " = " + mulsum(n, m));
    }
    public static int mulsum(int n, int m) {
        if (m == 1)
            return n;
        else
            return n + mulsum(n, m - 1); //n + n + n + n + n

    }
}
