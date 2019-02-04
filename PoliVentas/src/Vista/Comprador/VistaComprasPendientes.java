package Vista.Comprador;

import static Auxiliares.PatronVistaTitulos.crearTituloSubMenu;
import Modelo.Pedido;
import Vista.Principal.Vista;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
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
public class VistaComprasPendientes implements Vista {
    private final BorderPane root;
    private RadioButton  si, no; 
    private Rating ratingVendedor;
    private Rating ratingProducto;
    private final TableView<Pedido> pedidos;
    private TableColumn<Pedido, String> colId,colPrecio,colCant, colFP,colFE,colLE,colV,colP;
    private Label EntregaATiempo, lblCalifP, lblCalifV;
    private Button CalificarVendedor, CalificarProducto, AnularPedido, Regresar;
    
    @Override
    public BorderPane getRoot(){
        return root;
    }
    
    public TableColumn<Pedido, String> getColId() {
        return colId;
    }

    public TableColumn<Pedido, String> getColPrecio() {
        return colPrecio;
    }

    public TableColumn<Pedido, String> getColCant() {
        return colCant;
    }

    public TableColumn<Pedido, String> getColFP() {
        return colFP;
    }

    public TableColumn<Pedido, String> getColFE() {
        return colFE;
    }

    public TableColumn<Pedido, String> getColLE() {
        return colLE;
    }

    public TableColumn<Pedido, String> getColV() {
        return colV;
    }

    public TableColumn<Pedido, String> getColP() {
        return colP;
    }

    public Rating getRatingVendedor() {
        return ratingVendedor;
    }

    public Rating getRatingProducto() {
        return ratingProducto;
    }

    public String getLblCalifP() {
        return lblCalifP.getText();
    }

    public void setLblCalifP(Label lblCalifP) {
        this.lblCalifP = lblCalifP;
    }

    public String getLblCalifV() {
        return lblCalifV.getText();
    }

    public void setLblCalifV(Label lblCalifV) {
        this.lblCalifV = lblCalifV;
    }
    
    
    public void addCalificarVendedorButtonHandler(EventHandler calificarVendedorButtonHandler){
        this.CalificarVendedor.setOnAction(calificarVendedorButtonHandler);
    }
    
    public void addCalificarProductoButtonHandler(EventHandler calificarProductoButtonHandler){
        this.CalificarProducto.setOnAction(calificarProductoButtonHandler);
    }
    
    public void addAnularPedidoButtonHandler(EventHandler anularPedidoButtonHandler){
        this.AnularPedido.setOnAction(anularPedidoButtonHandler);
    }
    
    public void addHabilitarSiHandler(EventHandler habilitarSiHandler) {
        si.setOnAction(habilitarSiHandler);
    }
    
    public void addHabilitarNoHandler(EventHandler habilitarNoHandler) {
        no.setOnAction(habilitarNoHandler);
    }

    public TableView<Pedido> getPedidos() {
        return pedidos;
    }
    
    public VistaComprasPendientes(){
        this.pedidos = new TableView<>();
        root = new BorderPane();
        crearSeccionTituloComprador();
        inicializarBotones();
        crearSeccionProductos();
        seccionCalificaciones();
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
        si = new RadioButton("Si");
        si.setToggleGroup(grupo);
        no = new RadioButton("No");
        no.setToggleGroup(grupo);
    }
    
    private void seccionCalificaciones(){ 
        VBox vBoxCalif = new VBox();
        VBox entrega = new VBox();
        HBox h = new HBox();
        h.getChildren().addAll(si, no);
        h.setAlignment(Pos.CENTER);
        vBoxCalif.setSpacing(24);
        vBoxCalif.setAlignment(Pos.CENTER);
        h.setSpacing(65);
        vBoxCalif.setPadding(new Insets(8, 8, 8, 8));
        entrega.getChildren().addAll(EntregaATiempo, h);
        entrega.setSpacing(2);
        entrega.setPadding(new Insets(0, 10, 0, 10));
        vBoxCalif.getChildren().addAll(seccionCalificarP(CalificarProducto), 
           seccionCalificarV(CalificarVendedor), entrega, AnularPedido, Regresar);
        root.setLeft(vBoxCalif);
    } 
    
    private VBox seccionCalificarP(Button btn){    
        Label lblCalif = new Label("Calificación: ");
        lblCalifP = new Label();
        VBox verticalBox = new VBox();
        HBox hb = new HBox();
        ratingVendedor = new Rating();
        ratingVendedor.setRating(0);
        verticalBox.setSpacing(4);
        verticalBox.setPadding(new Insets(0, 8, 0, 8));
        hb.getChildren().addAll(lblCalif, lblCalifP);
        verticalBox.getChildren().addAll(btn,hb,ratingVendedor);
        ratingVendedor.ratingProperty().addListener((ObservableValue<? extends Number> o, Number n, Number n1) -> {
            lblCalifP.setText(n1.toString());
        });
        return verticalBox;
    }
    
    private VBox seccionCalificarV(Button btn){    
        Label lblCalif = new Label("Calificación: ");
        lblCalifV = new Label();
        VBox verticalBox = new VBox();
        HBox hb = new HBox();
        ratingProducto = new Rating();
        ratingProducto.setRating(0);
        verticalBox.setSpacing(4);
        verticalBox.setPadding(new Insets(0, 8, 0, 8));
        hb.getChildren().addAll(lblCalif, lblCalifV);
        verticalBox.getChildren().addAll(btn,hb,ratingProducto);
        ratingProducto.ratingProperty().addListener((ObservableValue<? extends Number> o, Number n, Number n1) -> {
            lblCalifV.setText(n1.toString());
        });
        return verticalBox;
    }
    
    private void crearSeccionTituloComprador(){
        root.setTop(crearTituloSubMenu("Compras Pendientes","A8C5FA"));
    }
    
    private void crearSeccionProductos(){
        VBox contenedorTablaProductos = new VBox();
        contenedorTablaProductos.setPadding(new Insets(10, 10, 10, 10));
        addColumnsToTable();
        contenedorTablaProductos.getChildren().add(pedidos);
        root.setCenter(contenedorTablaProductos);
    }
    
    private void addColumnsToTable(){
        colId= new TableColumn<>("ID");
        colPrecio = new TableColumn<>("Costo");
        colCant= new TableColumn<>("Cantidad");
        colFP = new TableColumn<>("Fecha Pedido");
        colFE = new TableColumn<>("Fecha Entrega");
        colLE = new TableColumn<>("Lugar Entrega");
        colV = new TableColumn<>("Vendedor");
        colP = new TableColumn<>("Producto");
        this.pedidos.getColumns().addAll(this.colId,this.colPrecio,
                this.colCant, this.colFP, this.colFE,this.colLE,colV,colP);
    }
    
    public void addBackButtonHandler(EventHandler agregarProductoButtonHandler){
        Regresar.setOnAction(agregarProductoButtonHandler);
    }
    
    public Pedido getPed(){
        return this.pedidos.getSelectionModel().getSelectedItem();
    }
    
    public void estiloBotones(Button btn){
        btn.setStyle("-fx-font: 17 Verdana;");
    }
    
    public boolean validarSeleccion(){
        return ((this.getPed() == null) );
    }
}
