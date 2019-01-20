/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Principal;

import Auxiliares.CONSTANTES;
import static Auxiliares.PatronVistaTitulos.crearTituloSubMenu;
import Controlador.Administrador.ControladorAdministradorOptions;
import Controlador.Comprador.ControladorBusquedaSencilla;
import Controlador.Comprador.ControladorCompradorOptions;
import Controlador.Vendedor.ControladorVendedorOptions;
import Vista.Administrador.AdministradorOptions;
import Vista.Comprador.CompradorOptions;
import Vista.Comprador.VistaBusquedaSencilla;
import Vista.Vendedor.VendedorOptions;
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
public class VistaTemporal implements Vista {

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
            
            CompradorOptions compradorOptionsView = new CompradorOptions();
            ControladorCompradorOptions controladorCompradorOptions = new ControladorCompradorOptions(compradorOptionsView);
            
            root.getScene().setRoot(compradorOptionsView.getRoot());
            
            
        });    
        
        vendedor.setOnAction((ActionEvent e) -> {
            
            VendedorOptions vendedorOptionsView = new VendedorOptions();
            ControladorVendedorOptions controladorVendedorOptions = new ControladorVendedorOptions(vendedorOptionsView);
            
            root.getScene().setRoot(vendedorOptionsView.getRoot());
            
        });
        
        admin.setOnAction((ActionEvent e) -> {
            
            AdministradorOptions administradorOptionsView = new AdministradorOptions();
            ControladorAdministradorOptions controladorVendedorOptions = new ControladorAdministradorOptions(administradorOptionsView);
            
            root.getScene().setRoot(administradorOptionsView.getRoot());
            
        });
        
    }
        
         private void crearSeccionTitulo(){
        root.setTop(crearTituloSubMenu("Elija un usuario...","58D3F7"));
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
        btn.setStyle("-fx-font: 12 Verdana; -fx-base: #"+base+";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG+path));
        btn.setGraphic(new ImageView(image));
        btn.setPrefSize(200, 110);
    }
}
