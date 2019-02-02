
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Administrador;

import Auxiliares.CONSTANTES;
import static Auxiliares.PatronVistaTitulos.botonRegresarMenu;
import static Auxiliares.PatronVistaTitulos.crearTituloSubMenu;
import Modelo.Usuario;
import Vista.Principal.PaneLogin;
import Vista.Principal.Vista;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/**
 *
 * @author Tiffy
 */
public class VistaBuscarUsuario implements Vista {

    private final BorderPane root;
    private Button back, buscar, ver, clean;
    private String color;
    private TextField campo;
    private ObservableList<Usuario> lusario;
    private VBox vbox;
    private ScrollPane busquedaScrollPane;

    public VistaBuscarUsuario(String color) {
        root = new BorderPane();
        this.color = color;
        inicializarObjetos();
        crearSeccionTitulo();
        seccionResultadoBusqueda();

    }

    public BorderPane getRoot() {
        return root;
    }

    private void inicializarObjetos() {
        back = botonRegresarMenu();
        root.setBottom(back);
        buscar = new Button();
        clean = new Button();
        estiloBotones(clean, "EAFF26", "/eraser.png");
        estiloBotones(buscar, "A8ECDD", "/search.png");
        campo = new TextField();
        campo.setPrefWidth(350);
        campo.setPrefHeight(40);
        campo.setPromptText("Ingrese cédula de Identidad o nombres completos...");
        vbox = new VBox();
    }

    private void estiloBotones(Button btn, String base, String path) {
        btn.setStyle("-fx-background-radius: 15em; -fx-min-width: 50px; -fx-min-height: 50px;"
                + " -fx-max-width: 50px; -fx-max-height: 50px; -fx-base: #" + base + ";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG + path));
        btn.setGraphic(new ImageView(image));
        btn.setAlignment(Pos.CENTER);
    }

    public void addBackButtonHandler(EventHandler agregarProductoButtonHandler) {
        back.setOnAction(agregarProductoButtonHandler);
    }

    public void addBuscarButtonHandler(EventHandler BuscarUButtonHandler) {
        buscar.setOnAction(BuscarUButtonHandler);
    }

    public void addVerButtonHandler(EventHandler nuevaVentanaButtonHandler) {
        ver.setOnAction(nuevaVentanaButtonHandler);
    }

    public void addCleanButtonHandler(EventHandler cleanUButtonHandler) {
        this.clean.setOnAction(cleanUButtonHandler);
    }

    private void crearSeccionTitulo() {
        root.setTop(crearTituloSubMenu("Buscar Usuario", color));
    }

    private VBox crearSeccionBusqueda() {
        VBox contenedorIngresoBusquedas = new VBox();
        GridPane gp = new GridPane();
        gp.addColumn(0, campo);
        gp.addColumn(1, buscar);
        gp.add(clean, 2, 0);
        gp.setHgap(15);
        gp.setVgap(10);
        gp.setAlignment(Pos.TOP_CENTER);
        contenedorIngresoBusquedas.setPadding(new Insets(5, 0, 0, 0));
        contenedorIngresoBusquedas.setAlignment(Pos.TOP_CENTER);
        contenedorIngresoBusquedas.getChildren().add(gp);
        return contenedorIngresoBusquedas;
    }

    private void seccionResultadoBusqueda() {
        VBox contenedorTitulos = new VBox();
        VBox v3 = new VBox();
        v3.setPadding(new Insets(0, 7, 0, 7));
        contenedorTitulos.setPadding(new Insets(0, 7, 0, 7));//top,derecha,abajo,izquierda
        contenedorTitulos.setAlignment(Pos.TOP_CENTER);
        contenedorTitulos.setSpacing(7);
        busquedaScrollPane = new ScrollPane();
        v3.getChildren().add(busquedaScrollPane);
        contenedorTitulos.getChildren().addAll(crearSeccionBusqueda(), v3);
        root.setCenter(contenedorTitulos);
    }

    public Button getBack() {
        return back;
    }

    public void setBack(Button back) {
        this.back = back;
    }

    public Button getBuscar() {
        return buscar;
    }

    public void setBuscar(Button buscar) {
        this.buscar = buscar;
    }

    public TextField getCampo() {
        return campo;
    }

    public void setCampo(TextField campo) {
        this.campo = campo;
    }

    public ObservableList<Usuario> getLusario() {
        return lusario;
    }

    public void setLusario(ObservableList<Usuario> lusario) {
        this.lusario = lusario;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }

    public ScrollPane getBusquedaScrollPane() {
        return busquedaScrollPane;
    }

    public void setBusquedaScrollPane(VBox contenedor) {
        this.busquedaScrollPane.setContent(contenedor);
    }

    public boolean campoVacio() {
        return !this.campo.getText().equals("");
    }

    public Button getVer() {
        return ver;
    }

    public void setVer(Button ver) {
        this.ver = ver;
    }

    public void iniciarVer() {
        ver = new Button("ver");
    }
}
