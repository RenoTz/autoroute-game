package org.game.autoroute.utils;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SoundUtils
{

    // private static final AudioClip takeCard = null;

    private static Clip clip;

    private static AudioInputStream audioInputStream;

    static {
        try {
            //            final URL urlTakeCard = new URL("file", ConstantesUtils.PATH_RESOURCES_SOUND, "takeCard.wav");
            //            takeCard = Applet.newAudioClip(urlTakeCard);

            // create AudioInputStream object
            audioInputStream = AudioSystem
                .getAudioInputStream(new File(ConstantesUtils.PATH_RESOURCES_SOUND, "takeCard.wav").getAbsoluteFile());

            // create clip reference
            clip = AudioSystem.getClip();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // open audioInputStream to the clip

        } catch (final LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public static void playTakeCard()
    {
        // takeCard.play();
        try {
            if (!clip.isOpen()) {
                clip.open(audioInputStream);
            }
            clip.start();
        } catch (final LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
}
