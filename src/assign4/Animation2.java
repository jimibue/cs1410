package assign4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Animation2 implements KeyListener{
	static double size = 1.0;
	static double color = 0.0;
	
	
	public static void paintFrame(Graphics g ,int t){
		
		drawThing(g);
		
		
		
	}
	
	public static void drawThing(Graphics g){
		
		
		for(int i = 0; i< 500;	i += 40){
//			Color c = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
//			g.setColor(c);
			
			for(int j = 0; j< 500; j+= 40){
				if(color>254){
					color = 0;
				}
				Color c = new Color((int)(Math.random()*255),(int)(color +=.01),(int)(Math.random()*255));
				g.setColor(c);
				
					
					g.fillRect(i, j, (int)(size +color/25)	,(int)(size +color/25));
					
			}
		}
		
	}
	public static void drawThing1(Graphics g){
		
		
		for(int i = 0; i< 500;	i += 40){
//			Color c = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
//			g.setColor(c);
			if(size <39)
				size+=.01;
			else
				size=(Math.random()*10);
			for(int j = 0; j< 500; j+= 40){
				for(int k = j; k< j+40; k+=4){
				Color c = new Color((int)(Math.random()*255),(int)(Math.random()*255),((int)(Math.random()*2550))/10);
				g.setColor(c);
				
					g.fillRect(k, k, ((int)size)/20	,((int) size));
				}
					
			}
		}
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		
			if(e.getKeyChar()=='a')
				System.out.println("yes");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
