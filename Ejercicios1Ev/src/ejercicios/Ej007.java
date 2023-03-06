//Mostrar por pantalla si un numero x es multiplo de otro numero y
package ejercicios;

public class Ej007 {
    public static void main(String arg[]){
        int x = 3;
        int y = 21;
        int aux=0;
        //este if es para que el numero mayor sea x y poder hacer la division
        if (x<y){
            aux=y;
            y=x;
            x=aux;
        }
        //si el resto de la division es 0, son multiplos
        if(x%y == 0){
            System.out.println(x+ " es múltiplo de " + y);
        }else{
            System.out.println(x+ " no es múltiplo de " + y);
        }
    }
}
