//Mostrar en pantalla si un numero es par o impar

package ejercicios;

public class Ej005 {
    public static void main(String arg[]){
        int x = 2;
        if((x%2) == 0){ //si el resto de la division es 0, es par
            System.out.println(x + " es un número par");
        }
        else{ //si no, es impar
            System.out.println(x + " es un número impar"); 
        }
    }    
}
