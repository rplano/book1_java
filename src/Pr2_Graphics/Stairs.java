import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: Stairs
 * 
 * Draw stairs using rects.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Stairs extends GraphicsProgram {

	public void run() {
		setSize(300, 200);
		for (int i = 0; i < 10; i++) {
			drawOneRowOfStones(i);
		}
	}

	private void drawOneRowOfStones(int n) {
		int x = -15;
		int y = 3 + 15 * n;
		for (int i = 0; i < n; i++) {
			x += 30;
			GRect stone = new GRect(30, 15);
			add(stone, x, y);
		}
	}

}
