/*
Dada una cadena de caracteres frase1 cambiar a mayusculas las palabras cuya
longitud sea mayor que tres y hacer ese cambio en  frase2
*/
package ejercicios;

public class Ej095otro {
    public static void main(String[] args) {
        //lo mismo que Ej095 pero transformando frase1 en frase2
        char frase1[] = {'e','n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'm', 'a', 'n', 'c', 'h', 'a', ' '};
        char frase2[] = new char[frase1.length];
        for (int i = 0; i < frase1.length; i++) {
            int cont = 0; //contara el numero de caracteres de la palabra

            while (frase1[i+cont] != ' ') { //Contamos num de char de la palabra sin espacios
                cont++;
            }
            //Cambio las palabras > 3 y
            if (cont > 3) {
                for (int j = i; (j < frase1.length) && (j<i+cont); j++) {
                    frase2[j] = Character.toUpperCase(frase1[j]);
                }
            }
            //Meto las palabras en minuscula en frase2
            else {
                for (int j = i; (j < frase1.length) && (j<i+cont); j++) {
                    frase2[j] = frase1[j];
                }
            }
            //En frase2 ponemos los espacios en blanco dentro de los espacios vacios del array
            for (int j = i+cont; j < frase1.length; j++) {
                frase2[j] = ' ';
            }
            i += cont; //i hasta el final de la palabra
        }
        System.out.println(frase2);
    }
}
