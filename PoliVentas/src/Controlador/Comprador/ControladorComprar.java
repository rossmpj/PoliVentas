package Controlador.Comprador;

import Controlador.Principal.WindowsController;
import Modelo.Producto;
import Vista.Comprador.SendMail;
import Vista.Comprador.VistaComprar;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Rosy
 */
public class ControladorComprar {
    private final Producto ModeloProducto;
    private final VistaComprar VistaComprar;
    private SendMail m;

    public ControladorComprar(Producto ModeloProducto, VistaComprar vistaComprar) {
        this.ModeloProducto = ModeloProducto;
        this.VistaComprar = vistaComprar;
        m = new SendMail();
        this.VistaComprar.addBackButtonHandler((event -> WindowsController.previous()));
        this.VistaComprar.addPagoEfectivoButtonHandler(new PagoEfectivoButtonHandler());
        this.VistaComprar.addPagoVirtualButtonHandler(new PagoVirtualButtonHandler());
    }

    private class PagoVirtualButtonHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            VistaComprar.getPagoEfectivo().setDisable(true);
            m.SendMail("rosita_mariap@hotmail.es", ModeloProducto.toString());
        }
    }
    
    private class PagoEfectivoButtonHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            VistaComprar.getPagoVirtual().setDisable(true);
            m.SendMail("rosita_mariap@hotmail.es", ModeloProducto.toString());
        }
    }
}
