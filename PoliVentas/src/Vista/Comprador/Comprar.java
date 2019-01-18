package Vista.Comprador;

import Auxiliares.CONSTANTES;
import Auxiliares.PatronVistaTitulos;
import static Auxiliares.PatronVistaTitulos.crearTituloMenuPrincipal;
import Modelo.Producto;
import Vista.Administrador.VistaComun;
import javafx.event.ActionEvent;
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
public class Comprar {
    private final BorderPane root;
    private Button PagoEfectivo, PagoVirtual, back;
    private final Label nota;
    
    public BorderPane getRoot(){
        return root;
    }
    
    public Comprar(Producto p){
        root = new BorderPane();
        nota = new Label("Usted está a punto de comprar un@: "+ p.getNombre());//hay que establecer cantidad
        crearSeccionTituloComprador();
        createContent();
        setListeners();
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
  
    private void setListeners(){
        PagoEfectivo.setOnAction((ActionEvent e) -> {
            this.PagoVirtual.setDisable(true);
            //root.getScene().setRoot(new VistaBusquedaSencilla().getRoot());
        });    
        PagoVirtual.setOnAction((ActionEvent e) -> {
            this.PagoEfectivo.setDisable(true);
            //root.getScene().setRoot(new VistaComun("Búsqueda Avanzada", "A8B6FA",'C').getRoot());
        });
        back.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new VistaBusquedaSencilla().getRoot());
        });
        
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
}