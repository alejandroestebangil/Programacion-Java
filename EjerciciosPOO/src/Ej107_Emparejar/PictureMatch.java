//JUEGO DE EMPAREJAR A LOS PERSONAJES DE SOUTHPARK EN UN TABLERO DE 4X4
package Ej107_Emparejar;

import java.applet.Applet;
import java.awt.*;

public class PictureMatch extends Applet implements Runnable{
    private int delay = 200;
    private Thread animacion;
    private Image imagen;
    private Image reverso;
    private Graphics noseve;
    public final static int SIZEX = 510;
    public final static int SIZEY = 510;
    public static final int ROWS = 4;
    public static final int COLUMNS = 4;
    private Image imagenes[];
    private Casilla[][] casillas;
    private Casilla activa1;
    private Casilla activa2;
    private int contador;
    private int visibles;

    public void init(){
        createWindow();

        //CARGAR IMAGENES
        reverso = getImage(getCodeBase(), "Ej107_Emparejar/imgParejas/reverso.png");
        imagenes = new Image[ROWS * COLUMNS / 2];
        for (int i = 0; i < imagenes.length; i++) {
            imagenes[i] = getImage(getCodeBase(), "Ej107_Emparejar/imgParejas/" + i + ".png");
        }

        //CREAR CASILLAS
        casillas = new Casilla[ROWS][COLUMNS];
        for(int i = 0; i < ROWS; i++)
            for(int j = 0; j < COLUMNS; j++)
                casillas[i][j] = new Casilla(j*Casilla.SIZE, i*Casilla.SIZE, imagenes[(i*ROWS + j)/2], reverso);

        imagen = this.createImage(SIZEX, SIZEY); //creamos la imagen
        noseve = imagen.getGraphics(); //creamos el lienzo

        desordenarImagenes();
    }

    private void createWindow() {
        Frame title = (Frame) this.getParent().getParent(); //obtenemos la ventana para
        title.setTitle("Picture Match"); //cambiamos el nombre de la ventana
        this.setSize(SIZEX, SIZEY); //tamaño de la ventana
        title.setMenuBar(null); //elimina la barra de menu de applet
        this.setFocusable(true); //para poder usar el teclado directamente
        this.requestFocus();
    }

    private void desordenarImagenes() {
        int posX, posY;
        Image aux;
        Casilla auxCasilla;
        for(int i = 0; i < ROWS; i++)
            for(int j = 0; j < COLUMNS; j++){
                posX = (int) (Math.random() * ROWS);
                posY = (int) (Math.random() * COLUMNS);
                aux = casillas[i][j].getImagen();
                casillas[i][j].setImagen(casillas[posX][posY].getImagen());
                casillas[posX][posY].setImagen(aux);
                auxCasilla = casillas[i][j];
                casillas[i][j] = casillas[posX][posY];
                casillas[posX][posY] = auxCasilla;
            }
    }

    public void start(){
        if(animacion == null){
            animacion = new Thread(this);
            animacion.start();
        }
    }

    public void paint(Graphics g){
        //CREAR FONDO
        noseve.setColor(Color.lightGray);
        noseve.fillRect(0, 0, SIZEX, SIZEY);

        //CREAR TABLERO
        visibles = 0;
        for(int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                casillas[i][j].paint(noseve, this);
                if (casillas[i][j].isVisible())
                    visibles++;
            }
        }

        ifWin();

        g.drawImage(imagen, 0, 0, this);
    }

    private void ifWin() {
        if(visibles == (ROWS * COLUMNS)){
            noseve.setColor(Color.WHITE);
            noseve.fillRect(0, 0, SIZEX, SIZEY);
            noseve.setColor(Color.BLACK);
            noseve.setFont(new Font("Arial", Font.BOLD, 56));
            noseve.drawString("HAS ACABADO!", SIZEX/2-220, SIZEY/2);
        }
    }

    public void update(Graphics g){ //override, lo sobreescribimos eliminando la linea de borrar
        paint(g);
    }

    public void run(){
        while(true){
            contador++;
            if(contador == 1000/delay){
                repaint();
            }

            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex){
                System.out.println("Error en el hilo");
            }
        }
    }

    public boolean mouseDown(Event ev, int x, int y){
        if(contador < (1000/delay))
            return false;
        for(int i = 0; i < ROWS; i++)
            for(int j = 0; j < COLUMNS; j++)
                if(casillas[i][j].contains(x,y) && activa1 == null && !casillas[i][j].isVisible()){
                    casillas[i][j].setVisible(Boolean.TRUE);
                    activa1 = casillas[i][j];
                    repaint();
                }else if(casillas[i][j].contains(x,y) && activa2 == null && !casillas[i][j].isVisible()){
                    casillas[i][j].setVisible(Boolean.TRUE);
                    activa2 = casillas[i][j];
                    repaint();
                }
        return false;
    }

    public boolean mouseUp(Event ev, int x, int y){
        if(activa1 == null || activa2 == null)
            return false;
        if(activa1.getImagen() != activa2.getImagen()){
            activa1.setVisible(Boolean.FALSE);
            activa2.setVisible(Boolean.FALSE);
            contador = 0;
        }
        activa1 = null;
        activa2 = null;

        return true;
    }
}
