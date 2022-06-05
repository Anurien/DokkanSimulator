
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



public class MenuPrincipal extends JFrame {
    private JButton help, summon1, score, sonido, log;

    JFrame frameMenu = new JFrame(" Dokkan Battle ");
    JFrame frameAyuda = new JFrame("Ayuda");
    JFrame frameHistorial = new JFrame("Historial");
    User user = null;

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
        help.setOpaque(false);
        help.setContentAreaFilled(false);
        help.setBorderPainted(false);
        help.addActionListener(new HelpButton());

        summon1 = new JButton(new ImageIcon());
        summon1.setBounds(130, 520, 159, 110);
        summon1.setBorderPainted(false);
        summon1.setOpaque(false);
        summon1.setContentAreaFilled(false);
        summon1.addActionListener(new SummonListener());

        score = new JButton(new ImageIcon());
        score.setBounds(310, 510, 50, 50);
        score.setBorderPainted(false);
        score.setOpaque(false);
        score.setContentAreaFilled(false);
        score.addActionListener(new ScoreButton());

        sonido = new JButton(new ImageIcon("src/resources/Assets/mute.png"));
        sonido.setBounds(12, 50, 51, 52);
        sonido.setOpaque(false);
        sonido.setContentAreaFilled(false);
        sonido.setBorderPainted(false);
        sonido.addActionListener(new ButtonSonido());

        log = new JButton();
        log.setBounds(67, 515, 51, 52);
        log.setOpaque(false);
        log.setContentAreaFilled(false);
        log.setBorderPainted(false);
        log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int eleccion;
                eleccion = Integer.parseInt(JOptionPane.showInputDialog(null, "Escoja opcion\n" + "Usuario\n" +
                        "1.Iniciar Sesion\n" + "2.Registrarse\n" + "3.Cerrar Sesion"));

                if (eleccion == 1) {

                    user = Metodos.login(JOptionPane.showInputDialog(null, "Introduce id de usuario",
                            this), JOptionPane.showInputDialog(null, "Introduce password"));

                } else if (eleccion == 2) {

                    user = Metodos.register(JOptionPane.showInputDialog(null, "Introduce id de usuario"),
                            JOptionPane.showInputDialog(null, "Introduce usuario"),
                            JOptionPane.showInputDialog(null, "Introduce password"));
                } else if (eleccion == 3) {

                    user = null;
                }
            }
        });

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
        Panelpaint imagen = new Panelpaint();
        panelMenu.add(imagen);
        panelMenu.add(summon1);
        panelMenu.add(help);
        panelMenu.add(score);
        panelMenu.add(sonido);
        panelMenu.add(log);


        /*
         * Dentro de la venatana de inicio de juego colocamos los botones
         * a final de pagina.
         * */
        frameMenu.add(panelMenu);
        frameMenu.add(imagen);
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
        try {
            Sonido.play("src/resources/Musica/app_src_main_res_raw_dokkan_theme_audio.wav");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

    }

    public class Panelpaint extends JPanel {
        public void paintComponent(Graphics g) {
            ImageIcon icon = new ImageIcon("src/resources/Assets/menuWallpaper2.png");
            g.drawImage(icon.getImage(), 0, 0, frameMenu.getWidth(), frameMenu.getHeight(), null);
            if (g instanceof Graphics2D) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                setOpaque(true);
                super.paintChildren(g);
            }
        }
    }

    public void closeIntro() {
        frameMenu.dispose();
        frameAyuda.dispose();
    }

    public void closeHelp() {
        frameAyuda.dispose();
    }

    public void closeScore() {
        frameHistorial.dispose();
    }

    private class ButtonSonido implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Sonido s = new Sonido();
            if (e.getSource() == sonido) {
                if (s.isPlaying()) {
                    s.dispose();
                } else {
                    try {
                        s.play("src/resources/Musica/app_src_main_res_raw_dokkan_theme_audio.wav");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (LineUnavailableException ex) {
                        ex.printStackTrace();
                    } catch (UnsupportedAudioFileException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
    }

    private class SummonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            new DokkanBanner(user);
            Sonido s = new Sonido();
            if (s.isPlaying()) {
                s.dispose();
            }
        }
    }

    private class CloseHelp implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            closeHelp();
        }
    }

    private class HelpButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JButton close = new JButton(new ImageIcon("src/resources/Assets/close.png"));
            close.setBounds(130, 492, 131, 34);
            close.setOpaque(false);
            close.setContentAreaFilled(false);
            close.setBorderPainted(false);
            close.addActionListener(new CloseHelp());

            JPanel panelMenu = new JPanel();
            panelMenu.setOpaque(false);
            panelMenu.setLayout(null);
            panelMenu.setBounds(0, 0, 300, 580);
            Panelpaint2 imagen = new Panelpaint2();
            panelMenu.add(imagen);
            panelMenu.add(close);
            /*
             * Dentro de la venatana de inicio de juego colocamos los botones
             * a final de pagina.
             * */
            frameAyuda.add(panelMenu);
            frameAyuda.add(imagen);

            frameAyuda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameAyuda.setSize(400, 650);
            frameAyuda.setResizable(false);
            frameAyuda.setLocationRelativeTo(null);
            frameAyuda.setVisible(true);
        }
    }

    public class Panelpaint2 extends JPanel {
        public void paintComponent(Graphics g) {
            ImageIcon icon = new ImageIcon("src/resources/Assets/dokkan_ayuda1_background.png");
            g.drawImage(icon.getImage(), 0, 0, frameAyuda.getWidth(), frameAyuda.getHeight(), null);
            if (g instanceof Graphics2D) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                setOpaque(true);
                super.paintChildren(g);
            }
        }
    }

    private class CloseScore implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            closeScore();
        }
    }

    private class ScoreButton implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            JButton close = new JButton(new ImageIcon("src/resources/Assets/close.png"));
            close.addActionListener(new CloseScore());

            close.setBounds(148, 650, 132, 34);
            close.setOpaque(false);
            close.setContentAreaFilled(false);
            close.setBorderPainted(false);

            Metodos.mostrarTabla(user,close);
        }
    }
}