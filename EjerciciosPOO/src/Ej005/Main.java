package Ej005;

public class Main {
    public static void main(String[] args) {
        Bombo bombo = new Bombo();
        int[][] tabla = new int[6][8];
        cargarTabla(tabla, bombo);
        mostrarTabla(tabla);
    }

    public static void cargarTabla(int[][] tabla, Bombo bombo){ // Carga la tabla con los números del bombo
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                tabla[i][j] = bombo.sacarBola();
            }
        }
    }

    public static void mostrarTabla(int[][] tabla){ // Muestra la tabla por pantalla
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println();
        }
    }


}
