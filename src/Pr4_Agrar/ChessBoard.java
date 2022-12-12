import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: ChessBoard
 * 
 * Draws a chess board pattern.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class ChessBoard extends GraphicsProgram {
	private final int WIDTH = 300;
	private final int HEIGHT = 300 + 44;

	private final int NUM_OF_SQUARES = 8;
	private final int size = WIDTH / NUM_OF_SQUARES;

	public void run() {
		this.setSize(WIDTH, HEIGHT);
		for (int i = 0; i < NUM_OF_SQUARES / 2; i++) {
			drawOneRow(0, 2 * i * size);
			drawOneRow(size, (2 * i + 1) * size);

		}
	}

	private void drawOneRow(int x, int y) {
		for (int i = 0; i < NUM_OF_SQUARES / 2; i++) {
			GRect square = new GRect(size, size);
			square.setFilled(true);
			add(square, x, y);
			x += 2 * size;
		}
	}

}
