/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Vista.Vendedor;

import ec.edu.espol.Auxiliares.CONSTANTES;
import static ec.edu.espol.Auxiliares.PatronVistaTitulos.crearTituloSubMenu;
import ec.edu.espol.Vista.Principal.Vista;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Tiffy, Galo Xavier Figueroa Villacreses
 */
public class VistaMapa implements Vista {

    private final BorderPane root;
    private final String color;
    private final String titulo;
    private final Button back;
    
    public VistaMapa() {
        
        root = new BorderPane();
        this.color = "A8EFFA";
        this.titulo = "Ubicación de entrega";
        
        back = new Button("        Volver        ");
        back.setStyle("-fx-font: 17 Verdana; ");
        back.setAlignment(Pos.CENTER);
        
        root.setTop(crearTituloSubMenu(titulo,color));
        root.setBottom(back);
    }
    
    public void addBackButtonHandler(EventHandler backButtonHandler){
        back.setOnAction(backButtonHandler);
    }
    
    public void setMapa(String path){
        Image image;
        
        try {
            image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG + path));
            
        } catch(Exception e){
            
            image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG + "/quioscos.png"));
        }
        
        ImageView mapa = new ImageView(image);
        
        root.setCenter(mapa);
    }

    @Override
    public BorderPane getRoot() {
        return root;
    }
     
}
