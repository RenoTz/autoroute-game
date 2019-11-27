package org.game.autoroute.model;

import javax.swing.ImageIcon;

public class Carte
{

    private final CarteEnum carteEnum;

    private ColorEnum couleur;

    private ImageIcon image;

    public Carte(final CarteEnum carteEnum, final ColorEnum couleur, final ImageIcon image)
    {

        this.carteEnum = carteEnum;
        this.couleur = couleur;
        this.setImage(image);
    }

    public ColorEnum getCouleur()
    {

        return this.couleur;
    }

    public void setCouleur(final ColorEnum couleur)
    {

        this.couleur = couleur;
    }

    public CarteEnum getCarteEnum()
    {

        return this.carteEnum;
    }

    public Integer getValeur()
    {

        return this.carteEnum.getValeur();
    }

    public ImageIcon getImage()
    {
        return this.image;
    }

    public void setImage(final ImageIcon image)
    {
        this.image = image;
    }

    @Override
    public String toString()
    {
        return this.carteEnum.name().concat(" de ".concat(this.couleur.name()));
    }
}
