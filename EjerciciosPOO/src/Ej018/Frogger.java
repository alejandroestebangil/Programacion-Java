package Ej018;

import javax.swing.tree.VariableHeightLayoutCache;
import java.awt.*;
import java.applet.Applet;
import java.util.ArrayList;

public class Frogger extends Applet implements Runnable {

    public static final int TIEMPO = 30;
    public static final int IZDA = 0;
    public static final int DCHA = 1;
    public static final int ARRIBA = 2;
    public static final int ABAJO = 3;
    int cronometro = 0;
    boolean hasEmpezado = false;
    boolean hasGanado = false;
    boolean gameOver = false;

    Thread animacion;
    Image imagen;
    Graphics noseve;

    Rana rana;
    ArrayList<Coche> coches;

    public void init() {

        Frame title = (Frame) this.getParent().getParent();
        title.setTitle("Frogger"); //cambiamos el nombre de la ventana
        this.setSize(300, 300); //tamaño de la ventana
        title.setMenuBar(null); //elimina la barra de menu de applet

        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();

        this.setFocusable(true); //para poder usar el teclado
        this.requestFocus();

        rana = new Rana(140,260);
        coches = new ArrayList<Coche>();
    }

    public void start() {
        animacion = new Thread(this);
        //animacion.start(); // llama al metodo run
    }

    public void paint(Graphics g) {
        noseve.setColor(new Color(155,118,83));
        noseve.fillRect(0, 0, 300, 300);
        drawRoad();
        drawMeta();

        rana.paint(noseve);
        for (int i=0; i<coches.size(); i++) {
            coches.get(i).paint(noseve);
        }

        if (hasGanado)
            hasGanado();
        if (gameOver)
            gameOver();
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

            cronometro += TIEMPO;
            if (cronometro >= 600) {
                if(Math.random() < 0.5) {
                    coches.add(new Coche(-30, (int) (Math.random() * (77-Coche.ALTURA)) + 148));
                } else {
                    coches.add(new Coche(330, (int) (Math.random() * (77-Coche.ALTURA)) + 73));
                }
                //crea coches cada menos de 1 segundo
                cronometro = 0;
            }

            //SI LA RANA LLEGA A LA META GANAS
            if (rana.isMeta()) {
                hasGanado = true;
                repaint();
                animacion.stop();
            }

            //ACTUALIZA LA POSICION DE LOS COCHES
            for (int i=0; i<coches.size(); i++) {
                coches.get(i).update();
                if (!coches.get(i).isInRoad()) {
                    coches.remove(i);
                }
            }

            //SI LA RANA CHOCA CON UN COCHE GAME OVER
            for (int i=0; i<coches.size(); i++) {
                if (rana.intersects(coches.get(i))) {
                    gameOver = true;
                    repaint();
                    animacion.suspend();
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
        if (tecla == 1004) {
            rana.update(ARRIBA);//flecha arriba
        } else if (tecla == 1005) {//flecha abajo
            rana.update(ABAJO);
        } else if (tecla == 1006) {//flecha izquierda
            rana.update(IZDA);
        } else if (tecla == 1007) {//flecha derecha
            rana.update(DCHA);
        } else if (tecla == 32) {//empieza el juego con el espacio
            if(!hasEmpezado){
                hasEmpezado = true;
                animacion.start(); // llama al metodo run
                repaint();
            }
        } else if (tecla == 114){ //reinicia el juego con la tecla R
            if (gameOver) {
                gameOver = false;
                rana = new Rana(140,260);
                for (int i=0; i<coches.size(); i++) {
                    coches.remove(i);
                }
                cronometro = 0;
                animacion.resume();
                repaint();
            }
        }
        return true;
    }
    private void gameOver() {
        noseve.setFont(new Font("Arial", Font.BOLD, 40));
        noseve.setColor(Color.BLACK);
        noseve.drawString("GAME OVER", 26, 267);
        noseve.drawString("GAME OVER", 26, 269);
        noseve.drawString("GAME OVER", 24, 267);
        noseve.drawString("GAME OVER", 24, 269);
        noseve.setFont(new Font("Arial",Font.BOLD,14));
        noseve.drawString("Pulsa 'R' para reiniciar",76,287);
        noseve.drawString("Pulsa 'R' para reiniciar",76,289);
        noseve.drawString("Pulsa 'R' para reiniciar",74,287);
        noseve.drawString("Pulsa 'R' para reiniciar",74,289);
        
        noseve.setFont(new Font("Arial", Font.BOLD, 40));
        noseve.setColor(Color.RED);
        noseve.drawString("GAME OVER", 25, 268);
        noseve.setFont(new Font("Arial",Font.BOLD,14));
        noseve.drawString("Pulsa 'R' para reiniciar",75,288);
    }
    private void hasGanado() {
        noseve.setFont(new Font("Arial", Font.BOLD, 40));
        noseve.setColor(Color.BLACK);
        noseve.drawString("HAS GANADO", 16, 274);
        noseve.drawString("HAS GANADO", 16, 276);
        noseve.drawString("HAS GANADO", 14, 274);
        noseve.drawString("HAS GANADO", 14, 276);
        noseve.setColor(Color.GREEN);
        noseve.drawString("HAS GANADO", 15, 275);
    }
    private void drawMeta() {
        noseve.setColor(Color.WHITE);
        for (int i=0; i<7; i++)
            noseve.fillRect(100+(i*16), 20, 8, 8);
        for (int i=0; i<6; i++)
            noseve.fillRect(108+(i*16), 28, 8, 8);
        for (int i=0; i<7; i++)
            noseve.fillRect(100+(i*16), 36, 8, 8);
        noseve.setColor(Color.BLACK);
        for (int i=0; i<6; i++)
            noseve.fillRect(108+(i*16), 20, 8, 8);
        for (int i=0; i<7; i++)
            noseve.fillRect(100+(i*16), 28, 8, 8);
        for (int i=0; i<6; i++)
            noseve.fillRect(108+(i*16), 36, 8, 8);
        noseve.fillRect(101, 44, 3, 22);
        noseve.fillRect(200, 44, 3, 22);
    }
    private void pulsaEmpezar() {
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 300, 300);
        noseve.setColor(Color.WHITE);
        noseve.setFont(new Font("Arial", Font.BOLD, 50));
        noseve.drawString("FROGGER", 25, 79);
        noseve.drawString("FROGGER", 25, 80);
        noseve.drawString("FROGGER", 23, 79);
        noseve.drawString("FROGGER", 23, 80);
        noseve.setColor(Color.GREEN);        
        noseve.drawString("FROGGER", 24, 80);
        noseve.fillRect(135, 250, 33, 7);
        noseve.fillRect(135,240,7,10);
        noseve.fillRect(161,240,7,10);
        noseve.fillOval(137, 110, 30, 20);
        noseve.fillOval(136, 105, 13, 13);
        noseve.fillOval(149, 105, 13, 13);
        noseve.setColor(Color.BLACK);
        noseve.fillOval(139, 107, 5, 5);
        noseve.fillOval(152, 107, 5, 5);
        noseve.drawArc(142, 115, 10, 5, 180, 180);
        noseve.setColor(Color.WHITE);
        noseve.setFont(new Font("Arial", Font.BOLD, 30));
        noseve.drawString("¡PULSA ESPACIO", 20, 180);
        noseve.drawString("PARA EMPEZAR!", 25, 215);
    }
    private void drawRoad() {
        noseve.setColor(Color.GRAY);
        noseve.fillRect(0, 75, 300, 150);
        noseve.setColor(Color.WHITE);
        noseve.drawLine(0, 75, 300, 75);
        noseve.drawLine(0, 225, 300, 225);
        noseve.drawLine(0, 150, 75, 150);
        noseve.drawLine(100, 150, 200, 150);
        noseve.drawLine(225, 150, 300, 150);
    }
}
