/*
Instanciamos un array bidimensional de enteros con los salarios
de unos trabajadores y creamos y llamamos a una funcion que sume todos esos salarios
*/
package ejercicios;

public class Ej045 {
    public static void main(String arg[]){
        int salarios[][] = {{730,900,1330,800,790,850},
                            {1000,950,1080,1070,1200,1100},
                            {1300,930,1200,1170,1000,1000},
                            {1500,1950,1880,1970,2200,2100}};
        System.out.printf("La suma de todos los salarios es de %d€", salariosuma(salarios));
    }
    public static int salariosuma(int salarios[][]){ //suma todos los salarios del vector bidimensional
        int suma = 0;
        for (int i = 0; i < salarios.length; i++) {
            for (int j = 0; j < salarios[i].length; j++) {
                suma += salarios[i][j]; //aqui se almacena todos lo salarios de todos los empleados
            }
        }
        return suma;
    }
}
//
