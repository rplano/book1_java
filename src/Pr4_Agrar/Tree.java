import acm.graphics.GLine;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: Tree
 * 
 * This program uses recursion to draw a tree.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Tree extends GraphicsProgram {

	private final double SCALE_LEFT = 0.70;
	private final double SCALE_MIDDLE = 0.50;
	private final double SCALE_RIGHT = 0.70;
	private final double ANGLE_MIDDLE = 10;
	private final double ANGLE_LEFT = 20 + ANGLE_MIDDLE;
	private final double ANGLE_RIGHT = -20 + ANGLE_MIDDLE;

	public void run() {
		setSize(300, 300);
		drawTree(6);
	}

	private void drawTree(int n) {
		int x = getWidth() / 2;
		int y = getHeight();
		int length = 70;
		int angle = 90;
		drawBranches(n, x, y, length, angle);
	}

	private void drawBranches(int n, int x, int y, double length, double angle) {
		// stemm
		drawLine(x, y, length, angle);

		if (n > 0) {
			// branches
			int x1 = x + (int) (length * Math.cos(-angle * Math.PI / 180.0));
			int y1 = y + (int) (length * Math.sin(-angle * Math.PI / 180.0));
			n--;
			drawBranches(n, x1, y1, length * SCALE_LEFT, angle + ANGLE_LEFT);
			drawBranches(n, x1, y1, length * SCALE_MIDDLE, angle + ANGLE_MIDDLE);
			drawBranches(n, x1, y1, length * SCALE_RIGHT, angle + ANGLE_RIGHT);
		}
	}

	private void drawLine(int x, int y, double length, double angle) {
		int x1 = x + (int) (length * Math.cos(-angle * Math.PI / 180.0));
		int y1 = y + (int) (length * Math.sin(-angle * Math.PI / 180.0));
		GLine line = new GLine(x, y, x1, y1);
		add(line);
	}
}
