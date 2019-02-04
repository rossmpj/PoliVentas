package ec.edu.espol.Controlador.Comprador;

import ec.edu.espol.Auxiliares.MensajesAcciones;
import ec.edu.espol.Controlador.Principal.ControladorLogin;
import ec.edu.espol.Controlador.Principal.WindowsController;
import ec.edu.espol.Modelo.CalificacionProducto;
import ec.edu.espol.Modelo.CalificacionVendedor;
import ec.edu.espol.Modelo.Pedido;
import ec.edu.espol.Modelo.Producto;
import ec.edu.espol.Vista.Comprador.VistaComprasPendientes;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import ec.edu.espol.Modelo.Vendedor;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorComprasPendientes {
    
    private final Pedido ModeloPedido;
    private final VistaComprasPendientes VistaComprasPendientes;
    private final ObservableList<Pedido> observableList;

    public ControladorComprasPendientes(Pedido ModeloPedido, VistaComprasPendientes VistaComprasPendientes) {
        this.ModeloPedido = ModeloPedido;
        this.VistaComprasPendientes = VistaComprasPendientes;
        this.observableList = FXCollections.observableArrayList();
        this.VistaComprasPendientes.addBackButtonHandler((event -> WindowsController.previous()));
        this.VistaComprasPendientes.addAnularPedidoButtonHandler(new AnularPedidoButtonHandler());
        this.VistaComprasPendientes.addCalificarProductoButtonHandler(new CalificarProductoButtonHandler());
        this.VistaComprasPendientes.addCalificarVendedorButtonHandler(new CalificarVendedorButtonHandler());
        this.VistaComprasPendientes.addHabilitarSiHandler(new HabilitarSiHandler());
        this.VistaComprasPendientes.addHabilitarNoHandler(new HabilitarNoHandler());        
        cargarData();
        actualizarTabla();
    }
    
    private void cargarData() {
        ModeloPedido.buscarPedidosPendientes(ControladorLogin.comp_id, this.observableList);
    }
    
    private void actualizarTabla(){
        VistaComprasPendientes.getColId().setCellValueFactory(new PropertyValueFactory<>("idPedido"));
        VistaComprasPendientes.getColPrecio().setCellValueFactory(new PropertyValueFactory<>("costo"));
        VistaComprasPendientes.getColCant().setCellValueFactory(new PropertyValueFactory<>("cantidadPedida"));
        VistaComprasPendientes.getColFP().setCellValueFactory(new PropertyValueFactory<>("fechaPedido"));
        VistaComprasPendientes.getColFE().setCellValueFactory(new PropertyValueFactory<>("fechaEntrega"));
        VistaComprasPendientes.getColLE().setCellValueFactory(new PropertyValueFactory<>("lugarEntrega"));
        VistaComprasPendientes.getColV().setCellValueFactory(new PropertyValueFactory<>("vendedor"));
        VistaComprasPendientes.getColP().setCellValueFactory(new PropertyValueFactory<>("product"));
        VistaComprasPendientes.getPedidos().setItems(observableList);
    }
     
    private class AnularPedidoButtonHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            if (VistaComprasPendientes.validarSeleccion()){
                MensajesAcciones.nadaQueAnular(); 
            }else if (observableList.isEmpty()){
                MensajesAcciones.accionEnTablaPedidosVacia();
            }else{
                if(MensajesAcciones.confirmacionAnularPedido()){
                    ModeloPedido.anular(); 
                }else{
                    MensajesAcciones.PedidoFallido("anulado");
                }
            }
        }        
    }
    
    private class CalificarProductoButtonHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            boolean noSeleccionaCalificacion = VistaComprasPendientes.getLblCalifV().equals("");
            boolean hayPedidosPendientes = observableList.isEmpty();
            boolean isSelectedItem = VistaComprasPendientes.validarSeleccion();
            if (isSelectedItem || hayPedidosPendientes || noSeleccionaCalificacion){
                MensajesAcciones.accionEnTablaPedidosVacia();
            }else{
                Pedido pedido = VistaComprasPendientes.getPed();
                Producto p = pedido.getProduct();
                CalificacionProducto cp = new CalificacionProducto();
                p.setCalificacion(p.getCalificacion());
                String s = VistaComprasPendientes.getLblCalifP();
                int prom = cp.getPromedioP((int)(Double.parseDouble(s)), p.getCalificacion());
                if (cp.modificarCalificacionProducto(prom, p.getIdProducto())){
                    MensajesAcciones.calificacionExitosa("producto");
                }else{
                    MensajesAcciones.calificacionFallida("producto");
                }
            }
        }
    }
    
    private class CalificarVendedorButtonHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            boolean noSeleccionaCalificacion = VistaComprasPendientes.getLblCalifV().equals("");
            boolean hayPedidosPendientes = observableList.isEmpty();
            boolean isSelectedItem = VistaComprasPendientes.validarSeleccion();
            if (isSelectedItem || hayPedidosPendientes || noSeleccionaCalificacion){
                MensajesAcciones.accionEnTablaPedidosVacia();
            }else{
                Pedido pedido = VistaComprasPendientes.getPed();
                Vendedor v = pedido.getVendedor();
                CalificacionVendedor cv = v.getCalificacionV();
                String s = VistaComprasPendientes.getLblCalifV();
                int prom = cv.getPromedioV((int)(Double.parseDouble(s)), cv.getCalificacionV());
                if (cv.modificarCalificacionVendedor(prom,v.getIdVendedor())){
                    MensajesAcciones.calificacionExitosa("vendedor");
                }else{
                    MensajesAcciones.calificacionFallida("vendedor");
                }
            }
        }
    }
    
    private class HabilitarSiHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            if (VistaComprasPendientes.validarSeleccion() || observableList.isEmpty()){
                MensajesAcciones.accionEnTablaPedidosVacia();
            }else{
                MensajesAcciones.estadoPedidoCambiado("entregado");
                ModeloPedido.pedidoExitoso();
            }
        }
    }
    
    private class HabilitarNoHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            if (VistaComprasPendientes.validarSeleccion() || observableList.isEmpty()){
                MensajesAcciones.accionEnTablaPedidosVacia();
            }else{
                if (MensajesAcciones.confirmacionAnularPedido()){
                    ModeloPedido.anular();
                }else{
                    MensajesAcciones.PedidoFallido("anulado");
                }
            }
        }
    }
}