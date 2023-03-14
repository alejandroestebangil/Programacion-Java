package Ej006;

import java.awt.*;

public class OvaloApp extends Frame { //hereda de la clase Frame
    Ovalo ovalo; //declaro un objeto ovalo
    public static void main(String[] args) {
        OvaloApp app = new OvaloApp(); //instancio el objeto app
    }

    public OvaloApp(){ //constructor
        super("Dibujando óvalos"); //para el nombre de la aplicacion en la ventana
        ovalo = new Ovalo(); //instancio el objeto ovalo

        Button boton1 = new Button("Salir");
        Button boton2 = new Button("Siguiente");
        Panel panel = new Panel();

        panel.add(boton1);
        panel.add(boton2);
        /*añado los botones a un panel que pondre en la parte inferior de la ventana porque no podemos
        hacer esto, ya que solo se vera un boton y no los dos:

        this.add("South",boton1);
        this.add("South",boton2);
        */

        this.add("South",panel);
        this.resize(300, 300); //le digo que la ventana tenga estas medidas
        this.show(true); //le digo que la ventana sea visible
    }

    //metodo para pintar, que forma dentro del ciclo de vida de la clase Frame
    public void paint(Graphics g){
        ovalo.paint(g);
    }

    //metodo de tratamiento de eventos para cerrar la ventana y para los botones
    public boolean handleEvent(Event ev) {
        if (ev.id == Event.WINDOW_DESTROY) {
            //WINDOWS_DESTROY es un atributo de la clase Event y va en mayusculas porque es una constante
            System.exit(0);
            return true;
        } else if (ev.id == Event.ACTION_EVENT)
            if (ev.target instanceof Button) { //esto es para comparar clases

                if (ev.arg.equals("Salir")) { //Si pulsamos el boton Salir, se cierra la ventana
                    System.exit(0);
                    return true;
                } else if (ev.arg.equals("Siguiente")) { //Si pulsamos el boton Siguiente, se crea nuevo ovalo
                    ovalo.inicializar();
                    //llamo al metodo inicializar del objeto ovalo para evitar directamente llamar al constructor
                    this.repaint();
                    return true;
                }
            }
            return false;
    }
}
