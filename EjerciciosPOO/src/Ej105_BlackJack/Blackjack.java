//BLACKJACK
package Ej105_BlackJack;

import java.applet.Applet;
import java.awt.*;

public class Blackjack extends Applet implements Runnable{
    private Image imagen;
    private Image imagenes[];
    private Graphics noseve;
    public final static int SIZEX = 800;
    public final static int SIZEY = 600;
    public final static int NUMCARTAS = 52;
    public final static int PALOS = 4;
    public final static int CCP = 13;
    private String nombresPalos[]= {"_of_clubs", "_of_diamonds", "_of_hearts", "_of_spades"};
    private Baraja baraja;
    private Carta carta;
    private ManoCartas jugador, croupier;
    public static final int jugadorY = 400;
    public static final int croupierY = 100;
    private TextField apuesta;
    private int saldo;
    private int acumuladorUltimaJugada;
    private boolean gameEnd = false;
    private boolean playerWin = false;
    private boolean draw = false;

    public void init() {
        createWindow();
        createPanels();

        imagenes = new Image[NUMCARTAS];

        croupier = new ManoCartas();
        jugador = new ManoCartas();


        createCards();
    }

    private void createWindow() {
        Frame title = (Frame) this.getParent().getParent(); //obtenemos la ventana para
        title.setTitle("Blackjack"); //cambiamos el nombre de la ventana
        this.setSize(SIZEX, SIZEY); //tamaño de la ventana
        title.setMenuBar(null); //elimina la barra de menu de applet
        imagen = this.createImage(SIZEX, SIZEY); //creamos la imagen
        noseve = imagen.getGraphics(); //creamos el lienzo
        this.setFocusable(true); //para poder usar el teclado directamente
        this.requestFocus();
    }

    private void createPanels() throws HeadlessException {
        this.setLayout(new BorderLayout());
        Panel panel1 = new Panel();
        Button boton1 = new Button("Hit me!");
        Button boton2 = new Button("Stand");
        panel1.add(boton1);
        panel1.add(boton2);
        this.add("South",panel1);
        panel1.setBackground(new Color(76,106,90));

        Panel panel2 = new Panel();
        Label etiqueta1 = new Label("Introduce tu apuesta:", Label.RIGHT);
        apuesta = new TextField("",10);
        Label etiqueta2 = new Label("€", Label.LEFT);
        panel2.add(etiqueta1);
        panel2.add(apuesta);
        panel2.add(etiqueta2);
        this.add("North", panel2);
        panel2.setBackground(new Color(55,80,70));
        etiqueta2.setBackground(new Color(55,80,70));
        etiqueta1.setBackground(new Color(55,80,70));
    }

    private void createCards() {
        for (int i = 0; i < NUMCARTAS; i++) {
            imagenes[i] = getImage(getDocumentBase(), "Carta/" + ((i%CCP)+1) + nombresPalos[i/CCP] + ".png");
        }
        baraja = new Baraja(imagenes);
    }

    public void start(){}

    public void paint(Graphics g) {
        noseve.setColor(new Color(76,106,90));
        noseve.fillRect(0, 0, SIZEX, SIZEY);

        paintCartas();
        finJugada();

        g.drawImage(imagen, 0, 0, this);
    }

    private void paintCartas() {
        for(int i = 0; i < baraja.getLista().size(); i++)
            baraja.getLista().get(i).paint(100, 50, noseve, this);
        if(!croupier.lista.isEmpty()){
            croupier.paint(noseve, this, croupierY, gameEnd);
            noseve.setColor(Color.WHITE);
            if(gameEnd)
                noseve.drawString("Croupier: " + croupier.points(), SIZEX-150, 250);
        }
        if(!jugador.lista.isEmpty()){
            jugador.paint(noseve, this, croupierY, gameEnd);
            noseve.setColor(Color.WHITE);
            noseve.drawString("Jugador: " + jugador.points(), SIZEX-150, 450);
        }
    }

    private void finJugada(){
        if(gameEnd){
            noseve.setColor(Color.WHITE);
            if(playerWin)
                noseve.drawString("Has ganado", 400, 300);
            else if(draw)
                noseve.drawString("Has empatado", 400, 300);
            else
                noseve.drawString("Has perdido", 400, 300);
        }

    }

    public void update(Graphics g) { paint(g); }
    public void run() { while(true){} }

    public boolean action(Event ev, Object obj){
        if(ev.target instanceof TextField){
            baraja.barajar();
            croupier.addCarta(baraja.sacarCarta());
            croupier.addCarta(baraja.sacarCarta());
            jugador.addCarta(baraja.sacarCarta());
            jugador.addCarta(baraja.sacarCarta());
            apuesta.setEditable(false);
            repaint();
            return true;
        }
        else if(ev.target instanceof Button){
            if("Hit me!".equals(ev.arg) && !gameEnd){
                jugador.addCarta(baraja.sacarCarta());
                repaint();
                if (jugador.over21()) {
                    juegaCrouppier();
                    gameEnd = true;
                }
            } else if (ev.arg.equals("Stand")) { //"Stand".equals(ev.arg)
                juegaCrouppier();
                return true;
            }

        }
        repaint();
        return true;
    }

    private void juegaCrouppier() {
        while(!croupier.reach17()){
            croupier.addCarta(baraja.sacarCarta());
        }
        repaint();
    }
}
