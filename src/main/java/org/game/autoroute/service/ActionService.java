package org.game.autoroute.service;

import java.awt.Color;
import java.io.Serializable;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.game.autoroute.model.Carte;
import org.game.autoroute.utils.CarteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

public class ActionService implements Serializable
{

    private static final long serialVersionUID = -7337095939630436762L;

    private static final Logger log = LoggerFactory.getLogger(ActionService.class);

    private static final String PATTER_LOG = "{} de {}";

    private static final List<Integer> previousIndexPeages = Lists.newArrayList(1, 4);

    public void prendreCarte(final List<Carte> cartes, final JButton button)
    {
        final Carte carte = CarteUtils.getCarte(cartes);
        carte.setVisible(true);
        button.setIcon(carte.getImage());
        log.info(PATTER_LOG, carte.getCarteEnum(), carte.getCouleur());
    }

    public Carte getCurrentCard(final List<Carte> cartes, final List<JButton> buttons, final int currentIndex)
    {
        return cartes.stream().filter(c -> c.getImage().equals(buttons.get(currentIndex).getIcon())).findFirst()
            .orElse(null);
    }

    public boolean more(final List<Carte> cartes, final List<JButton> buttons, final int currentIndex,
        final JLabel lblMessage, final List<JLabel> cursors, final int sens)
    {
        final Carte currentCard = this.getCurrentCard(cartes, buttons, currentIndex);
        final Carte nextCard = CarteUtils.getCarte(cartes);
        nextCard.setVisible(true);

        final int previousIndex = currentIndex != 0 ? currentIndex - 1 : 0;
        final int nextIndex = currentIndex != buttons.size() - 1 ? currentIndex + 1 : 0;

        buttons.get(nextIndex).setIcon(nextCard.getImage());
        log.info(PATTER_LOG, nextCard.getCarteEnum(), nextCard.getCouleur());

        if (nextCard.getValeur().intValue() > currentCard.getValeur().intValue()) {
            log.info("TRUE -> IS MORE");
            return this.correct(buttons, currentIndex, lblMessage, cursors, nextIndex);
        } else if (previousIndexPeages.contains(previousIndex)
            || nextCard.getValeur().intValue() == currentCard.getValeur().intValue()) {
            log.info("WRONG -> YOU DRINK TWICE");
            return this.wrong(buttons, currentIndex, lblMessage, "YOU DRINK TWICE", cursors, previousIndex, nextIndex);
        } else {
            log.info("WRONG -> YOU DRINK");
            return this.wrong(buttons, currentIndex, lblMessage, "YOU DRINK", cursors, previousIndex, nextIndex);
        }
    }

    public boolean less(final List<Carte> cartes, final List<JButton> buttons, final int currentIndex,
        final JLabel lblMessage, final List<JLabel> cursors, final int sens)
    {
        final Carte currentCard = this.getCurrentCard(cartes, buttons, currentIndex);
        final Carte nextCard = CarteUtils.getCarte(cartes);
        nextCard.setVisible(true);

        final int previousIndex = currentIndex != 0 ? currentIndex - 1 : (sens == -1 ? 1 : 0);
        final int nextIndex = currentIndex != buttons.size() - 1 ? currentIndex + 1 : 0;

        buttons.get(nextIndex).setIcon(nextCard.getImage());
        log.info(PATTER_LOG, nextCard.getCarteEnum(), nextCard.getCouleur());

        if (nextCard.getValeur().intValue() < currentCard.getValeur().intValue()) {
            log.info("TRUE -> IS LESS");
            return this.correct(buttons, currentIndex, lblMessage, cursors, nextIndex);
        } else if (previousIndexPeages.contains(previousIndex)
            || nextCard.getValeur().intValue() == currentCard.getValeur().intValue()) {
            log.info("WRONG -> YOU DRINK TWICE");
            this.wrong(buttons, currentIndex, lblMessage, "YOU DRINK TWICE", cursors, previousIndex, nextIndex);
        } else {
            log.info("WRONG -> YOU DRINK");
            this.wrong(buttons, currentIndex, lblMessage, "YOU DRINK", cursors, previousIndex, nextIndex);
        }
        return false;
    }

    private boolean correct(final List<JButton> buttons, final int currentIndex, final JLabel lblMessage,
        final List<JLabel> cursors, final int nextIndex)
    {
        buttons.get(nextIndex).setBorder(null);
        cursors.get(currentIndex).setIcon(null);
        cursors.get(nextIndex).setIcon(CarteUtils.getIconCursor());
        lblMessage.setText(previousIndexPeages.contains(currentIndex) ? "PEAGE -> YOU DRINK" : "PASSED");

        return true;
    }

    private boolean wrong(final List<JButton> buttons, final int currentIndex, final JLabel lblMessage,
        final String message, final List<JLabel> cursors, final int previousIndex, final int nextIndex)
    {
        cursors.get(currentIndex).setIcon(null);
        cursors.get(previousIndex).setIcon(CarteUtils.getIconCursor());
        buttons.get(nextIndex).setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.DARK_GRAY));
        lblMessage.setText(message);

        return false;
    }

}
