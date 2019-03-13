package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import carte.Player;
import carte.Table;
import traitement.Init;
import traitement.Management;
import carte.picturePath;


public class MainGUI {
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
	private Management management=new Management();
	private ArrayList<JButton> listButton = new ArrayList<JButton>();
	private int nbPlayer;
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
		frame.setBounds(100, 100, 716, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(64, 432, 454, 59);
		//frame.getContentPane().add(textField);
		//textField.setColumns(10);
		
		JButton passerButton = new JButton("Passer");
		passerButton.setBounds(550, 449, 97, 25);
		frame.getContentPane().add(passerButton);
		passerButton.addActionListener(new PasserListener());
		
		textField_1 = new JTextField();
		textField_1.setBounds(64, 305, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("resources\\images\\cover.gif"));
		btnNewButton_1.setBounds(538, 215, 97, 143);
		frame.getContentPane().add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(538, 191, 97, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		button = new JButton(new ImageIcon("resources\\images\\cover.gif"));
		button.setBounds(151, 0, 97, 143);
		frame.getContentPane().add(button);
		
		button_1 = new JButton(new ImageIcon("resources\\images\\cover.gif"));
		button_1.setBounds(245, 0, 97, 143);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton(new ImageIcon("resources\\images\\cover.gif"));
		button_2.setBounds(341, 0, 97, 143);
		frame.getContentPane().add(button_2);
	}
	
	public void settextField(Player player) {
		textField.setText(player.getHand().toString());
		String count ;
		count = String.valueOf(launchTable.getTable().getStock().cardCount());
		textField_2.setText(count);
	}
	
	public void settextField1(Player player) {
		textField_1.setText(player.getUsername());
	}
	
	public void tempor() {
		int x=64;
		for(int k=0; k<launchTable.getTable().getPlayers().get(i).getHand().cardCount(); k++) {
			int key=launchTable.getTable().getPlayers().get(i).getHand().getCardKey(k);
			
			//System.out.println(picturePath.getPicturePath(key));
			JButton cartButton = new JButton(new ImageIcon(picturePath.getPicturePath(key)));
			cartButton.setBounds(x, 330, 97, 143);
			listButton.add(cartButton);
			frame.getContentPane().add(cartButton);
			x=x+98;
			
		}
		System.out.println("---------------------");
	}
	
	public void tempor2() {
		int j=listButton.size() - 1;
		while(j>=0) {
			frame.getContentPane().remove(listButton.get(j));
			System.out.println(listButton.size());
			listButton.remove(j);
			j=j-1;
		}
		frame.repaint();
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
		System.out.println(launchTable.getTable().getPlayers().toString());

		tempor();

	}
	
	class PasserListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			management.stockManagement(launchTable.getTable().getPlayers().get(i).getHand(), launchTable.getTable().getStock());
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
}


