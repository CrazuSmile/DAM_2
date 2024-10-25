/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author juasanlop2
 */
public class TestMySQLJDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        try {
            //puede que sea requerido

            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(url, "root", "serpis");

            Statement instruccion = conexion.createStatement();

            String sql = "SELECT Id_persona, Nombre, Apellidos, Edad FROM persona";

            ResultSet resultado = instruccion.executeQuery(sql);

            while (resultado.next()) {
                System.out.println("Id Persona: " + resultado.getInt("Id_persona"));

                System.out.println("Nombre: " + resultado.getString("Nombre"));

                System.out.println("Apellidos " + resultado.getString("Apellidos"));

                System.out.println("Edad: " + resultado.getInt("Edad"));

                System.out.println();
            }

            resultado.close();
            instruccion.close();
            conexion.close();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
