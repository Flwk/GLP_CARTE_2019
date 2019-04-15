package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import traitement.Init;

public class Menu extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JButton buttonEntrainement = new JButton("Mode Entrainement");
	JButton buttonNormal = new JButton("Mode Normal");
	JButton info = new JButton("i");
	JList list = new JList();
	JButton buttonPlay = new JButton("Jouer");
	JTextField txt = new JTextField();
	JButton buttonMore = new JButton("+");
	JButton buttonLess = new JButton("-");
	Init launchTable;
	MainGUI main = new MainGUI();
	int nbPlayer=1;
	int rulesTypes=0;
	
	public Menu() {
		setTitle("Tu n'y peux rien ! MENU");
		setFont(new Font("Dialog", Font.PLAIN, 20));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 515);
		build();
		panel();
		
		this.setVisible(true);
		
		//construction de la fenetre
				
	}
	
	public void build() {
		

		buttonEntrainement.setForeground(Color.WHITE);
		buttonEntrainement.setBackground(Color.DARK_GRAY);
		buttonEntrainement.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonEntrainement.setBounds(313, 203, 340, 136);
		buttonEntrainement.addActionListener(new modeEntrainementListener());
		
		
		buttonNormal.setForeground(Color.WHITE);
		buttonNormal.setBackground(Color.LIGHT_GRAY);
		buttonNormal.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonNormal.setBounds(313, 42, 340, 136);
		buttonNormal.addActionListener(new modeNormalListener());
		
		
		//Liste comportant toutes les spécificités de l'IA !!
		list.setForeground(Color.WHITE);
		list.setBackground(Color.DARK_GRAY);
		list.setBounds(64, 42, 174, 297);
		
		
		buttonPlay.setForeground(Color.WHITE);
		buttonPlay.setBackground(Color.DARK_GRAY);
		buttonPlay.setFont(new Font("Tahoma", Font.PLAIN, 25));
		buttonPlay.setBounds(64, 369, 174, 71);
		buttonPlay.addActionListener(new playListener());
		
		
		txt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt.setForeground(Color.WHITE);
		txt.setBackground(Color.DARK_GRAY);
		txt.setBounds(306, 371, 206, 71);
		txt.setText("Nombre de Joueur: " + nbPlayer);
	

		buttonMore.setForeground(Color.WHITE);
		buttonMore.setBackground(Color.DARK_GRAY);
		buttonMore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		buttonMore.setBounds(633, 371, 97, 71);
		buttonMore.addActionListener(new incrementListener());
		
		
		buttonLess.setForeground(Color.WHITE);
		buttonLess.setBackground(Color.DARK_GRAY);
		buttonLess.setFont(new Font("Tahoma", Font.PLAIN, 30));
		buttonLess.setBounds(524, 371, 97, 71);
		buttonLess.addActionListener(new decrementListener());
		
		

		info.setBackground(Color.white);
		info.setFont(new Font("Tahoma", Font.PLAIN, 10));
		info.setBounds(0, 0, 30, 30);
		info.addActionListener(new infoListener());
	}
	
	
	public void panel() {

		
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(SystemColor.controlHighlight);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		panel.add(info);
		panel.add(buttonEntrainement);
		panel.add(buttonNormal);
		panel.add(list);
		panel.add(buttonPlay);
		panel.add(buttonMore);
		panel.add(buttonLess);
		panel.add(txt);
		
		
	}
	
	public void quit() {
		this.dispose();
	}
	
	public Init getInit() {
		return launchTable;
		
	}
	
	class modeEntrainementListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(rulesTypes == 0) {
				rulesTypes=1;
				buttonEntrainement.setBackground(Color.LIGHT_GRAY);
				buttonNormal.setBackground(Color.DARK_GRAY);
			}
			
		}
	}
	
	class modeNormalListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(rulesTypes == 1) {
				rulesTypes=0;
				buttonEntrainement.setBackground(Color.DARK_GRAY);
				buttonNormal.setBackground(Color.LIGHT_GRAY);
			}
		}
	}
	
	class playListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			quit();
			MainGUI main = new MainGUI();
			Init.setNbPlayer(nbPlayer);
			main.show();
		}
	}
	
	class incrementListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(nbPlayer<5) {
				nbPlayer++;
			}
			else {
				JOptionPane.showMessageDialog( null, "MAXIMUM 5 JOUEUR!!", "ERREUR NOMBRE DE JOUEUR", JOptionPane.ERROR_MESSAGE);
			}
			txt.setText("Nombre de Joueur: " + nbPlayer);
		}
	}
	
	class decrementListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(nbPlayer>1) {
				nbPlayer--;
			}
			else {
				JOptionPane.showMessageDialog( null, "MINIMUM 1 JOUEUR!!", "ERREUR NOMBRE DE JOUEUR", JOptionPane.ERROR_MESSAGE);
			}
			txt.setText("Nombre de Joueur: " + nbPlayer);
		}
	}
	
	class infoListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			rulesGui frame= new rulesGui();
		}
	}
}


