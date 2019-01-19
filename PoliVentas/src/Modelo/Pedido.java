package Modelo;

import java.sql.Date;
import java.sql.Time;

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
    private String lugarEntrega;
    private Pago metodoPago;
    private Comprador comprador;
    private Vendedor vendedor;
    private Producto product;

    public Pedido(){}
    
    public Pedido(String codPedido, String estado, double costo, Date fechaPedido, Time horaPedido, Date fechaEntrega, Time horaEntrega, String lugarEntrega, Pago metodoPago) {
        this.idPedido = codPedido;
        this.estado = estado;
        this.costo = costo;
        this.fechaPedido = fechaPedido;
        this.horaPedido = horaPedido;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.lugarEntrega = lugarEntrega;
        this.metodoPago = metodoPago;
    }

    public Pedido(String idPedido, String estado, double costo, int cantidadPedida, Date fechaPedido, Time horaPedido, Date fechaEntrega, Time horaEntrega, String lugarEntrega, Pago metodoPago, Comprador comprador, Vendedor vendedor, Producto product) {
        this.idPedido = idPedido;
        this.estado = estado;
        this.costo = costo;
        this.cantidadPedida = cantidadPedida;
        this.fechaPedido = fechaPedido;
        this.horaPedido = horaPedido;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.lugarEntrega = lugarEntrega;
        this.metodoPago = metodoPago;
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.product = product;
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
                + metodoPago + "\nComprador: " + comprador + "Vendedor: " 
                + vendedor + "\nProducto: " + product;
    }
    
}