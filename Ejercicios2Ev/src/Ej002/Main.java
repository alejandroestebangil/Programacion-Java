package Ej002;

public class Main {
    public static void main(String[] args) {
        Casa casa1;
        Chalet chalet1;

        casa1 = new Casa("Calle Santander 44", 50, 1, "Espanya");
        chalet1 = new Chalet("Calle Tarragona 99", 66, 2, "Espanya", 80, false);

        casa1.mostrar();
        System.out.println();
        chalet1.mostrar();
    }

}
