package ec.edu.espol.Modelo;

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
    
    /**
     * Constructor de la clase
     * @param cedula
     * @param nombres
     * @param apellidos
     * @param telefono
     * @param direccion
     * @param whatsapp true si tiene whatsapp, false si no tiene
     * @param matricula
     * @param email
     * @param usuario
     * @param contra
     * @param es, true si el usuario está eliminado, false si está activo 
     */
    public Vendedor(String cedula, String nombres, String apellidos, String telefono,
            String direccion, boolean whatsapp, String matricula, String email,String usuario, String contra,boolean es) {
        super(cedula, nombres, apellidos, telefono, direccion, whatsapp, matricula, email, usuario, contra, es);
        this.idVendedor = "v"+cedula;
    }    
    
     public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }
     
}