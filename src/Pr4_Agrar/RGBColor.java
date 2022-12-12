import java.awt.Color;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: RGBColor
 * 
 * This program draws the RGB color room.
 * 
 * @see https://en.wikipedia.org/wiki/HSL_and_HSV
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class RGBColor extends GraphicsProgram {
	private final int WIDTH = 300;
	private final int HEIGHT = 200;
	private final int CELL_COLOR_STEP = WIDTH / 6; // + 1;
	
	public void run() {
		setSize(WIDTH, HEIGHT);

		for (int x = 0; x < WIDTH; x++) {
			int choice = x / CELL_COLOR_STEP;
			drawColorLines(choice, x);
		}
	}

	private void drawColorLines(int choice, int x) {
		int r = x % CELL_COLOR_STEP;

		// pick color
		Color col = Color.WHITE;
		switch (choice) {
		case 0:
			col = new Color(255, r * 255 / CELL_COLOR_STEP, 0);
			break;
		case 1:
			col = new Color(255-r * 255 / CELL_COLOR_STEP, 255, 0);
			break;
		case 2:
			col = new Color(0, 255, r * 255 / CELL_COLOR_STEP);
			break;
		case 3:
			col = new Color(0, 255-r * 255 / CELL_COLOR_STEP, 255);
			break;
		case 4:
			col = new Color(r * 255 / CELL_COLOR_STEP, 0, 255);
			break;
		case 5:
			col = new Color(255, 0, 255-r * 255 / CELL_COLOR_STEP);
			break;
		}
		
		// draw line
		GLine line = new GLine(x, 0, x, HEIGHT);
		line.setColor(col);
		add(line);
	}
}
