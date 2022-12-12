import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: ConnectTheClicks
 * 
 * A simple drawing program. As the user clicks on the screen, the program
 * connects the clicks through lines.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class ConnectTheClicks extends GraphicsProgram {
	private int x0 = -1;
	private int y0 = -1;

	public void init() {
		setSize(300, 300);
		addMouseListeners();
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (x0 > -1) {
			GLine line = new GLine(x0, y0, x, y);
			add(line);
		}
		x0 = x;
		y0 = y;
	}
}
