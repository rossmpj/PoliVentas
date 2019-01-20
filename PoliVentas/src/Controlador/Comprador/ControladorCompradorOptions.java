/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Comprador;

import Controlador.Principal.WindowsController;
import Modelo.Pedido;
import Modelo.Producto;
import Vista.Comprador.CompradorOptions;
import Vista.Comprador.VistaBusquedaSencilla;
import Vista.Comprador.VistaComprasPendientes;
import Vista.Principal.ArticulosMasBuscados;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorCompradorOptions {
    
    private final CompradorOptions CompradorOptionsView;

    public ControladorCompradorOptions(CompradorOptions CompradorOptionsView) {
        
        this.CompradorOptionsView = CompradorOptionsView;
        
        this.CompradorOptionsView.addBusquedaSencillaButtonHandler(new BusquedaSencillaButtonHandler());
        this.CompradorOptionsView.addComprasPendientesButtonHandler(new ComprasPendientesButtonHandler());
        this.CompradorOptionsView.addArticulosMasBuscadosButtonHandler(new ArticulosMasBuscadosButtonHandler());
        
    }

    private class BusquedaSencillaButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            Producto producto = new Producto();
            VistaBusquedaSencilla busquedaSencillaView = new VistaBusquedaSencilla();
            ControladorBusquedaSencilla controladorVentasPendientes = new ControladorBusquedaSencilla(producto, busquedaSencillaView);
            
            WindowsController.next(CompradorOptionsView, busquedaSencillaView);
        }
        
    }
    
    private class ComprasPendientesButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            Pedido pedido = new Pedido();
            VistaComprasPendientes comprasPendientesView = new VistaComprasPendientes();
            ControladorComprasPendientes controladorComprasPendientes = new ControladorComprasPendientes(pedido, comprasPendientesView);
            
            WindowsController.next(CompradorOptionsView, comprasPendientesView);
        }
        
    }
    
    private class ArticulosMasBuscadosButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            Producto producto = new Producto();
            ArticulosMasBuscados articulosMasBuscadosView = new ArticulosMasBuscados();
            ControladorArticulosMasBuscados controladorArticulosMasBuscados = new ControladorArticulosMasBuscados(producto, articulosMasBuscadosView);
            
            CompradorOptionsView.getRoot().getScene().setRoot(articulosMasBuscadosView.getRoot());
        }
        
    }
    
}
