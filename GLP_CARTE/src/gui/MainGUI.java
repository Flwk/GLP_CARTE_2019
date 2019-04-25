package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import carte.Table;
import traitement.Init;
import traitement.PlayerAction;
import traitement.TurnManagement;
import carte.picturePath;
import carte.Card;
import carte.Game;
import carte.Posibility;

/**
 * @author Bilal / Nadir / Cl�ment
 *
 */
public class MainGUI {
	int gameId = 0;
	private JFrame frame;
	Table table;
	int i = 0;
	private JButton button_2;

	private ArrayList<JButton> listButton = new ArrayList<JButton>();
	private PanelImage pannel = new PanelImage();
	private JPanel pan = new JPanel();
	private ArrayList<String> cards = new ArrayList<String>();
	private ArrayList<Card> card = new ArrayList<Card>();
	Game game;
	JTextArea textArea = new JTextArea();

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1400, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pannel.setLayout(null);
		try {
			pannel.setImage("D://Games/background.jpg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		textArea = new JTextArea();
		JScrollPane scrollText = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollText.setBounds(1022, 13, 348, 478);
		scrollText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		textArea.setEditable(false);
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		pannel.add(scrollText);

		JScrollPane scrollPane = new JScrollPane(pan, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(64, 330, 500, 170);
		pannel.add(scrollPane);
		pan.setBackground(Color.DARK_GRAY);

		JButton passerButton = new JButton("Passer");
		passerButton.setBounds(580, 449, 180, 50);
		pannel.add(passerButton);
		passerButton.addActionListener(new PasserListener());
		
		JButton jouerButton = new JButton("jouer");
		jouerButton.setBounds(580, 400, 180, 50);
		jouerButton.addActionListener(new jouerListener());
		pannel.add(jouerButton);
		frame.getContentPane().add(pannel, BorderLayout.CENTER);
		
	}

	public JPanel getPanel() {
		return pan;
	}

	public JPanel getPan() {
		return pannel;
	}

	public JTextArea getArea() {
		return textArea;
	}

	public void tempor() {

		for (int k = 0; k < game.getPlayers().get(game.getPlayingPlayer()).getHand().cardCount(); k++) {
			int key = game.getPlayers().get(game.getPlayingPlayer()).getHand().getCardKey(k);
			JButton cartButton = new JButton(new ImageIcon(picturePath.getPicturePath(key)));
			cartButton.setPreferredSize(new Dimension(97, 143));
			listButton.add(cartButton);
			cartButton.setActionCommand(String.valueOf(key));
			cartButton.addActionListener(new SelectionListener());
			pan.add(cartButton);
		}
	}

	public void tempor2() {
		int j = listButton.size() - 1;
		while (j >= 0) {
			pan.remove(listButton.get(j));
			listButton.remove(j);
			j = j - 1;
		}
		pan.repaint();
		pan.revalidate();

		tempor();
	}

	public void Init() {
		game = Init.initGame();
		System.out.println(Init.getNbPlayer());
	}

	public void show() {
		this.frame.setVisible(true);
		Init();
		tempor();
	}

	class PasserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TurnManagement.turnManagement(game, pannel, textArea);
			tempor2();
		}
	}

	class SelectionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			int i;
			int test = 0;
			for (i = 0; i < cards.size(); i++) {
				if (String.valueOf(cards.get(i)) == String.valueOf(e.getActionCommand())) {
					cards.remove(i);
					test = 1;

				}
			}
			if (test == 0) {
			
				cards.add(e.getActionCommand());
			}

		}
	}

	class jouerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			/*
			 * Si aucune carte n'est selection� on ne peut jouer
			 */

			if (!cards.isEmpty()) {
				/*
				 * On va tester si les cartes jou�es suivent les regles du jeu Pour cela on
				 * recupere les cartes correspondante aux clefs jou�e
				 */
				for (int a = 0; a < cards.size(); a++) {
					Integer inter = Integer.valueOf(cards.get(a));
					card.add(Card.getCardWithKey(inter));
				}

				int isValid = PlayerAction.verify(card, game.getTable(gameId).getDiscard());
				// Si les cartes on passe les test et sont valident
				if (isValid == 2) {
					Posibility pos = new Posibility(0, card);
					TurnManagement.turnManagement(game, pannel, textArea, pos);
				} else if (isValid > 0) {
					Posibility pos = new Posibility(1, card);
					TurnManagement.turnManagement(game, pannel, textArea, pos);
				} else {
					JOptionPane.showMessageDialog(null, "mauvaise carte", "mauvaise carte jou�e",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			/*
			 * On appele la fonction qui va gerer les tours des joueurs
			 */
			tempor2();
			cards.clear();
			card.clear();
		}
	}
}
