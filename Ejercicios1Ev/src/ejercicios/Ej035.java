/* TIPO EXAMEN CREO 2
Mostrar por pantalla el nombre del alumno que mejores notas ha sacado y cual es su media.
Y el que peor notas ha sacado y su media. Despues mostrar la asignatura con mejores notas 
y su media y la que tiene peores notas y su media.
 */
package ejercicios;

public class Ej035 {
    public static void main(String arg[]){
         double notas[][] = {{7,9,3,8},{10,9,9,8},{9,10,7,1},{3,10,5,6},{8,5,4,5}};
         String asignaturas[] = {"Programación","Leng.Marcas","Sistemas Inf.","Bases de Datos"};
         String alumnos[] = {"Ismael Abed","Mikel Aramburu","Ismael Bernad","Ignacio Bielsa","Marcos Burgos"};
         
         double vAlumnosNota[]= {0,0,0,0,0};
         double vAsignaturasNota[] = {0,0,0,0};
        
        for(int i=0; i<notas.length; i++){
            for(int j=0; j < notas[i].length; j++){
                vAlumnosNota[i] += notas[i][j];
                vAsignaturasNota[j] += notas[i][j];
            }
        }

        int posMejorAlumno = 0;
        int posPeorAlumno = 0;
        for(int i=0; i<vAlumnosNota.length; i++){
            if(vAlumnosNota[i] > vAlumnosNota[posMejorAlumno]){
                posMejorAlumno = i;
            }
            if(vAlumnosNota[i] < vAlumnosNota[posPeorAlumno]){
                posPeorAlumno = i;
            }
        }
        System.out.printf("El alumno que mejor nota ha sacado es %s con una media de %.2f\n",alumnos[posMejorAlumno],vAlumnosNota[posMejorAlumno]/4);
        System.out.printf("El alumno que peor  nota ha sacado es %s con una media de %.2f\n",alumnos[posPeorAlumno],vAlumnosNota[posPeorAlumno]/4);

        int posMejorAsignatura = 0;
        int posPeorAsignatura = 0;

        for(int i=0; i<vAsignaturasNota.length; i++){
            if(vAsignaturasNota[i] > vAsignaturasNota[posMejorAsignatura]){
                posMejorAsignatura = i;
            }
            if(vAsignaturasNota[i] < vAsignaturasNota[posPeorAsignatura]){
                posPeorAsignatura = i;
            }
        }
        System.out.printf("La asignatura que mejor nota ha tenido es %s con una media de %.2f\n",asignaturas[posMejorAsignatura],vAsignaturasNota[posMejorAsignatura]/5);
        System.out.printf("La asignatura que peor  nota ha tenido es %s con una media de %.2f\n",asignaturas[posPeorAsignatura],vAsignaturasNota[posPeorAsignatura]/5);
    }
}
