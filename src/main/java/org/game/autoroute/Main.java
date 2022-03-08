package org.game.autoroute;

import java.awt.EventQueue;
import org.game.autoroute.ihm.AutorouteUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            try {
                AutorouteUI frame = new AutorouteUI();
                frame.setVisible(true);
            } catch (final Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        });
    }

}
