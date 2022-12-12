import acm.graphics.GLine;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: DrunkenWalk
 * 
 * Draws the path of drunken Karel.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class DrunkenWalk extends GraphicsProgram {

	private final int WIDTH = 300;
	private final int HEIGHT = 300;

	private final int STEP_SIZE = 15;
	private final int DELAY = 100;

	public void run() {
		setSize(WIDTH, HEIGHT);
		RandomGenerator rgen = RandomGenerator.getInstance();
		int x0 = WIDTH / 2;
		int y0 = HEIGHT / 2;
		int x1 = x0;
		int y1 = y0;
		while (true) {
			GLine walk = new GLine(x0, y0, x1, y1);
			add(walk);
			x1 = x0;
			y1 = y0;
			x0 += rgen.nextInt(-STEP_SIZE, STEP_SIZE);
			y0 += rgen.nextInt(-STEP_SIZE, STEP_SIZE);
			pause(DELAY);
		}
	}
}
