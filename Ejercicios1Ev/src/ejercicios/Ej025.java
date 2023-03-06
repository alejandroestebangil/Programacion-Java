/*
Imprime las tablas de multiplicar del 1 al 10
 */
package ejercicios;

public class Ej025 {
    public static void main(String arg[]){
        for(int n = 1; n<=10; n++){
            for(int i = 1; i<=10; i++){
                System.out.println(n + " * " + i + " = " + (n*i));
            } // se imprimen todas las tablas de multiplicar de n del 1 al 10
        System.out.println("");
        }
    }   
}
