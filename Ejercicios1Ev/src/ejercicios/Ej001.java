// Declaracion variables y primer programa de una suma de dos numeros

package ejercicios;

public class Ej001 {
    public static void main(String arg[]) {
        int x = 55;
        int y = 50;
        int resultado;
        resultado = x + y;
        System.out.println("El resultado es: " + resultado); //el + es concatenación
    }
}

//modificador public se puede usar en otro package y private en solo este package
//static se puede acceder a el atraves del nombre de la clase

//punto de ruptura
//f8 en netbeans para saltar el punto de ruptura