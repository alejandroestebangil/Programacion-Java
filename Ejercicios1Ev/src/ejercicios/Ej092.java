//Tienes un numero decimal y lo muestras en pantalla en binario
package ejercicios;

public class Ej092 {
    public static void main(String[] args) {
        int n = 1210;
        decimalBinario(n);
    }
    public static void decimalBinario(int n) {
        if (n == 1) //aqui no tendriamos en cuenta el 0
            System.out.print(n);
        else { //aqui hacemos la llamada recursiva antes del print para que se muestre de derecha a izquierda
            decimalBinario(n / 2);
            System.out.print(n % 2);
        }
    }
}
