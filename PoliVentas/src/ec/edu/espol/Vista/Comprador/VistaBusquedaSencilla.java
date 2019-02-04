package ec.edu.espol.Vista.Comprador;

import ec.edu.espol.Auxiliares.CONSTANTES;
import static ec.edu.espol.Auxiliares.PatronVistaTitulos.botonRegresarMenu;
import static ec.edu.espol.Auxiliares.PatronVistaTitulos.crearTituloSubMenu;
import ec.edu.espol.Vista.Principal.Vista;
import java.text.Normalizer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/**
 *
 * @author Rosy
 */
public class VistaBusquedaSencilla implements Vista {
    private final BorderPane root;
    private Button buscarBtn, back, clean, comprar;
    private TextField busquedaTextField;
    private VBox vbox;
    private ScrollPane busquedaScrollPane;

    @Override
    public BorderPane getRoot() {
        return root;
    }

    public VistaBusquedaSencilla() {
        root = new BorderPane();
        BackgroundFill myBF = new BackgroundFill(Color.rgb(245, 255, 231), new CornerRadii(1), new Insets(0.0, 0.0, 0.0, 0.0));
        root.setBackground(new Background(myBF));
        inicializarObjetos();
        seccionResultadoBusqueda();
    }

    private VBox seccionEncabezado() {
        return crearTituloSubMenu("Búsqueda Sencilla", "E8FDA5");
    }
    
    private VBox seccionIngresarBusqueda(){
        VBox contenedorIngresoBusquedas = new VBox();
        GridPane gp = new GridPane();
        gp.addColumn(0, busquedaTextField);
        gp.addColumn(1, buscarBtn);
        gp.addColumn(2, clean);
        gp.setHgap(15);
        gp.setVgap(10);
        gp.setAlignment(Pos.CENTER);
        contenedorIngresoBusquedas.setPadding(new Insets(10, 0, 10, 0));
        contenedorIngresoBusquedas.setAlignment(Pos.CENTER);
        contenedorIngresoBusquedas.getChildren().add(gp);
        return contenedorIngresoBusquedas;
    }

    private void seccionResultadoBusqueda() {
        VBox contenedorTitulos = new VBox();
        VBox v3 = new VBox();
        v3.setPadding(new Insets(0, 15, 0, 15));//top,derecha,abajo,izquierda
        contenedorTitulos.setAlignment(Pos.CENTER);
        contenedorTitulos.setSpacing(7);
        contenedorTitulos.getChildren().addAll(seccionEncabezado(), seccionIngresarBusqueda());
        busquedaScrollPane = new ScrollPane();
        v3.getChildren().add(busquedaScrollPane);
        root.setTop(contenedorTitulos);
        root.setCenter(v3);
    }
        
    private void inicializarObjetos() {
        buscarBtn = new Button();
        back = botonRegresarMenu();
        clean = new Button();
        busquedaTextField = new TextField(); 
        busquedaTextField.setPromptText("Ingrese producto..."); 
        vbox = new VBox();
        estiloBotones(buscarBtn, "EAFF16","/search.png");
        estiloBotones(clean, "EAFF26","/eraser.png");
        busquedaTextField.setPrefWidth(350);
        busquedaTextField.setPrefHeight(40);
        root.setBottom(back);
    }     
    
    public void estiloBotones(Button btn, String base, String path){
        btn.setStyle("-fx-background-radius: 15em; -fx-min-width: 50px; -fx-min-height: 50px;"
                + " -fx-max-width: 50px; -fx-max-height: 50px; -fx-base: #"+base+"; ");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG+path));
        btn.setGraphic(new ImageView(image));
        btn.setAlignment(Pos.CENTER);
    }
    
    public void addBackButtonHandler(EventHandler agregarProductoButtonHandler){
        back.setOnAction(agregarProductoButtonHandler);
    }
    
    public void addBuscarButtonHandler(EventHandler buscarButtonHandler){
        this.buscarBtn.setOnAction(buscarButtonHandler);
    }
        
    public String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto.replaceAll("[^\\w\\s]","").toLowerCase();
    } 
    
    public void addComprarButtonHandler(EventHandler buyButtonHandler) {
        comprar.setOnAction(buyButtonHandler);
    }
    
    public void addCleanButtonHandler(EventHandler cleanButtonHandler){
        this.clean.setOnAction(cleanButtonHandler);
    }
    
    public String getBusquedaTextField(){
        return this.busquedaTextField.getText();
    }
    
    public void setBusquedaTextField(String texto){
        this.busquedaTextField.setText(texto);
    }
    
    public VBox getVBoxProductosEncontrados(){
        return this.vbox;
    }
    
    public ScrollPane getBusquedaScrollPane() {
        return busquedaScrollPane;
    }

    public void setBusquedaScrollPane(VBox contenedor) {
        this.busquedaScrollPane.setContent(contenedor);
    }
    
    public Line drawLine(){
        Line linea = new Line(0, 0, 640, 0);
        linea.setStroke(Color.STEELBLUE);
        linea.setStrokeWidth(2);
        return linea;
    }
    
    public VBox nombreProducto(String nombre){
        VBox v = new VBox();
        Label productNameLbl = new Label("Entrega máxima: "+nombre);
        v.getChildren().add(productNameLbl);
        return v;
    }
    
    public Label precioProducto(double precio){
        Label priceLbl = new Label();
        priceLbl.setFont(new Font("Verdana",14));
        priceLbl.setText("$"+String.valueOf(precio));
        return priceLbl;
    }
    
    public HBox crearEstrellas(int calificacion, String n){
        HBox contenedorStars = new HBox();
        HBox hb = new HBox();
        Label l = new Label("Calificación " + n + ": ");
        for (int i=0; i<calificacion;i++){
                Image image = new Image(CONSTANTES.PATH_IMG + "/star.png") ;
                ImageView iv2 = new ImageView();
                iv2.setImage(image);
                contenedorStars.getChildren().add(iv2);
            }
        hb.getChildren().addAll(l, contenedorStars);
        return hb;
    }
    
    public Button getComprar() {
        return comprar;
    }

    public void setComprar(Button comprar) {
        this.comprar = comprar;
    }

    public void iniciarCompra() {
        comprar = new Button("Comprar");
    }
}