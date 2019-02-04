/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTest;

import ec.edu.espol.Modelo.Comprador;
import ec.edu.espol.Modelo.PagoVirtual;
import java.util.ArrayList;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

/**
 *
 * @author Tiffy
 */
public class PagoVirtualJunit extends TestCase {

    public void testDescontarSaldo() {
        Comprador com = new Comprador("0931983795", "Stefann", "Salvatore", "0908102940", "Migthsty fall", true, "21223456", "ssalva@tvvd.com", "salvi1", "abc123", false);
        ArrayList<Comprador> c = new ArrayList();
        PagoVirtual v = new PagoVirtual();
        com.setSaldo(50);
        c.add(com);
        assertTrue(v.pagar(com, "c0931983795", 10, c));
    }

    public void testDescuentoIdeal() {
        Comprador com = new Comprador("0931983795", "Stefann", "Salvatore", "0908102940", "Migthsty fall", true, "21223456", "ssalva@tvvd.com", "salvi1", "abc123", false);
        ArrayList<Comprador> c = new ArrayList();
        com.setSaldo(50);
        PagoVirtual v = new PagoVirtual();
        c.add(com);
        assertEquals(10.0, v.descontarSaldo("c0931983795", 40, c));
    }
    
    /***
     * Cuando no se tiene saldo suficiente
     */
    public void testPagoNoIdeal() {
        Comprador com = new Comprador("0931983795", "Stefann", "Salvatore", "0908102940", "Migthsty fall", true, "21223456", "ssalva@tvvd.com", "salvi1", "abc123", false);
        ArrayList<Comprador> c = new ArrayList();
        com.setSaldo(10);
        PagoVirtual v = new PagoVirtual();
        c.add(com);
        assertFalse(v.pagar(com, "c0931983795", 50, c));
    }

}

