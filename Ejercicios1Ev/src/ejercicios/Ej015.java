// Mostrar el elemento mayor de un vector usando el propio
// valor mayor o usando la posicion de ese valor mayor

package ejercicios;

public class Ej015 {
    public static void main(String arg[]){
        int datos[] = {17, 55, 33, 21, 88};
        int mayor = datos[0];
        int posmax = 0;
        
        for(int i=0; i < datos.length; i++){
            if (datos[i] > mayor)
                mayor =  datos[i];
        } //recorre el vector y compara cual es el mayor y mete el valor en la variable mayor
        System.out.println("El número mayor es " + mayor + " (Usando el propio valor mayor)");
        
        for(int i=0; i < datos.length; i++){
            if(datos[i] > datos[posmax])
                posmax = i;
        }//recorre el vector y compara i con la variable posmax viendo cual es el mayor metiendo posmax
        System.out.println("El número mayor es " + datos[posmax] + " (Usando la posicion del valor mayor)"); 
    }
}

