import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: Mandelbrot
 * 
 * A GraphicsProgram that draws the Mandelbrot set.
 * 
 * @see https://en.wikipedia.org/wiki/Mandelbrot_set
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Mandelbrot extends GraphicsProgram {
	private final int WIDTH = 400;
	private final int HEIGHT = 400;

	private final int MAX_ITERATION = 1000;

	private final int RAINBOW_COLOR_STEP = 10; // 10 * 6
	private final int RAINBOW_NR_OF_COLORS = 10 * 6;
	private Color[] RAINBOW_COLORS = new Color[RAINBOW_NR_OF_COLORS];

	private double xMin = -2.0;
	private double xMax = 1.0;
	private double yMin = -1.5;
	private double yMax = 1.5;

	public void run() {
		this.setSize(WIDTH, HEIGHT + 44);
		initColorTable();

		double xStep = (xMax - xMin) / WIDTH;
		double yStep = (yMax - yMin) / HEIGHT;
		for (double x = xMin; x < xMax; x += xStep) {
			int i = 0;
			for (double y = yMin; y < yMax; y += yStep) {
				Color col = function(x, y);
				// println(i+","+(i % RAINBOW_NR_OF_COLORS));
				setPixel(x, y, col);
			}
		}
	}

	private Color function(double x0, double y0) {
		double x = 0.0;
		double y = 0.0;
		int iteration = 0;
		while (x * x + y * y < 4 && iteration < MAX_ITERATION) {
			double xtemp = x * x - y * y + x0;
			y = 2 * x * y + y0;
			x = xtemp;
			iteration++;
		}
		return RAINBOW_COLORS[iteration % RAINBOW_NR_OF_COLORS];
	}

	private void setPixel(double x, double y, Color color) {
		int i = (int) (((x - xMin) * WIDTH) / (xMax - xMin));
		int j = (int) (((y - yMin) * HEIGHT) / (yMax - yMin));
		GRect r = new GRect(1, 1);
		// int color = (int) ((col + 1.0) * 255) / 2;
		// r.setColor(new Color(color, color, color));
		r.setColor(color);
		add(r, i, j);
	}

	private void initColorTable() {
		int i = 0;
		for (int r = 0; r < RAINBOW_COLOR_STEP; r++) {
			RAINBOW_COLORS[i] = new Color(r * 255 / RAINBOW_COLOR_STEP, 255, 0);
			i++;
		}
		for (int g = RAINBOW_COLOR_STEP; g > 0; g--) {
			RAINBOW_COLORS[i] = new Color(255, g * 255 / RAINBOW_COLOR_STEP, 0);
			i++;
		}
		for (int b = 0; b < RAINBOW_COLOR_STEP; b++) {
			RAINBOW_COLORS[i] = new Color(255, 0, b * 255 / RAINBOW_COLOR_STEP);
			i++;
		}
		for (int r = RAINBOW_COLOR_STEP; r > 0; r--) {
			RAINBOW_COLORS[i] = new Color(r * 255 / RAINBOW_COLOR_STEP, 0, 255);
			i++;
		}
		for (int g = 0; g < RAINBOW_COLOR_STEP; g++) {
			RAINBOW_COLORS[i] = new Color(0, g * 255 / RAINBOW_COLOR_STEP, 255);
			i++;
		}
		for (int b = RAINBOW_COLOR_STEP; b > 0; b--) {
			RAINBOW_COLORS[i] = new Color(0, 255, b * 255 / RAINBOW_COLOR_STEP);
			i++;
		}
		// RAINBOW_COLORS[i] = new Color(0, 255, 0);
	}

}
