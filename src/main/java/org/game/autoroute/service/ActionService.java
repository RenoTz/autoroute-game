package org.game.autoroute.service;

import java.io.Serializable;
import java.util.List;

import javax.swing.JButton;

import org.game.autoroute.model.Carte;
import org.game.autoroute.utils.CarteUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActionService implements Serializable
{

    private static final long serialVersionUID = -7337095939630436762L;

    private static final Logger log = LoggerFactory.getLogger(ActionService.class);

    public void accept(final List<Carte> cartes, final JButton button, final List<JButton> buttons)
    {
        final int indexPrec = buttons.indexOf(button) != 0 ? buttons.indexOf(button) - 1 : 0;

        if (buttons.indexOf(button) == 0 || !buttons.get(indexPrec).getIcon().toString().equals(button.getIcon().toString())) {
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

}
