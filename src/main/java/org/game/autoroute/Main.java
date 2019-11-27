package org.game.autoroute;

import java.awt.EventQueue;

import org.game.autoroute.controller.Autoroute;
import org.game.autoroute.ihm.AutorouteUI;

public class Main
{
    public static void main(final String[] args)
    {
        final Autoroute autoroute = new Autoroute();

        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try {
                    final AutorouteUI frame = new AutorouteUI();
                    frame.setVisible(true);
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
