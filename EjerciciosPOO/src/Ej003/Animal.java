/*

 */
package Ej003;

public abstract class Animal {
    int codigo;
    String paisOrigen;
    String nombre;
    String onomatopeya;
    String sexo;

    public Animal(int codigo, String paisOrigen, String nombre, String onomatopeya, String sexo){
        this.codigo = codigo;
        this.paisOrigen = paisOrigen;
        this.nombre = nombre;
        this.onomatopeya = onomatopeya;
        this.sexo = sexo;
    }
    public abstract void hablar(); //al poner esto hablar va a ser obligatorio en las subclases
}
