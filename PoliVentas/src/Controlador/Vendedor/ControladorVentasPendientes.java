/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Vendedor;

import Controlador.Principal.ControladorLogin;
import Controlador.Principal.WindowsController;
import Modelo.Pedido;
import Vista.Vendedor.VentasPendientes;
import Vista.Vendedor.VistaFechaPedido;
import Vista.Vendedor.VistaMapa;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorVentasPendientes{
    
    private final VentasPendientes VistaVentasPendientes;

    public ControladorVentasPendientes(VentasPendientes VistaVentasPendientes) {
        
        this.VistaVentasPendientes = VistaVentasPendientes;
        
        this.VistaVentasPendientes.addBackButtonHandler((event -> WindowsController.previous()));
        this.VistaVentasPendientes.addFechaEntregaButtonHandler(new FechaEntregaButtonHandler());
        this.VistaVentasPendientes.addAnularVentaButtonHandler(new AnularVentaButtonHandler());
        this.VistaVentasPendientes.addVerMapaButtonHandler(new VerMapaButtonHandler());
        refreshView();
    }

    private class FechaEntregaButtonHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            
            TableView<Pedido> pedidos = VistaVentasPendientes.getTablaPedidos();
            
            Pedido ModeloPedido = pedidos.getSelectionModel().getSelectedItem();
            
            Alert alert;
            
            if(ModeloPedido == null){
                
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Noy hay nada que cambiar");
                alert.setContentText("Debes seleccionar en la tabla el pedido que quieres modificar.");
                alert.showAndWait();
                return;
            
            }
            
            VistaFechaPedido fechaPedidoView = new VistaFechaPedido();
            ControladorFechaPedido controladorFechaPedido = new ControladorFechaPedido(ModeloPedido, fechaPedidoView);
            WindowsController.next(VistaVentasPendientes, fechaPedidoView);
            
        }
    }
    
    private class AnularVentaButtonHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            
            TableView<Pedido> pedidos = VistaVentasPendientes.getTablaPedidos();
            
            Pedido ModeloPedido = pedidos.getSelectionModel().getSelectedItem();
            
            Alert alert;
            
            if(ModeloPedido == null){
                
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Noy hay nada que anular");
                alert.setContentText("Debes seleccionar en la tabla el pedido que quieres anular.");
                alert.showAndWait();
                return;
            
            }
            
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Mensaje de confirmación");
            alert.setHeaderText("¿Estás seguro de anular el pedido seleccionado?");
            alert.setContentText(ModeloPedido.toString());
            alert.showAndWait();
            
            ButtonType result = alert.getResult();
            
            if(result == ButtonType.OK || result == ButtonType.YES){
                
                ModeloPedido.anular();
                refreshView();
                
            }
        
        }
        
    }
    
    private class VerMapaButtonHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            
            TableView<Pedido> pedidos = VistaVentasPendientes.getTablaPedidos();
            
            Pedido ModeloPedido = pedidos.getSelectionModel().getSelectedItem();
            
            
            if(ModeloPedido == null){
                
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Información");
                alert.setHeaderText("Noy hay nada que mostrar");
                alert.setContentText("Debes seleccionar en la tabla el pedido que quieres ver en el mapa.");
                alert.showAndWait();
                return;
            
            }
            
            VistaMapa mapaView = new VistaMapa();
            ControladorMapa controladorMapa = new ControladorMapa(ModeloPedido, mapaView);
            
            WindowsController.next(VistaVentasPendientes, mapaView);
        
        }
        
    }
    
    private void refreshView(){
        
        TableView<Pedido> table = VistaVentasPendientes.getTablaPedidos();
        ObservableList<Pedido> list = Pedido.getPedidosPendientesPorVendedor(ControladorLogin.vend_id);
        table.setItems(list);
        
    }
}
