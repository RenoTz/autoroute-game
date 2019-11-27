package org.game.autoroute.controller;

import java.util.List;

import org.game.autoroute.model.Carte;
import org.game.autoroute.utils.CarteUtils;

public class Autoroute
{

    private final List<Carte> jeuDeCartes;

    public Autoroute()
    {
        this.jeuDeCartes = CarteUtils.creerJeuDeCartes();
    }

    public List<Carte> getJeuDeCartes()
    {
        return jeuDeCartes;
    }

}
