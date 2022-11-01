package org.game.autoroute.model;

public enum CardEnum
{
    AS(14), DEUX(2), TROIS(3), QUATRE(4), CINQ(5), SIX(6), SEPT(7), HUIT(8), NEUF(9), DIX(10), VALET(11), DAME(12), ROI(
    13);

    private final Integer valeur;

    private CardEnum(final Integer valeur)
    {
        this.valeur = valeur;
    }

    public Integer getValeur()
    {
        return this.valeur;
    }
}
