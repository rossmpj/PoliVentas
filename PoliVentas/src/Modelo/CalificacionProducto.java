package Modelo;

import Auxiliares.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rosy
 */
public class CalificacionProducto {
    private String idCalificacionP;
    private int calificacionP;
    private String idProducto;
    private String idcomprador;

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

        public boolean modificarCalificacionProducto(int calif) {
        DBConnection conexion = DBConnection.getInstance();
        conexion.conectar();
        try {
            String consulta = "UPDATE tb_calificacion_producto SET calificacion_producto = ? WHERE id_producto = ?";
            PreparedStatement modifica = conexion.getConnection().prepareStatement(consulta);
            modifica.setString(1, String.valueOf(calif));
            modifica.setString(2, this.getIdCalificacionP());
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

}