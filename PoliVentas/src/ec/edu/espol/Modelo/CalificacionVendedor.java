package ec.edu.espol.Modelo;

import ec.edu.espol.Auxiliares.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Rosy
 */
public class CalificacionVendedor {
    private String idCalificacionV;
    private int calificacionV;
    private String idVendedor;
    private String idComprador;
    
    /**
     * Constructor de la clase
     * @param idCalificacionV
     * @param calificacionV
     * @param vendedor
     * @param comprador
     */
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
    
    /**
     * Método que permite modificar la calificacion del vendedor
     * @param calif
     * @return 
     */
    public boolean modificarCalificacionVendedor(int calif, String id) {
        DBConnection conexion = DBConnection.getInstance();
        conexion.conectar();
        try {
            String consulta = "UPDATE tb_calificacion_vendedor SET calificacion_vendedor = ? WHERE id_vendedor = ?";
            PreparedStatement modifica = conexion.getConnection().prepareStatement(consulta);
            modifica.setString(1, String.valueOf(calif));
            modifica.setString(2, id);
            modifica.executeUpdate();
            return true;
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }
    
    public int getPromedioV(int c1, int c2){
        return (int) ((c1+c2)/2);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idCalificacionV);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CalificacionVendedor other = (CalificacionVendedor) obj;
        return Objects.equals(this.idCalificacionV, other.idCalificacionV);
    }
    
}