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
public class MisProductos {
    
    private final BorderPane root;
    
    
    public MisProductos(){
        
        root = new BorderPane();
        
        createContent();
        
    }
    
    private void createContent(){
        
        Text viewTitle = new Text("MIS PRODUCTOS");
        viewTitle.setFont(new Font("Arial", 20));
        
        root.setTop(viewTitle);
        
        VBox center = new VBox();
        
        for(int i = 1; i < 11; ++i)
            center.getChildren().add(getPseudoProducto(i, Math.random() * 100));
        
        root.setCenter(center);
        
    }
    
    private VBox getPseudoProducto(int productNumber, double price){
        
        VBox venta = new VBox();
        
        Text name = new Text("Producto " + productNumber);
        name.setFont(new Font("Arial", 16));
        venta.getChildren().add(name);
        
        Text priceText = new Text(String.format("$%.2f", price));
        name.setFont(new Font("Arial", 16));
        venta.getChildren().add(priceText);
        
        Text description = new Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
        name.setFont(new Font("Arial", 14));
        venta.getChildren().add(description);
        
        
        return venta;
        
    }
    
    public BorderPane getRoot(){
        
        return root;
    }
    
}
