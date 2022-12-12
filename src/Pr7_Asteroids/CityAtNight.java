import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: CityAtNight
 * 
 * A GraphicsProgram that reuses GHouse from Skyscraper to draw a city at night.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class CityAtNight extends GraphicsProgram {
	private RandomGenerator rgen = new RandomGenerator();

	public void run() {
		setSize(400, 300);
		setBackground(Color.DARK_GRAY);

		for (int i = 0; i < 8; i++) {
			int cols = rgen.nextInt(4, 6);
			int rows = rgen.nextInt(4, 8);
			int x = rgen.nextInt(0, getWidth() - 40); // 120
			int y = rgen.nextInt(getHeight() / 4, getHeight() / 2); // 30
			GSkyscraper h = new GSkyscraper(rows, cols);
			add(h, x, y);
		}
	}
}

class GSkyscraper extends GCompound {
	// private final int X_OFFSET = 7;
	private final int Y_OFFSET = 5;
	private final int WINDOW_WIDTH = 10;
	private final int WINDOW_HEIGHT = 20;
	private final int WINDOW_SEPERATION = 5;

	public GSkyscraper(int rows, int cols) {

		// add house
		GRect house = new GRect((WINDOW_WIDTH + WINDOW_SEPERATION) * cols,
				(WINDOW_HEIGHT + WINDOW_SEPERATION) * rows + Y_OFFSET / 2);
		house.setColor(Color.LIGHT_GRAY);
		house.setFilled(true);
		house.setFillColor(Color.BLACK);
		add(house);

		// add windows
		for (int i = 0; i < rows * cols; i++) {
			if (Math.random() < 0.3) {
				addWindow(i % cols * (WINDOW_WIDTH + WINDOW_SEPERATION) + 0
						+ WINDOW_SEPERATION / 2, (i / cols)
						* (WINDOW_HEIGHT + WINDOW_SEPERATION) + 0
						+ WINDOW_SEPERATION / 2 + Y_OFFSET);
			}
		}
	}

	private void addWindow(int x, int y) {
		GRect window = new GRect(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setFilled(true);
		window.setFillColor(Color.YELLOW);
		add(window, x, y);
	}
}
