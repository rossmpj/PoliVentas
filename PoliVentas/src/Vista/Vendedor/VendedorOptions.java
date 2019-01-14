package Vista.Vendedor;

import Vista.*;
import Vista.Principal.PaneLogin;
import Auxiliares.CONSTANTES;
import Vista.Administrador.VistaComun;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 *
 * @author Rosy
 */
public class VendedorOptions {   
    private final BorderPane root;
    private Button VentasPendientes, ResumenVentas, MisProductos, CerrarSesion;
    
    public BorderPane getRoot(){
        return root;
    }
    
    public VendedorOptions(){
        root = new BorderPane();
        crearSeccionTituloVendedor();
        createContent();
        setListeners();
    }

    private void createContent(){
        inicializarBotones();
        VBox contentMenuComprador = new VBox();
        contentMenuComprador.setAlignment(Pos.CENTER); 
        contentMenuComprador.setPadding(new Insets(10, 10, 10, 10));
        contentMenuComprador.getChildren().addAll(GridPaneSeccion1(), GridPaneSeccion2());
        root.setCenter(contentMenuComprador);  
    }
    
    private void inicializarBotones(){
        VentasPendientes = new Button("Ventas\nPendientes");
        ResumenVentas = new Button("Resumen\nVentas");
        MisProductos = new Button("Mis\nProductos");
        CerrarSesion = new Button("Cerrar\nSesión");
        llamarBotones();        
    }
    
    private void llamarBotones(){
        estiloBotones(VentasPendientes, "A8EFFA","/searchS.png");
        estiloBotones(ResumenVentas, "FAB1A8","/history.png");
        estiloBotones(MisProductos, "DFA8FA","/newProduct.png");
        estiloBotones(CerrarSesion, "FAFAA8","/logout.png");
    }
    
    private GridPane GridPaneSeccion1(){
        GridPane gp = new GridPane();
        gp.add(crearSeccionVentas(), 0, 0);
        gp.setHgap(10);
        gp.setVgap(30);
        gp.setAlignment(Pos.CENTER);
        return gp;
    }
    
    private GridPane GridPaneSeccion2(){
        GridPane gp1 = new GridPane();
        gp1.add(MisProductos, 0, 2);
        gp1.add(CerrarSesion, 1, 2); 
        gp1.setHgap(79);
        gp1.setVgap(30);
        gp1.setAlignment(Pos.CENTER);
        return gp1;
    }
    
    private void crearSeccionTituloVendedor(){
        Label vendedor = new Label("Menú Vendedor");
        vendedor.setPrefSize(720, 80);
        vendedor.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #AEA8FA; ");
        vendedor.setAlignment(Pos.CENTER);
        root.setTop(vendedor);
    }
    
    private VBox crearSeccionVentas(){
        VBox ventas = new VBox();
        HBox ventas1 = new HBox();
        Label lblTitle = new Label("Ventas");
        estiloLabels(lblTitle, "4C00A7");
        ventas1.getChildren().addAll(VentasPendientes,ResumenVentas);
        ventas.getChildren().addAll(lblTitle, ventas1);
        return ventas;
    }
    
    private void setListeners(){
        VentasPendientes.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new VentasPendientes().getRoot());
        });
        
        ResumenVentas.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new VistaComun("Resumen de ventas", "78EDF4", 'V').getRoot());
        });
        
        MisProductos.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new PaneMisProductos().getRoot());
        });
        
        listenCerrarSesion();
    }
    
    public void estiloBotones(Button btn, String base, String path){
        btn.setStyle("-fx-font: 9 Verdana; -fx-base: #"+base+";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG+path));
        btn.setGraphic(new ImageView(image));
        btn.setPrefSize(130,100);
    }
    
    public void estiloLabels(Label lbl, String base){
        lbl.setPrefSize(260, 80);
        lbl.setStyle("-fx-font: 17 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #"+base+"; ");
        lbl.setAlignment(Pos.CENTER);
    }
    
    private void listenCerrarSesion(){
     CerrarSesion.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new PaneLogin().getRoot());});
    }

}