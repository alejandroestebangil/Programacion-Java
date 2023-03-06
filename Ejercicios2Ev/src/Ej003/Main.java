package Ej003;

public abstract class Main  {
    public static void main(String[] args) {
        Mono mono;
        Perro perro;

        mono = new Mono(4,"Sudan","Titi","U u u","Masculino","Hola","Volar");
        perro = new Perro(4,"Sudan","Titi","Guau guau","Masculino","Hola");

        perro.hablar();
        mono.hablar();
    }
}
