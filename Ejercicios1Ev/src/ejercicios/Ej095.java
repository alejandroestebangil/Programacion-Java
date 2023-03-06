//Cambiar una cadena de caracteres cambiar a mayusculas
// las palabras cuya longitud sea mayor que tres
package ejercicios;

public class Ej095 {
    public static void main(String[] args) {
        char frase[] = {'e','n',' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'l', 'a', ' ', 'm', 'a', 'n', 'c', 'h', 'a', ' '};
        for (int i = 0; i < frase.length; i++) { //recorremos la frase
            int cont = 0; //contara el numero de caracteres de la palabra
            while (frase[i+cont] != ' ') { //contamos el numero de caracteres de la palabra sin espacios
                cont++;
            }
            if (cont > 3) { //cambia las palabras > 3
                for (int j = i; (j < frase.length) && (j<i+cont); j++) {
                    frase[j] = Character.toUpperCase(frase[j]); //cambia a mayuscula
                }
            }
            i += cont; //avanzamos el indice i hasta el final de la palabra
        }
        System.out.println(frase);

    }
}
