//El chalet hereda todos los atributos de casa, ya que un chalet es una casa
package Ej002;

public class Chalet extends Casa{ //casa es la clase superior y chalet la subclase
    int metrosJardin;
    boolean piscina = true;

    public Chalet(String domicilio, int numMetros, int numHabitaciones, String pais, int metrosJardin, boolean piscina){
        super(domicilio, numMetros,numHabitaciones, pais);

        this.metrosJardin = metrosJardin;
        this.piscina = piscina;
    }//usamos this si en el metodo constructor tienen el mismo nombre que en la clase

    public void mostrar(){
        if(piscina==false)
            System.out.println("Esto es un chalet sin piscina." + "\nDirección: " + domicilio
                    + "\nMetros Cuadrados: "+ numMetros + "\nMetros Cuadrados Jardin: "
                    + metrosJardin +"\nHabitaciones: "+ numHabitaciones + "\nPais: " + pais);
        else
            System.out.println("Esto es un chalet con piscina." + "\nDirección: " + domicilio
                    + "\nMetros Cuadrados: "+ numMetros + "\nMetros Cuadrados Jardin: "
                    + metrosJardin +"\nHabitaciones: "+ numHabitaciones + "\nPais: " + pais);
    }

}
