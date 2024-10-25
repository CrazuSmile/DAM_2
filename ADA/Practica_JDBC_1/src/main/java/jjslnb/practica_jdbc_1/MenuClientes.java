package jjslnb.practica_jdbc_1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import datos.ClienteDAO;
import datos.ClientesPedidosDAO;
import domain.Cliente;

public class MenuClientes {

    private static final ClienteDAO CLIENTE_DAO = new ClienteDAO();
    private static final ClientesPedidosDAO CLIENTE_PEDIDO_DAO = new ClientesPedidosDAO();
    private static final Scanner TCL = new Scanner(System.in);

    public static void menuClientes() {
        int eleccion;

        do {
            System.out.println("-------------------------------------------");
            System.out.println(
                    "¿Qué quiere hacer? \n\t1. Ver clientes. \n\t2. Buscar un cliente. \n\t3. Insertar un nuevo cliente. \n\t4. Actualizar un cliente. \n\t5. Borrar un cliente. \n\t6. Mostrar los pedidos del cliente. \n(Pulse 0 para volver atrás)");
            System.err.print("Elección: ");
            eleccion = TCL.nextInt();
            TCL.nextLine();

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
                case 6:
                    llistarComndes();
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
            List<Cliente> clientes = CLIENTE_DAO.seleccionar();

            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
    }

    private static void buscar() {
        System.out.print("Id del cliente que buscar: ");
        int idCliente = TCL.nextInt();

        Cliente cliente = new Cliente(idCliente);
        try {
            List<Cliente> resultado = CLIENTE_DAO.seleccionarOne(cliente);
            System.out.println(resultado);
        } catch (SQLException e) {
            e.getLocalizedMessage();
        }

    }

    public static void insertar() {
        System.err.print("Saldo del cliente: ");
        float saldo = TCL.nextFloat();
        System.err.print("Límite de crédito del cliente: ");
        float limiteCredito = TCL.nextFloat();
        System.err.print("Descuento del cliente: ");
        float descuento = TCL.nextFloat();

        Cliente cliente = new Cliente(saldo, limiteCredito, descuento);
        CLIENTE_DAO.insertar(cliente);
    }

    private static void actualizar() {
        System.out.print("ID del cliente que desea actualizar: ");
        int idCliente = TCL.nextInt();
        TCL.nextLine();

        Cliente clienteID = new Cliente(idCliente);
        System.out.print("Nuevo saldo del cliente: ");
        float nuevoSaldo = TCL.nextFloat();
        System.out.print("Nuevo límite de crédito del cliente: ");
        float nuevoLimiteCredito = TCL.nextFloat();
        System.out.print("Nuevo descuento del cliente: ");
        float nuevoDescuento = TCL.nextFloat();

        Cliente cliente = new Cliente(idCliente, nuevoSaldo, nuevoLimiteCredito, nuevoDescuento);
        int registrosActualizados = CLIENTE_DAO.update(clienteID, cliente);
        System.out.println("Se actualizaron " + registrosActualizados + " registros.");
    }

    private static void borrar() {
        System.out.print("ID del cliente que desea borrar: ");
        int idCliente = TCL.nextInt();

        Cliente cliente = new Cliente(idCliente);
        int registrosBorrados = CLIENTE_DAO.delete(cliente);
        System.out.println("Se borraron " + registrosBorrados + " registros.");
    }
    
    private static void llistarComndes(){
        System.out.print("Id del cliente que buscar: ");
        int idCliente = TCL.nextInt();
        try {
            System.err.println(CLIENTE_PEDIDO_DAO.llistarComandesClient(idCliente));

        } catch (SQLException e) {
            e.getLocalizedMessage();
        }
    }
}