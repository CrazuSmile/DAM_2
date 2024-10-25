/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jjslnb.pruebasconjunit;

/**
 *
 * @author juasanlop2
 */
public class NewMain {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Coche p = new Coche("Audi", 1000);
        Coche.impuesto = 20f;
        System.out.println("El precio final del coche es: " + p.precioFinal(10f));
    }
    
}
