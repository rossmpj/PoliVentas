/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Comprador;

import Modelo.Producto;
import Vista.Principal.ArticulosMasBuscados;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorArticulosMasBuscados {
    
    private final Producto ModeloProducto;
    private final ArticulosMasBuscados VistaArticulosMasBuscados;

    public ControladorArticulosMasBuscados(Producto ModeloProducto, ArticulosMasBuscados VistaArticulosMasBuscados) {
        this.ModeloProducto = ModeloProducto;
        this.VistaArticulosMasBuscados = VistaArticulosMasBuscados;
    }
    
}
