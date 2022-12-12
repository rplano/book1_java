import java.awt.Color;

import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: 5. Billiards
 * 
 * Animate a ball moving around inside the screen area.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Billiards extends GraphicsProgram {
	// constants
	private final int WIDTH = 300;
	private final int HEIGHT = 300;
	private final int BALL_SIZE = 20;
	private final int DELAY = 48;

	// instance variables
	private GOval ball;
	private GLabel lbl;
	private int vx = 4;
	private int vy = -3;

	public void run() {
		setup();

		// game loop
		while (true) {
			moveBall();
			checkForCollisionsWithWall();
			pause(DELAY);
		}
	}

	private void moveBall() {
		ball.move(vx, vy);
		lbl.move(vx, vy);
	}

	private void checkForCollisionsWithWall() {
		double x = ball.getX();
		double y = ball.getY();
		if ((x < 0) || (x > WIDTH)) {
			vx = -vx;
		}
		if ((y < 0) || (y > HEIGHT)) {
			vy = -vy;
		}
	}

	private void setup() {
		setSize(WIDTH, HEIGHT + 44);

		setBackground(Color.GREEN);

		ball = new GOval(BALL_SIZE, BALL_SIZE);
		ball.setFilled(true);
		add(ball, WIDTH / 2, HEIGHT / 2);
		lbl = new GLabel("8");
		lbl.setColor(Color.WHITE);
		lbl.setFont("Arial-bold-20");
		add(lbl, WIDTH / 2 + 5, HEIGHT / 2 + 18);
	}
}
