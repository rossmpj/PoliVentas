package ec.edu.espol.Modelo;

import ec.edu.espol.Auxiliares.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

/**
 *
 * @author Rosy
 */
public class CalificacionProducto {
    private String idCalificacionP;
    private int calificacionP;
    private String idProducto;
    private String idcomprador;

    /**
     * Constructor de la clase
     * @param idCalificacionP
     * @param calificacionP
     * @param product
     * @param comprador 
     */
    public CalificacionProducto(String idCalificacionP, int calificacionP, 
            String product, String comprador) {
        this.idCalificacionP = idCalificacionP;
        this.calificacionP = calificacionP;
        this.idProducto = product;
        this.idcomprador = comprador;
    }
    
    public CalificacionProducto() {
    }

    public String getIdCalificacionP() {
        return idCalificacionP;
    }

    public void setIdCalificacionP(String idCalificacionP) {
        this.idCalificacionP = idCalificacionP;
    }

    public int getCalificacionP() {
        return calificacionP;
    }

    public void setCalificacionP(int calificacionP) {
        this.calificacionP = calificacionP;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getIdcomprador() {
        return idcomprador;
    }

    public void setIdcomprador(String idcomprador) {
        this.idcomprador = idcomprador;
    }

    @Override
    public String toString() {
        return "CalificacionProducto{" + "idCalificacionP=" + idCalificacionP + ", calificacionP=" + calificacionP + ", product=" + idProducto + ", comprador=" + idcomprador + '}';
    }

    /**
     * Método que permite modificar la calificacion de un producto
     * @param calif
     * @return 
     */
    public boolean modificarCalificacionProducto(int calif, String id) {
        DBConnection conexion = DBConnection.getInstance();
        conexion.conectar();
        try {
            String consulta = "UPDATE tb_calificacion_producto SET calificacion_producto = ? WHERE id_producto = ?";
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
    
    public int getPromedioP(int c1, int c2){
        return (int) ((c1+c2)/2);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.idCalificacionP);
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
        final CalificacionProducto other = (CalificacionProducto) obj;
        if (!Objects.equals(this.idCalificacionP, other.idCalificacionP)) {
            return false;
        }
        return true;
    }
    
}