/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package proyecto_acronimos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author juasanlop2
 */
public class AcronimosTest {
    
    public AcronimosTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of obtenerAcronimo method, of class Acronimos.
     */
    @Test
    public void testObtenerAcronimo() {
        System.out.println("obtenerAcronimo");
        String cadena = "Pruba";
        Acronimos instance = new Acronimos();
        String expResult = "P.";
        String result = instance.obtenerAcronimo(cadena);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testObtenerAcronimoCaracterVacio() {
        System.out.println("obtenerAcronimo");
        String cadena = " ";
        Acronimos instance = new Acronimos();
        String expResult = "";
        String result = instance.obtenerAcronimo(cadena);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testObtenerAcronimoSinSeparacion() {
        System.out.println("obtenerAcronimo");
        String cadena = "HolaQueTal";
        Acronimos instance = new Acronimos();
        String expResult = "H.";
        String result = instance.obtenerAcronimo(cadena);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testObtenerAcronimoConMultipleSeparacion() {
        System.out.println("obtenerAcronimo");
        String cadena = "Hola  Que   Tal";
        Acronimos instance = new Acronimos();
        String expResult = "H.Q.T.";
        String result = instance.obtenerAcronimo(cadena);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testObtenerAcronimoConSeparacionInicial() {
        System.out.println("obtenerAcronimo");
        String cadena = "  Hola  Que   Tal";
        Acronimos instance = new Acronimos();
        String expResult = "H.Q.T.";
        String result = instance.obtenerAcronimo(cadena);
        assertEquals(expResult, result);
    }
    
}
