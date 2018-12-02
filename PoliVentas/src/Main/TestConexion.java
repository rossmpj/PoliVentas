/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Auxiliares.Conexion;
import static Auxiliares.Conexion.llenar;

/**
 *
 * @author ROSA
 */
public class TestConexion {
    
    public static void main(String[] args){
        Conexion e = new Conexion();
        e.conectar(); 
        llenar(e.getConexion());
        e.cerrarConexion(); 
    }
}
