//Division entera mediante restas (bucle for)
package ejercicios;

public class Ej012 {
    public static void main(String arg[]){
        int divis = 3;
        int ogdivid = 21;
        int divid = ogdivid; //variable igual al dividendo que almacena las restas del divisor
        int resto = ogdivid % divis; //calculo del resto
        int coci;
        for (coci = 0; divis <= divid; coci++){
            divid -= divis;
        } //bucle que almacena las restas de dividendo-divisor hasta que el dividendo = divisor (ej: 3 = 3)
        System.out.println(ogdivid + " / " + divis + " = " + coci + " y el resto es " + resto);
    }
}

