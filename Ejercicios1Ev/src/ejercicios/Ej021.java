/*
Desplazar el ultimo elemento del vector al primer elemento del vector
 */
package ejercicios;

public class Ej021 {
    public static void main(String arg[]){
        int datos[] = {10,-20,30,-40,50,60};
        int aux = datos[datos.length-1];
        
        for (int i = datos.length-1; i > 0; i--)
            datos[i] = datos[i - 1];
        datos[0] = aux;

        /*
        Este es como desplazar el primer elemento al ultimo elemento del vector pero con alguna diferencia.
        Se arrastran todos los elementos una posicion a la derecha y al final en el primer elemento del vector
        se pone el ultimo elemento del vector (antes se iba tambien arrastrando el primer elemento durante
        el bucle pero en este caso no.
        */

        for (int i = 0; i < datos.length ; i++) {
            System.out.println(" En " + i + " = " + datos[i]);
        }
    }
    
}
