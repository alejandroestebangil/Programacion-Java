/*
Mostrar por pantalla el trimestre con mas nacimientos
Mes en el que mas bajas se han producido. Defunciones y traslados fuera
Mostrar por pantalla en cuantas personas nuevas han venido al pueblo
 */
package ejercicios;

public class Ej094 {
    public static void main(String[] args) {
        String movimientos[] = {"Nacimientos", "Defunciones", "Traslados fuera", "Traslados dentro"};
        int movPoblacion[][] = {{3,15,2,0},{1,5,0,1},{9,4,0,0},{3,8,0,7},{6,1,0,0},{2,3,0,0},{4,2,0,0},{5,1,0,0},{7,0,0,0},{8,24,8,0},{9,0,2,0},{2,0,2,10}};
        int trimestre[] = {0,0,0,0};
        String meses[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

        //calcula el mes con mas bajas
        int mesBajas = 0;
        int bajas = 0;
        for (int i = 0; i < movPoblacion.length; i++) {
            if (movPoblacion[i][1] > bajas || movPoblacion[i][2] > bajas) {
                bajas = movPoblacion[i][1]+movPoblacion[i][2];
                mesBajas = i;
            }
        }

        //calculo del trimestre con mas nacimientos
        int trimestreNacimientos = 0;
        int nacimientos = 0;
        for (int i = 0; i < movPoblacion.length; i++) {
            trimestre[i/3] += movPoblacion[i][0];
            if (trimestre[i/3] > nacimientos) {
                nacimientos = trimestre[i/3];
                trimestreNacimientos = i/3;
            }
        }

        //suma total de nacimientos y traslados (gente nueva)
        int poblacionNueva = 0;
        for (int i = 0; i < movPoblacion.length; i++) {
            poblacionNueva += movPoblacion[i][0] + movPoblacion[i][3];
        }

        System.out.println("El mes con mas bajas: " + meses[mesBajas] + " con " + bajas + " bajas");
        System.out.println("Poblacion nueva este año: " + poblacionNueva);
        System.out.println("Trimestre con mas nacimientos: " + (trimestreNacimientos+1));
        //+1 porque el array empieza en 0
    }

}
