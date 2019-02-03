package Modelo;

import Auxiliares.DBConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rosa
 */
public class Usuario {

    protected String nombres;
    protected String apellidos;
    protected String telefono;
    protected boolean whatsapp;
    protected String email;
    protected String direccion;
    protected String cedula;
    protected String matricula;
    protected String usuario;
    protected String contrasena;
    protected boolean estado;
    protected static final DBConnection CONNECTION = DBConnection.getInstance();
    protected static final Logger LOGGER = Logger.getLogger("Usuario Logger");
    private final String insert = "INSERT INTO db_poliventas.tb_usuario values(?,?,?,?,?,?,?,?,?,?,?)";
    private final String insertaRolAdmin = "insert into db_poliventas.tb_administrador values (?,?) ";
    private final String insertaRolVend = "insert into db_poliventas.tb_vendedor values (?,?,?) ";
    private final String insertaRolCom = "insert into db_poliventas.tb_comprador values (?,?) ";

    /**
     * Constructor por defecto
     */
    public Usuario() {
    }

    /**
     *Constructor utilizado para almacenar en la base de datos
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param telefono
     * @param direccion
     * @param whatsapp
     * @param matricula
     * @param email
     * @param usuario
     * @param contrasena
     * @param estado, true si esta eliminado, false si esta activo
     */
    public Usuario(String cedula, String nombres, String apellidos, String telefono,
            String direccion, boolean whatsapp, String matricula, String email,
            String usuario, String contrasena, boolean estado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.whatsapp = whatsapp;
        this.email = email;
        this.direccion = direccion;
        this.cedula = cedula;
        this.matricula = matricula;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(boolean whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Metodo para registrar nuevo usuario
     * @return true si se registró sin inconvenientes, false en caso contrario
     */
    public boolean registrar() {
        try {
            CONNECTION.conectar();
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(insert);
            ingreso.setString(1, cedula);
            ingreso.setString(2, nombres.toLowerCase());
            ingreso.setString(3, apellidos.toLowerCase());
            ingreso.setString(4, telefono);
            ingreso.setString(5, direccion.toLowerCase());
            ingreso.setBoolean(6, whatsapp);
            ingreso.setString(7, matricula);
            ingreso.setString(8, email.toLowerCase());
            ingreso.setString(9, usuario.toLowerCase());
            ingreso.setString(10, contrasena.toLowerCase());
            ingreso.setBoolean(11, estado);
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
     * Almacena las referencias del usuario en la tabla administrador
     */
    public void almacenarRolAdministrador() {
        try {
            CONNECTION.conectar();
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(insertaRolAdmin);
            ingreso.setString(1, "a" + this.cedula);
            ingreso.setString(2, this.cedula);
            ingreso.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }

    }

    /**
     * Almacena las referencias del usuario en la tabla vendedor Primero se debe
     * almacenar el comprador, luego esto
     */
    public void almacenarRolVendedor() {
        try {
            CONNECTION.conectar();
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(insertaRolVend);
            ingreso.setString(1, "v" + this.cedula);
            ingreso.setString(2, this.cedula);
            ingreso.setString(3, "c" + this.cedula);
            ingreso.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }

    }

    /**
     * Almacena las referencias del usuario en la tabla Comprador
     */
    public void almacenarRolComprador() {
        try {
            CONNECTION.conectar();
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(insertaRolCom);
            ingreso.setString(1, "c" + this.cedula);
            ingreso.setString(2, this.cedula);
            ingreso.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        } finally {
            CONNECTION.desconectar();
        }

    }
    
    /**
     * Método que permite mostrar el rol al que pertenece el usuario
     * @return 
     */
     public String mostrarRol() {
        try {
            CONNECTION.conectar();
            String consulta = "{call  encontraRol (?,?)}";
            CallableStatement sp = CONNECTION.getConnection().prepareCall(consulta);
            sp.setString(1, this.getCedula());
            sp.registerOutParameter(2, Types.VARCHAR);
            sp.execute();
            String rol = sp.getString(2);
            sp.close();
            return rol;
        } catch (SQLException ex) {
           Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            CONNECTION.desconectar();
        }
    }

     /**
      * Soobrescritura del metodo toString
      * @return String con los datos del Usuario
      */
    @Override
    public String toString() {
        return "Usuario" + " Nombres:" + nombres + ", apellidos:" + apellidos
                + ", telefono:" + telefono + ", whatsapp:" + whatsapp
                + ", email:" + email + ", direccion:" + direccion
                + ", cedula:" + cedula + ", matricula:" + matricula;
    }

    /**
     * HashCode
     * @return int
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nombres);
        hash = 97 * hash + Objects.hashCode(this.apellidos);
        hash = 97 * hash + Objects.hashCode(this.telefono);
        hash = 97 * hash + (this.whatsapp ? 1 : 0);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.direccion);
        hash = 97 * hash + Objects.hashCode(this.cedula);
        hash = 97 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    /**
     * Sobreescritura del metodo equals
     * @param obj
     * @return 
     */
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
        final Usuario other = (Usuario) obj;
        if (this.whatsapp != other.whatsapp) {
            return false;
        }
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }
}
