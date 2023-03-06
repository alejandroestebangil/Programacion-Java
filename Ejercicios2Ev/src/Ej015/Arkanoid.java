package Ej015;

import java.awt.*;
import java.applet.Applet;
import java.util.ArrayList;
import java.util.List;

public class Arkanoid extends Applet implements Runnable{ //ARKANOID
    public static final int IZDA = -1;
    public static final int DCHA = 1;
    public static final int NUM_FILAS = 5;
    public static final int NUM_COLUMNAS = 10;
    public static final Color colores[] = {Color.RED, Color.YELLOW, Color.BLUE, Color.MAGENTA, Color.GREEN};
    int highestScore;
    boolean gameOver = false;

    Thread animacion;
    Image imagen;
    Graphics noseve;
    
    Pelota pelota;
    List<Ladrillo> ladrillos;
    Raqueta raqueta;

    public void init(){
        
        Frame title = (Frame)this.getParent().getParent(); //cambiamos el nombre de la ventana
        title.setTitle("Arkanoid");

        this.setSize(300,300);

        title.setMenuBar(null); //elimina la barra de menu de applet

        imagen = this.createImage(300,300);
        noseve = imagen.getGraphics();

        //hace que lea las teclas sin tener que hacer click en el applet
        this.setFocusable(true);
        this.requestFocus();

        pelota = new Pelota();
        ladrillos = new ArrayList<Ladrillo>();
        
        for(int i=0; i<NUM_FILAS; i++)
            for(int j=0; j<NUM_COLUMNAS; j++)
                ladrillos.add(new Ladrillo(j*(Ladrillo.ANCHURA+2), i*(Ladrillo.ALTURA)+5, colores[i]));

        raqueta = new Raqueta();

        gameOver = false;
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start(); // llama al metodo run
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);

        noseve.fillRect(0,0,300,300);
        
        for (int i=0; i<ladrillos.size(); i++){
            ladrillos.get(i).paint(noseve);
        }

        pelota.paint(noseve);
        raqueta.paint(noseve);
        
        //SCOREBOARD
        noseve.setFont(new Font("Arial",Font.BOLD,15));
        noseve.setColor(Color.green);
        noseve.drawString("Score: " + pelota.getScore(), 5, 293);
        
        noseve.setFont(new Font("Arial",Font.BOLD,15));
        noseve.setColor(Color.green);
        noseve.drawString("Highest Score: " + highestScore, 177, 293);

        if (gameOver) {
            noseve.setFont(new Font("Arial",Font.BOLD,40));
            noseve.setColor(Color.RED);
            noseve.drawString("GAME OVER", 25, 150);
        }
        
        g.drawImage(imagen,0,0, this);
    }
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while(true){
            pelota.update(raqueta, ladrillos);

            //si no queda ningun ladriillo, se reinicia el juego con mas velocidad de bola
            if(ladrillos.size() == 0){
                pelota.velX += 3;
                pelota.velY += 3;
                for(int i=0; i<NUM_FILAS; i++)
                    for(int j=0; j<NUM_COLUMNAS; j++)
                        ladrillos.add(new Ladrillo(j*(Ladrillo.ANCHURA+2), i*(Ladrillo.ALTURA)+5, colores[i]));
            }

            //ELIMINA LADRILLOS ANTERIORES TRAS HACER GAMEOVER
            for(int i=0; i<ladrillos.size(); i++){
                for(int j=0; j<ladrillos.size(); j++){
                    if(i != j){
                        if(ladrillos.get(i).intersects(ladrillos.get(j))){
                            ladrillos.remove(i);
                        }
                    }
                }
            }

            //si la pelota cae al suelo, se reinicia el juego y elimina los ladrillos
            if(pelota.y > 300){
                gameOver = true;
                repaint();
                animacion.suspend();
            }




            repaint();
            try {
                Thread.sleep(20);
            }catch(InterruptedException e){}
        }
    }
    
    public boolean keyDown(Event ev, int tecla){
        //mover flechas teclado para mover Raqueta a izda y dcha
        if(tecla == 1006)
            raqueta.update(IZDA);
        if(tecla == 1007)
            raqueta.update(DCHA);
        
        if(tecla == 32) { //al darle al espacio reinicia el juego
            if(gameOver) {
                gameOver = false;
                //reinicia el score y guarda el highest score
                if (pelota.score > highestScore)
                    highestScore = pelota.score;
                pelota.score = 0;

                //reinicia los ladrillos
                for (int i = 0; i < NUM_FILAS; i++){
                    if(i < ladrillos.size())
                        for (int j = 0; j < NUM_COLUMNAS; j++){
                        if(j < ladrillos.size())
                            ladrillos.add(new Ladrillo(j * (Ladrillo.ANCHURA + 2), i * (Ladrillo.ALTURA) + 5, colores[i]));
                    }
                }
                //reinicia la pelota
                pelota.x = 150;
                pelota.y = 150;
                pelota.velX = 2;
                pelota.velY = 2;

                animacion.resume();
                repaint();
                return false;

            }
        }

        //gameover

        
        return true;
    }
}
