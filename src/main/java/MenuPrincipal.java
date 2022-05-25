
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MenuPrincipal extends JFrame {
    private JButton help, summon1, score, sonido;

    JFrame frameMenu = new JFrame(" Dokkan Battle ");
    JFrame frameAyuda = new JFrame("Ayuda");
    JFrame frameHistorial = new JFrame("Historial");
    /*
     * Constructor
     */
    public MenuPrincipal() {
        /*
         * Creamos botones para iniciar el menu, le ponemos dimensiones
         *
         * */
        help = new JButton(new ImageIcon("src/resources/ayuda.png"));
        help.setBounds(7, 655, 51, 52);
        help.addActionListener(new HelpButton());


        summon1 = new JButton(new ImageIcon());
        summon1.setBounds(130, 520, 159, 110);
        summon1.addActionListener(new SummonListener());


        score = new JButton(new ImageIcon());
        score.setBounds(310, 510, 50, 50);
        score.addActionListener(new ScoreButton());


        sonido = new JButton(new ImageIcon("src/resources/mute.png"));
        sonido.setBounds(12, 50, 51, 52);
        sonido.addActionListener(new ButtonSonido());


        /*
         * Asignamos titulo a la ventana
         * */
        frameMenu.setTitle(" Dokkan Battle ");
        /*
         * creamos un panel y le añadimos los botones de ayuda e inicio
         * */
        JPanel panelMenu = new JPanel();
        panelMenu.setOpaque(false);
        panelMenu.setLayout(null);
        panelMenu.setBounds(0, 0, 435, 778);
        panelMenu.add(summon1);
        panelMenu.add(help);
        panelMenu.add(score);
        panelMenu.add(sonido);


        /*
         * Dentro de la venatana de inicio de juego colocamos los botones
         * a final de pagina.
         * */
        frameMenu.add(panelMenu);

        /*
         *  Asignamos tamaño de la ventana
         * */
        frameMenu.setSize(435, 778);
        /*
         *  Centra la ventana al medio de la pantalla
         * */
        frameMenu.setLocationRelativeTo(null);
        frameMenu.setVisible(true);
        frameMenu.setResizable(false);
        frameMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
    private class ButtonSonido implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    private static class SummonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {


        }
    }


    private class HelpButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            JPanel panelMenu = new JPanel();
            panelMenu.setOpaque(false);
            panelMenu.setLayout(null);
            panelMenu.setBounds(0, 0, 300, 580);

            /*
             * Dentro de la venatana de inicio de juego colocamos los botones
             * a final de pagina.
             * */
            frameAyuda.add(panelMenu);
            frameAyuda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameAyuda.setSize(400, 650);
            frameAyuda.setResizable(false);
            frameAyuda.setLocationRelativeTo(null);
            frameAyuda.setVisible(true);
        }
    }



    private class ScoreButton implements ActionListener {

        public void actionPerformed(ActionEvent event) {


            JPanel panelMenu = new JPanel();
            panelMenu.setOpaque(false);
            panelMenu.setLayout(null);
            panelMenu.setBounds(0, 0, 435, 778);


            frameHistorial.add(panelMenu);
            frameHistorial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameHistorial.setSize(435, 778);
            frameHistorial.setResizable(false);
            frameHistorial.setLocationRelativeTo(null);
            frameHistorial.setVisible(true);
        }
    }

}
