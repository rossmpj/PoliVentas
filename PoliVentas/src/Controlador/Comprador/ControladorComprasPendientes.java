/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Comprador;

import Controlador.Principal.WindowsController;
import Modelo.Pedido;
import Vista.Comprador.PaneComprasPendientes;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorComprasPendientes {
    
    private final Pedido ModeloPedido;
    private final PaneComprasPendientes VistaComprasPendientes;

    public ControladorComprasPendientes(Pedido ModeloPedido, PaneComprasPendientes VistaComprasPendientes) {
        
        this.ModeloPedido = ModeloPedido;
        this.VistaComprasPendientes = VistaComprasPendientes;
        
        this.VistaComprasPendientes.addBackButtonHandler((event -> WindowsController.previous()));
        
    }
    
    
    
}
