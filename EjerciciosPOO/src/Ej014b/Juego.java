package Ej014b;

import java.awt.*;
import java.applet.Applet;
import java.util.ArrayList;
import java.util.List;

//ahora en lugar de que haya solo una pelota que haya un array de pelotas

public class Juego extends Applet implements Runnable {
    Thread animacion;
    Image imagen;
    Graphics noseve;
    
    
    //Pelota pelota; -> asi era para una sola pelota
    public static final int NUM_PELOTAS = 5;
    List<Pelota> pelotas;
    //Pelota pelotas[] = new Pelota[NUM_PELOTAS];
    
    
    public void init(){
        this.setSize(400,400);
        
        imagen = this.createImage(400,400);
        noseve = imagen.getGraphics();
        
        
        //pelota = new Pelota((int)(Math.random() * 40) + 10); -> solo con 1 pelota
        pelotas = new ArrayList<Pelota>();
        
        for (int i=0; i<NUM_PELOTAS; i++){
            pelotas.add(new Pelota((int)(Math.random() * 40) + 10));
        }
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start(); // llama al metodo run
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0,0,400,400);
        
        
        //pelota.paint(noseve); -> solo con 1 pelota
        
        for (int i=0; i<pelotas.size(); i++){ //i < pelotas.size
            pelotas.get(i).paint(noseve);
        }
        g.drawImage(imagen,0,0, this);
    }
    public void update(Graphics g){
        paint(g);
    }
    
    public void run(){
        while(true){
            //pelota.update();
            for (int i=0; i < pelotas.size(); i++){
                pelotas.get(i).update();
            }
            repaint();
            try {
                Thread.sleep(10);
            }catch(InterruptedException e){}
        }
    }
    
    //funcion con la que al darle click a una pelota la elimina
    public boolean mouseDown(Event ev, int x, int y){
        for (int i=0; i < pelotas.size(); i++){
                if(pelotas.get(i).contains(x,y))
                    pelotas.remove(i);
        }
        return true;
    }
}
