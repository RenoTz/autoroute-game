package org.game.autoroute.service;

import java.awt.Color;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import org.game.autoroute.model.Carte;
import org.game.autoroute.utils.CarteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Iterables;

public class ActionService implements Serializable
{

    private static final long serialVersionUID = -7337095939630436762L;

    private static final Logger log = LoggerFactory.getLogger(ActionService.class);

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
        log.info("{} de {}", carte.getCarteEnum(), carte.getCouleur());
    }

    public boolean more(final List<Carte> cartes, final List<JButton> buttons, final int currentIndex)
    {
        final Carte lastCardVisible =
            Iterables.getLast(cartes.stream().filter(Carte::isVisible).collect(Collectors.toList()));
        final Carte nextCard = CarteUtils.getCarte(cartes);
        nextCard.setVisible(true);

        buttons.get(currentIndex).setIcon(nextCard.getImage());

        if (nextCard.getValeur().intValue() > lastCardVisible.getValeur().intValue()) {
            log.info("TRUE -> IS MORE");
            return true;
        } else if (nextCard.getValeur().intValue() == lastCardVisible.getValeur().intValue()) {
            log.info("WRONG -> YOU DRINK TWICE");
            buttons.get(currentIndex).setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.DARK_GRAY));
        } else {
            log.info("WRONG -> YOU DRINK");
            buttons.get(currentIndex).setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.DARK_GRAY));
        }
        return false;

    }

    public boolean less(final List<Carte> cartes, final List<JButton> buttons, final int currentIndex)
    {
        final Carte lastCardVisible =
            Iterables.getLast(cartes.stream().filter(Carte::isVisible).collect(Collectors.toList()));
        final Carte nextCard = CarteUtils.getCarte(cartes);
        nextCard.setVisible(true);

        buttons.get(currentIndex).setIcon(nextCard.getImage());

        if (nextCard.getValeur().intValue() < lastCardVisible.getValeur().intValue()) {
            log.info("TRUE -> IS LESS");
            return true;
        } else if (nextCard.getValeur().intValue() == lastCardVisible.getValeur().intValue()) {
            log.info("WRONG -> YOU DRINK TWICE");
            buttons.get(currentIndex).setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.DARK_GRAY));
        } else {
            log.info("WRONG -> YOU DRINK");
            buttons.get(currentIndex).setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.DARK_GRAY));
        }
        return false;
    }

}
