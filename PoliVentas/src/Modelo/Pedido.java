/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Rosa
 */
public class Pedido {
    private String codPedido;
    private String estado;
    private double costo;
    private Date fechaPedido;
    private Time horaPedido;
    private Date fechaEntrega;
    private Time horaEntrega;
    private String lugarEntrega;
    private Pago metodoPago ;

    public Pedido(){}
    
    public Pedido(String codPedido, String estado, double costo, Date fechaPedido, Time horaPedido, Date fechaEntrega, Time horaEntrega, String lugarEntrega, Pago metodoPago) {
        this.codPedido = codPedido;
        this.estado = estado;
        this.costo = costo;
        this.fechaPedido = fechaPedido;
        this.horaPedido = horaPedido;
        this.fechaEntrega = fechaEntrega;
        this.horaEntrega = horaEntrega;
        this.lugarEntrega = lugarEntrega;
        this.metodoPago = metodoPago;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
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

    @Override
    public String toString() {
        return "Pedido{" + "codPedido=" + codPedido + ", estado=" + estado + ", costo=" + costo + ", fechaPedido=" + fechaPedido + ", horaPedido=" + horaPedido + ", fechaEntrega=" + fechaEntrega + ", horaEntrega=" + horaEntrega + ", lugarEntrega=" + lugarEntrega + ", metodoPago=" + metodoPago + '}';
    }
    
}
