//Calcular el factorial de un numero con un bucle de incremento negativo

package ejercicios;

public class Ej010b {
    public static void main(String arg[]){
        int num = 3;
        int fact = 1;
        for (int i = num; i >= 1; i--)
            fact *= i;
        System.out.println("El factorial de " + num + " = " + fact);    
    }
}//Para incremento negativo se intercambian la declaracion de i y la condicion respecto al incremento positivo
