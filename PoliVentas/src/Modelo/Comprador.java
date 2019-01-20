package Modelo;

/**
 *
 * @author Rosa
 */
public class Comprador extends Usuario {

    protected String id_comprador;

    /**
     * Constructor por defecto para el comprador
     */
    public Comprador() {
    }

    /**
     * Constructor con parametros para el comprador
     *
     * @param nombres
     * @param apellidos
     * @param telefono
     * @param whatsapp
     * @param email
     * @param direccion
     * @param cedula
     * @param matricula
     */
    public Comprador(String cedula, String nombres, String apellidos, String telefono,
            String direccion, boolean whatsapp, String matricula, String email) {
        super(cedula, nombres, apellidos, telefono, direccion, whatsapp, matricula, email);
        this.id_comprador = "c" + cedula;
    }

    public String getId_comprador() {
        return id_comprador;
    }

}
