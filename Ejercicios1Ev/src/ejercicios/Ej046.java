/*
Instanciar funciones para que devuelva de cada trabajador el salario semestral

1) Crear dos funcione llamadas salariosSemestrales que devuelva un vector de enteros
con el salario que ha acumulado cada empleado en los ultimos 6 meses y luego mostrar
el salario semestral de cada empleado con su nombre. Lo hacemos de dos maneras funcion int y void.

2)Crear dos funcione llamadas "sumaSalarios", que acumulen por meses y despues
mostramos de cada mes cuanto hemos pagado a los empleados
*/
package ejercicios;

public class Ej046 {
    public static void main(String arg[]) {
        int salarios[][] = {{730, 900, 1330, 800, 790, 850},
                            {1000, 950, 1080, 1070, 1200, 1100},
                            {1300, 930, 1200, 1170, 1000, 1000},
                            {1500, 1950, 1880, 1970, 2200, 2100}};
        String empleados[] = {"Javier Marías", "Antonio Muñoz", "Luis", "Maria"};
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};

        //MOSTRAR SEMESTRAL CON INT
        int salSemestral[] = salariosSemestrales(salarios); //se declara un vector donde cargar la funcion
        System.out.println("Pago semestral de cada empleado con void:\n");
        for (int i = 0; i < salSemestral.length; i++) { //bucle para mostrar por pantalla cada salario
            System.out.printf("%s ha ganado %d€ en los últimos 6 meses\n", empleados[i], salSemestral[i]);
        }
        System.out.println("");

        //MOSTRAL SEMESTRAL CON VOID
        int salSemestral2[] = new int[4];
        salariosSemestrales(salarios,salSemestral2);
        System.out.println("Pago semestral de cada empleado con void:\n");
        for (int i = 0; i < salSemestral.length; i++) {
            System.out.printf("%s ha ganado %d€ en los últimos 6 meses\n", empleados[i], salSemestral2[i]);
        }
        System.out.println("");

        //MOSTRAR MENSUAL CON INT
        int salMensual[] = salariosMensuales(salarios);
        System.out.println("Pago mensual total con int:\n");
        for (int i = 0; i < meses.length; i++) {
            System.out.printf("En %s pagamos %d€\n", meses[i], salMensual[i]);
        }
        System.out.println("");

        //MOSTRAR MENSUAL CON VOID
        int salMensual2[] = new int[6];
        salariosMensuales(salarios, salMensual2);
        System.out.println("Pago mensual total con void:\n");
        for (int i = 0; i < meses.length; i++) {
            System.out.printf("En %s pagamos %d€\n", meses[i], salMensual2[i]);
        }
    }

    //SEMESTRAL CON INT
    public static int[] salariosSemestrales(int salarios[][]) {
        int semestrales[] = new int[salarios.length];
        //se declara la variable con el espacio del vector salarios para hacer la suma y saber el total de 6 meses
        for (int i = 0; i < salarios.length; i++) {
            for (int j = 0; j < salarios[i].length; j++) {
                semestrales[i] += salarios[i][j];
            }
        }
        return semestrales;
        //devuelve el vector de enteros
    }

    //SEMESTRAL CON VOID
    public static void salariosSemestrales(int salarios[][], int salSemestral2[]) {
        for (int i = 0; i < salarios.length; i++) {
            for (int j = 0; j < salarios[i].length; j++) {
                salSemestral2[i] += salarios[i][j];
            }
        }
    }

    //MENSUAL CON INT
    public static int[] salariosMensuales(int salarios[][]) {
        int mensuales[] = new int[6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < salarios.length; j++) {
                mensuales[i] += salarios[j][i];
            }
        }
        return mensuales;
    }

    //MENSUAL CON VOID
    public static void salariosMensuales(int salarios[][], int salMensual2[]) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < salarios.length; j++) {
                salMensual2[i] += salarios[j][i];
            }
        }
    }
}


