package Modelo;

/**
 *
 * @author Rosy
 */
public class CalificacionProducto {
    private String idCalificacionP;
    private int calificacionP;
    private Producto product;
    private Comprador comprador;

    public CalificacionProducto(String idCalificacionP, int calificacionP, 
            Producto product, Comprador comprador) {
        this.idCalificacionP = idCalificacionP;
        this.calificacionP = calificacionP;
        this.product = product;
        this.comprador = comprador;
    }
    
    public CalificacionProducto() {
    }

    public String getIdCalificacionP() {
        return idCalificacionP;
    }

    public void setIdCalificacionP(String idCalificacionP) {
        this.idCalificacionP = idCalificacionP;
    }

    public int getCalificacionP() {
        return calificacionP;
    }

    public void setCalificacionP(int calificacionP) {
        this.calificacionP = calificacionP;
    }

    public Producto getProduct() {
        return product;
    }

    public void setProduct(Producto product) {
        this.product = product;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    @Override
    public String toString() {
        return "CalificacionProducto{" + "idCalificacionP=" + idCalificacionP + ", calificacionP=" + calificacionP + ", product=" + product + ", comprador=" + comprador + '}';
    }

}