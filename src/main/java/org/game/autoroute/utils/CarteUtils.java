package org.game.autoroute.utils;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.swing.ImageIcon;
import org.game.autoroute.model.Carte;
import org.game.autoroute.model.CarteEnum;
import org.game.autoroute.model.ColorEnum;

public class CarteUtils
{
    public static List<Carte> jeuDeCartes = Lists.newArrayList();

    private static ImageIcon iconCursor;

    static {
        iconCursor = new ImageIcon(ConstantesUtils.CURSOR);
        creerJeuDeCartes();
    }

    private static void creerJeuDeCartes()
    {
        // 4 cartes de "AS"
        Carte asCarreau = new Carte(CarteEnum.AS, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.AS_CARREAU));
        Carte asCoeur = new Carte(CarteEnum.AS, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.AS_COEUR));
        Carte asPique = new Carte(CarteEnum.AS, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.AS_PIQUE));
        Carte asTrefle = new Carte(CarteEnum.AS, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.AS_TREFLE));
        jeuDeCartes.add(asCarreau);
        jeuDeCartes.add(asCoeur);
        jeuDeCartes.add(asPique);
        jeuDeCartes.add(asTrefle);

        // 4 cartes de "DEUX"
        Carte deuxCarreau =
            new Carte(CarteEnum.DEUX, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.DEUX_CARREAU));
        Carte deuxCoeur = new Carte(CarteEnum.DEUX, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.DEUX_COEUR));
        Carte deuxPique = new Carte(CarteEnum.DEUX, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.DEUX_PIQUE));
        Carte deuxTrefle =
            new Carte(CarteEnum.DEUX, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.DEUX_TREFLE));
        jeuDeCartes.add(deuxCarreau);
        jeuDeCartes.add(deuxCoeur);
        jeuDeCartes.add(deuxPique);
        jeuDeCartes.add(deuxTrefle);
        // 4 cartes de "TROIS"
        Carte troisCarreau =
            new Carte(CarteEnum.TROIS, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.TROIS_CARREAU));
        Carte troisCoeur =
            new Carte(CarteEnum.TROIS, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.TROIS_COEUR));
        Carte troisPique =
            new Carte(CarteEnum.TROIS, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.TROIS_PIQUE));
        Carte troisTrefle =
            new Carte(CarteEnum.TROIS, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.TROIS_TREFLE));
        jeuDeCartes.add(troisCarreau);
        jeuDeCartes.add(troisCoeur);
        jeuDeCartes.add(troisPique);
        jeuDeCartes.add(troisTrefle);
        // 4 cartes de "QUATRE"
        Carte quatreCarreau =
            new Carte(CarteEnum.QUATRE, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.QUATRE_CARREAU));
        Carte quatreCoeur =
            new Carte(CarteEnum.QUATRE, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.QUATRE_COEUR));
        Carte quatrePique =
            new Carte(CarteEnum.QUATRE, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.QUATRE_PIQUE));
        Carte quatreTrefle =
            new Carte(CarteEnum.QUATRE, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.QUATRE_TREFLE));
        jeuDeCartes.add(quatreCarreau);
        jeuDeCartes.add(quatreCoeur);
        jeuDeCartes.add(quatrePique);
        jeuDeCartes.add(quatreTrefle);
        // 4 cartes de "CINQ"
        Carte cinqCarreau =
            new Carte(CarteEnum.CINQ, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.CINQ_CARREAU));
        Carte cinqCoeur = new Carte(CarteEnum.CINQ, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.CINQ_COEUR));
        Carte cinqPique = new Carte(CarteEnum.CINQ, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.CINQ_PIQUE));
        Carte cinqTrefle =
            new Carte(CarteEnum.CINQ, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.CINQ_TREFLE));
        jeuDeCartes.add(cinqCarreau);
        jeuDeCartes.add(cinqCoeur);
        jeuDeCartes.add(cinqPique);
        jeuDeCartes.add(cinqTrefle);
        // 4 cartes de "SIX"
        Carte sixCarreau =
            new Carte(CarteEnum.SIX, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.SIX_CARREAU));
        Carte sixCoeur = new Carte(CarteEnum.SIX, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.SIX_COEUR));
        Carte sixPique = new Carte(CarteEnum.SIX, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.SIX_PIQUE));
        Carte sixTrefle = new Carte(CarteEnum.SIX, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.SIX_TREFLE));
        jeuDeCartes.add(sixCarreau);
        jeuDeCartes.add(sixCoeur);
        jeuDeCartes.add(sixPique);
        jeuDeCartes.add(sixTrefle);
        // 4 cartes de "SEPT"
        Carte septCarreau =
            new Carte(CarteEnum.SEPT, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.SEPT_CARREAU));
        Carte septCoeur = new Carte(CarteEnum.SEPT, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.SEPT_COEUR));
        Carte septPique = new Carte(CarteEnum.SEPT, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.SEPT_PIQUE));
        Carte septTrefle =
            new Carte(CarteEnum.SEPT, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.SEPT_TREFLE));
        jeuDeCartes.add(septCarreau);
        jeuDeCartes.add(septCoeur);
        jeuDeCartes.add(septPique);
        jeuDeCartes.add(septTrefle);
        // 4 cartes de "HUIT"
        Carte huitCarreau =
            new Carte(CarteEnum.HUIT, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.HUIT_CARREAU));
        Carte huitCoeur = new Carte(CarteEnum.HUIT, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.HUIT_COEUR));
        Carte huitPique = new Carte(CarteEnum.HUIT, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.HUIT_PIQUE));
        Carte huitTrefle =
            new Carte(CarteEnum.HUIT, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.HUIT_TREFLE));
        jeuDeCartes.add(huitCarreau);
        jeuDeCartes.add(huitCoeur);
        jeuDeCartes.add(huitPique);
        jeuDeCartes.add(huitTrefle);
        // 4 cartes de "NEUF"
        Carte neufCarreau =
            new Carte(CarteEnum.NEUF, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.NEUF_CARREAU));
        Carte neufCoeur = new Carte(CarteEnum.NEUF, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.NEUF_COEUR));
        Carte neufPique = new Carte(CarteEnum.NEUF, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.NEUF_PIQUE));
        Carte neufTrefle =
            new Carte(CarteEnum.NEUF, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.NEUF_TREFLE));
        jeuDeCartes.add(neufCarreau);
        jeuDeCartes.add(neufCoeur);
        jeuDeCartes.add(neufPique);
        jeuDeCartes.add(neufTrefle);
        // 4 cartes de "DIX"
        Carte dixCarreau =
            new Carte(CarteEnum.DIX, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.DIX_CARREAU));
        Carte dixCoeur = new Carte(CarteEnum.DIX, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.DIX_COEUR));
        Carte dixPique = new Carte(CarteEnum.DIX, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.DIX_PIQUE));
        Carte dixTrefle = new Carte(CarteEnum.DIX, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.DIX_TREFLE));
        jeuDeCartes.add(dixCarreau);
        jeuDeCartes.add(dixCoeur);
        jeuDeCartes.add(dixPique);
        jeuDeCartes.add(dixTrefle);
        // 4 cartes de "VALET"
        Carte valetCarreau =
            new Carte(CarteEnum.VALET, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.VALET_CARREAU));
        Carte valetCoeur =
            new Carte(CarteEnum.VALET, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.VALET_COEUR));
        Carte valetPique =
            new Carte(CarteEnum.VALET, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.VALET_PIQUE));
        Carte valetTrefle =
            new Carte(CarteEnum.VALET, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.VALET_TREFLE));
        jeuDeCartes.add(valetCarreau);
        jeuDeCartes.add(valetCoeur);
        jeuDeCartes.add(valetPique);
        jeuDeCartes.add(valetTrefle);
        // 4 cartes de "DAME"
        Carte dameCarreau =
            new Carte(CarteEnum.DAME, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.DAME_CARREAU));
        Carte dameCoeur = new Carte(CarteEnum.DAME, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.DAME_COEUR));
        Carte damePique = new Carte(CarteEnum.DAME, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.DAME_PIQUE));
        Carte dameTrefle =
            new Carte(CarteEnum.DAME, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.DAME_TREFLE));
        jeuDeCartes.add(dameCarreau);
        jeuDeCartes.add(dameCoeur);
        jeuDeCartes.add(damePique);
        jeuDeCartes.add(dameTrefle);
        // 4 cartes de "ROI"
        Carte roiCarreau =
            new Carte(CarteEnum.ROI, ColorEnum.CARREAU, new ImageIcon(ConstantesUtils.ROI_CARREAU));
        Carte roiCoeur = new Carte(CarteEnum.ROI, ColorEnum.COEUR, new ImageIcon(ConstantesUtils.ROI_COEUR));
        Carte roiPique = new Carte(CarteEnum.ROI, ColorEnum.PIQUE, new ImageIcon(ConstantesUtils.ROI_PIQUE));
        Carte roiTrefle = new Carte(CarteEnum.ROI, ColorEnum.TREFLE, new ImageIcon(ConstantesUtils.ROI_TREFLE));
        jeuDeCartes.add(roiCarreau);
        jeuDeCartes.add(roiCoeur);
        jeuDeCartes.add(roiPique);
        jeuDeCartes.add(roiTrefle);

        // on mélange les cartes
        melangerJeuDeCartes();
    }

    public static Carte getNextCard()
    {
        Optional<Carte> carteOpt = CarteUtils.jeuDeCartes.stream().filter(c -> !c.isVisible()).findFirst();

        if (carteOpt.isPresent()) {
            Carte carte = carteOpt.get();
            carte.setVisible(true);
            return carte;
        } else {
            CarteUtils.jeuDeCartes.forEach(c -> c.setVisible(false));
            return getNextCard();
        }
    }

    public static ImageIcon getIconCursor()
    {
        return iconCursor;
    }

    private static void melangerJeuDeCartes()
    {
        Collections.shuffle(jeuDeCartes);
        Collections.shuffle(jeuDeCartes);
        Collections.shuffle(jeuDeCartes);
    }

}
