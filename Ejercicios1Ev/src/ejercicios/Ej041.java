// METODO DE ORDENACION DIRECTA (seleccion directa)
// Busca el elemento más pequeño del vector y ordenarlo, y asi sucesivamente
package ejercicios;

public class Ej041 {
    public static void main(String arg[]) {
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        int aux;
        int pos = 0;

        System.out.println("El vector no ordenado es:");
        for (int i = 0; i < vector.length; i++)
            System.out.printf("%d ", vector[i]);

        for (int j = 0; j < vector.length-1; j++) {
            for (int i = j+1; i < vector.length; i++) {
                if (vector[i] < vector[pos]) {
                    pos = i;
                }
            }
            aux = vector[j];
            vector[j] = vector[pos];
            vector[pos] = aux;
        }

        System.out.println("\n");
        System.out.println("El vector ordenado es:");
        for (int k = 0; k < vector.length; k++) {
            System.out.printf("%d ", vector[k]);
        }
    }
}
