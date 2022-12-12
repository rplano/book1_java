import java.awt.event.KeyEvent;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Agrar: Pong
 * 
 * A simple version of the game of Pong, a little like ping-pong.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Pong extends GraphicsProgram {
	private final int DELAY = 20;
	private final int WIDTH = 600;
	private final int HEIGHT = 400;
	private final int BALL_SIZE = 20;
	private final int PADDLE_SEPARATION = 10;
	private final int PADDLE_VY = 20;
	private final int PADDLE_HEIGHT = 60;
	private final int PADDLE_WIDTH = 10;

	private GOval ball;
	private GRect leftPaddle;
	private GRect rightPaddle;

	private int vx = 2;
	private int vy = 3;

	public void run() {
		setup();
		waitForClick();
		while (true) {
			moveBall();
			checkForCollision();
			pause(DELAY);
		}
	}

	public void keyPressed(KeyEvent e) {
		char c = e.getKeyChar();
		switch (c) {
		case 'p': // right paddle up
			rightPaddle.move(0, -PADDLE_VY);
			break;
		case 'l': // right paddle down
			rightPaddle.move(0, PADDLE_VY);
			break;
		case 'q': // left paddle up
			leftPaddle.move(0, -PADDLE_VY);
			break;
		case 'a': // left paddle down
			leftPaddle.move(0, PADDLE_VY);
			break;
		}
	}

	private void checkForCollision() {
		checkForCollisionWithWall();
		checkForCollisionWithPaddle(leftPaddle);
		checkForCollisionWithPaddle(rightPaddle);
	}

	private void checkForCollisionWithPaddle(GRect paddle) {
		double x = ball.getX();
		double y = ball.getY();

		GObject obj = getElementAt(x, y);
		if ((obj != null) && (obj == paddle)) {
			vx = -vx;
			return;
		}
		obj = getElementAt(x, y + BALL_SIZE);
		if ((obj != null) && (obj == paddle)) {
			vx = -vx;
			return;
		}
		obj = getElementAt(x + BALL_SIZE, y);
		if ((obj != null) && (obj == paddle)) {
			vx = -vx;
			return;
		}
		obj = getElementAt(x + BALL_SIZE, y + BALL_SIZE);
		if ((obj != null) && (obj == paddle)) {
			vx = -vx;
			return;
		}
	}

	private void checkForCollisionWithWall() {
		double x = ball.getX();
		double y = ball.getY();
		if ((y < 0) || (y > getHeight())) {
			vy = -vy;
		}
		if ((x < 0) || (x > getWidth())) {
			ball.setLocation(getWidth() / 2, getHeight() / 2);
			waitForClick();
		}
	}

	private void moveBall() {
		ball.move(vx, vy);
	}

	private void setup() {
		setSize(WIDTH, HEIGHT);
		ball = new GOval(getWidth() / 2, getHeight() / 2, BALL_SIZE, BALL_SIZE);
		ball.setFilled(true);
		add(ball);

		leftPaddle = new GRect(PADDLE_SEPARATION, getHeight() / 2,
				PADDLE_WIDTH, PADDLE_HEIGHT);
		leftPaddle.setFilled(true);
		add(leftPaddle);

		rightPaddle = new GRect(getWidth() - PADDLE_SEPARATION - 10,
				getHeight() / 2, PADDLE_WIDTH, PADDLE_HEIGHT);
		rightPaddle.setFilled(true);
		add(rightPaddle);

		addKeyListeners();
	}
}
