/*

 */
package Ej016;

import java.awt.*;

public class Columna { //Columna de flappy fird con valor aleatorio del espacio entre los dos rectangulos
    /*public static final int ANCHURA = 40;
    public static final int ALTURA = 10;
    public static final int ESPACIO = 100;
    public static final int VELOCIDAD = 2;
    int x, y1, y2;*/
    Pajaro p;
    private Rectangle rArriba, rAbajo;
    public Columna(){
        /*x = posX;
        y1 = (int)(Math.random()*(300-ESPACIO));
        y2 = y1 + ESPACIO + ALTURA; */
        rArriba = new Rectangle(300, 0, 40, (int)(Math.random()*150)+50);
        rAbajo = new Rectangle(300, rArriba.height+50, 40, 300-(rArriba.height+50));
    }
    public void update(){
        rArriba.x -= 2;
        rAbajo.x -= 2;
        //x -= VELOCIDAD;

    }
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        //g.fillRect(x, 0, ANCHURA, y1);
        //g.fillRect(x, y2, ANCHURA, 300);
        g.fillRect(rArriba.x, rArriba.y, rArriba.width, rArriba.height);
        g.fillRect(rAbajo.x, rAbajo.y, rAbajo.width, rAbajo.height);
    }
    

    public Rectangle getrArriba() {
        return rArriba;
    }

    public void setrArriba(Rectangle rArriba) {
        this.rArriba = rArriba;
    }

    public Rectangle getrAbajo() {
        return rAbajo;
    }

    public void setrAbajo(Rectangle rAbajo) {
        this.rAbajo = rAbajo;
    }

}
