/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Vendedor;

import Auxiliares.CONSTANTES;
import static Auxiliares.PatronVistaTitulos.crearTituloSubMenu;
import Vista.Principal.PaneLogin;
import Vista.Principal.Vista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
 * @author Tiffy, Galo Xavier Figueroa Villacreses
 */
public class VistaInfoProducto implements Vista {

    private final BorderPane root;
    private final String color, titulo;
    private Button guardar, back;
    private TextField id, nombre, categoria, precio, cantidad;
    private TextArea descripcion;
    
    public VistaInfoProducto() {
        root = new BorderPane();
        this.color = "f0f0f0";
        this.titulo = "Agregue su producto nuevo";
        crearSeccionTitulo();
        inicializarObjetos();
        construccion();
    }

    public VistaInfoProducto(String color, String titulo) {
        root = new BorderPane();
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
        id = new TextField();
        nombre = new TextField();
        nombre.setPrefWidth(100);
        categoria = new TextField();
        precio = new TextField();
        cantidad = new TextField();
        descripcion = new TextArea();
        descripcion.setPrefHeight(100);
        gestionBotones();
    }

    private VBox gestionBotones() {
        VBox sa = new VBox();
        sa.setAlignment(Pos.CENTER_RIGHT);
        guardar = new Button("Guardar");
        guardar.setPrefSize(100, 50);
        sa.getChildren().add(guardar);
        return sa;
    }
    
    public void addCreateButtonHandler(EventHandler createButtonHandler){
        guardar.setOnAction(createButtonHandler);
    }
    
    public void addUpdateButtonHandler(EventHandler updateButtonHandler){
        guardar.setOnAction(updateButtonHandler);
    }
    
    public void addBackButtonHandler(EventHandler backButtonHandler){
        back.setOnAction(backButtonHandler);
    }

    private void construccion() {
        HBox hb = new HBox();
        VBox contenedor=new VBox();
        contenedor.setAlignment(Pos.TOP_RIGHT);
        contenedor.setSpacing(10);
        hb.setSpacing(15);
        contenedor.getChildren().addAll(seccionAvatar(),gestionBotones());
        hb.getChildren().addAll(formulario(),contenedor);
        root.setCenter(hb);
    }

    private VBox formulario() {
        VBox scawflone = new VBox();
        GridPane grandPrix = new GridPane();
        Label idl = new Label("ID");
        Label nom = new Label("Nombre");
        Label des = new Label("Descripción");
        Label pre = new Label("Precio");
        Label cant = new Label("Cantidad");
        Label cat = new Label("Categoría");
        grandPrix.addColumn(0, idl, nom, des, pre, cant, cat);
        grandPrix.addColumn(1, id, nombre, descripcion, precio, cantidad, categoria);
        grandPrix.setHgap(15);
        grandPrix.setVgap(15);
        scawflone.setPadding(new Insets(30, 10, 0, 20));//top,derecha,abajo,izquierda
        scawflone.setAlignment(Pos.TOP_CENTER);
        scawflone.getChildren().add(grandPrix);
        return scawflone;
    }

    private void crearSeccionTitulo() {
        root.setTop(crearTituloSubMenu(titulo, color));
    }

    @Override
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
    
     
     private VBox seccionAvatar() {
        VBox k = new VBox();
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG+"/cesta.png"));
        Label myLabel = new Label();
        myLabel.setGraphic(new ImageView(image));
        k.setPadding(new Insets(30, 0, 0, 5));
        k.getChildren().add(myLabel);
        return k;
    }
     
    public TextField getID() {
        return id;
    }

    public TextField getNombre() {
        return nombre;
    }

    public TextField getCategoria() {
        return categoria;
    }

    public TextField getPrecio() {
        return precio;
    }

    public TextField getCantidad() {
        return cantidad;
    }

    public TextArea getDescripcion() {
        return descripcion;
    }
     
    
}
