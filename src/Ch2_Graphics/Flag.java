import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: 2. Flag
 * 
 * Write a graphics program that draws the flag of a country you like to visit.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Flag extends GraphicsProgram {
	private final int FLAG_WIDTH = 150;
	private final int FLAG_HEIGHT = 90;

	public void run() {
		setSize(300, 200);

		GRect black = new GRect(FLAG_WIDTH, FLAG_HEIGHT / 3);
		black.setFilled(true);
		black.setColor(Color.BLACK);
		add(black, 70, 30);

		GRect red = new GRect(FLAG_WIDTH, FLAG_HEIGHT / 3);
		red.setFilled(true);
		red.setColor(Color.RED);
		add(red, 70, 30 + FLAG_HEIGHT / 3);

		GRect yellow = new GRect(FLAG_WIDTH, FLAG_HEIGHT / 3);
		yellow.setFilled(true);
		yellow.setColor(Color.YELLOW);
		add(yellow, 70, 30 + 2 * FLAG_HEIGHT / 3);
	}

}
