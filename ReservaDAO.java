
    import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class ReservaDAO {

        public void insertar(Reserva reserva) {
            try (Connection conexion = BaseDatos.conectar()) {
                if (conexion == null) return;

                String sql = "INSERT INTO reservas(cliente_id, gato_id, fecha, comentario) VALUES (?, ?, ?, ?)";
                try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                    ps.setInt(1, reserva.getClienteId());
                    ps.setInt(2, reserva.getGatoId());
                    ps.setDate(3, Date.valueOf(reserva.getFecha()));
                    ps.setString(4, reserva.getComentario());
                    ps.executeUpdate();
                    System.out.println(" Reserva insertada.");
                }
            } catch (SQLException e) {
                System.out.println(" Error al insertar reserva: " + e.getMessage());
            }
        }

        public List<Reserva> listarTodas() {
            List<Reserva> lista = new ArrayList<>();
            try (Connection conexion = BaseDatos.conectar()) {
                if (conexion == null) return lista;

                String sql = "SELECT * FROM reservas";
                try (Statement stmt = conexion.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)) {

                    while (rs.next()) {
                        Reserva r = new Reserva();
                        r.setId(rs.getInt("id"));
                        r.setClienteId(rs.getInt("cliente_id"));
                        r.setGatoId(rs.getInt("gato_id"));
                        r.setFecha(rs.getDate("fecha").toLocalDate());
                        r.setComentario(rs.getString("comentario"));
                        lista.add(r);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error al listar reservas: " + e.getMessage());
            }
            return lista;
        }
    }


