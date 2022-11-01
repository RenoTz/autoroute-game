package org.game.autoroute.utils;

import com.google.common.collect.Lists;
import org.game.autoroute.model.Card;
import org.game.autoroute.model.CardEnum;
import org.game.autoroute.model.ColorEnum;

import javax.swing.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CardUtils {

    private List<Card> cards;
    private final ImageIcon iconCursor;

    public CardUtils() {
        iconCursor = new ImageIcon(ConstantesUtils.CURSOR);
        cards = createCards();
    }

    private List<Card> createCards() {
        cards = Lists.newArrayList();
        // 4 cartes de "AS"
        final Card asCarreau = new Card(CardEnum.AS, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.AS_CARREAU));
        final Card asCoeur = new Card(CardEnum.AS, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.AS_COEUR));
        final Card asPique = new Card(CardEnum.AS, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.AS_PIQUE));
        final Card asTrefle = new Card(CardEnum.AS, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.AS_TREFLE));
        cards.add(asCarreau);
        cards.add(asCoeur);
        cards.add(asPique);
        cards.add(asTrefle);

        // 4 cartes de "DEUX"
        final Card deuxCarreau =
                new Card(CardEnum.DEUX, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.DEUX_CARREAU));
        final Card deuxCoeur = new Card(CardEnum.DEUX, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.DEUX_COEUR));
        final Card deuxPique = new Card(CardEnum.DEUX, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.DEUX_PIQUE));
        final Card deuxTrefle = new Card(CardEnum.DEUX, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.DEUX_TREFLE));
        cards.add(deuxCarreau);
        cards.add(deuxCoeur);
        cards.add(deuxPique);
        cards.add(deuxTrefle);
        // 4 cartes de "TROIS"
        final Card troisCarreau = new Card(CardEnum.TROIS, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.TROIS_CARREAU));
        final Card troisCoeur = new Card(CardEnum.TROIS, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.TROIS_COEUR));
        final Card troisPique = new Card(CardEnum.TROIS, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.TROIS_PIQUE));
        final Card troisTrefle = new Card(CardEnum.TROIS, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.TROIS_TREFLE));
        cards.add(troisCarreau);
        cards.add(troisCoeur);
        cards.add(troisPique);
        cards.add(troisTrefle);
        // 4 cartes de "QUATRE"
        final Card quatreCarreau = new Card(CardEnum.QUATRE, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.QUATRE_CARREAU));
        final Card quatreCoeur = new Card(CardEnum.QUATRE, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.QUATRE_COEUR));
        final Card quatrePique = new Card(CardEnum.QUATRE, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.QUATRE_PIQUE));
        final Card quatreTrefle = new Card(CardEnum.QUATRE, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.QUATRE_TREFLE));
        cards.add(quatreCarreau);
        cards.add(quatreCoeur);
        cards.add(quatrePique);
        cards.add(quatreTrefle);
        // 4 cartes de "CINQ"
        final Card cinqCarreau = new Card(CardEnum.CINQ, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.CINQ_CARREAU));
        final Card cinqCoeur = new Card(CardEnum.CINQ, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.CINQ_COEUR));
        final Card cinqPique = new Card(CardEnum.CINQ, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.CINQ_PIQUE));
        final Card cinqTrefle = new Card(CardEnum.CINQ, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.CINQ_TREFLE));
        cards.add(cinqCarreau);
        cards.add(cinqCoeur);
        cards.add(cinqPique);
        cards.add(cinqTrefle);
        // 4 cartes de "SIX"
        final Card sixCarreau = new Card(CardEnum.SIX, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.SIX_CARREAU));
        final Card sixCoeur = new Card(CardEnum.SIX, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.SIX_COEUR));
        final Card sixPique = new Card(CardEnum.SIX, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.SIX_PIQUE));
        final Card sixTrefle = new Card(CardEnum.SIX, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.SIX_TREFLE));
        cards.add(sixCarreau);
        cards.add(sixCoeur);
        cards.add(sixPique);
        cards.add(sixTrefle);
        // 4 cartes de "SEPT"
        final Card septCarreau = new Card(CardEnum.SEPT, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.SEPT_CARREAU));
        final Card septCoeur = new Card(CardEnum.SEPT, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.SEPT_COEUR));
        final Card septPique = new Card(CardEnum.SEPT, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.SEPT_PIQUE));
        final Card septTrefle = new Card(CardEnum.SEPT, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.SEPT_TREFLE));
        cards.add(septCarreau);
        cards.add(septCoeur);
        cards.add(septPique);
        cards.add(septTrefle);
        // 4 cartes de "HUIT"
        final Card huitCarreau = new Card(CardEnum.HUIT, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.HUIT_CARREAU));
        final Card huitCoeur = new Card(CardEnum.HUIT, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.HUIT_COEUR));
        final Card huitPique = new Card(CardEnum.HUIT, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.HUIT_PIQUE));
        final Card huitTrefle = new Card(CardEnum.HUIT, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.HUIT_TREFLE));
        cards.add(huitCarreau);
        cards.add(huitCoeur);
        cards.add(huitPique);
        cards.add(huitTrefle);
        // 4 cartes de "NEUF"
        final Card neufCarreau = new Card(CardEnum.NEUF, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.NEUF_CARREAU));
        final Card neufCoeur = new Card(CardEnum.NEUF, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.NEUF_COEUR));
        final Card neufPique = new Card(CardEnum.NEUF, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.NEUF_PIQUE));
        final Card neufTrefle = new Card(CardEnum.NEUF, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.NEUF_TREFLE));
        cards.add(neufCarreau);
        cards.add(neufCoeur);
        cards.add(neufPique);
        cards.add(neufTrefle);
        // 4 cartes de "DIX"
        final Card dixCarreau = new Card(CardEnum.DIX, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.DIX_CARREAU));
        final Card dixCoeur = new Card(CardEnum.DIX, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.DIX_COEUR));
        final Card dixPique = new Card(CardEnum.DIX, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.DIX_PIQUE));
        final Card dixTrefle = new Card(CardEnum.DIX, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.DIX_TREFLE));
        cards.add(dixCarreau);
        cards.add(dixCoeur);
        cards.add(dixPique);
        cards.add(dixTrefle);
        // 4 cartes de "VALET"
        final Card valetCarreau = new Card(CardEnum.VALET, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.VALET_CARREAU));
        final Card valetCoeur = new Card(CardEnum.VALET, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.VALET_COEUR));
        final Card valetPique = new Card(CardEnum.VALET, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.VALET_PIQUE));
        final Card valetTrefle = new Card(CardEnum.VALET, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.VALET_TREFLE));
        cards.add(valetCarreau);
        cards.add(valetCoeur);
        cards.add(valetPique);
        cards.add(valetTrefle);
        // 4 cartes de "DAME"
        final Card dameCarreau = new Card(CardEnum.DAME, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.DAME_CARREAU));
        final Card dameCoeur = new Card(CardEnum.DAME, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.DAME_COEUR));
        final Card damePique = new Card(CardEnum.DAME, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.DAME_PIQUE));
        final Card dameTrefle = new Card(CardEnum.DAME, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.DAME_TREFLE));
        cards.add(dameCarreau);
        cards.add(dameCoeur);
        cards.add(damePique);
        cards.add(dameTrefle);
        // 4 cartes de "ROI"
        final Card roiCarreau = new Card(CardEnum.ROI, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.ROI_CARREAU));
        final Card roiCoeur = new Card(CardEnum.ROI, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.ROI_COEUR));
        final Card roiPique = new Card(CardEnum.ROI, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.ROI_PIQUE));
        final Card roiTrefle = new Card(CardEnum.ROI, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.ROI_TREFLE));
        cards.add(roiCarreau);
        cards.add(roiCoeur);
        cards.add(roiPique);
        cards.add(roiTrefle);

        // on mélange les cartes
        melangerJeuDeCartes();

        return cards;
    }

    public Card getNextCard() {
        final Optional<Card> carteOpt = cards.stream().filter(c -> !c.isVisible()).findFirst();

        if (carteOpt.isPresent()) {
            final Card card = carteOpt.get();
            card.setVisible(true);
            return card;
        } else {
            cards.forEach(c -> c.setVisible(false));
            return getNextCard();
        }
    }

    public ImageIcon getIconCursor() {
        return iconCursor;
    }

    private void melangerJeuDeCartes() {
        Collections.shuffle(cards);
        Collections.shuffle(cards);
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }

}
