
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GatoDAO {

    public void insertar(Gato gato) {
        Connection conexion = BaseDatos.conectar();
        if (conexion == null) {
            System.out.println("❌ No se pudo establecer conexión. Inserción cancelada.");
            return;
        }

        String sql = "INSERT INTO gatos(nombre, raza, edad, adoptado) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, gato.getNombre());
            ps.setString(2, gato.getRaza());
            ps.setInt(3, gato.getEdad());
            ps.setBoolean(4, gato.isAdoptado());
            ps.executeUpdate();
            System.out.println("✅ Gato insertado con éxito.");
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar el gato: " + e.getMessage());
        }
    }

    public List<Gato> listarTodos() {
        List<Gato> lista = new ArrayList<>();
        Connection conexion = BaseDatos.conectar();
        if (conexion == null) {
            System.out.println("❌ No se pudo establecer conexión. Listado cancelado.");
            return lista;
        }

        String sql = "SELECT * FROM gatos";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Gato g = new Gato();
                g.setId(rs.getInt("id"));
                g.setNombre(rs.getString("nombre"));
                g.setRaza(rs.getString("raza"));
                g.setEdad(rs.getInt("edad"));
                g.setAdoptado(rs.getBoolean("adoptado"));
                lista.add(g);
            }

        } catch (SQLException e) {
            System.out.println(" Error al listar gatos: " + e.getMessage());
        }

        return lista;
    }
}

