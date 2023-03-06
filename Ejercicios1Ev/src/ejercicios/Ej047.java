//Crear una funcion void para ordenar un vector (metodo de la burbuja)
package ejercicios;

public class Ej047 {
    public static void main(String arg[]){
        int vector[]={45,68,32,87,65};
        ordenarVector(vector);
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("[%d] ",vector[i]);
        }
    }
    public static void ordenarVector(int vector[]){
        int aux;
        for (int j = 0; j < vector.length; j++) {
            for (int i = vector.length - 1; i > j; i--) {
                if (vector[i] < vector[i - 1]) {
                    aux = vector[i];
                    vector[i] = vector[i - 1];
                    vector[i - 1] = aux;
                }
            }
        }
    }
}
