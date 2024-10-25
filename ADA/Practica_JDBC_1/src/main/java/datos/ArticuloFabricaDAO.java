package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static datos.Conexion.getConnection;
import domain.ArticuloFabrica;

public class ArticuloFabricaDAO {
    private static final String SQL_SELECT = "SELECT * FROM articulo_fabrica";
    private static final String SQL_SELECTONE = "SELECT * FROM articulo_fabrica WHERE id_articulo = ?";
    private static final String SQL_INSERT = "INSERT INTO articulo_fabrica (id_articulo, id_fabrica, existencias, precio) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE articulo_fabrica SET id_fabrica = ?, existencias = ?, precio = ? WHERE id_articulo = ?";
    private static final String SQL_DELETE = "DELETE FROM articulo_fabrica WHERE id_articulo = ?";

    public List<ArticuloFabrica> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArticuloFabrica articulo = null;
        List<ArticuloFabrica> articulos = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idArticulo = rs.getInt("id_articulo"); 
                int idFabrica = rs.getInt("id_fabrica");
                int existencias = rs.getInt("existencias");
                float precio = rs.getFloat("precio");
                articulo = new ArticuloFabrica(idArticulo, idFabrica, existencias, precio);
                articulos.add(articulo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return articulos;
    }

    public List<ArticuloFabrica> seleccionarOne(ArticuloFabrica articuloId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArticuloFabrica articulo = null;
        List<ArticuloFabrica> articulos = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECTONE);
            stmt.setInt(1, articuloId.getIdArticulo());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idArticulo = rs.getInt("id_articulo");
                int idFabrica = rs.getInt("id_fabrica");
                int existencias = rs.getInt("existencias");
                float precio = rs.getFloat("precio");
                articulo = new ArticuloFabrica(idArticulo, idFabrica, existencias, precio);
                articulos.add(articulo);

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return articulos;
    }

    public int insertar(ArticuloFabrica articulo) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, articulo.getIdArticulo());
            stmt.setInt(2, articulo.getIdFabrica());
            stmt.setInt(3, articulo.getExistencias());
            stmt.setFloat(4, articulo.getPrecio());
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

    public int update(ArticuloFabrica articuloId, ArticuloFabrica articulo) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, articulo.getIdFabrica());
            stmt.setInt(2, articulo.getExistencias());
            stmt.setFloat(3, articulo.getPrecio());
            stmt.setInt(4, articuloId.getIdArticulo());
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

    public int delete(ArticuloFabrica articuloId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, articuloId.getIdArticulo());
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
