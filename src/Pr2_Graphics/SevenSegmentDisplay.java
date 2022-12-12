import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: SevenSegmentDisplay
 * 
 * A GraphicsProgram that uses SevenSegmentDisplay.
 * 
 * @see https://en.wikipedia.org/wiki/Seven-segment_display
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class SevenSegmentDisplay extends GraphicsProgram {
	private final int WIDTH = 40;
	private final int HEIGHT = 80;
	private final int LED_WIDTH = 6;

	public void run() {
		setSize(300, 200);

		addSegments();
	}

	private void addSegments() {
		int x = (getWidth() - WIDTH) / 2;
		int y = 20;

		GRect upperFrontVertical = new GRect(LED_WIDTH, HEIGHT / 2);
		upperFrontVertical.setColor(Color.RED);
		upperFrontVertical.setFilled(true);
		add(upperFrontVertical, x + 0, y + LED_WIDTH);

		GRect upperBackVertical = new GRect(LED_WIDTH, HEIGHT / 2);
		upperBackVertical.setColor(Color.RED);
		upperBackVertical.setFilled(true);
		add(upperBackVertical, x + WIDTH + LED_WIDTH, y + LED_WIDTH);

		GRect lowerFrontVertical = new GRect(LED_WIDTH, HEIGHT / 2);
		lowerFrontVertical.setColor(Color.RED);
		lowerFrontVertical.setFilled(true);
		add(lowerFrontVertical, x + 0, y + HEIGHT / 2 + 2 * LED_WIDTH);

		GRect lowerBackVertical = new GRect(LED_WIDTH, HEIGHT / 2);
		lowerBackVertical.setColor(Color.RED);
		lowerBackVertical.setFilled(true);
		add(lowerBackVertical, x + WIDTH + LED_WIDTH, y + HEIGHT / 2 + 2
				* LED_WIDTH);

		GRect upperHorizontal = new GRect(WIDTH, LED_WIDTH);
		upperHorizontal.setColor(Color.RED);
		upperHorizontal.setFilled(true);
		add(upperHorizontal, x + LED_WIDTH, y + 0);

		GRect middleHorizontal = new GRect(WIDTH, LED_WIDTH);
		middleHorizontal.setColor(Color.RED);
		middleHorizontal.setFilled(true);
		add(middleHorizontal, x + LED_WIDTH, y + HEIGHT / 2 + LED_WIDTH);

		GRect lowerHorizontal = new GRect(WIDTH, LED_WIDTH);
		lowerHorizontal.setColor(Color.RED);
		lowerHorizontal.setFilled(true);
		add(lowerHorizontal, x + LED_WIDTH, y + HEIGHT + 2 * LED_WIDTH);
	}

}
