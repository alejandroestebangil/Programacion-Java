package Ej007;

import java.awt.*;
import java.io.*;

public class Editor extends Frame {
    MenuBar menuBar; //variable de tipo puntero
    TextArea texto;
    FileDialog abrirFichero, guardarFichero;

    public static void main(String[] args) {
        Editor app = new Editor();
    }

    public Editor() { //metodo constructor
        super("Editor de texto");
        setup();

        this.pack();
        this.resize(texto.minimumSize()); //le digo que la ventana tenga estas medidas
        this.show();

    }

    public void setup(){
        texto = new TextArea(25,55); //instancio el objeto texto
        this.add("Center",texto); //añado el objeto texto al centro de la ventana
        setupMenuBar();
        abrirFichero = new FileDialog(this, "Abrir fichero", FileDialog.LOAD);
        guardarFichero = new FileDialog(this, "Guardar fichero", FileDialog.SAVE);
    }
    public void setupMenuBar(){
        menuBar = new MenuBar(); //instancio el objeto menuBar
        Menu archivoMenu = new Menu("Archivo"); //instancio el objeto archivoMenu
        archivoMenu.add(new MenuItem("Nuevo")); //añado un item al menu archivoMenu
        archivoMenu.add(new MenuItem("Abrir"));
        archivoMenu.addSeparator(); //añado un separador
        archivoMenu.add(new MenuItem("Guardar"));
        archivoMenu.addSeparator();
        archivoMenu.add(new MenuItem("Salir"));
        menuBar.add(archivoMenu); //añado el menu archivoMenu al menuBar
        this.setMenuBar(menuBar); //añado el menuBar a la ventana

    }

    public void leerFichero(String nomFichero) {
        try {
            DataInputStream inStream;
            inStream = new DataInputStream(new FileInputStream(nomFichero));
            String total = "";
            String frase;
            while((frase = inStream.readLine()) != null) {
                total += frase + "\n"; //cada linea que lees le metes un retorno de carro y pasas de linea
            }
            texto.setFont(new Font("Courier", Font.BOLD, 12));
            texto.setText(total);
        } catch (FileNotFoundException e) {

        }
        catch (IOException e) {
            System.out.println("Error de lectura");
        }
    }

    public void guardarFichero(String nomFichero) {
        DataOutputStream outStream;
        try {
            outStream = new DataOutputStream(new FileOutputStream(nomFichero));
            outStream.writeBytes(texto.getText());
        } catch (FileNotFoundException e){}
        catch (IOException e) {}
    }

    //metodo de tratamiento de eventos para cerrar la ventana
    public boolean handleEvent(Event ev) {
        if (ev.id == Event.WINDOW_DESTROY) {
            //WINDOWS_DESTROY es un atributo de la clase Event y va en mayusculas porque es una constante
            System.exit(0);
            return true;
        } else if (ev.id == Event.ACTION_EVENT){
            if (ev.target instanceof MenuItem) { //esto es para comparar clases
                if (ev.arg.equals("Salir")) { //Si pulsamos el boton Salir, se cierra la ventana
                    System.exit(0);
                    return true;
                } else if (ev.arg.equals("Nuevo")) { //Si pulsamos el boton Nuevo, se borra el texto
                    texto.setText(" ");
                    return true;
                } else if (ev.arg.equals("Abrir")) {
                    abrirFichero.setVisible(true);
                    String nomFichero = abrirFichero.getDirectory() + "/" + abrirFichero.getFile();
                    leerFichero(nomFichero);
                    return true;
                }
                else if (ev.arg.equals("Guardar")) {
                    guardarFichero.setVisible(true);
                    String nomFichero = guardarFichero.getDirectory() + "/" + guardarFichero.getFile();
                    guardarFichero(nomFichero);
                    return true;
                }
            }
        }
        return false;
    }
}
