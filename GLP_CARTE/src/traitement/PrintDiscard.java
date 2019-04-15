package traitement;



import java.awt.BorderLayout;
import java.awt.TextArea;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import carte.Discard;
import carte.Game;
import carte.Player;
import carte.picturePath;

public class PrintDiscard {
	static JButton discardButton_a = new JButton();
	static JButton discardButton_b = new JButton();
	static JButton discardButton_c = new JButton();
	static JButton discardButton_d = new JButton();

	public static void printCard(JPanel gui, Discard discard) {

		int size = discard.cardCount();

		int x = 341;
		switch (discard.getType()) {
		case 1:
			discardButton_a
					.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size - 1).getKey())));
			discardButton_a.setBounds(323, 100, 97, 143);
			gui.add(discardButton_a);
			gui.remove(discardButton_b);
			gui.remove(discardButton_c);
			gui.remove(discardButton_d);
			break;

		case 2:
			discardButton_a
					.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size - 2).getKey())));
			discardButton_a.setBounds(323, 100, 97, 143);
			discardButton_b
					.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size - 1).getKey())));
			discardButton_b.setBounds(420, 0, 97, 143);
			gui.add(discardButton_a);
			gui.add(discardButton_b);
			gui.remove(discardButton_c);

			break;

		case 3:
			discardButton_a
					.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size - 3).getKey())));
			discardButton_a.setBounds(323, 100, 97, 143);
			discardButton_b
					.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size - 2).getKey())));
			discardButton_b.setBounds(420, 100, 97, 143);
			discardButton_c
					.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size - 1).getKey())));
			discardButton_c.setBounds(513, 100, 97, 143);
			gui.add(discardButton_a);
			gui.add(discardButton_b);
			gui.add(discardButton_c);
			gui.remove(discardButton_d);

			break;
		case 4:
			discardButton_a
					.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size - 4).getKey())));
			discardButton_a.setBounds(323, 100, 97, 143);
			discardButton_b
					.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size - 3).getKey())));
			discardButton_b.setBounds(420, 100, 97, 143);
			discardButton_c
					.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size - 2).getKey())));
			discardButton_c.setBounds(513, 100, 97, 143);
			discardButton_c
					.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size - 1).getKey())));
			discardButton_c.setBounds(600, 100, 97, 143);
			gui.add(discardButton_a);
			gui.add(discardButton_b);
			gui.add(discardButton_c);
			gui.add(discardButton_d);

			break;

		default:

		}
	}
	
	public static void printLog(JTextArea area, int playerId, Game game) {
		int id=game.getId();
		int type=game.getTable(id).getDiscard().getType();
		int size=game.getTable(id).getDiscard().cardCount();
		String str="Player"+ playerId + ": a joué ";
		if(game.getTable(id).getDiscard().getTurn() == 1) {
			area.append("-------------------------------------------------------------\n");
		}

		switch(playerId) {
		
		case 0:
			
			if(game.getPlayers().get(playerId).getToPass() == 1) {
				area.append("Player"+ playerId +": n'y peux rien\n");
			}
			else {
				for(int playSize=(size-type); playSize<size; playSize++) {
					str=str + game.getTable(id).getDiscard().getCards().get(playSize).getName() + "  ";
				}
				str=str+"\n";
				area.append(str);
			}
			break;
		case 1:
			if(game.getPlayers().get(playerId).getToPass() == 1) {
				area.append("Player"+ playerId +": n'y peux rien \n");
			}
			else {
				for(int playSize=(size-type); playSize<size; playSize++) {
					str=str + game.getTable(id).getDiscard().getCards().get(playSize).getName() + "  ";
				}
				str=str+"\n";
				area.append(str);
			}
			break;
		case 2:
			if(game.getPlayers().get(playerId).getToPass() == 1) {
				area.append("Player"+ playerId +": n'y peux rien \n");
			}
			else {
				for(int playSize=(size-type); playSize<size; playSize++) {
					str=str + game.getTable(id).getDiscard().getCards().get(playSize).getName() + "  ";
				}
				str=str+"\n";
				area.append(str);
			}
			break;
		case 3:
			if(game.getPlayers().get(playerId).getToPass() == 1) {
				area.append("Player"+ playerId +": n'y peux rien \n");
			}
			else {
				for(int playSize=(size-type); playSize<size; playSize++) {
					str=str + game.getTable(id).getDiscard().getCards().get(playSize).getName() + "  ";
				}
				str=str+"\n";
				area.append(str);
			}
			break;
		case 4:
			if(game.getPlayers().get(playerId).getToPass() == 1) {
				area.append("Player"+ playerId +": n'y peux rien \n");
			}
			else {
				for(int playSize=(size-type); playSize<size; playSize++) {
					str=str + game.getTable(id).getDiscard().getCards().get(playSize).getName() + "  ";
				}
				str=str+"\n";
				area.append(str);
			}
			break;
		}
		
		if(game.getTable(id).getDiscard().getTurn() == 2) {
			area.append("-------------------------------------------------------------\n");
		}
	}

}
