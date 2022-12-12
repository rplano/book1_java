import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: 2. Wall
 * 
 * Draw a brick wall using rects.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Wall extends GraphicsProgram {

	public void run() {
		setSize(300, 200);
		for (int j = 0; j < 3; j++) {
			drawRowOfNBricks(j);
		}
	}

	private void drawRowOfNBricks(int j) {
		int x = 70; // beginning x position of wall
		int y = 108 + j * 15; // beginning y position of wall
		for (int i = 0; i < 5; i++) {
			GRect brick = new GRect(30, 15);
			add(brick, x, y);
			x = x + 30;
		}
	}
}
