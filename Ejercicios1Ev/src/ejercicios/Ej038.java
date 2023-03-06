//Matriz traspuesta sin usar otra matriz auxiliar

package ejercicios;

public class Ej038 {
    public static void main(String arg[]) {
        int tabla[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int aux;
        for (int i = 0; i < tabla.length; i++) {
            for (int j = i; j < tabla[i].length; j++) { //cuando coincidan los indices lo transpone
                aux = tabla[i][j];
                tabla[i][j] = tabla[j][i];
                tabla[j][i] = aux;
            }
        }
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.printf("%d\t", tabla[i][j]);
            }
            System.out.println("");
        }
    }
}
