package Ej009;

import java.awt.*;

public class Objetos extends Frame {
    TextArea textArea;
    public static void main(String[] args) {
        Objetos app = new Objetos(); //instancio el objeto app
    }
    public Objetos() {
        super("Objetos comunes"); //Texto del marco de la ventana
        setup();

        this.pack(); //ajusta el tamaño de la ventana al tamaño de los componentes
        this.resize(400, 400);
        this.setVisible(true);
    }

    public void setup(){
        Panel principal = new Panel(); //instancio el panel principal
        principal.setLayout(new GridLayout(3,3));
        //le digo que el layout del panel principal es GridLayout
        Panel paneles[][] = new Panel[3][3]; //instancio el array de paneles

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                paneles[i][j] = new Panel();
            }
        } //este bucle crea los 9 paneles y los añade al panel principal

        paneles[0][0].add(new Label("Campo de texto"));
        paneles[0][0].add(new MiTextField("", 15));

        principal.add(paneles[0][0]);
        textArea = new TextArea(5, 10);
        textArea.setBackground(Color.lightGray);
        paneles[0][1].add(textArea);
        principal.add(paneles[0][1]);

        paneles[0][2].add(new MiButton("Limpiar", textArea));
        principal.add(paneles[0][2]);

        /* Choice eleccion = new Choice();
        eleccion.add("Uno");
        eleccion.add("Dos"); */

        //el string opciones hay que pasarlo a la funcion mi choice para que lo lea y lo añada como opciones
        String opciones[] = {"Si", "No", "Quizas"};
        paneles[1][0].add(new MiChoice(opciones, textArea));
        principal.add(paneles[1][0]);

        String deportes[] = {"Futbol", "Baloncesto", "Tenis", "Natacion", "Automovilismo", "Atletismo", "Ciclismo"};
        paneles[1][1].add(new MiList(deportes, textArea));
        principal.add(paneles[1][1]);

        paneles[1][2].add(new MiCanvas());
        principal.add(paneles[1][2]);

        String alimentos[] = {"Carne", "Pescado", "Fruta", "Verdura", "Leche"};
        paneles[2][0].add(new MiCheckboxGroup(alimentos));
        principal.add(paneles[2][0]);

        this.add("Center", principal);
    }

    //Para que el programa se cierre al pulsar la X
    public boolean handleEvent(Event evt) {
        if (evt.id == Event.WINDOW_DESTROY) {
            System.exit(0);
            return true;
        }
        return false;
    }

    //Cuadro en el que se puede escribir texto y si le das al enter se pone en mayus
    class MiTextField extends TextField{
        public MiTextField(String valor, int tamano){
            super(valor, tamano);
        }
        public boolean action(Event evt, Object arg){
            this.setText(this.getText().toUpperCase());
            return false;
        }
    }

    //Boton que limpia el textArea
    class MiButton extends Button{
        TextArea textArea; //para poder acceder al text area desde el boton
        public MiButton(String texto, TextArea tA){
            super(texto);
            textArea = tA; //asigno el text area al boton
        }
        public boolean action(Event evt, Object arg){
            textArea.setText(" "); //limpio el text area
            return false; //
        }
    }

    //Desplegable con opciones que se pueden seleccionar y se muestran en el text area
    class MiChoice extends Choice {
        TextArea textArea;
        public MiChoice(String opciones[], TextArea tA) {
            super();
            for (int i = 0; i < opciones.length; i++) {
                this.add(opciones[i]);
            }
            this.textArea = tA;
        }

        public boolean action(Event evt, Object arg) {
            textArea.setText(this.getSelectedItem());
            return true;
        }
    }

    //Lista con opciones que se pueden seleccionar varias a la vez y se muestran en el text area
    class MiList extends List {
        TextArea textArea;
        public MiList(String deportes[], TextArea tA) {
            super(5, true);
            //5 es el num de elementos mostrados a la vez y true es para seleccionar varias opciones
            for (int i = 0; i < deportes.length; i++) {
                this.add(deportes[i]);
            }
            this.textArea = tA;
        }
        public boolean handleEvent(Event evt) {
        //aqui se hace que pueds seleccionar varios elementos de la lista y no uno en uno como en MiChoice
            if ((evt.id == Event.LIST_SELECT) || (evt.id == Event.LIST_DESELECT)) {
                String select[] = this.getSelectedItems();
                String seleccionados = "";
                //Con este bucle se meten en el string los elementos seleccionados
                for (int i = 0; i < select.length; i++) {
                    seleccionados += select[i] + "\n";
                }
                //se muestra en el text area el string seleccionados
                textArea.setText(seleccionados);
                return true;
            }
            return false;
        }
    }

    class MiCanvas extends Canvas{
        int posX = 25;
        int posY = 25;
        public MiCanvas(){ //constructor
            super();
            this.setSize(75, 75);
            this.setBackground(Color.LIGHT_GRAY);
            this.setForeground(Color.BLACK);
            this.setVisible(true);
        }
        public void paint(Graphics g){
            g.fillRect(posX, posY,5,5);
        }
        public boolean mouseDown(Event evt, int x, int y){
            //no es lo mismo que hacer click que mouseDown ya que mouse down tiene contrario = mouseUp
            posX = x;
            posY = y;
            this.repaint();
            return true;
        }
    }
    //meter el seleccionado al textfield
    class MiCheckboxGroup extends Panel{
        public TextField resultado;
        Checkbox checkboxes[];
        public MiCheckboxGroup(String alimentos[]) {
            super();
            checkboxes = new Checkbox[alimentos.length];
            this.setLayout(new GridLayout(alimentos.length+1, 1));
            for (int i = 0; i < alimentos.length; i++) {
                checkboxes[i] = new Checkbox(alimentos[i]);
                this.add(checkboxes[i]);
            }
            resultado = new TextField(15);
            this.add(resultado);
        }
        public boolean handleEvent(Event evt) {
            if (evt.id == Event.ACTION_EVENT) {
                if(evt.target instanceof Checkbox){
                    String seleccionados = "";
                    for (int i = 0; i < checkboxes.length; i++) {
                        if(checkboxes[i].getState()){
                            seleccionados += checkboxes[i].getLabel() + "\n";
                        }
                    }
                    resultado.setText(seleccionados);
                    return true;
                }
            }
            return false;
        }
    }

}
