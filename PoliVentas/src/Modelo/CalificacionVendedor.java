package Modelo;

import Auxiliares.DBConnection;
import Auxiliares.MensajesAcciones;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rosy
 */
public class CalificacionVendedor {
    private String idCalificacionV;
    private int calificacionV;
    private String idVendedor;
    private String idComprador;

    public CalificacionVendedor(String idCalificacionV, int calificacionV, 
            String vendedor, String comprador) {
        this.idCalificacionV = idCalificacionV;
        this.calificacionV = calificacionV;
        this.idVendedor = vendedor;
        this.idComprador = comprador;
    }
    public CalificacionVendedor() {
    }

    public String getIdCalificacionV() {
        return idCalificacionV;
    }

    public void setIdCalificacionV(String idCalificacionV) {
        this.idCalificacionV = idCalificacionV;
    }

    public int getCalificacionV() {
        return calificacionV;
    }

    public void setCalificacionV(int calificacionV) {
        this.calificacionV = calificacionV;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getIdComprador() {
        return idComprador;
    }

    public void setIdComprador(String idComprador) {
        this.idComprador = idComprador;
    }

    @Override
    public String toString() {
        return "CalificacionVendedor{" + "idCalificacionV=" + idCalificacionV + ", calificacionV=" + calificacionV + ", vendedor=" + idVendedor + ", comprador=" + idComprador + '}';
    }
    
    public boolean modificarCalificacionVendedor(int calif) {
        DBConnection conexion = DBConnection.getInstance();
        conexion.conectar();
        try {
            String consulta = "UPDATE tb_calificacion_vendedor SET calificacion_vendedor = ? WHERE id_vendedor = ?";
            PreparedStatement modifica = conexion.getConnection().prepareStatement(consulta);
            modifica.setString(1, String.valueOf(calif));
            modifica.setString(2, this.getIdVendedor());
            int m = modifica.executeUpdate();
            if( m > 0){ 
                MensajesAcciones.CalificacionVendedorSi();
                System.out.println("modificación exitosa ...");
            }
            return true;
        } catch (SQLException ex) {
            MensajesAcciones.CalificacionVendedorNo();
            System.out.println("EXCEPCION: " + ex.getMessage());
            return false;
        } finally {
            conexion.desconectar();
        }
    }
    public int getPromedioV(int c1, int c2){
        return (int) ((c1+c2)/2);
    }
}