package EjExamen2Ev;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class Juego extends Applet implements Runnable {
    Thread animacion;
    Image imagen;
    Graphics noseve;

    public static final int NUM_RECT = 5;

    Color colores[] = {Color.RED, Color.YELLOW, Color.BLUE, Color.MAGENTA, Color.GREEN};
    public static int TIEMPO = 20;

    Linea linea;
    List<rectanguloInmovil> listaRI;
    List<rectanguloMovil> listaRM;
    List<Linea> listaL;

    public void init() {
        Frame title = (Frame) this.getParent().getParent();
        title.setTitle("Examen 2Ev"); //cambiamos el nombre de la ventana
        this.setSize(300, 300); //tamaño de la ventana
        title.setMenuBar(null); //elimina la barra de menu de applet

        listaRI = new ArrayList<rectanguloInmovil>();
        listaRM = new ArrayList<rectanguloMovil>();
        listaL = new ArrayList<Linea>();

        for (int i = 0; i < NUM_RECT; i++) {
            listaRI.add(new rectanguloInmovil(20 + (i * 55), 245, colores[i]));
        }

        for (int i = 0; i < NUM_RECT; i++) {
            listaRM.add(new rectanguloMovil(colores[i]));
        }

        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();

        this.setFocusable(true); //para poder usar el teclado directamente
        this.requestFocus();

    }

    public void start() {
        animacion = new Thread(this);
        animacion.start(); // llama al metodo run
    }

    public void paint(Graphics g) {
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 400, 400);

        for (int i = 0; i < listaRI.size(); i++) {
            listaRI.get(i).paint(noseve);
        }

        for (int i = 0; i < listaRM.size(); i++) {
            listaRM.get(i).paint(noseve);
        }

        for (int i = 0; i < listaL.size(); i++) {
            listaL.get(i).paint(noseve);
        }

        g.drawImage(imagen, 0, 0, this);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void run() {
        do {
            for (int i = 0; i < listaRM.size(); i++) {
                listaRM.get(i).update();
            }

            for (int i = 0; i < listaL.size(); i++) {
                listaL.get(i).update();
            }

            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {
            }
        } while (true);
    }

    public boolean mouseDown(Event e, int x, int y) {
        for (int i = 0; i < listaRI.size(); i++) {
            if (listaRI.get(i).contains(x, y)) {
                linea = new Linea(x, y, listaRI.get(i).getColor());
                listaL.add(linea);
            }
        }
        return true;
    }

    public boolean mouseDrag(Event e, int x, int y) {
        for (int i = 0; i < listaL.size(); i++) {
            if (listaL.get(i).getColor() == linea.getColor()) {
                listaL.get(i).setPosX(x);
                listaL.get(i).setPosY(y);
            }
        }
        return true;
    }

    public boolean mouseUp(Event e, int x, int y) {
        for (int i = 0; i < listaL.size(); i++) {
            if (listaL.get(i).getColor() == linea.getColor()) {
                for (int j = 0; j < listaRM.size(); j++) {
                    if (listaRM.get(j).getColor() == linea.getColor()) {
                        listaRM.get(j).setLinea(listaL.get(i));
                    }
                }
            }
        }
        return true;
    }






}


