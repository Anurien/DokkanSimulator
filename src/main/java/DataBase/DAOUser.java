package DataBase;
/*
 Manejo de inicio de sesión de usuario
*/

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAOUser {


    /**
     * Metodo que recibe un usuario extrae su id y lo elimina de la base de datos
     * @param user Uruario que se quiere eliminar
     */
    public void delete(User user) {
        Connection conn = null;


        String sql = "delete from usuario where id=?";

        PreparedStatement ps = null;
        try {
            conn = new DbConnection().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getID());
            ps.executeUpdate();

            ps.close();
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    /**
     * Metodo que inserta el id, nombre y contraseña de un usuario en la base de datos
     * @param u usuario que se quiere introducir en la base de datos
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void addUser(User u) throws ClassNotFoundException, SQLException {
        String sql = "insert into usuario (id, nomUsuario, conUsuario) values (?,?,?)";
        Connection conn = null;
        try {
            conn = new DbConnection().getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getID());
            ps.setString(2, u.getName());
            ps.setString(3, u.getPassword());
            ps.executeUpdate();
            // ps.close();
            //conn.close();

        } catch (SQLException ex) {
            System.out.println("¡Error al agregar usuario!" + ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    /**
     * Metodo que devuelve un usuario de la base de datos
     * con el id introducido
     * @param id identificador de un usuario
     * @return usuario recogido de la base de datos
     */
    public User getU(String id) {
        User u = null;
        ResultSet result;
        Connection conn = null;
        try {
            conn = new DbConnection().getConnection();

            PreparedStatement platform = conn.prepareStatement("SELECT * FROM usuario WHERE id=?");
            platform.setString(1, id);
            result = platform.executeQuery();

            if (result.next())
                u = new User(result.getString("id"), result.getString("nomUsuario"), result.getString("conUsuario"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return u;

    }
    /**
     * Metodo para iniciar sesion
     * @param userName Nombre del usuario a buscar en la base de datos
     * @return Los datos del usuario con el id más alto (último insert) que tenga el nombre introducido por parámetro
     */
    public User getRegister(String userName) {
        User u = null;
        ResultSet result;
        Connection conn = null;
        try {
            conn = new DbConnection().getConnection();
            PreparedStatement platform = conn.prepareStatement("SELECT * FROM usuario WHERE id = (SELECT MAX(id) FROM usuario WHERE nomUsuario =?)");
            platform.setString(1, userName);
            result = platform.executeQuery();

            if (result.next())
                u = new User(result.getString("id"), result.getString("nomUsuario"), result.getString("conUsuario"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return u;

    }


}
