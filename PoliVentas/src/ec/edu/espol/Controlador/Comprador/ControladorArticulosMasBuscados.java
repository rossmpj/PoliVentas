package ec.edu.espol.Controlador.Comprador;

import ec.edu.espol.Auxiliares.DBConnection;
import ec.edu.espol.Controlador.Administrador.ControladorInfoUsuario;
import ec.edu.espol.Controlador.Principal.ControladorLogin;
import ec.edu.espol.Controlador.Principal.WindowsController;
import ec.edu.espol.Modelo.Administrador;
import ec.edu.espol.Modelo.Producto;
import ec.edu.espol.Vista.Administrador.VistaInfoUsuario;
import ec.edu.espol.Vista.Comprador.VistaBusquedaSencilla;
import ec.edu.espol.Vista.Principal.ArticulosMasBuscados;
import ec.edu.espol.Vista.Principal.PaneLogin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public class ControladorArticulosMasBuscados {

    private final Producto ModeloProducto;
    private final ArticulosMasBuscados VistaArticulosMasBuscados;
    private final ObservableList<Producto> observableList;    

    public ControladorArticulosMasBuscados(Producto ModeloProducto, ArticulosMasBuscados VistaArticulosMasBuscados) {
        this.ModeloProducto = ModeloProducto;
        this.VistaArticulosMasBuscados = VistaArticulosMasBuscados;
        this.observableList = FXCollections.observableArrayList();
        this.VistaArticulosMasBuscados.addIniciarSesionBtnHandler(new IniciarSesionBtnHandler());
        this.VistaArticulosMasBuscados.addRegistrarseBtnHandler(new RegistrarseBtnHandler());
        this.VistaArticulosMasBuscados.addBackButtonHandler((e) -> WindowsController.previous());
        cargarData();
        actualizarTabla();
    }

    /**
     * Llena la lista con los articulos más buscados
     */
    private void cargarData() {
        DBConnection conexion = DBConnection.getInstance();
        conexion.conectar();
        this.ModeloProducto.ArticulosMasBuscados(this.observableList);
        conexion.desconectar();
    }

    /**
     * Carga las columnas y los items en la tabla
     */
    private void actualizarTabla() {
        VistaArticulosMasBuscados.getColNombre().setCellValueFactory(new PropertyValueFactory<>("nombre"));
        VistaArticulosMasBuscados.getColDescripcion().setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        VistaArticulosMasBuscados.getColPrecio().setCellValueFactory(new PropertyValueFactory<>("precio"));
        VistaArticulosMasBuscados.getColCateg().setCellValueFactory(new PropertyValueFactory<>("categoria"));
        VistaArticulosMasBuscados.getColStock().setCellValueFactory(new PropertyValueFactory<>("stock"));
        VistaArticulosMasBuscados.getColNB().setCellValueFactory(new PropertyValueFactory<>("numBusquedas"));
        VistaArticulosMasBuscados.getColCalif().setCellValueFactory(new PropertyValueFactory<>("calificacion"));
        cargarBotones();
        VistaArticulosMasBuscados.getTabla().setItems(observableList);
    }

    /**
     * Handler para boton regitrarse
     */
    private class RegistrarseBtnHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            Administrador d = new Administrador();
            VistaInfoUsuario vistaInfoUsuario = new VistaInfoUsuario(true, "FADCA8", "Formulario de Registro",null);
            ControladorInfoUsuario controladorArticulosMasBuscados = new ControladorInfoUsuario( d, vistaInfoUsuario);
            WindowsController.next(VistaArticulosMasBuscados, vistaInfoUsuario);
        }
    }

    /**
     * Handler para boton iniciar sesion
     */
    private class IniciarSesionBtnHandler implements EventHandler {
        @Override
        public void handle(Event event) {
            PaneLogin loginView = new PaneLogin();
            ControladorLogin loginController = new ControladorLogin(loginView);
            WindowsController.next(VistaArticulosMasBuscados, loginView);
        }
    }
    
    /**
     * Método que carga los botones que se encuentran dentro de la tabla de artículos más buscados
     */
    private void cargarBotones(){
        Callback<TableColumn<Producto, Void>, TableCell<Producto, Void>> cellFactory = (final TableColumn<Producto, Void> param) -> {
            final TableCell<Producto, Void> cell = new TableCell<Producto, Void>() {
                private final Button btn = new Button("Ver"); {
                btn.setOnAction((ActionEvent event) -> {
                    Administrador d = new Administrador();
                    VistaInfoUsuario vistaInfoUsuario = new VistaInfoUsuario(true, "FADCA8", "Formulario de Registro",null);
                    ControladorInfoUsuario controladorArticulosMasBuscados = new ControladorInfoUsuario(d, vistaInfoUsuario);
                    Producto ModeloProducto = new Producto();
                    VistaBusquedaSencilla busqueda = new VistaBusquedaSencilla();
                    ControladorBusquedaSencilla controllerBusqueda = new ControladorBusquedaSencilla(ModeloProducto, busqueda);
                    if(!VistaArticulosMasBuscados.isIngreso()){
                        WindowsController.next(VistaArticulosMasBuscados, vistaInfoUsuario);
                    }else{
                        WindowsController.next(VistaArticulosMasBuscados, busqueda);
                    }
                });
            }
                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }
            };
            return cell;
        };
        this.VistaArticulosMasBuscados.getColBtn().setCellFactory(cellFactory);
    }
    
}
