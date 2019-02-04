/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Modelo.Pago.CONNECT;
import static Modelo.Pago.LOG;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author Rosa
 */
public class PagoVirtual implements Pago {

    private final Comprador d;

    /**
     * Constructor de la clase
     */
    public PagoVirtual() {
        d = new Comprador();
    }

    @Override
    public boolean pagar(String ci_cel, double monto) {
        System.out.println("Saldo disp: "+d.obtenerSaldo(ci_cel));
        System.out.println();
        if ((d.obtenerSaldo(ci_cel) > -1) && (d.obtenerSaldo(ci_cel) > monto)) {
            this.descontarSaldo(ci_cel, monto);
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Método que permite descontar el saldo del comprador
     * @param ci_cel, identificacion del comprador
     * @param monto, la cantidad a pagar por el pedido 
     */
    public void descontarSaldo(String ci_cel, double monto) {
        try {
            CONNECT.conectar();
            String consulta = "{call  descontarSaldo (?,?)}";
            try (CallableStatement sp = CONNECT.getConnection().prepareCall(consulta)) {
                sp.setString(1, ci_cel);
                sp.setDouble(2, monto);
                sp.execute();
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECT.desconectar();
        }

    }
}
