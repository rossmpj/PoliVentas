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
import Vista.Administrador.VistaInfoProducto;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorInfoProducto {

    private final Administrador ModeloAdmin;
    private final VistaInfoProducto VistaNuevoProducto;

    public ControladorInfoProducto(Administrador ModeloAdmin, VistaInfoProducto VistaNuevoProducto) {
        this.VistaNuevoProducto = VistaNuevoProducto;
        this.ModeloAdmin = ModeloAdmin;
        this.VistaNuevoProducto.addBackButtonHandler((event -> WindowsController.previous()));
        if (!VistaNuevoProducto.isIngreso()) {
            this.VistaNuevoProducto.addEliminarButtonHandler(new eliminarButtonHandler());
            this.VistaNuevoProducto.addModificarButtonHandler(new modificarButtonHandler());
        } else {
            this.VistaNuevoProducto.addAlmacenarButtonHandler(new almacenarButtonHandler());
        }
    }

    private class almacenarButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            if (VistaNuevoProducto.validarCasillas()) {
                Producto nuevo = new Producto(VistaNuevoProducto.getId().getText(), VistaNuevoProducto.getNombre().getText(), VistaNuevoProducto.getDescripcion().getText(),
                        Double.valueOf(VistaNuevoProducto.getPrecio().getText()), VistaNuevoProducto.getCategoria().getText(), Integer.valueOf(VistaNuevoProducto.getCantidad().getText()),
                        false, 0, VistaNuevoProducto.getVendedor().getText());
                if (nuevo.registrar()) {
                    MensajesAcciones.almacenamientoExitoso();
                    VistaNuevoProducto.limpiarCasillas();
                } else {
                    MensajesAcciones.ventanaProblemasTecnicos();
                }
            } else {
                MensajesAcciones.camposVacios();
            }
        }
    }

    private class eliminarButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            if (ModeloAdmin.eliminarProducto(VistaNuevoProducto.getP())) {
                MensajesAcciones.eliminacionExitosa();
                VistaNuevoProducto.limpiarCasillas();
            } else {
                MensajesAcciones.ventanaProblemasTecnicos();
            }
        }

    }

    private class modificarButtonHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            if (ModeloAdmin.modificarProducto(VistaNuevoProducto.updateProducto())) {
                MensajesAcciones.modificacionExitosa();
                VistaNuevoProducto.limpiarCasillas();
            } else {
                MensajesAcciones.ventanaProblemasTecnicos();
            }
        }

    }

}
