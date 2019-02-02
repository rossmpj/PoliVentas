/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Vendedor;

import Auxiliares.Validators;
import Controlador.Principal.WindowsController;
import Modelo.Producto;
import Vista.Vendedor.VistaInfoProducto;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

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
            
            if(!fieldsOK){
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Valor ingresado incorrecto");
                alert.setContentText("Todos los campos son obligatorios.\nEn los campos numéricos, recuerda ingresar números positivos.");
                alert.showAndWait();
                return;
            }
            
            ModeloProducto.setNombre(nombre);
            ModeloProducto.setDescripcion(descripcion);
            ModeloProducto.setCategoria(categoria);
            ModeloProducto.setPrecio(precio);
            ModeloProducto.setStock(stock);
            
            ModeloProducto.modificarProducto();
            WindowsController.previous();
        }
        
    }
    
}
