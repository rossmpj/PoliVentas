/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTest;

import ec.edu.espol.Modelo.Producto;
import ec.edu.espol.Modelo.Vendedor;
import java.util.ArrayList;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

/**
 *
 * @author Tiffy
 */
public class ProductoJunit extends TestCase {
    
    Producto p = new Producto("dress001", "Vestido pets", "Talla S", 10.00, "Mascotas", 4, true, 9, "v0931983795");
    Vendedor com = new Vendedor("0931983795", "Stefann", "Salvatore", "0908102940", "Migthsty fall", true, "21223456", "ssalva@tvvd.com", "salvi1", "abc123", false);
    ArrayList<Producto> c = new ArrayList();
    ArrayList<Vendedor> k = new ArrayList();
    
    public void testRegistroIdeal() {
        assertTrue(p.registrar(c));
    }
    
    public void testRegistroNoIdeal() {
        c.add(p);
        assertFalse(p.registrar(c));
    }
    
    public void testDescontarStockIdeal() {
        assertTrue(p.descontarStockJ(2));
    }
    
    public void testDescontarStockNoIdeal() {
        assertFalse(p.descontarStockJ(5));
    }
    
    public void testObtenerVendedor() {
        k.add(com);
        c.add(p);
        assertNotNull(p.vendedorDeProductoBuscadoJ(k, c));      
    }
    
}

