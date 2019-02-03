package Controlador.Comprador;

import Auxiliares.DBConnection;
import Auxiliares.MensajesAcciones;
import Controlador.Principal.ControladorLogin;
import Controlador.Principal.WindowsController;
import Modelo.CalificacionProducto;
import Modelo.CalificacionVendedor;
import Modelo.Comprador;
import Modelo.Pedido;
import Modelo.Producto;
import Vista.Comprador.VistaComprasPendientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import Modelo.Vendedor;
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
        String id = ControladorLogin.comp_id;
        System.out.println("id: "+id);
        ModeloPedido.buscarPedidosPendientes(this.observableList);
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
            Pedido pedido = VistaComprasPendientes.getPed();
            ModeloPedido.anular();
        }        
    }
    
    private class CalificarProductoButtonHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            Pedido pedido = VistaComprasPendientes.getPed();
            Producto p = pedido.getProduct();
            CalificacionProducto cp = new CalificacionProducto();
            p.setCalificacion(p.getCalificacion());
            String s = VistaComprasPendientes.getLblCalifP();
            System.out.println(s);       
            System.out.println(p.getCalificacion());
            System.out.println(cp);
            int prom = cp.getPromedioP((int)(Double.parseDouble(s)), p.getCalificacion());
            System.out.println(prom);
            System.out.println(p.getIdProducto());
            cp.modificarCalificacionProducto(prom);
        }
    }
    
    private class CalificarVendedorButtonHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            Pedido pedido = VistaComprasPendientes.getPed();
            Vendedor v = pedido.getVendedor();
            CalificacionVendedor cv = v.getCalificacionV();
            String s = VistaComprasPendientes.getLblCalifV();
            System.out.println(s);       
            System.out.println(cv.getCalificacionV());
            int prom = cv.getPromedioV((int)(Double.parseDouble(s)), cv.getCalificacionV());
            System.out.println(prom);
            
            System.out.println("idv:"+v.getIdVendedor());
            cv.modificarCalificacionVendedor(prom);
        }
    }
    
    private class HabilitarSiHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            Pedido pedido = VistaComprasPendientes.getPed();
            ModeloPedido.pedidoExitoso();
        }
    }
    
    private class HabilitarNoHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            Pedido pedido = VistaComprasPendientes.getPed();
            ModeloPedido.anular();
        }
    }
}