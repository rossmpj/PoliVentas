/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class TemporaryOptionsView {
    
    private final VBox root;
    private Button misVentasButton, misProductosButton;
    
    public TemporaryOptionsView(){
        
        root = new VBox();
        
        createContent();
        setListeners();
        
    }
    
    private void createContent(){
        
        misVentasButton = new Button("Mis ventas");
        root.getChildren().add(misVentasButton);
        
        misProductosButton = new Button("Mis productos");
        root.getChildren().add(misProductosButton);
        
    }
    
    private void setListeners(){
        
        misVentasButton.setOnAction((ActionEvent e) -> {
            
            root.getScene().setRoot(new MisVentas().getRoot());
            
        });
        
        misProductosButton.setOnAction((ActionEvent e) -> {
            
            root.getScene().setRoot(new MisProductos().getRoot());
            
        });
        
    }
    
    public VBox getRoot(){
        return root;
    }
    
}
