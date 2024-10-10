/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static datos.Conexion.getConnection;
import domain.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juasanlop2
 */
public class PedidoDAO {

    private static final String SQL_SELECT = "SELECT id_pedido, id_cliente, fecha_pedido, numero, Calle, Comuna, Ciudad FROM pedido";
    private static final String SQL_SELECTONE = "SELECT * FROM pedido WHERE id_pedido = ?";
    private static final String SQL_INSERT = "INSERT INTO pedido (id_cliente, fecha_pedido, numero, Calle, Comuna, Ciudad) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE pedido SET id_cliente = ?, fecha_pedido = ?, numero = ?, Calle = ?, Comuna = ?, Ciudad = ? WHERE id_pedido = ?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente = ?";

    public List<Pedido> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPedido = rs.getInt("id_pedido");
                int idCliente = rs.getInt("idCliente");
                Date fechaPedido = rs.getDate("fecha_pedido");
                int numero = rs.getInt("numero");
                String calle = rs.getString("Calle");
                String comuna = rs.getString("Comuna");
                String ciudad = rs.getString("Ciudad");
                pedido = new Pedido(idPedido, idCliente, fechaPedido, numero, calle, comuna, ciudad);
                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return pedidos;
    }
    
    public List<Pedido> seleccionarOne(Pedido pedidoId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECTONE);
            stmt.setInt(1, pedidoId.getIdPedido());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPedido = rs.getInt("id_pedido");
                int idCliente = rs.getInt("idCliente");
                Date fechaPedido = rs.getDate("fecha_pedido");
                int numero = rs.getInt("numero");
                String calle = rs.getString("Calle");
                String comuna = rs.getString("Comuna");
                String ciudad = rs.getString("Ciudad");
                pedido = new Pedido(idPedido, idCliente, fechaPedido, numero, calle, comuna, ciudad);
                pedidos.add(pedido);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return pedidos;
    }

    public int insertar(Pedido pedido) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, pedido.getIdCliente());
            stmt.setDate(2, pedido.getFecha());
            stmt.setInt(3, pedido.getNumero());
            stmt.setString(4, pedido.getCalle());
            stmt.setString(5, pedido.getComuna());
            stmt.setString(6, pedido.getCiudad());
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

    public int update(Pedido pedidoId, Pedido pedido) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, pedido.getIdCliente());
            stmt.setDate(2, pedido.getFecha());
            stmt.setInt(3, pedido.getNumero());
            stmt.setString(4, pedido.getCalle());
            stmt.setString(5, pedido.getComuna());
            stmt.setString(6, pedido.getCiudad());
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

    public int delete(Pedido pedidoId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pedidoId.getIdPedido());
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
