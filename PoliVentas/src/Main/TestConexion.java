/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Auxiliares.DBConnection;
import static Auxiliares.DBConnection.llenar;

/**
 *
 * @author ROSA
 */
public class TestConexion {
    
    public static void main(String[] args){
        DBConnection e = DBConnection.getInstance();
        llenar(e.getConnection());
    }
}
