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

    public static void play(String nombreSonido) throws IOException, LineUnavailableException, UnsupportedAudioFileException {

        if (clip == null || !clip.isRunning()) {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile()));
            clip.setFramePosition(0);
            clip.start();
        }
    }
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.flush();
            dispose();
        }
    }

    public void dispose() {
        try {
            clip.close();
        } finally {
            clip = null;
        }
    }

    public static void reproducirSonido(String nombreSonido) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }
}
