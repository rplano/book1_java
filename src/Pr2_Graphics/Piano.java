import java.applet.AudioClip;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: Piano
 * 
 * Draw the keys of a piano.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Piano extends GraphicsProgram {
	public static final int WIDTH = 300;
	public static final int HEIGHT = 200;
	public static final int HEIGHT_OFFSET = 1;

	public void run() {
		setSize(WIDTH, HEIGHT);

		// draw 8 white keys
		for (int i = 0; i < 7; i++) {
			GRect whiteKeys = new GRect(WIDTH / 7, HEIGHT - HEIGHT_OFFSET);
			add(whiteKeys, i * WIDTH / 7, 0);
		}

		// draw 3 + 2 black keys
		for (int i = 0; i < 3; i++) {
			GRect blackKeys = new GRect(WIDTH / 12, HEIGHT / 2);
			blackKeys.setFilled(true);
			add(blackKeys, i * WIDTH / 7 + WIDTH / 7 / 2 + 10, 0);
		}
		for (int i = 0; i < 2; i++) {
			GRect blackKeys = new GRect(WIDTH / 12, HEIGHT / 2);
			blackKeys.setFilled(true);
			add(blackKeys, i * WIDTH / 7 + 9 * WIDTH / 7 / 2 + 10, 0);
		}
	}
}
