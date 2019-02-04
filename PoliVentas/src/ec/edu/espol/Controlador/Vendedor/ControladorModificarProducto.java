/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Controlador.Vendedor;

import ec.edu.espol.Auxiliares.MensajesAcciones;
import ec.edu.espol.Auxiliares.Validators;
import ec.edu.espol.Controlador.Principal.WindowsController;
import ec.edu.espol.Modelo.Producto;
import ec.edu.espol.Vista.Vendedor.VistaInfoProducto;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorModificarProducto {
    
    private final Producto ModeloProducto;
    private final VistaInfoProducto VistaModificarProducto;

    public ControladorModificarProducto(Producto ModeloProducto, VistaInfoProducto VistaModificarProducto) {
        this.ModeloProducto = ModeloProducto;
        this.VistaModificarProducto = VistaModificarProducto;
        
        this.VistaModificarProducto.addBackButtonHandler((event -> WindowsController.previous()));
        this.VistaModificarProducto.addUpdateButtonHandler(new UpdateButtonHandler());
        configureView();
    }
    
    private void configureView(){
        
        VistaModificarProducto.getID().setText(ModeloProducto.getIdProducto());
        VistaModificarProducto.getID().setDisable(true);
        VistaModificarProducto.getNombre().setText(ModeloProducto.getNombre());
        VistaModificarProducto.getDescripcion().setText(ModeloProducto.getDescripcion());
        VistaModificarProducto.getCantidad().setText(Integer.toString(ModeloProducto.getStock()));
        VistaModificarProducto.getCategoria().setText(ModeloProducto.getCategoria());
        VistaModificarProducto.getPrecio().setText(Double.toString(ModeloProducto.getPrecio()));
        
    }
    
    private class UpdateButtonHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            
            String nombre = VistaModificarProducto.getNombre().getText();
            String descripcion = VistaModificarProducto.getDescripcion().getText();
            String categoria = VistaModificarProducto.getCategoria().getText();
            String stockString = VistaModificarProducto.getCantidad().getText();
            String precioString = VistaModificarProducto.getPrecio().getText();
            Integer stock = Validators.validateInt(stockString);
            Float precio = Validators.validateFloat(precioString);
            
            boolean fieldsOK = Validators.fieldNotEmpty(nombre) && Validators.fieldNotEmpty(descripcion) && 
                    Validators.fieldNotEmpty(categoria) && stock != null && precio != null;
            
            if(!fieldsOK)   MensajesAcciones.camposNumericosIncorrectos();
            
            else{
            
                ModeloProducto.setNombre(nombre);
                ModeloProducto.setDescripcion(descripcion);
                ModeloProducto.setCategoria(categoria);
                ModeloProducto.setPrecio(precio);
                ModeloProducto.setStock(stock);

                ModeloProducto.modificarProducto();
                MensajesAcciones.almacenamientoExitoso();
                WindowsController.previous();
            }
        }
        
    }
    
}
