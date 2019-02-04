package Controlador.Administrador;

import Auxiliares.MensajesAcciones;
import Controlador.Principal.WindowsController;
import Modelo.Administrador;
import Modelo.Usuario;
import Vista.Administrador.VistaInfoUsuario;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorInfoUsuario { 
    private final Administrador admin;
    private final VistaInfoUsuario VistaNuevoUsuario;

    public ControladorInfoUsuario(Administrador a, VistaInfoUsuario VistaNuevoUsuario) {
        this.admin = a;
        this.VistaNuevoUsuario = VistaNuevoUsuario;
        this.VistaNuevoUsuario.addBackButtonHandler((event -> WindowsController.previous()));
        if (!VistaNuevoUsuario.isIngreso()) {
            this.VistaNuevoUsuario.addEliminarButtonHandler(new eliminarUButtonHandler());
            this.VistaNuevoUsuario.addModificarButtonHandler(new modificarUButtonHandler());
        } else {
            this.VistaNuevoUsuario.addAlmacenarButtonHandler(new almacenarUButtonHandler());
        }
    }

    private class almacenarUButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            if (VistaNuevoUsuario.validarCasillas()) {
                Usuario nuevo = new Usuario(VistaNuevoUsuario.getCi().getText(), VistaNuevoUsuario.getNom().getText(), VistaNuevoUsuario.getApe().getText(),
                        VistaNuevoUsuario.getTl().getText(), VistaNuevoUsuario.getDir().getText(), VistaNuevoUsuario.getWapp().isSelected(),
                        VistaNuevoUsuario.getMat().getText(), VistaNuevoUsuario.getMail().getText(), VistaNuevoUsuario.getUser().getText(), VistaNuevoUsuario.getContra().getText(), false);
                if (nuevo.registrar()) {
                    almacenaRol(nuevo);
                    MensajesAcciones.almacenamientoExitoso();
                    VistaNuevoUsuario.limpiarCasillas();
                } else {
                    MensajesAcciones.ventanaProblemasTecnicos();
                }
            } else {
                MensajesAcciones.camposVacios();
            }
        }

        private void almacenaRol(Usuario nuevo) {
            switch (VistaNuevoUsuario.seleccion()) {
                case "Administrador":
                    nuevo.almacenarRolAdministrador();
                    break;
                case "Vendedor":
                    nuevo.almacenarRolComprador();
                    nuevo.almacenarRolVendedor();
                    break;
                case "Comprador":
                    nuevo.almacenarRolComprador();
                    break;
            }
        }
    }

    private class eliminarUButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            if (admin.eliminarUsuario(VistaNuevoUsuario.getU())) {
                MensajesAcciones.eliminacionExitosa();
                VistaNuevoUsuario.limpiarCasillas();
            } else {
                MensajesAcciones.ventanaProblemasTecnicos();
            }
        }

    }

    private class modificarUButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            if (admin.modificarUsuario(VistaNuevoUsuario.updateUsuario())) {
                MensajesAcciones.modificacionExitosa();
                VistaNuevoUsuario.limpiarCasillas();
            } else {
                MensajesAcciones.ventanaProblemasTecnicos();
            }
        }

    }

}
