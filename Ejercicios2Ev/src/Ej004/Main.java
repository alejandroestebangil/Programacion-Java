package Ej004;

public class Main {
    public static void main(String[] args) throws Exception { //habra que habilitar tambien el throws exception en el main
        /*
        EJEMPLO EN EL QUE SE PUEDE PROBAR UNA EXCEPCION PARA VER SI FUNCIONA

        try{
            int a = 5;
            int b = 0;
            int c = a/b;

        }catch(ArithmeticException e){
            System.out.println("Has dividido entre 0 " + e.getMessage());
        }
        System.out.println("Mostrar mensaje");
         */
        Nif persona1;
        Nif persona2;

        persona1= new Nif(73068985); //asi me muestra el dni con la letra correcta
        persona2= new Nif(25208244, 'Z');
        //aqui me muestra el dni y la letra en el caso que sea correcta, si no salta la excepcion

        persona1.mostrarNif();
        persona2.mostrarNif();
    }

}
