package DataBase;

import DataBase.DAOSummonable;
import DataBase.DAOUser;
import DataBase.Summonable;
import DataBase.User;
import Simulador.MenuPrincipal;
import Simulador.Rarity;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Metodos {
    static JFrame frameHistorial;

    /**
     * Elimina los datos del usuario (incluidadlas puntuaciones) de la base de datos
     *
     * @param u El usuario a eliminar.
     * @return Devuelve null.
     */
    public static User deleteUser(User u) {
        DAOUser login = new DAOUser();
        DAOSummonable daoSummonable = new DAOSummonable();
        login.delete(u);
        daoSummonable.delete(u);
        JOptionPane.showMessageDialog(null,"usuario eliminado");
        return null;
    }

    public static User login(String id, String password) {

        DAOUser daoUser = new DAOUser();

        User logUser = daoUser.getU(id);

        if (logUser.getPassword().equals(password)) {

            JOptionPane.showMessageDialog(null, "Sesion iniciada correctamente\n" + "Sesion Iniciada");

            return logUser;

        } else {

            JOptionPane.showMessageDialog(null, "La contraseña no es correcta. Porfavor vuelva a intentarlo.\n" + "Error");

            return null;
        }
    }


    public static User register(String id, String username, String password) {

        DAOUser daoUser = new DAOUser();

        try {
            daoUser.addUser(new User(id, username, password));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return daoUser.getRegister(id);


    }


    public static void saveScore(int id, String nombre, ImageIcon icon, Rarity rareza, int cantidad, String idu) {

        DAOSummonable daoSummonable = new DAOSummonable();
        try {
            if (daoSummonable.getId(id)==true) {
                daoSummonable.actualizaPersona(new Summonable(id, nombre, icon, rareza, cantidad, idu));
                daoSummonable.insert(new Summonable(id, nombre, icon, rareza, cantidad, idu));
                System.out.println("actualizaos");
            } else {
                daoSummonable.insert(new Summonable(id, nombre, icon, rareza, cantidad, idu));
                System.out.println("insertaos");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateScore(int id, String nombre, ImageIcon icon, Rarity rareza, int cantidad, String idu) {
        DAOSummonable daoSummonable = new DAOSummonable();

    }

    public static void mostrarTabla(User u, JButton close) {

        DAOSummonable daoSummonable = new DAOSummonable();

        String[][] cartasTabla = daoSummonable.get(u);
        String[] columns = {"Nombre", "Rareza", "Cantidad"};

        tabla(cartasTabla, columns, u, close);

    }

    private static void tabla(String[][] data, String[] columns, User u, JButton close) {
        close = new JButton(new ImageIcon("src/resources/Assets/close.png"));
        close.addActionListener(new CloseScore());

        close.setBounds(148, 650, 132, 34);
        close.setOpaque(false);
        close.setContentAreaFilled(false);
        close.setBorderPainted(false);

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(250);
        columnModel.getColumn(1).setPreferredWidth(40);
        columnModel.getColumn(2).setPreferredWidth(50);
        table.setFillsViewportHeight(true);
        table.setOpaque(false);
        table.setForeground(Color.WHITE);
        table.setShowGrid(false);
        table.setShowVerticalLines(false);
        table.setBorder(null);
        table.setDefaultRenderer(Object.class, new CeldalRenderer());
        table.setBounds(0, 0, 434, 625);
        JScrollPane pane = new JScrollPane(table);
        pane.setOpaque(false);
        pane.setBorder(null);
        pane.getViewport().setOpaque(false);
        pane.setBounds(0, 0, 435, 625);

        JPanel panelMenu = new JPanel();
        panelMenu.setOpaque(false);
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, 434, 778);
        Panelpaint3 imagen = new Panelpaint3();
        panelMenu.add(pane);
        panelMenu.add(imagen);
        panelMenu.add(close);
        frameHistorial = new JFrame();
        frameHistorial.add(panelMenu);
        frameHistorial.add(imagen);
        frameHistorial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frameHistorial.setSize(435, 778);
        frameHistorial.setResizable(false);
        frameHistorial.setLocationRelativeTo(null);
        frameHistorial.setVisible(true);
        model.fireTableRowsUpdated(0, 150);
        model.fireTableDataChanged();


    }

    private static class CloseScore implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            closeScore();
        }
    }

    public static void closeScore() {
        frameHistorial.dispose();
    }

    private static class CeldalRenderer extends DefaultTableCellRenderer {

        public CeldalRenderer() {
            CeldalRenderer.this.setOpaque(false);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (isSelected) {
                setBackground(new Color(255, 255, 255));
                setOpaque(true);
                setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
                setFont(new Font("Arial", Font.BOLD, 12));
            } else {
                setOpaque(false);
                setFont(new Font("Arial", Font.PLAIN, 12));
                setBorder(null);
            }
            return cellComponent;
        }
    }

    public static class Panelpaint3 extends JPanel {
        public void paintComponent(Graphics g) {
            ImageIcon icon = new ImageIcon("src/resources/Assets/dokkan_summon_background.png");
            g.drawImage(icon.getImage(), 0, 0, 434, 778, null);
            if (g instanceof Graphics2D) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                setOpaque(true);
                super.paintChildren(g);
            }
        }
    }

}
