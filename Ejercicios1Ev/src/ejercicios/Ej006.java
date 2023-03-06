//Mostrar por pantalla si un numero termina en 5 o no
package ejercicios;

public class Ej006 {
     public static void main(String arg[]){
        int x = 345;
        if(x%10 == 5){ //Si el resto de dividir entre 10 es 5, es que termina en 5
            System.out.println(x + " acaba en 5");
        }else{
            System.out.println(x + " no acaba en 5");
        }
    }  
}
