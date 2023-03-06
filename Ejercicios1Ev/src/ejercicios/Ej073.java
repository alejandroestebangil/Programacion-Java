//Ordenar los nombres del vector en orden alfabético
package ejercicios;

public class Ej073{
    public static void main(String[] args) {
        String nombres[]={"Juan", "Pedro", "Ana", "Maria", "Jose", "Luis"};
        String aux;
        for (int i = 0; i < nombres.length; i++) { //metodo burbuja
            for (int j = 0; j < nombres.length; j++) {
                if (nombres[i].compareTo(nombres[j])<0){ //si el nombre i es menor que el nombre j
                    aux=nombres[i];
                    nombres[i]=nombres[j];
                    nombres[j]=aux;
                }
            }
        }
        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i]);
        }
    }
}
