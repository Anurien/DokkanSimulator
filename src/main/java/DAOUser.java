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

            connect = DbConnection.getInstance().getConnection();

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

    /**
     * Actualiza los datos del usuario en la base de datos
     *
     * @param u Usuario del que se quiere actualizar los datos
     */
    public void update(User u) {

        Connection connect = null;

        try {

            connect = DbConnection.getInstance().getConnection();

            PreparedStatement platform = connect.prepareStatement("UPDATE Usuario SET nomUsuario=?,conUsuario=? WHERE idUsuario=?");
            platform.setString(1, u.getName());
            platform.setString(2, u.getPassword());
            platform.setString(3, u.getId());
            platform.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.desconectar();
        }
    }


}
