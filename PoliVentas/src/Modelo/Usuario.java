/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Auxiliares.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    protected Usuario rol; //revisar 
    protected static final DBConnection CONNECTION = DBConnection.getInstance();
    private static final Logger LOGGER = Logger.getLogger("Usuario Logger");

    public Usuario() {
    }
    
    public Usuario(String nombres, String apellidos, String telefono, 
                   boolean whatsapp, String email, String direccion, 
                   String cedula, String matricula) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.whatsapp = whatsapp;
        this.email = email;
        this.direccion = direccion;
        this.cedula = cedula;
        this.matricula = matricula;
    }
    
    public Usuario(String nombres, String apellidos, String telefono, 
                   boolean whatsapp, String email, String direccion, 
                   String cedula, String matricula, Usuario rol) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.whatsapp = whatsapp;
        this.email = email;
        this.direccion = direccion;
        this.cedula = cedula;
        this.matricula = matricula;
        this.rol = rol;
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

    public Usuario getRol() {
        return rol;
    }

    public void setRol(Usuario rol) {
        this.rol = rol;
    }
    
    public boolean create(){
        
        if(nombres != null && apellidos != null && email != null && 
                direccion != null && cedula != null && matricula != null){
            
            CONNECTION.conectar();
            
            try{
                
                Statement statement = CONNECTION.getConnection().createStatement();
                statement.executeQuery("INSERT INTO db_poliventas.tb_usuario values("
                        + cedula + ", " + nombres + ", " + apellidos + ", " + telefono + ", " + 
                        whatsapp + ", " + matricula + ", " + email + ")");
                
                return true;
                
            } catch(SQLException e){
                
                LOGGER.log(Level.SEVERE, e.getMessage());
                return false;
                
            } finally{
                
                CONNECTION.desconectar();
                
            }
        }
        
        return false;
    }
    
    public Usuario get(String id){
        
        CONNECTION.conectar();
        
        try{

            Statement statement = CONNECTION.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM db_poliventas.tb_usuario WHERE ci_usuario = " + id);
            
            if(result.next()){
                
                return new Usuario(result.getString("nombres"), result.getString("apellidos"), result.getString("telefono"),
                        result.getBoolean("whatsapp"), result.getString("email"), result.getString("direccion"),
                        result.getString("cedula"), result.getString("matricula"));
            }
            
            return null;

        } catch(SQLException e){

            LOGGER.log(Level.SEVERE, e.getMessage());
            return null;

        } finally{

            CONNECTION.desconectar();

        }
    }

    @Override
    public String toString() {
        return "Usuario" + " Nombres:" + nombres + ", apellidos:" + apellidos 
                + ", telefono:" + telefono + ", whatsapp:" + whatsapp 
                + ", email:" + email + ", direccion:" + direccion 
                + ", cedula:" + cedula + ", matricula:" + matricula + ", rol:" + rol;
    }

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
        hash = 97 * hash + Objects.hashCode(this.rol);
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
        return Objects.equals(this.rol, other.rol);
    }
}