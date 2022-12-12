import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: OlympicGames
 * 
 * Draw the olympic rings using a ovals.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class OlympicGames extends GraphicsProgram {
	private int width = 5;
	private int size = 70;
	private int sep = 10;

	public void run() {
		setSize(300, 200);
		int x = 30;
		int y = 25;
		drawRing(x, y, Color.BLUE);
		x += size + sep;
		drawRing(x, y, Color.BLACK);
		x += size + sep;
		drawRing(x, y, Color.RED);
		x = 30 + size / 2 + sep / 2;
		y += size / 2;
		drawRing(x, y, Color.YELLOW);
		x += size + sep;
		drawRing(x, y, Color.GREEN);
	}

	private void drawRing(int x, int y, Color col) {
		for (int i = 0; i < width; i++) {
			GOval ring1 = new GOval(size - i * 2, size - i * 2);
			ring1.setColor(col);
			add(ring1, x++, y++);
		}
	}

	private void drawRing2(int x, int y, Color col) {
		GOval ring1 = new GOval(size, size);
		ring1.setFilled(true);
		ring1.setColor(col);
		add(ring1, x, y);
		GOval ring = new GOval(size - width * 2, size - width * 2);
		ring.setFilled(true);
		ring.setColor(Color.WHITE);
		add(ring, x + width, y + width);
	}

}
