package Ej011;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Event;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.PopupMenu;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DibujarApp extends Frame{
    public int tipo;
    DosPuntos actual;
    List<DosPuntos> lista;
    public static void main(String[] args) {
        DibujarApp app = new DibujarApp();
    }

    public DibujarApp(){
        super("Dibujando objetos");

        setup();

        tipo = DosPuntos.LINEA;
        lista = new ArrayList<DosPuntos>();

        this.pack();
        this.setSize(700, 700);
        this.setVisible(true);
    }


    public void setup(){
        MenuBar menub = new MenuBar();
        Menu menu1 = new Menu("Fichero");
        menu1.add(new MenuItem("Nuevo"));
        menu1.addSeparator();
        menu1.add(new MenuItem("Salir"));
        menub.add(menu1);
        Menu menu2 = new Menu("Dibujar");
        menu2.add(new MenuItem("Linea"));
        menu2.add(new MenuItem("Ovalo"));
        menu2.add(new MenuItem("Rectangulo"));
        menub.add(menu2);
        this.setMenuBar(menub);
    }

    public void paint (Graphics g){
        for (DosPuntos item : lista){
            item.dibujar(g);
        }
        if (actual != null) {
            actual.dibujar(g);
        }
    }




//    public boolean handleEvent (Event ev){
//        if(ev.id == Event.WINDOW_DESTROY){
//            System.exit(0);
//            return true;
//        }
//        if(ev.id == Event.WINDOW_DESTROY){
//            System.exit(0);
//            return true;
//        }else if(ev.id == Event.ACTION_EVENT){
//                if(ev.target instanceof MenuItem){
//                    if (ev.arg.equals("Salir")){
//                        System.exit(0);
//                        return true;
//                    }else if (ev.arg.equals("Nuevo")){
//                        repaint();
//                        return true;
//                    }else if (ev.arg.equals("Linea")){
//                        tipo = DosPuntos.LINEA;
//                        return true;
//                    }else if (ev.arg.equals("Ovalo")){
//                        tipo = DosPuntos.OVALO;
//                        return true;
//                    }else if (ev.arg.equals("RECTANGULO")){
//                        tipo = DosPuntos.RECTANGULO;
//                        return true;
//                    }
//                }
//        }
////        else if (ev.id == Event.MOUSE_MOVE) {
////            if (this.mouseDown(new Event(ev.target, Event.MOUSE_DOWN, ev.arg),this.getX(), this.getY()) ) {
////
////            }
////        }
//        return false;
//    }

    public boolean mouseDown(Event ev,int x, int y){
        actual = new DosPuntos(x, y, tipo);
        repaint();
        return true;
    }

    public boolean mouseDrag(Event ev,int x, int y){
        actual.setPosFX(x);
        actual.setPosFY(y);
        repaint();
        return true;
    }

    public boolean mouseUp(Event ev,int x, int y){
        lista.add(actual);
        actual = null;
        repaint();
        return true;
    }


    public boolean action (Event ev, Object obj){
        if(ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }else if(ev.id == Event.ACTION_EVENT){
            if(ev.target instanceof MenuItem){
                if (ev.arg.equals("Salir")){
                    System.exit(0);
                    return true;
                }else if (ev.arg.equals("Nuevo")){
                    repaint();
                    return true;
                }else if (ev.arg.equals("Linea")){
                    tipo = DosPuntos.LINEA;
                    return true;
                }else if (ev.arg.equals("Ovalo")){
                    tipo = DosPuntos.OVALO;
                    return true;
                }else if (ev.arg.equals("RECTANGULO")){
                    tipo = DosPuntos.RECTANGULO;
                    return true;
                }
            }
        }
        return false;
    }
}