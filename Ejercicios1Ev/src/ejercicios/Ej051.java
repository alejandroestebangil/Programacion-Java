/*
Implementa un metodo que modifique los datos de una tabla multiplicandolos por un entero
 */
package ejercicios;

public class Ej051 {
    public static void main(String arg[]) {
        int tabla[][] = {{730, 900, 1330, 800, 790, 850},
                {1000, 950, 1080, 1070, 1200, 1100},
                {1300, 930, 1200, 1170, 1000, 1000},
                {1500, 1950, 1880, 1970, 2200, 2100}};
        int multiplicador = 3;
        multiplicarTabla(tabla, multiplicador);
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.printf("[%d] ", tabla[i][j]);
            }
            System.out.println("");
        }
    }
    public static void multiplicarTabla(int tabla[][], int multiplicador){
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                tabla[i][j] *= multiplicador;
            }
        }
    }
}
