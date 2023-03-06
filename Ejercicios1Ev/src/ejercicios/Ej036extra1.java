//Calcular la media de goles de cada jugador en las ultimas cuatro temporadas
package ejercicios;

public class Ej036extra1 {
    public static void main(String arg[]) {
        int goles[][] = {{18, 19, 22, 33, 8},
                        {22, 24, 19, 18, 10},
                        {19, 20, 31, 42, 50},
                        {13, 14, 15, 16, 17}};
        String futbolistas []= {"Messi", "Ronaldo", "Neymar", "Mbappe", "Haaland"};
        String temporadas [] = {"2018-19", "2019-20", "2020-21", "2021-22"};
        double suma;
        for (int i = 0; i < futbolistas.length; i++) {
            suma = 0;
            for (int j = 0; j < goles.length; j++) {
                suma += goles[j][i];
            } //se suman todos los goles los jugadores en 4 años (vector goles[][] en vertical) y se hace la media
            System.out.printf("La media de goles de %s es %.1f\n", futbolistas[i], suma / goles.length);
        }
        System.out.println("");

        for (int i = 0; i < goles.length; i++) {
            suma = 0;
            for (int j = 0; j < goles[i].length; j++) {
                suma += goles[i][j];
            } //se suman todos los goles de todos los jugadores por temporada (vector goles[][] en horizontal)
            System.out.printf("La goles totales de la temporada %s es %.0f\n", temporadas[i], suma);
        }

    }
}
