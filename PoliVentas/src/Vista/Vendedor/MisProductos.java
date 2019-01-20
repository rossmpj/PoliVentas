/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Vendedor;

import Vista.Principal.Vista;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


/**
 *
 * @author Rosy, Galo Xavier Figueroa Villacreses
 */
public class MisProductos implements Vista{
    private final BorderPane root;
    private Button AgregarProducto, ModificarProducto, EliminarProducto, Regresar;
    
    public BorderPane getRoot(){
        return root;
    }
    
    public MisProductos(){
        root = new BorderPane();
        crearSeccionTituloProductos();
        inicializarBotones();
        crearSeccionProductos();
        seccionCalificaciones();
    }
    
    private void inicializarBotones(){   
        
        AgregarProducto = new Button("Agregar vendedor");
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
        TableView productos = new TableView();
        contenedorTablaProductos.setPadding(new Insets(10, 10, 10, 10));
        contenedorTablaProductos.getChildren().add(productos);
        root.setCenter(contenedorTablaProductos);
    }
    
    public void addAgregarProductoButtonHandler(EventHandler agregarProductoButtonHandler){
        AgregarProducto.setOnAction(agregarProductoButtonHandler);
    }
    
    public void addBackButtonHandler(EventHandler agregarProductoButtonHandler){
        Regresar.setOnAction(agregarProductoButtonHandler);
    }
    
    public void estiloBotones(Button btn){
        btn.setStyle("-fx-font: 17 Verdana;");
    }
}
