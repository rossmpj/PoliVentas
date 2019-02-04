package ec.edu.espol.Controlador.Comprador;

import ec.edu.espol.Auxiliares.MensajesAcciones;
import ec.edu.espol.Controlador.Principal.ControladorLogin;
import ec.edu.espol.Controlador.Principal.WindowsController;
import ec.edu.espol.Modelo.Pago;
import ec.edu.espol.Modelo.PagoEfectivo;
import ec.edu.espol.Modelo.PagoVirtual;
import ec.edu.espol.Modelo.Pedido;
import ec.edu.espol.Modelo.Producto;
import ec.edu.espol.Modelo.Vendedor;
import ec.edu.espol.Vista.Comprador.SendMail;
import ec.edu.espol.Vista.Comprador.VistaComprar;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Rosy
 */
public class ControladorComprar {

    private final Producto ModeloProducto;
    private final VistaComprar VistaComprar;
    private final SendMail enviaCorreo;
    private Pago pago;

    public ControladorComprar(Producto ModeloProducto, VistaComprar vistaComprar) {
        this.ModeloProducto = ModeloProducto;
        this.VistaComprar = vistaComprar;
        enviaCorreo = new SendMail();
        this.VistaComprar.addBackButtonHandler((event -> WindowsController.previous()));
        this.VistaComprar.addPagoEfectivoButtonHandler(new PagoEfectivoButtonHandler());
        this.VistaComprar.addPagoVirtualButtonHandler(new PagoVirtualButtonHandler());
    }

    private class PagoVirtualButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            VistaComprar.getPagoEfectivo().setDisable(true);
            pago = new PagoVirtual();
            Vendedor v = VistaComprar.getProduct().getVendedorDeProductoBuscado();
            Producto p = VistaComprar.getProduct();
            double total = VistaComprar.getProduct().getPrecio() * VistaComprar.getCantidadElegida();
            if(p.getStock()<VistaComprar.getCantidadElegida()){
                MensajesAcciones.stockInsuficiente();
            } else if (pago.pagar(ControladorLogin.comp_id, total)) {
                Pedido pw = new Pedido("pendiente", total, VistaComprar.getCantidadElegida(), Date.valueOf(LocalDate.now()), 
                Time.valueOf(LocalTime.now()), null, null, VistaComprar.getLugar().getText(), "PHONE", ControladorLogin.comp_id,
                v.getIdVendedor(), VistaComprar.getProduct().getIdProducto());
                if (MensajesAcciones.confirmarCompra(Math.round(total * 100d) / 100d)){
                    pw.registrar();
                    VistaComprar.getProduct().descontarStock(VistaComprar.getCantidadElegida());
                    enviaCorreo.SendMail(v.getEmail(), pw.toString() +"\n"+ModeloProducto.toString());
                }
            } else {
                MensajesAcciones.saldoInsuficiente();
            }
        }
    }

    private class PagoEfectivoButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            VistaComprar.getPagoVirtual().setDisable(true);
            pago = new PagoEfectivo();
            Vendedor v = VistaComprar.getProduct().getVendedorDeProductoBuscado();
            Producto p = VistaComprar.getProduct();
            double total = VistaComprar.getProduct().getPrecio() * VistaComprar.getCantidadElegida();
            if(p.getStock()<VistaComprar.getCantidadElegida()){
                MensajesAcciones.stockInsuficiente();
            }else if (pago.pagar(ControladorLogin.comp_id, VistaComprar.getProduct().getPrecio())){
                Pedido pw = new Pedido("pendiente", VistaComprar.getProduct().getPrecio(), VistaComprar.getCantidadElegida(), null, null, null, null, "Lugar de prueba", "MONEY", ControladorLogin.comp_id, VistaComprar.getProduct().getVendedor().getIdVendedor(), VistaComprar.getProduct().getIdProducto());
                pw.registrar();
                VistaComprar.getProduct().descontarStock(VistaComprar.getCantidadElegida());
                enviaCorreo.SendMail(v.getEmail(), ModeloProducto.toString());
            }
        }
    }
}
