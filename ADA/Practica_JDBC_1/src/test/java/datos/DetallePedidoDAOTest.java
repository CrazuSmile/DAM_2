/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package datos;

import domain.DetallePedido;
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
public class DetallePedidoDAOTest {
    
    public DetallePedidoDAOTest() {
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
     * Test of calcularQuantitatTotalArticlesAny method, of class DetallePedidoDAO.
     */
    @Test
    public void testCalcularQuantitatTotalArticlesAny() throws Exception {
        System.out.println("calcularQuantitatTotalArticlesAny");
        int any = 0;
        DetallePedidoDAO instance = new DetallePedidoDAO();
        int expResult = 0;
        int result = instance.calcularQuantitatTotalArticlesAny(any);
        assertEquals(expResult, result);

    }
    
}
