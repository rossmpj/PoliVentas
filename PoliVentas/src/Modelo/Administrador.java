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

    private final String modificarUser = "update db_poliventas.tb_usuario set nombres=?,apellidos=?,telefono=?,whatsapp=?"
            + ",email=?,matricula=?,direccion=?, usuario=?, contrasena=? where ci_usuario= ?";
    private final String eliminarUser = "update db_poliventas.tb_usuario set estado=? where ci_usuario=?";
    private final String consultarUser = "select * from db_poliventas.tb_usuario where CONCAT(nombres,' ',apellidos) = ? OR ci_usuario=? "; // 

    public Administrador() {
         CONNECTION.conectar();
    }

    public Administrador(String cedula, String nombres, String apellidos, String telefono,
            String direccion,boolean whatsapp, String matricula, String email) {
        super(cedula, nombres, apellidos, telefono,direccion ,whatsapp, matricula,email);
    }

    public boolean modificarDatosCliente(Usuario user) {
        try {
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(modificarUser);
            ingreso.setString(1, user.getNombres().toLowerCase());
            ingreso.setString(2, user.getApellidos().toLowerCase());
            ingreso.setString(3, user.getTelefono());
            ingreso.setBoolean(4, user.isWhatsapp());
            ingreso.setString(5, user.getMatricula());
            ingreso.setString(6, user.getEmail());
            ingreso.setString(7, user.getDireccion());
            ingreso.setString(8, user.getUsuario());
            ingreso.setString(9, user.getContrasena());
            ingreso.setString(10, user.getCedula());
            ingreso.executeUpdate();
            System.out.println("Actualizacion exitosa cliente...");
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return false;
        } finally {
            CONNECTION.desconectar();
        }
    }

    public boolean eliminarUsuario(Usuario user) {
        try {
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(eliminarUser);
            ingreso.setBoolean(1, false);
            ingreso.setString(2, user.getCedula());
            ingreso.executeUpdate();
            System.out.println("Actualizacion exitosa...");
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return false;
        } finally {
            CONNECTION.desconectar();
        }
    }

    public void consultarUsuario(String busqueda, List<Usuario> lista) {
        try {
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consultarUser);
            ingreso.setString(1, busqueda);
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
                                resultado.getString("contrasena")));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }

    }
}
