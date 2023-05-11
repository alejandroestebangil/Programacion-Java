package Ej106;


import java.awt.*;
import java.applet.Applet;

public class Solitario extends Applet implements Runnable{
    public final static int SIZEX = 900;
    public final static int SIZEY = 700;
    public static final int NUMCARTAS = 52;
    public static final int NUMPALOS = 4;
    public static final int CARTASxPALO = 13;
    Image imagenes[];
    String nombresPalos[]= {"_of_clubs", "_of_diamonds", "_of_hearts", "_of_spades"};
    Image imgReverso;
    Rectangle reverso;
    Baraja baraja;
    MazoSecundario mazoSec;
    Card active;
    Image imagen;
    Graphics noseve;
    MazoPalo mazoPalos[];
    MazoJuego mazoJuegos[];
    Boolean activaIsMazoJuego = false;
    Boolean encontrado = false;
    int mazoJuego;


    public void init(){
        createWindow(); //Creamos la ventana del applet
        setupBaraja(); //Cargamos las imagenes de las cartas
        mazoSec = new MazoSecundario(); //Creamos el mazo de cartas que se van a ir sacando
        mazoPalos = new MazoPalo[NUMPALOS]; //Creamos los mazos de palos
        for (int i = 0; i < NUMPALOS; i++)
            mazoPalos[i] = new MazoPalo(400+(i*100));
        mazoJuegos = new MazoJuego[7]; //Creamos los mazos de juego
        for (int i = 0; i < 7; i++)
            mazoJuegos[i] = new MazoJuego(100+(i*100));

        imagen = this.createImage(SIZEX, SIZEY); //creamos la imagen
        noseve = imagen.getGraphics(); //creamos el lienzo
    }

    private void setupBaraja() {
        imagenes = new Image[NUMCARTAS];
        for (int i = 0; i < NUMCARTAS; i++) {
            imagenes[i] = getImage(getCodeBase(), "Ej106/Cartas/" + ((i % CARTASxPALO) + 1) + nombresPalos[i/CARTASxPALO] + ".png");
        }
        imgReverso = getImage(getCodeBase(), "Ej106/Cartas/reverso.png");
        reverso = new Rectangle(20, 20, Card.WIDTH, Card.HEIGHT);
        baraja = new Baraja(imagenes);
        baraja.barajar();
    }

    private void createWindow() {
        Frame title = (Frame) this.getParent().getParent(); //obtenemos la ventana para
        title.setTitle("Solitario"); //cambiamos el nombre de la ventana
        this.setSize(SIZEX, SIZEY); //tamaño de la ventana
        title.setMenuBar(null); //elimina la barra de menu de applet
        this.setFocusable(true); //para poder usar el teclado directamente
        this.requestFocus();
    }

    public void paint(Graphics g){
        noseve.setColor(Color.green);
        noseve.fillRect(0, 0, SIZEX, SIZEY);
        noseve.drawImage(imgReverso, 20, 20, Card.WIDTH, Card.HEIGHT, this);
        if(!mazoSec.mazoB.isEmpty())
            for(Card carta:mazoSec.mazoB)
                carta.paint(noseve, this);
        for(int i=0; i<7; i++)
            if(!mazoJuegos[i].isEmpty())
                mazoJuegos[i].mostrar(noseve, this);

        mazoSec.mostrar(noseve, this);
        //if(activa!=null) activa.dibujar(noseve, this);

        g.drawImage(imagen, 0, 0, this);
    }

    public void run(){
        while(true){
        }
    }

    public void update(Graphics g){
        paint(g);
    }

    public boolean mouseDown(Event evt, int x, int y){
        if (reverso.contains(x, y)){ //si pulsamos sobre el reverso, sacamos una carta
            mazoSec.anadir(baraja.sacar());
            repaint();
            return true;
        }
        if (!mazoSec.mazoB.isEmpty() && mazoSec.extraer().contains(x, y)){ //si pulsamos sobre la carta del mazo secundario
            active = mazoSec.extraer();
        }
        for(int i=0; i<7; i++){
            if(!mazoJuegos[i].mazo.isEmpty() && mazoJuegos[i].extraer().contains(x,y)){ //si pulsamos sobre la ultima carta de un mazo de juego
                active = mazoJuegos[i].extraer();
                activaIsMazoJuego = true;
                mazoJuego = i;
                break;
            }
        }
        return false;
    }

    public boolean mouseDrag(Event ev, int x, int y){
        if (active != null){
            return false;
        }
        active.setPosition(x-Card.WIDTH/2, y-Card.HEIGHT/2);
        repaint();
        return true;
    }

    public boolean mouseUp(Event ev, int x, int y){
        if(active==null) {
            return false;
        }
        for(int i=0; i<NUMPALOS; i++){
            if(mazoPalos[i].intersects(active)){ //si la carta activa esta sobre el mazo de palos
                if(mazoPalos[i].anadir(active)){ //si se puede añadir
                    removeCardFromMazo(); //al meterla en mazoPalo, la eliminamos del mazo secundario
                    break;
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            if (mazoJuegos[i].mazo.isEmpty()){
                if (mazoJuegos[i].intersects(active)) {
                    if (mazoJuegos[i].anadir(active)) {
                        removeCardFromMazo();
                        break;
                    } else {
                        mazoJuegos[i].recolocar(active);
                        break;
                    }
                }
            } else if(mazoJuegos[i].mazo.get(mazoJuegos[i].mazo.size()-1).intersects(active)){
                if(mazoJuegos[i].anadir(active)){
                    removeCardFromMazo();
                    break;
                } else {
                    mazoJuegos[i].recolocar(active);
                    break;
                }
            }
        }
        if(!encontrado && !mazoSec.mazoB.isEmpty()){ //si no se ha encontrado un mazo donde añadir la carta
            mazoSec.recolocar();
        }
        active = null;
        activaIsMazoJuego = false;
        repaint();
        encontrado = false;
        return true;
    }

    private void removeCardFromMazo() {
        if(activaIsMazoJuego)
            mazoJuegos[mazoJuego].eliminar(active);
        else
            mazoSec.eliminar();
        encontrado = true;
    }
}
