import java.awt.Color;

import acm.graphics.*;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: Skyscraper
 * 
 * Draw a skyscraper using a rects.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Skyscraper extends GraphicsProgram {

	public void run() {
		setSize(300, 250);
		setBackground(Color.DARK_GRAY);
		
		GRect house = new GRect(100, 200);
		house.setFilled(true);
		house.setFillColor(Color.BLACK);
		add(house, 120, 30);
		for (int i = 0; i < 50; i++) {
			if (Math.random() < 0.3) {
				addWindow(i % 6 * 15 + 127, (i / 6) * 25 + 55);
			}
		}
	}

	private void addWindow(int x, int y) {
		GRect window = new GRect(10, 20);
		window.setFilled(true);
		window.setFillColor(Color.YELLOW);
		add(window, x, y);
	}

}
