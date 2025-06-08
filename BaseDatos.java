
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {

    private static final String URL = "jdbc:postgresql://aws-0-eu-north-1.pooler.supabase.com:5432/postgres";
    private static final String USUARIO = "postgres.vegnfvaoqwgpwruvzmez";
    private static final String CONTRASENA = "Puertablanca14";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar con PostgreSQL: " + e.getMessage());
            return null;
        }
    }
}



