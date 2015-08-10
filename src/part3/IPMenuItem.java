package part3;

import java.awt.event.ActionListener;


import javax.swing.JMenu;
import javax.swing.JMenuItem;
/**
 * this class helps organize the meunItems need for this assignment by providing a constructor
 * to help create new JMenuItems
 * 
 * @author James Yeates
 *
 */
public class IPMenuItem extends JMenuItem{
	

	public IPMenuItem(String title, String description, ActionListener l,JMenu j){
		super(title);
		setToolTipText(description);
		addActionListener(l);
		j.add(this);
	}

}
