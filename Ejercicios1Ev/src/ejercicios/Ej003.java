//Determina que numero es mayor o si son iguales

package ejercicios;

public class Ej003 {
    public static void main(String arg[]){
	int x, y;
	x = 65;
	y = 43;
	if(x > y){
            System.out.println("El mayor es : " + x);		
        // Si solo pongo 1 instruccion puedo no poner las llaves del if/else
	}
        else if(x == y){
            System.out.println("X e Y son iguales : " + x);
        } 
	else{
            System.out.println("El mayor es : " + y);
	}
    }
}
