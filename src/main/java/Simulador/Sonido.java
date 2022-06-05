package Simulador;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sonido {
    private static Clip clip;

    public Sonido() {

    }
    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }

    /**
     * Metodo que reproduce la musica
     * @param nombreSonido ruta donde esta el audio
     * @throws IOException
     * @throws LineUnavailableException
     * @throws UnsupportedAudioFileException
     */
    public static void play(String nombreSonido) throws IOException, LineUnavailableException, UnsupportedAudioFileException {

        if (clip == null || !clip.isRunning()) {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile()));
            clip.setFramePosition(0);
            clip.start();
        }
    }
    /**
     * Metodo que para la musica
     */
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.flush();
            dispose();
        }
    }
    /**
     * Metodo que cierra la musica
     */
    public void dispose() {
        try {
            clip.close();
        } finally {
            clip = null;
        }
    }

}
