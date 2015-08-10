package assign4;

import java.awt.*;

public class a {
	/**
	 * This is the method that you need to rewrite to create a custom animation.
	 * This method is called repeatedly as the animation proceeds. It needs to
	 * draw to g how the animation should look after t milliseconds have passed.
	 * 
	 * @param g
	 *            Graphics object on which to draw
	 * @param t
	 *            Number of milliseconds that have passed since animation
	 *            started
	 */

	static int var = 0;
	static int var2 = 0;
	static double var3 =0.0;

	public static void paintFrame(Graphics g, int t) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 400, 400);
//		if(t<2000){
//			drawcirclething(g, t);
//		}
//		if(t>=2000 && t<4000){
//			drawthing(g, t);
//			}
//	//	draw(g);
//		//drawSquare2(g, 0, 0, 400);
//
//		if (t>= 4000 && t< 6000) {
//			for (int i = 0; i < 360; i += 80) {
//				for (int j = 0; j < 360; j += 80) {
//					drawSquare2(g, i, j, 80);
//				}
//				
//				}
//
//		}
//		if (t>= 6000 && t<8000) {
//			for (int i = 0; i < 360; i += 80) {
//				for (int j = 0; j < 360; j += 80) {
//					drawSquare(g, i, j, 80);
//				}
//				
//				}
//
//		}
		if(t>0){
			drawcirclething(g,t);
			g.setColor(Color.BLACK);
			draw(g);
		}
		

	}//END MAIN

	public static void drawthing(Graphics g, int t) {
		for (int i = 0; i < 400; i += 40) {
			for (int j = 0; j < 400; j += 40) {
				for (int q = 10; q < 25; q += 5) {
					for (int p = 5; p < 50; p += 10) {
						Color c = new Color((int) (Math.random() * 255),
								(int) (Math.random() * 255),
								(int) (Math.random() * 255));
						int k = (int) (Math.random() * 20);
						int v = (int) (Math.random() * 20);
						g.setColor(c);
						g.drawRect(i + k, j + v, p, p);

						k = (int) (Math.random() * 20);
						v = (int) (Math.random() * 20);
						g.fillRect(i + k, j + v, q, q);
						g.fillOval(i / 40, q, 3, 3);

					}
				}
			}
		}
	}

	public static void drawLines(Graphics g, int t) {
		g.fillRect(20, 200, 20, 20);

		for (int i = 0; i < 400; i += 100) {

			for (int j = 0; j < 400; j += 100) {
				for (int h = 0; h < 400; h += 20) {

					Color c = new Color((int) (Math.random() * 255),
							(int) (Math.random() * 255),
							(int) (Math.random() * 255));
					g.setColor(c);
					// g.fillRect(i+(t/100), j+(h/10), 400-h, 400-h);
					Color d = new Color((int) (Math.random() * 255),
							(int) (Math.random() * 255),
							(int) (Math.random() * 255));
					g.setColor(d);
					// g.fillOval(i-(t/100), j-100, t/10, t/10);
					Color e = new Color((int) (Math.random() * 255),
							(int) (Math.random() * 255),
							(int) (Math.random() * 255));
					g.setColor(e);
					g.drawOval(i - (t / 50), j - 50, t / 200, t / 200);
					Color f = new Color((int) (Math.random() * 255),
							(int) (Math.random() * 255),
							(int) (Math.random() * 255));
					g.setColor(f);
					g.drawOval(i - (t / 25), j - 25, t / 1000, t / 1000);
					g.drawLine(i, j - 25, i - (t / 25), j - 25);
					g.setColor(c);
					g.drawOval(i + (t / 25), j + 25, t / 400, t / 400);

					g.fillOval(i + (t / 25), j + (t / 25), t / 400, t / 400);

				}
			}
		}
	}

	public static void drawSquare(Graphics g, int x1, int y1, int size) {

		int x2 = x1;
		int y2 = y1 + size;

		g.drawLine(x1, y1, x2, y2);
		Color a = new Color((x1 * x2) % 255, (int) (Math.random() * 255),
				size % 255);
		g.setColor(a);
		x1 = x2 + (int) (Math.random() * 3);
		y1 = y2 + (int) (Math.random() * 3);
		size -= 5;
		x2 += size;

		g.drawLine(x1, y1, x2, y2);
		Color b = new Color((int) (Math.random() * 255), 0, size % 255);
		g.setColor(b);
		x1 = x2;
		y1 = y2;
		// size-=10;
		y2 -= size;

		g.drawLine(x1, y1, x2, y2);
		x1 = x2;
		y1 = y2;
		size -= 5;
		x2 -= size;

		g.drawLine(x1, y1, x2, y2);
		x1 = x2;
		y1 = y2;

		if (size > 5) {
			drawSquare(g, x1, y1, size);
		}

	}

	public static void drawSquare2(Graphics g, int x1, int y1, int size) {

		int x2 = x1;
		int y2 = y1 + size;

		g.drawLine(x1, y1 + (int) (Math.random() * 10), x2,
				y2 + (int) (Math.random() * 10));
		Color a = new Color((x1 * x2) % 255, (int) (Math.random() * 255),
				size % 255);
		g.setColor(a);
		x1 = x2 + (int) (Math.random() * 10);
		y1 = y2 + (int) (Math.random() * 10);
		size -= 1;
		x2 += size;

		g.drawLine(x1 + (int) (Math.random() * 10), y1,
				x2 + (int) (Math.random() * 10), y2);
		Color b = new Color((int) (Math.random() * 255), (x1 * x2) % 255,
				size % 255);
		g.setColor(b);
		x1 = x2;
		y1 = y2;
		// size-=10;
		y2 -= size;

		g.drawLine(x1, y1 + (int) (Math.random() * 10), x2,
				y2 + (int) (Math.random() * 10));
		x1 = x2;
		y1 = y2;
		size -= 1;
		x2 -= size;

		g.drawLine(x1 + (int) (Math.random() * 10), y1
				+ (int) (Math.random() * 10), x2, y2);
		x1 = x2;
		y1 = y2;

		if (size > 5) {
			drawSquare2(g, x1, y1, size);
		}

	}

	public static void drawSquare3(Graphics g, int x1, int y1, int size) {

		int x2 = x1;
		int y2 = y1 + size;

		g.drawLine(x1, y1, x2, y2);
		Color a = new Color((x1 * x2) % 255, (int) (Math.random() * 255),
				size % 255);
		g.setColor(a);
		x1 = x2 + (int) (Math.random() * 10);
		y1 = y2 + (int) (Math.random() * 10);
		size -= 30;
		x2 += size;

		g.drawLine(x1, y1, x2 + (int) (Math.random() * 10),
				y2 + (int) (Math.random() * 10));
		Color b = new Color((int) (Math.random() * 255), 0, size % 255);
		g.setColor(b);
		x1 = x2;
		y1 = y2;
		// size-=10;
		y2 -= size;

		g.drawLine(x1, y1, x2 + (int) (Math.random() * 10),
				y2 + (int) (Math.random() * 10));
		x1 = x2;
		y1 = y2;
		size -= 30;
		x2 -= size;

		g.drawLine(x1, y1, x2 + (int) (Math.random() * 10),
				y2 + (int) (Math.random() * 10));
		x1 = x2;
		y1 = y2;

		if (size > 5) {
			drawSquare3(g, x1, y1, size);
		}

	}
	
	public static void draw(Graphics g){
		if (var<50){
			g.setColor(Color.BLACK);
			g.drawLine(200, 300, 200, 300 - var);
			
			System.out.println(var);
		}
		if (var>=50 && var <100){
			g.drawLine(200, 250, 200, 250 - var);
			g.drawLine(200, 300, 200,250);
			g.drawLine(200, 250, 150+var, 250);
		}
		if(var>100){
			var =0;
		}
		var+=5;
	}
	public static void drawcirclething(Graphics g, int t) {
		for (int i = 0; i < 400; i += 80) {
			if(var<120){
			var++;
			}
			else
				var=0;
			System.out.println(var);
		
			for (int j = 0; j < 400; j += 80) {
				g.drawRect(i , j , 100	, 100);
				g.drawRect(i+5 , j+5 , 100	, 100);
				g.drawRect(i-5 , j-5 , 100	, 100);
				g.drawRect(i , j , 100	, 100);
				g.drawRect(i+5 , j+5 , 50	, 50);
				g.drawRect(i-5 , j-5 , 50	, 50);
				for (int q = 10; q < 25; q += 5) {
					for (int p = 5; p < 50; p += 10) {
						Color f = new Color(var%255,var%255,var%255);
						g.setColor(f);
						g.fillRect(i+var , j+var , p	, q);
						Color e = new Color(255,var%255,var%255);
						g.setColor(e);
						g.fillRoundRect(i+var, j+var, p-10, q-10, 10, 10);
						Color c = new Color((int) (Math.random() * 255),
								(int) (Math.random() * 255),
								(int) (Math.random() * 255));
						int k = (int) (Math.random() * 20);
						int v = (int) (Math.random() * 20);
						g.setColor(c);
						//g.drawOval(i + k, j + v, p*2, p*2);

						k = (int) (Math.random() * 20);
						v = (int) (Math.random() * 20);
						g.fillOval(i + k+40, j + v+40 , q/2, q/2);
						g.fillOval((i / 40)+40, q+40, 3, 3);

					}
				}
			}
		}
	}
	
	public static void drawCircles(Graphics g, int t){
		for(int i =0; i<400; i+=4){
			var2 =0;
			
			for(int j =0; j< 400; j+=4){
				var2+=2;
				if (i==0 || j==0||i%40==0 || j%40==0){
					Color c= new Color((int)(Math.random() * 255) %20, 205+(int)(Math.random()*40),0+(int)(Math.random()*100) );
					g.setColor(c);
					g.fillRect(i, j, 10, 10);
					
				}
				else{
				Color d= new Color(205+(int)(Math.random()*40),0+(int)(Math.random()*10),0+var2 );
				g.setColor(d);
				g.fillRect(i, j, 10, 10);
				}
				
					
				}
			}
		}
	public static void drawCircles1(Graphics g, int t){
		for(int i =0; i<400; i+=4){
			var2 =0;
			
			for(int j =0; j< 400; j+=4){
				var2+=2;
				var3 +=.0001;
				if (i==0 || j==0||i%40==0 || j%40==0){
					Color c= new Color((int)var3%255, 205+(int)(Math.random()*40),0+(int)(Math.random()*100) );
					g.setColor(c);
					g.fillRect(i, j, 10, 10);
					
				}
				else{
				Color d= new Color((int)var3%255, 0+(int)(Math.random()*100),0+(int)var3%255 );
				g.setColor(d);
				g.fillRect(i, j, 10, 10);
				}
				
					
				}
			}
		}
	public static void drawCircles2(Graphics g, int t){
		for(int i =0; i<400; i+=20){
			var2 =0;
			
			for(int j =0; j< 400; j+=20){
				var2+=2;
				var3 +=.01;
				Color e= new Color(0, 0+(int)(Math.random()*100),0+(int)var3%255 );
				
				if (i==0 || j==0||i%40==0 || j%40==0){
					Color c= new Color((int)var3%255, 20+(int)(Math.random()*200),0+(int)(Math.random()*100) );
					g.setColor(c);
					//g.fillRect(i, j, 10, 10);
					
				}
				else{
					for(int k = i; k<400;k+=2){
						Color d= new Color(0, 0+(int)(Math.random()*100),0+(int)var3%255 );
						g.setColor(d);
						for(int l = j; l<400; l+=2){
							
							g.fillRect(k, l, 2, 2);
							
						}
					}
				
				}
				
					
				}
			}
		}
	public static void drawCircles3(Graphics g, int t){
		var2 =0;
		for(int i =0; i<400; i+=20){
			var2 ++;
			
			for(int j =0; j< 400; j+=20){
				var3 +=.01;
				Color e= new Color(0, 0+(int)(Math.random()*100),0+(int)var3%255 );
				g.setColor(e);
				g.drawLine(i, j, i, j);
			}
			}
		}
	public static void drawLines(Graphics g){
		
	}
}


