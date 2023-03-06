/*
Implementar la funcion sumarKilos que te devuelva un vector de dos elementos
con los kilos vendidos de cada producto
 */
package ejercicios;

public class Ej054 {
    public static void main(String arg[]){
        int kilos[][]={{5,6,9,23,7,14,0},{16,8,4,33,15,21,0}};
        String productos[]={"Peras", "Manzanas"};
        int totalKilos[] = sumarKilos(kilos);
        for (int i = 0; i < totalKilos.length; i++) {
            System.out.printf("Total kilos de %s: %d kg\n", productos[i], totalKilos[i]);
        }

    }
    public static int[] sumarKilos(int kilos[][]){
        int totalKilos[] = new int[kilos.length];
        for (int i = 0; i < kilos.length; i++) {
            for (int j = 0; j < kilos[i].length; j++) {
                totalKilos[i] += kilos[i][j];
            }
        }
        return totalKilos;
    }

}
