package ec.edu.espol.Controlador.Principal;

import ec.edu.espol.Auxiliares.MensajesAcciones;
import ec.edu.espol.Auxiliares.Validators;
import ec.edu.espol.Controlador.Administrador.ControladorAdministradorOptions;
import ec.edu.espol.Controlador.Administrador.ControladorInfoUsuario;
import ec.edu.espol.Controlador.Comprador.ControladorCompradorOptions;
import ec.edu.espol.Controlador.Vendedor.ControladorVendedorOptions;
import ec.edu.espol.Modelo.Administrador;
import ec.edu.espol.Modelo.Usuario;
import ec.edu.espol.Vista.Administrador.AdministradorOptions;
import ec.edu.espol.Vista.Administrador.VistaInfoUsuario;
import ec.edu.espol.Vista.Comprador.CompradorOptions;
import ec.edu.espol.Vista.Principal.PaneLogin;
import ec.edu.espol.Vista.Vendedor.VendedorOptions;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Rosy
 */
public class ControladorLogin {
         
    private final PaneLogin LoginView;
    public static String ced;
    public static String vend_id;
    public static String comp_id;
    public static String admin_id;

    public ControladorLogin(PaneLogin LoginView) {
        this.LoginView = LoginView;        
        this.LoginView.addLoginButtonHandler(new LoginButtonHandler());
        this.LoginView.addSignInButtonHandler(new SignInButtonHandler());
    }

    private class LoginButtonHandler implements EventHandler {
        
        @Override
        public void handle(Event event) {
            
            if (Validators.fieldNotEmpty(LoginView.getUser()) && Validators.fieldNotEmpty(LoginView.getContra())) {
                
                ced = Usuario.validarUser(LoginView.getUser(), LoginView.getContra());
                
                if(ced == null){
                    
                    MensajesAcciones.validarLogin();
                    limpiarCampos();
                    
                } else{
                    
                    vend_id = Usuario.isVendedor(ced);
                    comp_id = Usuario.isComprador(ced);
                    admin_id = Usuario.isAdministrador(ced);
                    
                    if(vend_id != null) mostrarVentanaVendedor();
                    else if (comp_id != null)   mostrarVentanaComprador();
                    else    mostrarVentanaAdministrador();
                    
                    limpiarCampos();
                }
                
            } else  MensajesAcciones.camposVacios();
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
            VistaInfoUsuario nuevoUsuarioView = new VistaInfoUsuario(true, "C7E7E0", "Formulario de Registro",null);
            ControladorInfoUsuario controladorU = new ControladorInfoUsuario(a, nuevoUsuarioView);
            WindowsController.next(LoginView, nuevoUsuarioView);
        }   
    }
}
