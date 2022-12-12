import java.awt.Color;
import java.awt.event.KeyEvent;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: Asteroids
 * 
 * Asteroids is an arcade space shooter game. The player controls a spaceship in
 * an asteroid field. The object of the game is to shoot and destroy asteroids
 * while not colliding with them.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Asteroids extends GraphicsProgram implements AsteroidConstants {

	private RandomGenerator rgen = new RandomGenerator();

	private GAsteroid[] asteroids = new GAsteroid[NR_OF_ASTEROIDS];

	private GSpaceShip spaceShip;

	private GBullet bullet;

	public void run() {
		setup();
		waitForClick();
		while (spaceShip != null) {
			moveSpaceShip();
			moveAsteroids();
			moveBullet();
			checkForCollisions();
			pause(50);
		}
		GLabel gameOverLabel = new GLabel("Game Over");
		gameOverLabel.setFont("SansSerif-36");
		gameOverLabel.setLocation((getWidth() - gameOverLabel.getWidth()) / 2,
				getHeight() / 2);
		add(gameOverLabel);
	}

	private void moveBullet() {
		if (bullet != null) {
			bullet.move();
		}
	}

	private void moveAsteroids() {
		for (int i = 0; i < NR_OF_ASTEROIDS; i++) {
			asteroids[i].move();
		}
	}

	private void moveSpaceShip() {
		spaceShip.move();
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case 38:
			spaceShip.startEngine();
			break;
		case ' ':
			fireBullet();
			break;
		case 37:
			// handle left
			spaceShip.rotate(10);
			break;
		case 39:
			// handle right
			spaceShip.rotate(-10);
			break;
		}
	}

	private void fireBullet() {
		if (bullet == null) {
			bullet = new GBullet(spaceShip.getX(), spaceShip.getY());
			bullet.vx = -Math.sin(Math.toRadians(spaceShip.angle))
					* BULLET_SPEED;
			bullet.vy = -Math.cos(Math.toRadians(spaceShip.angle))
					* BULLET_SPEED;
			add(bullet);
		}
	}

	private void checkForCollisions() {
		checkForCollisionAsteroidsWithWall();
		checkForCollisionSpaceShipWithWall();
		checkForCollisionBulletWithWall();
		checkForCollisionBulletWithAsteroid();
		checkForCollisionAsteroidWithSpaceShip();
	}

	private void checkForCollisionBulletWithAsteroid() {
		if (bullet != null) {
			double x = bullet.getX();
			double y = bullet.getY();
			GObject obj = getElementAt(x, y);
			if ((obj != null) && (obj != bullet) && (obj != spaceShip)) {
				remove(obj);
				remove(bullet);
				bullet = null;
			}
		}
	}

	private void checkForCollisionAsteroidWithSpaceShip() {
		double x = spaceShip.getX();
		double y = spaceShip.getY();
		GObject obj = getElementAt(x, y);
		if ((obj != null) && (obj != spaceShip)) {
			remove(obj);
			remove(spaceShip);
			spaceShip = null;
		}

	}

	private void checkForCollisionBulletWithWall() {
		if (bullet != null) {
			double x = bullet.getX();
			double y = bullet.getY();
			if ((x < -GBullet.BULLET_SIZE) || (x > getWidth())
					|| (y < -GBullet.BULLET_SIZE) || (y > getHeight())) {
				remove(bullet);
				bullet = null;
			}
		}
	}

	private void checkForCollisionSpaceShipWithWall() {
		double x = spaceShip.getX();
		double y = spaceShip.getY();
		if (x < -GSpaceShip.SPACE_SHIP_SIZE) {
			spaceShip.setLocation(getWidth(), y);
		} else if (x > getWidth()) {
			spaceShip.setLocation(-GSpaceShip.SPACE_SHIP_SIZE, y);
		}
		if (y < -GSpaceShip.SPACE_SHIP_SIZE) {
			spaceShip.setLocation(x, getHeight());
		} else if (y > getHeight()) {
			spaceShip.setLocation(x, -GSpaceShip.SPACE_SHIP_SIZE);
		}
	}

	private void checkForCollisionAsteroidsWithWall() {
		for (int i = 0; i < NR_OF_ASTEROIDS; i++) {
			double x = asteroids[i].getX();
			double y = asteroids[i].getY();
			if (x < -ASTEROID_SIZE) {
				asteroids[i].setLocation(getWidth(), y);
			} else if (x > getWidth()) {
				asteroids[i].setLocation(-ASTEROID_SIZE, y);
			}
			if (y < -ASTEROID_SIZE) {
				asteroids[i].setLocation(x, getHeight());
			} else if (y > getHeight()) {
				asteroids[i].setLocation(x, -ASTEROID_SIZE);
			}
		}
	}

	private void setup() {
		setSize(APP_WIDTH, APP_HEIGHT);
		createSpaceShip();
		createAsteroids();
		addKeyListeners();
	}

	private void createSpaceShip() {
		spaceShip = new GSpaceShip(getWidth() / 2, getHeight() / 2);
		add(spaceShip);
	}

	private void createAsteroids() {
		for (int i = 0; i < NR_OF_ASTEROIDS; i++) {
			asteroids[i] = new GAsteroid(rgen.nextInt(getWidth()),
					rgen.nextInt(getHeight()));
			asteroids[i].vx = rgen.nextInt(-ASTEROID_MAX_SPEED,
					ASTEROID_MAX_SPEED);
			asteroids[i].vy = rgen.nextInt(-ASTEROID_MAX_SPEED,
					ASTEROID_MAX_SPEED);
			asteroids[i].setColor(Color.BLUE);
			// asteroid.setFilled(true);
			add(asteroids[i]);
		}
	}

	public static void main(String[] args) {
		new Asteroids().start(args);
	}
}