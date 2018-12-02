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
public class Comprador extends Usuario{

    /**
     * Constructor por defecto para el comprador
     */
    public Comprador() {
    }

    /**
     * Constructor con parametros para el comprador
     * @param nombres
     * @param apellidos
     * @param telefono
     * @param whatsapp
     * @param email
     * @param direccion
     * @param cedula
     * @param matricula
     * @param rol
     */
    public Comprador(String nombres, String apellidos, String telefono, 
                     boolean whatsapp, String email, String direccion, 
                     String cedula, String matricula, Usuario rol) {
        super(nombres, apellidos, telefono, whatsapp, email, direccion, cedula, matricula, rol);
    }
    
}