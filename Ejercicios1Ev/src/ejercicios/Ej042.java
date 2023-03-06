//METODO DE ORDENACION POR INSERCION DIRECTA

package ejercicios;

public class Ej042 {
    public static void main(String arg[]) {
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        int aux;
        for(int i = 1; i < vector.length; i++){
            int j = i;
            //se comprueba si j>0 al principio porq al ser un and, si j=0, no se comprueba el segundo termino
            while((j > 0) && (vector[j] < vector[j - 1])){
                aux = vector[j];
                vector[j] = vector[j - 1];
                vector[j - 1] = aux;
                j--;
            }

        }
        System.out.println("El vector ordenado es:");
        for (int k = 0; k < vector.length; k++) {
            System.out.printf("%d ", vector[k]);
        }
    }
}
