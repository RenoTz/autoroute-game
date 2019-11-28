package org.game.autoroute.ihm;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.game.autoroute.controller.Autoroute;
import org.game.autoroute.model.Carte;
import org.game.autoroute.service.ActionService;
import org.game.autoroute.utils.ConstantesUtils;

import com.google.common.collect.Lists;

public class AutorouteUI extends JFrame
{

    private static final long serialVersionUID = -6926173123931888797L;

    private final JPanel contentPane;

    private final ActionService actionService;

    private final List<JButton> buttons;

    private final List<Carte> cartes;

    private int currentIndex;

    /**
     * Create the frame.
     */
    public AutorouteUI(final Autoroute autoroute)
    {
        this.actionService = new ActionService();
        this.cartes = autoroute.getJeuDeCartes();
        this.buttons = Lists.newArrayList();
        this.currentIndex = 1;

        this.setTitle("Autoroute");
        this.setForeground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 800, 337);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(new GridLayout(2, 1, 0, 0));

        final JPanel panelCards = new JPanel();
        this.contentPane.add(panelCards);
        panelCards.setLayout(new GridLayout(1, 9, 1, 1));

        final JPanel panel = new JPanel();
        panelCards.add(panel);
        panel.setLayout(new CardLayout(0, 0));

        final JButton btnLeft1 = new JButton();
        panel.add(btnLeft1, "name_178267754051600");
        btnLeft1.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnLeft1.addActionListener(this.takeCard(btnLeft1));
        this.buttons.add(btnLeft1);

        final JPanel panel1 = new JPanel();
        panelCards.add(panel1);
        panel1.setLayout(new CardLayout(0, 0));

        final JButton btnLeft2 = new JButton();
        panel1.add(btnLeft2, "name_178316235153300");
        btnLeft2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnLeft2.addActionListener(this.takeCard(btnLeft2));
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
        btnMiddle1.addActionListener(this.takeCard(btnMiddle1));
        this.buttons.add(btnMiddle1);

        final JPanel panel4 = new JPanel();
        panelCards.add(panel4);
        panel4.setLayout(new CardLayout(0, 0));

        final JButton btnMiddle2 = new JButton();
        panel4.add(btnMiddle2, "name_178461865085600");
        btnMiddle2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnMiddle2.addActionListener(this.takeCard(btnMiddle2));
        this.buttons.add(btnMiddle2);

        final JPanel panel5 = new JPanel();
        panelCards.add(panel5);
        panel5.setLayout(new CardLayout(0, 0));

        final JButton btnMiddle3 = new JButton();
        panel5.add(btnMiddle3, "name_178478241699700");
        btnMiddle3.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnMiddle3.addActionListener(this.takeCard(btnMiddle3));
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
        btnRight1.addActionListener(this.takeCard(btnRight1));
        this.buttons.add(btnRight1);

        final JPanel panel8 = new JPanel();
        panelCards.add(panel8);
        panel8.setLayout(new CardLayout(0, 0));

        final JButton btnRight2 = new JButton();
        panel8.add(btnRight2, "name_178636650147300");
        btnRight2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        btnRight2.addActionListener(this.takeCard(btnRight2));
        this.buttons.add(btnRight2);

        final JPanel panelDeck = new JPanel();
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
    }

    private ActionListener takeCard(final JButton button)
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                AutorouteUI.this.actionService.accept(AutorouteUI.this.cartes, button, AutorouteUI.this.buttons);
            }
        };
    }

    private ActionListener more()
    {
        return new ActionListener()
        {
            @Override
            public void actionPerformed(final ActionEvent e)
            {
                final boolean more = AutorouteUI.this.actionService.more(AutorouteUI.this.cartes,
                    AutorouteUI.this.buttons, AutorouteUI.this.currentIndex);
                if (more) {
                    AutorouteUI.this.currentIndex++;
                }
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
                final boolean less = AutorouteUI.this.actionService.less(AutorouteUI.this.cartes,
                    AutorouteUI.this.buttons, AutorouteUI.this.currentIndex);
                if (less) {
                    AutorouteUI.this.currentIndex++;
                }
            }
        };
    }

}
