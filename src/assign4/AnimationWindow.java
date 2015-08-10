package assign4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Provides a top-level animation window
 */
public class AnimationWindow extends JFrame implements ActionListener, KeyListener {

	public final static int REFRESH_RATE = 5; // Animation refresh rate in
												// milliseconds
	private DrawingArea area; // JPanel that contains animation
	private JButton start; // Start button
	private Timer timer; // Animation timer

	/**
	 * Launches an AnimationWindow
	 */
	public static void main(String[] args) {
		AnimationWindow g = new AnimationWindow();
		g.setSize(400, 400);
		g.setVisible(true);
	}

	/**
	 * Constructs a custom CS 1410 graphics window
	 */
	public AnimationWindow() {
		setTitle("CS 1410 Graphics Window");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		timer = new Timer(REFRESH_RATE, this);
		area = new DrawingArea();
		start = new JButton("Start");
		start.addActionListener(this);
		start.addKeyListener(this);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(area, "Center");
		panel.add(start, "South");
		setContentPane(panel);
	}

	/**
	 * Handles button presses and timer events.
	 */
	public void actionPerformed(ActionEvent e) {

		// Timer to generate a new frame
		if(e.getSource() == timer) {
			synchronized (area) {
				area.tick(REFRESH_RATE);
			}
			area.repaint();
		}

		// Start button has been pressed
		else if(start.getText().equals("Start")) {
			synchronized (area) {
				area.clearTimer();
			}
			start.setText("Stop");
			timer.start();

		}

		// Stop button has been pressed
		else if(e.getSource() == start) {
			timer.stop();
			start.setText("Start");
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
//		if(e.getKeyChar()=='s')
//		Animation2.size +=1;
//		if(e.getKeyChar()=='b')
//			Animation2.size -=1;
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()=='s')
			Animation2.size +=1;
		if(e.getKeyChar()=='b')
			Animation2.size -=1;
		if(e.getKeyChar()=='1')
			Animation2.size =5;
		if(e.getKeyChar()=='2')
			Animation2.size =40;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
