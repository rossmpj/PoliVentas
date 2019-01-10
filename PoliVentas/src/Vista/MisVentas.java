/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class MisVentas {
    
    private final BorderPane root;
    
    
    public MisVentas(){
        
        root = new BorderPane();
        
        createContent();
        
    }
    
    private void createContent(){
        
        Text viewTitle = new Text("Mis ventas pendientes");
        viewTitle.setFont(new Font("PRODUCTOS", 20));
        
        root.setTop(viewTitle);
        
        VBox center = new VBox();
        
        for(int i = 1; i < 11; ++i)
            center.getChildren().add(getPseudoVenta(i, 11 - i));
        
        root.setCenter(center);
        
    }
    
    private VBox getPseudoVenta(int numero, int quantity){
        
        VBox venta = new VBox();
        
        Text name = new Text("Pedido " + numero);
        name.setFont(new Font("Arial", 16));
        venta.getChildren().add(name);
        
        Text product = new Text("Producto " + numero);
        name.setFont(new Font("Arial", 16));
        venta.getChildren().add(product);
        
        Text quantityText = new Text(Integer.toString(quantity));
        name.setFont(new Font("Arial", 14));
        venta.getChildren().add(quantityText);
        
        
        return venta;
        
    }
    
    public BorderPane getRoot(){
        
        return root;
    }
    
}
