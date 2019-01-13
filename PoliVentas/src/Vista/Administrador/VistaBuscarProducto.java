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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author Tiffy
 */
public class VistaBuscarProducto {

    private final BorderPane root;
    private Button back, buscar;
    private String color;
    private TextField campo;

    public VistaBuscarProducto(String color) {
        root = new BorderPane();
        this.color = color;
        inicializarObjetos();
        crearSeccionTitulo();
        setCompradorListener();
        seccionResultadoBusqueda();

    }

    public BorderPane getRoot() {
        return root;
    }

    private void inicializarObjetos() {
        back = new Button();
        estiloBotones(back, "FFFFFF", "/back.png");
        root.setBottom(back);
        buscar = new Button();
        estiloBotones(buscar, "9FF781", "/search.png");
        campo = new TextField();
        campo.setPrefWidth(300);
        campo.setPrefHeight(40);
    }

    private void estiloBotones(Button btn, String base, String path) {
        btn.setStyle("-fx-background-radius: 15em; -fx-min-width: 50px; -fx-min-height: 50px;"
                + " -fx-max-width: 50px; -fx-max-height: 50px; -fx-base: #" + base + ";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG + path));
        btn.setGraphic(new ImageView(image));
        btn.setAlignment(Pos.CENTER);
    }

    private void setCompradorListener() {
        back.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new AdministradorOptions().getRoot());
        });
    }

    private void crearSeccionTitulo() {
        Label comprador = new Label("Buscar Productos");
        comprador.setPrefSize(720, 80);
        comprador.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #" + this.color + "; ");
        comprador.setAlignment(Pos.CENTER);
        root.setTop(comprador);
    }

    private VBox crearSeccionBusqueda() {
        Label name = new Label("Ingrese Producto");
        VBox contenedorIngresoBusquedas = new VBox();
        GridPane gp = new GridPane();
        name.setFont(new Font("Verdana", 15));
        gp.addColumn(0, name);
        gp.addColumn(1, campo);
        gp.addColumn(2, buscar);
        gp.setHgap(15);
        gp.setVgap(10);
        gp.setAlignment(Pos.CENTER);
        contenedorIngresoBusquedas.setPadding(new Insets(10, 0, 10, 0));
        contenedorIngresoBusquedas.setAlignment(Pos.CENTER);
        contenedorIngresoBusquedas.getChildren().add(gp);
        return contenedorIngresoBusquedas;
    }
    
    private void seccionResultadoBusqueda() {
        VBox contenedorTitulos = new VBox();
        contenedorTitulos.setPadding(new Insets(0, 7, 0, 7));//top,derecha,abajo,izquierda
        contenedorTitulos.setAlignment(Pos.TOP_CENTER);
        contenedorTitulos.setSpacing(7);
        contenedorTitulos.getChildren().addAll(crearSeccionBusqueda());
        root.setCenter(contenedorTitulos);
    }
}
