/*
Tenemos que modificar el contenido de los elementos del vector, pasando 
los valores negativos a positivos y multiplicando por dos los positivos
 */
package ejercicios;

public class Ej018 {
    public static void main(String arg[]){
        int datos[] = {10, -20, 30, -40, 50, 60};
        
        for (int i=0; i < datos.length; i++) {
            if(datos[i] < 0)
                datos[i] *= (-1); //pasar a positivo
            else
                datos[i] *= 2; //multipliar por 2
        }
        
        for (int i = 0; i < datos.length ; i++) {
            System.out.print(" En " + i + " = " + datos[i]+ "\n");
        }
    }
}
