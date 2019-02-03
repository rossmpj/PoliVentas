package Controlador.Vendedor;

import Controlador.Comprador.ControladorArticulosMasBuscados;
import Controlador.Comprador.ControladorBusquedaSencilla;
import Controlador.Comprador.ControladorComprasPendientes;
import Controlador.Principal.ControladorLogin;
import Controlador.Principal.WindowsController;
import Modelo.Pedido;
import Modelo.Producto;
import Vista.Comprador.VistaBusquedaSencilla;
import Vista.Comprador.VistaComprasPendientes;
import Vista.Principal.ArticulosMasBuscados;
import Vista.Principal.PaneLogin;
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
        this.VistaVendedorOptions.addCerrarSesionButtonHandler(new CerrarSesionButtonHandler());
        this.VistaVendedorOptions.addVentasPendientesButtonHandler(new VentasPendientesButtonHandler());
        this.VistaVendedorOptions.addMisProductosButtonHandler(new MisProductosButtonHandler());
        this.VistaVendedorOptions.addBusquedaSencillaButtonHandler(new BusquedaSencillaButtonHandler());
        this.VistaVendedorOptions.addComprasPendientesButtonHandler(new ComprasPendientesButtonHandler());
        this.VistaVendedorOptions.addArticulosMasBuscadosButtonHandler(new ArticulosMasBuscadosButtonHandler());
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

    private class BusquedaSencillaButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            Producto producto = new Producto();
            VistaBusquedaSencilla busquedaSencillaView = new VistaBusquedaSencilla();
            ControladorBusquedaSencilla controladorVentasPendientes = new ControladorBusquedaSencilla(producto, busquedaSencillaView);
            WindowsController.next(VistaVendedorOptions, busquedaSencillaView);
        }
        
    }
    
    private class ComprasPendientesButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            Pedido pedido = new Pedido();
            VistaComprasPendientes comprasPendientesView = new VistaComprasPendientes();
            ControladorComprasPendientes controladorComprasPendientes = new ControladorComprasPendientes(pedido, comprasPendientesView);  
            WindowsController.next(VistaVendedorOptions, comprasPendientesView);
        }
        
    }
    
    private class ArticulosMasBuscadosButtonHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            Producto producto = new Producto();
            ArticulosMasBuscados articulosMasBuscadosView = new ArticulosMasBuscados(true);
            ControladorArticulosMasBuscados controladorArticulosMasBuscados = new ControladorArticulosMasBuscados(producto, articulosMasBuscadosView);
            
            WindowsController.next(VistaVendedorOptions, articulosMasBuscadosView);
            //CompradorOptionsView.getRoot().getScene().setRoot(articulosMasBuscadosView.getRoot());
        }   
    }
    
    private class CerrarSesionButtonHandler implements EventHandler {
        @Override
        public void handle(Event event) {        
            PaneLogin loginView = new PaneLogin();
            ControladorLogin controladorLogin = new ControladorLogin(loginView);
            WindowsController.next(VistaVendedorOptions, loginView);
        }  
    }
}
