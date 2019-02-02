package Controlador.Vendedor;

import Controlador.Principal.ControladorLogin;
import Controlador.Principal.WindowsController;
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
    
    private class CerrarSesionButtonHandler implements EventHandler {
        @Override
        public void handle(Event event) {        
            PaneLogin loginView = new PaneLogin();
            ControladorLogin controladorLogin = new ControladorLogin(loginView);
            WindowsController.next(VistaVendedorOptions, loginView);
        }  
    }
}
