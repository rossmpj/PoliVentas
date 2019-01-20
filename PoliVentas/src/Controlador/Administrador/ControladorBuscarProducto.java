/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Administrador;

import Controlador.Principal.WindowsController;
import Modelo.Producto;
import Vista.Administrador.VistaBuscarProducto;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorBuscarProducto {
    
    private final Producto ModeloProducto;
    private final VistaBuscarProducto VistaBuscarProducto;

    public ControladorBuscarProducto(Producto ModeloProducto, VistaBuscarProducto VistaBuscarProducto) {
        this.ModeloProducto = ModeloProducto;
        this.VistaBuscarProducto = VistaBuscarProducto;
        
        this.VistaBuscarProducto.addBackButtonHandler((event -> WindowsController.previous()));
    }
    
}
