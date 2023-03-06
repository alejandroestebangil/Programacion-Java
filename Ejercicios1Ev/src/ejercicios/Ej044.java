//Implementar funcion a la que le pases un vector de enteros
//y te devuelva la posicion en la que se encuentra el max valor
package ejercicios;

public class Ej044 {
    public static void main(String arg[]){
        int vector[] = {24,45,65,12,7,123,16,50};
        System.out.println("El vector es:");
        for (int i = 0; i < vector.length; i++)
            System.out.printf("%d ", vector[i]);
        System.out.println("");
        System.out.printf("El maximo valor esta en la posicion %d y es %d", maxim(vector), vector[maxim(vector)]);
        //se imprime el vector y se imprime su máximo valor
        //se podria declarar un int que recoja maximo(vector) pero para imprimirlo en este caso no hace falta
    }
    //esta funcion devuelve la posicion del valor máximo del vector
    public static int maxim(int vector[]){
        int pos = 0;
        for(int i = 1; i< vector.length;i++)
            if (vector[i]>vector[pos])
                pos=i;
        return pos;
    }
}
