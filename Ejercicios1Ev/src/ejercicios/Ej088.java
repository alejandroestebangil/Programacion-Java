//Recursividad: division mediante restas
package ejercicios;

public class Ej088 {
    public static void main(String[] args) {
        int n = 20;
        int m = 4;
        System.out.println("La division de " + n + " / " + m + " = " + divrest(n, m));
    }
    public static int divrest(int n, int m) {
        if (n < m)
            return 0;
        else
            return 1 + divrest(n - m, m);
        //se suma 1 tantas veces porq es la cantidad de veces que se puede restar m a n

    }
}
