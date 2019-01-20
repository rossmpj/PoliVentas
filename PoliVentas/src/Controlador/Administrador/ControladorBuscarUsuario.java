/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Administrador;

import Controlador.Principal.WindowsController;
import Modelo.Usuario;
import Vista.Administrador.VistaBuscarUsuario;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorBuscarUsuario {
    
    private final Usuario ModeloUsuario;
    private final VistaBuscarUsuario VistaBuscarUsuario;

    public ControladorBuscarUsuario(Usuario ModeloUsuario, VistaBuscarUsuario VistaBuscarUsuario) {
        this.ModeloUsuario = ModeloUsuario;
        this.VistaBuscarUsuario = VistaBuscarUsuario;
        
        this.VistaBuscarUsuario.addBackButtonHandler((event -> WindowsController.previous()));
    }
    
}
