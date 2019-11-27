package org.game.autoroute.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AutorouteUI extends JFrame
{

    private final JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(final String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try {
                    final AutorouteUI frame = new AutorouteUI();
                    frame.setVisible(true);
                } catch (final Exception e) {
                    e.printStackTrace();
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
        this.setBounds(100, 100, 634, 514);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.contentPane.setLayout(new BorderLayout(0, 0));
        this.setContentPane(this.contentPane);

        final JPanel panel = new JPanel();
        this.contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(1, 9, 2, 2));

        final JButton btnNewButton = new JButton("New button");
        panel.add(btnNewButton);

        final JButton btnNewButton_1 = new JButton("New button");
        panel.add(btnNewButton_1);

        final JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.setIcon(new ImageIcon(
            "C:\\Users\\r.trezieres\\eclipse-workspace\\autoroute\\src\\main\\resource\\img\\peages.jpg"));
        btnNewButton_2.setSelectedIcon(new ImageIcon(
            "C:\\Users\\r.trezieres\\eclipse-workspace\\autoroute\\src\\main\\resource\\img\\peages.jpg"));
        panel.add(btnNewButton_2);

        final JButton btnNewButton_3 = new JButton("New button");
        panel.add(btnNewButton_3);

        final JButton btnNewButton_4 = new JButton("New button");
        panel.add(btnNewButton_4);

        final JButton btnNewButton_5 = new JButton("New button");
        panel.add(btnNewButton_5);

        final JButton btnNewButton_6 = new JButton("New button");
        btnNewButton_6.setBackground(Color.WHITE);
        btnNewButton_6.setIcon(new ImageIcon(
            "C:\\Users\\r.trezieres\\eclipse-workspace\\autoroute\\src\\main\\resource\\img\\peages.jpg"));
        panel.add(btnNewButton_6);

        final JButton btnNewButton_7 = new JButton("New button");
        panel.add(btnNewButton_7);

        final JButton btnNewButton_8 = new JButton("New button");
        panel.add(btnNewButton_8);

        final JPanel panel_1 = new JPanel();
        this.contentPane.add(panel_1, BorderLayout.SOUTH);
        panel_1.setLayout(new GridLayout(0, 3, 0, 0));

        final JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setEnabled(false);
        panel_1.add(lblNewLabel);

        final JButton btnNewButton_9 = new JButton("New button");
        panel_1.add(btnNewButton_9);

        final JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setEnabled(false);
        panel_1.add(lblNewLabel_1);
    }

}
