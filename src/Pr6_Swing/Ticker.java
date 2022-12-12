import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: Ticker
 * 
 * A Swing program that displays running text using a JLabel.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Ticker extends GraphicsProgram {
	private final int FONT_SIZE = 24;
	private final int WIDTH = 300;
	private final int HEIGHT = FONT_SIZE + 52;
	private final int DELAY = 50;

	public void run() {
		this.setSize(WIDTH, HEIGHT);
		GLabel lbl1 = new GLabel(
				"Hello World!              Hello World!              Hello World!");
		lbl1.setFont("SansSerif-" + FONT_SIZE);
		add(lbl1, WIDTH + 1, lbl1.getAscent());
		while (true) {
			lbl1.move(-5, 0);
			pause(DELAY);
		}
	}
}
