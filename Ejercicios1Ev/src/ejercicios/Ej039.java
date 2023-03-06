/*
Sustituye la diagonal principal (1,6,11,16) de la matriz
por la diagonal secundaria (4,7,10,13) de la matriz y viceversa
         */

package ejercicios;

public class Ej039 {
    public static void main(String arg[]) {
        int tabla[][] = {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}};
        int aux;
        for (int i = 0; i < tabla.length; i++) {
            aux = tabla[i][i];
            tabla[i][i] = tabla[i][tabla.length - 1 - i];
            tabla[i][tabla.length - 1 - i] = aux;
        }
        /*
        ESTE CÓDIGO ES EQUIVALENTE AL ANTERIOR PERO CON UNA VARIABLE AUXILIAR J
        for (int i = 0, int j = tabla.length - 1; i < tabla.length; i++, j--) {
            aux = tabla[i][i];
            tabla[i][i] = tabla[i][j];
            tabla[i][j] = aux;
        }
        */

        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.printf("%d\t", tabla[i][j]);
            }
            System.out.println("");
        }

    }
}
