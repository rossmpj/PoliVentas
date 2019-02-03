package Modelo;

import Auxiliares.DBConnection;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Rosa
 */
public class Producto {

    protected String idProducto;
    protected String nombre;
    protected String descripcion;
    protected double precio;
    protected String categoria;
    protected int stock;
    protected boolean estado;
    protected int numBusquedas;
    protected int calificacion;
    protected CalificacionProducto calificacionP;
    protected CalificacionVendedor calificacionV;
    protected Vendedor vendedor;
    protected Date tiempoMaxEntrega;

    protected static final Logger LOGGER = Logger.getLogger("Usuario Logger");
    protected static final DBConnection CONNECTION = DBConnection.getInstance();
    protected String idVendedor;
    private final String eliminarP = "update db_poliventas.tb_producto set estado=? where id_producto=?";
    private final String modificarP = "update db_poliventas.tb_producto set nombre=?,descripcion=?,precio=?,categoria=?,stock=?, estado=?"
            + " where id_producto=?";
    private final String extraer = "select distinct ci_usuario,nombres,apellidos,telefono,direccion, whatsapp,matricula,email,username,contrasena,u.estado "
            + "from tb_usuario u join tb_vendedor  v on ci_usuario=v.cedula join tb_producto p on p.id_vendedor=v.id_vendedor where p.id_producto=?";
    private final String insert = "insert into db_poliventas.tb_producto(id_producto, nombre, descripcion, "
            + "precio, categoria, stock, estado, id_vendedor) values(?,?,?,?,?,?,?,?)";
    private final String modifNumBusquedas = "UPDATE tb_producto SET num_busquedas = ? WHERE id_producto = ?";
    private final String buscarXNombreYDescripcion = "SELECT distinct p.id_producto, p.nombre, p.num_busquedas, p.descripcion, p.categoria, p.precio, "
            + "cp.calificacion_producto, cv.calificacion_vendedor, cv.id_vendedor, cp.id_producto, "
            + "e.fecha_entrega FROM tb_producto p, tb_calificacion_producto cp, "
            + "tb_vendedor v, tb_calificacion_vendedor cv, tb_pedido e "
            + "where p.id_producto = cp.id_producto and "
            + "p.id_vendedor = v.id_vendedor and "
            + "v.id_vendedor = cv.id_vendedor and "
            + "v.id_vendedor = e.id_vendedor_ped and (p.nombre like ? or p.descripcion like ?)";

    public Producto() {
    }

    public Producto(String idProducto, String nombre, String descripcion, String categoria, double precio,
            Date tiempoMaxEntrega, CalificacionProducto calificacionP, Vendedor vendedor, int n) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.tiempoMaxEntrega = tiempoMaxEntrega;
        this.calificacionP = calificacionP;
        this.vendedor = vendedor;
        this.numBusquedas = n;
    }

    public Producto(String idProducto, String nombre, String descripcion, double precio, String categoria, int stock, int numBusquedas, int calificacion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
        this.numBusquedas = numBusquedas;
        this.calificacion = calificacion;
    }

    /**
     * Constructor utilizado para realizar las consultas respectivas en la base
     * de datos
     */
    public Producto(String idProducto, String nombre, String descripcion, double precio, String categoria, int stock, boolean estado, int calificacion, String vendedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
        this.estado = estado;
        this.calificacion = calificacion;
        this.idVendedor = vendedor;
    }

    public Producto(String idProducto, String nombre, String descripcion, double precio, String categoria, int stock) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public CalificacionProducto getCalificacionP() {
        return calificacionP;
    }

    public void setCalificacion(CalificacionProducto calificacionP) {
        this.calificacionP = calificacionP;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public int getNumBusquedas() {
        return numBusquedas;
    }

    public void setNumBusquedas(int numBusquedas) {
        this.numBusquedas = numBusquedas;
    }

    public Vendedor getVendedor() {
       return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Date getTiempoMaxEntrega() {
        return tiempoMaxEntrega;
    }

    public void setTiempoMaxEntrega(Date tiempoMaxEntrega) {
        this.tiempoMaxEntrega = tiempoMaxEntrega;
    }

    public CalificacionVendedor getCalificacionV() {
        return calificacionV;
    }

    public void setCalificacionV(CalificacionVendedor calificacionV) {
        this.calificacionV = calificacionV;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    /**
     * Sobreescritura del matodo hashCode
     * @return int con hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idProducto);
        hash = 61 * hash + Objects.hashCode(this.nombre);
        hash = 61 * hash + Objects.hashCode(this.descripcion);
        hash = 61 * hash + Objects.hashCode(this.categoria);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        return hash;
    }

    /**
     * Sobreescritura del metodo equals
     * @param obj
     * @return  true or false
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.idProducto, other.idProducto)) {
            return false;
        }
        return true;
    }

    /**
     * Sobreescritura del metodo toString
     * @return datos del producto
     */
    @Override
    public String toString() {
        return "DETALLES DE PRODUCTO: " + "\nNombre: "
                + nombre + "\nDescripcion: " + descripcion + "\nCategoria: " + categoria
                + "\nPrecio: " + precio + "\nCalificacion: " + calificacionP;
    }

    /**
     * Método que permite deshabilitar el producto
     * @return true si se pudo eliminar, false si no
     */
    public boolean eliminarProducto() {
        try {
            CONNECTION.conectar();
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(eliminarP);
            ingreso.setBoolean(1, true);
            ingreso.setString(2, this.getIdProducto());
            ingreso.executeUpdate();
            return true;
        } catch (SQLException e) {
             Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            CONNECTION.desconectar();
        }
    }

    /**
     * Método que permite modificar los datos del producto
     * @return true si se pudo modificar, false si no
     */
    public boolean modificarProducto() {
        try {
            CONNECTION.conectar();
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(modificarP);
            ingreso.setString(1, this.getNombre().toLowerCase());
            ingreso.setString(2, this.getDescripcion().toLowerCase());
            ingreso.setDouble(3, this.getPrecio());
            ingreso.setString(4, this.getCategoria().toLowerCase());
            ingreso.setInt(5, this.getStock());
            ingreso.setBoolean(6, this.isEstado());
            ingreso.setString(7, this.getIdProducto());
            ingreso.executeUpdate();
            return true;
        } catch (SQLException e) {
             Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            CONNECTION.desconectar();
        }
    }

    /**
     * Método que permite almacenar el producto en la base de datos
     * @return  true si todo fue correcto, false si ocurrió alguna excepción 
     */
    public boolean registrar() {
        try {
            CONNECTION.conectar();
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(insert);
            ingreso.setString(1, idProducto);
            ingreso.setString(2, nombre);
            ingreso.setString(3, descripcion);
            ingreso.setDouble(4, precio);
            ingreso.setString(5, categoria);
            ingreso.setInt(6, stock);
            ingreso.setBoolean(7, false);
            ingreso.setString(8, idVendedor);
            ingreso.executeUpdate();
            return true;
        } catch (SQLException e) {
             Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } finally {
            CONNECTION.desconectar();
        }
    }

    public static ObservableList<Producto> getMisProductos(String idVendedor) {

        DBConnection conexion = DBConnection.getInstance();
        conexion.conectar();

        ObservableList<Producto> productos = FXCollections.observableArrayList();

        try {
            String query
                    = "select p.id_producto, p.nombre, p.descripcion, p.precio, p.categoria, p.stock from tb_producto p where p.id_vendedor = ? and p.estado = FALSE;";

            PreparedStatement buscar = conexion.getConnection().prepareStatement(query);
            buscar.setString(1, idVendedor);
            ResultSet resultado = buscar.executeQuery();
            while (resultado.next()) {
                productos.add(
                        new Producto(
                                resultado.getString("p.id_producto"),
                                resultado.getString("p.nombre"),
                                resultado.getString("p.descripcion"),
                                Double.parseDouble(resultado.getString("p.precio")),
                                resultado.getString("p.categoria"),
                                Integer.parseInt(resultado.getString("p.stock")))
                );
            }
        } catch (SQLException ex) {
             Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.desconectar();
        }
        return productos;
    }

    public void buscarProducto(String nom, String desc, ObservableList<Producto> lista) {
        try {
            CONNECTION.conectar();
            PreparedStatement buscar = CONNECTION.getConnection().prepareStatement(buscarXNombreYDescripcion);
            buscar.setString(1, '%' + nom + '%');
            buscar.setString(2, '%' + desc + '%');
            ResultSet resultado = buscar.executeQuery();
            while (resultado.next()) {
                SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date date = t.parse(resultado.getString("e.fecha_entrega"));
                CalificacionVendedor vend = new CalificacionVendedor();
                CalificacionProducto prod = new CalificacionProducto();
                Vendedor v = new Vendedor();
                vend.setCalificacionV(Integer.parseInt(resultado.getString("cv.calificacion_vendedor")));
                vend.setIdCalificacionV(resultado.getString("cv.id_vendedor"));
                v.setIdVendedor(resultado.getString("cv.id_vendedor"));
                v.setCalificacionV(vend);
                prod.setIdProducto(resultado.getString("cp.id_producto"));
                prod.setIdCalificacionP("p.id_calificacion_producto");
                prod.setCalificacionP(Integer.parseInt(resultado.getString("cp.calificacion_producto")));
                lista.add(
                        new Producto(
                                resultado.getString("p.id_producto"), resultado.getString("p.nombre"),
                                resultado.getString("p.descripcion"), resultado.getString("p.categoria"),
                                Double.parseDouble(resultado.getString("p.precio")), new Date(date.getTime()),
                                prod, v, Integer.parseInt(resultado.getString("p.num_busquedas"))
                        )
                );
            }
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            CONNECTION.desconectar();
        }
    }

    public boolean modificarBusquedasArticulo() {
        try {
            CONNECTION.conectar();
            PreparedStatement modifica = CONNECTION.getConnection().prepareStatement(modifNumBusquedas);
            modifica.setString(1, String.valueOf(this.getCalificacion() + 1));
            modifica.setString(2, this.getIdProducto());
            modifica.executeUpdate();
            return true;
        } catch (SQLException ex) {
             Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            CONNECTION.desconectar();
        }
    }
    /**
     * Método que permite descontar del stock actual del producto
     *
     * @param cantidad del producto al momento de la compra
     */
    public void descontarStock(int cantidad) {
        try {
            CONNECTION.conectar();
            String consulta = "{call  descontarStock(?,?)}";
            CallableStatement sp = CONNECTION.getConnection().prepareCall(consulta);
            sp.setString(1, this.idProducto);
            sp.setInt(2, cantidad);
            sp.execute();
            sp.close();
        } catch (SQLException e) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            CONNECTION.desconectar();
        }
    }

    /**
     * Método que permite obtener la cantidad actual del producto
     *
     * @return int, stock
     */
    public int obtenerStock() {
        try {
            int s = 0;
            CONNECTION.conectar();
            String consulta = "select stock from tb_producto where id_producto=?";
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(consulta);
            ingreso.setString(1, this.idProducto);
            ResultSet resultado = ingreso.executeQuery();
            while (resultado.next()) {
                s = resultado.getInt("stock");
            }
            return s;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return -1;
        } finally {
            CONNECTION.desconectar();
        }

    }
}
