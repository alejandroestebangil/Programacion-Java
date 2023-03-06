/*
CÁLCULO DE LA MATRIZ TRASPUESTA
    [1][2][3][4]    [1][5][9][13]
    [5][6][7][8]    [2][6][10][14]
 [9][10][11][12] -> [3][7][11][15]
[13][14][15][16]    [4][8][12][16]
 */

package ejercicios;

public class Ej037 {
    public static void main(String arg[]){
        int tabla1 [][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int tabla2 [][] = new int [4][4];
        for (int i = 0; i < tabla1.length; i++) {
            for (int j = 0; j < tabla1[i].length; j++) {
                tabla2[j][i] = tabla1[i][j]; //con una tabla auxiliar cambia las filas por las columnas
            }
        }
        for (int i = 0; i < tabla2.length; i++) {
            for (int j = 0; j < tabla2[i].length; j++) {
                System.out.printf("%d\t", tabla2[i][j]);
            }
            System.out.println("");
        }

    }
}
