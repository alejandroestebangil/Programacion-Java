/*
Mostrar por pantalla la media de los elementos del vector
 */
package ejercicios;

public class Ej019 {
    public static void main(String arg[]){
        int datos[] = {5, 10, 7 , 8, 6};
        double acumulador = 0;
        
        for (int i=0; i < datos.length; i++) {
            acumulador += datos[i];
        }
        
        double media = acumulador / datos.length;
        //Se acumulan cada valor del vector datos y luego se hace la media entre el numero de datos del vector
        
        System.out.println("La media de los elementos del vector es : " + media);
        
    }
}
