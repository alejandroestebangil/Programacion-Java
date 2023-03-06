/*
Dado un numero entero que se encuentra dentro de una variable, diseccionandolo,
analizandolo hasta las centenas de millar con recursividad
Ej n=12345 -> 5 unidades, 4 decenas, 3 centenas, 2 unidad de millar, 1 decenas de millar
 */
package ejercicios;

public class Ej091 {
    public static void main(String[] args) {
        int n = 456789;
        int unidades = 0;
        String medidas[] = {"unidades", "decenas", "centenas", "unidades de millar", "decenas de millar", "centenas de millar", "unidades de millon", "decenas de millon", "centenas de millon", "unidades de billon", "decenas de billon", "centenas de billon"};
        mostrarMedidas2(n, medidas, unidades);
    }
    public static void mostrarMedidas1(int n, String medidas[]) { //esta forma es sin recursividad
        if (n > 0) {
            for (int i = 0; i < medidas.length; i++) {
                if (n % 10 != 0) {
                    System.out.print(n % 10 + " " + medidas[i] + ", "); //muestra el ultimo digito y la medida
                }
                n = n / 10; //se divide entre 10 para ir sacando las unidades, decenas, centenas, etc
            }
        }
    }
    public static void mostrarMedidas2(int n, String medidas[], int unidades) { //mi forma recursiva
        if (n > 0) {
            //aqui hacemos la llamada recursiva antes del print para que se muestre de derecha a izquierda
            mostrarMedidas2(n / 10, medidas, unidades + 1); //elimina el ultimo digito
            System.out.print(n % 10 + " " + medidas[unidades] + "   "); //muestra el ultimo digito que es el resto
        }
    }
    public static void mostrarMedidas3(int n, String medidas[], int unidades) { //forma recursiva profe
        if ((n/10) == 0) {
            System.out.print(n % 10 + " " + medidas[unidades] + "   ");//muestra el resto(ultimo digito)
        }else{
            //aqui hacemos la llamada recursiva antes del print para que se muestre de derecha a izquierda
            mostrarMedidas3(n/10, medidas, unidades+1);
            System.out.print(n % 10 + " " + medidas[unidades] + "   ");//muestra el resto(ultimo digito)
        }
    }
}
