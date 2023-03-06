//Multiplicacion mediante sumas
package ejercicios;

public class Ej011 {
    public static void main(String arg[]){
        int num1 = 6;
        int num2 = 4;
        int res = 0;
        for (int i = 1; i<= num2; i++)
            res += num1;
        // este bucle suma num1 num2-veces y lo almacena en res
        System.out.println("La multiplicacion de " + num1 + " * " + num2 + " = " + res);
    }
}
