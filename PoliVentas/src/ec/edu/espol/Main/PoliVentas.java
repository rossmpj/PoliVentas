package ec.edu.espol.Main;

import ec.edu.espol.Auxiliares.CONSTANTES;
import ec.edu.espol.Controlador.Comprador.ControladorArticulosMasBuscados;
import ec.edu.espol.Modelo.Producto;
import ec.edu.espol.Vista.Principal.ArticulosMasBuscados;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Rosa
 */
public class PoliVentas extends Application {
    public static Scene scene;

    @Override
    public void start(Stage primaryStage) {
        Producto ModeloProducto = new Producto();
        ArticulosMasBuscados p = new ArticulosMasBuscados(false);
        ControladorArticulosMasBuscados controller = new ControladorArticulosMasBuscados(ModeloProducto, p);
        scene = new Scene(new Group(), 850, 650);
        scene.setRoot(p.getRoot());
        primaryStage.setTitle("PoliVentas");
        primaryStage.setScene(scene);
        Image image = new Image(CONSTANTES.PATH_IMG + "/logoo.jpg");
        primaryStage.getIcons().add(image);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}