package Vista.Principal;

import Modelo.Producto;
import Vista.Administrador.VistaInfoUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
public class ArticulosMasBuscados {
    private final TableView<Producto> tabla = new TableView<>();
    private ObservableList<Producto> observableList;
    private final BorderPane root;
    private Button iniciarSesionBtn;
    private Button registrarseBtn;
    private Label title;

    public BorderPane getRoot() {
        return root;
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
        observableList = FXCollections.observableArrayList();
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
        cargarData();
        tabla.setItems(observableList);
        contenedorTabla.getChildren().addAll(tabla);
        root.setCenter(contenedorTabla);
    }
    
    private void configurarAparienciaDeTabla() {
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tabla.setPrefWidth(600);
        tabla.setPrefHeight(600);
    }
    
    private void addColumnsToTable(){
        TableColumn<Producto, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("idProducto"));        
        TableColumn<Producto, Integer> colNombre= new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<Producto, String> colDescripcion = new TableColumn<>("Descripción");
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        TableColumn<Producto, String> colCateg = new TableColumn<>("Categoría");
        colCateg.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        TableColumn<Producto, String> colCalif = new TableColumn<>("Calificación");
        colCalif.setCellValueFactory(new PropertyValueFactory<>("calificacion"));
        tabla.getColumns().addAll(colId, colNombre, colDescripcion, colCateg, colCalif);
    }
    
    private void addButtonToTable() {
        TableColumn<Producto, Void> colBtn = new TableColumn("");
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
        //contenedorEncabezado.setEffect(ds);
        contenedorEncabezado.getChildren().addAll(seccionLabel(), seccionBotones());
        root.setTop(contenedorEncabezado);
    }  
    
    private void cargarData() {
        observableList.addAll(new Producto("01", "Audifonos", "Audifonos para celulares", "Tecnologica",10.00, 3),
        new Producto("02", "Cargadores", "Cargadores para celulares", "Tecnologica",15.00,4),
        new Producto("03", "Tortas", "Tortas de vainilla", "Comida",3.00, 4),
        new Producto("04", "Copa Mexicana", "Copa mexicana con guacamole", "Comida",2.50, 4),
        new Producto("05", "Micas", "Micas para celulares", "Articulos varios",13.00, 3),
        new Producto("06", "Case", "Case para celulares", "Articulos varios",13.00, 2),
        new Producto("07", "Cargadores", "Cargadores para celulares", "Tecnologica",15.00,4),
        new Producto("08", "Tortas", "Tortas de vainilla", "Comida",3.00, 4),
        new Producto("09", "Copa Mexicana", "Copa mexicana con guacamole", "Comida",2.50, 4),
        new Producto("10", "Micas", "Micas para celulares", "Articulos varios",13.00, 3),
        new Producto("11", "Case", "Case para celulares", "Articulos varios",13.00, 2),
        new Producto("12", "Case", "Case para celulares", "Articulos varios",13.00, 2),
        new Producto("13", "Case", "Case para celulares", "Articulos varios",13.00, 2),
        new Producto("14", "Case", "Case para celulares", "Articulos varios",13.00, 2),
        new Producto("15", "Case", "Case para celulares", "Articulos varios",13.00, 2)
        );
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