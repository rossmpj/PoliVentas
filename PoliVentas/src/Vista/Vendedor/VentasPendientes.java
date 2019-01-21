/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Vendedor;

import Modelo.Pedido;
import Modelo.Producto;
import Vista.Principal.Vista;
import javafx.event.ActionEvent;
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
public class VentasPendientes implements Vista{
    private final BorderPane root;
    private Button AnularVenta, VerMapa, Regresar;
    private TableView<Pedido> pedidos;
    
    @Override
    public BorderPane getRoot(){
        return root;
    }
    
    public VentasPendientes(){
        root = new BorderPane();
        crearSeccionTituloVentasPendientes();
        inicializarBotones();
        crearSeccionVentasPendientes();
        seccionCalificaciones();
    }
    
    private void inicializarBotones(){   
        
        AnularVenta = new Button("Anular venta");
        AnularVenta.setStyle("-fx-font: 17 Verdana; ");
        
        VerMapa = new Button("Ver en el mapa");
        VerMapa.setStyle("-fx-font: 17 Verdana; ");
        
        Regresar = new Button("        Volver        ");
        Regresar.setStyle("-fx-font: 17 Verdana; ");
    }
    
    private void seccionCalificaciones(){ 
        VBox vBoxCalif = new VBox();
        
        vBoxCalif.setSpacing(24);
        vBoxCalif.setAlignment(Pos.CENTER);
        
        vBoxCalif.setPadding(new Insets(8, 8, 8, 8));
        
        vBoxCalif.getChildren().addAll(AnularVenta, VerMapa, Regresar);
        root.setLeft(vBoxCalif);
    } 
    
    private void crearSeccionTituloVentasPendientes(){
        Label comprador = new Label("Mis ventas pendientes");
        comprador.setPrefSize(720, 80);
        comprador.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #A8C5FA; ");
        comprador.setAlignment(Pos.CENTER);
        root.setTop(comprador);
    }
    
    private void crearSeccionVentasPendientes(){
        VBox contenedorTablaProductos = new VBox();
        createTable();
        contenedorTablaProductos.setPadding(new Insets(10, 10, 10, 10));
        contenedorTablaProductos.getChildren().add(pedidos);
        root.setCenter(contenedorTablaProductos);
    }
    
    private void createTable(){
        
        pedidos = new TableView<>();
        TableColumn<Producto, String> idCOL = new TableColumn<>("ID Pedido");
        idCOL.setCellValueFactory(new PropertyValueFactory<>("idPedido"));
        
        TableColumn<Producto, String> nombreCOL = new TableColumn<>("ID Producto");
        nombreCOL.setCellValueFactory(new PropertyValueFactory<>("idProductos"));
        
        TableColumn<Producto, String> descripcionCOL = new TableColumn<>("Cantidad");
        descripcionCOL.setCellValueFactory(new PropertyValueFactory<>("cantidadPedida"));
        
        TableColumn<Producto, String> precioCOL = new TableColumn<>("Costo");
        precioCOL.setCellValueFactory(new PropertyValueFactory<>("costo"));
        
        
    }
    
    public void addBackButtonHandler(EventHandler agregarProductoButtonHandler){
        Regresar.setOnAction(agregarProductoButtonHandler);
    }
    
    public void estiloBotones(Button btn){
        btn.setStyle("-fx-font: 17 Verdana;");
    }
    
    public TableView<Pedido> getTablaPedidos(){
        return pedidos;
    }
}
