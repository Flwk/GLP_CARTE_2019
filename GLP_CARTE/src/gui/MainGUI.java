package gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import carte.Player;
import carte.Table;
import traitement.Init;

public class MainGUI {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	Table table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame.setBounds(100, 100, 716, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(64, 432, 454, 59);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(550, 449, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(69, 397, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton(new ImageIcon("C:\\Users\\cleme\\OneDrive\\Documents\\GLP\\GLP-Cartes-master\\resources\\images\\cover.gif"));
		btnNewButton_1.setBounds(538, 215, 97, 143);
		frame.getContentPane().add(btnNewButton_1);
	}
	
	public void settextField(Player player) {
		textField.setText(player.getHand().toString());
	}
	
	public void settextField1(Player player) {
		textField_1.setText(player.getUsername());
	}
	
	public  void show() {
		this.frame.setVisible(true);
		Init launchTable = new Init();
		launchTable.test();
		System.out.println(launchTable.getTable().getPlayers().toString());
		settextField(launchTable.getTable().getPlayers().get(0));
		settextField1(launchTable.getTable().getPlayers().get(0));

	}
}

