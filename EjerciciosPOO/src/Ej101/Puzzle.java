package Ej101;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Puzzle extends Applet {
    public static final int ROWS = 5;
    public static final int COLUMNS = 5;
    public static final int PIECES = 25;
    private Image imagen;
    private Graphics noseve;
    public final static int SIZEX = 1000;
    public final static int SIZEY = 600;
    public final static int IMAGESIZE = 60;
    private Image imagenes[];
    private Pieza piezas[];
    private Pieza actual;
    private Rectangle[][] sitios;
    private int actualIniX;
    private int actualIniY;


    public void init() {
        Frame title = (Frame) this.getParent().getParent();
        title.setTitle("Google Dino"); //cambiamos el nombre de la ventana
        this.setSize(SIZEX, SIZEY);
        title.setMenuBar(null); //elimina la barra de menu de applet

        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics();

        this.setFocusable(true); //para poder usar el teclado directamente
        this.requestFocus();

        imagenes = new Image[PIECES];
        piezas = new Pieza[PIECES];


        for (int i = 0; i < PIECES; i++) {
            imagenes[i] = getImage(getCodeBase(), "Ej101/directorioImagenes/" + (i + 1) + ".png");
            piezas[i] = new Pieza(imagenes[i], i);
        }
        sitios = new Rectangle[ROWS][COLUMNS];
        //sitios = new Rectangle[PIECES];

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++)
                sitios[i][j] = new Rectangle(j * IMAGESIZE + 100, i * IMAGESIZE + 150, IMAGESIZE, IMAGESIZE);
            //sitios[i*ROWS + j] = new Rectangle(j*IMAGESIZE + 100, i*IMAGESIZE + 150, IMAGESIZE, IMAGESIZE);
        }
    }

    public void paint(Graphics g) {
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, SIZEX, SIZEY);

        //noseve.drawImage(getImage(getCodeBase(), "Ej101/directorioImagenes/mapamundi3.png"), 100, 150, this);

        noseve.setColor(Color.WHITE);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                noseve.drawRect(sitios[i][j].x, sitios[i][j].y, sitios[i][j].width, sitios[i][j].height);
            }
        }
        for (Pieza pieza : piezas) {
            pieza.paint(noseve, this);
        }
        g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }

    public void update(Graphics g) { //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);

    }

    public boolean mouseDown(Event ev, int x, int y) {
        for (Pieza pieza : piezas) {
            if (pieza.contains(x, y)) {
                actual = pieza;
                //break; lo quito para que no se quede con el ultimo que encuentre
            }
        }
        return true;

        /*for(int i = 0; i < PIECES; i++){
            if(piezas[i].contains(x, y)){
                actual = piezas[i];
                actualIniX = actual.x;
                actualIniY = actual.y;
                repaint();
                return true;
            }
        }
        return false;*/
    }

    public boolean mouseDrag(Event ev, int x, int y) {//cuando haces click y sin soltar, mueves
        if (actual != null) {
            actual.update(x, y);
            //actual.setX(x-actual.width/2);
            //actual.setY(y-actual.height/2);
            repaint();
        }
        return true;
    }

    public boolean mouseUp(Event ev, int x, int y) {//cuando haces click y sin soltar, mueves
        if (actual == null) {
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLUMNS; j++) {
                    if (actual.intersects(sitios[i][j]) && actual.getPosicion() == (i * COLUMNS) + j) {
                        actual.setX(j * IMAGESIZE);
                        actual.setY(i * IMAGESIZE);
                        actual.setMover(false);
                        //break;
                    }
                }
            }
        }
            /*for(int i = 0; i < PIECES; i++){
                if(piezas[i].intersects(sitios[i])){
                    piezas[i].x = sitios[i].x;
                    piezas[i].y = sitios[i].y;
                    break;
                } else{
                    actual.setX(actualIniX);
                    actual.setY(actualIniY);
                }
            }*/
        repaint();
        actual = null;

        return true;
    }
}