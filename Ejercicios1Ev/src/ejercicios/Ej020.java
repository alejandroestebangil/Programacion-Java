/*
Desplazar el primer elemento del vector a la posicion final del vector
 */
package ejercicios;

public class Ej020 {
    public static void main(String arg[]){
        int datos[] = {10,-20,30,-40,50,60};
        int aux = datos[0];
        
        for (int i = 0; i < datos.length-1; i++){
            datos[i]=datos[i+1]; // a datos[i] (que en 1er caso = 0) se le da el valor de su siguiente
            datos[i+1]=aux; // a datos[i+1] se le da el valor de aux, que antes era datos[i]
            //de esta forma el primer elemento se arrastra por tod el vector hasta el final
        }
        for (int i = 0; i < datos.length ; i++) {
            System.out.println(" En " + i + " = " + datos[i]);
        }
    }
}
