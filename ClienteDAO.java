
    import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class ClienteDAO {


        public void insertar(Cliente cliente) {
            try (Connection conexion = BaseDatos.conectar()) {
                if (conexion == null) return;

                String sql = "INSERT INTO clientes(nombre, email) VALUES (?, ?)";
                try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                    ps.setString(1, cliente.getNombre());
                    ps.setString(2, cliente.getEmail());
                    ps.executeUpdate();
                    System.out.println("Cliente insertado.");
                }
            } catch (SQLException e) {
                System.out.println(" Error al insertar cliente: " + e.getMessage());
            }
        }

        public List<Cliente> listarTodos() {
            List<Cliente> lista = new ArrayList<>();
            try (Connection conexion = BaseDatos.conectar()) {
                if (conexion == null) return lista;

                String sql = "SELECT * FROM clientes";
                try (Statement stmt = conexion.createStatement();
                     ResultSet rs = stmt.executeQuery(sql)) {

                    while (rs.next()) {
                        Cliente c = new Cliente();
                        c.setId(rs.getInt("id"));
                        c.setNombre(rs.getString("nombre"));
                        c.setEmail(rs.getString("email"));
                        lista.add(c);
                    }
                }
            } catch (SQLException e) {
                System.out.println(" Error al listar clientes: " + e.getMessage());
            }
            return lista;
        }
    }


