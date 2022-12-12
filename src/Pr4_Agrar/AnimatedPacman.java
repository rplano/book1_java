import java.awt.Color;

import acm.graphics.GArc;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: AnimatedPacman
 * 
 * Draws an animated Pacman.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class AnimatedPacman extends GraphicsProgram {
	private final int DELAY = 50;

	public void run() {
		setSize(300, 200);

		GArc pacman = new GArc(150, 150, 0, 360);
		pacman.setFilled(true);
		pacman.setFillColor(Color.YELLOW);
		add(pacman, 75, 2);
		GOval eye = new GOval(15, 15);
		eye.setFilled(true);
		add(eye, 145, 32);

		int angle = 0;
		int step = 5;
		while (true) {
			pacman.setStartAngle(angle);
			pacman.setSweepAngle(360 - 2 * angle);
			angle += step;
			if (angle > 40 || angle <= 1) {
				step = -step;
			}
			pause(DELAY);
		}

	}
}
