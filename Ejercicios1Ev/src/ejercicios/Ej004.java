//Determina el mayor numero entre 3

package ejercicios;

public class Ej004 {
    public static void main(String arg[]){
        int x = 7;
        int y = 12;
        int z = 14;
        if (x > y && x > z){ //EL && UNE DOS COMPARACIONES
            System.out.println("El mayor es X = " + x);
        }
        else if (y > x && y > z){
            System.out.println("El mayor es Y = " + y);
        }
        else{
            System.out.println("El mayor es Z = " + z);
        }        
    }
}
