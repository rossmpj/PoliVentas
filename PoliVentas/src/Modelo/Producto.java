/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import javafx.collections.ObservableList;

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
    private int estado;
    private int calificacion;
    private Vendedor vendedor;
    
    public Producto(){}
    
    public Producto(String idProducto, String nombre, String descripcion, String categoria, double precio, int calificacion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.calificacion = calificacion;
    }
    
    public Producto(String nombre, String categoria, double precio, int calificacion) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.calificacion = calificacion;
    }

    public Producto(String idProducto, String nombre, String descripcion, double precio, String categoria, int stock, int estado, int calificacion, Vendedor vendedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
        this.estado = estado;
        this.calificacion = calificacion;
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

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idProducto);
        hash = 61 * hash + Objects.hashCode(this.nombre);
        hash = 61 * hash + Objects.hashCode(this.descripcion);
        hash = 61 * hash + Objects.hashCode(this.categoria);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.precio) ^ (Double.doubleToLongBits(this.precio) >>> 32));
        hash = 61 * hash + this.calificacion;
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
        if (Double.doubleToLongBits(this.precio) != Double.doubleToLongBits(other.precio)) {
            return false;
        }
        if (this.calificacion != other.calificacion) {
            return false;
        }
        if (!Objects.equals(this.idProducto, other.idProducto)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.categoria, other.categoria)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DETALLES DE PRODUCTO: " + "\nID Producto: " + idProducto + "\nNombre: " 
                + nombre + "\nDescripcion: " + descripcion + "\nCategoria: " + categoria 
                + "\nPrecio: " + precio + "\nCalificacion: " + calificacion ;
    }
    
    /**
     * Método de prueba para llenar campos
     * @param c
     * @param lista
     */
    public static void llenarArticulos(Connection c, ObservableList<Producto> lista){
        try {
            Statement in = c.createStatement();
            ResultSet resultado = in.executeQuery(
           "SELECT p.nombre, p.descripcion, p.precio, c.calificacion_producto FROM db_poliventas.tb_producto p JOIN db_poliventas.tb_calificacion_producto c on p.id_producto=c.id_producto");
            System.out.println("si");
            while(resultado.next()){
                lista.add(
                    new Producto( 
                    resultado.getString("p.nombre"), 
                    resultado.getString("p.descripcion"), 
                    Double.parseDouble(resultado.getString("p.precio")),
                    Integer.parseInt(resultado.getString("c.calificacion_producto")))
                );
            }
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
        }
    }    
}
