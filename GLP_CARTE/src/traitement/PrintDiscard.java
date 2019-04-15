package traitement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import carte.Discard;
import carte.Table;
import carte.picturePath;

public class PrintDiscard {
	static JButton discardButton_a=new JButton();
	static JButton discardButton_b=new JButton();
	static JButton discardButton_c=new JButton();
	static JButton discardButton_d=new JButton();
	public static void printCard(JFrame gui, Discard discard) {
		
		int size=discard.cardCount();
		
		int x=341;
		switch(discard.getType()) {
			case 1:
				discardButton_a.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size-1).getKey())));
				discardButton_a.setBounds(323, 0, 97, 143);
				gui.getContentPane().add(discardButton_a);
				gui.getContentPane().remove(discardButton_b);
				gui.getContentPane().remove(discardButton_c);
				gui.getContentPane().remove(discardButton_d);
				break;
			case 2:
				discardButton_a.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size-2).getKey())));
				discardButton_a.setBounds(323, 0, 97, 143);
				discardButton_b.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size-1).getKey())));
				discardButton_b.setBounds(420, 0, 97, 143);
				gui.getContentPane().add(discardButton_a);
				gui.getContentPane().add(discardButton_b);
				gui.getContentPane().remove(discardButton_c);
				
			
				break;
				
			case 3:
				discardButton_a.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size-3).getKey())));
				discardButton_a.setBounds(323, 0, 97, 143);
				discardButton_b.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size-2).getKey())));
				discardButton_b.setBounds(420, 0, 97, 143);
				discardButton_c.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size-1).getKey())));
				discardButton_c.setBounds(513, 0, 97, 143);
				gui.getContentPane().add(discardButton_a);
				gui.getContentPane().add(discardButton_b);
				gui.getContentPane().add(discardButton_c);
				gui.getContentPane().remove(discardButton_d);
			
				break;
			case 4:
				discardButton_a.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size-4).getKey())));
				discardButton_a.setBounds(323, 0, 97, 143);
				discardButton_b.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size-3).getKey())));
				discardButton_b.setBounds(420, 0, 97, 143);
				discardButton_c.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size-2).getKey())));
				discardButton_c.setBounds(513, 0, 97, 143);
				discardButton_c.setIcon(new ImageIcon(picturePath.getPicturePath(discard.getCards().get(size-1).getKey())));
				discardButton_c.setBounds(600, 0, 97, 143);
				gui.getContentPane().add(discardButton_a);
				gui.getContentPane().add(discardButton_b);
				gui.getContentPane().add(discardButton_c);
				gui.getContentPane().add(discardButton_d);

				
				break;
			
			default:
			
		}
	}
}
