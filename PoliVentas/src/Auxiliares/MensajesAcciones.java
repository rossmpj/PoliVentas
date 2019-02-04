package Auxiliares;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;

/**
 *
 * @author Tiffy
 */
public class MensajesAcciones {

    private MensajesAcciones() {
    }

    /**
     * Método que permitirá mostrar una ventana cuando se produzca una excepcion
     */
    public static void ventanaProblemasTecnicos() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Lo sentimos, estamos teniendo inconvenientes técnicos, realice la operación más tarde");
        alert.showAndWait();
    }

    /**
     * Método que permitirá mostrar una ventana cuando el usuario deje algún
     * campo vacío
     */
    public static void camposVacios() {
        Alert advertencia = new Alert(Alert.AlertType.WARNING);
        advertencia.setTitle("Error");
        advertencia.setContentText("Debe asegurarse de llenar todos los campos");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }

    /**
     * Método que permitirá saber que un registro se almacenó correctamente
     */
    public static void almacenamientoExitoso() {
        Alert advertencia = new Alert(Alert.AlertType.INFORMATION);
        advertencia.setTitle("Almacenar registro");
        advertencia.setContentText("Registro almacenado correctamente");
        advertencia.setHeaderText(null);
        advertencia.initStyle(StageStyle.UTILITY);
        advertencia.showAndWait();
    }

    /**
     * Método que permitirá saber que un registro se eliminó correctamente
     */
    public static void eliminacionExitosa() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Eliminar registro");
        alert.setHeaderText(null);
        alert.setContentText("El registro ha sido eliminado exitosamente");
        alert.showAndWait();
    }

    /**
     * Método que permitirá saber que un registro se modificó correctamente
     */
    public static void modificacionExitosa() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modificar registros");
        alert.setHeaderText(null);
        alert.setContentText("El registro ha sido modificado exitosamente");
        alert.showAndWait();
    }

    /**
     * Método que permitirá mostrar una ventana cuando ya exista un registro
     */
    public static void registroDuplicado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("El registro que está ingresando ya existe");
        alert.showAndWait();
    }

    /**
     * Método que permitirá mostrar una ventana cuando no exista un registro
     * buscado
     */
    public static void registroNoEncontrado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("404 not found");
        alert.setHeaderText(null);
        alert.setContentText("Lo sentimos, el registro que está buscando no existe");
        alert.showAndWait();
    }
    
    public static void productoNoEncontrado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("404 not found");
        alert.setHeaderText(null);
        alert.setContentText("Lo sentimos, el artículo que está buscando no existe");
        alert.showAndWait();
    }
    
    public static void NotificarVendedor() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Correo enviado exitosamente");
        alert.setHeaderText(null);
        alert.setContentText("El vendedor ha sido notificado para realizar la entrega");
        alert.showAndWait();
    }
    
    public static void NotificarVendedorFailed() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Envío de correo fallido");
        alert.setHeaderText(null);
        alert.setContentText("Lo sentimos, no se ha podido notificar al vendedor");
        alert.showAndWait();
    }
    
    
    public static void CalificacionProductoSi(){
        Alert advertencia = new Alert(Alert.AlertType.INFORMATION);
            advertencia.setTitle("Calificacion Producto");
            advertencia.setContentText("Se ha guardado la calificación correctamente");
            advertencia.setHeaderText(null);
            advertencia.initStyle(StageStyle.UTILITY);
            advertencia.showAndWait();
    }
    
    public static void CalificacionProductoNo(){
        Alert advertencia = new Alert(Alert.AlertType.ERROR);
            advertencia.setTitle("Calificacion Producto");
            advertencia.setContentText("Lo sentimos, no se pudo guardar la calificación");
            advertencia.setHeaderText(null);
            advertencia.initStyle(StageStyle.UTILITY);
            advertencia.showAndWait();
    }
    
    public static void CalificacionVendedorSi(){
        Alert advertencia = new Alert(Alert.AlertType.INFORMATION);
            advertencia.setTitle("Calificacion Vendedor");
            advertencia.setContentText("Se ha guardado la calificación correctamente");
            advertencia.setHeaderText(null);
            advertencia.initStyle(StageStyle.UTILITY);
            advertencia.showAndWait();
    }
    
    public static void CalificacionVendedorNo(){
        Alert advertencia = new Alert(Alert.AlertType.ERROR);
            advertencia.setTitle("Calificacion Vendedor");
            advertencia.setContentText("Lo sentimos, no se pudo guardar la calificación");
            advertencia.setHeaderText(null);
            advertencia.initStyle(StageStyle.UTILITY);
            advertencia.showAndWait();
    }
    
    public static void PedidoAnulado(){
        Alert advertencia = new Alert(Alert.AlertType.CONFIRMATION);
            advertencia.setTitle("Anular pedido");
            advertencia.setContentText("Está seguro de que desea anular el pedido?");
            advertencia.setHeaderText(null);
            advertencia.initStyle(StageStyle.UTILITY);
            advertencia.showAndWait();
    }
    
    public static void PedidoAnuladoSi(){
        Alert advertencia = new Alert(Alert.AlertType.INFORMATION);
            advertencia.setTitle("Anular pedido");
            advertencia.setContentText("Se ha anulado su pedido");
            advertencia.setHeaderText(null);
            advertencia.initStyle(StageStyle.UTILITY);
            advertencia.showAndWait();
    }
    
    public static void PedidoAnuladoNo(){
        Alert advertencia = new Alert(Alert.AlertType.INFORMATION);
            advertencia.setTitle("Anular pedido");
            advertencia.setContentText("Lo sentimos, no su pedido no ha sido anulado");
            advertencia.setHeaderText(null);
            advertencia.initStyle(StageStyle.UTILITY);
            advertencia.showAndWait();
    }
    
    public static void PedidoExitoso(){
        Alert advertencia = new Alert(Alert.AlertType.INFORMATION);
            advertencia.setTitle("Pedido entregado");
            advertencia.setContentText("Gracias por confirmar la entrega de su pedido");
            advertencia.setHeaderText(null);
            advertencia.initStyle(StageStyle.UTILITY);
            advertencia.showAndWait();
    }
    
    public static void PedidoFallido(){
        Alert advertencia = new Alert(Alert.AlertType.ERROR);
            advertencia.setTitle("Pedido no entregado");
            advertencia.setContentText("Lo sentimos, no se pudo realizar la actualizacion de su pedido");
            advertencia.setHeaderText(null);
            advertencia.initStyle(StageStyle.UTILITY);
            advertencia.showAndWait();
    }
    
    /**
     * Método utilizado en la vista de búsqueda sencilla, que muestra un mensaje 
     * de error en caso de que el usuario haya buscado un artículo con menos de 3 caracteres
     */
    public static void IngresoNoValido(){
        Alert advertencia = new Alert(Alert.AlertType.ERROR);
            advertencia.setTitle("Búsqueda fallida");
            advertencia.setContentText("Ingrese al menos 3 caracteres para realizar la búsqueda");
            advertencia.setHeaderText(null);
            advertencia.initStyle(StageStyle.UTILITY);
            advertencia.showAndWait();
    }
    /**
     * Método que muestra un cuadro de diálogo indicando un inicio de sesioón incorrecto
     */
    public static void validarIngreso(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Inicio de sesión incorrecto");
        alert.setHeaderText("");
        alert.setContentText("Nombre de usuario o contraseña incorrectos");
        alert.showAndWait();
    }
    
      /**
     * Método que muestra un cuadro de diálogo indicando que no cuenta con suficiente saldo
     */
    public static void saldoInsuficiente(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Sin dinero virtual :( ");
        alert.setHeaderText("");
        alert.setContentText("Lo sentimos, no puede realizar la compra por falta de saldo disponible");
        alert.showAndWait();
    }
    
          /**
     * Método que muestra un cuadro de diálogo indicando que no hay productos disponibles
     */
    public static void stockInsuficiente(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Sin productos disponibles :( ");
        alert.setHeaderText("");
        alert.setContentText("Lo sentimos, no hay productos disponibles");
        alert.showAndWait();
    }
    
    /**
    * Método que muestra un cuadro de diálogo indicando que se debe seleccinar un registro para proceder con la acción solicitada
    */
    public static void registroSinSeleccionar(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Noy hay nada seleccionado");
        alert.setContentText("Debes seleccionar en la tabla el registro sobre el cual quieres realizar la acción solicitada");
        alert.showAndWait();
    }
    
    public static ButtonType confirmacion(String body){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Mensaje de confirmación");
        alert.setHeaderText("¿Estás seguro de proseguir con la acción solicitada?");
        alert.setContentText(body);
        alert.showAndWait();
        
        return alert.getResult();
    }
    
    public static void camposNumericosIncorrectos(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("Valor ingresado incorrecto");
        alert.setContentText("Todos los campos son obligatorios.\nEn los campos numéricos, recuerda ingresar números positivos.");
        alert.showAndWait();
    }
}
