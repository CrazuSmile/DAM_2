/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package datos;

import domain.Cliente;
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
public class ClienteDAOTest {
    
    public ClienteDAOTest() {
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
     * Test of seleccionar method, of class ClienteDAO.
     */
    @Test
    public void testSeleccionar() throws Exception {
        System.out.println("seleccionar");
        ClienteDAO instance = new ClienteDAO();
        List<Cliente> expResult = instance.seleccionar();
        List<Cliente> result = instance.seleccionar();
        assertEquals(expResult, result);

    }

    /**
     * Test of insertar method, of class ClienteDAO.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Cliente cliente = new Cliente();
        ClienteDAO instance = new ClienteDAO();
        int expResult = 1;
        int result = instance.insertar(cliente);
        assertEquals(expResult, result);

    }

    /**
     * Test of update method, of class ClienteDAO.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Cliente clienteID = new Cliente();
        Cliente cliente = new Cliente();
        ClienteDAO instance = new ClienteDAO();
        int expResult = 0;
        int result = instance.update(clienteID, cliente);
        assertEquals(expResult, result);

    }

    /**
     * Test of delete method, of class ClienteDAO.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Cliente clienteID = new Cliente();
        ClienteDAO instance = new ClienteDAO();
        int expResult = 0;
        int result = instance.delete(clienteID);
        assertEquals(expResult, result);
    }
    
}
