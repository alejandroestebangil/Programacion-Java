// Mostrar la tabla y si los datos son negativos pasarlos a positivos,
// y si son positivos multiplicarlos por 2
package ejercicios;

public class Ej027 {
    public static void main(String arg[]){
        int tabla[][] = {{10,20,30},{40,50,60},{70,80,90},{100,110,120}};
        for (int i=0; i < tabla.length; i++) {
            for(int j=0; j < tabla[i].length; j++) {
                if(tabla[i][j]< 0){
                    tabla[i][j] *= (-1);
                }else{
                    tabla[i][j] *= 2;
                }
            } //aqui es donde compara y multiplica por 2 o -1
        }
        for(int i = 0; i < tabla.length; i++){
            for(int j = 0; j<tabla[i].length; j++){
                System.out.printf("%d\t", tabla[i][j]);
            }
        System.out.println("|") ;  //aqui se imprime la tabla
        }
    }
}
