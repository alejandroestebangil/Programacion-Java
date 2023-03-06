//Calcular el factorial de un numero

package ejercicios;

public class Ej010 {
    public static void main(String arg[]){
        int num = 3;
        int fact = 1;
        for (int i = 1; i<=num; i++)
            fact=fact*i;
        System.out.println("El factorial de " + num + " = " + fact);    
    }
}
