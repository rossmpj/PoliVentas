package Modelo;

/**
 *
 * @author Rosa
 */
public class Vendedor extends Comprador{
    protected String idVendedor;
    /**
     * Constructor por defecto
     */
    public Vendedor() {
    }
     /*   
     * Constructor con parámetros del vendedor
     * @param nombres
     * @param apellidos
     * @param telefono
     * @param whatsapp
     * @param email
     * @param direccion
     * @param cedula
     * @param matricula
     */
    public Vendedor(String cedula, String nombres, String apellidos, String telefono,
            String direccion, boolean whatsapp, String matricula, String email) {
        super(cedula, nombres, apellidos, telefono, direccion, whatsapp, matricula, email);
        this.idVendedor = "v"+cedula;
    }    
    
     public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }
     
}