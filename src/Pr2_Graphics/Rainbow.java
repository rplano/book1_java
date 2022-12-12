import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: Rainbow
 * 
 * Draw a rainbow using a ovals.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Rainbow extends GraphicsProgram {
	private Color[] cols = { Color.RED, Color.ORANGE, Color.YELLOW,
			Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.WHITE };

	public void run() {
		setSize(300, 200);
		for (int i = 0; i < cols.length; i++) {
			drawCircle(i);
		}
	}

	private void drawCircle(int i) {
		int width = (10 - i) * 20;
		GOval ring = new GOval(width, width);
		ring.setFilled(true);
		ring.setColor(cols[i]);
		int x = 50 + i * 10;
		add(ring, x, x + 15);
	}

}
