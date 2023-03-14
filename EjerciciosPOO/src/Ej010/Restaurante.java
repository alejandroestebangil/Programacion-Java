package Ej010;

import java.awt.*;

public class Restaurante extends Frame {
    String comidas[] = {"Desayuno", "Almuerzo", "Cena"};
    String[][] platos =
            {{"Café", "Huevos", "Leche", "Cereales", "Bacon", "Mantequilla", "Mermelada"},
            {"Sopa", "Paella", "Macarrones", "Ensalada", "Pescado", "Filete", "Albondigas"},
            {"Sopa", "Tortilla", "Hamburguesa", "Ensalada", "Pescado", "Pollo", "Bocadillo"}};
    List presentar;
    List listaPlatos[];
    Choice horario;
    TextField texto;
    public static void main(String[] args) {
        Restaurante app = new Restaurante();
    }

    public Restaurante() {
        super("Objetos comunes");
        setup();

        this.pack();
        this.setSize(400, 200);
        this.setVisible(true);
    }

    public void setup() {
        this.add("North", new Label("Elige tu comanda", Label.CENTER));
        horario = new Choice();
        for (int i = 0; i < comidas.length; i++) {
            horario.addItem(comidas[i]);
        }
        this.add("West", horario);
        listaPlatos = new List[platos.length];
        for (int i = 0; i < platos.length; i++) {
            listaPlatos[i] = new List(5, true);
            for (int j = 0; j < platos[i].length; j++) {
                listaPlatos[i].addItem(platos[i][j]);
            }
        }
        presentar = listaPlatos[0];
        this.add("East", presentar);

        texto = new TextField("", 35);
        this.add("South", texto);

    }


    public boolean handleEvent(Event evt) {
        if (evt.id == Event.WINDOW_DESTROY) {
            //Para que el programa se cierre al pulsar la X
            System.exit(0);
            return true;
        } else if (evt.id == Event.ACTION_EVENT) {
            //Para que al elegir una de las 3 comidas del dia se muestren los platos correspondientes
            if (evt.target instanceof Choice) {
                this.remove(presentar);
                presentar = listaPlatos[horario.getSelectedIndex()];
                this.add("East", presentar);
                texto.setText(horario.getSelectedItem() + ": ");
                this.show();
                return true;
            }
        } else if ((evt.id == Event.LIST_SELECT) || (evt.id == Event.LIST_DESELECT)) {
            //Para que al seleccionar un plato se muestre en el TextField
            String frase = "";
            texto.setText(horario.getSelectedItem() + ": ");
            String[] seleccionados = presentar.getSelectedItems();
            for (int i = 0; i < seleccionados.length; i++) {
                frase += seleccionados[i] + ", ";
            }
            texto.setText(texto.getText() + frase);
            return true;
        }
        return false;
    }
}
