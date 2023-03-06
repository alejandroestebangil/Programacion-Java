package Ej017;

import java.awt.*;
import java.applet.Applet;
import java.util.ArrayList;
import java.util.List;

public class Invaders extends Applet implements Runnable{ //SPACE INVADERS
    public static final int TIEMPO = 30;
    public static final int IZDA = 0;
    public static final int DCHA = 1;
    int cronometro = 0;
    int score = 0;
    int highScore = 0;
    boolean empezar = false;
    boolean gameOver = false;

    Thread animacion;
    Image imagen;
    Graphics noseve;
    
    Arma arma;
    List<Bala> balas;
    List<Nave> naves;

    public void init(){
        
        Frame title = (Frame)this.getParent().getParent(); //cambiamos el nombre de la ventana
        title.setTitle("Space Invaders");

        this.setSize(300,300);

        title.setMenuBar(null); //elimina la barra de menu de applet

        imagen = this.createImage(300,300);
        noseve = imagen.getGraphics();
        
        this.setFocusable(true);
        this.requestFocus();

        arma = new Arma();
        balas = new ArrayList<Bala>();
        naves = new ArrayList<Nave>();

        for(int i=0; i<5; i++)
            naves.add(new Nave());

        gameOver = false;

    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start(); // llama al metodo run
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0,0,300,300);

        arma.paint(noseve);

        for(int i=0; i<balas.size(); i++){
            balas.get(i).paint(noseve);
        }

        for(int i=0; i<naves.size(); i++){
            naves.get(i).paint(noseve);
        }
        
        //SCOREBOARD
        noseve.setColor(Color.WHITE);
        noseve.setFont(new Font("Arial", Font.BOLD, 12));
        noseve.drawString("Score: " + score, 7, 277);
        
        noseve.setColor(Color.WHITE);
        noseve.setFont(new Font("Arial", Font.BOLD, 12));
        noseve.drawString("Highest Score: " + highScore, 7, 293);

        if (gameOver)
            gameOver();
        
        g.drawImage(imagen,0,0, this);
    }
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while(true){
            
            cronometro += TIEMPO;
            if (cronometro>=1200){
                naves.add(new Nave()); //crea una nave cada 2 segundos
                cronometro=0;
            }

            for(int i=0; i<balas.size(); i++){
                balas.get(i).update();
                if(balas.get(i).y < -10 || balas.get(i).y > 300) //miro todas las balas que salgan para eliminarlas cuando salgan de pantalla
                    balas.remove(i); //podriamos hacerlo fuera del bucle y solo eliminar 0 al ser la primera cada vez
            }

            for(int i=0; i<naves.size(); i++){
                naves.get(i).update();
            }

            //SI LA NAVE TOCA LA BALA LA ELIMINA
            for(int i=0; i<naves.size(); i++){
                for(int j=0; j<balas.size(); j++){
                    if(naves.get(i).intersects(balas.get(j))){
                        naves.remove(i);
                        balas.remove(j);
                        score += 10;
                        break;
                    }
                }
            }

            //SI LA NAVE TOCA EL ARMA GAME OVER
            for(int i=0; i<naves.size(); i++){
                if(naves.get(i).intersects(arma)){
                    gameOver = true;
                    if (score>highScore)
                        highScore=score;
                    repaint();
                    animacion.stop();
                }
            }
            //SI LA POSICION DE LA NAVE EN Y ES MAYOR QUE 300 GAME OVER
            for(int i=0; i<naves.size(); i++){
                if(naves.get(i).y > 300){
                    gameOver = true;
                    if (score>highScore)
                        highScore=score;
                    repaint();
                    animacion.suspend();
                }
            }
            repaint();
            try {
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){}
        }
    }

    public boolean mouseMove(Event ev, int x, int y){
        arma.update(x);
        return true;
    }
    public boolean mouseDown(Event ev, int x, int y){
        balas.add(new Bala(x));
        return true;
    }

    //si le doy al espacio
    public boolean keyDown(Event ev, int key){
        if(key == 32){
            if(gameOver){
                score = 0;
                naves.clear();
                balas.clear();
                for(int i=0; i<5; i++)
                    naves.add(new Nave());
                animacion.resume();
                repaint();
                gameOver = false;
            }
        }
        return true;
    }

    private void gameOver(){
        noseve.setFont(new Font("Arial",Font.BOLD,40));
        noseve.setColor(Color.RED);
        noseve.drawString("GAME OVER", 25, 150);
        noseve.setFont(new Font("Arial",Font.BOLD,14));
        noseve.setColor(Color.GREEN);
        noseve.drawString("Pulsa espacio para reiniciar",45,170);
    }
}
