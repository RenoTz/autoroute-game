package org.game.autoroute;

import java.awt.EventQueue;

import org.game.autoroute.ihm.AutorouteUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main
{
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(final String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    final AutorouteUI frame = new AutorouteUI();
                    frame.setVisible(true);
                } catch (final Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        });
    }

}
