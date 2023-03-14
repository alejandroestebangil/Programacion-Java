package Ej100;

import javax.imageio.ImageIO;
import java.applet.Applet;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Caminar extends Applet implements Runnable {
    public static final int FILAS = 3;
    public static final int COLUMNAS = 4;
    Thread animacion;
    Image imagen;
    Image fotogramas[][];
    Image actual;
    Graphics noseve;
    String elementos[] = {"Guerrillero/g", "Hampon/h", "Vaquero/v", "Ken/ken"};
    Personaje persona;
    int numPersonaje = 0;

    public void init(){
        this.setSize(400,400);
        Frame title = (Frame) this.getParent().getParent();
        title.setTitle("Caminando con Sprites"); //cambiamos el nombre de la ventana
        title.setMenuBar(null); //elimina la barra de menu de applet

        imagen = this.createImage(400,400);
        noseve = imagen.getGraphics();
        fotogramas = new Image[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                fotogramas[i][j] = getImage(getCodeBase(),"Ej100/Sprites/" + elementos[i] + (j + 1) + ".gif");
            }
        }
        persona = new Personaje(fotogramas[numPersonaje]);
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0,0,400,400);

        persona.paint(noseve, this);
        g.drawImage(imagen, 0, 0, this);

    }
    public void update(Graphics g){
        paint(g);
    }
    public void run() {
        while (true) {
            persona.update();
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }
    public boolean keyDown(Event e, int key){
        switch (key){
            case 103:
            case 71:
                persona.setImagenes(fotogramas[0]);
                break;
            case 104:
            case 72:
                persona.setImagenes(fotogramas[1]);
                break;
            case 118:
            case 86:
                persona.setImagenes(fotogramas[2]);
        }
        return true;
    }


}
