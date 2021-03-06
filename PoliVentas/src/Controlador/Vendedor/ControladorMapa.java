/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Vendedor;

import Controlador.Principal.WindowsController;
import Modelo.Pedido;
import Vista.Vendedor.VistaMapa;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorMapa {
    
    private final Pedido ModeloPedido;
    private final VistaMapa vistaMapa;

    public ControladorMapa(Pedido ModeloPedido, VistaMapa vistaMapa) {
        this.ModeloPedido = ModeloPedido;
        this.vistaMapa = vistaMapa;
        
        this.vistaMapa.addBackButtonHandler((event -> WindowsController.previous()));
        
        configureView();
    }
    
    private void configureView(){
        
        String path = "/" + ModeloPedido.getLugarEntrega() + ".png";
        vistaMapa.setMapa(path);
    }
    
}
