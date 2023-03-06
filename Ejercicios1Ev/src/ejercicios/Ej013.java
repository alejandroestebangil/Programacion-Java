/* 
VARIACION DE TANTOS ELEMENTOS TOMADOS DE TANTOS EN TANTOS
COMBINATORIA PERO NO

 3          7!       7*6*5*4*3*2*1
V    =  _________ = _______________
 7          3!           3*2*1

*/

package ejercicios;

public class Ej013 {
    public static void main(String arg[]){
        int elementos = 7; // elementos tiene que ser mayor que tomados
        int tomados = 3;
        int resu = 1;
        for (int i = elementos; i > tomados; i--){ //acaba cuando i llega a tomados+1 -> 7*6*5*4
            resu *= i;
        }
        System.out.println("Variaciones de " + elementos + " elementos, tomados de " + tomados + " en " + tomados + " = "+ resu + "(Con for)");
        
        resu = 1;
        int i = elementos;
        while(i > tomados){
            resu *= i;
            i--;      
        } //lo mismo que con el bucle for pero con while
        System.out.printf("Variaciones de %d elementos, tomados de %d en %d = %d (Con while) \n", elementos, tomados, tomados, resu);
        //FORMA DE HACER PRINT MÁS CORTA CON \n (SECUENCIA DE ESCAPE) PARA SALTAR DE LÍNEA
    }
}

