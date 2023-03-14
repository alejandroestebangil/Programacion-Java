package Ej004;

public class Nif {
    public int dni;
    public char letra;
    public static char TABLA[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    //constructor
    public Nif(int dni, char letra) throws Exception { //este metodo es capaz de lanzar una excepcion
        this.dni = dni;
        if(letra != TABLA[dni%23]){ //si la letra no es la correcta
            letra = TABLA[dni%23]; //letra correcta
            throw new Exception("El nif no es correcto"); //lanzamos una excepcion
        }
        else {
            this.letra = letra;
        }
    }
    //aqui queda demostrado el polimorfismo porque se puede usar el mismo metodo para distintos tipos de datos
    public Nif(int dni){
        this.dni = dni;
        letra = TABLA[dni % TABLA.length];
    }
    //mostrar nif
    public void mostrarNif(){
        System.out.println("El NIF es: " + dni + letra);
    }
}
