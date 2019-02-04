/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Controlador.Administrador;

import ec.edu.espol.Auxiliares.MensajesAcciones;
import ec.edu.espol.Controlador.Principal.WindowsController;
import ec.edu.espol.Modelo.Administrador;
import ec.edu.espol.Modelo.Usuario;
import ec.edu.espol.Vista.Administrador.VistaBuscarUsuario;
import ec.edu.espol.Vista.Administrador.VistaInfoUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorBuscarUsuario {
    
    private Usuario ModeloUsuario;
    private final VistaBuscarUsuario VistaBuscarUsuario;
    private ObservableList<Usuario> lusuario;
    private final Administrador a;
    
    public ControladorBuscarUsuario(Usuario ModeloUsuario, Administrador a, VistaBuscarUsuario VistaBuscarUsuario) {
        this.ModeloUsuario = ModeloUsuario;
        this.VistaBuscarUsuario = VistaBuscarUsuario;
        this.a = a;
        this.VistaBuscarUsuario.addBackButtonHandler((event -> WindowsController.previous()));
        this.VistaBuscarUsuario.addBuscarButtonHandler(new BuscarUButtonHandler());
        this.VistaBuscarUsuario.addCleanButtonHandler(new CleanUButtonHandler());
    }
    
    private class BuscarUButtonHandler implements EventHandler {
        
        @Override
        public void handle(Event event) {
            VistaBuscarUsuario.getVbox().getChildren().clear();
            cargarContenido();
            VistaBuscarUsuario.setBusquedaScrollPane(VistaBuscarUsuario.getVbox());
        }
        
        private boolean cargarLista() {
            if (VistaBuscarUsuario.campoVacio()) {
                lusuario = FXCollections.observableArrayList();
                a.consultarUsuario(VistaBuscarUsuario.getCampo().getText(), lusuario);
                if (!lusuario.isEmpty()) {
                    return true;
                } else {
                    MensajesAcciones.registroNoEncontrado();
                    return false;
                }
            } else {
                MensajesAcciones.camposVacios();
                return false;
            }
        }
        
        private void cargarContenido() {
            if (cargarLista()) {
                for (Usuario p : lusuario) {
                    HBox hb = new HBox();
                    GridPane prix = new GridPane();
                    Label categoryNameLbl = new Label();
                    VistaBuscarUsuario.iniciarVer();
                    ModeloUsuario = p;
                    VistaBuscarUsuario.addVerButtonHandler(new nuevaVentanaButtonHandler());
                    categoryNameLbl.setText("Cel: " + p.getTelefono());
                    prix.addRow(0, nombreUsuario(p.getNombres() + " " + p.getApellidos()), VistaBuscarUsuario.getVer());
                    prix.setHgap(10);
                    hb.getChildren().addAll(prix);
                    hb.setPadding(new Insets(7, 0, 7, 5));
                    VistaBuscarUsuario.getVbox().setPadding(new Insets(7, 25, 0, 5));
                    VistaBuscarUsuario.getVbox().getChildren().addAll(hb, categoryNameLbl, ciUsuario(p.getCedula()),
                            drawLine());
                }
            }
        }
        
        private Label nombreUsuario(String nombre) {
            Label productNameLbl = new Label();
            productNameLbl.setFont(new Font("Verdana", 12));
            productNameLbl.setText("Nombres: " + nombre);
            return productNameLbl;
        }
        
        private Label ciUsuario(String ci) {
            Label productNameLbl = new Label();
            productNameLbl.setFont(new Font("Verdana", 12));
            productNameLbl.setText("CI: " + ci);
            return productNameLbl;
        }
        
        public Line drawLine() {
            Line linea = new Line(0, 0, 640, 0);
            linea.setStroke(Color.STEELBLUE);
            linea.setStrokeWidth(2);
            return linea;
        }
        
    }
    
    private class nuevaVentanaButtonHandler implements EventHandler {
        
        @Override
        public void handle(Event event) {
            VistaInfoUsuario v = new VistaInfoUsuario(false, "A8ECDD", "Modificar usuario", ModeloUsuario);
            ControladorInfoUsuario controladorInfoUsuario = new ControladorInfoUsuario(a, v);
            WindowsController.next(VistaBuscarUsuario, v);
        }
        
    }
    
    private class CleanUButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            VistaBuscarUsuario.getCampo().setText("");
            VistaBuscarUsuario.getVbox().getChildren().clear();
            lusuario.clear();
            VistaBuscarUsuario.setBusquedaScrollPane(VistaBuscarUsuario.getVbox());
        }
    }
    
}
