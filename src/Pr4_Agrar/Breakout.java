import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: Breakout
 * 
 * A simple version of the Breakout game.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Breakout extends GraphicsProgram {
	// constants
	private final int DELAY = 20;
	private final int WIDTH = 400;
	private final int HEIGHT = 600;
	private final int BALL_SIZE = 20;
	private final int PADDLE_SEPARATION = 10;
	private final int PADDLE_HEIGHT = 10;
	private final int PADDLE_WIDTH = 50;
	private final int BRICK_WIDTH = 30;
	private final int BRICK_HEIGHT = 15;

	// instance variables
	private GRect paddle;
	private GOval ball;
	private int vx = 2;
	private int vy = 3;

	private RandomGenerator rgen = new RandomGenerator();

	public void run() {
		setup();
		waitForClick();
		while (true) {
			moveBall();
			checkForCollision();
			pause(DELAY);
		}
	}

	private void checkForCollision() {
		checkForCollisionWithWall();
		checkForCollisionWithPaddleOrBricks();
	}

	private void checkForCollisionWithPaddleOrBricks() {
		double x = ball.getX();
		double y = ball.getY();
		GObject obj = getElementAt(x, y);
		if (obj != null) {
			if (obj == paddle) {
				vy = -vy;
			} else {
				remove(obj);
				vy = -vy;
			}
		}
	}

	private void checkForCollisionWithWall() {
		double x = ball.getX();
		double y = ball.getY();
		if ((x < 0) || (x > getWidth())) {
			vx = -vx;
		}
		if (y < 0) {
			vy = -vy;
		}
	}

	private void moveBall() {
		ball.move(vx, vy);
	}

	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		paddle.setLocation(x, getHeight() - PADDLE_SEPARATION);
	}

	private void setup() {
		setSize(WIDTH, HEIGHT);

		createBall();
		createPaddle();
		createBricks();

		addMouseListeners();
	}

	private void createBricks() {
		int y = 50;
		for (int i = 0; i < 5; i++) {
			drawOneRowOfStones(y, 12);
			y += BRICK_HEIGHT;
		}
	}

	private void drawOneRowOfStones(int y, int n) {
		int x = -15;
		for (int i = 0; i < n; i++) {
			x += BRICK_WIDTH;
			GRect stone = new GRect(BRICK_WIDTH, BRICK_HEIGHT);
			stone.setFilled(true);
			stone.setFillColor(rgen.nextColor());
			add(stone, x, y);
		}
	}

	private void createPaddle() {
		paddle = new GRect(getWidth() / 2, getHeight() - PADDLE_SEPARATION,
				PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);
	}

	private void createBall() {
		ball = new GOval(getWidth() / 2, getHeight() / 2, BALL_SIZE, BALL_SIZE);
		ball.setFilled(true);
		add(ball);
	}
}
