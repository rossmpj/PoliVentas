package Modelo;

/**
 *
 * @author Rosy
 */
public class CalificacionVendedor {
    private String idCalificacionV;
    private int calificacionV;
    private Vendedor vendedor;
    private Comprador comprador;

    public CalificacionVendedor(String idCalificacionV, int calificacionV, 
            Vendedor vendedor, Comprador comprador) {
        this.idCalificacionV = idCalificacionV;
        this.calificacionV = calificacionV;
        this.vendedor = vendedor;
        this.comprador = comprador;
    }
    public CalificacionVendedor() {
    }

    public String getIdCalificacionV() {
        return idCalificacionV;
    }

    public void setIdCalificacionV(String idCalificacionV) {
        this.idCalificacionV = idCalificacionV;
    }

    public int getCalificacionV() {
        return calificacionV;
    }

    public void setCalificacionV(int calificacionV) {
        this.calificacionV = calificacionV;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    @Override
    public String toString() {
        return "CalificacionVendedor{" + "idCalificacionV=" + idCalificacionV + ", calificacionV=" + calificacionV + ", vendedor=" + vendedor + ", comprador=" + comprador + '}';
    }
    
}