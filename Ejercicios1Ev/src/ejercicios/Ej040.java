//METODO DE LA BURBUJA con iteracion i--
//Ordenacion de un vector

package ejercicios;

public class Ej040 {
    public static void main(String arg[]){
        int vector[] = {25,2,73,81,16,4,33};
        int aux;
        System.out.println("El vector no ordenado es:");
        for (int i = 0; i < vector.length; i++)
            System.out.printf("%d ", vector[i]);

        for (int j = 0; j < vector.length; j++) {
            for (int i = vector.length - 1; i > j; i--) {
                if (vector[i] < vector[i - 1]) { //si el vector anterior es mayor al actual los intercambia
                    aux = vector[i];
                    vector[i] = vector[i - 1];
                    vector[i - 1] = aux;
                }
            }
        }

        System.out.println("\n");
        System.out.println("El vector ordenado es:");
        for (int k = 0; k < vector.length; k++) {
            System.out.printf("%d ", vector[k]);
        }

        //Forma copilot (for en posicion cambiada)

        /*for (int i = vector.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (vector[j] > vector[j + 1]) {
                    aux = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = aux;
                }
            }
        }*/
    }
}
