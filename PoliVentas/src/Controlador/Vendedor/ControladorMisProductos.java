/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Vendedor;

import Controlador.Principal.WindowsController;
import Modelo.Producto;
import Vista.Vendedor.MisProductos;
import Vista.Vendedor.NuevoProducto;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorMisProductos {
    
    private final Producto ModeloProducto;
    private final MisProductos VistaMisProductos;

    public ControladorMisProductos(Producto ModeloProducto, MisProductos VistaMisProductos) {
        this.ModeloProducto = ModeloProducto;
        this.VistaMisProductos = VistaMisProductos;
        
        this.VistaMisProductos.addBackButtonHandler((event -> WindowsController.previous()));
        this.VistaMisProductos.addAgregarProductoButtonHandler(new AgregarProductoButtonHandler());
    }
    
    private class AgregarProductoButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            NuevoProducto nuevoProductoView = new NuevoProducto();
            ControladorNuevoProducto controladorNuevoProducto = new ControladorNuevoProducto(ModeloProducto, nuevoProductoView);
            
            VistaMisProductos.getRoot().getScene().setRoot(nuevoProductoView.getRoot());
            
        }
        
    }
    
}
