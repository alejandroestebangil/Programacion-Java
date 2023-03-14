package Ej012;

import java.awt.*;

public class Animacion1 extends Frame implements Runnable{
    Thread animacion;
    String frames[] = {"*", "**", "***", "****", "*****", "******", "*****", "****", "***", "**", "*"};
    int actual = 0;
    public static void main(String[] args) {
        Animacion1 app = new Animacion1();
    }
    public Animacion1(){
        super("Animacion sencilla");
        pack();
        this.setSize(200, 200);
        this.setVisible(true);
        animacion = new Thread(this);
        animacion.start();
    }

    public void paint(Graphics g){
        g.drawString(frames[actual], 75, 75);
    }

    public void run() {
        while (true) {
            actual = (++actual) % frames.length;
            //se usa ++actual o actual+1 pero actual++ no funciona
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }

    //cerrar ventana
    public boolean handleEvent(Event ev){
        if(ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }
        return false;
    }
}
