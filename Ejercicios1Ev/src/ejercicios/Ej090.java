//Cuantas campanadas de reloj se han dado hoy hasta la hora actual

package ejercicios;

public class Ej090 {
    public static void main(String[] args) {
        System.out.println("Numero de campanadas: " + campanadas1(13));
    }
public static int campanadas1(int hora) {
    int acum = 0;
    for (int i = hora; i > 0; i--)
        if (i > 12)
            acum += i - 12;
        else
            acum += i;
    return acum;
}
    public static int campanadas2(int hora) {
        if (hora==1)
            return 1;
        else if(hora>12)
                return (hora - 12) + campanadas2(hora - 1);
            else
                return hora + campanadas2(hora-1);

    }
}
