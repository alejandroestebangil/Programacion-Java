//Intercambiar el contenido de los elementos de un vector, de manera que se intercambie
// lo que hay en la posición primera con la ultima, la seg con la penultima...
// De manera que el contenido del vector quede inverso.

package ejercicios;

public class Ej017 {
    public static void main(String arg[]){
        int datos[] = {10, 20, 30, 40, 50, 60};
        int aux=0;
        
        for (int i=0; i < datos.length/2; i++) { //tamaño del vector / 2 porque si no quedaria como al inicio
            aux = datos[i];
            datos[i] = datos[datos.length-1-i];
            datos[datos.length-1-i] = aux;
        } //Se intercambia mediante la var aux. Se resta por -1 porque datos.length no empieza en 0 como i
        
        System.out.print("Los datos invertidos del vector son : \n");
        
        for (int i = 0; i < datos.length ; i++) {
            System.out.print(" En " + i + " = " + datos[i]+ "\n");
        }
    }
}
