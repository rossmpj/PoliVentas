/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Administrador;

import Controlador.Principal.WindowsController;
import Modelo.Producto;
import Vista.Administrador.VistaInfoProducto;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorInfoProducto {
    
    private final Producto ModeloProducto;
    private final VistaInfoProducto VistaNuevoProducto;

    public ControladorInfoProducto(Producto ModeloProducto, VistaInfoProducto VistaNuevoProducto) {
        this.ModeloProducto = ModeloProducto;
        this.VistaNuevoProducto = VistaNuevoProducto;
        
        this.VistaNuevoProducto.addBackButtonHandler((event -> WindowsController.previous()));
    }
    
}
