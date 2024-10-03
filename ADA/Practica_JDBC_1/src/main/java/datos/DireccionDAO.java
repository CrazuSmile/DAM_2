/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static datos.Conexion.getConnection;
import domain.Direccion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juasanlop2
 */
public class DireccionDAO {

    private static final String SQL_SELECT = "SELECT id_direccion, id_cliente, numero, calle, comuna, ciudad FROM direcciones_envio";
    private static final String SQL_INSERT = "INSERT INTO direcciones_envio (numero, calle, comuna, ciudad) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE direcciones_envio SET numero = ?, calle = ?, comuna = ?, ciudad = ? WHERE id_direcciones = ?";
    private static final String SQL_DELETE = "DELETE FROM direcciones WHERE id_direcciones = ?";

    public List<Direccion> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Direccion direccion = null;
        List<Direccion> direcciones = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idDireccion = rs.getInt("id_direccion");
                int idCliente = rs.getInt("id_cliente");
                int numero = rs.getInt("numero");
                String calle = rs.getString("calle");
                String comuna = rs.getString("comuna");
                String ciudad = rs.getString("ciudad");
                direccion = new Direccion(idDireccion, idCliente, numero, calle, comuna, ciudad);
                direcciones.add(direccion);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return direcciones;
    }

    public int insertar(Direccion direccion) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, direccion.getNumero());
            stmt.setString(2, direccion.getCalle());
            stmt.setString(3, direccion.getComuna());
            stmt.setString(4, direccion.getCiudad());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int update(Direccion direccionId, Direccion direccion) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, direccion.getNumero());
            stmt.setString(2, direccion.getCalle());
            stmt.setString(3, direccion.getComuna());
            stmt.setString(4, direccion.getCiudad());
            stmt.setInt(5, direccionId.getIdDircciones());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int delete(Direccion direccionId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, direccionId.getIdDircciones());
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(stmt);
                Conexion.close(conn);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
