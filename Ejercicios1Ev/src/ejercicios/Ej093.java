//Ley d'Hondt
package ejercicios;

public class Ej093 {
    public static void main(String[] args) {
        int votos[] = {119421, 157420, 57398, 46645, 91978};
        int escanyos = 7;
        String[] partidos = { "PP", "PSOE", "UP", "Cs", "VOX" };
        int coeficientes[] ={1,1,1,1,1};
        int[] resultado = leyDHondt(votos, escanyos, partidos, coeficientes);
        for (int i = 0; i < resultado.length; i++) {
            System.out.println(partidos[i] + " = " + resultado[i]);
        }
    }
    public static int[] leyDHondt(int[] votos, int escanyos, String[] partidos, int[] coeficientes) {
        int[] resultado = new int[votos.length]; //array de escanyos por partido
        for (int i = 0; i < escanyos; i++) { //para cada escanyo
            int max = 0; //indice del partido con mas votos
            int indice = 0; //
            for (int j = 0; j < votos.length; j++) { //para cada partido
                if (votos[j] / coeficientes[j] > max) { //si el partido j tiene mas votos que el partido max
                    max = votos[j] / coeficientes[j]; //max pasa a ser el partido j
                    indice = j; //indice pasa a ser el partido j
                }
            }
            resultado[indice]++;
            coeficientes[indice]++;
        }
        return resultado;
    }
    //arregla la funcion copilot



}
