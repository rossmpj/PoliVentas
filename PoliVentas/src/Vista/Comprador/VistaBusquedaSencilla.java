package Vista.Comprador;

import Auxiliares.*;
import static Auxiliares.PatronVistaTitulos.botonRegresarMenu;
import static Auxiliares.PatronVistaTitulos.crearTituloSubMenu;
import Vista.Principal.Vista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 *
 * @author Rosy
 */
public class VistaBusquedaSencilla implements Vista {
    private final BorderPane root;
    private Button buscarBtn, back, clean;
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
        setListeners();
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
    
    private void setListeners(){
        back.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new CompradorOptions().getRoot());            
        });          
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
    
}