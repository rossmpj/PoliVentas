/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Vendedor;

import Modelo.Producto;
import Vista.Vendedor.NuevoProducto;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
class ControladorNuevoProducto {
    
    private final Producto ModeloProducto;
    private final NuevoProducto VistaMisProductos;

    public ControladorNuevoProducto(Producto ModeloProducto, NuevoProducto VistaNuevoProducto) {
        
        this.ModeloProducto = ModeloProducto;
        this.VistaMisProductos = VistaNuevoProducto;
        
    }
    
}
