/* VECTOR (el nombre del vector llamarlo en plural)

EJ: Vector de 4 enteros 
elementos[12][34][2][-4]
                  |
                  3 (posicion 3 del vector)
*/

package ejercicios;

public class Ej014 {
    public static void main(String arg[]){
        int datos[] = {17, 55, 33, 21, 88};
        
        for(int i=0; i < datos.length; i++){ // Bucle de mostrar datos originales
            System.out.printf("datos[%d] = %d \n", i, datos[i]);  
        }

        System.out.println();
        for(int i=0; i < datos.length; i++){ // Bucle de multiplicacion por 2 de datos
            datos[i] *= 2;
        }
        
         for(int i=0; i < datos.length; i++){ // Bucle mostrando datos multiplicados por 2
            System.out.printf("datos[%d] = %d \n", i, datos[i]);  
        }
    }
}

