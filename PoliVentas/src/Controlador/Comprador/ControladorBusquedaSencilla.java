package Controlador.Comprador;

import Auxiliares.*;
import Controlador.Principal.WindowsController;
import Modelo.Producto;
import Vista.Comprador.VistaBusquedaSencilla;
import Vista.Comprador.VistaComprar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorBusquedaSencilla {
    
    private Producto ModeloProducto;
    private final VistaBusquedaSencilla VistaBusquedaSencilla;
    private final ObservableList<Producto> l_articulos;

    public ControladorBusquedaSencilla(Producto ModeloProducto, VistaBusquedaSencilla VistaBusquedaSencilla) {
        this.ModeloProducto = ModeloProducto;
        this.VistaBusquedaSencilla = VistaBusquedaSencilla;
        this.l_articulos = FXCollections.observableArrayList();
        this.VistaBusquedaSencilla.addBackButtonHandler((event -> WindowsController.previous()));
        this.VistaBusquedaSencilla.addBuscarButtonHandler(new BuscarButtonHandler());
        this.VistaBusquedaSencilla.addCleanButtonHandler(new CleanButtonHandler());
    }
       
    private class BuyButtonHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            VistaComprar buyView = new VistaComprar(ModeloProducto);
            ControladorComprar controlCompra = new ControladorComprar(ModeloProducto, buyView);
            WindowsController.next(VistaBusquedaSencilla, buyView);
        }
    }
    
    private class CleanButtonHandler implements EventHandler{
        @Override
        public void handle(Event event) {
            VistaBusquedaSencilla.setBusquedaTextField("");
            VistaBusquedaSencilla.getVBoxProductosEncontrados().getChildren().clear();
            l_articulos.clear();
            VistaBusquedaSencilla.setBusquedaScrollPane(VistaBusquedaSencilla.getVBoxProductosEncontrados());
        }
    }
    
    private class BuscarButtonHandler implements EventHandler{
                            
        @Override
        public void handle(Event event) {
            VistaBusquedaSencilla.getVBoxProductosEncontrados().getChildren().clear();
            cargarContenido();
            VistaBusquedaSencilla.setBusquedaScrollPane(VistaBusquedaSencilla.getVBoxProductosEncontrados());
        }       
        
        private boolean cargarLista(){
            String campo = VistaBusquedaSencilla.cleanString(VistaBusquedaSencilla.getBusquedaTextField());
            boolean isVacio= campo.equals("");
            boolean isGreaterThan3=campo.length()<3;
            if ((!isVacio || !isGreaterThan3)) {
                ModeloProducto.buscarProducto(campo, campo, l_articulos);
                if (!l_articulos.isEmpty()) {
                    return true;
                } else {
                    MensajesAcciones.productoNoEncontrado();
                    return false;
                }
            } else {
                MensajesAcciones.camposVacios();
                return false;
            }
        }
        
        private void cargarContenido() {
            if (cargarLista()) {
                for (Producto p : l_articulos){            
                    HBox hb = new HBox();
                    HBox hb1 = new HBox();
                    Label categoryNameLbl = new Label();
                    Label nameLbl = new Label(p.getNombre());
                    Label desc = new Label(p.getDescripcion());
                    nameLbl.setFont(new Font("Verdana", 19));
                    VistaBusquedaSencilla.iniciarCompra();
                    ModeloProducto = p;
                    VistaBusquedaSencilla.addComprarButtonHandler(new BuyButtonHandler());
                    desc.setText("Descripción: "+p.getDescripcion());
                    categoryNameLbl.setText("Categoria: "+p.getCategoria());
                    hb.setSpacing(100);
                    hb1.setSpacing(100);
                    hb.getChildren().addAll(nameLbl,VistaBusquedaSencilla.getComprar());
                    hb1.getChildren().addAll(VistaBusquedaSencilla.crearEstrellas(p.getCalificacionP().getCalificacionP(), "Producto"),
                            VistaBusquedaSencilla.crearEstrellas(p.getCalificacionV().getCalificacionV(),"Vendedor"));
                    hb.setPadding(new Insets(7, 0, 7, 5));
                    VistaBusquedaSencilla.getVBoxProductosEncontrados().setPadding(new Insets(7, 70, 0, 70));
                    VistaBusquedaSencilla.getVBoxProductosEncontrados().getChildren().addAll(hb,categoryNameLbl,desc,VistaBusquedaSencilla.precioProducto(p.getPrecio()),
                            VistaBusquedaSencilla.nombreProducto(p.getTiempoMaxEntrega().toString()), hb1,
                             VistaBusquedaSencilla.drawLine());
                }
            }
        }  
    }
}