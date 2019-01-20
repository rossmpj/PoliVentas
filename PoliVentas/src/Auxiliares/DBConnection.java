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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ROSA
 */
public class DBConnection {
    private static DBConnection dbConnection;
    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/db_poliventas?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String user = "root2";
    private final String pass = "root";
    private static final Logger LOGGER = Logger.getLogger("DBConnection Logger");
    
    private DBConnection(){
        
    }

    /**
     * Getter para la connection
     * @return connection a BD
     */
    
    public static DBConnection getInstance(){
        
        if(dbConnection == null){
            
            dbConnection = new DBConnection();
            
        }
        
        return dbConnection;
    }
    
    public Connection getConnection() {
        
        return connection;
        
    }

    /**
     * Setter para connection 
     * @param connexion
     */
    public void setConnection(Connection connexion) {
        this.connection = connexion;
    }
    
    /**
     * Método de tipo void para establecer connection con la Base de datos
     */
    public void conectar(){
        
        LOGGER.log(Level.INFO, "Establishing the database connection...");
        
        try{
            this.connection = DriverManager.getConnection(url, user, pass);
            LOGGER.log(Level.INFO, "¡The database connection was established successfully!");
            
        } catch(SQLException e){
            
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }
    	
    /**
     * Método para cerrar la connection a la base de datos, no retorna nada
     */
    public void desconectar(){
        
	try {
            connection.close();
            
	} catch (SQLException e) {
            
            LOGGER.log(Level.SEVERE, e.getMessage());
	}
    }
    
    /**
     * Método de prueba
     * @param c: recibe connection de la base de datos
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