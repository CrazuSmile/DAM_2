/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.*;
import java.sql.*;

/**
 *
 * @author juasanlop2
 */
public class TestManejoPersonas {

    private static PersonaDAO personaDao = new PersonaDAO();
    private static final Scanner TCL = new Scanner(System.in);

    public static void main(String[] args) {
        int eleccion;

        do {
            System.out.println("Bienvenid@, ¿que quieres hacer? \n\t1. Listar personas. \n\t2. Insertar persona. \n\t3. Actualizar una persona. \n\t4. Elminiar persona \n\t5. Salir. \nEleccion del usuario.");
            eleccion = TCL.nextInt();
            switch (eleccion) {
                case 1:
                    seleccionar();
                    break;
                case 2:
                    insertar();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("No existe esa opcion.");
            }
            System.out.println();
        } while (eleccion != 5);

    }

    private static void seleccionar() {
        try {
            List<Persona> personas = personaDao.seleccionar();

            for (Persona persona : personas) {
                System.out.println(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private static void insertar() {
        TCL.nextLine();
        System.out.print("Escriba el nombre: ");
        String nombre = TCL.nextLine();

        System.out.println();
        System.out.print("Los apellido: ");
        String apellido = TCL.nextLine();

        System.out.println();

        System.out.print("Y la edad: ");
        int edad = TCL.nextInt();

        Persona personaNueva = new Persona(nombre, apellido, edad);

        personaDao.insertar(personaNueva);

    }

    private static void update() {
        System.out.print("¿Que persona quiere actualizar? (ID de la persona): ");
        int id = TCL.nextInt();

        Persona personaId = new Persona(id);

        TCL.nextLine();
        System.out.print("Escriba el nombre: ");
        String nombre = TCL.nextLine();

        System.out.println();
        System.out.print("Los apellido: ");
        String apellido = TCL.nextLine();

        System.out.println();

        System.out.print("Y la edad: ");
        int edad = TCL.nextInt();

        Persona personaNueva = new Persona(nombre, apellido, edad);

        personaDao.update(personaId, personaNueva);
    }

    private static void delete() {
        System.out.print("¿Que persona quieres eliminar? (ID de la persona): ");
        int id = TCL.nextInt();

        Persona personaId = new Persona(id);

        personaDao.delete(personaId);
    }

}
