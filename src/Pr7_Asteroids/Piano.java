import java.applet.AudioClip;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: Piano
 * 
 * A GraphicsProgram that simulates a piano, plays tunes based on mouse click.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Piano extends GraphicsProgram {
	private final int WIDTH = 300;
	private final int HEIGHT = 200;
	private final int HEIGHT_OFFSET = 1;

	private GRect[] keys = new GRect[12];

	private String[] tunes = { "F", "G", "A", "B", "C", "D", "E", "Fs", "Gs",
			"As", "Cs", "Ds" };

	public void run() {
		setup();
	}

	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		GObject obj = getElementAt(x, y);
		if (obj != null) {
			for (int i = 0; i < keys.length; i++) {
				if (obj == keys[i]) {
					AudioClip audioClip = getAudioClip(getCodeBase(), "music/"
							+ tunes[i] + "4.wav");
					println(tunes[i] + "4.wav");
					audioClip.play();
				}
			}
		}
	}

	private void setup() {
		setSize(WIDTH, HEIGHT);
		addMouseListeners();

		int keyCounter = 0;

		// draw 8 white keys
		for (int i = 0; i < 7; i++) {
			keys[keyCounter] = new GRect(WIDTH / 7, HEIGHT - HEIGHT_OFFSET);
			add(keys[keyCounter], i * WIDTH / 7, 0);
			keyCounter++;
		}

		// draw 3 + 2 black keys
		for (int i = 0; i < 3; i++) {
			keys[keyCounter] = new GRect(WIDTH / 12, HEIGHT / 2);
			keys[keyCounter].setFilled(true);
			add(keys[keyCounter], i * WIDTH / 7 + WIDTH / 7 / 2 + 10, 0);
			keyCounter++;
		}
		for (int i = 0; i < 2; i++) {
			keys[keyCounter] = new GRect(WIDTH / 12, HEIGHT / 2);
			keys[keyCounter].setFilled(true);
			add(keys[keyCounter], i * WIDTH / 7 + 9 * WIDTH / 7 / 2 + 10, 0);
			keyCounter++;
		}
	}
}
