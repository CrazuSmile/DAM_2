package ejercicio2;

import java.io.File;
import java.util.Scanner;

public class Main {
    private static Scanner TLC = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Introduce la ruta inicial del explorador de archivos:");
        String directorio = TLC.nextLine();

        System.out.println("Has seleccionado la ruta: " + directorio);
        int opcion = 0;

        do {
            System.out.println("------------------------------------------------");
            System.out.println("\t  \tMENU");
            System.out.println("------------------------------------------------");

            System.out.println(
                    "1. Mostrar ficheros del direcorio actual. \n2. Modificar el directorio actual (añade al path actual el directorio introducido)."
                            + //
                            "\n3. Volver atrás\n"
                            + //
                            "4. Salir del programa");

            System.out.println();
            System.out.println("¿ Qué opción quieres realizar ?");
            opcion = TLC.nextInt();

            switch (opcion) {
                case 1:
                    mostrarFicheros(directorio);
                    break;
                case 2:
                    directorio = cambiarDirectorio(directorio).getAbsolutePath();
                    break;
                case 3:
                    directorio = retroceder(directorio).getAbsolutePath();
                    break;
                case 4:
                    System.out.println("--- FIN DEL PROGRAMA ---");
                    break;
                default:
                    System.out.println("No existe esa opcion.");
                    break;
            }

        } while (opcion != 4);

    }

    private static void mostrarFicheros(String directorio) {
        File dir = new File(directorio);
        File[] files = dir.listFiles();

        System.out.println("------------------------------------------------");
        System.out.println("\t  \tFICHEROS");
        System.out.println("------------------------------------------------");

        for (File file : files) {
            System.out.println(file.getName());
        }

    }

    private static File cambiarDirectorio(String directorio) {
        TLC.nextLine();
        System.out.println("¿ Qué directorio quieres añadir ?");
        String nuevoDierctorio = TLC.nextLine();

        File newDir = new File(directorio + "/" + nuevoDierctorio);
        System.out.println("La nueva ruta es: " + newDir.getAbsolutePath());

        return newDir;
    }

    private static File retroceder(String dir) {
        File actualDir = new File(dir);
        File oldDir = new File(actualDir.getParent());

        System.out.println("La nueva ruta es: " + oldDir.getAbsolutePath());

        return oldDir;
    }
}