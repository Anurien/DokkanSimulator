package DataBase;


import DataBase.DbConnection;
import DataBase.Summonable;


import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;


public class DAOSummonable {

    public DAOSummonable() {
    }


    /**
     * Inserta en la base de datos los datos de la puntuacion
     *
     * @param s
     */
    public void insert(Summonable s) {

        Connection conn = null;
        try {
            conn = new DbConnection().getConnection();

            PreparedStatement psUser = conn.prepareStatement("INSERT INTO personajes(idP,nombre,icono,rareza,cantidad, id) VALUES(?,?,?,?,?,?)");
            psUser.setInt(1, s.getId());
            psUser.setString(2, s.getName());
            psUser.setString(3, String.valueOf(s.getIcon()));
            psUser.setString(4, String.valueOf(s.getRarity()));
            psUser.setInt(5, s.getCantidad() + 1);
            psUser.setString(6, s.getUserId());
            psUser.executeUpdate();

            //  psUser.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Elimina las puntuaciones asociadas a un usuario de la base de datos
     *
     * @param u Usuario del que se quieren eliminar las puntuaciones
     */
    public void delete(User u) {

        Connection conn = null;
        try {
            conn = new DbConnection().getConnection();

            PreparedStatement psUser = conn.prepareStatement("DELETE FROM personajes WHERE id=?");
            psUser.setString(1, u.getID());
            psUser.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo que recoge las cartas asociadas al usuario introducido
     * @param u usuario del que se quieren recoger datos
     * @return cartas del usuario
     */
    public String[][] get(User u) {

        String[][] userScoreTable = new String[150][3];
        ResultSet res;
        Connection conn = null;
        try {
            conn = new DbConnection().getConnection();

            PreparedStatement platform = conn.prepareStatement("SELECT nombre, rareza, cantidad FROM personajes WHERE id=?");
            platform.setString(1, u.getID());
            res = platform.executeQuery();
            int i = 0;
            while (res.next()) {
                i++;

                userScoreTable[i - 1] = new String[]{res.getString("nombre"), res.getString("rareza"), String.valueOf(res.getInt("cantidad"))};

            }
            res.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuario nulo, inicie sesion");
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return userScoreTable;

    }
    /**
     * Recibe un id y comprueba si existe en la base de datos devuelve un true o un false
     * @param id identificador de carta
     * @return boolean comprobador
     * @throws SQLException
     */
    public boolean getId(int id) throws SQLException {
        ResultSet res;
        Connection conn = null;
        conn = new DbConnection().getConnection();
        PreparedStatement platform = conn.prepareStatement("SELECT count(idP) FROM personajes where idP=?");
        platform.setInt(1, id);
        res = platform.executeQuery();

        return res.next();

    }

    /**
     * Actualiza los datos de la persona en la base de datos
     *
     * @param s Persona del que se quiere actualizar los datos
     */
    public void actualizaPersona(Summonable s) {
        Connection conn = null;
        try {
            conn = new DbConnection().getConnection();

            PreparedStatement actualiza = conn.prepareStatement(
                    "UPDATE personajes SET cantidad=? WHERE idP=?");
            actualiza.setInt(1, (s.getCantidad() + 1));
            actualiza.setInt(2, s.getId());
            actualiza.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
