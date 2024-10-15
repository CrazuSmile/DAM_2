/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package jjslnb.practica_jdbc_1;

import java.util.Scanner;

/**
 *
 * @author juasanlop2
 */
public class Menu extends MenuArticulos {
    private static final Scanner TCL = new Scanner(System.in);

    public static void main(String[] args) {
        int eleccion;
        do {
            System.out.println("-------------------------------------------");
            System.out.println(
                    "Bienvenido, ¿en que tabla deseas entrar? \n\t1. Articulos. \n\t2. Articulos-Fabricas. \n\t3. Clientes. \n\t4. Detalles del Pedido. \n\t5. Direcciones. \n\t6. Fabricas. \n\t7. Pedidos \n(Pulse 0 para salir)");
            System.out.print("Eleccion: ");
            eleccion = TCL.nextInt();

            switch (eleccion) {
                case 1:
                    menuArticulos();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 0:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("No es una opcion valida.");
                    break;
            }
        } while (eleccion != 0);

    }
}
