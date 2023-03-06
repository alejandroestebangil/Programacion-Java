/*
Hacer la suma del salario total de cada empleado y mostrar por pantalla el total
Para esto declarar y usar una funcion que reciba el vector de los salarios de un empleado
y devuelva la suma de sus elementos
*/
package ejercicios;

public class Ej050 {
    public static void main(String arg[]) {
        int salarios[][] = {{730, 900, 1330, 800, 790, 850},
                            {1000, 950, 1080, 1070, 1200, 1100},
                            {1300, 930, 1200, 1170, 1000, 1000},
                            {1500, 1950, 1880, 1970, 2200, 2100}};
        String empleados[]={"Javier Marias", "Antonio Muñoz", "Luis Aragonés", "Maria Galiana"};
        for (int i = 0; i < salarios.length; i++) {
            System.out.printf("%s ha ganado %d€ en los últimos 6 meses\n", empleados[i], salarioTotal(salarios[i]));
        }
    }
    public static int salarioTotal(int salarios[]){
        int total = 0;
        for (int i = 0; i < salarios.length; i++) {
                total += salarios[i];
        }
        return total;
    }
}
