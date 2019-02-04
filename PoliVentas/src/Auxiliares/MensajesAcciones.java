package Auxiliares;

import java.util.Optional;
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
     /**
      * Muestra mensaje indicando que el producto ingresado no se ha encontrado
      */
    public static void productoNoEncontrado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("404 not found");
        alert.setHeaderText(null);
        alert.setContentText("Lo sentimos, el artículo que está buscando no existe");
        alert.showAndWait();
    }
    
    /**
     * Ventana emergente que indica que una compra se realizó con éxito
     */
    public static void notificarVendedor() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Correo enviado exitosamente");
        alert.setHeaderText(null);
        alert.setContentText("El vendedor ha sido notificado para realizar la entrega");
        alert.showAndWait();
    }
    
    /**
     * Ventana que muestra que hubo un error al momento de realizar la compra
     */
    public static void notificarVendedorFailed() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Envío de correo fallido");
        alert.setHeaderText(null);
        alert.setContentText("Lo sentimos, no se ha podido notificar al vendedor");
        alert.showAndWait();
    }
    
    /**
     * Ventana que indica que una calificación se guardó con éxito en la base
     * @param tipo: puede ser "Producto" o "Vendedor"
     */
    public static void calificacionExitosa(String tipo){
        Alert advertencia = new Alert(Alert.AlertType.INFORMATION);
            advertencia.setTitle("Calificación "+ tipo);
            advertencia.setContentText("Se ha guardado la calificación correctamente");
            advertencia.setHeaderText(null);
            advertencia.showAndWait();
    }
    
    /**
     * Ventana que se muestra en caso de no haber podido guardar la calificación
     * @param tipo
     */
    public static void calificacionFallida(String tipo){
        Alert advertencia = new Alert(Alert.AlertType.ERROR);
            advertencia.setTitle("Calificación "+ tipo);
            advertencia.setContentText("Lo sentimos, no se pudo guardar la calificación");
            advertencia.setHeaderText(null);
            advertencia.showAndWait();
    }  
    
    /**
     * Mensaje de confirmación para realizar la anulación de un pedido
     * @return verdadero o falso para cancelar o no la acción en el controlador
     */
    public static boolean confirmacionAnularPedido(){
        Alert advertencia = new Alert(Alert.AlertType.CONFIRMATION);
            advertencia.setTitle("Anular pedido");
            advertencia.setContentText("¿Está seguro de que desea anular el pedido?");
            advertencia.setHeaderText(null);
            Optional<ButtonType> result = advertencia.showAndWait();
            return (result.get() == ButtonType.OK);
    }
    
    /**
     * Ventana emergente que muestra que el estado de un pedido fue cambiado exitosamente
     * @param estado puede ser anulado o entregado
     */
    public static void estadoPedidoCambiado(String estado){
        Alert advertencia = new Alert(Alert.AlertType.INFORMATION);
            advertencia.setTitle("Pedido "+estado);
            if (estado.equals("anulado")){
                advertencia.setContentText("Se ha anulado su pedido");
            }else{
                advertencia.setContentText("Gracias por confirmar la entrega de su pedido");
            }
            advertencia.setHeaderText(null);
            advertencia.showAndWait();
    }
    
    /**
     * Ventana emergente para el caso en que el estado no se puede actualizar
     * @param estado 
     */
    public static void PedidoFallido(String estado){
        Alert advertencia = new Alert(Alert.AlertType.ERROR);
            advertencia.setTitle("Pedido no "+estado);
            advertencia.setContentText("Lo sentimos, no se pudo realizar la actualizacion del estado su pedido");
            advertencia.setHeaderText(null);
            advertencia.showAndWait();
    }
       
    /**
     * Método que muestra un cuadro de diálogo indicando un inicio de sesioón incorrecto
     */
    public static void validarLogin(){
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
     * Ventana emergente que muestra un mensaje informando que el usuario debe 
     * seleccionar un item de la tabla para poder anular. 
     */
    public static void nadaQueAnular(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("No hay nada que anular");
        alert.setContentText("Debe seleccionar en la tabla el pedido que desea anular");
        alert.showAndWait();
    }
    
    /**
     * Ventana emergente que indica que el usuario no puede realizar ninguna de
     * las operaciones que se muestran en la ventana, tales como anular o calificar
     */
    public static void accionEnTablaPedidosVacia(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText("No se puede realizar ninguna acción");
        alert.setContentText("Usted no tiene ninguna compra pendiente");
        alert.showAndWait();
    }
    
    /**
     * Mensaje de confirmación para realizar la compra de un producto
     * @param total a pagar
     * @return verdadero o falso
     */
    public static boolean confirmarCompra(double total){
        Alert advertencia = new Alert(Alert.AlertType.CONFIRMATION);
        advertencia.setTitle("Confirmar compra");
        advertencia.setContentText("El total a pagar es: $"+ String.valueOf(total));
        advertencia.setHeaderText("¿Está seguro de que desea realizar la compra?");
        Optional<ButtonType> result = advertencia.showAndWait();
        return (result.get() == ButtonType.OK);
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
