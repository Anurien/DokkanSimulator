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

    /*
     * Método JudgeAdmin ()
     * Juzgue si la ID de usuario y la contraseña son correctas, si es correcta, muestra el inicio de sesión exitoso
     * Si está mal, aparecerá una ventana emergente para mostrar la cuenta o contraseña incorrecta
     */
    public boolean login(User user) {

        String sql = "select * from usuario where id=? and conUsuario=?";

        int ans = 0;
        Connection conn = null;
        try {
            conn = new DbConnection().getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getID());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ans = 1;
            }
            //rs.close();
            //ps.close();
            //conn.close();


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
        if (ans == 1) {
            return true;
        } else return false;

    }

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

    // Agregar cuenta de administrador a la base de datos
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
