package org.game.autoroute.ihm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.game.autoroute.utils.ConstantesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutorouteUI extends JFrame
{

    private static final long serialVersionUID = -7016570646412401206L;

    private static final Logger log = LoggerFactory.getLogger(AutorouteUI.class);

    private final JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(final String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    final AutorouteUI frame = new AutorouteUI();
                    frame.setVisible(true);
                } catch (final Exception e) {
                    log.error(e.getMessage(), e);
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AutorouteUI()
    {
        this.setTitle("Autoroute");
        this.setForeground(Color.WHITE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 765, 337);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(this.contentPane);
        this.contentPane.setLayout(new GridLayout(2, 1, 0, 0));

        final JPanel panelCards = new JPanel();
        this.contentPane.add(panelCards);
        panelCards.setLayout(new GridLayout(1, 9, 1, 1));

        final JButton btnLeft1 = new JButton("");
        btnLeft1.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        panelCards.add(btnLeft1);

        final JButton btnLeft2 = new JButton("");
        btnLeft2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        panelCards.add(btnLeft2);

        final JButton btnPeage1 = new JButton("");
        btnPeage1.setIcon(new ImageIcon(ConstantesUtils.PEAGE));
        panelCards.add(btnPeage1);

        final JButton btnMiddle1 = new JButton("");
        btnMiddle1.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        panelCards.add(btnMiddle1);

        final JButton btnMiddle2 = new JButton("");
        btnMiddle2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        panelCards.add(btnMiddle2);

        final JButton btnMiddle3 = new JButton("");
        btnMiddle3.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        panelCards.add(btnMiddle3);

        final JButton btnPeage2 = new JButton("");
        btnPeage2.setIcon(new ImageIcon(ConstantesUtils.PEAGE));
        panelCards.add(btnPeage2);

        final JButton btnRight1 = new JButton("");
        btnRight1.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        panelCards.add(btnRight1);

        final JButton btnRight2 = new JButton("");
        btnRight2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
        panelCards.add(btnRight2);

        final JPanel panelDeck = new JPanel();
        this.contentPane.add(panelDeck);
        panelDeck.setLayout(new GridLayout(0, 3, 0, 0));

        final JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panelDeck.add(lblNewLabel);

        final JButton btnDeck = new JButton("");
        btnDeck.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_H));
        panelDeck.add(btnDeck);

        final JLabel lblNewLabel_1 = new JLabel("");
        panelDeck.add(lblNewLabel_1);
    }

}
