/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Principal;

import Auxiliares.CONSTANTES;
import Vista.Administrador.AdministradorOptions;
import Vista.Comprador.CompradorOptions;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Tiffy
 */
public class VistaTemporal {

    private final BorderPane root;
    private Button comprador, vendedor, admin;

    public VistaTemporal() {
        root = new BorderPane();
        crearSeccionTitulo();
        createContent();
        setListeners();
    }

    private void createContent() {
        inicializarBotones();
        VBox contentMenu = new VBox();
        contentMenu.setAlignment(Pos.CENTER);
        contentMenu.setPadding(new Insets(10, 10, 10, 10));
        contentMenu.getChildren().addAll(GridPaneSeccion1());
        root.setCenter(contentMenu);
    }
    
        private void llamarBotones(){
        estiloBotones(comprador, "A8EFFA","/newProduct.png");
        estiloBotones(vendedor, "A8B6FA","/cesta.png");
        estiloBotones(admin, "FAA8DB","/man.png");
     
    }
        private void setListeners(){
        comprador.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new CompradorOptions().getRoot());
        });    
        
        admin.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new AdministradorOptions().getRoot());
        });
        
    }
        
         private void crearSeccionTitulo(){
        Label compr = new Label("Elija un usuario...");
        compr.setPrefSize(720, 80);
        compr.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #58D3F7; ");
        compr.setAlignment(Pos.CENTER);
        root.setTop(compr);
    }
        
        
        private GridPane GridPaneSeccion1(){
        GridPane gp = new GridPane();
        gp.addRow(0, comprador,vendedor,admin);
        gp.setHgap(10);
        gp.setVgap(30);
        gp.setAlignment(Pos.CENTER);
        return gp;
    }

    private void inicializarBotones() {
        comprador = new Button("Comprador");
        vendedor = new Button("Vendedor");
        admin = new Button("Adminstrador");
        llamarBotones();
    }

    public BorderPane getRoot() {
        return root;
    }

    
    public void estiloBotones(Button btn, String base, String path){
        btn.setStyle("-fx-font: 9 Verdana; -fx-base: #"+base+";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG+path));
        btn.setGraphic(new ImageView(image));
        btn.setPrefSize(150,100);
    }
}
