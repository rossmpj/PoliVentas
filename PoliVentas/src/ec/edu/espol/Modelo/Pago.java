/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Modelo;

import ec.edu.espol.Auxiliares.DBConnection;
import java.util.logging.Logger;

/**
 *
 * @author Rosa
 */
public interface Pago {

    static final DBConnection CONNECT = DBConnection.getInstance();
    static final Logger LOG = Logger.getLogger("Metodo de pago ");
    boolean pagar(String ci_cel,double monto);
}
