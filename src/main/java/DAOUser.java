import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAOUser {

    public DAOUser() {
    }

    /**
     * Inserta en la base de datos los datos del usuario
     *
     * @param u Usuario cuyos datos quieren añadirse
     */
    public void insert(User u) {

        Connection connect = null;

        try {

            connect = DbConnection.getInstance();

            PreparedStatement psUser = connect.prepareStatement("INSERT INTO Usuario(nomUsuario, conUsuario) VALUES(?,?)");
            psUser.setString(1, u.getName());
            psUser.setString(2, u.getPassword());
            psUser.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.desconectar();
        }

    }

}
