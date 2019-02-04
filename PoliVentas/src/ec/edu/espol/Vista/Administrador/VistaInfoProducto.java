/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.Vista.Administrador;

import ec.edu.espol.Auxiliares.CONSTANTES;
import static ec.edu.espol.Auxiliares.PatronVistaTitulos.botonRegresarMenu;
import static ec.edu.espol.Auxiliares.PatronVistaTitulos.crearTituloSubMenu;
import ec.edu.espol.Modelo.Producto;
import ec.edu.espol.Vista.Principal.Vista;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
public class VistaInfoProducto implements Vista {

    private final BorderPane root;
    private boolean ingreso;
    private String color;
    private String titulo;
    private Button guardar;
    private Button actualizar;
    private Button eliminar;
    private Button back;
    private TextField id;
    private TextField nombre;
    private TextField categoria;
    private TextField precio;
    private TextField cantidad;
    private TextField vendedor;
    private TextArea descripcion;
    private CheckBox eliminado;
    private Producto p;

    public VistaInfoProducto(boolean ingreso, String color, String titulo, Producto p) {
        root = new BorderPane();
        this.ingreso = ingreso;
        this.color = color;
        this.titulo = titulo;
        this.p = p;
        crearSeccionTitulo();
        inicializarObjetos();
        construccion();
        if (!this.ingreso) {
            llenarInformacion();
        }
    }

    private void llenarInformacion() {
        if (!this.ingreso) {
            id.setText(p.getIdProducto());
            nombre.setText(p.getNombre());
            categoria.setText(p.getCategoria());
            precio.setText(String.valueOf(p.getPrecio()));
            cantidad.setText(String.valueOf(p.getStock()));
            vendedor.setText(p.getIdVendedor());
            descripcion.setText(p.getDescripcion());
            eliminado.setSelected(p.isEstado());
        }
    }

    public Producto updateProducto() {
        return new Producto(getId().getText(), getNombre().getText(), getDescripcion().getText(),
                Double.valueOf(getPrecio().getText()), getCategoria().getText(), Integer.valueOf(getCantidad().getText()),
                getEliminado().isSelected(), 0, getVendedor().getText());
    }

    private void inicializarObjetos() {
        back = botonRegresarMenu();
        root.setBottom(back);
        nombre = new TextField();
        nombre.setPrefWidth(100);
        id = new TextField();
        categoria = new TextField();
        precio = new TextField();
        cantidad = new TextField();
        vendedor = new TextField();
        descripcion = new TextArea();
        descripcion.setPrefHeight(100);
        eliminado = new CheckBox();
        gestionBotones();
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
            id.setDisable(true);
            crearExtraC();
            sa.getChildren().addAll(actualizar, eliminar, crearExtraB());
        }
        return sa;
    }

    private HBox crearExtraB() {
        HBox g = new HBox();
        eliminado = new CheckBox();
        Label l = new Label("Este producto está eliminado?");
        g.getChildren().addAll(l, eliminado);
        g.setSpacing(3);
        return g;
    }

    private void crearExtraC() {
        actualizar = new Button("Actualizar");
        eliminar = new Button("Eliminar\nProducto");
        actualizar.setPrefSize(180, 50);
        eliminar.setPrefSize(180, 50);
    }

    public void addBackButtonHandler(EventHandler agregarProductoButtonHandler) {
        back.setOnAction(agregarProductoButtonHandler);
    }

    public void addEliminarButtonHandler(EventHandler eliminarButtonHandler) {
        eliminar.setOnAction(eliminarButtonHandler);
    }

    public void addModificarButtonHandler(EventHandler modificarButtonHandler) {
        actualizar.setOnAction(modificarButtonHandler);
    }

    public void addAlmacenarButtonHandler(EventHandler almacenarButtonHandler) {
        guardar.setOnAction(almacenarButtonHandler);
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
        Label ide = new Label("Código");
        Label nom = new Label("Nombre");
        Label des = new Label("Descripción");
        Label pre = new Label("Precio");
        Label cant = new Label("Cantidad");
        Label cat = new Label("Categoría");
        Label idv = new Label("Id Vendedor");
        grandPrix.addColumn(0, ide, nom, des, pre, cant, cat, idv);
        grandPrix.addColumn(1, id, nombre, descripcion, precio, cantidad, categoria, vendedor);
        grandPrix.setHgap(15);
        grandPrix.setVgap(15);
        scawflone.setPadding(new Insets(30, 10, 0, 20));
        scawflone.setAlignment(Pos.TOP_CENTER);
        scawflone.getChildren().add(grandPrix);
        return scawflone;
    }

    public void limpiarCasillas() {
        id.setText(" ");
        nombre.setText(" ");
        categoria.setText(" ");
        precio.setText(" ");
        cantidad.setText(" ");
        vendedor.setText(" ");
        descripcion.setText(" ");
        eliminado.setSelected(false);
    }

    public boolean validarCasillas() {
        return !id.getText().equals("") && !nombre.getText().equals("") && !categoria.getText().equals("")
                && !precio.getText().equals("") && !cantidad.getText().equals("")
                && !vendedor.getText().equals("") && !descripcion.getText().equals("");
    }

    private void crearSeccionTitulo() {
        root.setTop(crearTituloSubMenu(titulo, color));
    }

    @Override
    public BorderPane getRoot() {
        return root;
    }

    private VBox seccionAvatar() {
        VBox k = new VBox();
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG + "/cesta.png"));
        Label myLabel = new Label();
        myLabel.setGraphic(new ImageView(image));
        k.setAlignment(Pos.CENTER);
        k.setPadding(new Insets(100, 0, 0, 5));
        k.getChildren().add(myLabel);
        return k;
    }

    public boolean isIngreso() {
        return ingreso;
    }

    public String getColor() {
        return color;
    }

    public String getTitulo() {
        return titulo;
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

    public TextField getId() {
        return id;
    }

    public TextField getNombre() {
        return nombre;
    }

    public TextField getCategoria() {
        return categoria;
    }

    public TextField getPrecio() {
        return precio;
    }

    public TextField getCantidad() {
        return cantidad;
    }

    public TextField getVendedor() {
        return vendedor;
    }

    public TextArea getDescripcion() {
        return descripcion;
    }

    public CheckBox getEliminado() {
        return eliminado;
    }

    public Producto getP() {
        return p;
    }

}
