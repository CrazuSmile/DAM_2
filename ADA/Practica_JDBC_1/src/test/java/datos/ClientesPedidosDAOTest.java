/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package datos;

import domain.Pedido;
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
public class ClientesPedidosDAOTest {
    
    public ClientesPedidosDAOTest() {
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
     * Test of llistarComandesClient method, of class ClientesPedidosDAO.
     */
    @Test
    public void testLlistarComandesClient() throws Exception {
        System.out.println("llistarComandesClient");
        int idCliente = 0;
        ClientesPedidosDAO instance = new ClientesPedidosDAO();
        List<Pedido> expResult = null;
        List<Pedido> result = instance.llistarComandesClient(idCliente);
        assertEquals(expResult, result);
    }
    
}
