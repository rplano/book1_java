import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: Planets
 * 
 * A GraphicsProgram that simulates motion of planets.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Planets extends GraphicsProgram {
	private final int SIZE = 400;

	private final int SUN_MASS = 100;
	private final double SUN_SPEED = 0.15;
	private final int EARTH_MASS = 20;
	private final double EARTH_SPEED = -0.85;
	private final int MOON_MASS = 5;
	private final double MOON_SPEED = 0.2;

	private final int DELAY = 10;

	private GPlanet sun;
	private GPlanet earth;
	private GPlanet moon;

	public void run() {
		setSize(SIZE, SIZE);
		setup();
		while (true) {
			sun.move();
			earth.move();
			moon.move();
			calculateNewVelocities(sun, earth);
			calculateNewVelocities(sun, moon);
			calculateNewVelocities(earth, moon);
			pause(DELAY);
		}
	}

	private void calculateNewVelocities(GPlanet p1, GPlanet p2) {
		// mx*a = m1*m2/r^2
		// v=a*t
		double x1 = p1.getX() + p1.getWidth() / 2;
		double y1 = p1.getY() + p1.getHeight() / 2;
		double x2 = p2.getX() + p2.getWidth() / 2;
		double y2 = p2.getY() + p2.getHeight() / 2;
		double dx = x1 - x2;
		double dy = y1 - y2;
		double r2 = dx * dx + dy * dy;
		double r = Math.sqrt(r2);
		double a = 1.0 / r2;
		double dvx = a * dx / r;
		double dvy = a * dy / r;
		p2.vx += p1.getWidth() * dvx;
		p2.vy += p1.getWidth() * dvy;
		p1.vx -= p2.getWidth() * dvx;
		p1.vy -= p2.getWidth() * dvy;
	}

	private void setup() {
		// create sun
		sun = new GPlanet(SUN_MASS);
		sun.setFilled(true);
		sun.setColor(Color.YELLOW);
		sun.vy = SUN_SPEED;
		add(sun, (SIZE - SUN_MASS) / 2, (SIZE - SUN_MASS) / 2);

		// create earth
		earth = new GPlanet(EARTH_MASS);
		earth.setFilled(true);
		earth.setColor(Color.BLUE);
		earth.vy = EARTH_SPEED;
		add(earth, (SIZE - EARTH_MASS) / 2 + 150, (SIZE - EARTH_MASS) / 2);

		// create earth
		moon = new GPlanet(MOON_MASS);
		moon.setFilled(true);
		moon.setColor(Color.GREEN);
		moon.vy = MOON_SPEED;
		add(moon, (SIZE - MOON_MASS) / 2 + 130, (SIZE - MOON_MASS) / 2);

	}
}

class GPlanet extends GOval {
	public double vx;
	public double vy;

	public GPlanet(int size) {
		super(size, size);
	}

	public void move() {
		move(vx, vy);
	}
}
