package Controlador.Comprador;

import Controlador.Principal.ControladorLogin;
import Controlador.Principal.WindowsController;
import Modelo.Pago;
import Modelo.PagoEfectivo;
import Modelo.PagoVirtual;
import Modelo.Pedido;
import Modelo.Producto;
import Vista.Comprador.SendMail;
import Vista.Comprador.VistaComprar;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
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
    private Pago pago;

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
            pago = new PagoVirtual();
            if (pago.pagar(ControladorLogin.comp_id, VistaComprar.getProduct().getPrecio())) {
                Pedido pw = new Pedido("pendiente", VistaComprar.getProduct().getPrecio(), 1, null, null, null, null, "Lugar de prueba", "PHONE", ControladorLogin.comp_id,
                        VistaComprar.getProduct().getVendedor().getIdVendedor(), VistaComprar.getProduct().getIdProducto());
                pw.registrar();//cambiar la cantidad...
                VistaComprar.getProduct().descontarStock(1); //cambiar luego de acuerdo al seleccionado por el comprador
                m.SendMail(VistaComprar.getProduct().getVendedor().getEmail(), ModeloProducto.toString()); //falta lo de Observer
            }
        }
    }

    private class PagoEfectivoButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            VistaComprar.getPagoVirtual().setDisable(true);
            pago = new PagoEfectivo();
            pago.pagar(ControladorLogin.comp_id, VistaComprar.getProduct().getPrecio());
            Pedido pw = new Pedido("pendiente", VistaComprar.getProduct().getPrecio(), 1, null, null, null, null, "Lugar de prueba", "MONEY", ControladorLogin.comp_id, VistaComprar.getProduct().getVendedor().getIdVendedor(), VistaComprar.getProduct().getIdProducto());
            pw.registrar();//cambiar la cantidad...
            VistaComprar.getProduct().descontarStock(1); //cambiar luego de acuerdo al seleccionado por el comprador
            m.SendMail(VistaComprar.getProduct().getVendedor().getEmail(), ModeloProducto.toString());
        }
    }
}
