package Ej020;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//EN ESTE JUEGO HAY PELOTAS QUE SI LES HACES CLICK SE DIVIDEN EN 2 PELOTAS MAS PEQUEÑAS

public class Juego extends Applet implements Runnable {
    public static final int TIEMPO = 20;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    int milisegundos = 0;
    boolean gameOver = false;
    List<Pelota> pelotas;
    
    public void init(){
        Frame title = (Frame) this.getParent().getParent();
        title.setTitle("Bola Divisible"); //cambiamos el nombre de la ventana
        this.setSize(300, 300); //tamaño de la ventana
        title.setMenuBar(null); //elimina la barra de menu de applet

        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();

        this.setFocusable(true); //para poder usar el teclado directamente
        this.requestFocus();

        pelotas = new ArrayList<Pelota>();
        pelotas.add(new Pelota(150,150,80));

    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start(); // llama al metodo run
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0,0,400,400);

        for (int i=0; i<pelotas.size(); i++) {
            pelotas.get(i).paint(noseve);
        }
        
        if (gameOver)
            gameOver();

        g.drawImage(imagen,0,0, this);
    }
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while(true){
            milisegundos += TIEMPO;
            for (int i=0; i<pelotas.size(); i++) {
                pelotas.get(i).update();
            }

            if(pelotas.size() == 0) {
                gameOver = true;
                repaint();
                animacion.stop();
            }



            repaint();
            try {
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){}
        }
    }
    
    //funcion con la que al darle click a una pelota la divide en 2 pelotas mas pequeñas
    public boolean mouseDown(Event ev, int x, int y){
        for (int i=0; i<pelotas.size(); i++) {
            if (pelotas.get(i).contains(x,y)) {
                if(pelotas.get(i).width > 10) {
                    pelotas.add(new Pelota(pelotas.get(i).x, pelotas.get(i).y, pelotas.get(i).width / 2));
                    pelotas.add(new Pelota(pelotas.get(i).x, pelotas.get(i).y, pelotas.get(i).width / 2));
                }
                pelotas.remove(i);
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
        noseve.setColor(Color.RED);
        noseve.drawString("GAME OVER", 25, 268);
    }
}
