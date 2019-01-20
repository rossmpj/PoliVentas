/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Administrador;

import Controlador.Principal.WindowsController;
import Modelo.Usuario;
import Vista.Administrador.VistaInfoUsuario;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorInfoUsuario {
    
    private final Usuario ModeloUsuario;
    private final VistaInfoUsuario VistaNuevoUsuario;

    public ControladorInfoUsuario(Usuario ModeloUsuario, VistaInfoUsuario VistaNuevoUsuario) {
        this.ModeloUsuario = ModeloUsuario;
        this.VistaNuevoUsuario = VistaNuevoUsuario;
        
        this.VistaNuevoUsuario.addBackButtonHandler((event -> WindowsController.previous()));
    }
    
    
    
}
