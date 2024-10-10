/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static datos.Conexion.getConnection;
import domain.DetallePedido;
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
public class DetallePedidoDAO {

    private static final String SQL_SELECT = "SELECT * FROM detalle_pedido";
    private static final String SQL_SELECTONE = "SELECT * FROM detalle_pedido WHERE id_pedido = ?";
    private static final String SQL_INSERT = "INSERT INTO detalle_pedido (id_articulo, cantidad) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE detalle_pedido SET id_articulo = ?, cantidad = ? WHERE id_pedido = ?";
    private static final String SQL_DELETE = "DELETE FROM detalle_pedido WHERE id_pedido = ?";

    public List<DetallePedido> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DetallePedido detalle = null;
        List<DetallePedido> detalles = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPedido = rs.getInt(detalle.getIdPedido());
                int idArticulo = rs.getInt(detalle.getIdArticulo());
                int cantidad = rs.getInt(detalle.getCantidad());
                detalle = new DetallePedido(idPedido, idArticulo, cantidad);
                detalles.add(detalle);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return detalles;
    }
    public List<DetallePedido> seleccionarOne(DetallePedido detalleId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DetallePedido detalle = null;
        List<DetallePedido> detalles = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECTONE);
            stmt.setInt(1, detalleId.getIdPedido());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPedido = rs.getInt(detalle.getIdPedido());
                int idArticulo = rs.getInt(detalle.getIdArticulo());
                int cantidad = rs.getInt(detalle.getCantidad());
                detalle = new DetallePedido(idPedido, idArticulo, cantidad);
                detalles.add(detalle);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return detalles;
    }

    public int insertar(DetallePedido detalle) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, detalle.getIdArticulo());
            stmt.setInt(2, detalle.getCantidad());
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

    public int update(DetallePedido detalleId, DetallePedido detalle) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, detalle.getIdArticulo());
            stmt.setInt(2, detalle.getCantidad());
            stmt.setInt(3, detalleId.getIdPedido());
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

    public int delete(DetallePedido detalleId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, detalleId.getIdPedido());
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
