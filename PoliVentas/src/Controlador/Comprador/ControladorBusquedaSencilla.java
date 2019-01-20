/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Comprador;

import Controlador.Principal.WindowsController;
import Modelo.Producto;
import Vista.Comprador.VistaBusquedaSencilla;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorBusquedaSencilla {
    
    private final Producto ModeloProducto;
    private final VistaBusquedaSencilla VistaBusquedaSencilla;

    public ControladorBusquedaSencilla(Producto ModeloProducto, VistaBusquedaSencilla VistaBusquedaSencilla) {
        this.ModeloProducto = ModeloProducto;
        this.VistaBusquedaSencilla = VistaBusquedaSencilla;
        
        this.VistaBusquedaSencilla.addBackButtonHandler((event -> WindowsController.previous()));
    }
    
}
