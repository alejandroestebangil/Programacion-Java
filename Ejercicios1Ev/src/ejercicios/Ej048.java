//Ordenar cada uno de los vectores del array salarios llamando al metodo ordenar
package ejercicios;

public class Ej048 {
    public static void main(String arg[]) {
        int salarios[][] = {{730, 900, 1330, 800, 790, 850},
                {1000, 950, 1080, 1070, 1200, 1100},
                {1300, 930, 1200, 1170, 1000, 1000},
                {1500, 1950, 1880, 1970, 2200, 2100}};

        for(int i=0;i<salarios.length;i++){
            ordenarVector(salarios[i]);
        }
        for (int i = 0; i < salarios.length; i++) {
            for (int j = 0; j < salarios[i].length; j++) {
                System.out.printf("[%d] ",salarios[i][j]);
            }
            System.out.println("");
        }
    }
    public static void ordenarVector(int vector[]){
        int aux;
        for (int j = 0; j < vector.length; j++) {
            for (int i = vector.length - 1; i > j; i--) {
                if (vector[i] < vector[i - 1]) {
                    aux = vector[i];
                    vector[i] = vector[i - 1];
                    vector[i - 1] = aux;
                }
            }
        }
    }
}
