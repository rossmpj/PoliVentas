/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Vendedor;

import Auxiliares.CONSTANTES;
import static Auxiliares.PatronVistaTitulos.crearTituloSubMenu;
import Vista.Principal.Vista;
import java.util.LinkedList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Tiffy, Galo Xavier Figueroa Villacreses
 */
public class VistaFechaPedido implements Vista {

    private final BorderPane root;
    private final String color;
    private final String titulo;
    private Button guardar;
    private Button back;
    private ComboBox horaEntrega;
    private DatePicker datePicker;
    
    public VistaFechaPedido() {
        root = new BorderPane();
        this.color = "f0f0f0";
        this.titulo = "Modificar fecha de entrega";
        root.setTop(crearTituloSubMenu(titulo, color));
        inicializarObjetos();
        construccion();
    }

    private void inicializarObjetos() {
        back = new Button();
        datePicker = new DatePicker();
        estiloBotones(back, "FFFFFF", "/back.png");
        root.setBottom(back);
        horaEntrega = new ComboBox(createTimeOptionsList(9, 16, 15));
        gestionBotones();
    }

    private VBox gestionBotones() {
        VBox sa = new VBox();
        sa.setAlignment(Pos.CENTER_RIGHT);
        guardar = new Button("Guardar");
        guardar.setPrefSize(100, 50);
        sa.getChildren().add(guardar);
        return sa;
    }

    private void construccion() {
        HBox hb = new HBox();
        VBox contenedor=new VBox();
        contenedor.setSpacing(10);
        contenedor.setAlignment(Pos.CENTER);
        hb.setSpacing(15);
        contenedor.getChildren().addAll(seccionAvatar(),gestionBotones());
        hb.getChildren().addAll(formulario(),contenedor);
        hb.setAlignment(Pos.CENTER);
        root.setCenter(hb);
    }

    private VBox formulario() {
        VBox scawflone = new VBox();
        GridPane grandPrix = new GridPane();
        
        grandPrix.addColumn(0, new Label("Fecha de entrega"), new Label("Hora de entrega"));
        grandPrix.addColumn(1, datePicker, horaEntrega);
        grandPrix.setHgap(15);
        grandPrix.setVgap(15);
        
        scawflone.setPadding(new Insets(30, 10, 0, 20));
        scawflone.setAlignment(Pos.CENTER);
        scawflone.getChildren().add(grandPrix);
        
        return scawflone;
    }

    private void estiloBotones(Button btn, String base, String path) {
        btn.setStyle("-fx-background-radius: 15em; -fx-min-width: 50px; -fx-min-height: 50px;"
                + " -fx-max-width: 50px; -fx-max-height: 50px; -fx-base: #" + base + ";");
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG + path));
        btn.setGraphic(new ImageView(image));
        btn.setAlignment(Pos.CENTER);
    }
    
     
     private VBox seccionAvatar() {
        VBox k = new VBox();
        Image image = new Image(getClass().getResourceAsStream(CONSTANTES.PATH_IMG+"/cesta.png"));
        Label myLabel = new Label();
        myLabel.setGraphic(new ImageView(image));
        k.setPadding(new Insets(30, 0, 0, 5));
        k.getChildren().add(myLabel);
        return k;
    }

    private ObservableList<String> createTimeOptionsList(int start, int end, int period){
        
        if(start >= end || period > 60) throw new IllegalArgumentException();
        
        List<String> timeOptionsList = new LinkedList<>();
        
        for(int i = start; i <= end; i++){
            
            String hour = String.format("%02d",i);
            
            if(i != 24){
                
                for(int j = 0; j < 60/period; j++) {

                    String minute = String.format("%02d", period*j);
                    timeOptionsList.add(hour + ":" + minute);
                }
                
            } else  timeOptionsList.add(hour + ":00");
        }
        return FXCollections.observableList(timeOptionsList);
    }
    
    public void addSaveButtonHandler(EventHandler saveButtonHandler){
        guardar.setOnAction(saveButtonHandler);
    }
    
    public void addBackButtonHandler(EventHandler backButtonHandler){
        back.setOnAction(backButtonHandler);
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public ComboBox getHoraEntrega() {
        return horaEntrega;
    }

    @Override
    public BorderPane getRoot() {
        return root;
    }
}
