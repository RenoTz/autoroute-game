package org.game.autoroute.ihm;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

public class AutorouteUI extends JFrame
{

    private static final long serialVersionUID = -6926173123931888797L;

    private static final Logger log = LoggerFactory.getLogger(AutorouteUI.class);

    private final JPanel contentPane;

    private final ActionService actionService;

    private final List<JButton> buttons;

    private final List<JLabel> cursors;

    private int currentIndex;

    private final JLabel lblMessage;

    private final JLabel lblNbGorgees;

    private int nbGorgees;

    private final ActionListener takeFirstCard;

    private int sens = 1;

    /**
     * Create the frame.
     */
    public AutorouteUI()
    {
        this.actionService = new ActionService();
        this.buttons = Lists.newArrayList();
        this.cursors = Lists.newArrayList();
        this.currentIndex = 0;

        this.setTitle("Autoroute");
        this.setForeground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 800, 680);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(new GridLayout(5, 1, 0, 0));

        final JPanel panelCursor = new JPanel();
        panelCursor.addComponentListener(new ComponentAdapter()
        {
            @Override
            public void componentResized(final ComponentEvent e)
            {
                panelCursor.setPreferredSize(new Dimension(800, 10));
            }
        });
        this.contentPane.add(panelCursor);
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
        this.contentPane.add(panelCards);
        panelCards.setLayout(new GridLayout(1, 9, 1, 1));

        final JPanel panel = new JPanel();
        panelCards.add(panel);
        panel.setLayout(new CardLayout(0, 0));

        final JButton btnLeft1 = new JButton();
        panel.add(btnLeft1, "name_178267754051600");
        btnLeft1.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));

        this.takeFirstCard = new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                AutorouteUI.this.actionService.prendreCarte(CarteUtils.jeuDeCartes, btnLeft1);
            }
        };
        btnLeft1.addActionListener(this.takeFirstCard);
        this.buttons.add(btnLeft1);

        final JPanel panel1 = new JPanel();
        panelCards.add(panel1);
        panel1.setLayout(new CardLayout(0, 0));

        final JButton btnLeft2 = new JButton();
        panel1.add(btnLeft2, "name_178316235153300");
        btnLeft2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        this.buttons.add(btnLeft2);

        final JPanel panel2 = new JPanel();
        panelCards.add(panel2);
        panel2.setLayout(new CardLayout(0, 0));

        final JButton btnPeage1 = new JButton();
        btnPeage1.setIcon(new ImageIcon(ConstantesUtils.PEAGE));
        panel2.add(btnPeage1, "name_178975369160500");

        final JPanel panel3 = new JPanel();
        panelCards.add(panel3);
        panel3.setLayout(new CardLayout(0, 0));

        final JButton btnMiddle1 = new JButton();
        panel3.add(btnMiddle1, "name_178440026501400");
        btnMiddle1.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        this.buttons.add(btnMiddle1);

        final JPanel panel4 = new JPanel();
        panelCards.add(panel4);
        panel4.setLayout(new CardLayout(0, 0));

        final JButton btnMiddle2 = new JButton();
        panel4.add(btnMiddle2, "name_178461865085600");
        btnMiddle2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        this.buttons.add(btnMiddle2);

        final JPanel panel5 = new JPanel();
        panelCards.add(panel5);
        panel5.setLayout(new CardLayout(0, 0));

        final JButton btnMiddle3 = new JButton();
        panel5.add(btnMiddle3, "name_178478241699700");
        btnMiddle3.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        this.buttons.add(btnMiddle3);

        final JPanel panel6 = new JPanel();
        panelCards.add(panel6);
        panel6.setLayout(new CardLayout(0, 0));

        final JButton btnPeage2 = new JButton();
        btnPeage2.setIcon(new ImageIcon(ConstantesUtils.PEAGE));
        panel6.add(btnPeage2, "name_179321399766500");

        final JPanel panel7 = new JPanel();
        panelCards.add(panel7);
        panel7.setLayout(new CardLayout(0, 0));

        final JButton btnRight1 = new JButton();
        panel7.add(btnRight1, "name_178624505634100");
        btnRight1.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        this.buttons.add(btnRight1);

        final JPanel panel8 = new JPanel();
        panelCards.add(panel8);
        panel8.setLayout(new CardLayout(0, 0));

        final JButton btnRight2 = new JButton();
        panel8.add(btnRight2, "name_178636650147300");
        btnRight2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        this.buttons.add(btnRight2);

        final JPanel panelDeck = new JPanel();
        panelDeck.setPreferredSize(new Dimension(800, 60));
        this.contentPane.add(panelDeck);
        panelDeck.setLayout(new GridLayout(0, 3, 0, 0));

        final JButton btnDown = new JButton();
        btnDown.setIcon(new ImageIcon(ConstantesUtils.ARROW_DOWN));
        btnDown.addActionListener(this.less());
        panelDeck.add(btnDown);

        final JButton btnDeck = new JButton();
        btnDeck.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_H));
        panelDeck.add(btnDeck);

        final JButton btnUp = new JButton();
        btnUp.setIcon(new ImageIcon(ConstantesUtils.ARROW_UP));
        btnUp.addActionListener(this.more());
        panelDeck.add(btnUp);

        final JPanel panelMessage = new JPanel();
        panelMessage.setPreferredSize(new Dimension(800, 40));
        this.contentPane.add(panelMessage);

        this.lblMessage = new JLabel();
        this.lblMessage.setHorizontalAlignment(SwingConstants.TRAILING);
        this.lblMessage.setFont(new Font("Segoe Script", Font.PLAIN, 50));
        panelMessage.add(this.lblMessage);

        final JPanel panelGorgees = new JPanel();
        panelGorgees.setPreferredSize(new Dimension(800, 20));
        this.contentPane.add(panelGorgees);

        this.lblNbGorgees = new JLabel("GORGEES : 0");
        panelGorgees.add(this.lblNbGorgees);
        this.lblNbGorgees.setHorizontalAlignment(SwingConstants.CENTER);

        btnLeft1.doClick();
        btnLeft1.removeActionListener(this.takeFirstCard);
    }

    private ActionListener more()
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                if (AutorouteUI.this.currentIndex == 6 && AutorouteUI.this.sens == 1
                    || AutorouteUI.this.currentIndex == 0 && AutorouteUI.this.sens == -1) {
                    AutorouteUI.this.changementDeSens();
                }
                final boolean more = AutorouteUI.this.actionService.more(CarteUtils.jeuDeCartes,
                    AutorouteUI.this.buttons, AutorouteUI.this.currentIndex, AutorouteUI.this.lblMessage,
                    AutorouteUI.this.cursors, AutorouteUI.this.sens);
                if (more) {
                    AutorouteUI.this.currentIndex++;
                    AutorouteUI.this.nbGorgees =
                        AutorouteUI.this.currentIndex == 2 || AutorouteUI.this.currentIndex == 5
                            ? AutorouteUI.this.nbGorgees + 1 : AutorouteUI.this.nbGorgees;

                } else {
                    AutorouteUI.this.currentIndex =
                        AutorouteUI.this.currentIndex != 0 ? AutorouteUI.this.currentIndex - 1 : 0;
                    AutorouteUI.this.nbGorgees =
                        AutorouteUI.this.currentIndex == 1 || AutorouteUI.this.currentIndex == 4
                            ? AutorouteUI.this.nbGorgees + 2 : AutorouteUI.this.nbGorgees + 1;
                }
                AutorouteUI.this.updateLabelNbGorgees();
                log.info("currentIndex : {}", AutorouteUI.this.currentIndex);
                AutorouteUI.this.checkIfWon();
            }

        };
    }

    private ActionListener less()
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                if (AutorouteUI.this.currentIndex == 6 && AutorouteUI.this.sens == 1
                    || AutorouteUI.this.currentIndex == 0 && AutorouteUI.this.sens == -1) {
                    AutorouteUI.this.changementDeSens();
                }
                final boolean less = AutorouteUI.this.actionService.less(CarteUtils.jeuDeCartes,
                    AutorouteUI.this.buttons, AutorouteUI.this.currentIndex, AutorouteUI.this.lblMessage,
                    AutorouteUI.this.cursors, AutorouteUI.this.sens);
                if (less) {
                    AutorouteUI.this.currentIndex++;
                    AutorouteUI.this.nbGorgees =
                        AutorouteUI.this.currentIndex == 2 || AutorouteUI.this.currentIndex == 5
                            ? AutorouteUI.this.nbGorgees + 1 : AutorouteUI.this.nbGorgees;
                } else {
                    AutorouteUI.this.currentIndex =
                        AutorouteUI.this.currentIndex != 0 ? AutorouteUI.this.currentIndex - 1 : 0;
                    AutorouteUI.this.nbGorgees =
                        AutorouteUI.this.currentIndex == 1 || AutorouteUI.this.currentIndex == 4
                            ? AutorouteUI.this.nbGorgees + 2 : AutorouteUI.this.nbGorgees + 1;
                }

                AutorouteUI.this.updateLabelNbGorgees();
                log.info("currentIndex : {}", AutorouteUI.this.currentIndex);
                AutorouteUI.this.checkIfWon();
            }
        };
    }

    private void changementDeSens()
    {
        AutorouteUI.this.sens = AutorouteUI.this.sens == 1 ? -1 : 1;
        AutorouteUI.this.currentIndex = 0;
        Collections.reverse(AutorouteUI.this.cursors);
        Collections.reverse(AutorouteUI.this.buttons);
        log.info("changement de sens : {}", this.sens == 1 ? "ALLER" : "RETOUR");
    }

    private void updateLabelNbGorgees()
    {
        AutorouteUI.this.lblNbGorgees.setText("GORGEES : " + AutorouteUI.this.nbGorgees);
    }

    private void checkIfWon()
    {

        if (this.currentIndex == 6 && this.sens == -1) {
            JOptionPane.showMessageDialog(this, "YOU WON !!!");
        }
    }

}
