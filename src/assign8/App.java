package assign8;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import assign11.ImagePanel;

public class App extends JFrame {
	
	
	BufferedImage card;
	BufferedImage cSheet;
	CardSheet cardSheet;
	JPanel thePanel;
	
	public static void main(String[] args) {
		
		new App();
		
	}
	
	public App(){
		Deck d = new Deck();
		
	
		System.out.println("here");
	
		cardSheet= new CardSheet(cSheet);
		
		System.out.println("here!1");
		card = cardSheet.getCard(8,4);
		System.out.println("here!");
		
		thePanel = new JPanel();
		
		thePanel.setLayout(new BorderLayout());
		thePanel.add(new ImagePanel(d.cardsGUI[14]), BorderLayout.CENTER);
	
		
	
		//thePanel.add(new ImagePanel(cSheet));
		
		//pack();
		setLayout(new BorderLayout());
		add(thePanel,BorderLayout.CENTER);
		setSize(600,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
