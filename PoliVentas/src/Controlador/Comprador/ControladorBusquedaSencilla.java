package Controlador.Comprador;

import Auxiliares.*;
import Controlador.Principal.WindowsController;
import Modelo.CalificacionProducto;
import Modelo.CalificacionVendedor;
import Modelo.Producto;
import Vista.Comprador.Comprar;
import Vista.Comprador.VistaBusquedaSencilla;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

/**
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorBusquedaSencilla {
    
    private final Producto ModeloProducto;
    private final VistaBusquedaSencilla VistaBusquedaSencilla;
    private ObservableList<Producto> l_articulos;

    public ControladorBusquedaSencilla(Producto ModeloProducto, VistaBusquedaSencilla VistaBusquedaSencilla) {
        this.ModeloProducto = ModeloProducto;
        this.VistaBusquedaSencilla = VistaBusquedaSencilla;
        this.l_articulos = FXCollections.observableArrayList();
        this.VistaBusquedaSencilla.addBackButtonHandler((event -> WindowsController.previous()));
        this.VistaBusquedaSencilla.addBuscarButtonHandler(new BuscarButtonHandler());
        this.VistaBusquedaSencilla.addCleanButtonHandler(new CleanButtonHandler());
    }
    
    public void buscarArticulos(String nom, String desc, Connection c, ObservableList<Producto> lista){
        try {
            String consulta = "SELECT distinct p.id_producto, p.nombre, p.num_busquedas, p.descripcion, p.categoria, p.precio, "
                    + "cp.calificacion_producto, cv.calificacion_vendedor, "
                    + "e.fecha_entrega FROM tb_producto p, tb_calificacion_producto cp, "
                    + "tb_vendedor v, tb_calificacion_vendedor cv, tb_pedido e "
                    + "where p.id_producto = cp.id_producto and "
                    + "p.id_vendedor = v.id_vendedor and "
                    + "v.id_vendedor = cv.id_vendedor and "
                    + "v.id_vendedor = e.id_vendedor_ped and (p.nombre like ? or p.descripcion like ?)";
            PreparedStatement buscar = c.prepareStatement(consulta);
            buscar.setString(1, '%'+nom+'%');
            buscar.setString(2, '%'+desc+'%');
            ResultSet resultado = buscar.executeQuery();
           System.out.println("si");
            while(resultado.next()){
                SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = t.parse(resultado.getString("e.fecha_entrega"));
                java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
                CalificacionVendedor vend = new CalificacionVendedor();
                CalificacionProducto prod = new CalificacionProducto();
                vend.setCalificacionV(Integer.parseInt(resultado.getString("cp.calificacion_producto")));
                prod.setCalificacionP(Integer.parseInt(resultado.getString("cv.calificacion_vendedor")));
                lista.add(
                    new Producto( 
                            resultado.getString("p.id_producto"),
                    resultado.getString("p.nombre"), 
                    resultado.getString("p.descripcion"), 
                    resultado.getString("p.categoria"), 
                    Double.parseDouble(resultado.getString("p.precio")), sqlDate,
                    prod, vend,Integer.parseInt(resultado.getString("p.num_busquedas")))
                );
            }
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void modificarArticulo(String code, int calif, Connection e) {
        try {
            String consulta = "UPDATE tb_producto SET num_busquedas = ? WHERE id_producto = ?";
            PreparedStatement modifica = e.prepareStatement(consulta);
            modifica.setString(1, String.valueOf(calif));
            modifica.setString(2, code);
            int m = modifica.executeUpdate();
            if( m > 0){ 
                System.out.println("modificación exitosa ...");
            }
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
        }
    }
    
    private class CleanButtonHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            VistaBusquedaSencilla.setBusquedaTextField("");
            VistaBusquedaSencilla.getVBoxProductosEncontrados().getChildren().clear();
            l_articulos.clear();
            VistaBusquedaSencilla.setBusquedaScrollPane(VistaBusquedaSencilla.getVBoxProductosEncontrados());
        }
    }
    
    private class BuscarButtonHandler implements EventHandler{
        DBConnection conexion;
        private BuscarButtonHandler() {
            conexion = DBConnection.getInstance();
        }
                    
        @Override
        public void handle(Event event) {
            String campo = cleanString(VistaBusquedaSencilla.getBusquedaTextField());
            cargarLista(campo);
            if(l_articulos.isEmpty()){
                MensajesAcciones.productoNoEncontrado();
            }
            cargarContenido();
            for (Producto p : l_articulos){
                conexion.conectar();
                modificarArticulo(p.getIdProducto(), p.getNumBusquedas()+1, conexion.getConnection());
                conexion.desconectar();
            }
            VistaBusquedaSencilla.setBusquedaScrollPane(VistaBusquedaSencilla.getVBoxProductosEncontrados());
        }
        
        public String cleanString(String texto) {
            texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
            texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
            return texto.replaceAll("[^\\w\\s]","").toLowerCase();
        }        
        
        private void cargarLista(String cp){
            l_articulos = FXCollections.observableArrayList();
            conexion.conectar();
            buscarArticulos(cp, cp, conexion.getConnection(), l_articulos);
            conexion.desconectar();
        }
        
        private void cargarContenido() {
            for (Producto p : l_articulos){            
                HBox hb = new HBox();
                HBox hb1 = new HBox();
                Label categoryNameLbl = new Label();
                Label nameLbl = new Label(p.getNombre());
                Label desc = new Label(p.getDescripcion());
                nameLbl.setFont(new Font("Verdana", 19));
                Button buyButton = new Button("Comprar");
                buyButton.setOnAction((ActionEvent e)-> {
                    System.out.println("Comprar: " + p.getNombre());
                    VistaBusquedaSencilla.getRoot().getScene().setRoot(new Comprar(p).getRoot());
                });
                desc.setText("Descripción: "+p.getDescripcion());
                categoryNameLbl.setText("Categoria: "+p.getCategoria());
                hb.setSpacing(100);
                hb1.setSpacing(100);
                hb.getChildren().addAll(nameLbl,buyButton);
                hb1.getChildren().addAll(crearEstrellas(p.getCalificacionP().getCalificacionP(), "Producto"),
                        crearEstrellas(p.getCalificacionV().getCalificacionV(),"Vendedor"));
                hb.setPadding(new Insets(7, 0, 7, 5));
                VistaBusquedaSencilla.getVBoxProductosEncontrados().setPadding(new Insets(7, 70, 0, 70));
                VistaBusquedaSencilla.getVBoxProductosEncontrados().getChildren().addAll(hb,categoryNameLbl,desc,precioProducto(p.getPrecio()),
                        nombreProducto(p.getTiempoMaxEntrega().toString()), hb1,
                         drawLine());
            }
        }
        
        private VBox nombreProducto(String nombre){
            VBox v = new VBox();
            Label productNameLbl = new Label("Entrega máxima: "+nombre);
            v.getChildren().add(productNameLbl);
            return v;
        }
    
        private Label precioProducto(double precio){
            Label priceLbl = new Label();
            priceLbl.setFont(new Font("Verdana",14));
            priceLbl.setText("$"+String.valueOf(precio));
            return priceLbl;
        }
    
        public Line drawLine(){
            Line linea = new Line(0, 0, 640, 0);
            linea.setStroke(Color.STEELBLUE);
            linea.setStrokeWidth(2);
            return linea;
        }
    
        public HBox crearEstrellas(int calificacion, String n){
            HBox contenedorStars = new HBox();
            HBox hb = new HBox();
            Label l = new Label("Calificación "+n+": ");
            for (int i=0; i<calificacion;i++){
                    Image image = new Image(CONSTANTES.PATH_IMG+"/star.png") ;
                    ImageView iv2 = new ImageView();
                    iv2.setImage(image);
                    contenedorStars.getChildren().add(iv2);
                }
            hb.getChildren().addAll(l, contenedorStars);
            return hb;
        }
    }
}