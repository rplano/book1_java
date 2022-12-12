import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: 1. Archery
 * 
 * Draw a target using three ovals.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Archery extends GraphicsProgram {
	// constants
	private final int OUTER_RED_RADIUS = 60;
	private final int MIDDLE_WHITE_RADIUS = 40;
	private final int INNER_RED_RADIUS = 20;

	public void run() {
		setSize(300, 200);

		println(OUTER_RED_RADIUS);
		println(MIDDLE_WHITE_RADIUS);
		println(INNER_RED_RADIUS);

		drawCircle(OUTER_RED_RADIUS, Color.RED);
		drawCircle(MIDDLE_WHITE_RADIUS, Color.WHITE);
		drawCircle(INNER_RED_RADIUS, Color.RED);
	}

	private void drawCircle(int radius, Color color) {
		GOval ring = new GOval(2 * radius, 2 * radius);
		ring.setColor(color);
		ring.setFilled(true);
		int x = 50 + 72 - radius;
		add(ring, x + 25, x - 48);
	}
}
