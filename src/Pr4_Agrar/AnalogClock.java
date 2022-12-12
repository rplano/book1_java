import java.util.Date;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: AnalogClock
 * 
 * Draws an animated analog clock.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class AnalogClock extends GraphicsProgram {
	private final int SIZE = 300;
	private final int FUDGE = 4;
	private final int WIDTH = SIZE + FUDGE;
	private final int HEIGHT = SIZE + FUDGE + 43;

	private final int DELAY = 500;

	private GLine hoursHand;
	private GLine minutesHand;
	private GLine secondsHand;

	public void run() {
		setup();
		while (true) {
			drawHands();
			pause(DELAY);
		}
	}

	private void drawHands() {
		Date time = new Date();
		System.out.println(time.getMinutes());
		drawHours(time.getHours());
		drawMinutes(time.getMinutes());
		drawSeconds(time.getSeconds());

	}

	private void drawHours(int hours) {
		hours = hours % 12;
		double radians = 2 * Math.PI * hours / 12;
		double lengthHourHand = 150;
		double x = SIZE / 2 + Math.sin(radians) * lengthHourHand / 2;
		double y = SIZE / 2 - Math.cos(radians) * lengthHourHand / 2;
		hoursHand.setEndPoint(x, y);
	}

	private void drawMinutes(int minutes) {
		double radians = 2 * Math.PI * minutes / 60;
		double lengthMinuteHand = 200;
		double x = SIZE / 2 + Math.sin(radians) * lengthMinuteHand / 2;
		double y = SIZE / 2 - Math.cos(radians) * lengthMinuteHand / 2;
		minutesHand.setEndPoint(x, y);
	}

	private void drawSeconds(int seconds) {
		double radians = 2 * Math.PI * seconds / 60;
		double lengthSecondHand = 250;
		double x = SIZE / 2 + Math.sin(radians) * lengthSecondHand / 2;
		double y = SIZE / 2 - Math.cos(radians) * lengthSecondHand / 2;
		secondsHand.setEndPoint(x, y);
	}

	private void setup() {
		setSize(WIDTH, HEIGHT);
		drawFace();
		drawHours();
		hoursHand = new GLine(SIZE / 2, SIZE / 2, SIZE / 2, SIZE / 2);
		add(hoursHand);
		minutesHand = new GLine(SIZE / 2, SIZE / 2, SIZE / 2, SIZE / 2);
		add(minutesHand);
		secondsHand = new GLine(SIZE / 2, SIZE / 2, SIZE / 2, SIZE / 2);
		add(secondsHand);
	}

	private void drawHours() {
		for (int i = 1; i <= 12; i++) {
			GLabel digit = new GLabel("" + i);
			digit.setFont("Times New Roman-bold-24");
			double radians = 2 * Math.PI * i / 12;
			double radius = SIZE - 40;
			double x = -6 + SIZE / 2 + Math.sin(radians) * radius / 2;
			double y = 10 + SIZE / 2 - Math.cos(radians) * radius / 2;
			add(digit, x, y);
		}
	}

	private void drawFace() {
		GOval face = new GOval(SIZE, SIZE);
		add(face);
	}
}
