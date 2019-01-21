/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Vendedor;

import Controlador.Principal.WindowsController;
import Modelo.Pedido;
import Modelo.Producto;
import Vista.Principal.Vista;
import Vista.Vendedor.MisProductos;
import Vista.Vendedor.VendedorOptions;
import Vista.Vendedor.VentasPendientes;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorVendedorOptions{
    
    private final VendedorOptions VistaVendedorOptions;

    public ControladorVendedorOptions(VendedorOptions VistaVendedorOptions) {
        
        this.VistaVendedorOptions = VistaVendedorOptions;
        
        this.VistaVendedorOptions.addVentasPendientesButtonHandler(new VentasPendientesButtonHandler());
        this.VistaVendedorOptions.addMisProductosButtonHandler(new MisProductosButtonHandler());
    }
    
    private class VentasPendientesButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            VentasPendientes ventasPendientesView = new VentasPendientes();
            ControladorVentasPendientes controladorVentasPendientes = new ControladorVentasPendientes(ventasPendientesView);
            
            WindowsController.next(VistaVendedorOptions, ventasPendientesView);
            
        }
        
    }
    
    private class MisProductosButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            MisProductos misProductosView = new MisProductos();
            ControladorMisProductos controladorMisProductos = new ControladorMisProductos(misProductosView);
            
            WindowsController.next(VistaVendedorOptions, misProductosView);
            
        }
        
    }
    
}
