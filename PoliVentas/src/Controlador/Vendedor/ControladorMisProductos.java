/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Vendedor;

import Controlador.Principal.ControladorLogin;
import Controlador.Principal.WindowsController;
import Modelo.Producto;
import Vista.Vendedor.MisProductos;
import Vista.Vendedor.VistaInfoProducto;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorMisProductos {
    
    private final MisProductos VistaMisProductos;

    public ControladorMisProductos(MisProductos VistaMisProductos) {
        this.VistaMisProductos = VistaMisProductos;
        
        this.VistaMisProductos.addBackButtonHandler((event -> WindowsController.previous()));
        this.VistaMisProductos.addAgregarProductoButtonHandler(new AgregarProductoButtonHandler());
        this.VistaMisProductos.addModificarProductoButtonHandler(new ModificarProductoButtonHandler());
        this.VistaMisProductos.addDeleteButtonHandler(new DeleteButtonHandler());
        refreshView();
    }
    
    private class AgregarProductoButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            Producto ModeloProducto = new Producto();
            VistaInfoProducto nuevoProductoView = new VistaInfoProducto();
            ControladorNuevoProducto controladorNuevoProducto = new ControladorNuevoProducto(ModeloProducto, nuevoProductoView);
            
            WindowsController.next(VistaMisProductos, nuevoProductoView);
            
        }
        
    }
    
    private class ModificarProductoButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            TableView<Producto> productos = VistaMisProductos.getTablaProductos();
            Producto ModeloProducto = productos.getSelectionModel().getSelectedItem();
            
            if(ModeloProducto == null){
                
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Noy hay nada que modificar");
                alert.setContentText("Debes seleccionar en la tabla el producto que quieres modificar.");
                alert.showAndWait();
                return;
            
            }
            
            VistaInfoProducto modificarProductoView = new VistaInfoProducto();
            ControladorModificarProducto controladorModificarProducto = new ControladorModificarProducto(ModeloProducto, modificarProductoView);
            
            WindowsController.next(VistaMisProductos, modificarProductoView);
            
        }
        
    }
    
    private class DeleteButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            TableView<Producto> productos = VistaMisProductos.getTablaProductos();
            
            Producto ModeloProducto = productos.getSelectionModel().getSelectedItem();
            
            Alert alert;
            
            if(ModeloProducto == null){
                
                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Noy hay nada que eliminar");
                alert.setContentText("Debes seleccionar en la tabla el producto que quieres eliminar.");
                alert.showAndWait();
                return;
            
            }
            
            alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Mensaje de confirmación");
            alert.setHeaderText("¿Estás seguro de eliminar el producto seleccionado?");
            alert.setContentText(ModeloProducto.toString());
            alert.showAndWait();
            
            ButtonType result = alert.getResult();
            
            if(result == ButtonType.OK || result == ButtonType.YES){
                
                ModeloProducto.eliminarProducto();
                refreshView();
                
            }
        }
        
    }
    
    private void refreshView(){
        
        TableView<Producto> table = VistaMisProductos.getTablaProductos();
        ObservableList<Producto> list = Producto.getMisProductos(ControladorLogin.vend_id);
        table.setItems(list);
    }
    
}