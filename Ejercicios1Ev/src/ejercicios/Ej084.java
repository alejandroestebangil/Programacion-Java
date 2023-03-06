//Eliminar de frase1 los espacios en blanco que sobran entre las palabras

package ejercicios;

public class Ej084 {
    public static void main(String[] args) {
        String frase1= "Habia        una        vez       un           circo";
        boolean primero = true;
        for(int i=0; i<frase1.length(); i++) {
            if (frase1.charAt(i) == ' ') { //si es un espacio
                if (primero) {
                    primero = false; //si es el primero, no lo borro
                } else {
                    frase1 = frase1.substring(0, i).concat(frase1.substring(i + 1, frase1.length()));
                    //esto borra el espacio
                    i--; //para que no se salte el siguiente caracter y no se quede sin comprobar y borrar
                }
            } else {
                primero = true;
            }
        }
        System.out.println(frase1);

        //ASÍ SE HUBIERA HECHO CON REPLACE
        //frase1=frase1.replace(" +", "");
        //System.out.println(frase1);
    }

}
