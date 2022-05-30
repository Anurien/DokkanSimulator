import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    /**
     * Parametros de conexion
     */
    private static final String bd = "manual";
    private static final String login = "root";
    private static final String password = "Nuria21.";
    private static final String url = "jdbc:mysql://localhost/" + bd;

    static Connection connection = null;

    /**
     * Constructor de DbConnection
     */
    private DbConnection() {
        try {
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //obtenemos la conexión
            connection = DriverManager.getConnection(url, login, password);

            if (connection != null) {
                System.out.println("Conexión a base de datos " + bd + " OK\n");
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Permite retornar la conexión con Singleton
     */
    public static Connection getInstance() {
        if (connection == null) new DbConnection();
        return connection;
    }

    public static void desconectar() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}