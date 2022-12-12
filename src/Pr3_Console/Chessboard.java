import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: Checkerboard
 * 
 * A GraphicsProgram that draws a checker board on the screen using GRects.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Chessboard extends GraphicsProgram {
	private final int NROWS = 8;
	private final int NCOLUMNS = 8;

	public void run() {
		setSize(300, 344);

		int x = 0;
		int y = 0;
		int width = getWidth() / NCOLUMNS;
		for (int j = 0; j < NROWS; j++) {
			for (int i = 0; i < NCOLUMNS; i++) {
				GRect field = new GRect(width, width);
				if (((i + j) % 2) == 0) {
					field.setFilled(true);
				}
				add(field, x, y);
				x = x + width;
			}
			y = y + width;
			x = 0;
		}

	}

}
