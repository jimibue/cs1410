package assign4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Animation1 {

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
	static int var5 = 0;
	static double var3 = 0.0;
	static double var4 = 0.0;

	static int counter1 = 0;

	public static void paintFrame(Graphics g, int t) {

		if (t < 200) {
			drawBackGround(g);
			drawcirclething(g, t);

			try {
				Thread.sleep(200 - (t % 200));

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		if (t > 200 && t <= 2000) {
			drawBackGround(g);
			drawcirclething(g, t);
		}
		if (t > 2000 && t <= 2200) {
			drawBackGround(g);
			drawthing(g, t);
			try {
				Thread.sleep(t % 1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		if (t > 2200 && t <= 2400) {
			drawBackGround(g);
			dc(g);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		if (t > 2400 && t <= 2600) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 400, 400);
			drawthing2(g, t);
			try {
				Thread.sleep(143);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		if (t > 2600 && t < 5600) {
			var5 += 1;

			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 400, 400);

			drawthing1(g, t);
			Font f = new Font(Font.MONOSPACED, Font.BOLD, 100);

			g.setFont(f);
			Color c = new Color((var5 + 100) % 255, var % 255, 10);
			g.setColor(c);
			g.drawString("FIN", 80, 400 - var5);
			g.drawString("YO!", 80, 525 - var5);
		}

	}// END PAINTFRAME

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

	public static void drawcirclething(Graphics g, int t) {
		for (int i = 0; i < 400; i += 80) {
			if (var < 120) {
				var++;
			} else
				var = 0;

			for (int j = 0; j < 400; j += 80) {

				g.drawRect(i, j, 100, 100);
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

	public static void drawthing(Graphics g, int t) {

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
						System.out.println(t);

					}
				}
			}
		}
	}

	public static void adrawCircles(Graphics g, double r, double gr, double b) {

		for (int i = 0; i < 400; i += 2) {
			for (int j = 0; j < 400; j += 2) {
				var2 += .00001;
				var3 += .031;
				var4 += .000235;
				if (i == 0 || j == 0 || i % 40 == 0 || j % 40 == 0) {
					Color c = new Color((int) (Math.random() * 255) % 20,
							205 + (int) (Math.random() * 40),
							0 + (int) (Math.random() * 100));
					g.setColor(c);
					g.fillRect(i, j, 10, 10);

				} else {
					Color d = new Color((int) r % 255, (int) gr % 255,
							(int) b % 255);
					g.setColor(d);
					g.fillRect(i, j, 1, 1);
					System.out.println((int) var3 % 255);
					r += 2;
					gr += 2;
					b += 3;
				}
			}
		}
	}

	public static void dc(Graphics g) {

		var2 += 1;
		var3 += .4;
		var4 += 5;
		adrawCircles(g, var2, var3, var4);

	}

	public static void drawthing2(Graphics g, int t) {

		for (int i = 0; i < 400; i += 100) {
			for (int j = 0; j < 400; j += 100) {
				for (int q = 10; q < 25; q += 5) {
					for (int p = 5; p < 50; p += 10) {
						Color c = new Color((int) (Math.random() * 255),
								(int) (Math.random() * 255),
								(int) (Math.random() * 255));
						int k = (int) (Math.random() * 20);
						int v = (int) (Math.random() * 20);
						g.setColor(c);
						g.drawRect((i + k) + 25, (j + v) + 25, p, p);

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

	public static void drawthing1(Graphics g, int t) {

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

}