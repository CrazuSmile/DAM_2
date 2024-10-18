package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import domain.Pedido;

public class ClientesPedidosDAO {

    private static final String SQL_SELECT_PEDIDOS = 
        "SELECT p.id_pedido, p.fecha, p.numero, p.calle, p.comuna, p.ciudad, c.descuento " +
        "FROM pedidos p " +
        "JOIN clientes c ON p.id_cliente = c.id_cliente " +
        "WHERE c.id_cliente = ?";

    public List<Pedido> llistarComandesClient(int idCliente) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();
        float totalDescompte = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_PEDIDOS);
            stmt.setInt(1, idCliente);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idPedido = rs.getInt("id_pedido");
                Timestamp fecha = rs.getTimestamp("fecha");
                int numero = rs.getInt("numero");
                String calle = rs.getString("calle");
                String comuna = rs.getString("comuna");
                String ciudad = rs.getString("ciudad");
                float descompte = rs.getFloat("descuento");

                pedido = new Pedido(idPedido, idCliente, fecha, numero, calle, comuna, ciudad);
                pedidos.add(pedido);

                totalDescompte += descompte;
            }
            
            System.out.println("Comandes del client " + idCliente + ":");
            for (Pedido p : pedidos) {
                System.out.println(p);
            }
            System.out.println("Total d'import en descomptes: " + totalDescompte);

        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return pedidos;
    }
}
