package org.game.autoroute.service;

import com.google.common.collect.Iterables;
import org.game.autoroute.model.Card;
import org.game.autoroute.utils.CardUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class ActionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActionService.class);
    private static final String PATTER_LOG = "{} de {}";

    private final CardUtils cardUtils;

    public ActionService(CardUtils cardUtils) {
        this.cardUtils = cardUtils;
    }

    public ImageIcon getImageCard(CardUtils cardUtils) {
        Card card = cardUtils.getNextCard();
        card.setVisible(true);
        LOGGER.info(PATTER_LOG, card.getCarteEnum(), card.getCouleur());
        return card.getImage();
    }

    private Card getCurrentCard(JButton currentButtnon) {
        Card card = cardUtils.getCards()
                .stream()
                .filter(c -> c.getImage().equals(currentButtnon.getIcon()))
                .findFirst()
                .orElse(null);
        if (Objects.isNull(card)) {
            LOGGER.error("Plus de cartes. On reprends un nouveau jeu de cartes.");
            cardUtils.getCards().forEach(c -> c.setVisible(false));
            card = Iterables.getFirst(cardUtils.getCards(), null);
        }
        return card;
    }

    public boolean more(List<CardLayout> cardLayouts, List<JPanel> cardPanels, int currentIndex, List<JLabel> cursors, int sens) {
        JButton currentButtnon =
                (JButton) cardPanels.get(currentIndex).getComponent(cardPanels.get(currentIndex).getComponentCount() - 1);
        Card currentCard = this.getCurrentCard(currentButtnon);
        Card nextCard = cardUtils.getNextCard();
        nextCard.setVisible(true);

        int previousIndex = currentIndex != 0 ? currentIndex - 1 : (sens == -1 ? 6 : 0);
        int nextIndex = currentIndex != cardLayouts.size() - 1 ? currentIndex + 1 : 0;

        JButton nextCardButton = nextCard.addCard(cardLayouts.get(nextIndex), cardPanels.get(nextIndex));
        cardPanels.get(nextIndex).add(nextCardButton.getIcon().toString(), nextCardButton);
        nextCardButton.doClick();

        LOGGER.info(PATTER_LOG, nextCard.getCarteEnum(), nextCard.getCouleur());

        if (nextCard.getValeur() > currentCard.getValeur()) {
            LOGGER.info("TRUE -> IS MORE");
            return correct(cardPanels, currentIndex, cursors, nextIndex);
        } else {
            LOGGER.info("WRONG -> YOU DRINK");
            return wrong(cardPanels, currentIndex, cursors, previousIndex, nextIndex);
        }
    }

    public boolean less(List<CardLayout> cardLayouts, List<JPanel> cardPanels, int currentIndex, List<JLabel> cursors, int sens) {
        JButton currentButtnon =
                (JButton) cardPanels.get(currentIndex).getComponent(cardPanels.get(currentIndex).getComponentCount() - 1);
        Card currentCard = this.getCurrentCard(currentButtnon);
        Card nextCard = cardUtils.getNextCard();
        nextCard.setVisible(true);

        int previousIndex = currentIndex != 0 ? currentIndex - 1 : (sens == -1 ? 6 : 0);
        int nextIndex = currentIndex != cardLayouts.size() - 1 ? currentIndex + 1 : 0;

        //        buttons.get(nextIndex).setIcon(nextCard.getImage());
        JButton nextCardButton = nextCard.addCard(cardLayouts.get(nextIndex), cardPanels.get(nextIndex));
        cardPanels.get(nextIndex).add(nextCardButton.getIcon().toString(), nextCardButton);
        nextCardButton.doClick();
        LOGGER.info(PATTER_LOG, nextCard.getCarteEnum(), nextCard.getCouleur());

        if (nextCard.getValeur() < currentCard.getValeur()) {
            LOGGER.info("TRUE -> IS LESS");
            return this.correct(cardPanels, currentIndex, cursors, nextIndex);
        } else {
            LOGGER.info("WRONG -> YOU DRINK");
            this.wrong(cardPanels, currentIndex, cursors, previousIndex, nextIndex);
        }
        return false;
    }

    private boolean correct(List<JPanel> cardPanels, int currentIndex, List<JLabel> cursors, int nextIndex) {
        cardPanels.get(nextIndex).setBorder(null);
        cursors.get(currentIndex).setIcon(null);
        cursors.get(nextIndex).setIcon(cardUtils.getIconCursor());

        return true;
    }

    private boolean wrong(List<JPanel> cardPanels, int currentIndex, List<JLabel> cursors, int previousIndex, int nextIndex) {
        cursors.get(currentIndex).setIcon(null);
        cursors.get(previousIndex).setIcon(cardUtils.getIconCursor());
        cardPanels.get(nextIndex).setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.DARK_GRAY));

        return false;
    }

}
