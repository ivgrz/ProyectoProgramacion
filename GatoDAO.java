import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GatoDAO {

    public GatoDAO() {
        crearTablaSiNoExiste();
    }

    private void crearTablaSiNoExiste() {
        String sql = """
            CREATE TABLE IF NOT EXISTS gatos (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                raza TEXT,
                edad INTEGER,
                adoptado BOOLEAN
            )
            """;

        try (Connection conn = BaseDatos.conectar();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertar(Gato gato) {
        String sql = "INSERT INTO gatos(nombre, raza, edad, adoptado) VALUES (?, ?, ?, ?)";

        try (Connection conn = BaseDatos.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, gato.getNombre());
            ps.setString(2, gato.getRaza());
            ps.setInt(3, gato.getEdad());
            ps.setBoolean(4, gato.isAdoptado());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Gato> listarTodos() {
        List<Gato> gatos = new ArrayList<>();
        String sql = "SELECT * FROM gatos";

        try (Connection conn = BaseDatos.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Gato g = new Gato();
                g.setId(rs.getInt("id"));
                g.setNombre(rs.getString("nombre"));
                g.setRaza(rs.getString("raza"));
                g.setEdad(rs.getInt("edad"));
                g.setAdoptado(rs.getBoolean("adoptado"));
                gatos.add(g);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gatos;
    }
}
