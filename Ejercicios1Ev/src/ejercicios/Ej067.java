/*
Meter en frase2 la misma frase pero con las palabras en sentido inverso:
Ejemplo: "Mancha La de lugar un En" <- "En un lugar de La Mancha"
 */
package ejercicios;

public class Ej067 {
    public static void main(String[] args) {
        char frase[]= {' ','E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char frase2[]= new char[frase.length];
        int inicio=(frase.length-1), fin=(frase.length-1), i2=0;
        while(inicio>0){ //inicio=0 es el espacio
            while(frase[inicio]!=' '){ //busco el inicio de la palabra
                inicio--;//inicio de la palabra
            }
            for(int i=inicio; i<=fin; i++, i2++){ //bucle para copiar la palabra
                frase2[i2]=frase[i];//copio la palabra
            }
            fin=inicio=inicio-1;//establezco el inicio y fin de la siguiente palabra
        }
        System.out.println(frase);
        System.out.println(frase2);
    }
}
