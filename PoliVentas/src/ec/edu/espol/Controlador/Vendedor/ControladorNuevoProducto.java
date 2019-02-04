/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Controlador.Vendedor;

import ec.edu.espol.Auxiliares.MensajesAcciones;
import ec.edu.espol.Auxiliares.Validators;
import ec.edu.espol.Controlador.Principal.ControladorLogin;
import ec.edu.espol.Controlador.Principal.WindowsController;
import ec.edu.espol.Modelo.Producto;
import ec.edu.espol.Vista.Vendedor.VistaInfoProducto;
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
