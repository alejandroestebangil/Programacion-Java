package Ej016;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Flappy extends Applet implements Runnable{ //Flappy Bird
    public static final int TIEMPO = 30;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Pajaro pajaro;
    List<Columna> columnas;
    int cronometro = 0;
    boolean gameOver = false;
    int score = 0;

    public void init(){
        
        Frame title = (Frame)this.getParent().getParent(); //cambiamos el nombre de la ventana
        title.setTitle("Flappy Bird");
        this.setSize(300,300); //tamaño de la ventana
        title.setMenuBar(null); //elimina la barra de menu de applet
        this.setFocusable(true);
        this.requestFocus();

        pajaro = new Pajaro();
        columnas = new ArrayList<Columna>();
        columnas.add(new Columna());

        imagen = this.createImage(300,300);
        noseve = imagen.getGraphics();

    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start(); // llama al metodo run
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.cyan);
        noseve.fillRect(0,0,300,300);

        pajaro.paint(noseve);
        for(int i=0; i<columnas.size(); i++)
            columnas.get(i).paint(noseve);

        if(gameOver){
            noseve.setColor(Color.RED);
            noseve.setFont(new Font("Arial", Font.BOLD, 40));
            noseve.drawString("GAME OVER", 30, 150);
            noseve.setFont(new Font("Arial",Font.BOLD,14));
            noseve.drawString("Pulsa 'R' para reiniciar",75,170);
        }
        //scoreboard
        noseve.setColor(Color.WHITE);
        noseve.setFont(new Font("Arial", Font.BOLD, 40));
        noseve.drawString(" " + score, 130, 45);

        g.drawImage(imagen,0,0, this);
    }
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while(true){
            pajaro.update();
            for(int i=0; i<columnas.size(); i++)
                columnas.get(i).update();
            cronometro += TIEMPO;
            if (cronometro>=5000){
                columnas.add(new Columna());
                cronometro=0;
            }
            if(columnas.get(0).getrAbajo().x == -50){
                columnas.remove(0);
            }
            if(pajaro.intersects(columnas.get(0).getrAbajo()) || pajaro.intersects(columnas.get(0).getrArriba()) || pajaro.y > 300){
                gameOver = true;
                repaint();
                animacion.suspend();
            }
            if(pajaro.x == columnas.get(0).getrAbajo().x + 50){
                score++;
            }
            
            repaint();
            try {
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){}
        }
    }
    
    public boolean keyDown(Event ev, int tecla){
        if(tecla == 32) //espacio
            pajaro.subir();
        //si le das al esc se para el juego
        if(tecla == 27) {
            gameOver = true;
            repaint();
            animacion.suspend();
        }
        //si le das a R se reinicia el juego
        if(tecla == 114) {
            gameOver = false;
            score = 0;
            for(int i=0; i<columnas.size(); i++)
                columnas.remove(i);
            pajaro = new Pajaro();
            columnas.add(new Columna());
            cronometro = 0;
            repaint();
            animacion.resume();
        }
        return true;
    }

    public int getScore() {   return score; }
    public void setScore(int i) { score = i;  }
    public void addScore(int i) { score += i;  }
}
