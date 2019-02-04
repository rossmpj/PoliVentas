/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Controlador.Vendedor;

import ec.edu.espol.Auxiliares.MensajesAcciones;
import ec.edu.espol.Controlador.Principal.ControladorLogin;
import ec.edu.espol.Controlador.Principal.WindowsController;
import ec.edu.espol.Modelo.Producto;
import ec.edu.espol.Vista.Vendedor.MisProductos;
import ec.edu.espol.Vista.Vendedor.VistaInfoProducto;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
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
            
            VistaInfoProducto nuevoProductoView = new VistaInfoProducto();
            ControladorNuevoProducto controladorNuevoProducto = new ControladorNuevoProducto(nuevoProductoView);
            
            WindowsController.next(VistaMisProductos, nuevoProductoView);
        }
        
    }
    
    private class ModificarProductoButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            TableView<Producto> productos = VistaMisProductos.getTablaProductos();
            Producto ModeloProducto = productos.getSelectionModel().getSelectedItem();
            
            if(ModeloProducto == null)  MensajesAcciones.registroSinSeleccionar();
            
            else{
            
                VistaInfoProducto modificarProductoView = new VistaInfoProducto();
                ControladorModificarProducto controladorModificarProducto = new ControladorModificarProducto(ModeloProducto, modificarProductoView);
                WindowsController.next(VistaMisProductos, modificarProductoView);
            }
            
        }
        
    }
    
    private class DeleteButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            TableView<Producto> productos = VistaMisProductos.getTablaProductos();
            Producto ModeloProducto = productos.getSelectionModel().getSelectedItem();
            
            if(ModeloProducto == null) MensajesAcciones.registroSinSeleccionar();
            
            else{

                ButtonType result = MensajesAcciones.confirmacion("Se eliminará " + ModeloProducto.toString());

                if(result == ButtonType.OK || result == ButtonType.YES){
                    
                    ModeloProducto.eliminarProducto();
                    refreshView();
                }
            }
        }
        
    }
    
    private void refreshView(){
        
        TableView<Producto> table = VistaMisProductos.getTablaProductos();
        ObservableList<Producto> list = Producto.getMisProductos(ControladorLogin.vend_id);
        table.setItems(list);
    }
    
}