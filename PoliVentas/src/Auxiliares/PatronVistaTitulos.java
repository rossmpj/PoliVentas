package Auxiliares;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author Rosy
 */
public class PatronVistaTitulos {
    public static VBox crearTituloMenuPrincipal(String nombre, String colorHEX){
        VBox contenedorTitulo = new VBox();
        Label comprador = new Label(nombre);
        comprador.setPrefHeight(120);
        DropShadow ds = new DropShadow();
        contenedorTitulo.setEffect(ds);
        contenedorTitulo.setAlignment(Pos.CENTER);
        contenedorTitulo.setStyle("-fx-background-color: #"+colorHEX+";");
        comprador.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; -fx-font-weight: bold;");
        contenedorTitulo.getChildren().add(comprador);
        return contenedorTitulo;
    }
    
    public static VBox crearTituloSubMenu(String nombre, String colorHEX){
        VBox contenedorTitulo = new VBox();
        Label comprador = new Label(nombre);
        comprador.setPrefHeight(100);
        contenedorTitulo.setAlignment(Pos.CENTER);
        contenedorTitulo.setStyle("-fx-background-color: #"+colorHEX+";");
        comprador.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; ");
        contenedorTitulo.getChildren().add(comprador);
        return contenedorTitulo;
    }      
    
    public static Button botonRegresarMenu(){
        Button btn = new Button("Volver al menú principal");
        btn.setStyle("-fx-base:FFFFFF; -fx-font: 15 Verdana;");
        Image image = new Image(CONSTANTES.PATH_IMG+"/back.png");
        btn.setGraphic(new ImageView(image));
        btn.setAlignment(Pos.CENTER);
        return btn;
    }
}