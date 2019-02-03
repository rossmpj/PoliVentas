/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.scene.control.Alert;

/**
 *
 * @author Rosa
 */
public class PagoEfectivo implements Pago {

    @Override
    public boolean pagar(String ci_cel,double monto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pago en Efectivo");
        alert.setHeaderText("");
        alert.setContentText("Se ha efectuado el pago total de $"+monto+" en efectivo");
        alert.showAndWait();
        return true;
    }

}
