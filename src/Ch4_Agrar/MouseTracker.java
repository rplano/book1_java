import java.awt.event.MouseEvent;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: 7. MouseTracker
 * 
 * Draws a label with the mouse position at the position where the mouse is.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class MouseTracker extends GraphicsProgram {
	// constants
	private final int WIDTH = 300;
	private final int HEIGHT = 200;

	// instance variables
	private GLabel lbl;

	public void run() {
		setSize(WIDTH, HEIGHT);

		lbl = new GLabel("");
		lbl.setFont("Arial-bold-20");
		add(lbl, 0, 0);

		addMouseListeners();
	}

	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		lbl.setLabel("x=" + x + ",y=" + y);
		lbl.setLocation(x, y);
	}
}
