package Modelo;

import Auxiliares.DBConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
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
    private String id_metodoPago;
   
    private static final DBConnection CONNECTION = DBConnection.getInstance();
    private final String consulta= "INSERT INTO db_poliventas.tb_pedido (estado,costo,cantidad_pedida,fecha_pedido,hora_pedido,"
            + "lugar_entrega,id_pago,id_comprador_ped, id_vendedor_ped,id_producto_ped) values (?,?,?,?,?,?,?,?,?,?)";
    private final String updt_query = "update db_poliventas.tb_pedido set estado=?, costo=?, "
            + "cantidad_pedida=?, fecha_pedido=?, hora_pedido=?, fecha_entrega=?, hora_entrega=?, lugar_entrega=?, id_pago=?, id_comprador_ped=?, id_vendedor_ped=?, id_producto_ped=? where id_pedido=?";
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

    public Pedido(String idPedido, String estado, double costo, int cantidadPedida, Date fechaPedido, Time horaPedido, Date fechaEntrega, Time horaEntrega, String lugarEntrega, String id_comprador, String id_vendedor, String id_product, String id_metodoPago) {
        this.idPedido = idPedido;
        this.estado = estado;
        this.costo = costo;
        this.cantidadPedida = cantidadPedida;
        this.fechaPedido = fechaPedido;
        this.horaPedido = horaPedido;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.lugarEntrega = lugarEntrega;
        this.id_comprador = id_comprador;
        this.id_vendedor = id_vendedor;
        this.id_product = id_product;
        this.id_metodoPago = id_metodoPago;
    }

    
    /**
     * Constructor para Insertar nuevo Pedido en la base de datos
     * @param estado
     * @param costo
     * @param cantidadPedida
     * @param fechaPedido
     * @param horaPedido
     * @param fechaEntrega
     * @param horaEntrega
     * @param lugarEntrega
     * @param pago
     * @param comprador
     * @param vendedor
     * @param product
     */
     public Pedido(String estado, double costo, int cantidadPedida, Date fechaPedido, Time horaPedido, Date fechaEntrega, Time horaEntrega, String lugarEntrega,String pago ,String comprador, String vendedor, String product) {
        this.estado = estado;
        this.costo = costo;
        this.cantidadPedida = cantidadPedida;
        this.fechaPedido = fechaPedido;
        this.horaPedido = horaPedido;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.lugarEntrega = lugarEntrega;
        this.id_comprador = comprador;
        this.id_metodoPago= pago;
        this.id_vendedor = vendedor;
        this.id_product = product;
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
    
      public String getId_metodoPago() {
        return id_metodoPago;
    }

    public void setId_metodoPago(String id_metodoPago) {
        this.id_metodoPago = id_metodoPago;
    }
    
    /**
     * Sobreescritura del metodo to String
     * @return datos del pedido
     */
    @Override
    public String toString() {
        return ">>> DETALLES DE PEDIDO:" + "\nEstado: " + estado + "\nCosto: " + costo + "\nFecha Pedido: " 
                +"\nCantidad pedida: " + cantidadPedida + "\nFecha Pedido: "+fechaPedido + "\nHora Pedido: " 
                + horaPedido + "\nLugar Entrega: "  + lugarEntrega ; 
    }
    
    /**
     * Método que permite obtener los pedidos pendientes por vendedor
     * @param id vendedor
     * @return ObservableList a ser cargada en table view
     */
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
                
                Date sqlDateP = new java.sql.Date(datePedido.getTime()); 
                Time sqlTimeP = Time.valueOf(LocalTime.parse(resultado.getString("hora_pedido")));
                
                Date sqlDateE = null;
                Time sqlTimeE = null;
                String dateEString = resultado.getString("fecha_entrega");
                String hourEString = resultado.getString("hora_entrega");
                
                if (dateEString != null)
                    sqlDateE = Date.valueOf(LocalDate.parse(dateEString));
                
                if (hourEString != null)
                    sqlTimeE = Time.valueOf(LocalTime.parse(hourEString));
                
                pedidos.add(new Pedido( 
                    resultado.getString("p.id_pedido"),
                    resultado.getString("p.estado"), 
                    Double.parseDouble(resultado.getString("p.costo")),
                    Integer.parseInt(resultado.getString("p.cantidad_pedida")),
                    sqlDateP, sqlTimeP, sqlDateE, sqlTimeE,
                    resultado.getString("p.lugar_entrega"),
                    resultado.getString("p.id_comprador_ped"),
                    resultado.getString("p.id_vendedor_ped"), 
                    resultado.getString("p.id_producto_ped"),
                    resultado.getString("p.id_pago")));
            }
        } catch (SQLException | ParseException ex) {
             Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            conexion.desconectar();
        }
        
        return pedidos;
    }
    
    /**
     * Método que permite anular el pedido
     * @return true si se pudo anular correctamente, false en caso contrario
     */
    public boolean anular(){
        DBConnection conexion = DBConnection.getInstance();
        conexion.conectar();
        try {
            String query = "update db_poliventas.tb_pedido set estado='anulado' where id_pedido=?";
            PreparedStatement ingreso = conexion.getConnection().prepareStatement(query);
            ingreso.setString(1, this.getIdPedido());
            ingreso.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            conexion.desconectar();
        }
        return true;
    }

    /**
     * Método que guarda en la base de datos un pedido con el estado de entregado
     * @return true si se actualizó con éxito, false en caso de error
     */
    public boolean pedidoExitoso() {
        DBConnection conexion = DBConnection.getInstance();
        conexion.conectar();
        try {
            String c = "UPDATE tb_pedido SET estado = 'entregado' WHERE id_pedido = ?";
            PreparedStatement modifica = conexion.getConnection().prepareStatement(c);
            modifica.setString(1, this.getIdPedido());
            modifica.executeUpdate();
            return true;            
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            conexion.desconectar();
        }
    }
    
    /**
     * Método usado para cargar los pedidos por vendedor
     * @param idComprador
     * @param lista 
     */
    public void buscarPedidosPendientes(String idComprador, ObservableList<Pedido> lista){
        DBConnection conexion = DBConnection.getInstance();
        conexion.conectar();
        try {           
            String c = "select p.id_pedido, p.id_producto_ped,p.estado,p.costo, p.cantidad_pedida, p.fecha_pedido, p.fecha_entrega, "+
            "p.lugar_entrega, l.categoria, l.nombre, cv.calificacion_vendedor, l.precio,p.hora_entrega, l.descripcion, u.nombres, u.apellidos, p.id_comprador_ped, p.id_vendedor_ped, "+
            "cp.calificacion_producto, p.hora_pedido from tb_pedido p join tb_producto l on p.id_producto_ped="+
            "l.id_producto join tb_calificacion_producto cp on cp.id_producto=l.id_producto join "+
            "tb_vendedor v on v.id_vendedor=p.id_vendedor_ped join tb_calificacion_vendedor cv on cv.id_vendedor = p.id_vendedor_ped "
                    + "join tb_usuario u on u.ci_usuario=v.cedula "+
            "where p.estado='pendiente' and  p.id_comprador_ped = ?" ;
            PreparedStatement buscar = conexion.getConnection().prepareStatement(c);
            buscar.setString(1, idComprador);
            ResultSet resultado = buscar.executeQuery();
            while(resultado.next()){
                SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date datePedido = t.parse(resultado.getString("p.fecha_pedido"));
                java.util.Date dateEntrega = t.parse(resultado.getString("p.fecha_entrega"));
                Comprador co = new Comprador();
                Vendedor ve = new Vendedor(); 
                Producto pr = new Producto();
                CalificacionVendedor cv = new CalificacionVendedor();
                pr.setNombre(resultado.getString("l.nombre"));
                pr.setDescripcion(resultado.getString("l.descripcion"));
                pr.setCategoria(resultado.getString("l.categoria"));
                pr.setPrecio(Double.parseDouble(resultado.getString("l.precio")));
                pr.setCalificacion(Integer.parseInt(resultado.getString("cp.calificacion_producto")));
                co.setId_comprador(resultado.getString("p.id_comprador_ped"));
                ve.setIdVendedor(resultado.getString("p.id_vendedor_ped"));
                cv.setIdVendedor(resultado.getString("p.id_vendedor_ped"));
                cv.setIdComprador(resultado.getString("p.id_comprador_ped"));
                cv.setCalificacionV(Integer.valueOf(resultado.getString("cv.calificacion_vendedor")));
                ve.setCalificacionV(cv);
                ve.setNombres(resultado.getString("u.nombres"));              
                ve.setApellidos(resultado.getString("u.apellidos"));
                pr.setIdProducto(resultado.getString("p.id_producto_ped"));
                lista.add(new Pedido( 
                    resultado.getString("p.id_pedido"), resultado.getString("p.estado"), 
                    Double.parseDouble(resultado.getString("p.costo")),
                    Integer.parseInt(resultado.getString("p.cantidad_pedida")),
                    new Date(datePedido.getTime()), resultado.getString("p.hora_pedido"),
                    new Date(dateEntrega.getTime()), resultado.getString("p.hora_entrega"),
                    resultado.getString("p.lugar_entrega"), co, ve, pr )
                );
            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.desconectar();
        }
    } 
    
    /**
     * Método que permite registrar el pedido en la base de datos
     * @return true, si se registró con exito, false si no se pudo
     */
    public boolean registrar(){
        try {
            CONNECTION.conectar();
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consulta);
            ingreso.setString(1, this.estado);
            ingreso.setDouble(2, this.costo);
            ingreso.setInt(3, this.cantidadPedida);
            ingreso.setDate(4, java.sql.Date.valueOf(LocalDate.now()));
            ingreso.setTime(5, java.sql.Time.valueOf(LocalTime.now()));
            ingreso.setString(6, this.lugarEntrega);
            ingreso.setString(7, this.id_metodoPago);
            ingreso.setString(8, this.id_comprador);
            ingreso.setString(9, this.id_vendedor);
            ingreso.setString(10, this.id_product);
            ingreso.executeUpdate();
            return true;
        }catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            CONNECTION.desconectar();
        }
    }
    
    /**
     * Método que permite actualizar el pedido
     * @return true si se realizó correctamente, false en caso contrario
     */
    public boolean update(){
        try {
                CONNECTION.conectar();
                PreparedStatement updt = CONNECTION.getConnection().prepareStatement(updt_query);
                updt.setString(1, this.estado);
                updt.setDouble(2, this.costo);
                updt.setInt(3, this.cantidadPedida);
                updt.setDate(4, fechaPedido);
                updt.setTime(5, horaPedido);
                updt.setDate(6, fechaEntrega);
                updt.setTime(7, horaEntrega);
                updt.setString(8, this.lugarEntrega);
                updt.setString(9, this.id_metodoPago);
                updt.setString(10, this.id_comprador);
                updt.setString(11, this.id_vendedor);
                updt.setString(12, this.id_product);
                updt.setString(13, this.idPedido);
                updt.executeUpdate();
                return true;
        }catch (SQLException ex) {
                 Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
                return false;
        } finally {
                CONNECTION.desconectar();
        }
    }
    
    /**
     * Sobrescritura de hashCode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idPedido);
        return hash;
    }

    /**
     * Sobrescritura de método equals
     * @param obj objeto a ser comparado
     * @return true si es igual, false caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        return Objects.equals(this.idPedido, other.idPedido);
    }
    
}
