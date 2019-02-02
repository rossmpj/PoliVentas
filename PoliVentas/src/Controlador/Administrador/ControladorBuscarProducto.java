/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Administrador;

import Auxiliares.MensajesAcciones;
import Controlador.Principal.WindowsController;
import Modelo.Administrador;
import Modelo.Producto;
import Vista.Administrador.VistaBuscarProducto;
import Vista.Administrador.VistaInfoProducto;
import Vista.Comprador.VistaBusquedaSencilla;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorBuscarProducto {

    private Producto ModeloProducto;
    private final VistaBuscarProducto VistaBuscarProducto;
    private final VistaBusquedaSencilla VistaBusq;
    private ObservableList<Producto> lproducto;
    private final Administrador a;

    public ControladorBuscarProducto(Producto ModeloProducto, Administrador a, VistaBuscarProducto VistaBuscarProducto) {
        this.ModeloProducto = ModeloProducto;
        this.VistaBuscarProducto = VistaBuscarProducto;
        this.VistaBusq = new VistaBusquedaSencilla();
        this.a = a;
        this.lproducto = FXCollections.observableArrayList();
        this.VistaBuscarProducto.addBackButtonHandler((event -> WindowsController.previous()));
        this.VistaBuscarProducto.addBuscarButtonHandler(new BuscarButtonHandler());
        this.VistaBuscarProducto.addCleanButtonHandler(new CleanPButtonHandler());
    }

    private class BuscarButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            VistaBuscarProducto.getVbox().getChildren().clear();
            cargarContenido();
            VistaBuscarProducto.setBusquedaScrollPane(VistaBuscarProducto.getVbox());
        }

        private boolean cargarLista() {
            if (VistaBuscarProducto.campoVacio()) {
                lproducto = FXCollections.observableArrayList();
                a.consultarProducto(VistaBuscarProducto.getCampo().getText(), lproducto);
                if (!lproducto.isEmpty()) {
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
                for (Producto p : lproducto) {
                    HBox hb = new HBox();
                    GridPane prix = new GridPane();
                    Label categoryNameLbl = new Label();
                    VistaBuscarProducto.iniciarVer();
                    ModeloProducto = p;
                    VistaBuscarProducto.addVerButtonHandler(new ventanaPButtonHandler());
                    prix.addRow(0, VistaBusq.nombreProducto(p.getNombre()), VistaBuscarProducto.getVer());
                    prix.setHgap(10);
                    hb.getChildren().addAll(prix);
                    hb.setPadding(new Insets(7, 0, 7, 5));
                    VistaBuscarProducto.getVbox().setPadding(new Insets(7, 25, 0, 5));
                    VistaBuscarProducto.getVbox().getChildren().addAll(hb, categoryNameLbl, VistaBusq.precioProducto(p.getPrecio()),
                            VistaBusq.crearEstrellas(p.getCalificacion(),""), VistaBusq.drawLine());
                }
            }
        }
    }

    private class ventanaPButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            Producto y = new Producto();
            VistaInfoProducto v = new VistaInfoProducto(false, "81F7D8", "Modificar Producto", ModeloProducto);
            ControladorInfoProducto controladorInfoUsuario = new ControladorInfoProducto(y, a, v);
            WindowsController.next(VistaBuscarProducto, v);
        }

    }
     private class CleanPButtonHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            VistaBuscarProducto.getCampo().setText("");
            VistaBuscarProducto.getVbox().getChildren().clear();
            lproducto.clear();
            VistaBuscarProducto.setBusquedaScrollPane(VistaBuscarProducto.getVbox());
        }
    }
}

