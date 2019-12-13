package org.game.autoroute.ihm;

import com.google.common.collect.Lists;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import org.game.autoroute.service.ActionService;
import org.game.autoroute.utils.CarteUtils;
import org.game.autoroute.utils.ConstantesUtils;
import org.game.autoroute.utils.SoundUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutorouteUI extends JFrame
{

    private static final long serialVersionUID = -6926173123931888797L;

    private static final Logger log = LoggerFactory.getLogger(AutorouteUI.class);

    private static final String LABEL_MSG_GORGEE = "TU BOIS +%d";

    private ActionService actionService;

    private List<CardLayout> cardLayouts;

    private List<JPanel> cardPanels;

    private List<JLabel> cursors;

    private JLabel lblNbGorgees;

    private JLabel lblMessage;

    private JLabel lblActionIcon;

    private int currentIndex;

    private int nbGorgeesTotal;

    private int serie;

    private int sens = 1;

    private String playerName1;

    private String playerName2;

    /**
     * Create the frame.
     */
    public AutorouteUI()
    {
        this.init();
        this.setup();
    }

    private void init()
    {
        this.actionService = new ActionService();
        this.cardLayouts = Lists.newArrayList();
        this.cardPanels = Lists.newArrayList();
        this.cursors = Lists.newArrayList();
        this.currentIndex = 0;

        this.initialiserLesJoueurs();
    }

    private void setup()
    {
        this.setTitle("Autoroute");
        this.setForeground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 800, 680);

        final JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(5, 1, 0, 0));

        final JPanel panelCursor = new JPanel();
        contentPane.add(panelCursor);
        panelCursor.setLayout(new GridLayout(0, 9, 0, 0));

        final JLabel lblSelectLeft1 = new JLabel();
        lblSelectLeft1.setHorizontalAlignment(SwingConstants.CENTER);
        lblSelectLeft1.setIcon(CarteUtils.getIconCursor());
        panelCursor.add(lblSelectLeft1);
        this.cursors.add(lblSelectLeft1);

        final JLabel lblSelectLeft2 = new JLabel();
        lblSelectLeft2.setHorizontalAlignment(SwingConstants.CENTER);
        panelCursor.add(lblSelectLeft2);
        this.cursors.add(lblSelectLeft2);

        final JLabel lblPeage1 = new JLabel();
        lblPeage1.setEnabled(false);
        panelCursor.add(lblPeage1);

        final JLabel lblSelectMiddle1 = new JLabel();
        lblSelectMiddle1.setHorizontalAlignment(SwingConstants.CENTER);
        panelCursor.add(lblSelectMiddle1);
        this.cursors.add(lblSelectMiddle1);

        final JLabel lblSelectMiddle2 = new JLabel();
        lblSelectMiddle2.setHorizontalAlignment(SwingConstants.CENTER);
        panelCursor.add(lblSelectMiddle2);
        this.cursors.add(lblSelectMiddle2);

        final JLabel lblSelectMiddle3 = new JLabel();
        lblSelectMiddle3.setHorizontalAlignment(SwingConstants.CENTER);
        panelCursor.add(lblSelectMiddle3);
        this.cursors.add(lblSelectMiddle3);

        final JLabel lblPeage2 = new JLabel();
        lblPeage2.setEnabled(false);
        panelCursor.add(lblPeage2);

        final JLabel lblSelectRight1 = new JLabel();
        lblSelectRight1.setHorizontalAlignment(SwingConstants.CENTER);
        panelCursor.add(lblSelectRight1);
        this.cursors.add(lblSelectRight1);

        final JLabel lblSelectRight2 = new JLabel();
        lblSelectRight2.setHorizontalAlignment(SwingConstants.CENTER);
        panelCursor.add(lblSelectRight2);
        this.cursors.add(lblSelectRight2);

        final JPanel panelCards = new JPanel();
        panelCards.setPreferredSize(new Dimension(800, 80));
        contentPane.add(panelCards);
        panelCards.setLayout(new GridLayout(1, 9, 1, 1));

        // CARD LEFT 1
        final JPanel panelLeft1 = new JPanel();
        panelCards.add(panelLeft1);
        final CardLayout cardLayoutLeft1 = new CardLayout(0, 0);
        panelLeft1.setLayout(cardLayoutLeft1);
        this.cardLayouts.add(cardLayoutLeft1);

        final JButton btnLeft1 = new JButton();
        final ImageIcon imageIconCard = this.actionService.getImageCard();
        panelLeft1.add(imageIconCard.toString(), btnLeft1);
        btnLeft1.setIcon(imageIconCard);
        btnLeft1.addActionListener(this.nextCard(cardLayoutLeft1, panelLeft1));
        this.cardPanels.add(panelLeft1);

        // CARD LEFT 2
        final JPanel panelLeft2 = new JPanel();
        panelCards.add(panelLeft2);
        final CardLayout cardLayoutLeft2 = new CardLayout(0, 0);
        panelLeft2.setLayout(cardLayoutLeft2);
        this.cardLayouts.add(cardLayoutLeft2);

        final JButton btnLeft2 = new JButton();
        panelLeft2.add(ConstantesUtils.BACK_CARD_BLUE_V, btnLeft2);
        btnLeft2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnLeft2.addActionListener(this.nextCard(cardLayoutLeft2, panelLeft2));
        this.cardPanels.add(panelLeft2);

        // PEAGE 1
        final JPanel panelPeage1 = new JPanel();
        panelCards.add(panelPeage1);
        panelPeage1.setLayout(new CardLayout(0, 0));

        final JButton btnPeage1 = new JButton();
        btnPeage1.setIcon(new ImageIcon(ConstantesUtils.PEAGE));
        panelPeage1.add(btnPeage1);

        // CARD MIDDLE 1
        final JPanel panelMiddle1 = new JPanel();
        panelCards.add(panelMiddle1);
        final CardLayout cardLayoutMiddle1 = new CardLayout(0, 0);
        panelMiddle1.setLayout(cardLayoutMiddle1);
        this.cardLayouts.add(cardLayoutMiddle1);

        final JButton btnMiddle1 = new JButton();
        panelMiddle1.add(ConstantesUtils.BACK_CARD_BLUE_V, btnMiddle1);
        btnMiddle1.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnMiddle1.addActionListener(this.nextCard(cardLayoutMiddle1, panelMiddle1));
        this.cardPanels.add(panelMiddle1);

        // CARD MIDDLE 2
        final JPanel panelMiddle2 = new JPanel();
        panelCards.add(panelMiddle2);
        final CardLayout cardLayoutMiddle2 = new CardLayout(0, 0);
        panelMiddle2.setLayout(cardLayoutMiddle2);
        this.cardLayouts.add(cardLayoutMiddle2);

        final JButton btnMiddle2 = new JButton();
        panelMiddle2.add(ConstantesUtils.BACK_CARD_BLUE_V, btnMiddle2);
        btnMiddle2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnMiddle2.addActionListener(this.nextCard(cardLayoutMiddle2, panelMiddle2));
        this.cardPanels.add(panelMiddle2);

        // CARD MIDDLE 3
        final JPanel panelMiddle3 = new JPanel();
        panelCards.add(panelMiddle3);
        final CardLayout cardLayoutMiddle3 = new CardLayout(0, 0);
        panelMiddle3.setLayout(cardLayoutMiddle3);
        this.cardLayouts.add(cardLayoutMiddle3);

        final JButton btnMiddle3 = new JButton();
        panelMiddle3.add(ConstantesUtils.BACK_CARD_BLUE_V, btnMiddle3);
        btnMiddle3.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnMiddle3.addActionListener(this.nextCard(cardLayoutMiddle3, panelMiddle3));
        this.cardPanels.add(panelMiddle3);

        // PEAGE 2
        final JPanel panelPeage2 = new JPanel();
        panelCards.add(ConstantesUtils.PEAGE, panelPeage2);
        panelPeage2.setLayout(new CardLayout(0, 0));

        final JButton btnPeage2 = new JButton();
        btnPeage2.setIcon(new ImageIcon(ConstantesUtils.PEAGE));
        panelPeage2.add(btnPeage2);

        // CARD RIGHT 1
        final JPanel panelRight1 = new JPanel();
        panelCards.add(ConstantesUtils.BACK_CARD_BLUE_V, panelRight1);
        final CardLayout cardLayoutRight1 = new CardLayout(0, 0);
        panelRight1.setLayout(cardLayoutRight1);
        this.cardLayouts.add(cardLayoutRight1);

        final JButton btnRight1 = new JButton();
        panelRight1.add(ConstantesUtils.BACK_CARD_BLUE_V, btnRight1);
        btnRight1.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnRight1.addActionListener(this.nextCard(cardLayoutRight1, panelRight1));
        this.cardPanels.add(panelRight1);

        // CARD RIGHT 2
        final JPanel panelRight2 = new JPanel();
        panelCards.add(panelRight2);
        final CardLayout cardLayoutRight2 = new CardLayout(0, 0);
        panelRight2.setLayout(cardLayoutRight2);
        this.cardLayouts.add(cardLayoutRight2);

        final JButton btnRight2 = new JButton();
        panelRight2.add(btnRight2);
        btnRight2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnRight2.addActionListener(this.nextCard(cardLayoutRight2, panelRight2));
        this.cardPanels.add(panelRight2);

        final JPanel panelAction = new JPanel();
        panelAction.setPreferredSize(new Dimension(800, 60));
        contentPane.add(panelAction);
        panelAction.setLayout(new GridLayout(0, 3, 0, 0));

        final JButton btnActionLess = new JButton();
        btnActionLess.setIcon(new ImageIcon(ConstantesUtils.ARROW_DOWN));
        btnActionLess.addActionListener(this.less());
        panelAction.add(btnActionLess);

        this.lblActionIcon = new JLabel();
        this.lblActionIcon.setIcon(new ImageIcon(ConstantesUtils.AU_DEBUT));
        this.lblActionIcon.setHorizontalAlignment(SwingConstants.CENTER);
        panelAction.add(this.lblActionIcon);

        final JButton btnActionMore = new JButton();
        btnActionMore.setIcon(new ImageIcon(ConstantesUtils.ARROW_UP));
        btnActionMore.addActionListener(this.more());
        panelAction.add(btnActionMore);

        final JPanel panelMessage = new JPanel();
        panelMessage.setPreferredSize(new Dimension(800, 40));
        contentPane.add(panelMessage);

        this.lblMessage = new JLabel();
        this.lblMessage.setHorizontalAlignment(SwingConstants.TRAILING);
        this.lblMessage.setFont(new Font("Segoe Script", Font.PLAIN, 50));
        panelMessage.add(this.lblMessage);

        final JPanel panelGorgees = new JPanel();
        panelGorgees.setPreferredSize(new Dimension(800, 20));
        contentPane.add(panelGorgees);
        panelGorgees.setLayout(new GridLayout(1, 3, 0, 0));

        final JLabel lblJoueur1 = new JLabel(this.playerName1);
        lblJoueur1.setHorizontalAlignment(SwingConstants.CENTER);
        panelGorgees.add(lblJoueur1);

        this.lblNbGorgees = new JLabel("GORGEES : 0");
        panelGorgees.add(this.lblNbGorgees);
        this.lblNbGorgees.setHorizontalAlignment(SwingConstants.CENTER);

        final JLabel lblJoueur2 = new JLabel(this.playerName2);
        lblJoueur2.setHorizontalAlignment(SwingConstants.CENTER);
        panelGorgees.add(lblJoueur2);
    }

    private ActionListener more()
    {
        return e -> {
            SoundUtils.playTakeCard();
            this.checkChangementDeSens();
            final boolean more = AutorouteUI.this.actionService
                .more(AutorouteUI.this.cardLayouts, AutorouteUI.this.cardPanels, AutorouteUI.this.currentIndex,
                    AutorouteUI.this.cursors, AutorouteUI.this.sens);
            AutorouteUI.this.postCalculsAndUpdate(more);
        };
    }

    private ActionListener less()
    {
        return e -> {
            SoundUtils.playTakeCard();
            this.checkChangementDeSens();
            final boolean less = AutorouteUI.this.actionService
                .less(AutorouteUI.this.cardLayouts, AutorouteUI.this.cardPanels, AutorouteUI.this.currentIndex,
                    AutorouteUI.this.cursors, AutorouteUI.this.sens);
            this.postCalculsAndUpdate(less);
        };
    }

    private void postCalculsAndUpdate(final boolean success)
    {
        if (success) {
            AutorouteUI.this.currentIndex++;
            AutorouteUI.this.calculNbGorgeesSuccess();
        } else {
            AutorouteUI.this.currentIndex = AutorouteUI.this.currentIndex != 0 ? AutorouteUI.this.currentIndex - 1 : 0;
            this.calculNbGorgeesFailed();
        }
        AutorouteUI.this.updateLabel();
        AutorouteUI.this.checkIfWon();
    }

    private void calculNbGorgeesSuccess()
    {
        // check si le joueur passe un péage : +1 gorgée le cas échéant
        final int nbGorgeesSuppl = this.currentIndex == 2 || this.currentIndex == 5 ? 1 : 0;

        // Affichage nombre de gorgées à boire + maj nbGorgeesTotal
        this.lblMessage.setText(String.format(LABEL_MSG_GORGEE, nbGorgeesSuppl));
        this.nbGorgeesTotal += nbGorgeesSuppl;

        // on incrémente le nombre de série
        this.serie++;
    }

    private void calculNbGorgeesFailed()
    {
        // check si l'échec est dû à l'encontre d'un double : +2 gorgées le cas échéant sinon +1
        final int previousIndex =
            this.currentIndex != this.cardLayouts.size() - 1 ? this.currentIndex + 1 : this.cardLayouts.size() - 2;
        final int beforePreviousIndex =
            previousIndex != this.cardLayouts.size() - 1 ? previousIndex + 1 : this.cardLayouts.size() - 2;

        final JButton previousButton = (JButton) this.cardPanels.get(previousIndex)
            .getComponent(this.cardPanels.get(previousIndex).getComponentCount() - 1);
        final JButton beforePreviousButton = (JButton) this.cardPanels.get(beforePreviousIndex)
            .getComponent(this.cardPanels.get(beforePreviousIndex).getComponentCount() - 1);
        int nbGorgeesSuppl =
            previousButton.getIcon().toString().equals(beforePreviousButton.getIcon().toString()) ? 2 : 1;

        // check si le joueur passe un péage : +1 gorgée le cas échéant
        nbGorgeesSuppl += this.currentIndex == 1 || this.currentIndex == 4 ? 1 : 0;

        // Affichage nombre de gorgées à boire + maj nbGorgeesTotal
        this.lblMessage.setText(String.format(LABEL_MSG_GORGEE, nbGorgeesSuppl));
        this.nbGorgeesTotal += nbGorgeesSuppl;
        // on remet à zéro le nombre de série
        this.serie = 0;

    }

    private ActionListener nextCard(final CardLayout cardLayout, final JPanel panel)
    {
        return e -> cardLayout.next(panel);
    }

    private void updateLabel()
    {
        AutorouteUI.this.updateLabelNbGorgees();
        this.lblActionIcon.setIcon(new ImageIcon(ConstantesUtils.TU_BOIS));
        log.info("currentIndex : {}", AutorouteUI.this.currentIndex);
    }

    private void checkChangementDeSens()
    {
        if (AutorouteUI.this.currentIndex == 6 && AutorouteUI.this.sens == 1
            || AutorouteUI.this.currentIndex == 0 && AutorouteUI.this.sens == -1) {
            AutorouteUI.this.changementDeSens();
        }
    }

    private void changementDeSens()
    {
        this.sens = this.sens == 1 ? -1 : 1;
        this.currentIndex = this.sens == 1 ? 6 : 0;
        Collections.reverse(this.cursors);
        Collections.reverse(this.cardLayouts);
        Collections.reverse(this.cardPanels);
        log.info("changement de sens : {}", this.sens == 1 ? "ALLER" : "RETOUR");
    }

    private void updateLabelNbGorgees()
    {
        this.lblNbGorgees.setText("GORGEES : " + this.nbGorgeesTotal);
    }

    private void checkIfWon()
    {
        if (this.currentIndex == 6 && this.sens == -1) {
            this.lblActionIcon.setIcon(new ImageIcon(ConstantesUtils.SAOUL));
            //            JOptionPane.showMessageDialog(this, "YOU WON !!!");
        }
    }

    private void initialiserLesJoueurs()
    {
        // Creation du joueur 1
        this.playerName1 = JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 1 :", "Joueur 1");
        // Creation du joueur 2
        this.playerName2 = JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 2 :", "Joueur 2");
    }

}
