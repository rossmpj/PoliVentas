/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Controlador.Vendedor;

import ec.edu.espol.Auxiliares.MensajesAcciones;
import ec.edu.espol.Controlador.Principal.WindowsController;
import ec.edu.espol.Modelo.Pedido;
import ec.edu.espol.Vista.Vendedor.VistaFechaPedido;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
class ControladorFechaPedido{
    
    private final Pedido ModeloPedido;
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
            
            if(ld == null || stringHour == null)    MensajesAcciones.camposVacios();
            
            else{
            
                Date date = Date.valueOf(LocalDate.parse(ld.toString()));
                Time hour = Time.valueOf(LocalTime.parse(stringHour));

                ModeloPedido.setFechaEntrega(date);
                ModeloPedido.setHoraEntrega(hour);
                ModeloPedido.update();

                WindowsController.previous();
            }
        }
    }
}
