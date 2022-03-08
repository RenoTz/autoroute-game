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

public class ActionService implements Serializable {

    private static final long serialVersionUID = -7337095939630436762L;

    private static final Logger LOGGER = LoggerFactory.getLogger(ActionService.class);

    private static final String PATTER_LOG = "{} de {}";

    public ImageIcon getImageCard() {
        Carte carte = CarteUtils.getNextCard();
        carte.setVisible(true);
        LOGGER.info(PATTER_LOG, carte.getCarteEnum(), carte.getCouleur());
        return carte.getImage();
    }

    private Carte getCurrentCard(JButton currentButtnon) {
        Carte carte = CarteUtils.jeuDeCartes.stream().filter(c -> c.getImage().equals(currentButtnon.getIcon())).findFirst().orElse(null);
        if (Objects.isNull(carte)) {
            LOGGER.error("Plus de cartes. On reprends un nouveau jeu de cartes.");
            CarteUtils.jeuDeCartes.forEach(c -> c.setVisible(false));
        }
        return carte;
    }

    public boolean more(List<CardLayout> cardLayouts, List<JPanel> cardPanels, int currentIndex, List<JLabel> cursors, int sens) {
        JButton currentButtnon = (JButton) cardPanels.get(currentIndex).getComponent(cardPanels.get(currentIndex).getComponentCount() - 1);
        Carte currentCard = this.getCurrentCard(currentButtnon);
        Carte nextCard = CarteUtils.getNextCard();
        nextCard.setVisible(true);

        int previousIndex = currentIndex != 0 ? currentIndex - 1 : (sens == -1 ? 6 : 0);
        int nextIndex = currentIndex != cardLayouts.size() - 1 ? currentIndex + 1 : 0;

        JButton nextCardButton = nextCard.addCard(cardLayouts.get(nextIndex), cardPanels.get(nextIndex));
        cardPanels.get(nextIndex).add(nextCardButton.getIcon().toString(), nextCardButton);
        nextCardButton.doClick();

        LOGGER.info(PATTER_LOG, nextCard.getCarteEnum(), nextCard.getCouleur());

        if (nextCard.getValeur() > currentCard.getValeur()) {
            LOGGER.info("TRUE -> IS MORE");
            return this.correct(cardPanels, currentIndex, cursors, nextIndex);
        }
        else {
            LOGGER.info("WRONG -> YOU DRINK");
            return this.wrong(cardPanels, currentIndex, cursors, previousIndex, nextIndex);
        }
    }

    public boolean less(List<CardLayout> cardLayouts, List<JPanel> cardPanels, int currentIndex, List<JLabel> cursors, int sens) {
        JButton currentButtnon = (JButton) cardPanels.get(currentIndex).getComponent(cardPanels.get(currentIndex).getComponentCount() - 1);
        Carte currentCard = this.getCurrentCard(currentButtnon);
        Carte nextCard = CarteUtils.getNextCard();
        nextCard.setVisible(true);

        int previousIndex = currentIndex != 0 ? currentIndex - 1 : (sens == -1 ? 6 : 0);
        int nextIndex = currentIndex != cardLayouts.size() - 1 ? currentIndex + 1 : 0;

        //        buttons.get(nextIndex).setIcon(nextCard.getImage());
        JButton nextCardButton = nextCard.addCard(cardLayouts.get(nextIndex), cardPanels.get(nextIndex));
        cardPanels.get(nextIndex).add(nextCardButton.getIcon().toString(), nextCardButton);
        nextCardButton.doClick();
        LOGGER.info(PATTER_LOG, nextCard.getCarteEnum(), nextCard.getCouleur());

        if (nextCard.getValeur() < currentCard.getValeur()) {
            LOGGER.info("CORRECT -> IS LESS");
            return this.correct(cardPanels, currentIndex, cursors, nextIndex);
        }
        else {
            LOGGER.info("WRONG -> YOU DRINK");
            this.wrong(cardPanels, currentIndex, cursors, previousIndex, nextIndex);
        }
        return false;
    }

    private boolean correct(List<JPanel> cardPanels, int currentIndex, List<JLabel> cursors, int nextIndex) {
        cardPanels.get(nextIndex).setBorder(null);
        cursors.get(currentIndex).setIcon(null);
        cursors.get(nextIndex).setIcon(CarteUtils.getIconCursor());

        return true;
    }

    private boolean wrong(List<JPanel> cardPanels, int currentIndex, List<JLabel> cursors, int previousIndex, int nextIndex) {
        cursors.get(currentIndex).setIcon(null);
        cursors.get(previousIndex).setIcon(CarteUtils.getIconCursor());
        cardPanels.get(nextIndex).setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.DARK_GRAY));

        return false;
    }

}
