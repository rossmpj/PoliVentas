/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Vendedor;

import Auxiliares.Validators;
import Controlador.Principal.WindowsController;
import Modelo.Producto;
import Vista.Principal.Vista;
import Vista.Vendedor.VistaInfoProducto;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
class ControladorNuevoProducto{
    
    private Producto ModeloProducto;
    private final VistaInfoProducto VistaNuevoProducto;

    public ControladorNuevoProducto(Producto ModeloProducto, VistaInfoProducto VistaNuevoProducto) {
        
        this.ModeloProducto = ModeloProducto;
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
            
            if(!fieldsOK){
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Valor ingresado incorrecto");
                alert.setContentText("Todos los campos son obligatorios.\nEn los campos numéricos, recuerda ingresar números positivos.");
                alert.showAndWait();
                return;
            }
            
            ModeloProducto.setIdProducto(id);
            ModeloProducto.setNombre(nombre);
            ModeloProducto.setDescripcion(descripcion);
            ModeloProducto.setCategoria(categoria);
            ModeloProducto.setPrecio(precio);
            ModeloProducto.setStock(stock);
            
            ModeloProducto.setId_vendedor("vend001");
            
            ModeloProducto.registrar();
            WindowsController.previous();
        }
        
    }
    
}
