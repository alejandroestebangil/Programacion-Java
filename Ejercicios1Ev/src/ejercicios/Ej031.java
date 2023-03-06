/*
Mostrar por pantalla de cada producto el dinero recaudado y tambien
tenemos que mostrar el dinero recaudado en total
 */
package ejercicios;

public class Ej031 {
    public static void main(String arg[]){
        int tabla[][] = {{10,20,30,40},{40,50,60,70},{70,80,90,100}};
        String productos[] = {"Naranjas","Peras","Manzanas"};
        double precios[]= {1.5,2,0.8};
        int acum;
        double dinero; //quitar si no quiero usar variable dinero
        double dintotal = 0;
        for (int i=0; i < tabla.length; i++) {
            acum = 0;
            dinero = 0; //quitar si no quiero usar variable dinero
            for(int j=0; j < tabla[i].length; j++) { //este bucle acumula el dinero recaudado de cada producto
                acum += tabla[i][j];
                dinero = acum * precios[i]; //quitar si no quiero usar variable dinero
            }
            System.out.printf("Tengo %.2f € de %s\n", dinero, productos[i]); //poner    acum * precios[i]    si no quiero usar variable dinero
            dintotal += dinero;  //usar  dintotal += acum * precios[i];  si no quiero usar variable dinero
         }
         System.out.printf("Hemos recaudado %.2f €  en total\n", dintotal);
        
    }
    
}