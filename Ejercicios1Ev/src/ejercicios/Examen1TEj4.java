/*
Multiplicacion de estas dos matrices cuadradas 3x3

[2] [0] [1]     [1] [0] [1]     [3] [1] [2]
[3] [0] [0]  X  [1] [2] [1]  =  [3] [0] [3]
[5] [1] [1]     [1] [1] [0]     [7] [3] [6]

*/

package ejercicios;

public class Examen1TEj4 {
    public static void main(String arg[]) {
        int matriz1[][] = {{2, 0, 1}, {3, 0, 0}, {5, 1, 1}};
        int matriz2[][] = {{1, 0, 1}, {1, 2, 1}, {1, 1, 0}};

        int matriz3[][] = new int[3][3];

        //Multiplico las dos matrices
        for(int i = 0; i < matriz3.length; i++){
            for(int j=0; j < matriz3.length; j++){
                matriz3[i][j] = 0;
                for(int k = 0; k < matriz3.length; k++) {
                    matriz3[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        //Imprimo la matriz 3
        for (int i = 0; i < matriz3.length; i++) {
            for (int j = 0; j < matriz3.length; j++) {
                System.out.print(matriz3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
