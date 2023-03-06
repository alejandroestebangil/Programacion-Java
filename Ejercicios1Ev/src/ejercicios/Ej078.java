//Convierte a mayus "en" cada vez que aparezca en la frase

//Tambien usamos la funcion concat() para concatenar strings
package ejercicios;

public class Ej078 {
    public static void main(String[] args) {
        String frase[] = {"en un lugar", "de en La Mancha", "de cuyo nombre", "no quiero acordarme"};
        String subcadena = "en";

        for (int i = 0; i < frase.length; i++) {
            frase[i]= frase[i].replace(subcadena, subcadena.toUpperCase());
            //reemplaza subcadena por subcadena en mayusculas
        }
        for (int i = 0; i < frase.length; i++) {
            System.out.printf("%s ", frase[i]);
        }




        frase[0] = frase[0].concat("hola"); //concatena hola al final de frase[0]
        System.out.println();
        System.out.println(frase[0]);
    }
}
