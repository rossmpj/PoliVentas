package Vista.Vendedor;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


/**
 *
 * @author Rosy
 */
public class VentasPendientes {
    private final BorderPane root;
    private Button AnularVenta, VerMapa, Regresar;
    
    public BorderPane getRoot(){
        return root;
    }
    
    public VentasPendientes(){
        root = new BorderPane();
        crearSeccionTituloVentasPendientes();
        inicializarBotones();
        crearSeccionVentasPendientes();
        seccionCalificaciones();
        setListeners();
    }
    
    private void inicializarBotones(){   
        
        AnularVenta = new Button("Anular venta");
        AnularVenta.setStyle("-fx-font: 17 Verdana; ");
        
        VerMapa = new Button("Ver en el mapa");
        VerMapa.setStyle("-fx-font: 17 Verdana; ");
        
        Regresar = new Button("        Volver        ");
        Regresar.setStyle("-fx-font: 17 Verdana; ");
    }
    
    private void seccionCalificaciones(){ 
        VBox vBoxCalif = new VBox();
        
        vBoxCalif.setSpacing(24);
        vBoxCalif.setAlignment(Pos.CENTER);
        
        vBoxCalif.setPadding(new Insets(8, 8, 8, 8));
        
        vBoxCalif.getChildren().addAll(AnularVenta, VerMapa, Regresar);
        root.setLeft(vBoxCalif);
    } 
    
    private void crearSeccionTituloVentasPendientes(){
        Label comprador = new Label("Mis ventas pendientes");
        comprador.setPrefSize(720, 80);
        comprador.setStyle("-fx-font: 25 Verdana; -fx-text-fill: #FFFFFF; -fx-background-color: #A8C5FA; ");
        comprador.setAlignment(Pos.CENTER);
        root.setTop(comprador);
    }
    
    private void crearSeccionVentasPendientes(){
        VBox contenedorTablaProductos = new VBox();
        TableView productos = new TableView();
        contenedorTablaProductos.setPadding(new Insets(10, 10, 10, 10));
        contenedorTablaProductos.getChildren().add(productos);
        root.setCenter(contenedorTablaProductos);
    }
    
    private void setListeners(){
        
        Regresar.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new VendedorOptions().getRoot());
        });          
    }
    
    public void estiloBotones(Button btn){
        btn.setStyle("-fx-font: 17 Verdana;");
    }
}
