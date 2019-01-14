/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Vendedor;

import javafx.scene.control.ScrollPane;
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
        
        ScrollPane center = new ScrollPane();
        
        VBox list = new VBox();
        list.setStyle("-fx-padding:10px;-fx-spacing:10px");
        list.setFillWidth(true);
        
        
        for(int i = 1; i < 11; ++i)
            list.getChildren().add(getPseudoProducto(i, Math.random() * 100));
        
        center.setContent(list);
        root.setCenter(center);
        
    }
    
    private VBox getPseudoProducto(int productNumber, double price){
        
        VBox producto = new VBox();
        if(productNumber%2 == 0)    producto.setStyle("-fx-background-color:#a1d3f1;");
        else    producto.setStyle("-fx-background-color:#a3f5c1;");
        
        producto.setStyle(producto.getStyle() + "-fx-background-radius:5px;-fx-background-radius:10px; -fx-padding:10px;");
        producto.setFillWidth(true);
        
        Text name = new Text("Nombre producto " + productNumber);
        name.setFont(new Font("Arial", 16));
        producto.getChildren().add(name);
        
        Text priceText = new Text(String.format("$%.2f", price));
        
        name.setFont(new Font("Arial", 16));
        producto.getChildren().add(priceText);
        
        Text description = new Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
        //description.setWrappingWidth(500);
        name.setFont(new Font("Arial", 14));
        producto.getChildren().add(description);
        
        
        return producto;
        
    }
    
    public BorderPane getRoot(){
        
        return root;
    }
    
}
