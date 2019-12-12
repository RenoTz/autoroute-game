package org.game.autoroute.service;

import com.google.common.collect.Lists;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.game.autoroute.model.Carte;
import org.game.autoroute.utils.CarteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionService implements Serializable
{

    private static final long serialVersionUID = -7337095939630436762L;

    private static final Logger log = LoggerFactory.getLogger(ActionService.class);

    private static final String PATTER_LOG = "{} de {}";

    private static final List<Integer> previousIndexPeages = Lists.newArrayList(1, 4);

    public ImageIcon getImageCard(final List<Carte> cartes)
    {
        final Carte carte = CarteUtils.getCarte(cartes);
        carte.setVisible(true);
        log.info(PATTER_LOG, carte.getCarteEnum(), carte.getCouleur());
        return carte.getImage();
    }

    private Carte getCurrentCard(final List<Carte> cartes, final List<JButton> buttons, final int currentIndex)
    {
        final Carte carte =  cartes.stream().filter(c -> c.getImage().equals(buttons.get(currentIndex).getIcon())).findFirst()
            .orElse(null);
        if(Objects.isNull(carte)){
            log.error("Plus de cartes. On reprends un nouveau jeu de cartes.");
            cartes.forEach(c -> c.setVisible(false));
        }
        return carte;
    }

    public boolean more(final List<Carte> cartes, final List<JButton> buttons,
        final List<CardLayout> cardLayouts, final List<JPanel> cardPanels,
        final int currentIndex,
        final JLabel lblMessage, final List<JLabel> cursors, final int sens)
    {
        final Carte currentCard = this.getCurrentCard(cartes, buttons, currentIndex);
        final Carte nextCard = CarteUtils.getCarte(cartes);
        nextCard.setVisible(true);

        final int previousIndex = currentIndex != 0 ? currentIndex - 1 : 0;
        final int nextIndex = currentIndex != buttons.size() - 1 ? currentIndex + 1 : 0;

//        buttons.get(nextIndex).setIcon(nextCard.getImage());
        final JButton nextCardButton = nextCard.addCard(cardLayouts.get(nextIndex), cardPanels.get(nextIndex));
        cardPanels.get(nextIndex).add(nextCardButton);
        nextCardButton.doClick();

        log.info(PATTER_LOG, nextCard.getCarteEnum(), nextCard.getCouleur());

        if (nextCard.getValeur() > currentCard.getValeur()) {
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

        if (nextCard.getValeur() < currentCard.getValeur()) {
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
