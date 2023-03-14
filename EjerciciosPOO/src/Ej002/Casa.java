package Ej002;

public class Casa {
    String domicilio;
    int numMetros;
    int numHabitaciones;
    String pais;

    public Casa(String domicilio, int numMetros, int numHabitaciones, String pais){
        this.domicilio = domicilio;
        this.numMetros = numMetros;
        this.numHabitaciones = numHabitaciones;
        this.pais = pais;
    }
    public void mostrar() {
        System.out.println("\nDirección: " + domicilio + "\nMetros Cuadrados: "
                + numMetros + "\nHabitaciones: " + numHabitaciones + "\nPais: " + pais);
    }
}
