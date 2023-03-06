//Implementar funcion que devuelva el n de veces que una subcadena aparece repetia en una cadena
package ejercicios;

public class Ej061 {
    public static void main(String arg[]) {
        char frase[] = {'E', 'n', 'n', 'n', 'n', ' ', 'n', 'n','n', 'r', ' ', 'n', 'n', 'n', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char subcadena[] = {'n','n','n'};
        int contador=0;
        System.out.println("Numero de veces que aparece la subcadena: " + contarSubcadena2(frase, subcadena, contador));
    }
    //Esta forma usa dos for, tres if y un break (largo pero mas facil de pensar)
    public static int contarSubcadena1(char frase[], char subcadena[], int contador){
        for (int i = 0; i < frase.length; i++) {
            if (frase[i] == subcadena[0]){
                for (int j = 0; j < subcadena.length; j++) {
                    if (frase[i+j] == subcadena[j]) {
                        if (j == subcadena.length - 1)
                            contador++;
                    }else {
                        break;
                    }
                }
            }
        }
        return contador;
    }
    //Esta forma usa un for, un while y dos if (corta pero mas dificil de pensar)
    public static int contarSubcadena2(char frase[], char subcadena[], int contador){
        int j;
        for (int i = 0; i < frase.length; i++) {
            if(frase[i] == subcadena[0]){
                //Apartir de aqui abajo es distinto a la forma anterior - USANDO WHILE
                j=1;
                while((j<subcadena.length) && (subcadena[j] == frase[i+j]))
                    j++;
                if(j==subcadena.length)
                    contador++;
            }
        }
        return contador;
    }

}
