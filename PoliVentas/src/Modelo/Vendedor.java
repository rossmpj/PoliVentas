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
     /*   
     * Constructor con parámetros del vendedor
     * @param nombres
     * @param apellidos
     * @param telefono
     * @param whatsapp
     * @param email
     * @param direccion
     * @param cedula
     * @param matricula
     */
    public Vendedor(String cedula, String nombres, String apellidos, String telefono,
            String direccion, boolean whatsapp, String matricula, String email) {
        super(cedula, nombres, apellidos, telefono, direccion, whatsapp, matricula, email);
    }      
}