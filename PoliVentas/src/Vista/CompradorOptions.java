package Vista;

import Auxiliares.CONSTANTES;
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
public class CompradorOptions {   
    private final BorderPane root;
    private Button BusquedaSencilla, BusquedaAvanzada, ComprasPendientes,
     Historial, ArticulosMasBuscados, NuevosArticulos, CerrarSesion;
    
    public BorderPane getRoot(){
        return root;
    }
    
    public CompradorOptions(){
        root = new BorderPane();
        crearSeccionTituloComprador();
        createContent();
        setListeners();
    }

    private void createContent(){
        inicializarBotones();
        VBox contentMenuComprador = new VBox();
        contentMenuComprador.setAlignment(Pos.CENTER); 
        contentMenuComprador.setPadding(new Insets(10, 10, 10, 10));
        contentMenuComprador.getChildren().addAll(GridPaneSeccion1(),GridPaneSeccion2());
        root.setCenter(contentMenuComprador);  
    }
    
    private void inicializarBotones(){
        BusquedaSencilla = new Button("Búsqueda\nSencilla");
        BusquedaAvanzada = new Button("Búsqueda\nAvanzada");
        ComprasPendientes = new Button("Compras\nPendientes");
        Historial = new Button("Historial");
        ArticulosMasBuscados = new Button("Articulos\nMás\nBuscados");
        NuevosArticulos = new Button("Nuevos\nArtículos");
        CerrarSesion = new Button("Cerrar\nSesión");
        llamarBotones();        
    }
    
    private void llamarBotones(){
        estiloBotones(BusquedaSencilla, "A8EFFA","/searchS.png");
        estiloBotones(BusquedaAvanzada, "A8B6FA","/searchA.png");
        estiloBotones(ComprasPendientes, "FAA8DB","/stopwatch.png");
        estiloBotones(Historial, "FAB1A8","/history.png");
        estiloBotones(ArticulosMasBuscados, "CEFAA8","/loupe.png");
        estiloBotones(NuevosArticulos, "E6A8FA","/newProduct.png");
        estiloBotones(CerrarSesion, "FAEDA8","/logout.png");
    }
    
    private GridPane GridPaneSeccion1(){
        GridPane gp = new GridPane();
        gp.add(crearSeccionBusquedas(), 0, 0);
        gp.add(crearSeccionPedidos(), 3, 0);
        gp.setHgap(10);
        gp.setVgap(30);
        gp.setAlignment(Pos.CENTER);
        return gp;
    }
    
    private GridPane GridPaneSeccion2(){
        GridPane gp1 = new GridPane();gp1.add(ArticulosMasBuscados, 0, 2);
        gp1.add(NuevosArticulos, 1, 2);
        gp1.add(CerrarSesion, 2, 2); 
        gp1.setHgap(79);
        gp1.setVgap(30);
        gp1.setAlignment(Pos.CENTER);
        return gp1;
    }
    
    private void crearSeccionTituloComprador(){
        Label comprador = new Label("Menú Comprador");
        comprador.setPrefSize(720, 80);
        comprador.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #AEA8FA; ");
        comprador.setAlignment(Pos.CENTER);
        root.setTop(comprador);
    }
    
    private VBox crearSeccionBusquedas(){
        VBox busqueda = new VBox();
        HBox busqueda1 = new HBox();
        Label lblTitle = new Label("Búsqueda");
        estiloLabels(lblTitle, "000FA7");
        busqueda1.getChildren().addAll(BusquedaSencilla,BusquedaAvanzada);
        busqueda.getChildren().addAll(lblTitle, busqueda1);
        return busqueda;
    }
    
    private VBox crearSeccionPedidos(){
        VBox pedido = new VBox();
        HBox pedido1 = new HBox();
        Label lblPedidos = new Label("Mis Pedidos");
        estiloLabels(lblPedidos,"A73300");
        pedido1.getChildren().addAll(ComprasPendientes,Historial);
        pedido.getChildren().addAll(lblPedidos, pedido1);
        return pedido;
    }
    
    private void setListeners(){
        BusquedaSencilla.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new PaneBusquedaSencilla().getRoot());
        });          
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
}