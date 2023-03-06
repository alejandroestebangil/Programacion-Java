//OPERADORES ARITMETICOS: Indica que numero es mayor
package ejercicios;
public class Ej002 {
    public static void main(String arg[]){
		int x, y;
		x = 65;
		y = 44;
		if(x > y)
            System.out.println("El mayor es : " + x);
        	// Si solo pongo 1 instruccion puedo no poner las llaves del if/else
		else
            System.out.println("El mayor es : " + y);
	}
/*  OPERADORES
    === (triple igual) si son iguales y la clase es la misma
    == (doble igual) si son iguales
    = (asignacion) , != (diferente)
    >,<,>=,<= mayor menor igual a
    && (and) y ; || (or) o ; ! (not) no
    ++ (incremento) suma 1 , -- (decremento) resta 1
    +=, -=, *=, /=, %= (operadores de asignacion) x = x + 1 ó x += 1
    / es dividir y * multiplicar
    % es el resto de la division
*/
}