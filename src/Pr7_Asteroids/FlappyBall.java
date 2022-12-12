import java.awt.Color;
import java.awt.event.KeyEvent;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: FlappyBall
 * 
 * Inspired by its big cousin. ToDo: dont touch floor!
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class FlappyBall extends GraphicsProgram {
	private final int WIDTH = 400;
	private final int HEIGHT = 400;

	private final int DELAY = 40;
	private final double GRAVITY = 1;

	private final int WALL_WIDTH = 30;

	private final int BALL_DIAM = 30;
	private final int BALL_OFFSET = 2;
	private final double X_START = WIDTH / 2;
	private final double Y_START = 100;

	private RandomGenerator rgen = RandomGenerator.getInstance();

	private boolean alive = true;
	private int wallCounter = 0;
	private double ballVel = 0.0;
	private double wallVel = 1.5;
	private GOval ball;
	private GRect upperWall;
	private GRect lowerWall;

	public void run() {
		setup();
		waitForClick();
		while (alive) {
			moveBall();
			moveWall();
			checkForCollision();
			pause(DELAY);
		}
		println("Game over!  You survived " + wallCounter + " walls.");
	}

	/** Update and move ball */
	private void moveBall() {
		// increase yVelocity due to gravity on each cycle
		ball.move(0, ballVel);
		ballVel = ballVel + GRAVITY;
	}

	private void moveWall() {
		upperWall.move(-wallVel, 0);
		lowerWall.move(-wallVel, 0);
		if (upperWall.getX() < -BALL_DIAM) {
			remove(upperWall);
			remove(lowerWall);
			createNewWall();
			wallCounter++;
			wallVel += 0.3;
		}
	}

	public void keyTyped(KeyEvent e) {
		ballVel = -5.0;
	}

	private void checkForCollision() {
		checkForCollisionWithFloor();
		checkForCollisionWithWall();
	}

	private void checkForCollisionWithWall() {
		GObject obj = getElementAt(ball.getX() + BALL_DIAM, ball.getY());
		if ((obj == lowerWall) || (obj == upperWall)) {
			alive = false;
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
		setSize(WIDTH, HEIGHT);

		ball = new GOval(BALL_DIAM, BALL_DIAM);
		ball.setFilled(true);
		ball.setFillColor(Color.PINK);
		add(ball, X_START, Y_START);

		createNewWall();

		addKeyListeners();
	}

	private void createNewWall() {
		int middle = rgen.nextInt(2 * BALL_DIAM, HEIGHT - 2 * BALL_DIAM);
		upperWall = new GRect(WIDTH, 0, WALL_WIDTH, middle - BALL_DIAM);
		upperWall.setFilled(true);
		upperWall.setFillColor(rgen.nextColor());
		add(upperWall);
		lowerWall = new GRect(WIDTH, middle + BALL_DIAM, WALL_WIDTH, HEIGHT);
		lowerWall.setFilled(true);
		lowerWall.setFillColor(rgen.nextColor());
		add(lowerWall);
	}
}
