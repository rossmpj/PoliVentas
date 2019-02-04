package ec.edu.espol.Vista.Comprador;

import ec.edu.espol.Auxiliares.CONSTANTES;
import ec.edu.espol.Auxiliares.PatronVistaTitulos;
import static ec.edu.espol.Auxiliares.PatronVistaTitulos.crearTituloMenuPrincipal;
import ec.edu.espol.Modelo.Producto;
import ec.edu.espol.Vista.Principal.Vista;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
    private Spinner<Integer> spinner;
    private TextField lugar;
    
    @Override
    public BorderPane getRoot(){
        return root;
    }
    
    public VistaComprar(Producto p){
        root = new BorderPane();
        product = p;
        nota = new Label("Usted está a punto de comprar un@: " + p.getNombre()
                + "\nCódigo vendedor: " + p.getCalificacionV().getIdVendedor());
        crearSeccionTituloComprador();
        createContent();
    }

    private void createContent(){
        inicializarBotones();
        HBox contentMenuComprador = new HBox();
        VBox content = new VBox();
        VBox grandprix = new VBox();
        GridPane gp = new GridPane();
        this.estiloLabels(nota, "D2F378");
        Label descripcion = new Label();
        descripcion.setText("Lugar de entrega");
        Label cantidad = new Label("Cantidad ");
        gp.addColumn(0, descripcion, cantidad);
        gp.addColumn(1, lugar, spinner);
        gp.setStyle("-fx-base:EEFEC2");
        gp.setHgap(25);
        gp.setVgap(5);
        gp.setAlignment(Pos.CENTER);
        grandprix.getChildren().addAll(nota, gp);
        grandprix.setAlignment(Pos.CENTER);
        contentMenuComprador.setAlignment(Pos.CENTER); 
        content.setAlignment(Pos.CENTER); 
        contentMenuComprador.setSpacing(25);
        content.setSpacing(25);
        contentMenuComprador.setPadding(new Insets(10, 10, 10, 10));
        content.setPadding(new Insets(10, 10, 10, 10));
        contentMenuComprador.getChildren().addAll(this.PagoEfectivo, this.PagoVirtual);
        content.getChildren().addAll(grandprix, contentMenuComprador);
        root.setCenter(content);  
        root.setBottom(back);
    }
    
    private void inicializarBotones(){
        PagoEfectivo = new Button("Pago\nEfectivo");
        PagoVirtual = new Button("Pago\nVirtual");
        back = PatronVistaTitulos.botonRegresarMenu();
        back.setAlignment(Pos.CENTER);
         spinner = new Spinner();
        SpinnerValueFactory<Integer> valueFactory
                = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE, 1);
        spinner.setValueFactory(valueFactory);
        lugar= new TextField();
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
    
     public int getCantidadElegida() {
            return Integer.parseInt(spinner.getEditor().getText());

    }

    public TextField getLugar() {
        return lugar;
    }
     
}