import java.awt.Color;

import acm.graphics.GArc;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: YinYang
 * 
 * If you are into esoteric science and philosophy you may have encountered the
 * YinYang symbol. Write a little a graphics program that draws the YinYang
 * symbol. Hint: the GArc class is helpful.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class YinYang extends GraphicsProgram {
	private final int DIAMETER = 150;

	public void run() {
		setSize(300, 200);

		int x = 0;
		int y = -48;

		// draw half black
		GArc blackHalf = new GArc(DIAMETER, DIAMETER, -90, 180);
		blackHalf.setFilled(true);
		blackHalf.setFillColor(Color.BLACK);
		add(blackHalf, x + DIAMETER / 2, y + DIAMETER / 2 - 25);

		// draw small white oval
		GOval smallWhiteOval = new GOval(DIAMETER / 2, DIAMETER / 2);
		smallWhiteOval.setFilled(true);
		smallWhiteOval.setColor(Color.WHITE);
		smallWhiteOval.setFillColor(Color.WHITE);
		add(smallWhiteOval, x + 3 * DIAMETER / 4, y + DIAMETER / 2 - 25);

		// draw small black oval
		GOval smallBlackOval = new GOval(DIAMETER / 2, DIAMETER / 2);
		smallBlackOval.setFilled(true);
		smallBlackOval.setColor(Color.BLACK);
		smallBlackOval.setFillColor(Color.BLACK);
		add(smallBlackOval, x + 3 * DIAMETER / 4, y + DIAMETER - 25);

		// draw small white oval
		GOval tinyBlackOval = new GOval(DIAMETER / 10, DIAMETER / 10);
		tinyBlackOval.setFilled(true);
		tinyBlackOval.setColor(Color.BLACK);
		tinyBlackOval.setFillColor(Color.BLACK);
		add(tinyBlackOval, x + DIAMETER, y + 7 * DIAMETER / 10 - 25);

		// draw small white oval
		GOval tinyWhiteOval = new GOval(DIAMETER / 10, DIAMETER / 10);
		tinyWhiteOval.setFilled(true);
		tinyWhiteOval.setColor(Color.WHITE);
		tinyWhiteOval.setFillColor(Color.WHITE);
		add(tinyWhiteOval, x + DIAMETER, y + 12 * DIAMETER / 10 - 25);

		// draw envelope
		GOval envelope = new GOval(DIAMETER, DIAMETER);
		add(envelope, x + DIAMETER / 2, y + DIAMETER / 2 - 25);
	}
}
