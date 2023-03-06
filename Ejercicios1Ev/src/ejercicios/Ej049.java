/*
COMBINATORIA CON FACTORIAL

 3                  7!
V    = V    = ______________
 7      7,3     3! * (7-3)!

*/
package ejercicios;

public class Ej049 {
    public static void main(String arg[]){
        int elementosNum = 5;
        int tomadosNum = 2;
        int resultadoNum = factorial(elementosNum)/ (factorial(elementosNum-tomadosNum)*factorial(tomadosNum));
        System.out.printf("Combinaciones de %d elementos tomados de %d en %d = %d", elementosNum, tomadosNum, tomadosNum, resultadoNum);
    }

    public static int factorial(int num) {
        int fact = 1;
        for (int i = 1; i <= num; i++)
            fact *= i;
        return fact;
    }
}

