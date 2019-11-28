package org.game.autoroute.service;

import java.awt.Color;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.game.autoroute.model.Carte;
import org.game.autoroute.utils.CarteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;

public class ActionService implements Serializable
{

    private static final long serialVersionUID = -7337095939630436762L;

    private static final Logger log = LoggerFactory.getLogger(ActionService.class);

    private static final String PATTER_LOG = "{} de {}";

    public void accept(final List<Carte> cartes, final JButton button, final List<JButton> buttons)
    {
        // final int indexPrec = buttons.indexOf(button) != 0 ? buttons.indexOf(button) - 1 : 0;

        if (buttons.indexOf(button) == 0
        /* || !buttons.get(indexPrec).getIcon().toString().equals(button.getIcon().toString()) */) {
            this.prendreCarte(cartes, button);
        }
    }

    private void prendreCarte(final List<Carte> cartes, final JButton button)
    {
        final Carte carte = CarteUtils.getCarte(cartes);
        carte.setVisible(true);
        button.setIcon(carte.getImage());
        log.info(PATTER_LOG, carte.getCarteEnum(), carte.getCouleur());
    }

    public boolean more(final List<Carte> cartes, final List<JButton> buttons, final int currentIndex,
        final JLabel lblMessage, final List<JLabel> cursors)
    {
        final Carte lastCardVisible =
            Iterables.getLast(cartes.stream().filter(Carte::isVisible).collect(Collectors.toList()));
        final Carte nextCard = CarteUtils.getCarte(cartes);
        nextCard.setVisible(true);

        final int nextIndex = currentIndex != buttons.size() - 1 ? currentIndex + 1 : buttons.size() - 1;

        buttons.get(nextIndex).setIcon(nextCard.getImage());
        log.info(PATTER_LOG, nextCard.getCarteEnum(), nextCard.getCouleur());

        if (nextCard.getValeur().intValue() > lastCardVisible.getValeur().intValue()) {
            log.info("TRUE -> IS MORE");
            buttons.get(nextIndex).setBorder(null);
            cursors.get(currentIndex).setIcon(null);
            cursors.get(nextIndex).setIcon(CarteUtils.getIconCursor());
            lblMessage.setText("GREAT !!! ");
            return true;
        } else if (nextCard.getValeur().intValue() == lastCardVisible.getValeur().intValue()) {
            log.info("WRONG -> YOU DRINK TWICE");
            buttons.get(nextIndex).setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.DARK_GRAY));
            lblMessage.setText("YOU DRINK TWICE !!! ");
        } else {
            log.info("WRONG -> YOU DRINK");
            buttons.get(nextIndex).setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.DARK_GRAY));
            lblMessage.setText("YOU DRINK !!! ");
        }
        return false;

    }

    public boolean less(final List<Carte> cartes, final List<JButton> buttons, final int currentIndex,
        final JLabel lblMessage, final List<JLabel> cursors)
    {
        final Carte lastCardVisible =
            Iterables.getLast(cartes.stream().filter(Carte::isVisible).collect(Collectors.toList()));
        final Carte nextCard = CarteUtils.getCarte(cartes);
        nextCard.setVisible(true);

        final int previousIndex = currentIndex != 0 ? currentIndex - 1 : 0;
        final int nextIndex = currentIndex != buttons.size() - 1 ? currentIndex + 1 : buttons.size() - 1;

        buttons.get(nextIndex).setIcon(nextCard.getImage());
        log.info(PATTER_LOG, nextCard.getCarteEnum(), nextCard.getCouleur());

        if (nextCard.getValeur().intValue() < lastCardVisible.getValeur().intValue()) {
            log.info("TRUE -> IS LESS");
            buttons.get(nextIndex).setBorder(null);
            cursors.get(currentIndex).setIcon(null);
            cursors.get(nextIndex).setIcon(CarteUtils.getIconCursor());
            lblMessage.setText("GREAT !!! ");
            return true;
        } else if (nextCard.getValeur().intValue() == lastCardVisible.getValeur().intValue()) {
            log.info("WRONG -> YOU DRINK TWICE");
            cursors.get(currentIndex).setIcon(null);
            cursors.get(previousIndex).setIcon(CarteUtils.getIconCursor());
            buttons.get(nextIndex).setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.DARK_GRAY));
            lblMessage.setText("YOU DRINK TWICE !!! ");
        } else {
            log.info("WRONG -> YOU DRINK");
            cursors.get(currentIndex).setIcon(null);
            cursors.get(previousIndex).setIcon(CarteUtils.getIconCursor());
            buttons.get(nextIndex).setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.DARK_GRAY));
            lblMessage.setText("YOU DRINK !!! ");
        }
        return false;
    }

}
