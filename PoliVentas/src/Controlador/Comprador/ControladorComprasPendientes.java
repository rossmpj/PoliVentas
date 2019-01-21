package Controlador.Comprador;

import Auxiliares.DBConnection;
import Auxiliares.MensajesAcciones;
import Controlador.Principal.WindowsController;
import Modelo.CalificacionVendedor;
import Modelo.Comprador;
import Modelo.Pedido;
import Modelo.Producto;
import Vista.Comprador.VistaComprasPendientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import Modelo.Vendedor;
import javafx.collections.FXCollections;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorComprasPendientes {
    
    private final Pedido ModeloPedido;
    private final VistaComprasPendientes VistaComprasPendientes;
    private final ObservableList<Pedido> observableList;
    private final DBConnection conexion;

    public ControladorComprasPendientes(Pedido ModeloPedido, VistaComprasPendientes VistaComprasPendientes) {
        this.conexion = DBConnection.getInstance();
        this.ModeloPedido = ModeloPedido;
        this.VistaComprasPendientes = VistaComprasPendientes;
        this.observableList = FXCollections.observableArrayList();
        this.VistaComprasPendientes.addBackButtonHandler((event -> WindowsController.previous()));
        this.VistaComprasPendientes.addAnularPedidoButtonHandler(new AnularPedidoButtonHandler());
        this.VistaComprasPendientes.addCalificarProductoButtonHandler(new CalificarProductoButtonHandler());
        this.VistaComprasPendientes.addCalificarVendedorButtonHandler(new CalificarVendedorButtonHandler());
        this.VistaComprasPendientes.addHabilitarSiHandler(new HabilitarSiHandler());
        this.VistaComprasPendientes.addHabilitarNoHandler(new HabilitarNoHandler());        
        cargarData();
        actualizarTabla();
    }
    
    private void cargarData() {
        conexion.conectar();        
        buscarPedidosPendientes("comp001", conexion.getConnection(), this.observableList);
        conexion.desconectar();
    }
    
    private void actualizarTabla(){
        VistaComprasPendientes.getColId().setCellValueFactory(new PropertyValueFactory<>("idPedido"));
        VistaComprasPendientes.getColPrecio().setCellValueFactory(new PropertyValueFactory<>("costo"));
        VistaComprasPendientes.getColCant().setCellValueFactory(new PropertyValueFactory<>("cantidadPedida"));
        VistaComprasPendientes.getColFP().setCellValueFactory(new PropertyValueFactory<>("fechaPedido"));
        VistaComprasPendientes.getColFE().setCellValueFactory(new PropertyValueFactory<>("fechaEntrega"));
        VistaComprasPendientes.getColLE().setCellValueFactory(new PropertyValueFactory<>("lugarEntrega"));
        VistaComprasPendientes.getColV().setCellValueFactory(new PropertyValueFactory<>("vendedor"));
        VistaComprasPendientes.getColP().setCellValueFactory(new PropertyValueFactory<>("product"));
        VistaComprasPendientes.getPedidos().setItems(observableList);
    }
    
    public int promediar(int c1, int c2){
        return (int) ((c1+c2)/2);
    }
    
    public void modificarCalificacionArticulo(String code, int calif, Connection e) {
        try {
            String consulta = "UPDATE tb_calificacion_producto SET calificacion_producto = ? WHERE id_producto = ?";
            PreparedStatement modifica = e.prepareStatement(consulta);
            modifica.setString(1, String.valueOf(calif));
            modifica.setString(2, code);
            int m = modifica.executeUpdate();
            if( m > 0){ 
                MensajesAcciones.CalificacionProductoSi();
                System.out.println("modificación exitosa art...");
            }
        } catch (SQLException ex) {
            MensajesAcciones.CalificacionProductoNo();
            System.out.println("EXCEPCION: " + ex.getMessage());
        }
    }
        
    public void modificarCalificacionVendedor(String code, int calif, Connection e) {
        try {
            String consulta = "UPDATE tb_calificacion_vendedor SET calificacion_vendedor = ? WHERE id_vendedor = ?";
            PreparedStatement modifica = e.prepareStatement(consulta);
            modifica.setString(1, String.valueOf(calif));
            modifica.setString(2, code);
            int m = modifica.executeUpdate();
            if( m > 0){ 
                MensajesAcciones.CalificacionVendedorSi();
                System.out.println("modificación exitosa ...");
            }
        } catch (SQLException ex) {
            MensajesAcciones.CalificacionVendedorNo();
            System.out.println("EXCEPCION: " + ex.getMessage());
        }
    }
    
    public void anularPedido(String code, Connection e) {
        try {
            String consulta = "UPDATE tb_pedido SET estado = 'anulado' WHERE id_pedido = ?";
            PreparedStatement modifica = e.prepareStatement(consulta);
            modifica.setString(1, code);
            int m = modifica.executeUpdate();
            if( m > 0){ 
                MensajesAcciones.PedidoAnuladoSi();
                System.out.println("modificación exitosa ...");
            }
        } catch (SQLException ex) {
            MensajesAcciones.PedidoAnuladoNo();
            System.out.println("EXCEPCION: " + ex.getMessage());
        }
    }
    
    public void pedidoExitoso(String code, Connection e) {
        try {
            String consulta = "UPDATE tb_pedido SET estado = 'entregado' WHERE id_pedido = ?";
            PreparedStatement modifica = e.prepareStatement(consulta);
            modifica.setString(1, code);
            int m = modifica.executeUpdate();
            if( m > 0){ 
                MensajesAcciones.PedidoExitoso();
                System.out.println("modificación exitosa ...");
            }
        } catch (SQLException ex) {
            MensajesAcciones.PedidoFallido();
            System.out.println("EXCEPCION: " + ex.getMessage());
        }
    }
    
    public void buscarPedidosPendientes(String id, Connection c, ObservableList<Pedido> lista){
        try {
            String consulta = "select * from tb_pedido p, (select * from tb_producto) pr ,"
                    + "(select * from tb_vendedor) ve ,(select * from tb_calificacion_producto) cal, "
                    + "(select * from tb_comprador) co , (select * from tb_calificacion_vendedor) ca,"
                    + "(select * from tb_usuario) us where p.estado = 'pendiente' "
                    + "and pr.id_producto = p.id_producto_ped and ve.id_vendedor = p.id_vendedor_ped "
                    + "and co.id_comprador = p.id_comprador_ped and co.cedula = us.ci_usuario and ca.id_vendedor = ve.id_vendedor "
                    + "and ve.cedula = us.ci_usuario and ve.id_comprador = co.id_comprador and cal.id_producto = pr.id_producto "
                    + "and ve.id_comprador = p.id_comprador_ped and id_comprador_ped = ?";
            PreparedStatement buscar = c.prepareStatement(consulta);
            buscar.setString(1, id);
            ResultSet resultado = buscar.executeQuery();
            System.out.println("si");
            while(resultado.next()){
                SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date datePedido = t.parse(resultado.getString("fecha_pedido"));
                java.util.Date dateEntrega = t.parse(resultado.getString("fecha_entrega"));
                java.sql.Date sqlDateP = new java.sql.Date(datePedido.getTime()); 
                java.sql.Date sqlDateE = new java.sql.Date(dateEntrega.getTime()); 
                Comprador co = new Comprador();
                Vendedor ve = new Vendedor (); 
                Producto pr = new Producto();
                CalificacionVendedor cv = new CalificacionVendedor();
                pr.setNombre(resultado.getString("pr.nombre"));
                pr.setDescripcion(resultado.getString("pr.descripcion"));
                pr.setCategoria(resultado.getString("pr.categoria"));
                pr.setPrecio(Double.parseDouble(resultado.getString("pr.precio")));
                pr.setNumBusquedas(Integer.parseInt(resultado.getString("pr.num_busquedas")));
                pr.setCalificacion(Integer.parseInt(resultado.getString("cal.calificacion_producto")));
                co.setId_comprador(resultado.getString("id_comprador_ped"));
                ve.setId_vendedor(resultado.getString("id_vendedor_ped"));
                ve.setNombres(resultado.getString("us.nombres"));
                cv.setCalificacionV(Integer.parseInt(resultado.getString("ca.calificacion_vendedor")));
                cv.setIdCalificacionV(resultado.getString("ca.id_calificacion_vend"));
                ve.setCalificacionV(cv);               
                ve.setApellidos(resultado.getString("us.apellidos"));
                pr.setIdProducto(resultado.getString("id_producto_ped"));
                lista.add(new Pedido( 
                    resultado.getString("p.id_pedido"),
                    resultado.getString("p.estado"), 
                    Double.parseDouble(resultado.getString("p.costo")),
                    Integer.parseInt(resultado.getString("p.cantidad_pedida")),
                    sqlDateP, resultado.getString("hora_pedido"),
                    sqlDateE, resultado.getString("hora_entrega"),
                    resultado.getString("p.lugar_entrega"), 
                    co, ve, pr )
                );
            }
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
     
    private class AnularPedidoButtonHandler implements EventHandler{
        
        @Override
        public void handle(Event event) {
            Pedido pedido = VistaComprasPendientes.getPed();
            conexion.conectar();
            anularPedido(pedido.getIdPedido(), conexion.getConnection());
            conexion.desconectar();
        }        
    }
    
    private class CalificarProductoButtonHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            Pedido pedido = VistaComprasPendientes.getPed();
            Producto p = pedido.getProduct();
            String s = VistaComprasPendientes.getLblCalifP();
            System.out.println(s);       
            System.out.println(p.getCalificacion());
            int prom = promediar((int)(Double.parseDouble(s)), p.getCalificacion());
            System.out.println(prom);
            System.out.println(p.getIdProducto());
            conexion.conectar();
            modificarCalificacionArticulo(p.getIdProducto(), prom, conexion.getConnection());
            conexion.desconectar();
        }
    }
    
    private class CalificarVendedorButtonHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            Pedido pedido = VistaComprasPendientes.getPed();
            Vendedor p = pedido.getVendedor();
            String s = VistaComprasPendientes.getLblCalifV();
            System.out.println(s);       
            System.out.println(p.getCalificacionV().getCalificacionV());
            int prom = promediar((int)(Double.parseDouble(s)), p.getCalificacionV().getCalificacionV());
            System.out.println(prom);
            conexion.conectar();
            System.out.println("idv:"+p.getId_vendedor());
            modificarCalificacionVendedor(p.getId_vendedor(), prom, conexion.getConnection());
            conexion.desconectar();
        }
    }
    
    private class HabilitarSiHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            Pedido pedido = VistaComprasPendientes.getPed();
            conexion.conectar();
            pedidoExitoso(pedido.getIdPedido(), conexion.getConnection());
            conexion.desconectar();
        }
    }
    
    private class HabilitarNoHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            Pedido pedido = VistaComprasPendientes.getPed();
            conexion.conectar();
            anularPedido(pedido.getIdPedido(), conexion.getConnection());
            conexion.desconectar();
        }
    }
}