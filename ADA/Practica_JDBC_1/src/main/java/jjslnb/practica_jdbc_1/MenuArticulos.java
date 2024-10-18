package jjslnb.practica_jdbc_1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import datos.ArticuloDAO;
import domain.Articulo;

public class MenuArticulos {

    private static final ArticuloDAO articuloDao = new ArticuloDAO();
    private static final Scanner TCL = new Scanner(System.in);

    public static void menuArticulos() {
        int eleccion;

        do {
            System.out.println("-------------------------------------------");
            System.out.println(
                    "¿Que quiere hacer? \n\t1. Ver articulos. \n\t2. Buscar un articulo. \n\t3. Insertar un nuevo articulo. \n\t4. Actualizar un articulo. \n\t5. Borrar un articulo. \n(Pulse 0 para volver atras)");
            System.err.print("Eleccion: ");
            eleccion = TCL.nextInt();
            TCL.nextLine();

            switch (eleccion) {
                case 1:
                    seleccionar();
                    break;
                case 2:
                    System.err.println(buscar());
                    break;
                case 3:
                    insertar();
                    break;
                case 4:
                    actualizar();
                    break;
                case 5:
                    borrar();
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

    private static List<Articulo> buscar() {
        System.out.print("Id del articulo que buscar: ");
        int idArticulo = TCL.nextInt();

        Articulo articulo = new Articulo(idArticulo);
        try {
            return articuloDao.seleccionarOne(articulo);

        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
        return null;
    }

    public static void insertar() {
        System.err.print("Descripcion del articulo: ");
        String descripcion = TCL.nextLine();
        TCL.nextLine();

        Articulo articulo = new Articulo(descripcion);

        articuloDao.insertar(articulo);
    }

    private static void actualizar() {
        System.out.print("ID del artículo que desea actualizar: ");
        int idArticulo = TCL.nextInt();
        TCL.nextLine();

        System.out.print("Nueva descripción del artículo: ");
        String nuevaDescripcion = TCL.nextLine();

        Articulo articulo = new Articulo(idArticulo, nuevaDescripcion);

        int registrosActualizados = articuloDao.update(articulo, articulo);
        System.out.println("Se actualizaron " + registrosActualizados + " registros.");

    }

    private static void borrar() {
        System.out.print("ID del artículo que desea borrar: ");
        int idArticulo = TCL.nextInt();

        Articulo articulo = new Articulo(idArticulo);

        int registrosBorrados = articuloDao.delete(articulo);
        System.out.println("Se borraron " + registrosBorrados + " registros.");

    }
}
