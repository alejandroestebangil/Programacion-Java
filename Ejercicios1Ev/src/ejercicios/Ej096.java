// Calcula el maximo multiplo de dos numeros con el algoritmo de Euclides
//mcd(18, 12) -> mcd(12, 6) -> mcd(6, 0) -> 6

package ejercicios;

public class Ej096 {
    public static void main(String[] args) {
        int a = 18;
        int b = 12;
        System.out.println("Maximo comun divisor de " + a + " y " + b + " = " + mcd(a, b));
    }
    public static int mcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return mcd(b, a % b); //a%b es el resto de la division de a entre b
    }

    /*
    //Otra forma de hacerlo recursivo

    public static int mcd(int a, int b) {
        if (a == b)
            return a;
        else if (a > b)
                return mcd(a-b, b);
            else
                return mcd(a, b-a);
     */

    public static int mcd2(int a, int b) {
        //ESTA ES LA FUNCION DEL MCD SIN RECURSIVIDAD
        int resto;
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }
}

