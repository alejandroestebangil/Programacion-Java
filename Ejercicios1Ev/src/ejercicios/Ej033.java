/*
Mostrar por pantalla la pelicula más taquillera y cuantas entradas ha vendido y la menos
taquillera y cuantas ha vendido.
 */
package ejercicios;

public class Ej033 {
    public static void main(String arg[]){
        int salas[][] = {{13,28,30,40,150,230,245},
                        {40,50,60,70,175,200,170},
                        {70,81,90,100,130,125,110},
                        {30,81,90,100,170,225,180}};
        String peliculas[] = {"Avatar","Gran Torino","Blonde","Kill Bill"};
        int vacum[] = {0,0,0,0};
        
        for (int i = 0; i<salas.length; i++){
            for (int j = 0; j<salas[i].length; j++) {
                vacum[i] += salas[i][j];
            } //almacena en vacum los espectadores totales de cada pelicula
        }
        
         //calculo de posmin y pos max sacado de Ej016 que mira que pelicula tiene menos o mas espectadores
        int posmax = 0; 
        int posmin = 0;
        
        for(int i=0; i < vacum.length; i++){
            if(vacum[i] > vacum[posmax])
                posmax = i;
            if(vacum[i] < vacum[posmin])
                posmin = i;
        }
        
        System.out.printf("La pelicula más vista es %s, con %d espectadores\n", peliculas[posmax], vacum[posmax]);
        System.out.printf("La pelicula menos vista es %s, con %d espectadores\n", peliculas[posmin], vacum[posmin]);
        
        
        
    }
    
}