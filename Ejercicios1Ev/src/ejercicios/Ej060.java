//Implementar funcion que sustituya los caracteres 'n' que hay en "frase" por la cadena "sutituto" como
//en el ejercicio anterior pero sin usar una cadena auxiliar
package ejercicios;

public class Ej060 {
    public static void main(String arg[]) {
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char sustituir = 'n';
        char sustituta[] = {'X', 'Y', 'Z'};
        char frase2[] = new char[40];
        for (int i = 0; i < frase.length; i++)
            frase2[i] = frase[i];
        sustitucion(frase2, sustituir, sustituta);
        System.out.println(frase2);
    }
    public static void sustitucion(char frase2[], char sustituir, char sustituta[]) {
        for(int i=0; i<frase2.length; i++){
            if(frase2[i] == sustituir ){
                frase2[i] = sustituta[0];
                for(int j=1; j<sustituta.length; j++){
                    for(int z=(frase2.length-1); z>(i+1); z--){
                        frase2[z] = frase2[z-1];
                    }
                    i++;
                    frase2[i] = sustituta[j];
                }
            }
        }
    }


}
