/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Administrador;

import Controlador.Principal.WindowsController;
import Modelo.Producto;
import Modelo.Usuario;
import Vista.Administrador.AdministradorOptions;
import Vista.Administrador.VistaBuscarProducto;
import Vista.Administrador.VistaBuscarUsuario;
import Vista.Administrador.VistaInfoProducto;
import Vista.Administrador.VistaInfoUsuario;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorAdministradorOptions {
    
    private final AdministradorOptions VistaAdministradorOptions;

    public ControladorAdministradorOptions(AdministradorOptions VistaAdministradorOptions) {
        
        this.VistaAdministradorOptions = VistaAdministradorOptions;
        
        this.VistaAdministradorOptions.addNuevoUsuarioButtonHandler(new NuevoUsuarioButtonHandler());
        this.VistaAdministradorOptions.addBuscarUsuarioButtonHandler(new BuscarUsuarioButtonHandler());
        this.VistaAdministradorOptions.addNuevoProductoButtonHandler(new NuevoProductoButtonHandler());
        this.VistaAdministradorOptions.addBuscarProductoButtonHandler(new BuscarProductoButtonHandler());
    }
    
    private class NuevoUsuarioButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            Usuario usuario = new Usuario();
            VistaInfoUsuario nuevoUsuarioView = new VistaInfoUsuario(true, "C7E7E0", "Ingreso nuevo usuario");
            ControladorInfoUsuario controladorNuevoUsuario = new ControladorInfoUsuario(usuario, nuevoUsuarioView);
            
            WindowsController.next(VistaAdministradorOptions, nuevoUsuarioView);
        
        }
        
    }
    
    private class BuscarUsuarioButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            Usuario usuario = new Usuario();
            VistaBuscarUsuario buscarUsuarioView = new VistaBuscarUsuario("A8ECDD");
            ControladorBuscarUsuario controladorBuscarUsuario = new ControladorBuscarUsuario(usuario, buscarUsuarioView);
            
            WindowsController.next(VistaAdministradorOptions, buscarUsuarioView);
        }
        
    }
    
    private class NuevoProductoButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            Producto producto = new Producto();
            VistaInfoProducto nuevoProductoView = new VistaInfoProducto(true, "81F7D8", "Ingreso nuevo Producto");
            ControladorInfoProducto controladorNuevoProducto = new ControladorInfoProducto(producto, nuevoProductoView);
            
            WindowsController.next(VistaAdministradorOptions, nuevoProductoView);
            
        }
        
    }
    
    private class BuscarProductoButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            
            Producto producto = new Producto();
            VistaBuscarProducto buscarProductoView = new VistaBuscarProducto("51A7C1");
            ControladorBuscarProducto controladorBuscarProducto = new ControladorBuscarProducto(producto, buscarProductoView);
            
            WindowsController.next(VistaAdministradorOptions, buscarProductoView);
            
        }
        
    }
    
}
