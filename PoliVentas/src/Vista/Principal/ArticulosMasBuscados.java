/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Principal;

import Modelo.Producto;
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Karen
 */
public class ArticulosMasBuscados {

    private LinkedList<Producto> productos;
    private final GridPane root;

    public ArticulosMasBuscados() {
        productos=new LinkedList();
        root = new GridPane();
        BackgroundFill myBF = new BackgroundFill(Color.ALICEBLUE, new CornerRadii(1), new Insets(0.0, 0.0, 0.0, 0.0));
        root.setBackground(new Background(myBF));
        /*Button b = new Button("Articulos mas buscados");
        b.setAlignment(Pos.CENTER);
        b.setPrefSize(250, 50);
        b.setStyle("-fx-font: 15 Verdana; -fx-base: #0B93FE; -fx-text-fill: white;");
        root.getChildren().add(b);
        b.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new PaneLogin().getRoot());
        });
        root.setAlignment(Pos.CENTER);
        b.setDefaultButton(true);*/
        productos.add(new Producto("01", "Audifonos", "Audifonos para celulares", "Tecnologica",10.00, 3));
        productos.add(new Producto("02", "Cargadores", "Cargadores para celulares", "Tecnologica",15.00,4));
        productos.add(new Producto("03", "Tortas", "Tortas de vainilla", "Comida",3.00, 4));
        productos.add(new Producto("04", "Copa Mexicana", "Copa mexicana con guacamole", "Comida",2.50, 4));
        productos.add(new Producto("05", "Micas", "Micas para celulares", "Articulos varios",13.00, 3));
        productos.add(new Producto("06", "Case", "Case para celulares", "Articulos varios",13.00, 2));
        ProductosMasBuscados();
    }

    private void ProductosMasBuscados() {
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(30, 10, 10, 10));
        root.setGridLinesVisible(false);

        root.add(new Label("ARTICULOS MAS BUSCADOS"), 0, 0, 4, 1);
        int i = 1;

        for (Producto p : productos) {
            agregarFilaGrid(p, i);
            i++;
        }
    }

    private void agregarFilaGrid(Producto p, int i) {

        Label l1 = new Label(p.getNombre());
        Label l2 = new Label(p.getDescripcion());
        Label l3 = new Label(p.getCategoria());
        Button b = new Button("Ver");

        root.addRow(i, l1, l2, l3, b);
        i++;
        b.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new PaneLogin().getRoot());
        });

    }

    public GridPane getRoot() {
        return root;
    }
}
