/*
MODIFICADORES CLASES
public - el metodo es visible en cualquier clase
abstract - no puedes implementar objetos de esa clase pero si puedes crear subclases de esa clase
final - Atributo declarado como constante (no se puede modificar). Las constantes todo en mayusculas
static - atributo de clase, no de objeto
 */
package Ej001;

public class Main {
    public static void main(String[] args) {
        //persona1, persona2, persona3 son objetos de la clase persona
        Persona persona1;
        Persona persona2;
        Persona persona3;

        //con el new Persona usa el metodo constructor para pasar los parametros
        persona1 = new Persona(20202020, "Alejandro", "1/1/9999", "Tarragona 6");
        persona2 = new Persona(34423234, "Kevin", "20/20/20", "Santander 31");
        persona3 = new Persona(343333, "Carlos", "12/12/2000", "Burgos 2");

        persona1.mostrar();
        persona2.mostrar();
        persona3.mostrar();

    }

}
