/*

 */
package Ej003;

public class Perro extends Animal {
    String raza;

    public Perro (int codigo, String paisOrigen, String nombre, String onomatopeya, String sexo, String raza){
        super(codigo, paisOrigen, nombre, onomatopeya, sexo);

        this.raza = raza;

    }

    public void hablar(){
        System.out.println("El perro con codigo: "+ codigo + " dice " + onomatopeya);
    }
}
