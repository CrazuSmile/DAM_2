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
public class Menu {

    private static final Scanner TCL = new Scanner(System.in);
    private static final MenuArticulos MENU_ARTICULOS = new MenuArticulos();
    private static final MenuArtiFab MENU_ARTI_FAB = new MenuArtiFab();
    private static final MenuClientes MENU_CLIENTES = new MenuClientes();
    private static final MenuPedido MENU_PEDIDO = new MenuPedido();
    private static final MenuDirecciones MENU_DIRECCIONES = new MenuDirecciones();
    private static final MenuFabrica MENU_FABRICA = new MenuFabrica();
    private static final MenuDetallePedido MENU_DETALLE_PEDIDO = new MenuDetallePedido();

    public static void main(String[] args) {
        int eleccion;
        do {
            System.out.println("-------------------------------------------");
            System.out.println(
                    "Bienvenido, ¿en que tabla deseas entrar? \n\t1. Articulos. \n\t2. Articulos-Fabricas. \n\t3. Clientes. \n\t4. Pedidos.  \n\t5. Direcciones. \n\t6. Fabricas. \n\t7. Detalles del Pedido. \n(Pulse 0 para salir)");
            System.out.print("Eleccion: ");
            eleccion = TCL.nextInt();

            switch (eleccion) {
                case 1:
                    MENU_ARTICULOS.menuArticulos();
                    break;
                case 2:
                    MENU_ARTI_FAB.menuArtiFab();
                    break;
                case 3:
                    MENU_CLIENTES.menuClientes();
                    break;
                case 4:
                    MENU_PEDIDO.menuPedido();
                    break;
                case 5:
                    MENU_DIRECCIONES.menuDireccion();
                    break;
                case 6:
                    MENU_FABRICA.menuFabrica();
                    break;
                case 7:
                    MENU_DETALLE_PEDIDO.menuDetallePedido();
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
