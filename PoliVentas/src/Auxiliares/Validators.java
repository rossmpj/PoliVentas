/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

/**
 *
 * @author Galo Xavier Figueroa Villacreses
 */
public final class Validators {
    
    public static Float validateFloat(String number){
        
        Float parsed;
        
        try{
            
            parsed = Float.parseFloat(number);
            
        } catch(NumberFormatException | NullPointerException e1){
            
            return null;
            
        }
        
        return parsed;
    }
    
    public static Integer validateInt(String number){
        
        Integer parsed;
        
        try{
            
            parsed = Integer.parseInt(number);
            
        } catch(NumberFormatException | NullPointerException e1){
            
            return null;
            
        }
        
        return parsed;
    }
    
    public static boolean fieldNotEmpty(String text){
        
        return !(text == null || text.length() == 0 || text.split(" ").length == 0);
        
    }
    
}
