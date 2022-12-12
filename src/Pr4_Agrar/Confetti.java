import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: Confetti
 * 
 * Draw confetti on the screen.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Confetti extends GraphicsProgram {
	private final int WIDTH = 300;
	private final int HEIGHT = 200;
	private final int SIZE = 20;
	private final int DELAY = 40;

	private RandomGenerator rgen = new RandomGenerator();

	public void run() {
		this.setSize(WIDTH, HEIGHT);

		while (true) {
			// create randomly sized rect
			double width = rgen.nextDouble(SIZE / 2, SIZE);
			GOval rect = new GOval(width, width);

			// set random color of rect
			rect.setFilled(true);
			rect.setColor(rgen.nextColor());

			// put rect at random position
			double x = rgen.nextDouble(-WIDTH / 2, WIDTH);
			double y = rgen.nextDouble(-HEIGHT / 2, HEIGHT);
			add(rect, x, y);

			pause(DELAY);
		}
	}
}
