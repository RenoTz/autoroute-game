package org.game.autoroute.utils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class SoundUtils {

    static Logger LOGGER = LoggerFactory.getLogger(SoundUtils.class);
    static Clip clip;

    static {
        try {
            // create AudioInputStream object
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(ConstantesUtils.PATH_RESOURCES_SOUND, ConstantesUtils.TAKE_CARD).getAbsoluteFile());

            // create clip reference
            clip = AudioSystem.getClip();

            // open audioInputStream to the clip
            clip.open(audioInputStream);
            clip.start();
        }
        catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    public static void playTakeCard() {
        clip.start();
    }
}
