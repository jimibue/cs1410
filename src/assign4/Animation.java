package assign4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * This Class contains methods to draw an animation.  There are a lot of nested for loops used in these methods
 * to create mosaics like animations.  There is also a large amount of randomness used in this class
 * which makes the animations more interesting but makes the code harder to read.
 * 
 * @author James Yeates
 *
 */
public class Animation {

	/**
	 * This Method calls upon many methods and draws a variety of experimental and abstract animations. 
	 * Thread.sleep is also used in this method to adjust the pace of the animations.
	 * 
	 * @param g
	 *            Graphics object on which to draw
	 * @param t
	 *            Number of milliseconds that have passed since animation
	 *        	  started, since this thread is put to sleep at various points,
	 *            this does not represent the actual time that has passed.
	 */
	
	/*these static variables assist in help the animations and object in animation 
	* change color shape and size
	*/
	static int var = 0;
	static int var2 = 0;
	static int var5 = 0;
	static double var3 = 0.0;
	static double var4 = 0.0;
	static int dir =0;

	

	public static void paintFrame(Graphics g, int t) {
		
		/* draw first part, since this thread is put to sleep
		 * t does not represent the real time since animation has passed,
		 * but the time the time the thread has run
		 */
		
		if (t < 200) {
			drawBackGround(g);
			drawcirclething(g, t);
			
			//try catch block needed for Thread.sleep
			try {
				//first slow the animation down
				// then slowly speed the animation up
				Thread.sleep(200 - (t % 200));

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		
		//draw second part
		if (t > 200 && t <= 2000) {
			drawBackGround(g);
			drawcirclething(g, t);
		}
		
		//draw third part
		if (t > 2000 && t <= 2200) {
			drawBackGround(g);
			drawthing(g, t);
			
			try {
				//this progressively slows down the animation
				Thread.sleep(t % 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		
		//draw fourth part
		if (t > 2200 && t <= 2500) {
			drawBackGround(g);
			changeDrawBlock(g);
			
			try {
				//slow animation down
				Thread.sleep(20);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		
		//draw fifth part
		if (t > 2500 && t <= 2700) {
			
			//set a black background
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 400, 400);
			
			drawthing2(g, t);
			
			try {
				//slow animation down
				Thread.sleep(143);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		//draw final part
		if (t > 2700 && t < 7000) {
			if(t==2600){
				var5=0;
			}
			var5 += 1;

			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 400, 400);

			drawthing1(g, t);
			Font f = new Font(Font.MONOSPACED, Font.BOLD, 100);
			
			//display message
			g.setFont(f);
			Color c = new Color((var5 + 100) % 255, var % 255, 10);
			g.setColor(c);
			
			dir =  Math.abs(400 - var5)+50;
			if((400 - var5)> 0){
				g.drawString("Up", 80, dir);
				g.drawString("YO!", 80, Math.abs(525 - var5)+50);
			}else{
				g.drawString("DOWN", 80, dir);
				g.drawString("YO!", 80, Math.abs(525 - var5)+50);
			}
		}

	}// END PAINTFRAME
	
	/**
	 * This method draws a background with four different squares that randomly change colors
	 *
	 * @param g  graphic object
	 */

	public static void drawBackGround(Graphics g) {
		Color col = new Color(var % 255, var % 255, (var * var2) % 255);
		g.setColor(col);
		g.fillRect(0, 0, 200, 200);

		var++;
		var2 += 5;
		Color col1 = new Color(var % 255, (100 + var) % 255, (var * var2) % 255);
		g.setColor(col1);
		g.fillRect(200, 0, 200, 200);
		Color col2 = new Color((100 + var) % 255, var % 255, (var * var2) % 255);
		g.setColor(col2);
		g.fillRect(0, 200, 200, 200);

		Color col3 = new Color((var + 180) % 255, (100 + var) % 255,
				(var * var2) % 255);
		g.setColor(col3);
		g.fillRect(200, 200, 200, 200);
		// drawthing2(g, t);
		var++;
		var2 += 5;

	}
	/**
	 * This method draws a matrix of randomly moving balls and squares that move around columns and rows
	 * 
	 * 
	 * @param g a graphics object
	 *
	 * @param t   Number of milliseconds that have passed since animation
	 *        	  started, since this thread is put to sleep at various points,
	 *            this does not represent the actual time that has passed.
	 */

	public static void drawcirclething(Graphics g, int t) {
		
		/*
		 * these nested for loops are used to to create the location points
		 * and size dimensions to draw shapes in a mosaic like order
		 */
		for (int i = 0; i < 400; i += 80) {
			if (var < 120) {
				var++;
			} else
				var = 0;

			for (int j = 0; j < 400; j += 80) {

				g.drawRect(i, j, 100, 100);
				
				//these if statements are to create some variety
				if ((t % 20 == 0 && t % 60 != 0) && t > 200) {
					g.drawRect(i, j + t, 100, 100);
					g.drawRect(i - t, j, 100, 100);
					for (int x = 0; x < 400; x += 20) {
						for (int z = 0; z < 400; z += 20) {
							if ((z % 40 == 0 && x % 40 == 0)
									&& !(z % 80 != 0 && x % 80 != 0)) {
								g.fillRect(x, z, 20, 20);
							}
						}
					}
				}
				if (t % 60 == 0) {
					g.drawRect(i, j + t, 100, 100);
					g.drawRect(i - t, j, 100, 100);
					for (int x = 0; x < 400; x += 20) {
						for (int z = 0; z < 400; z += 20) {
							if ((z % 40 == 0 && x % 40 == 0)
									&& (z % 80 == 0 && x % 80 == 0)) {
								g.fillRect(x, z, 20, 20);
							}
						}
					}
				}

				g.drawRect(i, j, 100, 100);
				g.fillRect(i, t, 20, 20);
				g.fillRect(t, j, 20, 20);
				g.fillRect(i, 400 - t, 20, 20);
				g.fillRect(400 - t, j, 20, 20);
				for (int q = 10; q < 25; q += 5) {
					for (int p = 5; p < 50; p += 10) {

						Color c = new Color((int) (Math.random() * 255),
								(int) (Math.random() * 255),
								(int) (Math.random() * 255));
						int k = (int) (Math.random() * 20);
						int v = (int) (Math.random() * 20);
						g.setColor(c);
						// g.drawOval(i + k, j + v, p*2, p*2);

						k = (int) (Math.random() * 20);
						v = (int) (Math.random() * 20);
						g.fillOval(i + k + 40, j + v + 40, q / 2, q / 2);
						g.fillOval((i / 40) + 40, q + 40, 3, 3);

					}
				}
			}
		}
	}
	/**
	 * This method draws a mosaic of semi-randomly moving squares and arcs that change color.
	 * also draw two circle object that move to the corner and grow in size
	 * 
	 * @param g	  a graphics object
	 * @param t   Number of milliseconds that have passed since animation
	 *        	  started, since this thread is put to sleep at various points,
	 *            this does not represent the actual time that has passed.
	 */

	public static void drawthing(Graphics g, int t) {
		/*
		 * these nested for loops are used to to create the location points
		 * and size dimensions to draw shapes in a mosaic like order
		 */

		for (int i = 0; i < 400; i += 40) {
			for (int j = 0; j < 400; j += 40) {
				for (int q = 10; q < 25; q += 5) {
					for (int p = 5; p < 50; p += 10) {

						Color c = new Color(0, 0, (int) (Math.random() * 255));
						if (t % 10 == 0 && t % 20 != 0) {
							c = new Color((int) (Math.random() * 255),
									(int) (Math.random() * 255),
									(int) (Math.random() * 255));
						}
						if (t % 20 == 0) {
							c = new Color(t % 255, (int) (Math.random() * 255),
									t % 255);
						}
						int k = (int) (Math.random() * 20);
						int v = (int) (Math.random() * 20);
						g.setColor(c);
						g.drawRect(i + k, j + v, p, p);

						k = (int) (Math.random() * 20);
						v = (int) (Math.random() * 20);
						g.fillRect(i + k, j + v, q, q);
						c = new Color(255, (int) (Math.random() * 255), t % 255);
						g.setColor(c);
						g.fillOval(t % 400 + 80, t % 400 + 80, t % 200, t % 200);
						c = new Color(0, (int) (Math.random() * 255), t % 255);
						g.setColor(c);
						g.fillOval(t % 400 + 100, t % 400 + 100, t % 200 - 100,
								t % 200 - 100);
						c = new Color(255, (int) (Math.random() * 255), t % 255);
						g.setColor(c);
						g.drawArc(i, j, t % 255, j,
								(int) (Math.random() * 180),
								(int) (Math.random() * 180));
						c = new Color((int) (Math.random() * 255), 0, 180);
						g.setColor(c);
						g.drawArc(j, i, t % 255, j,
								(int) (Math.random() * 180), t % 180);
						

					}
				}
			}
		}
	}
	
	/**
	 * this method draws a matrix that does not move but colors change. 
	 * 
	 * @param g  graphic object
	 * @param r double used to generate red part of the rgb color scheme
	 * @param gr double used to generate green part of the rgb color scheme
	 * @param b double used to generate blue part of the rgb color scheme
	 */

	public static void drawBlock(Graphics g, double r, double gr, double b) {
		
		/*
		 * these nested for loops are used to to create the location points
		 * and size dimensions to draw shapes in a mosaic like order
		 */
		for (int i = 0; i < 400; i += 2) {
			for (int j = 0; j < 400; j += 2) {
				//var2 += .00001;
				var3 += .031;
				//var4 += .000235;
				
				//this draws greenish rows and columns
				if (i == 0 || j == 0 || i % 40 == 0 || j % 40 == 0) {
					Color c = new Color((int) (Math.random() * 255) % 20,
							205 + (int) (Math.random() * 40),
							0 + (int) (Math.random() * 100));
					g.setColor(c);
					g.fillRect(i, j, 10, 10);
					
				} 
				//draw the squares in between rows and columns
				else {
					Color d = new Color((int) r % 255, (int) gr % 255,
							(int) b % 255);
					g.setColor(d);
					g.fillRect(i, j, 1, 1);
					System.out.print(/*(int) var3 % 255*/ " ");
					
					//increment colors
					r += 2;
					gr += 2;
					b += 3;
				}
			}
		}
	}
	/**
	 * this method is used to increment the parameters of drawBlock		
	 * @param g
	 */

	public static void changeDrawBlock(Graphics g) {

		var2 += 1;
		var3 += .4;
		var4 += 5;
		drawBlock(g, var2, var3, var4);

	}
	/**
	 * this method draws rows and columns of of randomly placed squares
	 * 
	 * @param g	  a graphics object
	 * @param t   Number of milliseconds that have passed since animation
	 *        	  started, since this thread is put to sleep at various points,
	 *            this does not represent the actual time that has passed.
	 */

	public static void drawthing2(Graphics g, int t) {
		/*
		 * these nested for loops are used to to create the location points
		 * and size dimensions to draw shapes in a mosaic like order
		 */

		for (int i = 0; i < 400; i += 100) {
			for (int j = 0; j < 400; j += 100) {
				for (int q = 10; q < 25; q += 5) {
					for (int p = 5; p < 50; p += 10) {
						
						//create a random color
						Color c = new Color((int) (Math.random() * 255),
								(int) (Math.random() * 255),
								(int) (Math.random() * 255));
						int k = (int) (Math.random() * 20);
						int v = (int) (Math.random() * 20);
						g.setColor(c);
						g.drawRect((i + k) + 25, (j + v) + 25, p, p);
						
						//These if statements are used to create some variety
						if (t % 25 == 0) {
							k = (int) (Math.random() * 20);
							v = (int) (Math.random() * 20);
							g.fillRect((i + k) + 25, (j + v) + 25, q, q);
							g.fillOval(i, j, 3, 3);
							if (t % 50 == 0) {
								g.fillRect(i, j, 100, 100);

								g.fillRect(i / 2, j / 2, 50, 50);

							}
						}
					}
				}
			}
		}

	}
	
	/**
	 * this method draws more squares that are not filled
	 * 
	 * @param g a graphics object
	 * @param t   Number of milliseconds that have passed since animation
	 *        	  started, since this thread is put to sleep at various points,
	 *            this does not represent the actual time that has passed.
	 */

	public static void drawthing1(Graphics g, int t) {
		
		/*
		 * these nested for loops are used to to create the location points
		 * and size dimensions to draw shapes in a mosaic like order
		 */
		for (int i = 0; i < 400; i += 40) {
			for (int j = 0; j < 400; j += 40) {
				for (int q = 10; q < 25; q += 5) {
					for (int p = 5; p < 50; p += 10) {
						//create a random color
						Color c = new Color((int) (Math.random() * 255),
								(int) (Math.random() * 255),
								(int) (Math.random() * 255));
						int k = (int) (Math.random() * 20);
						int v = (int) (Math.random() * 20);
						g.setColor(c);
						g.drawRect(i + k, j + v, p, p);
						
						//draw solid squares
						if (t % 25 == 0) {
							k = (int) (Math.random() * 20);
							v = (int) (Math.random() * 20);
							g.fillRect(i + k, j + v, q, q);
							g.fillOval(i / 40, q, 3, 3);
						}
					}
				}
			}
		}
	}

}//end