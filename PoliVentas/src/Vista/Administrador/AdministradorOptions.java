/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Administrador;

import Auxiliares.CONSTANTES;
import Vista.Principal.PaneLogin;
import Vista.Principal.Vista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class AdministradorOptions implements Vista{

    private final BorderPane root;
    private Button busquedaSencilla, busquedaAvanzada, nuevoUser, buscarUser, nuevoProducto, buscarProducto,
            comprasPendientes, comprasAnuladas, comprasExitosas, cerrarSesion;

    public AdministradorOptions() {
        root = new BorderPane();
        crearSeccionTituloAdmin();
        createContent();
        setListeners();
    }

    public BorderPane getRoot() {
        return root;
    }

    private void inicializarBotones() {
        busquedaSencilla = new Button("Búsqueda\nSencilla");
        busquedaAvanzada = new Button("Búsqueda\nAvanzada");
        nuevoUser = new Button("Agregar\nUsuario");
        buscarUser = new Button("Buscar\nUsuario");
        nuevoProducto = new Button("Nuevo\nproducto");
        buscarProducto = new Button("Buscar\nProducto");
        comprasPendientes = new Button("Compras\nPendientes");
        comprasAnuladas = new Button("Compras\nAnuladas");
        comprasExitosas = new Button("Compras\nExitosas");
        cerrarSesion = new Button("Cerrar\nSesión");
        llamarBotones();
    }

    public void estiloBotones(Button btn, String base, String path) {
        btn.setStyle("-fx-font: 9 Verdana; -fx-base: #" + base + ";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG + path));
        btn.setGraphic(new ImageView(image));
        btn.setPrefSize(130, 100);
    }

    public void estiloLabels(Label lbl, String base) {
        lbl.setPrefSize(260, 80);
        lbl.setStyle("-fx-font: 17 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #" + base + "; ");
        lbl.setAlignment(Pos.CENTER);
    }

    private void createContent() {
        inicializarBotones();
        VBox contentMenuAdmin = new VBox();
        contentMenuAdmin.setAlignment(Pos.CENTER);
        contentMenuAdmin.setPadding(new Insets(10, 10, 10, 10));
        contentMenuAdmin.getChildren().addAll(GridPaneSeccion1(), GridPaneSeccion2());
        root.setCenter(contentMenuAdmin);
    }

    private void llamarBotones() {
        estiloBotones(busquedaSencilla, "A8EFFA", "/busqueda.png");
        estiloBotones(busquedaAvanzada, "A8B6FA", "/ajustes.png");
        estiloBotones(nuevoUser, "C7E7E0", "/add-user.png");
        estiloBotones(buscarUser, "A8ECDD", "/searchu.png");//C3F58E
        estiloBotones(nuevoProducto, "81F7D8", "/valor.png");
        estiloBotones(buscarProducto, "51A7C1", "/bolsa.png");
        estiloBotones(comprasPendientes, "78EDF4", "/cartp.png");
        estiloBotones(comprasAnuladas, "5DC2E1", "/cartc.png");
        estiloBotones(comprasExitosas, "BCFBFF", "/carta.png");
        estiloBotones(cerrarSesion, "FAEDA8", "/logout.png");
    }

    private VBox crearSeccionUsuarios() {
        VBox usuarios = new VBox();
        HBox usuarios1 = new HBox();
        Label lblUsuarios = new Label("Administrar Usuarios");
        estiloLabels(lblUsuarios, "63C5AF");
        usuarios1.getChildren().addAll(nuevoUser, buscarUser);
        usuarios.getChildren().addAll(lblUsuarios, usuarios1);
        return usuarios;
    }

    private VBox crearSeccionProductos() {
        VBox productos = new VBox();
        HBox productos1 = new HBox();
        Label lblProductos = new Label("Administrar Productos");
        estiloLabels(lblProductos, "086A87");
        productos1.getChildren().addAll(nuevoProducto, buscarProducto);
        productos.getChildren().addAll(lblProductos, productos1);
        return productos;
    }

    private VBox crearSeccionBusquedas() {
        VBox busqueda = new VBox();
        HBox busqueda1 = new HBox();
        Label lblTitle = new Label("Búsqueda");
        estiloLabels(lblTitle, "515489");
        busqueda1.getChildren().addAll(busquedaSencilla, busquedaAvanzada);
        busqueda.getChildren().addAll(lblTitle, busqueda1);
        return busqueda;
    }

    private VBox crearSeccionCompra() {
        VBox compras = new VBox();
        HBox compras1 = new HBox();
        Label lblCompras = new Label("Compras");
        estiloLabels(lblCompras, "6E939E");
        lblCompras.setPrefSize(390, 80);
        compras1.getChildren().addAll(comprasExitosas, comprasPendientes, comprasAnuladas);
        compras.getChildren().addAll(lblCompras, compras1);
        return compras;
    }

    private void crearSeccionTituloAdmin() { //comun
        Label comprador = new Label("Menú Administrador");
        comprador.setPrefSize(720, 80);
        comprador.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #47DEBD; ");
        comprador.setAlignment(Pos.CENTER);
        root.setTop(comprador);
    }

    private GridPane GridPaneSeccion1() {
        GridPane gp = new GridPane();
        gp.add(crearSeccionBusquedas(), 0, 0);
        gp.add(crearSeccionProductos(), 1, 0);
        gp.add(crearSeccionUsuarios(), 2, 0);
        gp.setHgap(10);
        gp.setVgap(30);
        gp.setAlignment(Pos.CENTER);
        return gp;
    }

    private GridPane GridPaneSeccion2() {
        GridPane gp = new GridPane();
        gp.add(crearSeccionCompra(), 0, 2);
        gp.add(cerrarSesion, 1, 2);
        gp.setHgap(10);
        gp.setVgap(10);
        gp.setPadding(new Insets(0, 24, 0, 0));
        gp.setAlignment(Pos.CENTER);
        return gp;
    }
    
    public void addNuevoUsuarioButtonHandler(EventHandler nuevoUsuarioButtonHandler){
        
        nuevoUser.setOnAction(nuevoUsuarioButtonHandler);
        
    }
    
    public void addBuscarUsuarioButtonHandler(EventHandler buscarUsuarioButtonHandler){
        
        buscarUser.setOnAction(buscarUsuarioButtonHandler);
        
    }
    
    public void addNuevoProductoButtonHandler(EventHandler nuevoProductoButtonHandler){
        
        nuevoProducto.setOnAction(nuevoProductoButtonHandler);
        
    }
    
    public void addBuscarProductoButtonHandler(EventHandler buscarProductoButtonHandler){
        
        buscarProducto.setOnAction(buscarProductoButtonHandler);
        
    }

    private void setListeners() {
        listenCerrarSesion();     
    }
    
    private void listenCerrarSesion(){
     cerrarSesion.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new PaneLogin().getRoot());});
    }

}
