//Multiplicar v1[] por cada dato de tabla[][]
package ejercicios;

public class Ej028 {
    public static void main(String arg[]){
        int tabla[][] = {{10,20,30,40},{40,50,60,70},{70,80,90,100}};
        int v1[] = {2,4,6};
        for (int i=0; i < tabla.length; i++) { //bucle que recorre [i][]
            for(int j=0; j < tabla[i].length; j++) { //bucle que recorre [][j]
                System.out.print(tabla[i][j]*v1[i] + "\t");
            }
        System.out.println("|") ;  
        }
    }
    
}
