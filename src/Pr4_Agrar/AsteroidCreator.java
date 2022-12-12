import java.awt.event.MouseEvent;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: AsteroidCreator
 * 
 * Draws an asteroid at the location where the mouse was pressed.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class AsteroidCreator extends GraphicsProgram {
	private RandomGenerator rgen = new RandomGenerator();

	public void init() {
		setSize(300, 200);
		addMouseListeners();
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int size = rgen.nextInt(10, 50);
		GRect asteroid = new GRect(size, size);
		add(asteroid, x, y);
	}
}