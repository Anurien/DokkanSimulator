package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    /**
     * Parametros de conexion
     */
    private static final String bd = "registro";
    private static final String login = "root";
    private static final String password = "oracle123";
    private static final String url = "jdbc:mysql://localhost/" + bd;

    private static Connection connection = null;
    private static DbConnection instance;

    /**
     * Constructor de DataBase.DbConnection
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
    public static DbConnection getInstance() {
        if (instance == null)
            instance = new DbConnection();
        return instance;
    }
    public Connection getConnection(){
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