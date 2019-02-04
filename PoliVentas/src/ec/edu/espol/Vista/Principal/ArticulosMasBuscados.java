package ec.edu.espol.Vista.Principal;

import ec.edu.espol.Auxiliares.PatronVistaTitulos;
import ec.edu.espol.Modelo.Producto;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Karen
 */
public class ArticulosMasBuscados implements Vista {
    private TableView<Producto> tabla;
    private TableColumn<Producto, Void> colBtn;
    private TableColumn<Producto, String> colNombre;
    private TableColumn<Producto, String> colDescripcion;
    private TableColumn<Producto, String> colPrecio;
    private TableColumn<Producto, String> colCateg;
    private TableColumn<Producto, String> colStock;
    private TableColumn<Producto, String> colNB;
    private TableColumn<Producto, String> colCalif;
    private final BorderPane root;
    private boolean ingreso;
    private Button iniciarSesionBtn;
    private Button registrarseBtn;
    private Button back;
    private Label title;  
    
    public ArticulosMasBuscados(boolean ingreso) {
        root = new BorderPane();
        this.ingreso = ingreso;
        inicializarObjetos();
        BackgroundFill myBF = new BackgroundFill(Color.WHITESMOKE, new CornerRadii(1), new Insets(0.0, 0.0, 0.0, 0.0));
        root.setBackground(new Background(myBF));
        crearSeccionEncabezado();
        crearSeccionTabla();
    } 
    
    private void inicializarObjetos(){
        this.tabla = new TableView<>();
        iniciarSesionBtn = new Button("Iniciar Sesión");
        registrarseBtn = new Button("Registrarse");
        title = new Label("Artículos más buscados");  
        back = PatronVistaTitulos.botonRegresarMenu();
    }
    
    private void crearSeccionTabla(){
        VBox contenedorTabla = new VBox();
        contenedorTabla.setPadding(new Insets(35, 35, 35, 35));
        configurarAparienciaDeTabla();
        addColumnsToTable();
        addButtonToTable();
        contenedorTabla.getChildren().addAll(tabla);
        root.setCenter(contenedorTabla);
    }
    
    private void configurarAparienciaDeTabla() {
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabla.setPrefWidth(600);
        tabla.setPrefHeight(600);
    }
    
    private void addColumnsToTable(){
        colNombre= new TableColumn<>("Nombre");
        colDescripcion = new TableColumn<>("Descripción");
        colPrecio = new TableColumn<>("Precio");
        colCateg = new TableColumn<>("Categoría");
        colStock = new TableColumn<>("Stock");
        colNB = new TableColumn<>("Búsquedas");
        colCalif = new TableColumn<>("Calificación");
        tabla.getColumns().addAll(this.colNombre,this.colDescripcion,this.colPrecio,
                this.colCateg, this.colStock, this.colNB,this.colCalif);
          }
    
    private void addButtonToTable() {
        colBtn = new TableColumn("Accion");
        tabla.getColumns().add(colBtn);
    }
    
    private HBox seccionLabel(){
        HBox contenedorLabelTitulo = new HBox();
        title.setPrefHeight(97);
        title.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; ");
        title.setAlignment(Pos.CENTER);
        contenedorLabelTitulo.setAlignment(Pos.CENTER);
        contenedorLabelTitulo.getChildren().add(title);
        return contenedorLabelTitulo;
    }
    
    private HBox seccionBotones(){
        HBox contenedorBotones = new HBox();
        contenedorBotones.setAlignment(Pos.CENTER);
        contenedorBotones.setSpacing(15);
        this.estiloBotones(registrarseBtn, "0059A0");
        this.estiloBotones(iniciarSesionBtn, "0059A0");
        if (!this.ingreso) {
            contenedorBotones.getChildren().addAll(iniciarSesionBtn, registrarseBtn);
        }else{
            contenedorBotones.getChildren().add(back);
        }
        return contenedorBotones;
    }
    
    private void crearSeccionEncabezado(){
        HBox contenedorEncabezado = new HBox();
        DropShadow ds = new DropShadow();
        contenedorEncabezado.setAlignment(Pos.CENTER);
        contenedorEncabezado.setSpacing(90);
        contenedorEncabezado.setStyle("-fx-background-color: #01C5FF;");
        contenedorEncabezado.setEffect(ds);
        contenedorEncabezado.getChildren().addAll(seccionLabel(), seccionBotones());
        root.setTop(contenedorEncabezado);
    }  
    
    public void estiloBotones(Button btn, String colorHEX){
        btn.setStyle("-fx-font: 15 Verdana; -fx-base: #"+colorHEX+";");
        btn.setPrefSize(130, 35);
    }   

    public void addBackButtonHandler(EventHandler addBackButtonHandler){
        this.back.setOnAction(addBackButtonHandler);
    }
    
    public void addRegistrarseBtnHandler(EventHandler registrarseBtnHandler){
        this.registrarseBtn.setOnAction(registrarseBtnHandler);
    }
    
    public void addIniciarSesionBtnHandler(EventHandler iniciarSesionBtnHandler){
        this.iniciarSesionBtn.setOnAction(iniciarSesionBtnHandler);
    }
    
    public TableView<Producto> getTabla(){
        return this.tabla;
    }

    public boolean isIngreso() {
        return ingreso;
    }

    public void setIngreso(boolean ingreso) {
        this.ingreso = ingreso;
    }

    public TableColumn<Producto, Void> getColBtn() {
        return colBtn;
    }

    public TableColumn<Producto, String> getColNombre() {
        return colNombre;
    }

    public TableColumn<Producto, String> getColDescripcion() {
        return colDescripcion;
    }

    public TableColumn<Producto, String> getColPrecio() {
        return colPrecio;
    }

    public TableColumn<Producto, String> getColCateg() {
        return colCateg;
    }

    public TableColumn<Producto, String> getColStock() {
        return colStock;
    }

    public TableColumn<Producto, String> getColNB() {
        return colNB;
    }

    public TableColumn<Producto, String> getColCalif() {
        return colCalif;
    }

    @Override
    public BorderPane getRoot() {
        return root;
    }
}