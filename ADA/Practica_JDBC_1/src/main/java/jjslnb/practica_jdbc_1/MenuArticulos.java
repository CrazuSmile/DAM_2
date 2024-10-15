package jjslnb.practica_jdbc_1;

import java.util.Scanner;

import datos.ArticuloDAO;
import domain.Articulo;
import java.util.*;
import java.sql.*;

public class MenuArticulos {
    private static ArticuloDAO articuloDao = new ArticuloDAO();
    private static final Scanner TCL = new Scanner(System.in);

    public static void menuArticulos() {
        int eleccion;

        do {
            System.out.println("-------------------------------------------");
            System.out.println(
                    "¿Que quiere hacer? \n\t1. Ver articulos. \n\t2. Buscar un articulo. \n\t3. Insertar un nuevo articulo. \n\t4. Actualizar un articulo. \n\t5. Borrar un articulo. \n(Pulse 0 para volver atras)");
            System.err.print("Eleccion: ");
            eleccion = TCL.nextInt();

            switch (eleccion) {
                case 1:
                    seleccionar();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.out.println("<-");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (eleccion != 0);
    }

    private static void seleccionar() {
        try {
            List<Articulo> articulos = articuloDao.seleccionar();

            for (Articulo articulo : articulos) {
                System.out.println(articulo);
            }
        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
    }
}
