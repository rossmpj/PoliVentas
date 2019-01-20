package Controlador.Comprador;

import Auxiliares.DBConnection;
import Controlador.Administrador.ControladorInfoUsuario;
import Controlador.Principal.WindowsController;
import Modelo.Administrador;
import Modelo.Producto;
import Modelo.Usuario;
import Vista.Administrador.VistaInfoUsuario;
import Vista.Principal.ArticulosMasBuscados;
import Vista.Principal.PaneLogin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;

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
        cargarData();
        actualizarTabla();
    }

    private void cargarData() {
        DBConnection conexion = DBConnection.getInstance();
        conexion.conectar();
        ArticulosMasBuscados(conexion.getConnection(), this.observableList);
        conexion.desconectar();
    }

    private void actualizarTabla() {
        VistaArticulosMasBuscados.getColNombre().setCellValueFactory(new PropertyValueFactory<>("nombre"));
        VistaArticulosMasBuscados.getColDescripcion().setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        VistaArticulosMasBuscados.getColPrecio().setCellValueFactory(new PropertyValueFactory<>("precio"));
        VistaArticulosMasBuscados.getColCateg().setCellValueFactory(new PropertyValueFactory<>("categoria"));
        VistaArticulosMasBuscados.getColStock().setCellValueFactory(new PropertyValueFactory<>("stock"));
        VistaArticulosMasBuscados.getColNB().setCellValueFactory(new PropertyValueFactory<>("numBusquedas"));
        VistaArticulosMasBuscados.getColCalif().setCellValueFactory(new PropertyValueFactory<>("calificacion"));
        VistaArticulosMasBuscados.getTabla().setItems(observableList);
    }

    public void ArticulosMasBuscados(Connection c, ObservableList<Producto> lista) {
        try {
            Statement in = c.createStatement();
            ResultSet resultado = in.executeQuery(
                    "select p.id_producto, p.nombre, p.descripcion, p.precio, p.categoria, p.stock, p.num_busquedas, c.calificacion_producto from tb_producto p join tb_calificacion_producto c on p.id_producto = c.id_producto order by p.num_busquedas desc limit 15;");
            System.out.println("si");
            while (resultado.next()) {
                lista.add(
                        new Producto(
                                resultado.getString("p.id_producto"),
                                resultado.getString("p.nombre"),
                                resultado.getString("p.descripcion"),
                                Double.parseDouble(resultado.getString("p.precio")),
                                resultado.getString("p.categoria"),
                                Integer.parseInt(resultado.getString("p.stock")),
                                Integer.parseInt(resultado.getString("p.num_busquedas")),
                                Integer.parseInt(resultado.getString("c.calificacion_producto")))
                );
            }
        } catch (SQLException ex) {
            System.out.println("EXCEPCION: " + ex.getMessage());
        }
    }

    private class RegistrarseBtnHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            Usuario user = new Usuario();
            Administrador d = new Administrador();
            VistaInfoUsuario vistaInfoUsuario = new VistaInfoUsuario(true, "FADCA8", "Formulario de Registro");
            ControladorInfoUsuario controladorArticulosMasBuscados = new ControladorInfoUsuario(user, d, vistaInfoUsuario);
            WindowsController.next(VistaArticulosMasBuscados, vistaInfoUsuario);
        }
    }

    private class IniciarSesionBtnHandler implements EventHandler {

        @Override
        public void handle(Event event) {
            WindowsController.next(VistaArticulosMasBuscados, new PaneLogin());
        }
    }
}
