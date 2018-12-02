/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ROSA
 */
public class Conexion {
    private Connection conexion ;
    private final String url = "jdbc:mysql://localhost:3306/db_poliventas?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String user = "root";
    private final String pass = "rmpincay";

    /**
     * Getter para la conexion
     * @return conexion a BD
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * Setter para conexion 
     * @param connexion
     */
    public void setConexion(Connection connexion) {
        this.conexion = connexion;
    }
    
    /**
     * Método de tipo void para establecer conexion con la Base de datos
     */
    public void conectar(){
        System.out.println("Conectando...");
        try{
            this.conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("Conectado!!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    	
    /**
     * Método para cerrar la conexion a la base de datos, no retorna nada
     */
    public void cerrarConexion(){
	try {
            conexion.close();
	} catch (SQLException e) {
            System.out.println(e.getMessage());
	}
    }
    
    /**
     * Método de prueba
     * @param c: recibe conexion de la base de datos
     */
    public static void llenar(Connection c){
        try {
            Statement in = c.createStatement();
            ResultSet resultado = in.executeQuery(
            "SELECT * FROM db_poliventas.tb_usuario");
            System.out.println("si");
            while(resultado.next()){
                String cadena=resultado.getString("matricula");
                String caden=resultado.getString("nombres");
                System.out.println("matricula: "+cadena+" nombres: " +caden);
            }
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
        }
    }
}