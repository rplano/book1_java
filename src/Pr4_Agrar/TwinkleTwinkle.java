import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: TwinkleTwinkle
 * 
 * Draw a random star map.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class TwinkleTwinkle extends GraphicsProgram {
	private final int WIDTH = 300;
	private final int HEIGHT = 200;
	private final int DELAY = 500;

	private RandomGenerator rgen = new RandomGenerator();

	public void run() {
		this.setSize(WIDTH, HEIGHT);
		setBackground(Color.BLACK);

		while (true) {
			int x = rgen.nextInt(WIDTH);
			int y = rgen.nextInt(HEIGHT);
			int size = rgen.nextInt(1, 4);
			GOval star = new GOval(size, size);
			star.setColor(Color.WHITE);
			star.setFilled(true);
			add(star, x, y);

			pause(DELAY);
		}
	}
}
