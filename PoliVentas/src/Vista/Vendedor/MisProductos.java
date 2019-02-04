/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Vendedor;

import Modelo.Producto;
import Vista.Principal.Vista;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


/**
 *
 * @author Rosy, Galo Xavier Figueroa Villacreses
 */
public class MisProductos implements Vista{
    private final BorderPane root;
    private Button AgregarProducto;
    private Button ModificarProducto;
    private Button EliminarProducto;
    private Button Regresar;
    private TableView<Producto> productos;
    
    public MisProductos(){
        root = new BorderPane();
        crearSeccionTituloProductos();
        inicializarBotones();
        crearSeccionProductos();
        seccionCalificaciones();
    }
    
    private void inicializarBotones(){
        
        AgregarProducto = new Button("Agregar producto");
        AgregarProducto.setStyle("-fx-font: 17 Verdana; ");
        
        ModificarProducto = new Button("Modificar producto");
        ModificarProducto.setStyle("-fx-font: 17 Verdana; ");
        
        EliminarProducto = new Button("Eliminar producto");
        EliminarProducto.setStyle("-fx-font: 17 Verdana; ");
        
        Regresar = new Button("        Volver        ");
        Regresar.setStyle("-fx-font: 17 Verdana; ");
    }
    
    private void seccionCalificaciones(){ 
        VBox vBoxCalif = new VBox();
        
        vBoxCalif.setSpacing(24);
        vBoxCalif.setAlignment(Pos.CENTER);
        
        vBoxCalif.setPadding(new Insets(8, 8, 8, 8));
        
        vBoxCalif.getChildren().addAll(AgregarProducto, ModificarProducto, EliminarProducto, Regresar);
        root.setLeft(vBoxCalif);
    } 
    
    private void crearSeccionTituloProductos(){
        Label comprador = new Label("Mis productos");
        comprador.setPrefSize(720, 80);
        comprador.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #A8C5FA; ");
        comprador.setAlignment(Pos.CENTER);
        root.setTop(comprador);
    }
    
    private void crearSeccionProductos(){
        VBox contenedorTablaProductos = new VBox();
        
        createTable();
        
        contenedorTablaProductos.setPadding(new Insets(10, 10, 10, 10));
        contenedorTablaProductos.getChildren().add(productos);
        root.setCenter(contenedorTablaProductos);
    }
    
    private void createTable(){
        
        productos = new TableView<>();
        TableColumn<Producto, String> idCOL = new TableColumn<>("ID");
        idCOL.setCellValueFactory(new PropertyValueFactory<>("idProducto"));
        
        TableColumn<Producto, String> nombreCOL = new TableColumn<>("Nombre");
        nombreCOL.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        
        TableColumn<Producto, String> descripcionCOL = new TableColumn<>("Descripción");
        descripcionCOL.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        
        TableColumn<Producto, String> precioCOL = new TableColumn<>("Precio");
        precioCOL.setCellValueFactory(new PropertyValueFactory<>("precio"));
        
        TableColumn<Producto, String> categoriaCOL = new TableColumn<>("Categoría");
        categoriaCOL.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        
        TableColumn<Producto, String> stockCOL = new TableColumn<>("Stock");
        stockCOL.setCellValueFactory(new PropertyValueFactory<>("stock"));
        
        productos.getColumns().addAll(idCOL,nombreCOL, descripcionCOL, precioCOL, categoriaCOL, stockCOL);
        
    }
    
    public void addAgregarProductoButtonHandler(EventHandler agregarProductoButtonHandler){
        AgregarProducto.setOnAction(agregarProductoButtonHandler);
    }
    
    public void addModificarProductoButtonHandler(EventHandler modificarProductoButtonHandler){
        ModificarProducto.setOnAction(modificarProductoButtonHandler);
    }
    
    public void addDeleteButtonHandler(EventHandler deleteButtonHandler){
        EliminarProducto.setOnAction(deleteButtonHandler);
    }
    
    public void addBackButtonHandler(EventHandler agregarProductoButtonHandler){
        Regresar.setOnAction(agregarProductoButtonHandler);
    }
    
    public TableView getTablaProductos(){
        return productos;
    }
    
    @Override
    public BorderPane getRoot(){
        return root;
    }
}
