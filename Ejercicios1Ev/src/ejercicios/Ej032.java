/*
En "salas" tenemos guardados el numero de espectadores que visitan cada
una de las cuatro salas, cada dia de la semana.
Mostrar por pantalla el dia que más entradas se vendieron y cuantas
se vendieron. Y tambien el dia que menos se vendieron y cuantas.
 */
package ejercicios;

public class Ej032 {
    public static void main(String arg[]){
        int salas[][] = {{13,28,30,40,150,230,245},
                        {40,50,60,70,175,200,170},
                        {70,81,90,100,130,125,110},
                        {30,81,90,100,170,225,180}};
        String dias[] = {"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"};
        int vacum[] = {0,0,0,0,0,0,0};
        
        for (int j = 0; j<dias.length; j++){ //recorremos la columna primero en vez de filas (por ejemplo)
            for (int i = 0; i<salas.length; i++) {
                vacum[j] += salas[i][j];
            }
        }
        //AQUI ABAJO - Recorrido por filas
        /* for (int i = 0; i<salas.length; i++){
            for (int j = 0; j<dias.length; j++) {
                vacum[i] += salas[i][j];
            }
        } */
        
        //calculo de min y max sacado de Ej016
        int posmax = 0; 
        int posmin = 0;
        
        for(int i=0; i < vacum.length; i++){
            if(vacum[i] > vacum[posmax])
                posmax = i;
            if(vacum[i] < vacum[posmin])
                posmin = i;
        }
        
        System.out.printf("El día con más espectadores es el %s, con %d espectadores\n", dias[posmax], vacum[posmax]);
        System.out.printf("El día con menos espectadores es el %s, con %d espectadores\n", dias[posmin], vacum[posmin]);
 
    }
    
}