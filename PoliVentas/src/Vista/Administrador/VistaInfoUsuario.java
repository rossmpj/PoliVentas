/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Administrador;

import Auxiliares.CONSTANTES;
import static Auxiliares.PatronVistaTitulos.botonRegresarMenu;
import static Auxiliares.PatronVistaTitulos.crearTituloSubMenu;
import Vista.Principal.Vista;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Tiffy
 */
public class VistaInfoUsuario implements Vista {

    private final BorderPane root;
    private boolean ingreso;
    private String color, titulo;
    private Button guardar, actualizar, eliminar, back;
    private TextField ci, nom, ape, tl, wapp, mail, mat, user, contra;
    private TextArea dir;
    private ComboBox<String> rol;

    public VistaInfoUsuario(boolean ingreso, String color, String titulo) {
        root = new BorderPane();
        this.ingreso = ingreso;
        this.color = color;
        this.titulo = titulo;
        crearSeccionTitulo();
        inicializarBotones();
        construccion();
        
    }

    private void inicializarBotones() {
        back = botonRegresarMenu();
        root.setBottom(back);
        ci = new TextField();
        ci.setPrefWidth(100);
        nom = new TextField();
        ape = new TextField();
        tl = new TextField();
        wapp = new TextField();
        mail = new TextField();
        mat = new TextField();
        user = new TextField();
        contra = new TextField();
        dir = new TextArea();
        dir.setPrefHeight(100);
        rol = new ComboBox();
        cargarCombo();
        gestionBotones();
    }

    private VBox gestionBotones() {
        VBox sa = new VBox();
        sa.setAlignment(Pos.CENTER_RIGHT);
        if (this.ingreso) {
            guardar = new Button("Guardar");
            guardar.setPrefSize(100, 50);
            sa.getChildren().add(guardar);
        } else {
            actualizar = new Button("Actualizar");
            eliminar = new Button("Eliminar\nUsuario");
            actualizar.setPrefSize(100, 50);
            eliminar.setPrefSize(100, 50);
            sa.getChildren().addAll(actualizar, eliminar);
        }
        return sa;
    }

    public void addBackButtonHandler(EventHandler agregarProductoButtonHandler){
        back.setOnAction(agregarProductoButtonHandler);
    }

    private void construccion() {
        HBox hb = new HBox();
        VBox contenedor = new VBox();
        hb.setAlignment(Pos.CENTER);
        contenedor.setSpacing(10);
        hb.setSpacing(15);
        hb.setPadding(new Insets(0, 20, 0, 20));//top,derecha,abajo,izquierda
        contenedor.getChildren().addAll(seccionAvatar(),gestionBotones());
        hb.getChildren().addAll(formulario(),contenedor);
        root.setCenter(hb);
    }

    private VBox formulario() {
        VBox scawflone = new VBox();
        GridPane grandPrix = new GridPane();
        Label cedula = new Label("Cédula");
        Label nombres = new Label("Nombres");
        Label apellidos = new Label("Apellidos");
        Label tlf = new Label("Teléfono");
        Label ws = new Label("Whatsapp");
        Label email = new Label("Email");
        Label direccion = new Label("Dirección");
        Label matricula = new Label("Matrícula");
        Label roll = new Label("Rol");
        Label usser = new Label("Usuario");
        Label cont = new Label("Contraseña");
        grandPrix.addColumn(0, cedula, nombres, apellidos, tlf, ws, email, direccion, matricula, roll, usser, cont);
        grandPrix.addColumn(1, ci, nom, ape, tl, wapp, mail, dir, mat, rol, user, contra);
        grandPrix.setHgap(10);
        grandPrix.setVgap(3);
        scawflone.setAlignment(Pos.CENTER);
        scawflone.getChildren().add(grandPrix);
        return scawflone;
    }

    private void crearSeccionTitulo() {
        root.setTop(crearTituloSubMenu(titulo, color));
    }

    /**
     * De acuerdo a lo seleccionado en el combo, se aplicarán los filtros
     */
    private void cargarCombo() {
        String se[] = {"Administrador","Comprador", "Vendedor"};
        rol.setItems(FXCollections.observableArrayList(se));
    }

    public BorderPane getRoot() {
        return root;
    }

    private void estiloBotones(Button btn, String base, String path) {
        btn.setStyle("-fx-background-radius: 15em; -fx-min-width: 50px; -fx-min-height: 50px;"
                + " -fx-max-width: 50px; -fx-max-height: 50px; -fx-base: #" + base + ";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG + path));
        btn.setGraphic(new ImageView(image));
        btn.setAlignment(Pos.CENTER);
    }
    
    private VBox seccionAvatar() {
        VBox k = new VBox();
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG+"/man.png"));
        Label myLabel = new Label();
        myLabel.setGraphic(new ImageView(image));
        k.setPadding(new Insets(30, 0, 0, 5));
        k.getChildren().add(myLabel);
        return k;
    }
}
