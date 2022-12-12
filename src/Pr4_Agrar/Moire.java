import acm.graphics.GLine;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: Moire
 * 
 * Draws a simple Moire pattern.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Moire extends GraphicsProgram {
	private final int WIDTH = 300;
	private final int HEIGHT = 300;
	private final int NR_OF_LINES = 11;

	public void run() {
		this.setSize(WIDTH, HEIGHT + 50);

		int dX = WIDTH / (NR_OF_LINES - 1);
		int dY = HEIGHT / (NR_OF_LINES - 1);

		for (int i = 0; i < NR_OF_LINES; i++) {
			for (int j = 0; j < NR_OF_LINES; j++) {
				GLine line = new GLine(i * dX, 0, j * dY, HEIGHT);
				add(line);
			}
		}

		for (int i = 0; i < NR_OF_LINES; i++) {
			for (int j = 0; j < NR_OF_LINES; j++) {
				GLine line = new GLine(0, i * dX, HEIGHT, j * dY);
				add(line);
			}
		}

	}
}
