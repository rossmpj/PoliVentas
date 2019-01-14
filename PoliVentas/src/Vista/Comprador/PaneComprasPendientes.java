package Vista.Comprador;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import org.controlsfx.control.Rating;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 *
 * @author Rosy
 */
public class PaneComprasPendientes {
    private final BorderPane root;
    private RadioButton  c, n;
    private Label EntregaATiempo;
    private Button CalificarVendedor, CalificarProducto, AnularPedido, Regresar;
    
    public BorderPane getRoot(){
        return root;
    }
    
    public PaneComprasPendientes(){
        root = new BorderPane();
        crearSeccionTituloComprador();
        inicializarBotones();
        crearSeccionProductos();
        seccionCalificaciones();
        setListeners();
    }
    
    private void inicializarBotones(){   
        CalificarProducto = new Button("Calificar producto");
        CalificarProducto.setStyle("-fx-font: 17 Verdana; ");
        CalificarVendedor = new Button("Calificar vendedor");
        CalificarVendedor.setStyle("-fx-font: 17 Verdana; ");
        AnularPedido = new Button("  Anular Pedido  ");
        AnularPedido.setStyle("-fx-font: 17 Verdana; ");
        EntregaATiempo = new Label("¿Entrega a tiempo?");
        EntregaATiempo.setStyle("-fx-font: 17 Verdana; ");
        Regresar = new Button("        Volver        ");
        Regresar.setStyle("-fx-font: 17 Verdana; ");
        ToggleGroup grupo = new ToggleGroup();
        c = new RadioButton("Si");
        c.setToggleGroup(grupo);
        n = new RadioButton("No");
        n.setToggleGroup(grupo);
    }
    
    private void seccionCalificaciones(){ 
        VBox vBoxCalif = new VBox();
        VBox entrega = new VBox();
        HBox h = new HBox();
        h.getChildren().addAll(c, n);
        h.setAlignment(Pos.CENTER);
        vBoxCalif.setSpacing(24);
        vBoxCalif.setAlignment(Pos.CENTER);
        h.setSpacing(65);
        vBoxCalif.setPadding(new Insets(8, 8, 8, 8));
        entrega.getChildren().addAll(EntregaATiempo, h);
        entrega.setSpacing(2);
        entrega.setPadding(new Insets(0, 10, 0, 10));
        vBoxCalif.getChildren().addAll(seccionCalificar(CalificarProducto), 
           seccionCalificar(CalificarVendedor), entrega, AnularPedido, Regresar);
        root.setLeft(vBoxCalif);
    } 
    
    private VBox seccionCalificar(Button btn){    
        Label lblCalif = new Label("Calificación: ");
        VBox verticalBox = new VBox();
        Rating ratingVendedor = new Rating();
        verticalBox.setSpacing(4);
        verticalBox.setPadding(new Insets(0, 8, 0, 8));
        verticalBox.getChildren().addAll(btn,lblCalif,ratingVendedor);
        ratingVendedor.ratingProperty().addListener((ObservableValue<? extends Number> o, Number n, Number n1) -> {
            lblCalif.setText("Calificación: "+ n1.toString());
        });
        return verticalBox;
    }
    
    private void crearSeccionTituloComprador(){
        Label comprador = new Label("Compras Pendientes");
        comprador.setPrefSize(720, 80);
        comprador.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #A8C5FA; ");
        comprador.setAlignment(Pos.CENTER);
        root.setTop(comprador);
    }
    
    private void crearSeccionProductos(){
        VBox contenedorTablaProductos = new VBox();
        TableView productos = new TableView();
        contenedorTablaProductos.setPadding(new Insets(10, 10, 10, 10));
        contenedorTablaProductos.getChildren().add(productos);
        root.setCenter(contenedorTablaProductos);
    }
    
    private void setListeners(){
        Regresar.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new CompradorOptions().getRoot());
        });          
    }
    
    public void estiloBotones(Button btn){
        btn.setStyle("-fx-font: 17 Verdana;");
    }
}
