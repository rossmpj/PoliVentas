package Vista.Administrador;

import Auxiliares.CONSTANTES;
import static Auxiliares.PatronVistaTitulos.botonRegresarMenu;
import Vista.Comprador.CompradorOptions;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Tiffy
 */
public class VistaComun {
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
        back = botonRegresarMenu();
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
        VBox contenedorTitulo = new VBox();
        Label comprador = new Label(this.tipo);
        comprador.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; ");
        comprador.setPrefHeight(80);
        contenedorTitulo.setAlignment(Pos.CENTER);
        contenedorTitulo.setStyle("-fx-background-color: #"+this.color+";");
        contenedorTitulo.getChildren().add(comprador);
        root.setTop(contenedorTitulo);
    }
    
    private void setCompradorListener(){
        back.setOnAction((ActionEvent e) -> {
            switch (this.user) {
                case 'C':
                    root.getScene().setRoot(new CompradorOptions().getRoot());
                    break;
                case 'V':
                    //root.getScene().setRoot(new VendedorOptions().getRoot());
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
