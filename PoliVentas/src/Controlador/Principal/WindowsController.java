/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Principal;

import Main.PoliVentas;
import Vista.Principal.Vista;
import java.util.Deque;
import java.util.LinkedList;
import javafx.scene.Scene;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public final class WindowsController {
    
    private static final Deque<Vista> TRACK = new LinkedList<>();
    private static Scene scene = PoliVentas.scene;
    
    public static void setScene(Scene scene){
        WindowsController.scene = scene;
    }
    
    public static void next(Vista current, Vista next){
        
        TRACK.push(current);
        scene.setRoot(next.getRoot());
        
    }
    
    public static void previous(){
        
        Vista vista = TRACK.pop();
        scene.setRoot(vista.getRoot());
        
    }
    
    
}
