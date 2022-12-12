import java.awt.Color;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: ConnectTwoMovingPoints
 * 
 * A GraphicsProgram that connects two moving points through lines.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class ConnectTwoMovingPoints extends GraphicsProgram {
	private final int SIZE = 300;
	private final int WIDTH = SIZE;
	private final int HEIGHT = SIZE;
	private final int V_MAX = 10;
	private final int DELAY = 30;
	private final int NR_OF_LINES = 20;

	private RandomGenerator rgen = new RandomGenerator();
	private GLine[] lines = new GLine[NR_OF_LINES];
	private int linePointer = 0;

	public void run() {
		this.setSize(WIDTH, HEIGHT + 44);
		setBackground(Color.BLACK);

		Point p1 = new Point();
		Point p2 = new Point();

		while (true) {
			p1.move();
			p2.move();
			checkForCollisionWithWall(p1);
			checkForCollisionWithWall(p2);
			drawConnection(p1, p2);
			pause(DELAY);
		}
	}

	private void drawConnection(Point p1, Point p2) {
		if (lines[linePointer] != null) {
			remove(lines[linePointer]);
		}
		GLine line = new GLine(p1.x, p1.y, p2.x, p2.y);
		line.setColor(Color.GREEN);
		add(line);
		lines[linePointer] = line;
		linePointer++;
		linePointer = linePointer % NR_OF_LINES;
	}

	private void checkForCollisionWithWall(Point p) {
		if (p.x < 0 || p.x > WIDTH) {
			p.vx = -p.vx;
		}
		if (p.y < 0 || p.y > HEIGHT) {
			p.vy = -p.vy;
		}
	}

	class Point {
		public int x;
		public int y;
		public int vx;
		public int vy;

		public Point() {
			x = rgen.nextInt(WIDTH);
			y = rgen.nextInt(HEIGHT);
			vx = rgen.nextInt(-V_MAX, V_MAX);
			vy = rgen.nextInt(-V_MAX, V_MAX);
		}

		public void move() {
			x += vx;
			y += vy;
		}
	}

}
