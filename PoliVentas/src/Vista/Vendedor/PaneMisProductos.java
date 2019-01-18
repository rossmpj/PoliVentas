package Vista.Vendedor;

import static Auxiliares.PatronVistaTitulos.crearTituloSubMenu;
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
public class PaneMisProductos {
    private final BorderPane root;
    private Button AgregarProducto, ModificarProducto, EliminarProducto, Regresar;
    
    public BorderPane getRoot(){
        return root;
    }
    
    public PaneMisProductos(){
        root = new BorderPane();
        crearSeccionTituloProductos();
        inicializarBotones();
        crearSeccionProductos();
        seccionCalificaciones();
        setListeners();
    }
    
    private void inicializarBotones(){   
        
        AgregarProducto = new Button("Agregar vendedor");
        AgregarProducto.setStyle("-fx-font: 17 Verdana; ");
        
        ModificarProducto = new Button("Modificar producto");
        ModificarProducto.setStyle("-fx-font: 17 Verdana; ");
        
        EliminarProducto = new Button("Eliminar producto");
        EliminarProducto.setStyle("-fx-font: 17 Verdana; ");
        
        Regresar = new Button("        Volver        ");
        Regresar.setStyle("-fx-font: 17 Verdana; ");
    }
    
    private void seccionCalificaciones(){ 
        VBox vBoxCalif = new VBox();
        
        vBoxCalif.setSpacing(24);
        vBoxCalif.setAlignment(Pos.CENTER);
        
        vBoxCalif.setPadding(new Insets(8, 8, 8, 8));
        
        vBoxCalif.getChildren().addAll(AgregarProducto, ModificarProducto, EliminarProducto, Regresar);
        root.setLeft(vBoxCalif);
    } 
    
    private void crearSeccionTituloProductos(){
        root.setTop(crearTituloSubMenu("Mis productos", "A8C5FA"));
    }
    
    private void crearSeccionProductos(){
        VBox contenedorTablaProductos = new VBox();
        TableView productos = new TableView();
        contenedorTablaProductos.setPadding(new Insets(10, 10, 10, 10));
        contenedorTablaProductos.getChildren().add(productos);
        root.setCenter(contenedorTablaProductos);
    }
    
    private void setListeners(){
        AgregarProducto.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new NuevoProducto().getRoot());
        });
        
        Regresar.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new VendedorOptions().getRoot());
        });          
    }
    
    public void estiloBotones(Button btn){
        btn.setStyle("-fx-font: 17 Verdana;");
    }
}
