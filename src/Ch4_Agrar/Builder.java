import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: 6. Builder
 * 
 * Draw little blocks at the position the mouse was pressed.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Builder extends GraphicsProgram {
	// constants
	private final int WIDTH = 300;
	private final int HEIGHT = 300;
	private final int BLOCK_SIZE = 25;

	public void run() {
		setSize(WIDTH, HEIGHT + 44);
		addMouseListeners();
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		x = x / BLOCK_SIZE * BLOCK_SIZE;
		y = y / BLOCK_SIZE * BLOCK_SIZE;
		GRect block = new GRect(BLOCK_SIZE, BLOCK_SIZE);
		block.setColor(Color.RED);
		block.setFilled(true);
		block.setFillColor(Color.YELLOW);
		add(block, x, y);
	}
}
