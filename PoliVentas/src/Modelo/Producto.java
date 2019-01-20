package Modelo;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Rosa
 */
public class Producto {
    private String idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private String categoria;
    private int stock;
    private boolean estado;
    private int numBusquedas;
    private int calificacion;
    private CalificacionProducto calificacionP;
    private CalificacionVendedor calificacionV;
    private Vendedor vendedor;
    private Date tiempoMaxEntrega;
    
    public Producto(){}
        
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
    
    public Producto(String idProducto, String nombre, String descripcion, double precio, String categoria, int stock, int numBusquedas,int calificacion) {
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
                + "\nPrecio: " + precio + "\nCalificacion: " + calificacionP + "\nNBusquedas: "+this.numBusquedas;
    }
}