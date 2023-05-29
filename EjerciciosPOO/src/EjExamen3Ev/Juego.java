/*

Es un juego en el que parece que un coche se desplaza por una carretera.
Hay una lista de coches de colores arriba que haciendo click en ellos cambiará el coche que se ve en pantalla.
Se acelerará o se frenará clickando unos pedales, el de la derecha acelera, el de la izquierda frena.
El coche no se mueve, es la imagen de fondo la que se desplaza hacia la izquierda.
Se desplazará más rápido dependiendo de la velocidad, que también aparece en pantalla, la velocidad
se modifica pulsando los pedales.

Se puntuará:

Análisis de las clases, sus atributos y métodos (5 puntos)
Clase principal, el Applet, atributos, instanciación, eventos, métodos… (5 puntos)

 */

package EjExamen3Ev;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class Juego extends Applet implements Runnable {
    public static final int NUMCOCHES = 4;
    private Thread animacion;
    private Image imagen;
    private Graphics noseve;
    public final static int SIZEX = 1000;
    public final static int SIZEY = 600;
    Image fondoImg;
    Image[] coches;
    Image aceleradorImg, frenoImg;
    Coche coche;
    Fondo fondo;
    Pedal acelerador, freno;
    ArrayList<Coche> cochesLista;

    public boolean acelerando = false;
    public boolean frenando = false;

    public void init(){
        Frame title = (Frame) this.getParent().getParent();
        title.setTitle("Examen3Ev"); //cambiamos el nombre de la ventana
        this.setSize(SIZEX, SIZEY);
        title.setMenuBar(null); //elimina la barra de menu de applet
        imagen = this.createImage(SIZEX, SIZEY);
        noseve = imagen.getGraphics();
        this.setFocusable(true); //para poder usar el teclado directamente
        this.requestFocus();

        fondoImg = getImage(getCodeBase(), "EjExamen3Ev/imagenes/tira.jpg");
        coches = new Image[NUMCOCHES];
        for (int i = 0; i < NUMCOCHES; i++) {
            coches[i] = getImage(getCodeBase(), "EjExamen3Ev/imagenes/coche" +(i+1)+".png");
        }
        aceleradorImg = getImage(getCodeBase(), "EjExamen3Ev/imagenes/acelerador.png");
        frenoImg = getImage(getCodeBase(), "EjExamen3Ev/imagenes/freno.png");

        fondo = new Fondo(fondoImg, 0);
        cochesLista = new ArrayList<>();
        for (int i = 0; i < NUMCOCHES; i++) {
            cochesLista.add(new Coche(coches[i], 30 + ((i * 180) + 30), 100, 100, 20));
        }


        coche = new Coche(coches[0], 50, 450, 250, 50);
        acelerador = new Pedal(aceleradorImg, 880, 425, 75, 150);
        freno = new Pedal(frenoImg, 780, 500, 75, 75);

    }
    public void start(){
        if (animacion == null){
            animacion = new Thread(this);
            animacion.start();
        }
    }

    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, SIZEX, SIZEY);


        fondo.dibujar(noseve, this);

        for (Coche c: cochesLista) {
            c.dibujar(noseve);
        }
        coche.dibujar(noseve);

        acelerador.dibujar(noseve);
        freno.dibujar(noseve);


        //CONTADOR DE VELOCIDAD
        noseve.setColor(Color.WHITE);
        noseve.setFont(new Font("Arial", Font.BOLD, 22));
        noseve.drawString(""+fondo.getVelocidad(), 30, 30);
        g.drawImage(imagen, 0, 0, this);
    }

    public void update(Graphics g){
        paint(g);

    }

    public boolean mouseDown(Event e, int x, int y) {
        if (acelerador.contains(x, y)) {
            acelerando = true;
        } else if (freno.contains(x, y)) {
            frenando = true;
        }

        else {
            for (Coche c: cochesLista) {
                if (c.contains(x, y)) {
                    coche.setImagen(c.getImagen());
                }
            }
        }
        return true;
    }

    public boolean mouseUp(Event e, int x, int y) {
        acelerando = false;
        frenando = false;
        return true;
    }


    public void run() {
        while (true) {
            if (acelerando) {
                fondo.setVelocidad(fondo.getVelocidad() + 2);
                repaint();
            }
            if (frenando) {
                fondo.setVelocidad(fondo.getVelocidad() - 3);
                if (fondo.getVelocidad() < 0) {
                    fondo.setVelocidad(0);
                }
                repaint();
            }

            fondo.mover();
            repaint();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) { }
        }
    }



}
