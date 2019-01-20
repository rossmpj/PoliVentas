
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Administrador;

import Auxiliares.CONSTANTES;
import static Auxiliares.PatronVistaTitulos.botonRegresarMenu;
import static Auxiliares.PatronVistaTitulos.crearTituloSubMenu;
import Modelo.Usuario;
import Vista.Principal.Vista;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/**
 *
 * @author Tiffy
 */
public class VistaBuscarUsuario implements Vista {

    private final BorderPane root;
    private Button back, buscar;
    private String color;
    private TextField campo;
    private ObservableList<Usuario> lusario;
    private VBox vbox;

    public VistaBuscarUsuario(String color) {
        root = new BorderPane();
        this.color = color;
        inicializarObjetos();
        crearSeccionTitulo();
        seccionResultadoBusqueda();

    }

    public BorderPane getRoot() {
        return root;
    }

    private void inicializarObjetos() {
        back = botonRegresarMenu();
        root.setBottom(back);
        buscar = new Button();
        estiloBotones(buscar, "A8ECDD", "/search.png");
        campo = new TextField();
        campo.setPrefWidth(350);
        campo.setPrefHeight(40);
        campo.setPromptText("Ingrese cédula de Identidad o nombres completos...");
        vbox= new VBox();
    }

    private void estiloBotones(Button btn, String base, String path) {
        btn.setStyle("-fx-background-radius: 15em; -fx-min-width: 50px; -fx-min-height: 50px;"
                + " -fx-max-width: 50px; -fx-max-height: 50px; -fx-base: #" + base + ";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG + path));
        btn.setGraphic(new ImageView(image));
        btn.setAlignment(Pos.CENTER);
    }

    public void addBackButtonHandler(EventHandler agregarProductoButtonHandler){
        back.setOnAction(agregarProductoButtonHandler);
    }

    private void crearSeccionTitulo() {
        root.setTop(crearTituloSubMenu("Buscar Usuario", color));
    }

    private VBox crearSeccionBusqueda() {
        VBox contenedorIngresoBusquedas = new VBox();
        GridPane gp = new GridPane();
        gp.addColumn(0, campo);
        gp.addColumn(1, buscar);
        gp.setHgap(15);
        gp.setVgap(10);
        gp.setAlignment(Pos.TOP_CENTER);
        contenedorIngresoBusquedas.setPadding(new Insets(5, 0, 0, 0));
        contenedorIngresoBusquedas.setAlignment(Pos.TOP_CENTER);
        contenedorIngresoBusquedas.getChildren().add(gp);
        return contenedorIngresoBusquedas;
    }

    private void seccionResultadoBusqueda() {
        VBox contenedorTitulos = new VBox();
        VBox v3 = new VBox();
        v3.setPadding(new Insets(0, 7, 0, 7));
        contenedorTitulos.setPadding(new Insets(0, 7, 0, 7));//top,derecha,abajo,izquierda
        contenedorTitulos.setAlignment(Pos.TOP_CENTER);
        contenedorTitulos.setSpacing(7);
        ScrollPane tv = new ScrollPane();
        v3.getChildren().add(tv);
        contenedorTitulos.getChildren().addAll(crearSeccionBusqueda(),v3);
        buscar.setOnAction(e -> {
            tv.setContent(vbox);
            cargarContenido();
        });
        
        root.setCenter(contenedorTitulos);
    }
    
     private Label nombreUsuario(String nombre) {
        Label productNameLbl = new Label();
        productNameLbl.setFont(new Font("Verdana", 12));
        productNameLbl.setText("Nombres: " + nombre);
        return productNameLbl;
    }

    private Label ciUsuario(String ci) {
        Label productNameLbl = new Label();
        productNameLbl.setFont(new Font("Verdana", 12));
        productNameLbl.setText("CI: " + ci);
        return productNameLbl;
    }
    
     public Line drawLine() {
        Line linea = new Line(0, 0, 780, 0);
        linea.setStroke(Color.STEELBLUE);
        linea.setStrokeWidth(2);
        return linea;
    }
     
     private void cargarLista() {
        lusario = FXCollections.observableArrayList();
    }
     
      private void cargarContenido() {
        cargarLista();
        for (Usuario p : this.lusario) {
            HBox hb = new HBox();
            Label categoryNameLbl = new Label();
            Button viewButton = new Button("Ver");
            viewButton.setOnAction(e
                    -> root.getScene().setRoot(new VistaInfoUsuario(false, "A8ECDD", "Ingreso nuevo usuario").getRoot()));
            categoryNameLbl.setText(p.getTelefono());
            hb.setSpacing(100);
            hb.getChildren().addAll(nombreUsuario(p.getNombres()+ " " + p.getApellidos()), viewButton);
            hb.setSpacing(50);
            hb.setPadding(new Insets(7, 0, 7, 5));
            vbox.setPadding(new Insets(7, 25, 0, 5));
            vbox.getChildren().addAll(hb, categoryNameLbl, ciUsuario(p.getCedula()),
                    drawLine());
        }
    }

    private VBox seccionAvatar() {
        VBox k = new VBox();
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG + "/man.png"));
        Label myLabel = new Label();
        myLabel.setGraphic(new ImageView(image));
        k.setPadding(new Insets(30, 0, 0, 5));
        k.getChildren().add(myLabel);
        return k;
    }
}
