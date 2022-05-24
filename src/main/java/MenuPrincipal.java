import javax.swing.*;


public class MenuPrincipal extends JFrame {
    private JButton help, summon1, score, sonido;

    JFrame frameMenu = new JFrame(" Dokkan Battle ");
    /*
     * Constructor
     */
    public MenuPrincipal() {
        /*
         * Creamos botones para iniciar el juego, le ponemos dimensiones
         * y un listener para registrar cuando es pulsado
         * */
        help = new JButton(new ImageIcon("src/resources/ayuda.png"));
        help.setBounds(7, 655, 51, 52);



        summon1 = new JButton(new ImageIcon());
        summon1.setBounds(130, 520, 159, 110);


        score = new JButton(new ImageIcon());
        score.setBounds(310, 510, 50, 50);


        sonido = new JButton(new ImageIcon("src/resources/mute.png"));
        sonido.setBounds(12, 50, 51, 52);


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
}
