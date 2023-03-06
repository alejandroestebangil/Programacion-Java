/*
Hacer una funcion que modifique el contenido de la tabla kilos,
multiplicando cada elemento por el precio en vector precio.
*/
package ejercicios;

public class Ej052 {
    public static void main(String arg[]){
        int kilos[][]={{5,6,9,23,7,14,0},{16,8,4,33,15,21,0}};
        int precios[]={6,7};

        precioKilo(kilos,precios);
        for (int i = 0; i < kilos.length; i++) {
            for (int j = 0; j < kilos[i].length; j++) {
                System.out.printf("%d\t", kilos[i][j]);
            }
            System.out.println("");
        }
    }
    public static void precioKilo(int kilos[][],int precios[]){
        for (int i = 0; i < kilos.length; i++) {
            for (int j = 0; j < kilos[i].length; j++) {
                kilos[i][j] *= precios[i];
            }
        }
    }

}
