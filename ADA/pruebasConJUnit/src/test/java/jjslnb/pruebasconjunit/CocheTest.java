/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package jjslnb.pruebasconjunit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.function.Executable;

/**
 *
 * @author juasanlop2
 */
public class CocheTest {

    public CocheTest() {
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
     * Test of precioFinal method, of class Coche.
     */
    @Test
    public void testPrecioFinal() throws Exception {
        System.out.println("precioFinal para coche barato");
        float descuento = 10.0F;
        Coche instance = new Coche("Audi", 1000);
        Coche.impuesto = 20f;
        float expResult = 1200.0F;
        float result = instance.precioFinal(descuento);
        assertEquals(expResult, result, 0.00001);

    }

    @Test
    public void testPrecioFinal2() throws Exception {
        System.out.println("precioFinal para coche caro");
        float descuento = 10.0F;
        Coche instance = new Coche("Audi", 10000);
        Coche.impuesto = 20f;
        float expResult = 10800.0F;
        float result = instance.precioFinal(descuento);
        assertEquals(expResult, result, 0.00001);

    }

    @Test
    public void TestPrecioFinal3() throws Exception {

        System.out.println("precioFinal coche con descuento erróneo");

        float descuento = 110.0F;

        Coche instance = new Coche("Audi A3", 1000);

        Coche.impuesto = 20f;

        assertThrows(Exception.class, new Executable() {

            @Override

            public void execute() throws Throwable {

                float result = instance.precioFinal(descuento);

            }
        });

    }
}
