/*
[10][20][30][40][50][60]

60-10-20-30-40-50
50-60-10-20-30-40
40-50-60-10-20-30
30-40-50-60-10-20
20-30-40-50-60-10
10-20-30-40-50-60
 */
package ejercicios;

public class Ej023 {
    public static void main(String arg[]){
        int datos[] = {10,20,30,40,50,60};
        for (int j = 0; j < datos.length; j++){
            int aux = datos[datos.length-1];
            //igual que el ej 21, desplazando el ultimo elemento del vector al primer elemento del vector,
            //pero hacer un bucle para que al final quede igual que estaba al principio
        
            for (int i = datos.length-1; i > 0; i--)
                datos[i]=datos[i-1];
            datos[0]=aux;
            for (int i = 0; i < datos.length ; i++) {
                System.out.println(" En el desplazamiento " + j + " - Pos: " + i + " = " + datos[i]);
            } //El print esta en el bucle y con cada desplazamiento lo imprime
        System.out.println("");
        }
        
    }
       
}

// System.out.printf(" En el desplazamiento %d" + j + "  " + i + " = " + datos[i]);