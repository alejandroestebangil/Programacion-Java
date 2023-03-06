/*
Multiplicar una tabla por un vector

Resultado:
  [1][2][3][4]      [1]    [1][4][9][16]
  [2][4][6][8]   *  [2] =  [2][8][18][32]
  [3][6][9][12]     [3]    [3][12][27][48]
  [4][8][12][16]    [4]    [4][16][36][64]
 */
package ejercicios;

public class Ej097 {
    public static void main(String arg[]) {
        int tabla[][] = {{1,2,3,4},{2,4,6,8},{3,6,9,12},{4,8,12,16}};
        int vector[] = {1,2,3,4};
        int resultado[][] = new int[tabla.length][vector.length];
        for(int i = 0; i < tabla.length; i++) {
            for(int j = 0; j < tabla[i].length; j++) {
                resultado[i][j] = tabla[i][j] * vector[j];
            }
        }
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print("[" + resultado[i][j] + "]");
            }
            System.out.println();
        }
    }
}
