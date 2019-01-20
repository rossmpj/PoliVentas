package Vista.Principal;

import Modelo.Producto;
import Vista.Administrador.VistaInfoUsuario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;

/**
 *
 * @author Karen
 */
public class ArticulosMasBuscados implements Vista {
    private TableView<Producto> tabla;
    private TableColumn<Producto, String> colNombre, colDescripcion, colPrecio, colCateg,
            colStock,colNB, colCalif;
    private final BorderPane root;
    private Button iniciarSesionBtn;
    private Button registrarseBtn;
    private Label title;

    @Override
    public BorderPane getRoot() {
        return root;
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
    
    public void addRegistrarseBtnHandler(EventHandler registrarseBtnHandler){
        this.registrarseBtn.setOnAction(registrarseBtnHandler);
    }
    
    public void addIniciarSesionBtnHandler(EventHandler iniciarSesionBtnHandler){
        this.iniciarSesionBtn.setOnAction(iniciarSesionBtnHandler);
    }
    
    public TableView<Producto> getTabla(){
        return this.tabla;
    }  
    
    public ArticulosMasBuscados() {
        root = new BorderPane();
        inicializarObjetos();
        BackgroundFill myBF = new BackgroundFill(Color.WHITESMOKE, new CornerRadii(1), new Insets(0.0, 0.0, 0.0, 0.0));
        root.setBackground(new Background(myBF));
        setListeners();
        crearSeccionEncabezado();
        crearSeccionTabla();
    } 
    
    private void inicializarObjetos(){
        this.tabla = new TableView<>();
        iniciarSesionBtn = new Button("Iniciar Sesión");
        registrarseBtn = new Button("Registrarse");
        title = new Label("Artículos más buscados");   
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
        TableColumn<Producto, Void> colBtn = new TableColumn("Accion");
        Callback<TableColumn<Producto, Void>, TableCell<Producto, Void>> cellFactory = (final TableColumn<Producto, Void> param) -> {
            final TableCell<Producto, Void> cell = new TableCell<Producto, Void>() {
                private final Button btn = new Button("Ver"); {
                btn.setOnAction((ActionEvent event) -> {
                    root.getScene().setRoot(new PaneLogin().getRoot());
                });
            }
                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }
            };
            return cell;
        };
        colBtn.setCellFactory(cellFactory);
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
        contenedorBotones.getChildren().addAll(iniciarSesionBtn, registrarseBtn);
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
    
    private void setListeners(){
        iniciarSesionBtn.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new PaneLogin().getRoot());
        });    
        registrarseBtn.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new VistaInfoUsuario(true, "FADCA8", "Formulario de Registro").getRoot());
        });
    }
}