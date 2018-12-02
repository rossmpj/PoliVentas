/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Rosa
 */
public class Administrador extends Usuario{

    public Administrador() {
    }

    public Administrador(String nombres, String apellidos, String telefono, 
                         boolean whatsapp, String email, String direccion, String cedula, 
                         String matricula) {
        super(nombres, apellidos, telefono, whatsapp, email, direccion, cedula, matricula);
    }

}