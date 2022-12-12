import java.awt.Color;
import java.awt.event.KeyEvent;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: JumpAndRun
 * 
 * Inspired by "Geometry Dash". Shows how to use arrays. Only die if you collide
 * with GOval.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class JumpAndRun extends GraphicsProgram {
	private final int WIDTH = 400;
	private final int HEIGHT = 200;

	private final int DELAY = 30;
	private final double GRAVITY = 1;

	private final int BALL_DIAM = 30;
	private final int BALL_OFFSET = 2;
	private final double X_START = WIDTH / 2;
	private final double Y_START = HEIGHT -2* BALL_DIAM;// - BALL_OFFSET;

	private RandomGenerator rgen = new RandomGenerator();

	private boolean alive = true;
	private double ballVel = 0.0;
	private double backgroundVel = 2.0;

	private GOval ball;
	private GObject[] movingObject = new GObject[400 / BALL_DIAM + 1];
	private String world = "  RRRR  O   RO  OOO  R";

	public void run() {
		setup();
		waitForClick();
		while (alive) {
			moveBall();
			moveObjects();
			checkForCollision();
			pause(DELAY);
		}
		println("Game over!");
	}

	public void keyTyped(KeyEvent e) {
		if (ball.getY() >= HEIGHT - BALL_DIAM - BALL_OFFSET) {
			ballVel = -20.0;
		}
	}

	/** Update and move ball */
	private void moveBall() {
		// increase yVelocity due to gravity on each cycle
		ball.move(0, ballVel);
		ballVel = ballVel + GRAVITY;
	}

	private void moveObjects() {
		for (int i = 0; i < movingObject.length; i++) {
			if (movingObject[i] != null) {
				movingObject[i].move(-backgroundVel, 0);
				if (movingObject[i].getX() < -BALL_DIAM) {
					movingObject[i].setLocation(WIDTH, HEIGHT - BALL_DIAM
							- BALL_OFFSET);
					// backgroundVel += 0.3;
				}
			}
		}
	}

	private void checkForCollision() {
		checkForCollisionWithFloor();
		checkForCollisionWithObjects();
	}

	private void checkForCollisionWithObjects() {
		GObject obj = getElementAt(ball.getX() + BALL_DIAM / 2, ball.getY()
				+ BALL_DIAM + 1);
		if ((obj != null)) {
			if (obj instanceof GRect) {
				ballVel = 0.0;
				// ball.setLocation(X_START, HEIGHT - BALL_OFFSET);
			} else {
				alive = false;
			}
		}
	}

	private void checkForCollisionWithFloor() {
		if (ball.getY() >= HEIGHT - BALL_DIAM - BALL_OFFSET) {
			ballVel = 0.0;
			ball.setLocation(X_START, HEIGHT - BALL_DIAM - BALL_OFFSET);
		}
	}

	/** Create and place ball. */
	private void setup() {
		setSize(WIDTH, HEIGHT+44);

		ball = new GOval(BALL_DIAM, BALL_DIAM);
		ball.setFilled(true);
		ball.setFillColor(Color.PINK);
		add(ball, X_START, Y_START);

		createNewObjects();

		addKeyListeners();
	}

	private void createNewObjects() {
		for (int i = 0; i < movingObject.length; i++) {
			switch (world.charAt(i)) {
			case 'R':
				GRect rect = new GRect(WIDTH + i * BALL_DIAM, Y_START, BALL_DIAM, BALL_DIAM);
				rect.setColor(rgen.nextColor());
				rect.setFilled(true);
				rect.setFillColor(rgen.nextColor());
				movingObject[i] = rect;
				add(movingObject[i]);
				break;
			case 'O':
				GOval oval = new GOval(WIDTH + i * BALL_DIAM,Y_START, BALL_DIAM, BALL_DIAM);
				oval.setColor(rgen.nextColor());
				oval.setFilled(true);
				oval.setFillColor(rgen.nextColor());
				movingObject[i] = oval;
				add(movingObject[i]);
				break;
			default:
				movingObject[i] = null;
				break;
			}
		}
	}
}
