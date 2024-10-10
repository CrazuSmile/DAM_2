package datos;

import static datos.Conexion.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Fabrica;

public class FabricaDAO {
private static final String SQL_SELECT = "SELECT * FROM fabrica";
    private static final String SQL_SELECTONE = "SELECT * FROM fabrica WHERE id_fabrica = ?";
    private static final String SQL_INSERT = "INSERT INTO fabrica (telefono, articulos_provistos) VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE fabrica SET telefono = ?, articulos_provistos = ? WHERE id_articulo = ?";
    private static final String SQL_DELETE = "DELETE FROM fabrica WHERE id_fabrica = ?";

    public List<Fabrica> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Fabrica fabrica = null;
        List<Fabrica> fabricas = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idFabrica = rs.getInt(fabrica.getIdFabrica());
                String telefono = rs.getString(fabrica.getTelefono());
                int articulosProvistos = rs.getInt(fabrica.getArticulosProvistos());
                fabrica = new Fabrica(idFabrica, telefono, articulosProvistos);
                fabricas.add(fabrica);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return fabricas;
    }

    public List<Fabrica> seleccionarOne(Fabrica fabricaId) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Fabrica fabrica = null;
        List<Fabrica> fabricas = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECTONE);
            stmt.setInt(1, fabricaId.getIdFabrica());
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idFabrica = rs.getInt(fabrica.getIdFabrica());
                String telefono = rs.getString(fabrica.getTelefono());
                int articulosProvistos = rs.getInt(fabrica.getArticulosProvistos());
                fabrica = new Fabrica(idFabrica, telefono, articulosProvistos);
                fabricas.add(fabrica);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(rs);
            Conexion.close(stmt);
        }

        return fabricas;
    }

    public int insertar(Fabrica fabrica) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, fabrica.getTelefono());
            stmt.setInt(2, fabrica.getArticulosProvistos());
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

    public int update(Fabrica fabricaId, Fabrica fabrica) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, fabrica.getTelefono());
            stmt.setInt(2, fabrica.getArticulosProvistos());
            stmt.setInt(3, fabricaId.getIdFabrica());
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

    public int delete(Fabrica fabricaId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, fabricaId.getIdFabrica());
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
