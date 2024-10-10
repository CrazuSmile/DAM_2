/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import static datos.Conexion.getConnection;
import domain.Articulo;
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
public class ArticuloDAO {

    private static final String SQL_SELECT = "SELECT * FROM articulo";
    private static final String SQL_SELECTONE = "SELECT * FROM articulo WHERE id_articulo = ?";
    private static final String SQL_INSERT = "INSERT INTO articulo (descripcion) VALUES (?)";
    private static final String SQL_UPDATE = "UPDATE articulo SET cantidad = ? WHERE id_articulo = ?";
    private static final String SQL_DELETE = "DELETE FROM articulo WHERE id_artciulo = ?";

    public List<Articulo> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Articulo articulo = null;
        List<Articulo> articulos = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idArticulo = rs.getInt(articulo.getIdArticulo());
                String descripcion = rs.getString(articulo.getDescripcion());
                articulo = new Articulo(idArticulo, descripcion);
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

    public List<Articulo> seleccionarOne(Articulo articuloId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Articulo articulo = null;
        List<Articulo> articulos = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECTONE);
            stmt.setInt(1, articuloId.getIdArticulo());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idArticulo = rs.getInt(articulo.getIdArticulo());
                String descripcion = rs.getString(articulo.getDescripcion());
                articulo = new Articulo(idArticulo, descripcion);
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

    public int insertar(Articulo articulo) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, articulo.getDescripcion());
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

    public int update(Articulo articuloId, Articulo articulo) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, articulo.getDescripcion());
            stmt.setInt(2, articulo.getIdArticulo());
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

    public int delete(Articulo articuloId) {
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
