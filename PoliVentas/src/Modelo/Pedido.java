package Modelo;

import Auxiliares.DBConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Rosa
 */
public class Pedido {
    private String idPedido;
    private String estado;
    private double costo;
    private int cantidadPedida;
    private Date fechaPedido;
    private Time horaPedido;
    private Date fechaEntrega;
    private Time horaEntrega;
    private String horaP;
    private String horaE;
    private String lugarEntrega;
    private Pago metodoPago;
    private Comprador comprador;
    private Vendedor vendedor;
    private Producto product;
    private String id_comprador;
    private String id_vendedor;
    private String id_product;

    public Pedido(){}
    
    public Pedido(String idPedido, String estado, 
            double costo, int cantidadPedida, Date
            fechaPedido, String horaP, Date fechaEntrega, String horaE, String lugarEntrega, Comprador co, Vendedor vendedor, Producto product) {
        this.idPedido = idPedido;
        this.estado = estado;
        this.costo = costo;
        this.cantidadPedida = cantidadPedida;
        this.fechaPedido = fechaPedido;
        this.horaP = horaP;
        this.fechaEntrega = fechaEntrega;
        this.horaE = horaE;
        this.lugarEntrega = lugarEntrega;
        this.comprador = co;
        this.vendedor = vendedor;
        this.product = product;
    }
    
    public Pedido(String idPedido, String estado, 
            double costo, int cantidadPedida, Date
            fechaPedido, String horaP, Date fechaEntrega, String horaE, String lugarEntrega,
            String id_comprador, String id_product) {
        this.idPedido = idPedido;
        this.estado = estado;
        this.costo = costo;
        this.cantidadPedida = cantidadPedida;
        this.fechaPedido = fechaPedido;
        this.horaP = horaP;
        this.fechaEntrega = fechaEntrega;
        this.horaE = horaE;
        this.lugarEntrega = lugarEntrega;
        this.id_comprador = id_comprador;
        this.id_product = id_product;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getCosto() {
        return costo;
    }

    public String getId_comprador() {
        return id_comprador;
    }

    public void setId_comprador(String id_comprador) {
        this.id_comprador = id_comprador;
    }

    public String getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(String id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getHoraP() {
        return horaP;
    }

    public void setHoraP(String horaP) {
        this.horaP = horaP;
    }

    public String getHoraE() {
        return horaE;
    }

    public void setHoraE(String horaE) {
        this.horaE = horaE;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidadPedida() {
        return cantidadPedida;
    }

    public void setCantidadPedida(int cantidadPedida) {
        this.cantidadPedida = cantidadPedida;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Time getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(Time horaPedido) {
        this.horaPedido = horaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Time getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(Time horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }

    public Pago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(Pago metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Producto getProduct() {
        return product;
    }

    public void setProduct(Producto product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return ">>> DETALLES DE PEDIDO:" + "\nID Pedido: " + idPedido + 
                "\nEstado: " + estado + "\nCosto: " + costo + "\nFecha Pedido: " 
                +"\nCantidad pedida: " + cantidadPedida + fechaPedido + "\nHora Pedido: " 
                + horaPedido + "\nFecha Entrega: " + fechaEntrega + "\nHora Entrega=" 
                + horaEntrega + "\nLugar Entrega: "  + lugarEntrega + "Método Pago: " 
                + metodoPago + "\nComprador: " + comprador + ""+ "Vendedor: " 
                + vendedor + "\nProducto: " + product;
    }
    
    public static ObservableList<Pedido> getPedidosPendientesPorVendedor(String id){
        
        DBConnection conexion = DBConnection.getInstance();
        conexion.conectar();
        
        ObservableList<Pedido> pedidos = FXCollections.observableArrayList();
        
        try {
            String consulta = "select * from tb_pedido p where p.estado = 'pendiente' and p.id_vendedor_ped = ?;";
            PreparedStatement buscar = conexion.getConnection().prepareStatement(consulta);
            buscar.setString(1, id);
            ResultSet resultado = buscar.executeQuery();
            
            while(resultado.next()){
                SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date datePedido = t.parse(resultado.getString("fecha_pedido"));
                java.util.Date dateEntrega = t.parse(resultado.getString("fecha_entrega"));
                Date sqlDateP = new java.sql.Date(datePedido.getTime()); 
                Date sqlDateE = new java.sql.Date(dateEntrega.getTime());
                pedidos.add(new Pedido( 
                    resultado.getString("p.id_pedido"),
                    resultado.getString("p.estado"), 
                    Double.parseDouble(resultado.getString("p.costo")),
                    Integer.parseInt(resultado.getString("p.cantidad_pedida")),
                    sqlDateP, resultado.getString("hora_pedido"),
                    sqlDateE, resultado.getString("hora_entrega"),
                    resultado.getString("p.lugar_entrega"), 
                    resultado.getString("p.id_comprador_ped"), 
                    resultado.getString("p.id_producto_ped")));
            }
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            conexion.desconectar();
        }
        
        return pedidos;
    }
    
    public boolean anular(){
        DBConnection conexion = DBConnection.getInstance();
        conexion.conectar();
        try {
            String query = "update db_poliventas.tb_pedido set estado='anulado' where id_pedido=?";
            PreparedStatement ingreso = conexion.getConnection().prepareStatement(query);
            ingreso.setString(1, this.getIdPedido());
            ingreso.executeUpdate();
        } catch (SQLException e) {
            return false;
        } finally {
            conexion.desconectar();
        }
        return true;
    }

    public boolean pedidoExitoso() {
        DBConnection conexion = DBConnection.getInstance();
        conexion.conectar();
        try {
            String consulta = "UPDATE tb_pedido SET estado = 'entregado' WHERE id_pedido = ?";
            PreparedStatement modifica = conexion.getConnection().prepareStatement(consulta);
            modifica.setString(1, this.getIdPedido());
            modifica.executeUpdate();
            return true;            
        } catch (SQLException ex) {
            return false;
        } finally {
            conexion.desconectar();
        }
    }
    
    public void buscarPedidosPendientes(ObservableList<Pedido> lista){
        DBConnection conexion = DBConnection.getInstance();
        conexion.conectar();
        try {
            String consulta = "select * from tb_pedido p, (select * from tb_producto) pr ,"
                    + "(select * from tb_vendedor) ve ,(select * from tb_calificacion_producto) cal, "
                    + "(select * from tb_comprador) co , (select * from tb_calificacion_vendedor) ca,"
                    + "(select * from tb_usuario) us where p.estado = 'pendiente' "
                    + "and pr.id_producto = p.id_producto_ped and ve.id_vendedor = p.id_vendedor_ped "
                    + "and co.id_comprador = p.id_comprador_ped and co.cedula = us.ci_usuario and ca.id_vendedor = ve.id_vendedor "
                    + "and ve.cedula = us.ci_usuario and ve.id_comprador = co.id_comprador and cal.id_producto = pr.id_producto "
                    + "and ve.id_comprador = p.id_comprador_ped and id_comprador_ped = ?";
            PreparedStatement buscar = conexion.getConnection().prepareStatement(consulta);
            buscar.setString(1, this.getId_comprador());
            ResultSet resultado = buscar.executeQuery();
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
                ve.setIdVendedor(resultado.getString("id_vendedor_ped"));
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
        } finally {
            conexion.desconectar();
        }
    }    
    
}
