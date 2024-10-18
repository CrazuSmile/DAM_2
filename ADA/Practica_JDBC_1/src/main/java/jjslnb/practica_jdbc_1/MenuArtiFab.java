package jjslnb.practica_jdbc_1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import datos.ArticuloFabricaDAO;
import domain.ArticuloFabrica;

public class MenuArtiFab {

    private static final ArticuloFabricaDAO articuloFabricaDAO = new ArticuloFabricaDAO();
    private static final Scanner TCL = new Scanner(System.in);

    public static void menuArtiFab() {
        int eleccion;

        do {
            System.out.println("-------------------------------------------");
            System.out.println(
                    "¿Que quiere hacer? \n\t1. Ver detalles de articulos. \n\t2. Buscar un detalle de un articulo. \n\t3. Insertar un nuevo detalle de un articulo. \n\t4. Actualizar un detalle de un articulo. \n\t5. Borrar un detalle de articulo. \n(Pulse 0 para volver atras)");
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
            List<ArticuloFabrica> articulos = articuloFabricaDAO.seleccionar();

            for (ArticuloFabrica articulo : articulos) {
                System.out.println(articulo);
            }
        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
    }

    private static List<ArticuloFabrica> buscar() {
        System.out.print("Id del articulo que buscar: ");
        int idArticulo = TCL.nextInt();

        ArticuloFabrica articuloFabrica = new ArticuloFabrica(idArticulo);
        try {
            return articuloFabricaDAO.seleccionarOne(articuloFabrica);

        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
        return null;
    }

    public static void insertar() {
        System.out.println("ID del articulo: ");
        int idArticulo = TCL.nextInt();
        System.out.print("ID de la fábrica: ");
        int idFabrica = TCL.nextInt();
        System.out.print("Existencias: ");
        int existencias = TCL.nextInt();
        System.out.print("Precio: ");
        float precio = TCL.nextFloat();
        TCL.nextLine(); 

        ArticuloFabrica articulo = new ArticuloFabrica(idArticulo, idFabrica, existencias, precio);

        articuloFabricaDAO.insertar(articulo);
    }

    private static void actualizar() {
        System.out.print("ID del artículo que desea actualizar: ");
        int idArticulo = TCL.nextInt();
        System.out.print("Nuevo ID de la fábrica: ");
        int idFabrica = TCL.nextInt();
        System.out.print("Nuevas existencias: ");
        int existencias = TCL.nextInt();
        System.out.print("Nuevo precio: ");
        float precio = TCL.nextFloat();
        TCL.nextLine();

        ArticuloFabrica articuloActualizado = new ArticuloFabrica(idArticulo, idFabrica, existencias, precio);
        int registrosActualizados = articuloFabricaDAO.update(new ArticuloFabrica(idArticulo), articuloActualizado);
        System.out.println("Se actualizaron " + registrosActualizados + " registros.");

    }

    private static void borrar() {
        System.out.print("ID del artículo que desea borrar: ");
        int idArticulo = TCL.nextInt();

        ArticuloFabrica articuloFabrica = new ArticuloFabrica(idArticulo);

        int registrosBorrados = articuloFabricaDAO.delete(articuloFabrica);
        System.out.println("Se borraron " + registrosBorrados + " registros.");

    }
}

