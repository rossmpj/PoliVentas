/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

/**
 *
 * @author Tiffy
 */
public class MensajesAcciones {

    private MensajesAcciones() {
    }

    /**
     * Método que permitirá mostrar una ventana cuando se produzca una excepcion
     */
    public static void ventanaProblemasTecnicos() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Lo sentimos, estamos teniendo inconvenientes técnicos, realice la operación más tarde");
        alert.showAndWait();
    }

    /**
     * Método que permitirá mostrar una ventana cuando el usuario deje algún
     * campo vacío
     */
    public static void camposVacios() {
        Alert advertencia = new Alert(Alert.AlertType.WARNING);
        advertencia.setTitle("Error");
        advertencia.setContentText("Debe asegurarse de llenar todos los campos");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }

    /**
     * Método que permitirá saber que un registro se almacenó correctamente
     */
    public static void almacenamientoExitoso() {
        Alert advertencia = new Alert(Alert.AlertType.INFORMATION);
        advertencia.setTitle("Almacenar registro");
        advertencia.setContentText("Registro almacenado correctamente");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }

    /**
     * Método que permitirá saber que un registro se eliminó correctamente
     */
    public static void eliminacionExitosa() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Eliminar registro");
        alert.setHeaderText(null);
        alert.setContentText("El registro ha sido eliminado exitosamente");
        alert.showAndWait();
    }

    /**
     * Método que permitirá saber que un registro se modificó correctamente
     */
    public static void modificacionExitosa() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modificar registros");
        alert.setHeaderText(null);
        alert.setContentText("El registro ha sido modificado exitosamente");
        alert.showAndWait();
    }

    /**
     * Método que permitirá mostrar una ventana cuando ya exista un registro
     */
    public static void registroDuplicado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("El registro que está ingresando ya existe");
        alert.showAndWait();
    }

    /**
     * Método que permitirá mostrar una ventana cuando no exista un registro
     * buscado
     */
    public static void registroNoEncontrado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("404 not found");
        alert.setHeaderText(null);
        alert.setContentText("Lo sentimos,el registro que está buscando no existe");
        alert.showAndWait();
    }
    
    public static void NotificarVendedor() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Correo enviado exitosamente");
        alert.setHeaderText(null);
        alert.setContentText("El vendedor ha sido notificado para realizar la entrega");
        alert.showAndWait();
    }
    
    public static void NotificarVendedorFailed() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Envío de correo fallido");
        alert.setHeaderText(null);
        alert.setContentText("Lo sentimos, no se ha podido notificar al vendedor");
        alert.showAndWait();
    }
}
