package org.game.autoroute.utils;

import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

import org.game.autoroute.model.Carte;
import org.game.autoroute.model.CarteEnum;
import org.game.autoroute.model.ColorEnum;

import com.google.common.collect.Lists;

public class CarteUtils
{
    private static final String pathImgResources = "src/main/resources/img/";

    private static final String ext_png = ".png";

    public static List<Carte> creerJeuDeCartes()
    {

        final List<Carte> jeuDeCartes = Lists.newArrayList();
        // 4 cartes de "UN"
        final Carte asCarreau =
            new Carte(CarteEnum.AS, ColorEnum.CARREAU, new ImageIcon(pathImgResources.concat("AD").concat(ext_png)));
        final Carte asCoeur =
            new Carte(CarteEnum.AS, ColorEnum.COEUR, new ImageIcon(pathImgResources.concat("AH").concat(ext_png)));
        final Carte asPique =
            new Carte(CarteEnum.AS, ColorEnum.PIQUE, new ImageIcon(pathImgResources.concat("AS").concat(ext_png)));
        final Carte asTrefle =
            new Carte(CarteEnum.AS, ColorEnum.TREFLE, new ImageIcon(pathImgResources.concat("AC").concat(ext_png)));
        jeuDeCartes.add(asCarreau);
        jeuDeCartes.add(asCoeur);
        jeuDeCartes.add(asPique);
        jeuDeCartes.add(asTrefle);
        // 4 cartes de "DEUX"
        final Carte deuxCarreau =
            new Carte(CarteEnum.DEUX, ColorEnum.CARREAU, new ImageIcon(pathImgResources.concat("2D").concat(ext_png)));
        final Carte deuxCoeur =
            new Carte(CarteEnum.DEUX, ColorEnum.COEUR, new ImageIcon(pathImgResources.concat("2H").concat(ext_png)));
        final Carte deuxPique =
            new Carte(CarteEnum.DEUX, ColorEnum.PIQUE, new ImageIcon(pathImgResources.concat("2S").concat(ext_png)));
        final Carte deuxTrefle =
            new Carte(CarteEnum.DEUX, ColorEnum.TREFLE, new ImageIcon(pathImgResources.concat("2C").concat(ext_png)));
        jeuDeCartes.add(deuxCarreau);
        jeuDeCartes.add(deuxCoeur);
        jeuDeCartes.add(deuxPique);
        jeuDeCartes.add(deuxTrefle);
        // 4 cartes de "TROIS"
        final Carte troisCarreau =
            new Carte(CarteEnum.TROIS, ColorEnum.CARREAU, new ImageIcon(pathImgResources.concat("3D").concat(ext_png)));
        final Carte troisCoeur =
            new Carte(CarteEnum.TROIS, ColorEnum.COEUR, new ImageIcon(pathImgResources.concat("3H").concat(ext_png)));
        final Carte troisPique =
            new Carte(CarteEnum.TROIS, ColorEnum.PIQUE, new ImageIcon(pathImgResources.concat("3S").concat(ext_png)));
        final Carte troisTrefle =
            new Carte(CarteEnum.TROIS, ColorEnum.TREFLE, new ImageIcon(pathImgResources.concat("3C").concat(ext_png)));
        jeuDeCartes.add(troisCarreau);
        jeuDeCartes.add(troisCoeur);
        jeuDeCartes.add(troisPique);
        jeuDeCartes.add(troisTrefle);
        // 4 cartes de "QUATRE"
        final Carte quatreCarreau = new Carte(CarteEnum.QUATRE, ColorEnum.CARREAU,
            new ImageIcon(pathImgResources.concat("4D").concat(ext_png)));
        final Carte quatreCoeur =
            new Carte(CarteEnum.QUATRE, ColorEnum.COEUR, new ImageIcon(pathImgResources.concat("4H").concat(ext_png)));
        final Carte quatrePique =
            new Carte(CarteEnum.QUATRE, ColorEnum.PIQUE, new ImageIcon(pathImgResources.concat("4S").concat(ext_png)));
        final Carte quatreTrefle =
            new Carte(CarteEnum.QUATRE, ColorEnum.TREFLE, new ImageIcon(pathImgResources.concat("4C").concat(ext_png)));
        jeuDeCartes.add(quatreCarreau);
        jeuDeCartes.add(quatreCoeur);
        jeuDeCartes.add(quatrePique);
        jeuDeCartes.add(quatreTrefle);
        // 4 cartes de "CINQ"
        final Carte cinqCarreau =
            new Carte(CarteEnum.CINQ, ColorEnum.CARREAU, new ImageIcon(pathImgResources.concat("5D").concat(ext_png)));
        final Carte cinqCoeur =
            new Carte(CarteEnum.CINQ, ColorEnum.COEUR, new ImageIcon(pathImgResources.concat("5H").concat(ext_png)));
        final Carte cinqPique =
            new Carte(CarteEnum.CINQ, ColorEnum.PIQUE, new ImageIcon(pathImgResources.concat("5S").concat(ext_png)));
        final Carte cinqTrefle =
            new Carte(CarteEnum.CINQ, ColorEnum.TREFLE, new ImageIcon(pathImgResources.concat("5C").concat(ext_png)));
        jeuDeCartes.add(cinqCarreau);
        jeuDeCartes.add(cinqCoeur);
        jeuDeCartes.add(cinqPique);
        jeuDeCartes.add(cinqTrefle);
        // 4 cartes de "SIX"
        final Carte sixCarreau =
            new Carte(CarteEnum.SIX, ColorEnum.CARREAU, new ImageIcon(pathImgResources.concat("6D").concat(ext_png)));
        final Carte sixCoeur =
            new Carte(CarteEnum.SIX, ColorEnum.COEUR, new ImageIcon(pathImgResources.concat("6H").concat(ext_png)));
        final Carte sixPique =
            new Carte(CarteEnum.SIX, ColorEnum.PIQUE, new ImageIcon(pathImgResources.concat("6S").concat(ext_png)));
        final Carte sixTrefle =
            new Carte(CarteEnum.SIX, ColorEnum.TREFLE, new ImageIcon(pathImgResources.concat("6C").concat(ext_png)));
        jeuDeCartes.add(sixCarreau);
        jeuDeCartes.add(sixCoeur);
        jeuDeCartes.add(sixPique);
        jeuDeCartes.add(sixTrefle);
        // 4 cartes de "SEPT"
        final Carte septCarreau =
            new Carte(CarteEnum.SEPT, ColorEnum.CARREAU, new ImageIcon(pathImgResources.concat("7D").concat(ext_png)));
        final Carte septCoeur =
            new Carte(CarteEnum.SEPT, ColorEnum.COEUR, new ImageIcon(pathImgResources.concat("7H").concat(ext_png)));
        final Carte septPique =
            new Carte(CarteEnum.SEPT, ColorEnum.PIQUE, new ImageIcon(pathImgResources.concat("7S").concat(ext_png)));
        final Carte septTrefle =
            new Carte(CarteEnum.SEPT, ColorEnum.TREFLE, new ImageIcon(pathImgResources.concat("7C").concat(ext_png)));
        jeuDeCartes.add(septCarreau);
        jeuDeCartes.add(septCoeur);
        jeuDeCartes.add(septPique);
        jeuDeCartes.add(septTrefle);
        // 4 cartes de "HUIT"
        final Carte huitCarreau =
            new Carte(CarteEnum.HUIT, ColorEnum.CARREAU, new ImageIcon(pathImgResources.concat("8D").concat(ext_png)));
        final Carte huitCoeur =
            new Carte(CarteEnum.HUIT, ColorEnum.COEUR, new ImageIcon(pathImgResources.concat("8H").concat(ext_png)));
        final Carte huitPique =
            new Carte(CarteEnum.HUIT, ColorEnum.PIQUE, new ImageIcon(pathImgResources.concat("8S").concat(ext_png)));
        final Carte huitTrefle =
            new Carte(CarteEnum.HUIT, ColorEnum.TREFLE, new ImageIcon(pathImgResources.concat("8C").concat(ext_png)));
        jeuDeCartes.add(huitCarreau);
        jeuDeCartes.add(huitCoeur);
        jeuDeCartes.add(huitPique);
        jeuDeCartes.add(huitTrefle);
        // 4 cartes de "NEUF"
        final Carte neufCarreau =
            new Carte(CarteEnum.NEUF, ColorEnum.CARREAU, new ImageIcon(pathImgResources.concat("9D").concat(ext_png)));
        final Carte neufCoeur =
            new Carte(CarteEnum.NEUF, ColorEnum.COEUR, new ImageIcon(pathImgResources.concat("9H").concat(ext_png)));
        final Carte neufPique =
            new Carte(CarteEnum.NEUF, ColorEnum.PIQUE, new ImageIcon(pathImgResources.concat("9S").concat(ext_png)));
        final Carte neufTrefle =
            new Carte(CarteEnum.NEUF, ColorEnum.TREFLE, new ImageIcon(pathImgResources.concat("9C").concat(ext_png)));
        jeuDeCartes.add(neufCarreau);
        jeuDeCartes.add(neufCoeur);
        jeuDeCartes.add(neufPique);
        jeuDeCartes.add(neufTrefle);
        // 4 cartes de "DIX"
        final Carte dixCarreau =
            new Carte(CarteEnum.DIX, ColorEnum.CARREAU, new ImageIcon(pathImgResources.concat("10D").concat(ext_png)));
        final Carte dixCoeur =
            new Carte(CarteEnum.DIX, ColorEnum.COEUR, new ImageIcon(pathImgResources.concat("10H").concat(ext_png)));
        final Carte dixPique =
            new Carte(CarteEnum.DIX, ColorEnum.PIQUE, new ImageIcon(pathImgResources.concat("10S").concat(ext_png)));
        final Carte dixTrefle =
            new Carte(CarteEnum.DIX, ColorEnum.TREFLE, new ImageIcon(pathImgResources.concat("10C").concat(ext_png)));
        jeuDeCartes.add(dixCarreau);
        jeuDeCartes.add(dixCoeur);
        jeuDeCartes.add(dixPique);
        jeuDeCartes.add(dixTrefle);
        // 4 cartes de "VALET"
        final Carte valetCarreau =
            new Carte(CarteEnum.VALET, ColorEnum.CARREAU, new ImageIcon(pathImgResources.concat("JD").concat(ext_png)));
        final Carte valetCoeur =
            new Carte(CarteEnum.VALET, ColorEnum.COEUR, new ImageIcon(pathImgResources.concat("JH").concat(ext_png)));
        final Carte valetPique =
            new Carte(CarteEnum.VALET, ColorEnum.PIQUE, new ImageIcon(pathImgResources.concat("JS").concat(ext_png)));
        final Carte valetTrefle =
            new Carte(CarteEnum.VALET, ColorEnum.TREFLE, new ImageIcon(pathImgResources.concat("JC").concat(ext_png)));
        jeuDeCartes.add(valetCarreau);
        jeuDeCartes.add(valetCoeur);
        jeuDeCartes.add(valetPique);
        jeuDeCartes.add(valetTrefle);
        // 4 cartes de "DAME"
        final Carte dameCarreau =
            new Carte(CarteEnum.DAME, ColorEnum.CARREAU, new ImageIcon(pathImgResources.concat("QD").concat(ext_png)));
        final Carte dameCoeur =
            new Carte(CarteEnum.DAME, ColorEnum.COEUR, new ImageIcon(pathImgResources.concat("QH").concat(ext_png)));
        final Carte damePique =
            new Carte(CarteEnum.DAME, ColorEnum.PIQUE, new ImageIcon(pathImgResources.concat("QS").concat(ext_png)));
        final Carte dameTrefle =
            new Carte(CarteEnum.DAME, ColorEnum.TREFLE, new ImageIcon(pathImgResources.concat("QC").concat(ext_png)));
        jeuDeCartes.add(dameCarreau);
        jeuDeCartes.add(dameCoeur);
        jeuDeCartes.add(damePique);
        jeuDeCartes.add(dameTrefle);
        // 4 cartes de "ROI"
        final Carte roiCarreau =
            new Carte(CarteEnum.ROI, ColorEnum.CARREAU, new ImageIcon(pathImgResources.concat("KD").concat(ext_png)));
        final Carte roiCoeur =
            new Carte(CarteEnum.ROI, ColorEnum.COEUR, new ImageIcon(pathImgResources.concat("KH").concat(ext_png)));
        final Carte roiPique =
            new Carte(CarteEnum.ROI, ColorEnum.PIQUE, new ImageIcon(pathImgResources.concat("KS").concat(ext_png)));
        final Carte roiTrefle =
            new Carte(CarteEnum.ROI, ColorEnum.TREFLE, new ImageIcon(pathImgResources.concat("KC").concat(ext_png)));
        jeuDeCartes.add(roiCarreau);
        jeuDeCartes.add(roiCoeur);
        jeuDeCartes.add(roiPique);
        jeuDeCartes.add(roiTrefle);

        // on mélange les cartes
        CarteUtils.melangerJeuDeCartes(jeuDeCartes);
        return jeuDeCartes;
    }

    public Carte getBackCard()
    {
        return new Carte(null, null, new ImageIcon(pathImgResources.concat("red_back").concat(ext_png)));
    }

    public static void melangerJeuDeCartes(final List<Carte> jeuDeCartes)
    {

        Collections.shuffle(jeuDeCartes);
        Collections.shuffle(jeuDeCartes);
        Collections.shuffle(jeuDeCartes);
    }

}
