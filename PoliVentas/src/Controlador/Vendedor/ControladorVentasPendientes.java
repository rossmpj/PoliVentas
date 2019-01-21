/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Vendedor;

import Controlador.Principal.WindowsController;
import Modelo.Pedido;
import Vista.Principal.Vista;
import Vista.Vendedor.VentasPendientes;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorVentasPendientes{
    
    private final Pedido ModeloPedido;
    private final VentasPendientes VistaVentasPendientes;

    public ControladorVentasPendientes(Pedido ModeloPedido, VentasPendientes VistaVentasPendientes) {
        
        this.ModeloPedido = ModeloPedido;
        this.VistaVentasPendientes = VistaVentasPendientes;
        
        VistaVentasPendientes.addBackButtonHandler((event -> WindowsController.previous()));
        
    }
    
    
}
