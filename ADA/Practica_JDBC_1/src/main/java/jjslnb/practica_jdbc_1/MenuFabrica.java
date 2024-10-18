package jjslnb.practica_jdbc_1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import datos.FabricaDAO;
import domain.Fabrica;

public class MenuFabrica {

    private static final FabricaDAO FABRICA_DAO = new FabricaDAO();
    private static final Scanner TCL = new Scanner(System.in);

    public static void menuFabrica() {
        int eleccion;

        do {
            System.out.println("-------------------------------------------");
            System.out.println(
                    "¿Qué desea hacer?\n"
                    + "1. Ver fabricas.\n"
                    + "2. Buscar una fabrica.\n"
                    + "3. Insertar una nueva fabrica.\n"
                    + "4. Actualizar una fabrica.\n"
                    + "5. Borrar una fabrica.\n" 
                    + "6. Borrar las fabricas vacias. \n"
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
                case 6:
                    borrarVacias();
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
            List<Fabrica> fabricas = FABRICA_DAO.seleccionar();

            for (Fabrica fabrica : fabricas) {
                System.out.println(fabrica);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void buscar() {
        System.out.print("ID de la fabrica a buscar: ");
        int idFabrica = TCL.nextInt();

        Fabrica fabrica = new Fabrica(idFabrica);
        try {
            List<Fabrica> result = FABRICA_DAO.seleccionarOne(fabrica);
            System.out.println(result);
            System.out.println("Fabrica no encontrada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertar() {
        TCL.nextLine();

        System.out.print("Teléfono: ");
        String telefono = TCL.nextLine();

        System.out.print("Artículos provistos: ");
        int articulosProvistos = TCL.nextInt();

        Fabrica fabrica = new Fabrica(telefono, articulosProvistos);

        int registrosInsertados = FABRICA_DAO.insertar(fabrica);
        System.out.println("Se insertaron " + registrosInsertados + " registros.");

    }

    private static void actualizar() {
        System.out.print("ID de la fabrica a actualizar: ");
        int idFabrica = TCL.nextInt();
        TCL.nextLine();
        Fabrica fabricaId = new Fabrica(idFabrica);

        System.out.print("Teléfono: ");
        String telefono = TCL.nextLine();

        System.out.print("Artículos provistos: ");
        int articulosProvistos = TCL.nextInt();

        Fabrica fabrica = new Fabrica(telefono, articulosProvistos);

        int registrosActualizados = FABRICA_DAO.update(fabricaId, fabrica);
        System.out.println("Se actualizaron " + registrosActualizados + " registros.");

    }

    private static void borrar() {
        System.out.print("ID de la fabrica a borrar: ");
        int idFabrica = TCL.nextInt();

        Fabrica fabrica = new Fabrica(idFabrica);

        int registrosBorrados = FABRICA_DAO.delete(fabrica);
        System.out.println("Se borraron " + registrosBorrados + " registros.");

    }

    private static void borrarVacias(){
        try {
            int fabriquesEsborrades = FABRICA_DAO.esborrarFabriquesSenseComandes();
            System.out.println("Total de fàbriques esborrades: " + fabriquesEsborrades);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
