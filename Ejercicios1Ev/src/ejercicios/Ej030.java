/*
Mostrar por pantalla cuantos kilos de cada producto hemos vendido
 */
package ejercicios;

public class Ej030 {
    public static void main(String arg[]){
        int tabla[][] = {{10,20,30,40},{40,50,60,70},{70,80,90,100}};
        String productos[] = {"Naranjas","Peras","Manzanas"};
        int acum;
        for (int i=0; i < tabla.length; i++) { //bucle que recorre los 3 tipos de producto
            acum = 0;
            for(int j=0; j < tabla[i].length; j++) { //bucle que recorre los kilos y los suma
                acum += tabla[i][j];
            }
            System.out.printf("Tengo %d kg de %s\n", acum, productos[i]); //imprime cada vez lo que vale cada

        }
        
    }
    
}