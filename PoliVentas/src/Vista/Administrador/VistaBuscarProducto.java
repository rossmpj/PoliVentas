/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista.Administrador;

import Auxiliares.CONSTANTES;
import static Auxiliares.PatronVistaTitulos.botonRegresarMenu;
import static Auxiliares.PatronVistaTitulos.crearTituloSubMenu;
import Vista.Principal.Vista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Tiffy
 */
public class VistaBuscarProducto implements Vista {

    private final BorderPane root;
    private Button back, buscar, herramientas, ver,clean;
    private final String color;
    private TextField campo;
    private MenuBar menu;
    VBox efectoMenu;
    private VBox vbox;
    private ScrollPane busquedaScrollPane;

    public VistaBuscarProducto(String color) {
        root = new BorderPane();
        this.color = color;
        inicializarObjetos();
        crearSeccionTitulo();
        seccionResultadoBusqueda();
        llamarEfecto();
    }

    @Override
    public BorderPane getRoot() {
        return root;
    }

    private void inicializarObjetos() {
        back = botonRegresarMenu();
        root.setBottom(back);
        buscar = new Button();
        clean = new Button();
        herramientas = new Button("Herramientas");
        estiloBotones(clean, "EAFF26","/eraser.png");
        estiloBotones(buscar, "51A7C1", "/search.png");
        campo = new TextField();
        campo.setPrefWidth(350);
        campo.setPrefHeight(40);
        campo.setPromptText("Ingrese nombre del producto...");
        menu = new MenuBar();
        menu.setPrefWidth(200);
        NewMenu();
        efectoMenu = new VBox();
        vbox = new VBox();
    }

    private void NewMenu() {
        this.menu.setBackground(Background.EMPTY);
        Menu costo = new Menu("Costo ▼");
        Menu catego = new Menu("Categoría ▼");
        Menu cali = new Menu("Calificación ▼");
        Menu esta = new Menu("Estado ▼");
        menu.getMenus().addAll(costo, catego, cali, esta);
        RadioMenuItem todos = new RadioMenuItem("Todos");
        RadioMenuItem anulados = new RadioMenuItem("Anulados");
        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(todos, anulados);
        esta.getItems().addAll(todos, anulados);
    }

    private void estiloBotones(Button btn, String base, String path) {
        btn.setStyle("-fx-background-radius: 15em; -fx-min-width: 50px; -fx-min-height: 50px;"
                + " -fx-max-width: 50px; -fx-max-height: 50px; -fx-base: #" + base + ";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG + path));
        btn.setGraphic(new ImageView(image));
        btn.setAlignment(Pos.CENTER);
    }

    private void llamarEfecto() {
        efectoMenu();
    }

    public void addBackButtonHandler(EventHandler agregarProductoButtonHandler) {
        back.setOnAction(agregarProductoButtonHandler);
    }

    public void addBuscarButtonHandler(EventHandler BuscarPButtonHandler) {
        buscar.setOnAction(BuscarPButtonHandler);
    }

    public void addVerButtonHandler(EventHandler ventanaPButtonHandler) {
        ver.setOnAction(ventanaPButtonHandler);
    }
    
    public void addCleanButtonHandler(EventHandler cleanPButtonHandler){
        this.clean.setOnAction(cleanPButtonHandler);
    }

    private void crearSeccionTitulo() {
        root.setTop(crearTituloSubMenu("Buscar Productos", color));
    }

    private VBox crearSeccionBusqueda() {
        VBox contenedorIngresoBusquedas = new VBox();
        GridPane gp = new GridPane();
        gp.addColumn(0, campo);
        gp.addColumn(1, buscar);
        gp.addColumn(2, clean);
        gp.addColumn(3, herramientas);
        gp.setHgap(15);
        gp.setVgap(10);
        gp.setAlignment(Pos.TOP_CENTER);
        contenedorIngresoBusquedas.setPadding(new Insets(5, 0, 0, 0));
        contenedorIngresoBusquedas.setAlignment(Pos.TOP_CENTER);
        contenedorIngresoBusquedas.getChildren().addAll(gp, efectoMenu);
        contenedorIngresoBusquedas.setSpacing(5);
        return contenedorIngresoBusquedas;
    }

    private void efectoMenu() {
        herramientas.setOnAction((ActionEvent e) -> {
            if (efectoMenu.getChildren().isEmpty()) {
                this.efectoMenu.getChildren().add(menu);
            } else {
                this.efectoMenu.getChildren().clear();
            }
        });
    }

    private void seccionResultadoBusqueda() {
        VBox contenedorTitulos = new VBox();
        VBox v3 = new VBox();
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

    public Button getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(Button herramientas) {
        this.herramientas = herramientas;
    }

    public TextField getCampo() {
        return campo;
    }

    public void setCampo(TextField campo) {
        this.campo = campo;
    }

    public VBox getVbox() {
        return vbox;
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
