/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UnitTest;

import ec.edu.espol.Modelo.Usuario;
import java.util.ArrayList;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

/**
 *
 * @author Tiffy
 */
public class UsuarioJunit extends TestCase {

    Usuario user = new Usuario("0931983795", "Stefann", "Salvatore", "0908102940", "Migthsty fall", true, "21223456", "ssalva@tvvd.com", "salvi1", "abc123", false);
    ArrayList<Usuario> u = new ArrayList<>();

    public void testRegistro() {
        assertTrue(user.resgistrar(u));
    }

    public void testRegistroDuplicado() {
        u.add(user);
        assertFalse(user.resgistrar(u));
    }
}
