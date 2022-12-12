import java.awt.Color;

import acm.graphics.*;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: 6. Polymorphism
 * 
 * Shows an example for polymorphism using the ACM graphics library.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Polymorphism extends GraphicsProgram {

	public void run() {
		setSize(300, 200);

		GRect frankWalter = new GRect(50, 30);
		add(frankWalter, 50, 50);
		fillWithRedColor(frankWalter);

		for (int i = 0; i < 10; i++) {
			moveByTenPixelToLeft(frankWalter);
			pause(1000);
		}
	}

	public void fillWithRedColor(GFillable rect) {
		rect.setFilled(true);
		rect.setFillColor(Color.RED);
	}

	public void moveByTenPixelToLeft(GObject rect) {
		rect.move(10, 0);
	}
}