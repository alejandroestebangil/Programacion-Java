//Mostrar el valor mayor y menor del vector y en que posicion del vector esta cada uno

package ejercicios;

public class Ej016 {
    public static void main(String arg[]){
        int datos[] = {25, 19, 53, 11, 48};
        int posmax = 0;

        for(int i=0; i < datos.length; i++){
            if(datos[i] > datos[posmax])
                posmax = i;
        }//recorre el vector y compara i con la variable posmax viendo cual es el mayor metiendo posmax (ej15)
                
        System.out.println("El número mayor es " + datos[posmax] + " y esta en la posición " + posmax);  
        
        int posmin = 0;
        
        for(int i=0; i < datos.length; i++){
            if(datos[i] < datos[posmin])
                posmin = i;
        } //lo mismo que con posmax pero con la posicion del valor minimo
        System.out.println("El número menor es " + datos[posmin] + " y esta en la posición " + posmin);  
    }
}
