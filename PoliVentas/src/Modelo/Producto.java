package Modelo;

import Auxiliares.DBConnection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    protected String id_vendedor;
    private final String eliminarP = "update db_poliventas.tb_producto set estado=? where id_producto=?";
    private final String modificarP = "update db_poliventas.tb_producto set nombre=?,descripcion=?,precio=?,categoria=?,stock=?, estado=?,"
            + " where id_producto=?";
    private final String insert = "insert into db_poliventas.tb_producto values(?,?,?,?,?,?,?,?)";

    public Producto() {
    }

    public Producto(String idProducto, String nombre, String descripcion, String categoria, double precio,
            Date tiempoMaxEntrega, CalificacionProducto calificacionP, CalificacionVendedor calificacionV, int n) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.tiempoMaxEntrega = tiempoMaxEntrega;
        this.calificacionP = calificacionP;
        this.calificacionV = calificacionV;
        this.numBusquedas = n;
    }

    public Producto(String nombre, String categoria, double precio,
            Date tiempoMaxEntrega, CalificacionProducto calificacionP, CalificacionVendedor calificacionV) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.tiempoMaxEntrega = tiempoMaxEntrega;
        this.calificacionP = calificacionP;
        this.calificacionV = calificacionV;
    }

    public Producto(String idProducto, String nombre, String descripcion, String categoria, double precio, CalificacionProducto calificacionP, CalificacionVendedor calificacionV, Vendedor vendedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.calificacionP = calificacionP;
        this.vendedor = vendedor;
    }

    public Producto(String idProducto, String nombre, String descripcion, String categoria, double precio, int calificacion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.calificacion = calificacion;
    }

    public Producto(String nombre, String categoria, double precio, CalificacionProducto calificacionP) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.calificacionP = calificacionP;
        //this.calificacionV = calificacionV;
    }

    public Producto(String nombre, String categoria, double precio, int calificacion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.calificacion = calificacion;
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

    public Producto(String idProducto, String nombre, String descripcion, double precio, String categoria, int stock, Vendedor vendedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
        this.vendedor = vendedor;
    }

    /**
     * Constructor utilizado para realizar las consultas respectivas en la base de datos
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
        this.id_vendedor = vendedor;
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

    public String getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(String id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

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

    @Override
    public String toString() {
        return "DETALLES DE PRODUCTO: " + "\nID Producto: " + idProducto + "\nNombre: "
                + nombre + "\nDescripcion: " + descripcion + "\nCategoria: " + categoria
                + "\nPrecio: " + precio + "\nCalificacion: " + calificacionP + "\nNBusquedas: " + this.numBusquedas;
    }

    public boolean eliminarProducto() {
        try {
            CONNECTION.conectar();
            PreparedStatement ingreso = CONNECTION.getConnection().prepareStatement(eliminarP);
            ingreso.setBoolean(1, true);
            ingreso.setString(2, this.getIdProducto());
            ingreso.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return false;
        } finally {
            CONNECTION.desconectar();
        }
    }

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
            LOGGER.log(Level.SEVERE, e.getMessage());
            return false;
        } finally {
            CONNECTION.desconectar();
        }
    }

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
            ingreso.setString(8, id_vendedor);
            ingreso.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
            return false;

        } finally {

            CONNECTION.desconectar();

        }
    }
}
