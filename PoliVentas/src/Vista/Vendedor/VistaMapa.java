/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Vendedor;

import Auxiliares.CONSTANTES;
import static Auxiliares.PatronVistaTitulos.crearTituloSubMenu;
import Vista.Principal.Vista;
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
    private final String color, titulo;
    private Button back;
    
    public VistaMapa() {
        root = new BorderPane();
        this.color = "A8EFFA";
        this.titulo = "Ubicación de entrega";
        crearSeccionTitulo();
        inicializarObjetos();
    }

    public VistaMapa(String color, String titulo) {
        root = new BorderPane();
        this.color = color;
        this.titulo = titulo;
        crearSeccionTitulo();
        inicializarObjetos();
    }

    private void inicializarObjetos() {
        back = new Button("        Volver        ");
        back.setStyle("-fx-font: 17 Verdana; ");
        back.setAlignment(Pos.CENTER);
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

    private void crearSeccionTitulo() {
        root.setTop(crearTituloSubMenu(titulo,color));
    }

    @Override
    public BorderPane getRoot() {
        return root;
    }
     
}
