package org.game.autoroute.model;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.game.autoroute.utils.ConstantesUtils;

public class Carte implements Serializable
{

    private static final long serialVersionUID = -7368611572002865056L;

    private final CarteEnum carteEnum;

    private ColorEnum couleur;

    private ImageIcon image;

    private boolean visible;

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
        return this.isVisible() ? this.image : new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V);
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

    public boolean isVisible()
    {
        return this.visible;
    }

    public void setVisible(final boolean visible)
    {
        this.visible = visible;
    }

    public JButton addCard(final CardLayout cardLayout, final JPanel panel) {

        final JButton button = new JButton();
        button.setIcon(getImage());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                cardLayout.next(panel);
            }
        });
        panel.add(getImage().toString(), button);
        button.doClick();
        return button;
    }
}
