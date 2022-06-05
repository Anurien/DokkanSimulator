package Simulador;


import DataBase.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class DokkanBanner extends JFrame {
    private JButton singleSummonG, singleSummonF, multiSummonG, multiSummonF, volver;
    JFrame frameSummon = new JFrame("Summon");
    JFrame frameSingle = new JFrame();
    JFrame frameSingle1 = new JFrame("SingleGoku");
    JFrame frameMulti = new JFrame();
    JFrame frameMulti1 = new JFrame();
    private SingleSummon singleSummon;
    private MultiSummon multiSummon;
    private User user;

    public DokkanBanner(User user) {
        this.user=user;
        singleSummon = new SingleSummon();
        multiSummon = new MultiSummon();

        singleSummonG = new JButton(new ImageIcon());
        singleSummonG.addActionListener(new SingleListener(singleSummon));
        singleSummonG.setBounds(65, 280, 115, 45);
        singleSummonG.setBorderPainted(false);
        singleSummonG.setOpaque(false);
        singleSummonG.setContentAreaFilled(false);

        singleSummonF = new JButton(new ImageIcon());
        singleSummonF.addActionListener(new SingleListener1(singleSummon));
        singleSummonF.setBounds(65, 585, 115, 45);
        singleSummonF.setBorderPainted(false);
        singleSummonF.setOpaque(false);
        singleSummonF.setContentAreaFilled(false);

        multiSummonG = new JButton(new ImageIcon());
        multiSummonG.addActionListener(new MultiListener(multiSummon));
        multiSummonG.setBounds(220, 280, 120, 45);
        multiSummonG.setBorderPainted(false);
        multiSummonG.setOpaque(false);
        multiSummonG.setContentAreaFilled(false);

        multiSummonF = new JButton(new ImageIcon());
        multiSummonF.addActionListener(new MultiListener1(multiSummon));
        multiSummonF.setBounds(220, 585, 120, 45);
        multiSummonF.setBorderPainted(false);
        multiSummonF.setOpaque(false);
        multiSummonF.setContentAreaFilled(false);

        volver = new JButton(new ImageIcon());
        volver.addActionListener(new VolverListener());
        volver.setBounds(25, 660, 70, 30);
        volver.setBorderPainted(false);
        volver.setOpaque(false);
        volver.setContentAreaFilled(false);

        JPanel panelSummon = new JPanel();
        panelSummon.setOpaque(false);
        panelSummon.setLayout(null);
        panelSummon.setBounds(0, 0, 435, 778);
        Panelpaint1 imagen = new Panelpaint1();
        panelSummon.add(imagen);
        panelSummon.add(singleSummonG);
        panelSummon.add(singleSummonF);
        panelSummon.add(multiSummonG);
        panelSummon.add(multiSummonF);
        panelSummon.add(volver);

        frameSummon.add(panelSummon);
        frameSummon.add(imagen);
        frameSummon.setSize(435, 778);
        /*
         *  Centra la ventana al medio de la pantalla
         * */
        frameSummon.setLocationRelativeTo(null);
        frameSummon.setVisible(true);
        frameSummon.setResizable(false);
        frameSummon.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        try {
            Sonido.play("src/resources/Musica/app_src_main_res_raw_dokkan_summon_theme_audio.wav");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }


    }

    public class Panelpaint1 extends JPanel {
        public void paintComponent(Graphics g) {
            ImageIcon icon = new ImageIcon("src/resources/Assets/dokkan_summon_background2.png");
            g.drawImage(icon.getImage(), 0, 0, frameSummon.getWidth(), frameSummon.getHeight(), null);
            if (g instanceof Graphics2D) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                setOpaque(true);
                super.paintChildren(g);
            }
        }
    }

    public void closeSummon() {
        frameSingle1.dispose();
        frameMulti.dispose();
        frameSingle.dispose();
        frameMulti1.dispose();
    }

    private class CloseSingle1 implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            closeSummon();
        }
    }

    private class SingleListener implements ActionListener {

        private SingleSummon singleSummon;

        public SingleListener(SingleSummon singleSummon) {
            this.singleSummon = singleSummon;
        }

        public void actionPerformed(ActionEvent event) {
            frameSingle = new JFrame();
            JPanel summonResultsPanel = new JPanel();

            JButton volver = new JButton(new ImageIcon("src/resources/Assets/backi.png"));
            volver.addActionListener(new CloseSingle1());
            volver.setBounds(25, 660, 100, 50);
            volver.setBorderPainted(false);
            volver.setOpaque(false);
            volver.setContentAreaFilled(false);

            Panelpaint4 imagen = new Panelpaint4();
            summonResultsPanel.setOpaque(false);
            summonResultsPanel.setLayout(null);
            summonResultsPanel.setBounds(0, 0, 435, 778);

            Summonable summoned = singleSummon.summon();
            JButton label = new JButton(summoned.getIcon());
            Metodos.saveScore(summoned.getId(), summoned.getName(),summoned.getIcon(),summoned.getRarity(),summoned.getCantidad(),user.getID());

            label.setBounds(170, 300, 75, 82);
            label.setOpaque(false);
            label.setContentAreaFilled(false);
            label.setBorderPainted(false);
            summonResultsPanel.add(label);
            summonResultsPanel.add(volver);
            summonResultsPanel.add(imagen);

            frameSingle.add(summonResultsPanel);
            frameSingle.add(imagen);
            frameSingle.setSize(435, 778);
            frameSingle.setLocationRelativeTo(null);
            frameSingle.setVisible(true);
            frameSingle.setResizable(false);
            frameSingle.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }


    private class SingleListener1 implements ActionListener {
        private SingleSummon singleSummon;

        public SingleListener1(SingleSummon singleSummon) {
            this.singleSummon = singleSummon;
        }

        public void actionPerformed(ActionEvent event) {
            frameSingle1 = new JFrame();
            JPanel summonResultsPanel = new JPanel();

            JButton volver = new JButton(new ImageIcon("src/resources/Assets/backi.png"));
            volver.addActionListener(new CloseSingle1());
            volver.setBounds(25, 660, 100, 50);
            volver.setBorderPainted(false);
            volver.setOpaque(false);
            volver.setContentAreaFilled(false);

            Panelpaint4 imagen = new Panelpaint4();
            summonResultsPanel.setOpaque(false);
            summonResultsPanel.setLayout(null);
            summonResultsPanel.setBounds(0, 0, 435, 778);

            Summonable summoned = singleSummon.summon2();
            JButton label = new JButton(summoned.getIcon());
            Metodos.saveScore(summoned.getId(), summoned.getName(),summoned.getIcon(),summoned.getRarity(),summoned.getCantidad(),user.getID());

            label.setBounds(170, 300, 75, 82);
            label.setOpaque(false);
            label.setContentAreaFilled(false);
            label.setBorderPainted(false);
            summonResultsPanel.add(label);
            summonResultsPanel.add(volver);
            summonResultsPanel.add(imagen);

            frameSingle1.add(summonResultsPanel);
            frameSingle1.add(imagen);
            frameSingle1.setSize(435, 778);
            frameSingle1.setLocationRelativeTo(null);
            frameSingle1.setVisible(true);
            frameSingle1.setResizable(false);
            frameSingle1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }

    private class MultiListener implements ActionListener {
        private MultiSummon multiSummon;

        public MultiListener(MultiSummon multiSummon) {
            this.multiSummon = multiSummon;
        }

        public void actionPerformed(ActionEvent event) {
            frameMulti = new JFrame();
            JPanel summonResultsPanel = new JPanel();

            JButton volver = new JButton(new ImageIcon("src/resources/Assets/backi.png"));
            volver.addActionListener(new CloseSingle1());
            volver.setBounds(25, 660, 70, 30);
            volver.setBorderPainted(false);
            volver.setOpaque(false);
            volver.setContentAreaFilled(false);

            Panelpaint4 imagen = new Panelpaint4();
            summonResultsPanel.setOpaque(false);
            summonResultsPanel.setLayout(new GridLayout(6, 2, 40, 40));
            summonResultsPanel.setBounds(35, 35, 355, 710);

            List<Summonable> summoned = multiSummon.summon();
            for (Summonable s : summoned) {
                summonResultsPanel.add(new JLabel(s.getIcon()));
                System.out.println(summoned);
                Metodos.saveScore(s.getId(), s.getName(), s.getIcon(), s.getRarity(), s.getCantidad(), user.getID());
            }

            summonResultsPanel.add(volver);
            summonResultsPanel.add(imagen);
            frameMulti.add(summonResultsPanel);
            frameMulti.add(imagen);

            frameMulti.setSize(435, 778);
            frameMulti.setLocationRelativeTo(null);
            frameMulti.setVisible(true);
            frameMulti.setResizable(false);
            frameMulti.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }


    private class MultiListener1 implements ActionListener {
        private MultiSummon multiSummon;

        public MultiListener1(MultiSummon multiSummon) {
            this.multiSummon = multiSummon;
        }

        public void actionPerformed(ActionEvent event) {
            frameMulti1 = new JFrame();
            JPanel summonResultsPanel = new JPanel();
            Panelpaint4 imagen = new Panelpaint4();
            JButton volver = new JButton(new ImageIcon("src/resources/Assets/backi.png"));
            volver.addActionListener(new CloseSingle1());
            volver.setBounds(25, 660, 40, 20);
            volver.setBorderPainted(false);
            volver.setOpaque(false);
            volver.setContentAreaFilled(false);

            summonResultsPanel.setOpaque(false);
            summonResultsPanel.setLayout(new GridLayout(6, 2, 40, 40));
            summonResultsPanel.setBounds(35, 35, 355, 710);
            List<Summonable> summoned = multiSummon.summon2();
            for (Summonable s : summoned) {
                summonResultsPanel.add(new JLabel(s.getIcon()));
                Metodos.saveScore(s.getId(), s.getName(), s.getIcon(), s.getRarity(), s.getCantidad(), user.getID());
                //Metodos.updateScore(s.getId(), s.getName(), s.getIcon(), s.getRarity(), s.getCantidad(), user.getID());
                System.out.println(summoned);
            }
            summonResultsPanel.add(volver);
            summonResultsPanel.add(imagen);

            frameMulti1.add(summonResultsPanel);
            frameMulti1.add(imagen);
            frameMulti1.setSize(435, 778);
            frameMulti1.setLocationRelativeTo(null);
            frameMulti1.setVisible(true);
            frameMulti1.setResizable(false);
            frameMulti1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }

    public void closeIntro() {
        frameSummon.dispose();

    }

    private class VolverListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Sonido s = new Sonido();
            closeIntro();
            if (s.isPlaying()) {
                s.dispose();
            }
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
    }

    public class Panelpaint4 extends JPanel {
        public void paintComponent(Graphics g) {
            ImageIcon icon = new ImageIcon("src/resources/Assets/dokkan_summon_background.png");
            g.drawImage(icon.getImage(), 0, 0, frameSingle1.getWidth(), frameSingle1.getHeight(), null);
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
