package jjslnb.practica_jdbc_1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import datos.DireccionDAO;
import domain.Direccion;

public class MenuDirecciones {

    private static final DireccionDAO DIRECCION_DAO = new DireccionDAO();
    private static final Scanner TCL = new Scanner(System.in);

    public static void menuDireccion() {
        int eleccion;

        do {
            System.out.println("-------------------------------------------");
            System.out.println(
                    "¿Qué desea hacer?\n"
                    + "1. Ver direcciones.\n"
                    + "2. Buscar una dirección.\n"
                    + "3. Insertar una nueva dirección.\n"
                    + "4. Actualizar una dirección.\n"
                    + "5. Borrar una dirección.\n"
                    + "(Pulse 0 para volver atrás)"
            );
            System.err.print("Elección: ");
            eleccion = TCL.nextInt();

            switch (eleccion) {
                case 1:
                    seleccionar();
                    break;
                case 2:
                    buscar();
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
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (eleccion != 0);
    }

    private static void seleccionar() {
        try {
            List<Direccion> direcciones = DIRECCION_DAO.seleccionar();

            for (Direccion direccion : direcciones) {
                System.out.println(direccion);
            }
        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
    }

    private static void buscar() {
        System.out.print("ID de la dirección a buscar: ");
        int idDireccion = TCL.nextInt();

        Direccion direccion = new Direccion(idDireccion);
        try {
            List<Direccion> result = DIRECCION_DAO.seleccionarOne(direccion);
            System.out.println(result);
            System.out.println("Dirección no encontrada.");

        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
    }

    public static void insertar() {
        System.out.print("ID del cliente: ");
        int idCliente = TCL.nextInt();

        System.out.print("Número: ");
        int numero = TCL.nextInt();
        TCL.nextLine();

        System.out.print("Calle: ");
        String calle = TCL.nextLine();

        System.out.print("Comuna: ");
        String comuna = TCL.nextLine();

        System.out.print("Ciudad: ");
        String ciudad = TCL.nextLine();

        Direccion direccion = new Direccion(idCliente, numero, calle, comuna, ciudad);

        int registrosInsertados = DIRECCION_DAO.insertar(direccion);
        System.out.println("Se insertaron " + registrosInsertados + " registros.");

    }

    private static void actualizar() {
        System.out.print("ID de la dirección a actualizar: ");
        int idDireccion = TCL.nextInt();
        TCL.nextLine();
        Direccion direccionId = new Direccion(idDireccion);

        System.out.print("ID del cliente: ");
        int idCliente = TCL.nextInt();

        System.out.print("Número: ");
        int numero = TCL.nextInt();
        TCL.nextLine();

        System.out.print("Calle: ");
        String calle = TCL.nextLine();

        System.out.print("Comuna: ");
        String comuna = TCL.nextLine();

        System.out.print("Ciudad: ");
        String ciudad = TCL.nextLine();

        Direccion direccion = new Direccion(idCliente, numero, calle, comuna, ciudad);

        int registrosActualizados = DIRECCION_DAO.update(direccionId, direccion);
        System.out.println("Se actualizaron " + registrosActualizados + " registros.");

    }

    private static void borrar() {
        System.out.print("ID de la dirección a borrar: ");
        int idDireccion = TCL.nextInt();

        Direccion direccion = new Direccion(idDireccion);

        int registrosBorrados = DIRECCION_DAO.delete(direccion);
        System.out.println("Se borraron " + registrosBorrados + " registros.");

    }
}
