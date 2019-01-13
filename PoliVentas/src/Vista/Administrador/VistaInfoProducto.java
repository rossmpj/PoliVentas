/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Administrador;

import Auxiliares.CONSTANTES;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Tiffy
 */
public class VistaInfoProducto {

    private final BorderPane root;
    private boolean ingreso;
    private String color, titulo;
    private Button guardar, actualizar, eliminar, back;
    private TextField nombre, categoria, precio, cantidad, vendedor;
    private TextArea descripcion;

    public VistaInfoProducto(boolean ingreso, String color, String titulo) {
        root = new BorderPane();
        this.ingreso = ingreso;
        this.color = color;
        this.titulo = titulo;
        crearSeccionTitulo();
        inicializarObjetos();
        construccion();
    }

    private void inicializarObjetos() {
        back = new Button();
        estiloBotones(back, "FFFFFF", "/back.png");
        root.setBottom(back);
        nombre = new TextField();
        nombre.setPrefWidth(100);
        categoria = new TextField();
        precio = new TextField();
        cantidad = new TextField();
        vendedor = new TextField();
        descripcion = new TextArea();
        descripcion.setPrefHeight(100);
        gestionBotones();
        gestionSalida();
    }

    private VBox gestionBotones() {
        VBox sa = new VBox();
        sa.setAlignment(Pos.CENTER_RIGHT);
        if (this.ingreso) {
            guardar = new Button("Guardar");
            sa.getChildren().add(guardar);
        } else {
            actualizar = new Button("Actualizar");
            eliminar = new Button("Eliminar");
            sa.getChildren().addAll(actualizar, eliminar);
        }
        return sa;
    }

    private void gestionSalida() {
        if (ingreso) {
            back.setOnAction((ActionEvent e) -> {
                root.getScene().setRoot(new AdministradorOptions().getRoot());
            });
        } else {
            back.setOnAction((ActionEvent e) -> {
                root.getScene().setRoot(new VistaBuscarProducto("9FF781").getRoot());
            });
        }
    }

    private void construccion() {
        HBox hb = new HBox();
        hb.getChildren().addAll(formulario(), gestionBotones());
        root.setCenter(hb);

    }

    private VBox formulario() {
        VBox scawflone = new VBox();
        GridPane grandPrix = new GridPane();
        Label nom = new Label("Nombre");
        Label des = new Label("Descripción");
        Label pre = new Label("Precio");
        Label cant = new Label("Cantidad");
        Label cat = new Label("Categoría");
        Label idv = new Label("Id Vendedor");
        grandPrix.addColumn(0, nom, des, pre, cant, cat, idv);
        grandPrix.addColumn(1, nombre, descripcion, precio, cantidad, categoria, vendedor);
        grandPrix.setHgap(15);
        grandPrix.setVgap(3);
        scawflone.setPadding(new Insets(0, 10, 0, 20));//top,derecha,abajo,izquierda
        scawflone.setAlignment(Pos.TOP_CENTER);
        scawflone.getChildren().add(grandPrix);
        return scawflone;
    }

    private void crearSeccionTitulo() {
        Label comprador = new Label(this.titulo);
        comprador.setPrefSize(720, 80);
        comprador.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #" + this.color + "; ");
        comprador.setAlignment(Pos.CENTER);
        root.setTop(comprador);
    }

    public BorderPane getRoot() {
        return root;
    }

    private void estiloBotones(Button btn, String base, String path) {
        btn.setStyle("-fx-background-radius: 15em; -fx-min-width: 50px; -fx-min-height: 50px;"
                + " -fx-max-width: 50px; -fx-max-height: 50px; -fx-base: #" + base + ";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG + path));
        btn.setGraphic(new ImageView(image));
        btn.setAlignment(Pos.CENTER);
    }
}
