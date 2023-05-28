//RULETA APUESTAS
package Ej104_Ruleta;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ruleta extends Applet implements Runnable {
    private Image imagen;
    private Graphics noseve;
    public final static int DELAY = 100;
    public final static int SIZEX = 700;
    public final static int SIZEY = 800;
    public final static int FILAS = 12;
    public final static int COLUMNAS = 3;
    public final static int NUMFICHAS = 10;
    private Image imagenesFicha[];
    public Casilla tablero[][];
    public int rojos[] = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
    List<Integer> listaRojos;
    public int valoresFicha[] = {1, 5, 10, 25, 50, 100, 200, 500, 1000, 5000, 10000};
    private Ficha fichas[][];
    private Ficha actual;
    private Button boton;
    private int valorAleatorio;
    private int ultimosDiez[];
    private int capital; //dinero que tiene el jugador al empezar
    private int acumulador; //dinero acumulado en perdidas y ganancias de la ultima jugada

    public void init(){
        Frame title = (Frame) this.getParent().getParent();
        title.setTitle("Ruleta"); //cambiamos el nombre de la ventana
        this.setSize(SIZEX, SIZEY);
        title.setMenuBar(null); //elimina la barra de menu de applet
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics();
        this.setFocusable(true); //para poder usar el teclado directamente
        this.requestFocus();

        Panel panel = new Panel();
        boton = new Button("¡JUGAR!");
        boton.setFont(new Font("Arial", Font.BOLD, 15));
        panel.setBackground(Color.BLACK);
        panel.add(boton);
        this.setLayout(new BorderLayout());
        this.add("North", panel);

        listaRojos = new ArrayList<Integer>();
        for (int i = 0; i < rojos.length; i++) {
            listaRojos.add(new Integer(rojos[i]));
        }
        tablero = new Casilla[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (listaRojos.contains(new Integer((i*COLUMNAS)+j+1)))
                    tablero[i][j] = new Casilla((j*Casilla.SIZE)+20, (i*Casilla.SIZE)+40, ((i*COLUMNAS)+j+1), Color.RED);
                else
                    tablero[i][j] = new Casilla((j*Casilla.SIZE)+20, (i*Casilla.SIZE)+40, ((i*COLUMNAS)+j+1), Color.BLACK);
            }
        }

        imagenesFicha = new Image[NUMFICHAS];
        for (int i = 0; i < NUMFICHAS; i++) {
            imagenesFicha[i] = getImage(getCodeBase(), "Ej104_Ruleta/Fichas/ficha" +(i+1)+".png");
        }

        fichas = new Ficha[NUMFICHAS][NUMFICHAS];
        for (int i = 0; i < NUMFICHAS; i++) {
            for (int j = 0; j < NUMFICHAS; j++) {
                fichas[i][j] = new Ficha((i*60)+45, imagenesFicha[i], valoresFicha[i]);
            }
        }

        ultimosDiez = new int[NUMFICHAS];
        capital = 10000;
    }

    public void paint(Graphics g){
        noseve.setColor(new Color(76,106,90));
        noseve.fillRect(0, 0, SIZEX, SIZEY);
        noseve.setColor(Color.BLACK);

        pintarTablero();

        g.drawImage(imagen, 0, 0, SIZEX, SIZEY, this);
    }


    public void run() {
        while (true) {
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException ex){
                System.out.println("Error en el hilo");
            }
            repaint();
        }
    }

    public void update(Graphics g){
        paint(g);
    }

    public boolean mouseDown(Event evt, int x, int y) {
        for (int i = 0; i < NUMFICHAS; i++) {
            for (int j = 0; j < NUMFICHAS; j++) {
                if (fichas[i][j].contains(x, y)){
                    actual = fichas[i][j];
                }
            }
        }
        return true;
    }

    public boolean mouseDrag(Event evt, int x, int y) {
        if (actual != null){
            actual.move((x-(Ficha.SIZE/2)), (y-(Ficha.SIZE/2)));
        repaint();
        }
        return true;
    }

    public boolean mouseUp(Event evt, int x, int y) {
        try {
            actual.setApuestas(tablero);
            actual = null;
            return true;
        } catch (NullPointerException e) {
            return false;
        }
        //Solo haria falta lo del try pero asi no me da error en el caso de que no haya ficha seleccionada
    }

    public boolean action(Event evt, Object obj) {
        if (evt.target instanceof Button) {
            /*if (obj.equals("Jugar!")) {
                Thread hilo = new Thread(this);
                hilo.start();
            }*/
            valorAleatorio = ((int)(Math.random() * 37));
            desplazarVectorDiezNum();
            comprobarApuesta();
            repaint();
            return true;
        }
        return false;
    }

    private void pintarTablero() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j].paint(noseve);
            }
        }

        for (int i = 0; i < NUMFICHAS; i++) {
            for (int j = 0; j < NUMFICHAS; j++) {
                fichas[i][j].paint(noseve, this);
            }
        }

        marcadorNumero();
        marcadorDiezUltimos();

        noseve.setColor(Color.BLACK);
        noseve.drawString("Total = "+capital+"€", 422, 60);
        noseve.drawString("Ult. jug. = "+acumulador+"€", 422, 100);
    }

    private void comprobarApuesta() {
        for (int i = 0; i < NUMFICHAS; i++) {
            for (int j = 0; j < NUMFICHAS; j++) {
                for (Casilla apuesta : fichas[i][j].getApuestas()) {
                    if (valorAleatorio == apuesta.valor) {
                        acumulador += fichas[i][j].getValor()*(FILAS*COLUMNAS) / fichas[i][j].getApuestas().size();
                    }
                    if (fichas[i][j].getApuestas() != null) acumulador -= fichas[i][j].getValor();
                    //si la ficha ha apostado a un numero, se le resta el valor de la ficha
                }
            }
        }
        capital += acumulador;
    }

    private void desplazarVectorDiezNum() {
        for (int i = 1; i < NUMFICHAS; i++) {
            ultimosDiez[i-1] = ultimosDiez[i];
        }
        ultimosDiez[NUMFICHAS-1] = valorAleatorio;
    }

    private void marcadorNumero() {
        noseve.setColor(Color.BLACK);
        noseve.drawRect(290, 20, 120, 150);
        noseve.drawRect(292, 22, 120, 150);

        //DIBUJAR VALOR ALEATORIO CON COLOR CORRESPONDIENTE
        noseve.setFont(new Font("Arial", Font.BOLD, 30));
        if (listaRojos.contains(new Integer(valorAleatorio))) {
            noseve.setColor(Color.RED);
            noseve.drawString("ROJO", 306, 100);
        } else if (valorAleatorio == 0) {
            noseve.setColor(Color.GREEN);
            noseve.drawString("VERDE", 297, 100);
        } else {
            noseve.setColor(Color.BLACK);
            noseve.drawString("NEGRO", 297, 100);
        }
        noseve.drawString(""+valorAleatorio, 337, 70);

        //SACAR FALTA O PASA
        if(valorAleatorio <= 18)
            noseve.drawString("FALTA", 303, 130);
        else
            noseve.drawString("PASA", 308, 130);

        //SACAR PAR O IMPAR
        if(valorAleatorio == 0)
            noseve.drawString("NADA", 309,160);
        else if ((valorAleatorio%2) == 0)
            noseve.drawString("PAR", 315, 160);
        else
            noseve.drawString("IMPAR", 301, 160);
    }

    private void marcadorDiezUltimos() {
        noseve.setFont(new Font("Arial", Font.BOLD, 20));
        for (int i = 0; i < NUMFICHAS; i++) {
            if (ultimosDiez[i] == 0) {
                noseve.setColor(Color.GREEN);
            } else if ((!listaRojos.contains(new Integer(ultimosDiez[i])))) {
                noseve.setColor(Color.BLACK);
            } else {
                noseve.setColor(Color.RED);
            }
            noseve.drawString(""+ultimosDiez[i], ((i*33)+245), 630);
        }
        noseve.setColor(Color.BLACK);
        noseve.drawString("ÚLTIMOS 10 NÚMEROS: ", 275, 605);
    }
}
