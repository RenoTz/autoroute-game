package org.game.autoroute.ihm;

import com.google.common.collect.Lists;
import org.game.autoroute.service.ActionService;
import org.game.autoroute.utils.CardUtils;
import org.game.autoroute.utils.ConstantesUtils;
import org.game.autoroute.utils.SoundUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;

public class AutorouteUI extends JFrame {

    private static Logger log = LoggerFactory.getLogger(AutorouteUI.class);

    private static String LABEL_MSG_GORGEE = "TU BOIS +%d";

    private ActionService actionService;
    private CardUtils cardUtils;
    private List<CardLayout> cardLayouts;
    private List<JPanel> cardPanels;
    private List<JLabel> cursors;
    private JLabel lblNbGorgees;
    private JLabel lblMessage;
    private JLabel lblActionIcon;
    private int currentIndex;
    private int nbGorgeesTotal;
    private int sens = 1;

    private String playerName1;
    private String playerName2;

    public AutorouteUI() {
        init();
        setup();
    }

    private void init() {
        cardUtils = new CardUtils();
        actionService = new ActionService(cardUtils);
        cardLayouts = Lists.newArrayList();
        cardPanels = Lists.newArrayList();
        cursors = Lists.newArrayList();
        currentIndex = 0;

        initialiserLesJoueurs();
    }

    private void setup() {
        setTitle("Autoroute");
        setForeground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 680);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(5, 1, 0, 0));

        JPanel panelCursor = new JPanel();
        contentPane.add(panelCursor);
        panelCursor.setLayout(new GridLayout(0, 9, 0, 0));

        JLabel lblSelectLeft1 = new JLabel();
        lblSelectLeft1.setHorizontalAlignment(SwingConstants.CENTER);
        lblSelectLeft1.setIcon(cardUtils.getIconCursor());
        panelCursor.add(lblSelectLeft1);
        cursors.add(lblSelectLeft1);

        JLabel lblSelectLeft2 = new JLabel();
        lblSelectLeft2.setHorizontalAlignment(SwingConstants.CENTER);
        panelCursor.add(lblSelectLeft2);
        cursors.add(lblSelectLeft2);

        JLabel lblPeage1 = new JLabel();
        lblPeage1.setEnabled(false);
        panelCursor.add(lblPeage1);

        JLabel lblSelectMiddle1 = new JLabel();
        lblSelectMiddle1.setHorizontalAlignment(SwingConstants.CENTER);
        panelCursor.add(lblSelectMiddle1);
        cursors.add(lblSelectMiddle1);

        JLabel lblSelectMiddle2 = new JLabel();
        lblSelectMiddle2.setHorizontalAlignment(SwingConstants.CENTER);
        panelCursor.add(lblSelectMiddle2);
        cursors.add(lblSelectMiddle2);

        JLabel lblSelectMiddle3 = new JLabel();
        lblSelectMiddle3.setHorizontalAlignment(SwingConstants.CENTER);
        panelCursor.add(lblSelectMiddle3);
        cursors.add(lblSelectMiddle3);

        JLabel lblPeage2 = new JLabel();
        lblPeage2.setEnabled(false);
        panelCursor.add(lblPeage2);

        JLabel lblSelectRight1 = new JLabel();
        lblSelectRight1.setHorizontalAlignment(SwingConstants.CENTER);
        panelCursor.add(lblSelectRight1);
        cursors.add(lblSelectRight1);

        JLabel lblSelectRight2 = new JLabel();
        lblSelectRight2.setHorizontalAlignment(SwingConstants.CENTER);
        panelCursor.add(lblSelectRight2);
        cursors.add(lblSelectRight2);

        JPanel panelCards = new JPanel();
        panelCards.setPreferredSize(new Dimension(800, 80));
        contentPane.add(panelCards);
        panelCards.setLayout(new GridLayout(1, 9, 1, 1));

        // CARD LEFT 1
        JPanel panelLeft1 = new JPanel();
        panelCards.add(panelLeft1);
        CardLayout cardLayoutLeft1 = new CardLayout(0, 0);
        panelLeft1.setLayout(cardLayoutLeft1);
        cardLayouts.add(cardLayoutLeft1);

        JButton btnLeft1 = new JButton();
        ImageIcon imageIconCard = actionService.getImageCard(cardUtils);
        panelLeft1.add(imageIconCard.toString(), btnLeft1);
        btnLeft1.setIcon(imageIconCard);
        btnLeft1.addActionListener(nextCard(cardLayoutLeft1, panelLeft1));
        cardPanels.add(panelLeft1);

        // CARD LEFT 2
        JPanel panelLeft2 = new JPanel();
        panelCards.add(panelLeft2);
        CardLayout cardLayoutLeft2 = new CardLayout(0, 0);
        panelLeft2.setLayout(cardLayoutLeft2);
        cardLayouts.add(cardLayoutLeft2);

        JButton btnLeft2 = new JButton();
        panelLeft2.add(ConstantesUtils.BACK_CARD_BLUE_V, btnLeft2);
        btnLeft2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnLeft2.addActionListener(nextCard(cardLayoutLeft2, panelLeft2));
        cardPanels.add(panelLeft2);

        // PEAGE 1
        JPanel panelPeage1 = new JPanel();
        panelCards.add(panelPeage1);
        panelPeage1.setLayout(new CardLayout(0, 0));

        JButton btnPeage1 = new JButton();
        btnPeage1.setIcon(new ImageIcon(ConstantesUtils.PEAGE));
        panelPeage1.add(btnPeage1);

        // CARD MIDDLE 1
        JPanel panelMiddle1 = new JPanel();
        panelCards.add(panelMiddle1);
        CardLayout cardLayoutMiddle1 = new CardLayout(0, 0);
        panelMiddle1.setLayout(cardLayoutMiddle1);
        cardLayouts.add(cardLayoutMiddle1);

        JButton btnMiddle1 = new JButton();
        panelMiddle1.add(ConstantesUtils.BACK_CARD_BLUE_V, btnMiddle1);
        btnMiddle1.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnMiddle1.addActionListener(nextCard(cardLayoutMiddle1, panelMiddle1));
        cardPanels.add(panelMiddle1);

        // CARD MIDDLE 2
        JPanel panelMiddle2 = new JPanel();
        panelCards.add(panelMiddle2);
        CardLayout cardLayoutMiddle2 = new CardLayout(0, 0);
        panelMiddle2.setLayout(cardLayoutMiddle2);
        cardLayouts.add(cardLayoutMiddle2);

        JButton btnMiddle2 = new JButton();
        panelMiddle2.add(ConstantesUtils.BACK_CARD_BLUE_V, btnMiddle2);
        btnMiddle2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnMiddle2.addActionListener(nextCard(cardLayoutMiddle2, panelMiddle2));
        cardPanels.add(panelMiddle2);

        // CARD MIDDLE 3
        JPanel panelMiddle3 = new JPanel();
        panelCards.add(panelMiddle3);
        CardLayout cardLayoutMiddle3 = new CardLayout(0, 0);
        panelMiddle3.setLayout(cardLayoutMiddle3);
        cardLayouts.add(cardLayoutMiddle3);

        JButton btnMiddle3 = new JButton();
        panelMiddle3.add(ConstantesUtils.BACK_CARD_BLUE_V, btnMiddle3);
        btnMiddle3.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnMiddle3.addActionListener(nextCard(cardLayoutMiddle3, panelMiddle3));
        cardPanels.add(panelMiddle3);

        // PEAGE 2
        JPanel panelPeage2 = new JPanel();
        panelCards.add(ConstantesUtils.PEAGE, panelPeage2);
        panelPeage2.setLayout(new CardLayout(0, 0));

        JButton btnPeage2 = new JButton();
        btnPeage2.setIcon(new ImageIcon(ConstantesUtils.PEAGE));
        panelPeage2.add(btnPeage2);

        // CARD RIGHT 1
        JPanel panelRight1 = new JPanel();
        panelCards.add(ConstantesUtils.BACK_CARD_BLUE_V, panelRight1);
        CardLayout cardLayoutRight1 = new CardLayout(0, 0);
        panelRight1.setLayout(cardLayoutRight1);
        cardLayouts.add(cardLayoutRight1);

        JButton btnRight1 = new JButton();
        panelRight1.add(ConstantesUtils.BACK_CARD_BLUE_V, btnRight1);
        btnRight1.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnRight1.addActionListener(nextCard(cardLayoutRight1, panelRight1));
        cardPanels.add(panelRight1);

        // CARD RIGHT 2
        JPanel panelRight2 = new JPanel();
        panelCards.add(panelRight2);
        CardLayout cardLayoutRight2 = new CardLayout(0, 0);
        panelRight2.setLayout(cardLayoutRight2);
        cardLayouts.add(cardLayoutRight2);

        JButton btnRight2 = new JButton();
        panelRight2.add(btnRight2);
        btnRight2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnRight2.addActionListener(nextCard(cardLayoutRight2, panelRight2));
        cardPanels.add(panelRight2);

        JPanel panelAction = new JPanel();
        panelAction.setPreferredSize(new Dimension(800, 60));
        contentPane.add(panelAction);
        panelAction.setLayout(new GridLayout(0, 3, 0, 0));

        JButton btnActionLess = new JButton();
        btnActionLess.setIcon(new ImageIcon(ConstantesUtils.ARROW_DOWN));
        btnActionLess.addActionListener(less());
        panelAction.add(btnActionLess);

        lblActionIcon = new JLabel();
        lblActionIcon.setIcon(new ImageIcon(ConstantesUtils.AU_DEBUT));
        lblActionIcon.setHorizontalAlignment(SwingConstants.CENTER);
        panelAction.add(lblActionIcon);

        JButton btnActionMore = new JButton();
        btnActionMore.setIcon(new ImageIcon(ConstantesUtils.ARROW_UP));
        btnActionMore.addActionListener(more());
        panelAction.add(btnActionMore);

        JPanel panelMessage = new JPanel();
        panelMessage.setPreferredSize(new Dimension(800, 40));
        contentPane.add(panelMessage);

        lblMessage = new JLabel();
        lblMessage.setHorizontalAlignment(SwingConstants.TRAILING);
        lblMessage.setFont(new Font("Segoe Script", Font.PLAIN, 50));
        panelMessage.add(lblMessage);

        JPanel panelGorgees = new JPanel();
        panelGorgees.setPreferredSize(new Dimension(800, 20));
        contentPane.add(panelGorgees);
        panelGorgees.setLayout(new GridLayout(1, 3, 0, 0));

        JLabel lblJoueur1 = new JLabel(playerName1);
        lblJoueur1.setHorizontalAlignment(SwingConstants.CENTER);
        panelGorgees.add(lblJoueur1);

        lblNbGorgees = new JLabel("GORGEES : 0");
        panelGorgees.add(lblNbGorgees);
        lblNbGorgees.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblJoueur2 = new JLabel(playerName2);
        lblJoueur2.setHorizontalAlignment(SwingConstants.CENTER);
        panelGorgees.add(lblJoueur2);
    }

    private ActionListener more() {
        return e -> {
            SoundUtils.play();
            checkChangementDeSens();
            postCalculsAndUpdate(actionService.more(cardLayouts, cardPanels, currentIndex, cursors, sens));
        };
    }

    private ActionListener less() {
        return e -> {
            SoundUtils.play();
            checkChangementDeSens();
            postCalculsAndUpdate(actionService.less(cardLayouts, cardPanels, currentIndex, cursors, sens));
        };
    }

    private void postCalculsAndUpdate(boolean success) {
        if (success) {
            currentIndex++;
            calculNbGorgeesSuccess();
        } else {
            currentIndex = currentIndex != 0 ? currentIndex - 1 : 0;
            calculNbGorgeesFailed();
        }
        updateLabel();
        checkIfWon();
    }

    private void calculNbGorgeesSuccess() {
        // check si le joueur passe un péage : +1 gorgée le cas échéant
        int nbGorgeesSuppl = currentIndex == 2 || currentIndex == 5 ? 1 : 0;

        // Affichage nombre de gorgées à boire + maj nbGorgeesTotal
        lblMessage.setText(String.format(LABEL_MSG_GORGEE, nbGorgeesSuppl));
        nbGorgeesTotal += nbGorgeesSuppl;
    }

    private void calculNbGorgeesFailed() {
        // check si l'échec est dû à l'encontre d'un double : +2 gorgées le cas échéant sinon +1
        int previousIndex = currentIndex != cardLayouts.size() - 1 ? currentIndex + 1 : cardLayouts.size() - 2;
        int beforePreviousIndex = previousIndex != cardLayouts.size() - 1 ? previousIndex + 1 : cardLayouts.size() - 2;

        JButton previousButton = (JButton) cardPanels.get(previousIndex).getComponent(cardPanels.get(previousIndex).getComponentCount() - 1);
        JButton beforePreviousButton = (JButton) cardPanels.get(beforePreviousIndex).getComponent(cardPanels.get(beforePreviousIndex).getComponentCount() - 1);
        int nbGorgeesSuppl = previousButton.getIcon().toString().equals(beforePreviousButton.getIcon().toString()) ? 2 : 1;

        // check si le joueur passe un péage : +1 gorgée le cas échéant
        nbGorgeesSuppl += currentIndex == 1 || currentIndex == 4 ? 1 : 0;

        // Affichage nombre de gorgées à boire + maj nbGorgeesTotal
        lblMessage.setText(String.format(LABEL_MSG_GORGEE, nbGorgeesSuppl));
        nbGorgeesTotal += nbGorgeesSuppl;
    }

    private ActionListener nextCard(CardLayout cardLayout, JPanel panel) {
        return e -> cardLayout.next(panel);
    }

    private void updateLabel() {
        updateLabelNbGorgees();
        lblActionIcon.setIcon(new ImageIcon(ConstantesUtils.TU_BOIS));
        log.info("currentIndex : {}", currentIndex);
    }

    private void checkChangementDeSens() {
        if (currentIndex == 6 && sens == 1 || currentIndex == 0 && sens == -1) {
            changementDeSens();
        }
    }

    private void changementDeSens() {
        sens = -sens;
        currentIndex = sens == 1 ? 6 : 0;
        Collections.reverse(cursors);
        Collections.reverse(cardLayouts);
        Collections.reverse(cardPanels);
        log.info("changement de sens : {}", sens == 1 ? "ALLER" : "RETOUR");
    }

    private void updateLabelNbGorgees() {
        lblNbGorgees.setText("GORGEES : " + nbGorgeesTotal);
    }

    private void checkIfWon() {
        if (currentIndex == 6 && sens == -1) {
            lblActionIcon.setIcon(new ImageIcon(ConstantesUtils.SAOUL));
            JOptionPane.showMessageDialog(this, "YOU WON !!!");
        }
    }

    private void initialiserLesJoueurs() {
        // Creation du joueur 1
        playerName1 = JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 1 :", "Joueur 1");
        // Creation du joueur 2
        playerName2 = JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 2 :", "Joueur 2");
    }

}
