package org.game.autoroute;

import org.game.autoroute.ihm.AutorouteUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(final String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                final AutorouteUI frame = new AutorouteUI();
                frame.setVisible(true);
            } catch (final Exception e) {
                LOGGER.error(e.getMessage(), e);
            }
        });
    }

}
