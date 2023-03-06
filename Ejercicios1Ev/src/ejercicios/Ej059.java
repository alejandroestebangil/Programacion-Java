//Implementar funcion que sustituya los caracteres 'n' que hay en "frase" por la cadena "sutituto"
//EXYZ uXYZ lugar de la MaXYZcha
package ejercicios;

public class Ej059 {
    public static void main(String arg[]) {
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char sustituir = 'n';
        char sustituto[] = {'X', 'Y', 'Z'};
        char fraseSustituida[] = sustitucion(frase, sustituir, sustituto);
        System.out.println(fraseSustituida);
    }
    public static char[] sustitucion(char frase[], char sustituir, char sustituto[]) {
        char fraseX[] = new char[30];
        for (int i = 0, j = 0; i < frase.length; i++) {
            if (frase[i] == sustituir) { //
                for (int k = 0; k < sustituto.length; k++) {
                    fraseX[j] = sustituto[k]; //
                    j++;
                }
            }else { //este caso es cuando no hay que sustituir
                fraseX[j] = frase[i];
                j++;
            }
        }
        return fraseX;
    }
}