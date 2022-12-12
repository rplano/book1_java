import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: RandomSquares
 * 
 * Draws randomly colored and sized rectangles.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class RandomSquares extends GraphicsProgram {
	private final int WIDTH = 300;
	private final int HEIGHT = 300;

	private final int DELAY = 100;

	public void run() {
		this.setSize(WIDTH, HEIGHT);

		RandomGenerator rgen = new RandomGenerator();

		while (true) {
			// create randomly sized rect
			double width = rgen.nextDouble(0, WIDTH / 2);
			double height = rgen.nextDouble(0, HEIGHT / 2);
			GRect rect = new GRect(width, height);

			// set random color of rect
			rect.setFilled(true);
			rect.setFillColor(rgen.nextColor());

			// put rect at random position
			double x = rgen.nextDouble(-WIDTH / 2, WIDTH);
			double y = rgen.nextDouble(-HEIGHT / 2, HEIGHT);
			add(rect, x, y);

			pause(DELAY);
		}
	}
}
