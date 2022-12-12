import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: TrafficLight
 * 
 * Draw a traffic light using a rect and ovals.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class TrafficLight extends GraphicsProgram {
	private final int SIZE = 30;
	private final int OFFSET = 10;

	public void run() {
		setSize(300, 200);
		GRect housing = new GRect(SIZE + OFFSET, (SIZE + OFFSET) * 3);
		housing.setFilled(true);
		int pos = 30;
		add(housing, pos + 100, pos - 15);

		int x = pos + 100 + OFFSET / 2;
		int y = pos + OFFSET - 15;
		drawLight(x, y, Color.RED);
		y += SIZE + OFFSET / 2;
		drawLight(x, y, Color.YELLOW);
		y += SIZE + OFFSET / 2;
		drawLight(x, y, Color.GREEN);
	}

	private void drawLight(int x, int y, Color col) {
		GOval light = new GOval(SIZE, SIZE);
		light.setFilled(true);
		light.setColor(col);
		add(light, x, y);
	}
}
