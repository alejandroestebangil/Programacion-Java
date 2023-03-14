/*

 */
package Ej003;

public class Mono extends Animal {
    String raza;
    String habilidades;

    public Mono (int codigo, String paisOrigen, String nombre, String onomatopeya, String sexo, String raza, String habilidades){
        super(codigo, paisOrigen, nombre, onomatopeya, sexo);

        this.raza = raza;
        this.habilidades = habilidades;

    }
    public void hablar(){
        System.out.println("El mono es " + raza + " y dice " + onomatopeya);
    }
}
