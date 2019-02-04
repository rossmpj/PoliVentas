/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Vendedor;

import Auxiliares.Validators;
import Controlador.Principal.ControladorLogin;
import Controlador.Principal.WindowsController;
import Modelo.Pedido;
import Modelo.Producto;
import Vista.Principal.Vista;
import Vista.Vendedor.VistaFechaPedido;
import Vista.Vendedor.VistaInfoProducto;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
class ControladorFechaPedido{
    
    private Pedido ModeloPedido;
    private final VistaFechaPedido VistaFechaPedido;

    public ControladorFechaPedido(Pedido ModeloPedido, VistaFechaPedido VistaFechaPedido) {
        
        this.ModeloPedido = ModeloPedido;
        this.VistaFechaPedido = VistaFechaPedido;
        
        this.VistaFechaPedido.addBackButtonHandler(event -> WindowsController.previous());
        this.VistaFechaPedido.addSaveButtonHandler(new SaveButtonHandler());
        
    }
    
    private class SaveButtonHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            
            LocalDate ld = VistaFechaPedido.getDatePicker().getValue();
            String stringHour = (String) VistaFechaPedido.getHoraEntrega().getValue();
            
            if(ld == null || stringHour == null){
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Existe algún campo sin llenar");
                alert.setContentText("Todos los campos son obligatorios. Debe seleccionar una fecha y una hora de entrega.");
                alert.showAndWait();
                
                return;
            }
            
            Date date = Date.valueOf(LocalDate.parse(ld.toString()));
            Time hour = Time.valueOf(LocalTime.parse(stringHour));
            
            ModeloPedido.setFechaEntrega(date);
            ModeloPedido.setHoraEntrega(hour);
            
            ModeloPedido.update();
            
            WindowsController.previous();
        }
        
    }
    
}
