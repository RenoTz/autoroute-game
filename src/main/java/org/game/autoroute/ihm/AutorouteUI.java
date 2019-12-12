package org.game.autoroute.ihm;

import com.google.common.collect.Lists;
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

public class AutorouteUI extends JFrame {

	private static final long serialVersionUID = -6926173123931888797L;

	private static final Logger log = LoggerFactory.getLogger(AutorouteUI.class);

	private final ActionService actionService;

	private final List<JButton> buttons;

	private final List<CardLayout> cardLayouts;

	private final List<JPanel> cardPanels;

	private final List<JLabel> cursors;

	private int currentIndex;

	private final JLabel lblMessage;

	private final JLabel lblNbGorgees;

	private int nbGorgees;

	private int sens = 1;

	/**
	 * Create the frame.
	 */
	public AutorouteUI() {
		this.actionService = new ActionService();
		this.buttons = Lists.newArrayList();
		this.cardLayouts = Lists.newArrayList();
		this.cardPanels = Lists.newArrayList();
		this.cursors = Lists.newArrayList();
		this.currentIndex = 0;

		this.setTitle("Autoroute");
		this.setForeground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 680);

		final JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 1, 0, 0));

		final JPanel panelCursor = new JPanel();
		panelCursor.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(final ComponentEvent e) {
				panelCursor.setPreferredSize(new Dimension(800, 10));
			}
		});
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
		panelLeft1.add(btnLeft1);
		btnLeft1.setIcon(this.actionService.getImageCard(CarteUtils.jeuDeCartes));
		btnLeft1.addActionListener(nextCard(cardLayoutLeft1, panelLeft1));
		this.buttons.add(btnLeft1);
		this.cardPanels.add(panelLeft1);

		// CARD LEFT 2
		final JPanel panelLeft2 = new JPanel();
		panelCards.add(panelLeft2);
		final CardLayout cardLayoutLeft2 = new CardLayout(0, 0);
		panelLeft2.setLayout(cardLayoutLeft2);
		this.cardLayouts.add(cardLayoutLeft2);

		final JButton btnLeft2 = new JButton();
		panelLeft2.add(btnLeft2);
		btnLeft2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
		btnLeft2.addActionListener(nextCard(cardLayoutLeft2, panelLeft2));
		this.buttons.add(btnLeft2);
		this.cardPanels.add(panelLeft2);

		// PEAGE 1
		final JPanel panelPeage1 = new JPanel();
		panelCards.add(panelPeage1);
		panelPeage1.setLayout(new CardLayout(0,0));

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
		panelMiddle1.add(btnMiddle1);
		btnMiddle1.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
		btnMiddle1.addActionListener(nextCard(cardLayoutMiddle1, panelMiddle1));
		this.buttons.add(btnMiddle1);
		this.cardPanels.add(panelMiddle1);

		// CARD MIDDLE 2
		final JPanel panelMiddle2 = new JPanel();
		panelCards.add(panelMiddle2);
		final CardLayout cardLayoutMiddle2 = new CardLayout(0, 0);
		panelMiddle2.setLayout(cardLayoutMiddle2);
		this.cardLayouts.add(cardLayoutMiddle2);

		final JButton btnMiddle2 = new JButton();
		panelMiddle2.add(btnMiddle2);
		btnMiddle2.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
		btnMiddle2.addActionListener(nextCard(cardLayoutMiddle2, panelMiddle2));
		this.buttons.add(btnMiddle2);
		this.cardPanels.add(panelMiddle2);

		// CARD MIDDLE 3
		final JPanel panelMiddle3 = new JPanel();
		panelCards.add(panelMiddle3);
		final CardLayout cardLayoutMiddle3 = new CardLayout(0, 0);
		panelMiddle3.setLayout(cardLayoutMiddle3);
		this.cardLayouts.add(cardLayoutMiddle3);

		final JButton btnMiddle3 = new JButton();
		panelMiddle3.add(btnMiddle3);
		btnMiddle3.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
		btnMiddle3.addActionListener(nextCard(cardLayoutMiddle3, panelMiddle3));
		this.buttons.add(btnMiddle3);
		this.cardPanels.add(panelMiddle3);

		// PEAGE 2
		final JPanel panelPeage2 = new JPanel();
		panelCards.add(ConstantesUtils.PEAGE, panelPeage2);
		panelPeage2.setLayout(new CardLayout(0,0));

		final JButton btnPeage2 = new JButton();
		btnPeage2.setIcon(new ImageIcon(ConstantesUtils.PEAGE));
		panelPeage2.add(btnPeage2);

		// CARD RIGHT 1
		final JPanel panelRight1 = new JPanel();
		panelCards.add(panelRight1);
		final CardLayout cardLayoutRight1 = new CardLayout(0, 0);
		panelRight1.setLayout(cardLayoutRight1);
		this.cardLayouts.add(cardLayoutRight1);

		final JButton btnRight1 = new JButton();
		panelRight1.add(btnRight1);
		btnRight1.setIcon(new ImageIcon(ConstantesUtils.BACK_CARD_BLUE_V));
		btnRight1.addActionListener(nextCard(cardLayoutRight1, panelRight1));
		this.buttons.add(btnRight1);
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
		btnRight2.addActionListener(nextCard(cardLayoutRight2, panelRight2));
		this.buttons.add(btnRight2);
		this.cardPanels.add(panelRight2);

		final JPanel panelDeck = new JPanel();
		panelDeck.setPreferredSize(new Dimension(800, 60));
		contentPane.add(panelDeck);
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
		contentPane.add(panelMessage);

		this.lblMessage = new JLabel();
		this.lblMessage.setHorizontalAlignment(SwingConstants.TRAILING);
		this.lblMessage.setFont(new Font("Segoe Script", Font.PLAIN, 50));
		panelMessage.add(this.lblMessage);

		final JPanel panelGorgees = new JPanel();
		panelGorgees.setPreferredSize(new Dimension(800, 20));
		contentPane.add(panelGorgees);
		panelGorgees.setLayout(new GridLayout(1, 3, 0, 0));

		final JLabel lblJoueur1 = new JLabel("Joueur 1");
		lblJoueur1.setHorizontalAlignment(SwingConstants.CENTER);
		panelGorgees.add(lblJoueur1);

		this.lblNbGorgees = new JLabel("GORGEES : 0");
		panelGorgees.add(this.lblNbGorgees);
		this.lblNbGorgees.setHorizontalAlignment(SwingConstants.CENTER);

		final JLabel lblJoueur2 = new JLabel("Joueur 2");
		lblJoueur2.setHorizontalAlignment(SwingConstants.CENTER);
		panelGorgees.add(lblJoueur2);

	}

	private ActionListener more() {
		return new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				if (AutorouteUI.this.currentIndex == 6 && AutorouteUI.this.sens == 1
						|| AutorouteUI.this.currentIndex == 0 && AutorouteUI.this.sens == -1) {
					AutorouteUI.this.changementDeSens();
				}
				final boolean more = AutorouteUI.this.actionService.more(CarteUtils.jeuDeCartes,
						AutorouteUI.this.buttons, AutorouteUI.this.cardLayouts, AutorouteUI.this.cardPanels, AutorouteUI.this.currentIndex, AutorouteUI.this.lblMessage,
						AutorouteUI.this.cursors, AutorouteUI.this.sens);
				if (more) {
					AutorouteUI.this.currentIndex++;
					calculNbGorgeesSuccess();

				} else {
					AutorouteUI.this.currentIndex = AutorouteUI.this.currentIndex != 0
							? AutorouteUI.this.currentIndex - 1
							: 0;
					AutorouteUI.this.nbGorgees = AutorouteUI.this.currentIndex == 1
							|| AutorouteUI.this.currentIndex == 4 ? AutorouteUI.this.nbGorgees + 2
									: AutorouteUI.this.nbGorgees + 1;
				}
				updateLabel();
				checkIfWon();
			}

		};
	}

	private ActionListener less() {
		return new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				if (AutorouteUI.this.currentIndex == 6 && AutorouteUI.this.sens == 1
						|| AutorouteUI.this.currentIndex == 0 && AutorouteUI.this.sens == -1) {
					AutorouteUI.this.changementDeSens();
				}
				final boolean less = AutorouteUI.this.actionService.less(CarteUtils.jeuDeCartes,
						AutorouteUI.this.buttons, AutorouteUI.this.currentIndex, AutorouteUI.this.lblMessage,
						AutorouteUI.this.cursors, AutorouteUI.this.sens);
				if (less) {
					AutorouteUI.this.currentIndex++;
					calculNbGorgeesSuccess();
				} else {
					AutorouteUI.this.currentIndex = AutorouteUI.this.currentIndex != 0
							? AutorouteUI.this.currentIndex - 1
							: 0;
					AutorouteUI.this.nbGorgees = AutorouteUI.this.currentIndex == 1
							|| AutorouteUI.this.currentIndex == 4 ? AutorouteUI.this.nbGorgees + 2
									: AutorouteUI.this.nbGorgees + 1;
				}

				updateLabel();
				checkIfWon();
			}

		};
	}

	private ActionListener nextCard(final CardLayout cardLayout, final JPanel panel){
		return new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				cardLayout.next(panel);
			}
		};
	}

	private void calculNbGorgeesSuccess() {
		AutorouteUI.this.nbGorgees = AutorouteUI.this.currentIndex == 2 || AutorouteUI.this.currentIndex == 5
				? AutorouteUI.this.nbGorgees + 1
				: AutorouteUI.this.nbGorgees;
	}

	private void updateLabel() {
		AutorouteUI.this.updateLabelNbGorgees();
		log.info("currentIndex : {}", AutorouteUI.this.currentIndex);
	}

	private void changementDeSens() {
		AutorouteUI.this.sens = AutorouteUI.this.sens == 1 ? -1 : 1;
		AutorouteUI.this.currentIndex = AutorouteUI.this.sens == 1 ? 6 : 0;
		Collections.reverse(AutorouteUI.this.cursors);
		Collections.reverse(AutorouteUI.this.buttons);
		log.info("changement de sens : {}", this.sens == 1 ? "ALLER" : "RETOUR");
	}

	private void updateLabelNbGorgees() {
		AutorouteUI.this.lblNbGorgees.setText("GORGEES : " + AutorouteUI.this.nbGorgees);
	}

	private void checkIfWon() {

		if (this.currentIndex == 6 && this.sens == -1) {
			JOptionPane.showMessageDialog(this, "YOU WON !!!");
		}
	}

	private void initialiserLesJoueurs() {
		// Creation du joueur 1
		final String playerName1 = JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 1 :", "Joueur 1");
		// Creation du joueur 2
		final String playerName2 = JOptionPane.showInputDialog("Veuillez entrer le nom du joueur 2 :", "Joueur 2");
	}

}
