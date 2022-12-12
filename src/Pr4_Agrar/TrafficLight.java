import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: TrafficLight
 * 
 * Draw an animated traffic light.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class TrafficLight extends GraphicsProgram {
	// constants
	private final int SIZE = 30;
	private final int OFFSET = 10;
	private final int DELAY = 1000;

	// instance variables
	private GOval redLight;
	private GOval yellowLight;
	private GOval greenLight;

	private int currentLight = 0;

	public void run() {
		setup();

		// game loop
		while (true) {
			switchLight();
			pause(DELAY);
		}
	}

	private void switchLight() {
		if (currentLight == 0) {
			redLight.setColor(Color.RED);
			yellowLight.setColor(Color.BLACK);
			greenLight.setColor(Color.BLACK);
		} else if (currentLight == 1) {
			redLight.setColor(Color.RED);
			yellowLight.setColor(Color.YELLOW);
			greenLight.setColor(Color.BLACK);
		} else {
			redLight.setColor(Color.BLACK);
			yellowLight.setColor(Color.BLACK);
			greenLight.setColor(Color.GREEN);
		}
		currentLight++;
		currentLight = currentLight % 3;
	}

	private void setup() {
		setSize(300, 200);
		int pos = 30;

		GRect housing = new GRect(SIZE + OFFSET, (SIZE + OFFSET) * 3);
		housing.setFilled(true);
		add(housing, pos + 100, pos - 15);

		int x = pos + 100 + OFFSET / 2;
		int y = pos + OFFSET - 15;
		redLight = new GOval(SIZE, SIZE);
		drawLight(redLight, x, y, Color.RED);
		y += SIZE + OFFSET / 2;
		yellowLight = new GOval(SIZE, SIZE);
		drawLight(yellowLight, x, y, Color.YELLOW);
		y += SIZE + OFFSET / 2;
		greenLight = new GOval(SIZE, SIZE);
		drawLight(greenLight, x, y, Color.GREEN);
	}

	private void drawLight(GOval light, int x, int y, Color col) {
		light.setFilled(true);
		light.setColor(col);
		add(light, x, y);
	}
}
