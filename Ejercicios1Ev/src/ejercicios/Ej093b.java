//Ley d'hondt forma del profe
package ejercicios;

public class Ej093b {
    public static void main(String[] args) {
        int votos[] = {119421, 157420, 57398, 46645, 91978};
        int escanyos = 7;
        String[] partidos = { "PP", "PSOE", "UP", "Cs", "VOX" };
        int coeficientes[] ={1,1,1,1,1};

        for (int i = 0; i < escanyos; i++) { //para cada escanyo
            int max = 0; //indice del partido con mas votos
            for (int j = 1; j < partidos.length; j++) { //para cada partido
                if ((votos[j] / coeficientes[j]) > (votos[max] / coeficientes[max])) {
                    max = j; //max pasa a ser el partido j
                }
            }
            coeficientes[max]++;
        }
        for (int i = 0; i < partidos.length; i++) {
            System.out.println(partidos[i] + " = " + (coeficientes[i] - 1));
        }
    }
}
