/*
CLASE PERSONA
Cada una persona seria un objeto de esta clase
Los atributos de la clase son dni, nombre, apellidos, fNac y domicilio
 */
package Ej001;

public class Persona {
    int dni;
    String nombre;
    String fNac; //tendria que ser Date en vez de String pero hay q importar java.util
    String domicilio;

    //Metodo constructor
    public Persona(int dni, String nombre, String fNac, String domicilio)
    {
        this.dni = dni; //con this se refiere al atributo de la clase
        this.nombre = nombre;
        this.fNac = fNac;
        this.domicilio = domicilio;
    }
    //si no tienes algun valor de los atributos no los pasas al public y los declaras en

    public void mostrar(){
        System.out.println(nombre +"-"+ dni + " f. Nac: "+ fNac + " Domicilio: "+ domicilio);
    }
}
