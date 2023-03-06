//Llenar en dos vectores la suma de los valores de tabla[][] en horizontal y tambien en vertical
package ejercicios;

public class Ej029 {
    public static void main(String arg[]){
        int tabla[][] = {{10,20,30,40},
                        {40,50,60,70},
                        {70,80,90,100}};
        int v1[] = {0,0,0};
        int v2[] = {0,0,0,0};
        for (int i=0; i < tabla.length; i++) {
            for(int j=0; j < tabla[i].length; j++) {
                v1[i] += tabla[i][j]; //llena en v1 la suma de los valores en horizontal del vector tabla[][]
                v2[j] += tabla[i][j]; //llena en v2 la suma de los valores en vertical del vector tabla[][]
            }
        }
        System.out.print("|");
        for(int n = 0; n<v1.length; n++){
                System.out.print(v1[n]);
        System.out.print("|");
        }
        System.out.print("\t|");
        for(int k = 0; k<v2.length; k++){
                System.out.print(v2[k]);
        System.out.print("|");
        }
    }  
}

