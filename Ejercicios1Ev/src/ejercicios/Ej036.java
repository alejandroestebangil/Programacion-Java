/*Mostrar por pantalla el listado de dieces. Tiene que mostrar la dupla alumno-asignatura
 */

package ejercicios;

public class Ej036 {
    public static void main(String arg[]) {
        double notas[][] = {{7, 9, 3, 8}, {10, 9, 9, 8}, {9, 10, 7, 10}, {3, 10, 5, 6}, {8, 5, 4, 5}};
        String asignaturas[] = {"Programación", "Lenguaje de Marcas", "Sistemas Informáticos.", "Bases de Datos"};
        String alumnos[] = {"Ismael Abed", "Mikel Aramburu", "Ismael Bernad", "Ignacio Bielsa", "Marcos Burgos"};
        int totalDiez = 0;
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[i].length; j++) {
                if (notas[i][j] == 10) {
                    totalDiez = i+1;
                    //suma cada diez para sacar el total y imprime cada vez que sea 10
                    System.out.printf("El alumno %s ha sacado un diez en %s\n", alumnos[i], asignaturas[j]);
                }
            }
        }
        if (totalDiez == 0) {
            System.out.println("Ningún alumno ha sacado un diez");
        }else{
            System.out.printf("Han sacado %d dieces", totalDiez);
        }
    }
}
