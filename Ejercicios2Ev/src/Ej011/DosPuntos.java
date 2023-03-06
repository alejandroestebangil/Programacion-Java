package Ej011;

import java.awt.Graphics;

public class DosPuntos {
    public static final int LINEA = 0;
    public static final int OVALO = 1;
    public static final int RECTANGULO = 2;
    private int posX, posY, posFX, posFY;
    private int tipo;

    public DosPuntos(int px1,int py1,int px2,int py2,int tipo ){
        posX = px1;
        posY = py1;
        posFX = px2;
        posFY = py2;
        this.tipo = tipo;
    }

    public DosPuntos(int px1,int py1,int tipo ){
//      this(px1, py1, px1, py1, tipo);
        posX = px1;
        posY = py1;
        posFX = px1;
        posFY = py1;
        this.tipo = tipo;
    }

    public void dibujar(Graphics g){
        switch (tipo) {
            case LINEA:
                g.drawLine(posX, posY, posFX, posFY);
                break;
            case OVALO:
                g.drawOval(posX, posY, Math.abs(posFX - posX), Math.abs(posFY - posY) );
                break;
            case RECTANGULO:
                g.drawRect(posX, posY,  Math.abs(posFX - posX),  Math.abs(posFY - posY));
                break;
            default:
                System.out.println("Syntax Error:");
        }
    }


    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void setPosFX(int posFX) {
        this.posFX = posFX;
    }
    public void setPosFY(int posFY) {
        this.posFY = posFY;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public static int getLINEA() {
        return LINEA;
    }
    public static int getOVALO() {
        return OVALO;
    }
    public static int getRECTANGULO() {
        return RECTANGULO;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public int getPosFX() {
        return posFX;
    }
    public int getPosFY() {
        return posFY;
    }
    public int getTipo() {
        return tipo;
    }
}
