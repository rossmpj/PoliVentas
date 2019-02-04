package Modelo;

import static Modelo.Usuario.CONNECTION;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author Rosa
 */
public class Comprador extends Usuario {

    protected CalificacionVendedor calificacionV;
    protected String id_comprador;
    protected double saldo;

    /**
     * Constructor por defecto para el comprador
     */
    public Comprador() {
    }

    /**
     * Constructor con parametros para el comprador
     */
    public Comprador(String cedula, String nombres, String apellidos, String telefono,
            String direccion, boolean whatsapp, String matricula, String email, String usuario, String contra, boolean es) {
        super(cedula, nombres, apellidos, telefono, direccion, whatsapp, matricula, email, usuario, contra, es);
        this.id_comprador = "c" + cedula;
    }

    public String getId_comprador() {
        return id_comprador;
    }

    public void setId_comprador(String id_comprador) {
        this.id_comprador = id_comprador;
    }

    public CalificacionVendedor getCalificacionV() {
        return calificacionV;
    }

    public void setCalificacionV(CalificacionVendedor calificacionV) {
        this.calificacionV = calificacionV;
    }

    /**
     * Método que permite obtener el saldo actual del Comprador para realizar
     * compras
     *
     * @param ci_cel, numero de identificacion del comprador
     * @return valor del saldo virtual
     */
    public double obtenerSaldo(String ci_cel) {
        try {
            double s = 0;
            CONNECTION.conectar();
            String consulta = "select saldo from tb_comprador where id_comprador= ?";
            PreparedStatement salida = CONNECTION.getConnection().prepareStatement(consulta);
            salida.setString(1, ci_cel);
            ResultSet resultado = salida.executeQuery();
            while (resultado.next()) {
                s = resultado.getDouble("saldo");
            }
            return s;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return -1;
        } finally {
            CONNECTION.desconectar();
        }
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

}
