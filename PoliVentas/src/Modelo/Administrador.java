/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author Rosa
 */
public class Administrador extends Usuario {

    private String id_administrador;

    private final String modificarUser = "update db_poliventas.tb_usuario set nombres=?,apellidos=?,telefono=?,direccion=?,whatsapp=?, matricula=?,"
            + " email=?, username=?, contrasena=?, estado=? where ci_usuario=?";

    private final String eliminarUser = "update db_poliventas.tb_usuario set estado=? where ci_usuario=?";
    private final String consultarUser = "select * from db_poliventas.tb_usuario where CONCAT(nombres,' ',apellidos) like ? OR ci_usuario=? ";
    private final String consultarP = "select * from db_poliventas.tb_producto p LEFT JOIN db_poliventas.tb_calificacion_producto c on p.id_producto=c.id_producto where p.nombre like ? OR p.id_producto=? ";

    /**
     * Constructor por defecto
     */
    public Administrador() {
    }

    /**
     * Constructor de la clase
     */
    public Administrador(String cedula, String nombres, String apellidos, String telefono,
            String direccion, boolean whatsapp, String matricula, String email, String usuario, String contra, boolean es) {
        super(cedula, nombres, apellidos, telefono, direccion, whatsapp, matricula, email, usuario, contra, es);
        this.id_administrador = "a" + cedula;
    }

    public String getId_administrador() {
        return id_administrador;
    }

    /**
     * Método que permite modificar un usuario
     *
     * @param user Usuario
     * @return true si se modificó correctamente, false en caso contrario
     */
    public boolean modificarUsuario(Usuario user) {
        try {
            CONNECTION.conectar();
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(modificarUser);
            ingreso.setString(1, user.getNombres().toLowerCase());
            ingreso.setString(2, user.getApellidos().toLowerCase());
            ingreso.setString(3, user.getTelefono());
            ingreso.setString(4, user.getDireccion());
            ingreso.setBoolean(5, user.isWhatsapp());
            ingreso.setString(6, user.getMatricula());
            ingreso.setString(7, user.getEmail());
            ingreso.setString(8, user.getUsuario());
            ingreso.setString(9, user.getContrasena());
            ingreso.setBoolean(10, user.isEstado());
            ingreso.setString(11, user.getCedula());
            ingreso.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return false;
        } finally {
            CONNECTION.desconectar();
        }
    }

    /**
     * Método que permite eliminar el usuario true: Eliminado
     *
     * @param user
     * @return
     */
    public boolean eliminarUsuario(Usuario user) {
        try {
            CONNECTION.conectar();
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(eliminarUser);
            ingreso.setBoolean(1, true);
            ingreso.setString(2, user.getCedula());
            ingreso.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return false;
        } finally {
            CONNECTION.desconectar();
        }
    }

    /**
     * Método que permite obtener una lista de usuarios de acuerdo al parámetro
     *
     * @param busqueda, string
     * @param lista de objeto Usuario
     */
    public void consultarUsuario(String busqueda, List<Usuario> lista) {
        try {
            CONNECTION.conectar();
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consultarUser);
            ingreso.setString(1, "%" + busqueda + "%");
            ingreso.setString(2, busqueda);
            ResultSet resultado = ingreso.executeQuery();
            while (resultado.next()) {
                lista.add(
                        new Usuario(
                                resultado.getString("ci_usuario"),
                                resultado.getString("nombres"),
                                resultado.getString("apellidos"),
                                resultado.getString("telefono"),
                                resultado.getString("direccion"),
                                resultado.getBoolean("whatsapp"),
                                resultado.getString("matricula"),
                                resultado.getString("email"),
                                resultado.getString("username"),
                                resultado.getString("contrasena"),
                                resultado.getBoolean("estado")));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }
    }

     /**
     * Método para eliminar un producto
     * @param p Producto
     * @return true si se eliminó correctamente, false en caso contrario
     */
    public boolean eliminarProducto(Producto p) {
        return p.eliminarProducto();
    }

    /**
     * Metodo para modificar un producto
     * @param p Producto
     * @return true si se eliminó correctamente, false en caso contrario
     */
    public boolean modificarProducto(Producto p) {
        return p.modificarProducto();
    }

    /**
     * Método que permite buscar un producto en la base de datos
     * @param campo, String
     * @param lista, de Productos 
     */
    public void consultarProducto(String campo, List<Producto> lista) {
        try {
            CONNECTION.conectar();
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consultarP);
            ingreso.setString(1, "%" + campo + "%");
            ingreso.setString(2, campo);
            ResultSet resultado = ingreso.executeQuery();
            while (resultado.next()) {
                lista.add(
                        new Producto(
                                resultado.getString("p.id_producto"),
                                resultado.getString("p.nombre"),
                                resultado.getString("p.descripcion"),
                                resultado.getDouble("p.precio"),
                                resultado.getString("p.categoria"),
                                resultado.getInt("p.stock"),
                                resultado.getBoolean("p.estado"),
                                resultado.getInt("c.calificacion_producto"),
                                resultado.getString("p.id_vendedor")));

            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }

    }
}
