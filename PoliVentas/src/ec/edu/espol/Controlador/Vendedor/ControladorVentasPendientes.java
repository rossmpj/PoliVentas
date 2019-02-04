/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Controlador.Vendedor;

import ec.edu.espol.Auxiliares.MensajesAcciones;
import ec.edu.espol.Controlador.Principal.ControladorLogin;
import ec.edu.espol.Controlador.Principal.WindowsController;
import ec.edu.espol.Modelo.Pedido;
import ec.edu.espol.Vista.Vendedor.VentasPendientes;
import ec.edu.espol.Vista.Vendedor.VistaFechaPedido;
import ec.edu.espol.Vista.Vendedor.VistaMapa;
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
            
            if(ModeloPedido == null)    MensajesAcciones.registroSinSeleccionar();
            
            else{
                VistaFechaPedido fechaPedidoView = new VistaFechaPedido();
                ControladorFechaPedido controladorFechaPedido = new ControladorFechaPedido(ModeloPedido, fechaPedidoView);
                WindowsController.next(VistaVentasPendientes, fechaPedidoView);
            }
            
        }
    }
    
    private class AnularVentaButtonHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            
            TableView<Pedido> pedidos = VistaVentasPendientes.getTablaPedidos();
            Pedido ModeloPedido = pedidos.getSelectionModel().getSelectedItem();
            
            if(ModeloPedido == null)    MensajesAcciones.registroSinSeleccionar();
            
            else{
                
                ButtonType result = MensajesAcciones.confirmacion("Se eliminará " + ModeloPedido.toString());

                if(result == ButtonType.OK || result == ButtonType.YES){

                    ModeloPedido.anular();
                    refreshView();
                }
            }
        }
    }
    
    private class VerMapaButtonHandler implements EventHandler{

        @Override
        public void handle(Event event) {
            
            TableView<Pedido> pedidos = VistaVentasPendientes.getTablaPedidos();
            Pedido ModeloPedido = pedidos.getSelectionModel().getSelectedItem();
            
            if(ModeloPedido == null)    MensajesAcciones.registroSinSeleccionar();
            
            else{
                VistaMapa mapaView = new VistaMapa();
                ControladorMapa controladorMapa = new ControladorMapa(ModeloPedido, mapaView);

                WindowsController.next(VistaVentasPendientes, mapaView);
            }
        }
    }
    
    private void refreshView(){
        
        TableView<Pedido> table = VistaVentasPendientes.getTablaPedidos();
        ObservableList<Pedido> list = Pedido.getPedidosPendientesPorVendedor(ControladorLogin.vend_id);
        table.setItems(list);
        
    }
}
