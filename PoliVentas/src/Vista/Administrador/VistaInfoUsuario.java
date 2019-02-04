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
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    private String color;
    private String titulo;
    private Button guardar;
    private Button actualizar;
    private Button eliminar;
    private Button back;
    private TextField ci;
    private TextField nom;
    private TextField ape;
    private TextField tl;
    private TextField mail;
    private TextField mat;
    private TextField user;
    private TextField contra;
    private TextArea dir;
    public CheckBox wapp;
    public CheckBox eliminado;
    private ComboBox<String> rol;
    private ComboBox<String> nuevoRol;
    private Usuario u;

    public VistaInfoUsuario(boolean ingreso, String color, String titulo, Usuario u) {
        root = new BorderPane();
        this.ingreso = ingreso;
        this.color = color;
        this.titulo = titulo;
        this.u = u;
        crearSeccionTitulo();
        inicializarBotones();
        construccion();
        if (!this.ingreso) {
            llenarInformacion();
        }
    }

    private void inicializarBotones() {
        crearSeccionA();
        crearSeccionB();
        cargarCombo();
        gestionBotones();
    }

    private void crearSeccionA() {
        back = botonRegresarMenu();
        root.setBottom(back);
        ci = new TextField();
        ci.setPrefWidth(100);
        nom = new TextField();
        ape = new TextField();
        tl = new TextField();
        wapp = new CheckBox();
    }

    private void crearSeccionB() {
        mail = new TextField();
        mat = new TextField();
        user = new TextField();
        contra = new TextField();
        dir = new TextArea();
        dir.setPrefHeight(100);
        rol = new ComboBox();
        nuevoRol = new ComboBox();
        nuevoRol.setDisable(true);
    }

    private VBox gestionBotones() {
        VBox sa = new VBox();
        sa.setAlignment(Pos.CENTER);
        sa.setSpacing(5);
        if (this.ingreso) {
            guardar = new Button("Guardar");
            guardar.setPrefSize(180, 50);
            sa.getChildren().add(guardar);
        } else {
            ci.setDisable(true);
            crearExtraButton();
            sa.getChildren().addAll(eliminar, actualizar, crearExtra());
        }
        return sa;
    }

    private HBox crearExtra() {
        HBox g = new HBox();
        eliminado = new CheckBox();
        Label l = new Label("Este usuario está eliminado?");
        g.getChildren().addAll(l, eliminado);
        g.setSpacing(3);
        return g;
    }

    private void crearExtraButton() {
        actualizar = new Button("Actualizar");
        eliminar = new Button("Eliminar\nUsuario");
        actualizar.setPrefSize(180, 50);
        eliminar.setPrefSize(180, 50);
    }

    public void addBackButtonHandler(EventHandler agregarProductoButtonHandler) {
        back.setOnAction(agregarProductoButtonHandler);
    }

    public void addEliminarButtonHandler(EventHandler eliminarUButtonHandler) {
        eliminar.setOnAction(eliminarUButtonHandler);
    }

    public void addModificarButtonHandler(EventHandler modificarUButtonHandler) {
        actualizar.setOnAction(modificarUButtonHandler);
    }

    public void addAlmacenarButtonHandler(EventHandler almacenarUButtonHandler) {
        guardar.setOnAction(almacenarUButtonHandler);
    }

    private void construccion() {
        HBox hb = new HBox();
        VBox contenedor = new VBox();
        GridPane gp = new GridPane();
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(25);
        hb.setPadding(new Insets(0, 20, 0, 20));
        gp.addColumn(0, seccionAvatar(), gestionBotones());
        contenedor.getChildren().addAll(gp);
        hb.getChildren().addAll(formulario(), contenedor);
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
        HBox ne = new HBox();
        ne.getChildren().add(rol);
        extraH(ne);
        grandPrix.addColumn(0, cedula, nombres, apellidos, tlf, ws, email, direccion, matricula, roll, usser, cont);
        grandPrix.setHgap(10);
        grandPrix.setVgap(3);
        grandPrix.addColumn(1, ci, nom, ape, tl, wapp, mail, dir, mat, ne, user, contra);
        scawflone.setAlignment(Pos.CENTER);
        scawflone.getChildren().add(grandPrix);
        return scawflone;
    }

    private void extraH(HBox ne) {
        if (!this.ingreso) {
            Button b = new Button("CambiarRol");
            b.setOnAction(e -> {
                nuevoRol.setDisable(false);
            });
            ne.setSpacing(5);
            ne.getChildren().addAll(b, nuevoRol);
        }
    }

    private void crearSeccionTitulo() {
        root.setTop(crearTituloSubMenu(titulo, color));
    }

    private void cargarCombo() {
        String se[] = {"Administrador", "Comprador", "Vendedor"};
        if (this.ingreso) {
            rol.setItems(FXCollections.observableArrayList(se));
        } else {
            rol.setDisable(true);
            rol.setItems(FXCollections.observableArrayList(this.u.mostrarRol()));
            rol.getSelectionModel().selectFirst();
            nuevoRol.setItems(FXCollections.observableArrayList(se));
        }
    }

    public String seleccion() {
        return rol.getSelectionModel().getSelectedItem();
    }

    @Override
    public BorderPane getRoot() {
        return root;
    }

    private VBox seccionAvatar() {
        VBox k = new VBox();
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG + "/man.png"));
        Label myLabel = new Label();
        k.setAlignment(Pos.CENTER);
        myLabel.setGraphic(new ImageView(image));
        k.setPadding(new Insets(100, 0, 0, 5));
        k.getChildren().add(myLabel);
        return k;
    }

    public boolean validarCasillas() {
        return !ci.getText().equals("") && !nom.getText().equals("") && !ape.getText().equals("")
                && !tl.getText().equals("") && !mail.getText().equals("")
                && !mat.getText().equals("") && !user.getText().equals("") && !contra.getText().equals("")
                && !dir.getText().equals("") && !seleccion().equals("");
    }

    public void llenarInformacion() {
        if (!this.ingreso) {
            llenarInformacionA();
            llenarInformacionB();
        }
    }

    private void llenarInformacionA() {
        ci.setText(u.getCedula());
        nom.setText(u.getNombres());
        ape.setText(u.getApellidos());
        tl.setText(u.getTelefono());
        wapp.setSelected(u.isWhatsapp());
        mail.setText(u.getEmail());

    }

    private void llenarInformacionB() {
        mat.setText(u.getMatricula());
        user.setText(u.getUsuario());
        contra.setText(u.getContrasena());
        dir.setText(u.getDireccion());
        eliminado.setSelected(u.isEstado());
    }

    public Usuario updateUsuario() {
        return new Usuario(ci.getText(), nom.getText(), ape.getText(), tl.getText(), dir.getText(), wapp.isSelected(), mat.getText(),
                mail.getText(), user.getText(), contra.getText(), eliminado.isSelected());
    }

    public void limpiarCasillas() {
        limpiarA();
        user.setText(" ");
        contra.setText(" ");
        dir.setText(" ");
        if (!this.ingreso) {
            eliminado.setSelected(false);
        }
    }

    private void limpiarA() {
        ci.setText(" ");
        nom.setText(" ");
        ape.setText(" ");
        tl.setText(" ");
        wapp.setSelected(false);
        mail.setText(" ");
        mat.setText(" ");

    }

    public boolean isIngreso() {
        return ingreso;
    }

    public Button getGuardar() {
        return guardar;
    }

    public Button getActualizar() {
        return actualizar;
    }

    public Button getEliminar() {
        return eliminar;
    }

    public Button getBack() {
        return back;
    }

    public TextField getCi() {
        return ci;
    }

    public TextField getNom() {
        return nom;
    }

    public TextField getApe() {
        return ape;
    }

    public TextField getTl() {
        return tl;
    }

    public TextField getMail() {
        return mail;
    }

    public TextField getMat() {
        return mat;
    }

    public TextField getUser() {
        return user;
    }

    public TextField getContra() {
        return contra;
    }

    public TextArea getDir() {
        return dir;
    }

    public CheckBox getWapp() {
        return wapp;
    }

    public CheckBox getEliminado() {
        return eliminado;
    }

    public Usuario getU() {
        return u;
    }

}
