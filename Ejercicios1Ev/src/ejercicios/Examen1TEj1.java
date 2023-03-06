/*
Realizar la función que resuelva el binomio de Newton.
(Para obtener la potencia de un número elevado a otro tenéis que utilizar la función Math.pow(número, potencia)).
*/
package ejercicios;

public class Examen1TEj1 {
    public static void main(String arg[]) {
        int x = 2, y = 3, n = 5;
        binomioNewton(x, y, n);
    }

    public static void binomioNewton(int x, int y, int n) {
        int factN = factorial(n);
        int resultado = 0;

        for (int k = 0; k <= n; k++) {

            //Calculo cada vez el factorial de n-k y k
            int factNK = factorial(n - k);
            int factK = factorial(k);

            //El (int) es para que la potencia sea entera
            int potX = (int) Math.pow(x, n - k);
            int potY = (int) Math.pow(y, k);

            //Calculo el resultado
            resultado += factN / (factNK * factK) * potX * potY;

        }
        System.out.println("El resultado del binomio de newton de X e Y es: "+ resultado);

    }

    //Funcion factorial
    public static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }




}
