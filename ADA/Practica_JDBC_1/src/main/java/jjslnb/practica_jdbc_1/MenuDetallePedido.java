package jjslnb.practica_jdbc_1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import datos.DetallePedidoDAO;
import domain.DetallePedido;

public class MenuDetallePedido {

    private static final DetallePedidoDAO DETALLE_PEDIDO_DAO = new DetallePedidoDAO();
    private static final Scanner TCL = new Scanner(System.in);

    public static void menuDetallePedido() {
        int eleccion;

        do {
            System.out.println("-------------------------------------------");
            System.out.println(
                    "¿Qué desea hacer?\n"
                    + "1. Ver detalles de pedidos.\n"
                    + "2. Buscar un detalle de pedido.\n"
                    + "3. Insertar un nuevo detalle de pedido.\n"
                    + "4. Actualizar un detalle de pedido.\n"
                    + "5. Borrar un detalle de pedido.\n"
                    + "(Pulse 0 para volver atrás)"
            );
            System.out.print("Elección: ");
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
            List<DetallePedido> detalles = DETALLE_PEDIDO_DAO.seleccionar();

            for (DetallePedido detalle : detalles) {
                System.out.println(detalle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void buscar() {
        System.out.print("ID del pedido: ");
        int idPedido = TCL.nextInt();
        System.out.print("ID del artículo: ");
        int idArticulo = TCL.nextInt();

        DetallePedido detallePedido = new DetallePedido(idPedido, idArticulo);
        try {
            List<DetallePedido> result = DETALLE_PEDIDO_DAO.seleccionarOne(detallePedido);
            System.out.println(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertar() {
        System.out.print("ID del pedido: ");
        int idPedido = TCL.nextInt();
        System.out.print("ID del artículo: ");
        int idArticulo = TCL.nextInt();
        System.out.print("Cantidad: ");
        int cantidad = TCL.nextInt();

        DetallePedido detallePedido = new DetallePedido(idPedido, idArticulo, cantidad);

        int registrosInsertados = DETALLE_PEDIDO_DAO.insertar(detallePedido);
        System.out.println("Se insertaron " + registrosInsertados + " registros.");

    }

    private static void actualizar() {
        System.out.print("ID del pedido: ");
        int idPedido = TCL.nextInt();
        DetallePedido detallePedidoId = new DetallePedido(idPedido);
        System.out.print("ID del artículo: ");
        int idArticulo = TCL.nextInt();
        System.out.print("Nueva cantidad: ");
        int cantidad = TCL.nextInt();

        DetallePedido detallePedido = new DetallePedido(idArticulo, cantidad);

        int registrosActualizados = DETALLE_PEDIDO_DAO.update(detallePedidoId, detallePedido);
        System.out.println("Se actualizaron " + registrosActualizados + " registros.");
    }

    private static void borrar() {
        System.out.print("ID del pedido: ");
        int idPedido = TCL.nextInt();
        System.out.print("ID del artículo: ");
        int idArticulo = TCL.nextInt();

        DetallePedido detallePedido = new DetallePedido(idPedido, idArticulo);

        int registrosBorrados = DETALLE_PEDIDO_DAO.delete(detallePedido);
        System.out.println("Se borraron " + registrosBorrados + " registros.");

    }
}
