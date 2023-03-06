/* TIPO EXAMEN CREO
Mostrar por pantalla el nombre de la pelicula que consiguio mayor numero de espectadores
en un dia y que dia de la semana ocurrió.
Lo mismo para la pelicula que menos espectadores tuvo en un dia.
 */
package ejercicios;

public class Ej034 {
    public static void main(String arg[]){
        int salas[][] = {{45,33,31,40,150,230,245},
                        {40,50,60,70,175,200,170},
                        {70,81,90,100,130,125,110},
                        {30,81,90,100,170,225,180}};
        String peliculas[] = {"Avatar","Gran Torino","Blonde","Kill Bill"};
        String dias[] = {"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"};
        
        int posMaxFila = 0;
        int posMaxCol = 0;
        int posMinFila = 0;
        int posMinCol = 0;
        
        for(int i=0; i<salas.length; i++){
            for(int j=0; j < salas[i].length; j++){
                if(salas[i][j] > salas[posMaxFila][posMaxCol]){
                    posMaxFila = i;
                    posMaxCol = j;
                }
                if(salas[i][j] < salas[posMinFila][posMinCol]){
                    posMinFila = i;
                    posMinCol = j;
                }
            }
        }
        System.out.printf("La pelicula %s, con %d espectadores el %s, fue la más vista \n", peliculas[posMaxFila], salas[posMaxFila][posMaxCol], dias[posMaxCol]);
        System.out.printf("La pelicula %s, con %d espectadores el %s, fue la menos vista\n", peliculas[posMinFila], salas[posMinFila][posMinCol], dias[posMinCol]);
    }
}
