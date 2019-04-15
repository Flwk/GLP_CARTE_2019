package gui;

import java.awt.*;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import carte.Player;
import carte.Table;
import traitement.EndGame;
import traitement.Init;
import traitement.Management;
import traitement.PlayerAction;
import traitement.PrintDiscard;
import traitement.TurnManagement;
import carte.picturePath;
import carte.Card;

public class MainGUI {
	int turn=0;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	Table table;
	Init launchTable=null;
	int i=0;
	private JTextField textField_2;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton discardButton;
	private Management management=new Management();
	private ArrayList<JButton> listButton = new ArrayList<JButton>();
	private int nbPlayer;
	private JScrollPane scrollPane;
	private JPanel p = new JPanel();
	private ArrayList<String> cards = new ArrayList<String>();
	private ArrayList<Card> card = new ArrayList<Card>();
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
		ArrayList<JButton> listButton = new ArrayList<JButton>();
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane(p,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(64,330, 500, 170);
		frame.getContentPane().add(scrollPane);
		
		
		JButton passerButton = new JButton("Passer");
		passerButton.setBounds(580, 449, 180, 50);
		frame.getContentPane().add(passerButton);
		passerButton.addActionListener(new PasserListener());
		
		JButton jouerButton = new JButton("jouer");
		jouerButton.setBounds(580, 400, 180, 50);
		jouerButton.addActionListener(new jouerListener());
		frame.getContentPane().add(jouerButton);
	
		
			
		button_2 = new JButton(new ImageIcon("resources\\images\\cover.gif"));
		button_2.setBounds(600, 215, 97, 143);
		frame.getContentPane().add(button_2);
	}
	
	public JPanel getPanel() {
		return p;
	}	
	public void tempor() {
		int x=64;
		for(int k=0; k<launchTable.getTable().getPlayers().get(i).getHand().cardCount(); k++) {
			int key=launchTable.getTable().getPlayers().get(i).getHand().getCardKey(k);
			
			JButton cartButton = new JButton(new ImageIcon(picturePath.getPicturePath(key)));
			cartButton.setPreferredSize(new Dimension(97, 143));
			listButton.add(cartButton);
			cartButton.setActionCommand(String.valueOf(key));
			cartButton.addActionListener(new SelectionListener());
			
			if(turn != 0) {
				discardButton.setIcon((new ImageIcon(picturePath.getPicturePath(launchTable.getTable().getDiscard().getLastCardPlay()))));
			}
			
			p.add(cartButton);
			p.repaint();
			p.revalidate();
			frame.repaint();
			frame.revalidate();
			
		}
		
	}
	
	
	public void tempor2() {
		int j=listButton.size() - 1;
		while(j>=0) {
			p.remove(listButton.get(j));
			listButton.remove(j);
			j=j-1;
		}
		p.repaint();
		p.revalidate();
		frame.repaint();
		frame.revalidate();
		tempor();
	}
	
	public void Init() {
		launchTable = new Init();
		launchTable.setNbPlayer(nbPlayer);
		launchTable.launch();
		launchTable.test();
	}
	
	public  void show() {
		this.frame.setVisible(true);
		Init();

		tempor();

	}
	
	class PasserListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			management.stockManagement(launchTable.getTable().getPlayers().get(i).getHand(), launchTable.getTable().getStock());
			launchTable.getTable().getPlayers().get(i).pass(1);
			
			if(!TurnManagement.canPlay(launchTable.getTable().getPlayers())) {
				i=TurnManagement.getLastPlayerWhoPlay()-1;
				launchTable.getTable().getDiscard().setType(0);
				for(int i=0; i<launchTable.getTable().getPlayers().size(); i++) {
					launchTable.getTable().getPlayers().get(i).pass(0);
				}
			}
			
			if (i<nbPlayer - 1) {
				i = i + 1;
			}
			else {
				i=0;
			}
			
			tempor2();
			
		}
	}

	public void setNbPlayer(int nbPlayer) {
		this.nbPlayer = nbPlayer;
	}
	
	class SelectionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int i;
			int test=0;
			for(i=0;i<cards.size();i++) {
				if(String.valueOf(cards.get(i))==String.valueOf(e.getActionCommand())) {
					cards.remove(i);
					test=1;
				}
			}
			if(test==0) {
				cards.add(e.getActionCommand());
			}
			
		}
	}
	
	class jouerListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(!cards.isEmpty()) {
				if(launchTable.getTable().getPlayers().get(i).getToPass()==0) {
					for(int a=0; a<cards.size(); a++) {
						Integer inter = Integer.valueOf(cards.get(a));
						card.add(Card.getCardWithKey(inter));
					}
					
					//test si la (les) carte(s) jouée(s) son(t) valide(nt)
					int isValid=PlayerAction.verify(card, launchTable.getTable().getDiscard());
				
					if(isValid  > 0) {
						launchTable.getTable().getDiscard().setType(cards.size());
						for(int a=0; a<cards.size(); a++) {
							Integer inter = Integer.valueOf(cards.get(a));
							launchTable.getTable().getDiscard().add(Card.getCardWithKey(inter));
							launchTable.getTable().getPlayers().get(i).getHand().remove(inter);
						}
						PrintDiscard.printCard(frame, launchTable.getTable().getDiscard());
						TurnManagement.lastPlayerWhoPlay(i);
					}
					else{
						JOptionPane.showMessageDialog( null, "mauvaise carte", "mauvaise carte jouée", JOptionPane.ERROR_MESSAGE);
					}
	
					if(isValid == 2) {
						launchTable.getTable().getDiscard().setType(0);
						for(int y=0; y<launchTable.getTable().getPlayers().size(); y++) {
							launchTable.getTable().getPlayers().get(y).pass(0);
						}
					}

					if(TurnManagement.endGame(launchTable.getTable().getPlayers())) {
						Player winner=EndGame.winner(launchTable.getTable().getPlayers());
						System.out.println(winner.getUsername() + " a gagner la partie");
					}
					else if (isValid == 1) {
						if(i<nbPlayer - 1) {
							i = i + 1;
						}
						else {
						i=0;
						}
					}
					tempor2();
					cards.clear();
					card.clear();
				}
		}
	}
}
}





