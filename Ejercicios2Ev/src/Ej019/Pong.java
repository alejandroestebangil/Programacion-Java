package Ej019;

import java.awt.*;
import java.applet.Applet;
import java.util.ArrayList;

public class Pong extends Applet implements Runnable {

    public static final int TIEMPO = 30;
    public static final int ARRIBA = -1;
    public static final int ABAJO = 1;
    int cronometro = 0;
    boolean hasEmpezado = false;
    boolean hasGanado = false;
    boolean gameOver = false;

    Thread animacion;
    Image imagen;
    Graphics noseve;

    Raqueta raqueta1;
    Raqueta raqueta2;
    Pelota pelota;

    public void init() {
        Frame title = (Frame) this.getParent().getParent();
        title.setTitle("Pong"); //cambiamos el nombre de la ventana
        this.setSize(300, 300); //tamaño de la ventana
        title.setMenuBar(null); //elimina la barra de menu de applet

        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();

        this.setFocusable(true); //para poder usar el teclado
        this.requestFocus();

        raqueta1 = new Raqueta(20,80);
        raqueta2 = new Raqueta(280,80);
        pelota = new Pelota();
    }

    public void start() {
        animacion = new Thread(this);
        //animacion.start(); // llama al metodo run
    }

    public void paint(Graphics g) {
        noseve.setColor(new Color(179,0,0));
        noseve.fillRect(0, 0, 300, 300);
        drawPista();

        raqueta1.paint(noseve);
        raqueta2.paint(noseve);
        pelota.paint(noseve);

        //puntuacion
        noseve.setColor(Color.WHITE);
        noseve.setFont(new Font("Arial", Font.BOLD, 14));
        noseve.drawString("Nadal " + pelota.getScore1() +" - "+ pelota.getScore2() + " Alcaraz", 95, 50);

        if (hasGanado)
            hasGanado();
        if (!hasEmpezado)
            pulsaEmpezar();

        noseve.setColor(Color.BLACK);
        g.drawImage(imagen, 0, 0, this);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void run() {
        while (true) {

            if (hasEmpezado) {
                pelota.update(raqueta1, raqueta2);
                if (pelota.getScore1() == 10 || pelota.getScore2() == 10) {
                    hasGanado = true;
                }
            }
            
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {
            }
        }
    }

    public boolean keyDown(Event ev, int tecla) {
        if(tecla == 1004) {
            raqueta1.update(ARRIBA);
            raqueta2.update(ARRIBA);
        } else if(tecla == 1005) {
            raqueta1.update(ABAJO);
            raqueta2.update(ABAJO);
        } else if (tecla == 32) {//empieza el juego con el espacio
            if(!hasEmpezado){
                hasEmpezado = true;
                animacion.start(); // llama al metodo run
                repaint();
            }
        }
        return true;
    }
    private void hasGanado() {
        noseve.setFont(new Font("Arial", Font.BOLD, 40));
        noseve.setColor(Color.BLACK);
        noseve.drawString("HAS GANADO", 16, 282);
        noseve.drawString("HAS GANADO", 16, 284);
        noseve.drawString("HAS GANADO", 14, 282);
        noseve.drawString("HAS GANADO", 14, 284);
        noseve.setColor(Color.GREEN);
        noseve.drawString("HAS GANADO", 15, 283);
        animacion.stop();
    }
    private void drawPista() {
        noseve.setColor(new Color(76,177,34));
        noseve.fillRect(35, 63, 235, 175);

        noseve.setColor(Color.WHITE);
        noseve.fillRect(35, 63, 235, 5);
        noseve.fillRect(35, 238, 235, 5);
        noseve.fillRect(35, 63, 5, 175);
        noseve.fillRect(265, 63, 5, 175);

        noseve.fillRect(35, 86, 235, 5);
        noseve.fillRect(35, 215, 235, 5);
        noseve.fillRect(84, 86, 5, 129);
        noseve.fillRect(216, 86, 5, 129);
        noseve.fillRect(84, 150, 135, 5);

        noseve.setColor(Color.BLACK);
        noseve.fillRect(152, 63, 5, 175);
        noseve.fillRect(149, 63, 10, 8);
        noseve.fillRect(149, 238, 10, 8);
        noseve.setColor(Color.WHITE);
        noseve.fillRect(154, 71, 1, 167);


    }
    private void pulsaEmpezar() {
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 300, 300);
        noseve.setColor(Color.WHITE);
        noseve.setFont(new Font("Arial", Font.BOLD, 50));
        noseve.drawString("TENNIS", 60, 109);
        noseve.drawString("TENNIS", 60, 110);
        noseve.drawString("TENNIS", 58, 109);
        noseve.drawString("TENNIS", 58, 110);
        noseve.setColor(Color.GREEN);
        noseve.drawString("TENNIS", 59, 110);
        noseve.setColor(Color.BLACK);
        noseve.fillOval(139, 107, 5, 5);
        noseve.fillOval(152, 107, 5, 5);
        noseve.drawArc(142, 115, 10, 5, 180, 180);
        noseve.setColor(Color.WHITE);
        noseve.setFont(new Font("Arial", Font.BOLD, 30));
        noseve.drawString("¡PULSA ESPACIO", 20, 180);
        noseve.drawString("PARA EMPEZAR!", 25, 215);
    }
}
