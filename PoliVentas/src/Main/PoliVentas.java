/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Vista.PaneLogin;
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

        PaneLogin p = new PaneLogin();
        scene = new Scene(new Group(), 700, 500);
        scene.setRoot(p.getRoot());
        primaryStage.setTitle("PoliVentas");
        primaryStage.setScene(scene);
        Image image = new Image("/recursos/logoo.jpg");
        primaryStage.getIcons().add(image);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    
}
