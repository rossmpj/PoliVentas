/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Administrador;

import Auxiliares.CONSTANTES;
import Auxiliares.MensajesAcciones;
import Controlador.Principal.WindowsController;
import Modelo.Administrador;
import Modelo.Producto;
import Vista.Administrador.VistaBuscarProducto;
import Vista.Administrador.VistaInfoProducto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorBuscarProducto {

    private Producto ModeloProducto;
    private final VistaBuscarProducto VistaBuscarProducto;
    private ObservableList<Producto> lproducto;
    private final Administrador a;

    public ControladorBuscarProducto(Producto ModeloProducto, Administrador a, VistaBuscarProducto VistaBuscarProducto) {
        this.ModeloProducto = ModeloProducto;
        this.VistaBuscarProducto = VistaBuscarProducto;
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
                    prix.addRow(0, nombreProducto(p.getNombre()), VistaBuscarProducto.getVer());
                    prix.setHgap(10);
                    hb.getChildren().addAll(prix);
                    hb.setPadding(new Insets(7, 0, 7, 5));
                    VistaBuscarProducto.getVbox().setPadding(new Insets(7, 25, 0, 5));
                    VistaBuscarProducto.getVbox().getChildren().addAll(hb, categoryNameLbl, precioProducto(p.getPrecio()),
                            crearEstrellas(p.getCalificacion()), drawLine());
                }
            }
        }

        private Label precioProducto(double precio) {
            Label priceLbl = new Label();
            priceLbl.setFont(new Font("Verdana", 10));
            priceLbl.setText("$" + String.valueOf(precio));
            return priceLbl;
        }

        private Label nombreProducto(String nombre) {
            Label productNameLbl = new Label();
            productNameLbl.setFont(new Font("Verdana", 12));
            productNameLbl.setText(nombre);
            return productNameLbl;
        }

        public Line drawLine() {
            Line linea = new Line(0, 0, 640, 0);
            linea.setStroke(Color.STEELBLUE);
            linea.setStrokeWidth(2);
            return linea;
        }

        private HBox crearEstrellas(int calificacion) {
            HBox contenedorStars = new HBox();
            for (int i = 0; i < calificacion; i++) {
                Image image = new Image(CONSTANTES.PATH_IMG + "/star.png");
                ImageView iv2 = new ImageView();
                iv2.setImage(image);
                contenedorStars.getChildren().add(iv2);
            }
            contenedorStars.setPadding(new Insets(5, 25, 7, 5));
            return contenedorStars;
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

