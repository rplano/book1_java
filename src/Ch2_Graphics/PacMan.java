import java.awt.Color;

import acm.graphics.*;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: 6. PacMan
 * 
 * Draw a PacMan using a GArc.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class PacMan extends GraphicsProgram {

	public void run() {
		setSize(300, 200);
		GArc pacman = new GArc(150, 150, 45, 270);
		pacman.setFilled(true);
		pacman.setFillColor(Color.YELLOW);
		add(pacman, 75, 2);
	}

}
