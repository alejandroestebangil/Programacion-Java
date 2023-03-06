/*
Hacer una funcion que modifique el contenido de la tabla kilos,
multiplicando cada elemento por el precio en vector precio pero
almacenando el resultado en otro vector

EN ESTE APARTADO HE DECLARADO RESULTADO EN LA FUNCION Y LO HE RETORNADO
*/
package ejercicios;

public class Ej053 {
    public static void main(String arg[]){
        int kilos[][]={{5,6,9,23,7,14,0},{16,8,4,33,15,21,0}};
        int precios[]={6,7};
        int resultado[][]=precioKilo(kilos,precios);
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.printf("%d\t", resultado[i][j]);
            }
            System.out.println("");
        }

    }
    public static int[][] precioKilo(int kilos[][],int precios[]){
        int resultado[][]=new int[kilos.length][kilos[0].length];
        for (int i = 0; i < kilos.length; i++) {
            for (int j = 0; j < kilos[i].length; j++) {
                resultado[i][j] = kilos[i][j] * precios[i];
            }
        }
        return resultado;
    }

}


