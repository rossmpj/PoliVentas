package Vista.Vendedor;

import Auxiliares.CONSTANTES;
import Vista.Principal.Vista;
import static Auxiliares.PatronVistaTitulos.crearTituloMenuPrincipal;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 *
 * @author Rosy, Galo Xavier Figueroa Villacreses
 */
public class VendedorOptions implements Vista{   
    private final BorderPane root;
    private Button VentasPendientes, ResumenVentas, MisProductos, CerrarSesion;
    
    @Override
    public BorderPane getRoot(){
        return root;
    }
    
    public VendedorOptions(){
        root = new BorderPane();
        crearSeccionTituloVendedor();
        createContent();
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
        estiloBotones(VentasPendientes, "DDC4F7","/searchS.png");
        estiloBotones(ResumenVentas, "E8C4F7","/history.png");
        estiloBotones(MisProductos, "F7C4D1","/newProduct.png");
        estiloBotones(CerrarSesion, "F5C4F7","/logout.png");
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
        gp1.setHgap(40);
        gp1.setVgap(30);
        gp1.setAlignment(Pos.CENTER);
        return gp1;
    }
    
    private void crearSeccionTituloVendedor(){
        root.setTop(crearTituloMenuPrincipal("Menú Vendedor", "DE479C"));
    }
    
    private VBox crearSeccionVentas(){
        VBox ventas = new VBox();//A4A700
        HBox ventas1 = new HBox();
        Label lblTitle = new Label("Ventas");
        estiloLabels(lblTitle, "5900A7");
        ventas1.getChildren().addAll(VentasPendientes,ResumenVentas);
        ventas.getChildren().addAll(lblTitle, ventas1);
        return ventas;
    }
    
    public void addVentasPendientesButtonHandler(EventHandler ventasPendientesButtonHandler){ 
        VentasPendientes.setOnAction(ventasPendientesButtonHandler); 
    }
    
    public void addMisProductosButtonHandler(EventHandler misProductosButtonHandler){
        MisProductos.setOnAction(misProductosButtonHandler); 
    }
    
    public void estiloBotones(Button btn, String base, String path){
        btn.setStyle("-fx-font: 12 Verdana; -fx-base: #"+base+";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG+path));
        btn.setGraphic(new ImageView(image));
        btn.setPrefSize(190, 130);
    }
     
    public void estiloLabels(Label lbl, String base){
        lbl.setPrefSize(380, 80);
        lbl.setStyle("-fx-font: 17 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #"+base+"; ");
        lbl.setAlignment(Pos.CENTER);
    }
    
    public void addCerrarSesionButtonHandler(EventHandler cerrarSesionButtonHandler){
        CerrarSesion.setOnAction(cerrarSesionButtonHandler);
    }
}