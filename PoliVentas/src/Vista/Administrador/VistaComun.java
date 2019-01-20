/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Administrador;

import Auxiliares.CONSTANTES;
import Vista.Comprador.CompradorOptions;
import Vista.Principal.Vista;
import Vista.Vendedor.VendedorOptions;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Tiffy
 */
public class VistaComun implements Vista {
     private final BorderPane root;
     private String tipo,color;
     private char user;
     private Button back;
    
    public VistaComun(String tipo,String color, char user){
     root = new BorderPane();
     this.tipo=tipo;
     this.color=color;
     this.user = user;
     crearSeccionTitulo();
     inicializarObjetos();
     setCompradorListener();
    }
    
    public BorderPane getRoot(){
        return root;
    }
    
    private void inicializarObjetos(){
    back= new Button();
     estiloBotones(back, "FFFFFF", "/back.png");
     root.setBottom(back);
    }
    
     public void estiloBotones(Button btn, String base, String path){
        btn.setStyle("-fx-background-radius: 15em; -fx-min-width: 50px; -fx-min-height: 50px;"
                + " -fx-max-width: 50px; -fx-max-height: 50px; -fx-base: #"+base+";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG+path));
        btn.setGraphic(new ImageView(image));
        btn.setAlignment(Pos.CENTER);
    }
    
    private void crearSeccionTitulo(){ 
        Label comprador = new Label(this.tipo);
        comprador.setPrefSize(720, 80);
        comprador.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #"+this.color+"; ");
        comprador.setAlignment(Pos.CENTER);
        root.setTop(comprador);
    }
    
    private void setCompradorListener(){
        back.setOnAction((ActionEvent e) -> {
            switch (this.user) {
                case 'C':
                    root.getScene().setRoot(new CompradorOptions().getRoot());
                    break;
                case 'V':
                    root.getScene().setRoot(new VendedorOptions().getRoot());
                    break;
                case 'A':
                    root.getScene().setRoot(new AdministradorOptions().getRoot());
                    break;
                default:
                    break;
            }
        });
    }
}
