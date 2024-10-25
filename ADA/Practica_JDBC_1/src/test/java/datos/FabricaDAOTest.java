/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package datos;

import domain.Fabrica;
import java.util.List;
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
public class FabricaDAOTest {
    
    public FabricaDAOTest() {
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
     * Test of esborrarFabriquesSenseComandes method, of class FabricaDAO.
     */
    @Test
    public void testEsborrarFabriquesSenseComandes() throws Exception {
        System.out.println("esborrarFabriquesSenseComandes");
        FabricaDAO instance = new FabricaDAO();
        int expResult = 0;
        int result = instance.esborrarFabriquesSenseComandes();
        assertEquals(expResult, result);
    }
    
}
