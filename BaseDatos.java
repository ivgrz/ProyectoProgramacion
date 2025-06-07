import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    /**
     * Clase para gestionar la conexión con la base de datos SQLite.
     */
    public class BaseDatos {
        // Ruta del archivo de base de datos
        private static final String URL = "jdbc:sqlite:catcafe.db";

        /**
         * Establece y devuelve una conexión con la base de datos SQLite.
         * @return Objeto Connection listo para usar en consultas.
         * @throws SQLException si ocurre un error al conectar.
         */
        public static Connection conectar() throws SQLException {
            return DriverManager.getConnection(URL);
        }
    }


