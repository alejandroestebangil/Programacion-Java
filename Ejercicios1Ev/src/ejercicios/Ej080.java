/*
Tenemos una frase formada por palabras separadas por un espacio
en blanco. Cada palabra se debe guardar en un elemento del vector.
Despues ordenaré el vector alfabéticamente y mostraréis sus strings por pantalla.
*/
package ejercicios;

public class Ej080 {
    public static void main(String[] args) {
        String frase = "5Cinco 6Seis 2Dos 4Cuatro 1Uno 3Tres ";
        String vector[];

        //Encontramos cuantos espacios hay en la frase para saber cuantos elementos en el vector habrá
        int pos = frase.indexOf(" "); //primera pos espacio
        int cont = 0;
        while (pos != -1) { //mientras haya espacios
            cont++;
            pos = frase.indexOf(" ", pos + 1); //busca el siguiente espacio
        }
        vector = new String[cont];

        //Guardamos las palabras en el vector
        pos = frase.indexOf(" "); //pos del primer espacio
        int pos2 = 0; //pos2 del primer caracter de la palabra

        for (int i = 0; i < vector.length; i++) {
            vector[i] = frase.substring(pos2, pos); //guarda la palabra en el vector (aqui el profe cogia pos+1 para coger el espacio para rellenar el vector otra vez pero yo lo concateno con vector[]+ " ")
            pos2 = pos + 1; //pos primer caracter de la siguiente palabra (uno mas que el espacio anterior)
            pos = frase.indexOf(" ", pos + 1); //pos del siguiente espacio
        }

        //Ordenamos el vector alfabeticamente y lo mostramos en pantalla
        ordenar(vector);
        for (int i = 0; i < vector.length; i++)
            System.out.println(vector[i]);
        System.out.println();

        //Vaciamos frase, formamos frase con las palabras ordenadas del vector y mostramos
        frase = "";
        for (int i = 0; i < vector.length; i++)
            frase = frase.concat(vector[i] + " ");
        System.out.println(frase);


    }
    //Funcion para ordenar alfabeticamente un vector de strings
    public static void ordenar(String[] vector) {
        for (int i = 0; i < vector.length; i++) { //j<vector.length-1
            for (int j = 0; j < vector.length; j++) { //int j=vector.length-1; j>i; j--
                if (vector[i].compareTo(vector[j]) < 0) { //vector[j].compareTo(vector[j-1])
                    String aux = vector[i]; //vector[j]
                    vector[i] = vector[j]; //vector[j] = vector[j-1]
                    vector[j] = aux;//vector[j-1] = aux
                }
            }
        }
    }
}
