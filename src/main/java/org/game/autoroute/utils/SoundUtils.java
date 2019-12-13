package org.game.autoroute.utils;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class SoundUtils
{

    private static AudioClip takeCard = null;

    static {
        try {
            final URL urlTakeCard = new URL("file", ConstantesUtils.PATH_RESOURCES_SOUND, "takeCard.wav");
            takeCard = Applet.newAudioClip(urlTakeCard);
        } catch (final MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void playTakeCard()
    {
        takeCard.play();
    }
}
