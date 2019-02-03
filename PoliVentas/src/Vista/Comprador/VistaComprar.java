package Vista.Comprador;

import Auxiliares.CONSTANTES;
import Auxiliares.PatronVistaTitulos;
import static Auxiliares.PatronVistaTitulos.crearTituloMenuPrincipal;
import Modelo.Producto;
import Vista.Principal.Vista;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Rosy
 */
public class VistaComprar implements Vista {
    private final BorderPane root;
    private Button PagoEfectivo, PagoVirtual, back;
    private final Label nota;
    private final Producto product;
    
    @Override
    public BorderPane getRoot(){
        return root;
    }
    
    public VistaComprar(Producto p){
        root = new BorderPane();
        product = p;
        nota = new Label("Usted está a punto de comprar un@: "+ p.getNombre()+p.getVendedor().getIdVendedor());//hay que establecer cantidad
        crearSeccionTituloComprador();
        createContent();
    }

    private void createContent(){
        inicializarBotones();
        HBox contentMenuComprador = new HBox();
        VBox content = new VBox();
        this.estiloLabels(nota, "E5FDA5");
        contentMenuComprador.setAlignment(Pos.CENTER); 
        content.setAlignment(Pos.CENTER); 
        contentMenuComprador.setSpacing(25);
        content.setSpacing(25);
        contentMenuComprador.setPadding(new Insets(10, 10, 10, 10));
        content.setPadding(new Insets(10, 10, 10, 10));
        contentMenuComprador.getChildren().addAll(this.PagoEfectivo, this.PagoVirtual);
        content.getChildren().addAll(nota, contentMenuComprador);
        root.setCenter(content);  
        root.setBottom(back);
    }
    
    private void inicializarBotones(){
        PagoEfectivo = new Button("Pago\nEfectivo");
        PagoVirtual = new Button("Pago\nVirtual");
        back = PatronVistaTitulos.botonRegresarMenu();
        back.setAlignment(Pos.CENTER);
        llamarBotones();        
    }
    
    private void llamarBotones(){
        estiloBotones(PagoEfectivo, "F1F7C4","/money.png");
        estiloBotones(PagoVirtual, "C4F7DA","/virtual.png");
    }
    
    private void crearSeccionTituloComprador(){
        root.setTop(crearTituloMenuPrincipal("Elija método de pago", "A5FDB9"));
    }
  
    public void addPagoEfectivoButtonHandler(EventHandler pagoEfectivoButtonHandler) {
        this.PagoEfectivo.setOnAction(pagoEfectivoButtonHandler);
    }
    
    public void addPagoVirtualButtonHandler(EventHandler pagoVirtualButtonHandler){
        this.PagoVirtual.setOnAction(pagoVirtualButtonHandler);
    }
    
    public void addBackButtonHandler(EventHandler backButtonHandler){
        this.back.setOnAction(backButtonHandler);
    }

    public Button getPagoEfectivo() {
        return PagoEfectivo;
    }

    public Button getPagoVirtual() {
        return PagoVirtual;
    }
    
    public void estiloLabels(Label lbl, String base){
        lbl.setPrefSize(625, 50);
        lbl.setStyle("-fx-font: 17 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #"+base+"; ");
        lbl.setAlignment(Pos.CENTER);
    }
    
    public void estiloBotones(Button btn, String base, String path){
        btn.setStyle("-fx-font: 12 Verdana; -fx-base: #"+base+";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG+path));
        btn.setGraphic(new ImageView(image));
        btn.setPrefSize(300, 300);
    }   
    
    public Producto getProduct() {
        return product;
    }
}