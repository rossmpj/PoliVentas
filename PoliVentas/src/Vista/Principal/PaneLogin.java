package Vista.Principal;

import Auxiliares.CONSTANTES;
import Vista.Administrador.VistaInfoUsuario;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author ROSA
 */
public class PaneLogin {
    private final BorderPane root;
    private Button login, signIn;
    private TextField user;
    private PasswordField contra;
    
    public BorderPane getRoot() {
        return root;
    }

    public PaneLogin() {
        root = new BorderPane();
        BackgroundFill myBF = new BackgroundFill(Color.ALICEBLUE, new CornerRadii(1), new Insets(0.0, 0.0, 0.0, 0.0));
        root.setBackground(new Background(myBF));
        inicializarObjetos();
        pantallaLogin();
    }

    private VBox encabezado() {
        VBox encabezados = new VBox();
        Label lblWelcome = new Label("Bienvenido");
        lblWelcome.setFont(new Font("Verdana",30));
        lblWelcome.setStyle("-fx-text-fill: #000278; -fx-font-weight: bold;");
        lblWelcome.setAlignment(Pos.CENTER);
        encabezados.setAlignment(Pos.CENTER);
        Image image = new Image(CONSTANTES.PATH_IMG+"/logoo.jpg") ;
        ImageView iv2 = new ImageView();
         iv2.setImage(image);
         iv2.setFitWidth(150);
         iv2.setPreserveRatio(true);
         iv2.setSmooth(true);
         iv2.setCache(true);
        encabezados.setSpacing(10);
        encabezados.getChildren().addAll(lblWelcome,iv2);
        return encabezados;
    }

    private void pantallaLogin() {
        VBox vb = new VBox();
        VBox v2 = new VBox();
        GridPane gp = new GridPane();
        Label l2 = new Label("Usuario");
        l2.setFont(new Font("Verdana", 17));
        Label l = new Label("Contraseña");
        l.setFont(new Font("Verdana", 17));
        gp.addColumn(0, l2, l);
        gp.addColumn(1, user, contra);
        gp.setHgap(10);
        gp.setVgap(20);
        gp.setAlignment(Pos.CENTER);
        v2.setPadding(new Insets(30, 0, 30,0));
        v2.setAlignment(Pos.CENTER);
        v2.getChildren().add(gp);
        vb.setPadding(new Insets(40, 0, 40, 0));//top,derecha,abajo,izquierda
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
        vb.getChildren().addAll(encabezado(), v2, boton());
        setLoginListener();
        root.setTop(vb);
    }

    private void inicializarObjetos() {
        login = new Button("Ingresar");
        signIn = new Button("Registrarse");
        estiloBotones(login, "0B93FE");
        estiloBotones(signIn, "0059A0");
        user = new TextField();
        user.setPrefWidth(300);
        user.setPrefHeight(50);
        contra = new PasswordField();
        contra.setPrefWidth(300);
        contra.setPrefHeight(50);
    }

    private VBox boton() {
        VBox v = new VBox();
        v.getChildren().addAll(login, signIn);
        v.setAlignment(Pos.CENTER);
        v.setSpacing(7);
        login.setDefaultButton(true);
        return v;
    }
    
    private void setLoginListener(){
        login.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new VistaTemporal().getRoot());
        });
        signIn.setOnAction((ActionEvent e) -> {
            root.getScene().setRoot(new VistaInfoUsuario(true, "FADCA8", "Formulario de Registro").getRoot());
        });
    }
    
    private void estiloBotones(Button btn, String colorHEX){
        btn.setAlignment(Pos.CENTER);
        btn.setPrefSize(150, 50);
        btn.setStyle("-fx-font: 17 Verdana;  -fx-base: #"+colorHEX+"; -fx-text-fill: white;");
        
    }
}