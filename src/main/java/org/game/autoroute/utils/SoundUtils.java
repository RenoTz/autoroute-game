package org.game.autoroute.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class SoundUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(SoundUtils.class);

    /**
     * Play the specified audio file serially.
     */
    public static void play() {
        try {
            play(AudioSystem.getAudioInputStream(new File(ConstantesUtils.PATH_RESOURCES_SOUND, ConstantesUtils.TAKE_CARD).getAbsoluteFile()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void play(AudioInputStream audioInputStream) {
        try {
            AudioFormat format = audioInputStream.getFormat();
            int bufferSize = format.getFrameSize() * Math.round(format.getFrameRate() / 10);
            byte[] buffer = new byte[bufferSize];
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format, bufferSize);
            // start the line
            line.start();
            // copy data to the line
            int numBytesRead = 0;
            while (numBytesRead != -1) {
                numBytesRead = audioInputStream.read(buffer, 0, buffer.length);
                if (numBytesRead != -1) {
                    line.write(buffer, 0, numBytesRead);
                }
            }
            // wait until all data is played, then close the line
            line.drain();
            line.close();
        } catch (IOException | LineUnavailableException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
