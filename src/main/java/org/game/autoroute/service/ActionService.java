package org.game.autoroute.service;

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

    public ImageIcon getImageCard()
    {
        final Carte carte = CarteUtils.getNextCard();
        carte.setVisible(true);
        log.info(PATTER_LOG, carte.getCarteEnum(), carte.getCouleur());
        return carte.getImage();
    }

    private Carte getCurrentCard(final JButton currentButtnon)
    {
        final Carte carte =
            CarteUtils.jeuDeCartes.stream().filter(c -> c.getImage().equals(currentButtnon.getIcon())).findFirst()
                .orElse(null);
        if (Objects.isNull(carte)) {
            log.error("Plus de cartes. On reprends un nouveau jeu de cartes.");
            CarteUtils.jeuDeCartes.forEach(c -> c.setVisible(false));
        }
        return carte;
    }

    public boolean more(final List<CardLayout> cardLayouts, final List<JPanel> cardPanels, final int currentIndex,
        final List<JLabel> cursors, final int sens)
    {
        final JButton currentButtnon =
            (JButton) cardPanels.get(currentIndex).getComponent(cardPanels.get(currentIndex).getComponentCount() - 1);
        final Carte currentCard = this.getCurrentCard(currentButtnon);
        final Carte nextCard = CarteUtils.getNextCard();
        nextCard.setVisible(true);

        final int previousIndex = currentIndex != 0 ? currentIndex - 1 : (sens == -1 ? 6 : 0);
        final int nextIndex = currentIndex != cardLayouts.size() - 1 ? currentIndex + 1 : 0;

        final JButton nextCardButton = nextCard.addCard(cardLayouts.get(nextIndex), cardPanels.get(nextIndex));
        cardPanels.get(nextIndex).add(nextCardButton.getIcon().toString(), nextCardButton);
        nextCardButton.doClick();

        log.info(PATTER_LOG, nextCard.getCarteEnum(), nextCard.getCouleur());

        if (nextCard.getValeur() > currentCard.getValeur()) {
            log.info("TRUE -> IS MORE");
            return this.correct(cardPanels, currentIndex, cursors, nextIndex);
        } else {
            log.info("WRONG -> YOU DRINK");
            return this.wrong(cardPanels, currentIndex, cursors, previousIndex, nextIndex);
        }
    }

    public boolean less(final List<CardLayout> cardLayouts, final List<JPanel> cardPanels, final int currentIndex,
        final List<JLabel> cursors, final int sens)
    {
        final JButton currentButtnon =
            (JButton) cardPanels.get(currentIndex).getComponent(cardPanels.get(currentIndex).getComponentCount() - 1);
        final Carte currentCard = this.getCurrentCard(currentButtnon);
        final Carte nextCard = CarteUtils.getNextCard();
        nextCard.setVisible(true);

        final int previousIndex = currentIndex != 0 ? currentIndex - 1 : (sens == -1 ? 6 : 0);
        final int nextIndex = currentIndex != cardLayouts.size() - 1 ? currentIndex + 1 : 0;

        //        buttons.get(nextIndex).setIcon(nextCard.getImage());
        final JButton nextCardButton = nextCard.addCard(cardLayouts.get(nextIndex), cardPanels.get(nextIndex));
        cardPanels.get(nextIndex).add(nextCardButton.getIcon().toString(), nextCardButton);
        nextCardButton.doClick();
        log.info(PATTER_LOG, nextCard.getCarteEnum(), nextCard.getCouleur());

        if (nextCard.getValeur() < currentCard.getValeur()) {
            log.info("TRUE -> IS LESS");
            return this.correct(cardPanels, currentIndex, cursors, nextIndex);
        } else {
            log.info("WRONG -> YOU DRINK");
            this.wrong(cardPanels, currentIndex, cursors, previousIndex, nextIndex);
        }
        return false;
    }

    private boolean correct(final List<JPanel> cardPanels, final int currentIndex, final List<JLabel> cursors,
        final int nextIndex)
    {
        cardPanels.get(nextIndex).setBorder(null);
        cursors.get(currentIndex).setIcon(null);
        cursors.get(nextIndex).setIcon(CarteUtils.getIconCursor());

        return true;
    }

    private boolean wrong(final List<JPanel> cardPanels, final int currentIndex, final List<JLabel> cursors,
        final int previousIndex, final int nextIndex)
    {
        cursors.get(currentIndex).setIcon(null);
        cursors.get(previousIndex).setIcon(CarteUtils.getIconCursor());
        cardPanels.get(nextIndex).setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.DARK_GRAY));

        return false;
    }

}
