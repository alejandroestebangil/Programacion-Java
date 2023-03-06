package ejercicios;

public class Ej089 {
    public static void main(String[] args) {
        mostrarFrase(5);
    }
    public static void mostrarFrase(int n) {
        if (n>0) {
            System.out.println("mostrarFrase(" + n + ")");
            mostrarFrase(n-1);
            System.out.println("mostrarFrase(" + n + ")");
        }
    }
}
