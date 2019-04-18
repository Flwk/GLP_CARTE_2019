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
			discardButton_b.setBounds(420, 100, 97, 143);
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
			discardButton_c.setBounds(420, 100, 97, 143);
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
	
	public static void printLog(JTextArea area, Game game) {
		int id=game.getId();
		int type=game.getTable(id).getDiscard().getLastPlaySize();
		int size=game.getTable(id).getDiscard().cardCount();
		
		String str=game.getPlayers().get(game.getPlayingPlayer()).getUsername()+ " : a joué ";
		
		if(game.getPlayers().get(game.getPlayingPlayer()).getToPass() == 1) {
			area.append(game.getPlayers().get(game.getPlayingPlayer()).getUsername() +": n'y peux rien\n");
		}
		else {
			for(int playSize=(size-type); playSize<size; playSize++) {
				System.out.println(game.getTable(0).getDiscard().getCards().get(playSize).getName() + "test");
				str=str + game.getTable(id).getDiscard().getCards().get(playSize).getName() + "  ";
			}
			str=str+"\n";
			area.append(str);
		}
		
	}

}
