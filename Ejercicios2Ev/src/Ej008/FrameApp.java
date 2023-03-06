package Ej008;

import java.awt.*;

public class FrameApp extends Frame {
    MenuBar porDefecto;
    MenuBar alternativo; //variable de tipo puntero
    String tituloInicial;
    int cursores[] = {Cursor.DEFAULT_CURSOR, Cursor.CROSSHAIR_CURSOR, Cursor.HAND_CURSOR, Cursor.MOVE_CURSOR, Cursor.WAIT_CURSOR, Cursor.TEXT_CURSOR, Cursor.N_RESIZE_CURSOR, Cursor.S_RESIZE_CURSOR, Cursor.E_RESIZE_CURSOR, Cursor.W_RESIZE_CURSOR, Cursor.NE_RESIZE_CURSOR, Cursor.NW_RESIZE_CURSOR, Cursor.SE_RESIZE_CURSOR, Cursor.SW_RESIZE_CURSOR, Cursor.NW_RESIZE_CURSOR, Cursor.NE_RESIZE_CURSOR, Cursor.SW_RESIZE_CURSOR, Cursor.SE_RESIZE_CURSOR, Cursor.HAND_CURSOR, Cursor.MOVE_CURSOR};
    int indCursor = 0;
    Color colores[] = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow};
    int indColor = 0;
    int indColorForeground = 0;
    String fuentes[] = {Font.DIALOG, "TimesRoman", "Courier", "Dialog", "DialogInput"};
    int indFuente = 0;
    public static void main(String[] args) {
        FrameApp app = new FrameApp();
    }

    public FrameApp() { //metodo constructor
        super("Propiedades del Frame"); //Texto del marco de la ventana
        tituloInicial = this.getTitle();
        setup(); //llamo al metodo setup

        this.pack(); //ajusta el tamaño de la ventana al tamaño de los componentes
        this.resize(400, 400); //le digo que la ventana tenga estas medidas
        this.show(); //muestra la ventana (ahora es setVisible(true))
    }

    public void paint(Graphics g) {
        g.drawString("Cambia el color al pulsar foreground", 100, 150);
    }

    public void setup() { //metodo setup
        setupMenuBar(); //llamo al metodo setupMenuBar
        setupPaneles(); //llamo al metodo setupPaneles
    }

    public void setupPaneles(){ //metodo setupPaneles
        Panel principal = new Panel(); //instancio el objeto principal
        principal.setLayout(new GridLayout(4,1)); //le digo que el layout del panel principal es BorderLayout

        principal.add(new Label("Cambian las caracteristicas de la ventana", Label.CENTER)); //añado un label al panel principal
        Panel panel1 = new Panel(); //instancio el objeto panel1
        panel1.add(new Button("MenuBar")); //añado un boton al panel1
        panel1.add(new Button("Titulo"));
        panel1.add(new Button("Resizable"));
        principal.add(panel1); //añado el panel1 al panel principal

        principal.add(new Label("Salidas en la ventana", Label.CENTER)); //añado un label al panel principal
        Panel panel2 = new Panel(); //instancio el objeto panel2
        panel2.add(new Button("Cursor")); //añado un boton al panel2
        panel2.add(new Button("Color"));
        panel2.add(new Button("Foreground"));
        panel2.add(new Button("Fuente"));
        principal.add(panel2); //añado el panel2 al panel principal

        this.add("South", principal); //añado el panel principal al sur de la ventana
    }

    public void setupMenuBar(){ //metodo setupMenuBar

        porDefecto = new MenuBar(); //instancio el objeto menuBar
        Menu fileMenu = new Menu("File"); //instancio el objeto fileMenu
        fileMenu.add(new MenuItem("Exit")); //añado un item al menu fileMenu
        porDefecto.add(fileMenu); //añado el menu fileMenu al menuBar
        this.setMenuBar(porDefecto); //añado el menuBar a la ventana


        alternativo = new MenuBar(); //instancio el objeto menuBar
        Menu fileMenu2 = new Menu("Archivo"); //instancio el objeto fileMenu2
        fileMenu2.add(new MenuItem("Salir")); //añado un item al menu fileMenu2
        alternativo.add(fileMenu2); //añado el menu fileMenu2 al menuBar

    }


    public boolean handleEvent(Event ev) {
        if (ev.id == Event.WINDOW_DESTROY) { //evento cerrar la ventana
            System.exit(0);
            return true;
        } else if (ev.id == Event.ACTION_EVENT) { //evento pulsar un boton
            if (ev.target instanceof Button) { //evento pulsar un boton
                if (ev.arg.equals("MenuBar")) { //Si pulsamos el boton MenuBar, cambia el menuBar
                    if (this.getMenuBar() == porDefecto) { //si el menuBar es el por defecto
                        this.setMenuBar(alternativo); //cambia el menuBar por el alternativo
                    } else { //si el menuBar es el alternativo
                        this.setMenuBar(porDefecto); //cambia el menuBar por el por defecto
                    }
                    return true;
                } else if (ev.arg.equals("Titulo")) { //Si pulsamos el boton Titulo, cambia el titulo
                    if (this.getTitle().equals(tituloInicial)) { //si el titulo es el inicial
                        this.setTitle("Titulo cambiado"); //cambia el titulo
                    } else { //si el titulo es el cambiado
                        this.setTitle(tituloInicial); //cambia el titulo
                    }
                    return true;
                } else if (ev.arg.equals("Resizable")) { //Si pulsamos el boton Resizable
                    this.setResizable(!this.isResizable()); //cambia el resizable
                    return true;
                } else if (ev.arg.equals("Cursor")) { //Si pulsamos el boton cursor
                    this.setCursor(cursores[indCursor]); //cambia el cursor
                    indCursor = (indCursor + 1) % cursores.length;
                    //incrementa el indice del cursor y si es mayor que el numero de cursores, lo pone a 0
                    return true;
                } else if (ev.arg.equals("Color")) { //Si pulsamos el boton color
                    this.setBackground(colores[indColor]); //cambia el color de fondo
                    indColor = (indColor + 1) % colores.length;
                    //incrementa el indice del color y si es mayor que el numero de colores, lo pone a 0
                    return true;
                } else if (ev.arg.equals("Foreground")) { //Si pulsamos el boton foreground
                    this.setForeground(colores[indColorForeground]); //cambia el color de la fuente
                    indColorForeground = (indColorForeground + 1) % colores.length;
                    //incrementa el indice del color y si es mayor que el numero de colores, lo pone a 0
                    return true;
                } else if (ev.arg.equals("Fuente")) { //Si pulsamos el boton fuente
                    this.setFont(new Font(fuentes[indFuente], Font.ITALIC, 15)); //cambia la fuente
                    indFuente = (indFuente + 1) % fuentes.length;
                    //incrementa el indice de la fuente y si es mayor que el numero de fuentes, lo pone a 0
                    return true;
                }
            }
        }
        return false;
    }
}
