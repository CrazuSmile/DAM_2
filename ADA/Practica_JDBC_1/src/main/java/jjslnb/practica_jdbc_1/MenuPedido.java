package jjslnb.practica_jdbc_1;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import datos.PedidoDAO;
import domain.Pedido;

public class MenuPedido {

    private static final PedidoDAO PEDIDO_DAO = new PedidoDAO();
    private static final Scanner TCL = new Scanner(System.in);

    public static void menuPedido() {
        int eleccion;

        do {
            System.out.println("-------------------------------------------");
            System.out.println(
                    "¿Qué desea hacer?\n"
                    + "1. Ver pedidos.\n"
                    + "2. Buscar un pedido.\n"
                    + "3. Insertar un nuevo pedido.\n"
                    + "4. Actualizar un pedido.\n"
                    + "5. Borrar un pedido.\n"
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
            List<Pedido> pedidos = PEDIDO_DAO.seleccionar();

            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
    }

    private static void buscar() {
        System.out.print("ID del pedido a buscar: ");
        int idPedido = TCL.nextInt();

        Pedido pedido = new Pedido(idPedido);
        try {
            List<Pedido> result = PEDIDO_DAO.seleccionarOne(pedido);
            System.out.println(result);

        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
    }

    public static void insertar() {
        System.out.print("ID del cliente: ");
        int idCliente = TCL.nextInt();

        System.out.print("Número de calle: ");
        int numero = TCL.nextInt();
        TCL.nextLine();

        System.out.print("Calle: ");
        String calle = TCL.nextLine();

        System.out.print("Comuna: ");
        String comuna = TCL.nextLine();

        System.out.print("Ciudad: ");
        String ciudad = TCL.nextLine();

        Timestamp fecha = new Timestamp(System.currentTimeMillis());

        Pedido pedido = new Pedido(idCliente, fecha, numero, calle, comuna, ciudad);

        int registrosInsertados = PEDIDO_DAO.insertar(pedido);
        System.out.println("Se insertaron " + registrosInsertados + " registros.");
    }

    private static void actualizar() {
        System.out.print("ID del pedido a actualizar: ");
        int idPedido = TCL.nextInt();
        TCL.nextLine();

        Pedido pedidoId = new Pedido(idPedido);

        System.out.print("ID del cliente: ");
        int idCliente = TCL.nextInt();

        System.out.print("Número de pedido: ");
        int numero = TCL.nextInt();
        TCL.nextLine();  // Limpiar el buffer

        System.out.print("Calle: ");
        String calle = TCL.nextLine();

        System.out.print("Comuna: ");
        String comuna = TCL.nextLine();

        System.out.print("Ciudad: ");
        String ciudad = TCL.nextLine();

        Timestamp fecha = new Timestamp(System.currentTimeMillis());

        Pedido pedido = new Pedido(idCliente, fecha, numero, calle, comuna, ciudad);

        int registrosActualizados = PEDIDO_DAO.update(pedidoId, pedido);
        System.out.println("Se actualizaron " + registrosActualizados + " registros.");

    }

    private static void borrar() {
        System.out.print("ID del pedido a borrar: ");
        int idPedido = TCL.nextInt();

        Pedido pedido = new Pedido(idPedido);

        int registrosBorrados = PEDIDO_DAO.delete(pedido);
        System.out.println("Se borraron " + registrosBorrados + " registros.");

    }
}
