package Vista;

import Auxiliares.*;
import Modelo.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
public class PaneBusquedaSencilla {
    private final BorderPane root;
    private Button buscarBtn, back;
    private TextField busquedaTfld;
    private final DBConnection c;
    private VBox vbox;
    private ObservableList<Producto> l_articulos;

    public BorderPane getRoot() {
        return root;
    }

    public PaneBusquedaSencilla() {
        root = new BorderPane();
        c = DBConnection.getInstance();
        BackgroundFill myBF = new BackgroundFill(Color.rgb(245, 255, 231), new CornerRadii(1), new Insets(0.0, 0.0, 0.0, 0.0));
        root.setBackground(new Background(myBF));
        inicializarObjetos();
        seccionResultadoBusqueda();
    }

    private VBox seccionEncabezado() {
        VBox encabezados = new VBox();
        Label lblTitle = new Label("Búsqueda Sencilla");
        lblTitle.setPrefSize(720, 80);
        lblTitle.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #274400; -fx-background-color: #E8FDA5; ");
        lblTitle.setAlignment(Pos.CENTER);
        encabezados.setAlignment(Pos.CENTER);         
        encabezados.getChildren().addAll(lblTitle);
        return encabezados;
    }
    
    private VBox seccionIngresarBusqueda(){
        VBox contenedorIngresoBusquedas = new VBox();
        GridPane gp = new GridPane();
        Label ingresoArticulo = new Label("Ingrese artículo: ");
        ingresoArticulo.setFont(new Font("Verdana", 15));
        gp.addColumn(0, ingresoArticulo);
        gp.addColumn(1, busquedaTfld);
        gp.addColumn(2, buscarBtn);
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
        v3.setPadding(new Insets(0, 7, 0, 7));//top,derecha,abajo,izquierda
        contenedorTitulos.setAlignment(Pos.CENTER);
        contenedorTitulos.setSpacing(7);
        contenedorTitulos.getChildren().addAll(seccionEncabezado(), seccionIngresarBusqueda());
        ScrollPane tv = new ScrollPane();
        setCompradorListener();
        //cargarContenido();
        v3.getChildren().add(tv);
        buscarBtn.setOnAction(e->{
            tv.setContent(vbox);
        });
        root.setTop(contenedorTitulos);
        root.setCenter(v3);
    }
    
    private void cargarLista(){
        l_articulos = FXCollections.observableArrayList();
        c.conectar();
        Producto.llenarArticulos(c.getConnection(), l_articulos);
        c.desconectar();
    }
    
    private void cargarContenido() {
        //cargarLista();
        for (Producto p : l_articulos){            
            HBox hb = new HBox();
            Label categoryNameLbl = new Label();
            Button buyButton = new Button("Comprar");
            buyButton.setOnAction(e-> 
            System.out.println("Comprar: " + p.getNombre()));
            categoryNameLbl.setText(p.getCategoria());
            hb.setSpacing(100);
            hb.getChildren().addAll(nombreProducto(p.getNombre()), buyButton);
            hb.setPadding(new Insets(7, 0, 7, 5));
            vbox.setPadding(new Insets(7, 25, 0, 5));
            vbox.getChildren().addAll(hb,categoryNameLbl,precioProducto(p.getPrecio()),
                    crearEstrellas(p.getCalificacion()),drawLine());
        }
    }
    
    private Label nombreProducto(String nombre){
        Label productNameLbl = new Label();
        productNameLbl.setFont(new Font("Verdana",12));
        productNameLbl.setText(nombre);
        return productNameLbl;
    }
    
    private Label precioProducto(double precio){
        Label priceLbl = new Label();
        priceLbl.setFont(new Font("Verdana",10));
        priceLbl.setText("$"+String.valueOf(precio));
        return priceLbl;
    }
    
    public Line drawLine(){
        Line linea = new Line(0, 0, 640, 0);
        linea.setStroke(Color.STEELBLUE);
        linea.setStrokeWidth(2);
        return linea;
    }
    
    public HBox crearEstrellas(int calificacion){
        HBox contenedorStars = new HBox();
        for (int i=0; i<calificacion;i++){
                Image image = new Image(CONSTANTES.PATH_IMG+"/star.png") ;
                ImageView iv2 = new ImageView();
                iv2.setImage(image);
                contenedorStars.getChildren().add(iv2);
            }
        contenedorStars.setPadding(new Insets(5, 25, 7, 5));
        return contenedorStars;
    }
    
    private void inicializarObjetos() {
        buscarBtn = new Button();
        back = new Button();
        busquedaTfld = new TextField();  
        vbox = new VBox();
        estiloBotones(back, "FFFFFF", "/back.png");
        estiloBotones(buscarBtn, "EAFF16","/search.png");
        busquedaTfld.setPrefWidth(300);
        busquedaTfld.setPrefHeight(40);
        root.setBottom(back);
    }    
    
    public void estiloBotones(Button btn, String base, String path){
        btn.setStyle("-fx-background-radius: 15em; -fx-min-width: 50px; -fx-min-height: 50px;"
                + " -fx-max-width: 50px; -fx-max-height: 50px; -fx-base: #"+base+";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG+path));
        btn.setGraphic(new ImageView(image));
        btn.setAlignment(Pos.CENTER);
    }
    
    private void setCompradorListener(){
        back.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new CompradorOptions().getRoot());            
        });
    }
}