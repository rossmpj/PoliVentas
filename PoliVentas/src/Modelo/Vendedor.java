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
public class Vendedor extends Comprador{

    /**
     * Constructor por defecto
     */
    public Vendedor() {
    }

    /**
     * Constructor con parámetros del vendedor
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
    public Vendedor(String nombres, String apellidos, String telefono, 
                    boolean whatsapp, String email, String direccion, String cedula, 
                    String matricula, Usuario rol) {
        super(nombres, apellidos, telefono, whatsapp, email, direccion, cedula, matricula, rol);
    }
       
}