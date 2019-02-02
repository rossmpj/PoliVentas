package Controlador.Principal;

import Auxiliares.DBConnection;
import Auxiliares.MensajesAcciones;
import Controlador.Administrador.ControladorAdministradorOptions;
import Controlador.Administrador.ControladorInfoUsuario;
import Controlador.Comprador.ControladorCompradorOptions;
import Controlador.Vendedor.ControladorVendedorOptions;
import Modelo.Administrador;
import Modelo.Usuario;
import Vista.Administrador.AdministradorOptions;
import Vista.Administrador.VistaInfoUsuario;
import Vista.Comprador.CompradorOptions;
import Vista.Principal.PaneLogin;
import Vista.Vendedor.VendedorOptions;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Rosy
 */
public class ControladorLogin {
         
    private final PaneLogin LoginView;
    public static String ced;

    public ControladorLogin(PaneLogin LoginView) {
        this.LoginView = LoginView;        
        this.LoginView.addLoginButtonHandler(new LoginButtonHandler());
        this.LoginView.addSignInButtonHandler(new SignInButtonHandler());
    }

    private class LoginButtonHandler implements EventHandler {
        @Override
        public void handle(Event event) {
        if (!LoginView.getUser().equals("") && !LoginView.getContra().equals("")) {
            DBConnection c = DBConnection.getInstance();
            c.conectar();
            String usu = validarUser(LoginView.getUser(), LoginView.getContra(), c.getConnection());
            final boolean esComprador = isComprador(usu, c.getConnection());
            final boolean esVendedor = isVendedor(usu, c.getConnection());
            final boolean esAdmin = isAdministrador(usu, c.getConnection());
            System.out.println("ci: "+usu);
            ced = usu;
            System.out.println(ced);
            c.desconectar();
            if (usu != null) {
                if ( (esComprador && esVendedor) || (esComprador) ) {
                    mostrarVentanaComprador();
                } else if (esVendedor) {
                    mostrarVentanaVendedor();
                } else if (esAdmin){ 
                    mostrarVentanaAdministrador();
                }
                limpiarCampos();
            } else {
                MensajesAcciones.validarIngreso();
                limpiarCampos();
            }
        } else {
            MensajesAcciones.camposVacios();
        }
    }  
    }
    
    private void limpiarCampos(){
        LoginView.setUser("");
        LoginView.setContra("");
    }
    
    private void mostrarVentanaComprador(){
        CompradorOptions compOptView = new CompradorOptions();
        ControladorCompradorOptions contC = new ControladorCompradorOptions(compOptView);
        WindowsController.next(LoginView, compOptView);
    }
    
    private void mostrarVentanaVendedor(){
        VendedorOptions vendOptView = new VendedorOptions();
        ControladorVendedorOptions contV = new ControladorVendedorOptions(vendOptView);
        WindowsController.next(LoginView, vendOptView);
    }
    
    private void mostrarVentanaAdministrador(){
        AdministradorOptions adminOptView = new AdministradorOptions();
        ControladorAdministradorOptions contV = new ControladorAdministradorOptions(adminOptView);
        WindowsController.next(LoginView, adminOptView);
    }
    
    private class SignInButtonHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            Administrador a = new Administrador();
            Usuario usuario = new Usuario();
            VistaInfoUsuario nuevoUsuarioView = new VistaInfoUsuario(true, "C7E7E0", "Formulario de Registro");
            ControladorInfoUsuario controladorU = new ControladorInfoUsuario(usuario, a, nuevoUsuarioView);
            WindowsController.next(LoginView, nuevoUsuarioView);
        }   
    } 
   
    public static String validarUser(String user, String pass, Connection c){
        String ci = null;
        try {
            String consulta = "{call login(?,?,?)}"; 
            try (CallableStatement sp = c.prepareCall(consulta)) {
                sp.setString(1, user);
                sp.setString(2, pass);
                sp.registerOutParameter(3, Types.VARCHAR);
                sp.execute();
                ci= sp.getString(3);
            }
        } catch (SQLException ex) {
            System.out.println("EXCEPCION user: " + ex.getMessage());
        }      
        return ci;
    }
    
    public static boolean isComprador(String code, Connection e) {
        boolean isComprador = false;
        try {
            String query = "SELECT cedula FROM db_poliventas.tb_comprador WHERE cedula = "+ code;
            Statement in = e.createStatement();
            ResultSet resultado = in.executeQuery(query);
            if(resultado.next()) {
                isComprador = true;               
            }
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
        }
        return isComprador;
    }
    
    public static boolean isVendedor(String code, Connection e) {
        boolean isVendedor = false;
        try {
            String query = "SELECT cedula FROM db_poliventas.tb_vendedor WHERE cedula = "+ code;
            Statement in = e.createStatement();
            ResultSet resultado = in.executeQuery(query);
            if(resultado.next()) {
                isVendedor = true;                    
            }
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
        }
        return isVendedor;
    }
    
    public static boolean isAdministrador(String code, Connection e) {
        boolean isAdministrador = false;
        try {
            String query = "SELECT cedula FROM db_poliventas.tb_administrador WHERE cedula = "+ code;
            Statement in = e.createStatement();
            ResultSet resultado = in.executeQuery(query);
            if(resultado.next()) {
                isAdministrador = true;               
            }
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
        }
        return isAdministrador;
    }
}