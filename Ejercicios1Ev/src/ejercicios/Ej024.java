/*
Mostrar por pantalla 3 lineas. En cada una de ellas apareceran los elementos de datos
multiplicados por cada uno de los elementos de multiplos
 */
package ejercicios;

public class Ej024 {
    public static void main(String arg[]){
        int datos[] = {10,20,30,40,50,60};
        int multiplo[] = {3, 5, 7};
        for (int j = 0; j < multiplo.length; j++){ //for que recorre los multiplos con los que multiplicar cada dato
            for (int i = 0; i < datos.length ; i++) { //for que recorre los datos que multiplicar para imprimirlos
                System.out.println("La multiplicacion de " + multiplo[j] + " * " + datos[i] + " = " + datos[i]*multiplo[j]);
            }
        System.out.println("");
        }
        
    }
       
}
