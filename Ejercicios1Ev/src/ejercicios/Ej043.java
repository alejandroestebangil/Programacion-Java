//Tratamiento de funciones o metodos
package ejercicios;

public class Ej043 {
    public static void main(String arg[]){
        //Si empieza por mayusucula es clase (objeto), si empieza por minuscula es metodo (funcion)
        String palabras;
        escribir();
        hablar("Hola que tal");
        animalHabla("Perro", "Guau");
        System.out.println(concatenar("En un lugar ", "de la mancha"));
        concatenar2("En un lugar de la mancha ", "de cuyo nombre no quiero acordarme");
        System.out.printf("La suma de 45 + 30 = %d", suma(45, 30));
    }
    //Esta funcion no devuelve nada, es void (vacío). Imprime por pantalla "Hola"
    public static void escribir(){
        System.out.println("Hola");
    }
    //Esta funcion espera recibir un parametro de tipo String. Imprime la String frase declarada en main
    public static void hablar(String frase){
        System.out.println(frase);
    }
    //Void espera recibir 2 String. Imprime las String frase y animal declarada en main al llamar a la funcion
    public static void animalHabla(String animal, String frase){
        System.out.printf("El %s dice %s\n", animal, frase);
    }
    //Es una funcion String que espera recibir 2 String. Devuelve la concatenacion de las 2 String
    public static String concatenar(String frase1, String frase2){
        return frase1 + frase2;
    }
    //Es una funcion String como la anterior pero imprime la concatenacion pero no devuelve nada ("")
    public static String concatenar2(String frase1, String frase2){
        System.out.println(frase1 + frase2);
        return "";
    }
    //Es una funcion double que espera recibir 2 int. Devuelve la suma de los 2 int
    public static int suma(int num1, int num2){
        return num1 + num2;
    }
}
