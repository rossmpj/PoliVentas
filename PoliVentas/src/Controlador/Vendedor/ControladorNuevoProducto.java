/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Vendedor;

import Auxiliares.MensajesAcciones;
import Auxiliares.Validators;
import Controlador.Principal.ControladorLogin;
import Controlador.Principal.WindowsController;
import Modelo.Producto;
import Vista.Vendedor.VistaInfoProducto;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
class ControladorNuevoProducto{
    
    private final VistaInfoProducto VistaNuevoProducto;

    public ControladorNuevoProducto(VistaInfoProducto VistaNuevoProducto) {
        
        this.VistaNuevoProducto = VistaNuevoProducto;
        
        this.VistaNuevoProducto.addBackButtonHandler(event -> WindowsController.previous());
        this.VistaNuevoProducto.addCreateButtonHandler(new SaveButtonHandler());
        
    }
    
    private class SaveButtonHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            
            String id = VistaNuevoProducto.getID().getText();
            String nombre = VistaNuevoProducto.getNombre().getText();
            String descripcion = VistaNuevoProducto.getDescripcion().getText();
            String categoria = VistaNuevoProducto.getCategoria().getText();
            String stockString = VistaNuevoProducto.getCantidad().getText();
            String precioString = VistaNuevoProducto.getPrecio().getText();
            Integer stock = Validators.validateInt(stockString);
            Float precio = Validators.validateFloat(precioString);
            
            boolean fieldsOK = Validators.fieldNotEmpty(id) &&Validators.fieldNotEmpty(nombre) && 
                    Validators.fieldNotEmpty(descripcion) && Validators.fieldNotEmpty(categoria) && 
                    stock != null && precio != null;
            
            if(!fieldsOK)   MensajesAcciones.camposNumericosIncorrectos();
            
            else{
                
                Producto ModeloProducto = new Producto();
                ModeloProducto.setIdProducto(id);
                ModeloProducto.setNombre(nombre);
                ModeloProducto.setDescripcion(descripcion);
                ModeloProducto.setCategoria(categoria);
                ModeloProducto.setPrecio(precio);
                ModeloProducto.setStock(stock);

                ModeloProducto.setIdVendedor(ControladorLogin.vend_id);

                ModeloProducto.registrar();
                WindowsController.previous();
            }
        }
        
    }
    
}
