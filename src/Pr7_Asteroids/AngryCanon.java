import java.awt.Color;
import java.awt.event.KeyEvent;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: AngryCanon
 * 
 * Inspired by the name of a popular game, this program consists of a canon
 * (rectangle), of which you can modify the angle, using the keys.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class AngryCanon extends GraphicsProgram {
	private final int APP_WIDTH = 300;
	private final int APP_HEIGHT = 200;
	private final int OFFSET = 100;

	private final int DELAY = 50;

	private final int TARGET_SIZE = 40;
	private final int BULLET_SIZE = 12;
	private final double BULLET_SPEED = 20.0;
	private final double GRAVITY = 1.0;

	private GPolygon canon;
	private GRect target;
	private GOval bullet;

	private double vx = 0.0;
	private double vy = 0.0;
	private double angle = 0.0;

	public void run() {
		setup();
		while (true) {
			moveBullet();
			checkForCollisions();
			pause(DELAY);
		}
		// displayGameOver();

	}

	private void checkForCollisions() {
		collisionWithWalls();
		collisionWithTarget();
	}

	private void collisionWithWalls() {
		if (bullet != null) {
			if (bullet.getX() > APP_WIDTH) {
				remove(bullet);
				bullet = null;
			} else if (bullet.getY() > APP_HEIGHT) {
				remove(bullet);
				bullet = null;
			}
		}
	}

	private void collisionWithTarget() {
		if (bullet != null) {
			GObject obj = getElementAt(bullet.getX(), bullet.getY());
			if (obj != null) {
				if (obj == target) {
					remove(obj);
					remove(bullet);
					bullet = null;
				}
			}
		}
	}

	private void moveBullet() {
		if (bullet != null) {
			bullet.move(vx, vy);
			vy += GRAVITY;
		}
	}

	private void fireBullet() {
		if (bullet == null) {
			vx = -Math.sin(Math.toRadians(angle)) * BULLET_SPEED;
			vy = -Math.cos(Math.toRadians(angle)) * BULLET_SPEED;

			bullet = new GOval(BULLET_SIZE, BULLET_SIZE);
			bullet.setColor(Color.GREEN);
			bullet.setFilled(true);
			add(bullet, 50 - BULLET_SIZE / 2, APP_HEIGHT - 30 - BULLET_SIZE);
		}
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch (code) {
		case 37:
			angle += 5;
			canon.rotate(5);
			break;
		case 39:
			angle -= 5;
			canon.rotate(-5);
			break;
		case 32:
			fireBullet();
			break;
		default:
			println(code);
			break;
		}
	}

	private void setup() {
		setSize(APP_WIDTH, APP_HEIGHT + OFFSET);

		canon = new GPolygon();
		canon.addVertex(-8, -40);
		canon.addVertex(-8, 10);
		canon.addVertex(-6, 12);
		canon.addVertex(-3, 15);
		canon.addVertex(3, 15);
		canon.addVertex(6, 12);
		canon.addVertex(8, 10);
		canon.addVertex(8, -40);
		canon.setColor(Color.BLACK);
		canon.setFilled(true);
		add(canon, 50, APP_HEIGHT - 35);
		GOval canon2 = new GOval(50, 50);
		canon2.setColor(Color.RED);
		canon2.setFilled(true);
		add(canon2, 25, APP_HEIGHT - 50);

		target = new GRect(TARGET_SIZE, TARGET_SIZE);
		target.setColor(Color.BLUE);
		target.setFilled(true);
		add(target, 230, APP_HEIGHT - TARGET_SIZE);

		addKeyListeners();
	}
}
