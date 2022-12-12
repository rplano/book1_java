import java.awt.Color;
import java.awt.event.KeyEvent;

import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: GeometryRun
 * 
 * A jump-and-run game where you try to escape incoming geometric objects.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class GeometryRun extends GraphicsProgram implements GeometryConstants {

	private RandomGenerator rgen = new RandomGenerator();

	private GeometryObstacle[] obstacles;
	private Geometry runner;

	public void run() {
		setup();
		waitForClick();
		while (true) {
			moveObstacles();
			moveDash();
			checkForCollision();
			pause(DELAY);
		}
	}

	private void moveDash() {
		if (runner.getY() < DASH_Y_POS) {
			runner.vy += GRAVITY;
			runner.move();
		} else {
			runner.vy = 0;
			runner.setLocation(DASH_X_POS, DASH_Y_POS);
		}
	}

	private void checkForCollision() {
		for (int i = 0; i < obstacles.length; i++) {
			if (obstacles[i].getX() < 0) {
				obstacles[i].setLocation(APP_WIDTH, obstacles[i].getY());
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == ' ') {
			runner.vy -= DASH_JUMP;
			runner.move();
		}
	}

	private void moveObstacles() {
		for (int i = 0; i < obstacles.length; i++) {
			obstacles[i].move();
		}
	}

	private void setup() {
		setSize(APP_WIDTH, APP_HEIGHT);
		addKeyListeners();

		runner = new Geometry();
		runner.setFilled(true);
		runner.setColor(Color.GREEN);
		add(runner, DASH_X_POS, DASH_Y_POS);

		obstacles = new GeometryObstacle[NR_OF_OBSTACLES];
		for (int i = 0; i < obstacles.length; i++) {
			int x = rgen.nextInt(APP_WIDTH);
			int y = APP_HEIGHT - 2 * OBSTACLES_SIZE;
			obstacles[i] = new GeometryObstacle();
			obstacles[i].vx = -OBSTACLES_SPEED;
			add(obstacles[i], x, y);
		}
	}
}
