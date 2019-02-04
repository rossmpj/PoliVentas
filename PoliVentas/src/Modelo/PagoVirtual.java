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
import java.util.ArrayList;
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

    /**
     * Método pagar para la forma de pago virtual
     *
     * @param ci_cel idComprador
     * @param monto valor a pagar total
     * @return
     */
    @Override
    public boolean pagar(String ci_cel, double monto) {
        if ((d.obtenerSaldo(ci_cel) > -1) && (d.obtenerSaldo(ci_cel) > monto)) {
            this.descontarSaldo(ci_cel, monto);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que permite descontar el saldo del comprador
     *
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

    /**
     * Para Junit Test, Simulacion de pagar
     */
    public boolean pagar(Comprador d, String ci_cel, double monto, ArrayList<Comprador> c) {
        if ((d.getSaldo() > -1) && (d.getSaldo() > monto)) {
            this.descontarSaldo(ci_cel, monto, c);
            return true;
        } else {
            return false;
        }

    }

    /**
     * Para Junit Test, Simulacion de decontar saldo a comprador
     */
    public double descontarSaldo(String ci_cel, double monto, ArrayList<Comprador> c) {
        for (Comprador d : c) {
            if (d.getId_comprador().equals(ci_cel)) {
                return d.getSaldo() - monto;
            }
        }
        return -1;
    }   
}
