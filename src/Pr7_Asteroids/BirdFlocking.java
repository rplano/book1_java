import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: BirdFlocking
 * 
 * A GraphicsProgram that simulates a flock of birds.
 * 
 * @see http://www.vergenet.net/~conrad/boids/pseudocode.html
 * @see http://gpolo.github.io/birdflocking/
 * @see https://en.wikipedia.org/wiki/Flocking_(behavior)#Flocking_rules
 *      Flocking rules. Basic models of flocking behavior are controlled by
 *      three simple rules: Separation - avoid crowding neighbors (short range
 *      repulsion) Alignment - steer towards average heading of neighbors
 *      Cohesion - steer towards average position of neighbors (long range
 *      attraction)
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class BirdFlocking extends GraphicsProgram {
	private final int SIZE = 300;
	private final int OFFSET = 44;

	private final int DELAY = 40;

	private final int NR_OF_BIRDS = 50;
	private final int BIRD_SIZE = 5;
	private final double BIRD_SPEED = 1.0;
	private final int BIRD_INITIAL_SEPERATION = 50;

	public static final double COHESION = 100;
	public static final double ALIGNMENT = 500;
	public final double SEPARATION = 10;
	public final double SEPARATION_FACTOR = 8;
	public final double DAMPENING_FACTOR = 0.8;

	private RandomGenerator rgen = new RandomGenerator();

	private GBird[] birds;
	private int mouseX = SIZE / 2;
	private int mouseY = SIZE / 2;

	public void run() {
		setSize(SIZE, SIZE + OFFSET);
		setup();
		while (true) {
			applyCohesion();
			applyAlignment();
			applySeparation();
			moveBirds();
			checkForCollisions();
			getKinteticEnergy();
			pause(DELAY);
		}
	}

	private void moveBirds() {
		for (int i = 0; i < NR_OF_BIRDS; i++) {
			birds[i].move();
		}
	}

	private void checkForCollisions() {
		for (int i = 0; i < NR_OF_BIRDS; i++) {
			double x = birds[i].getX();
			if (x < 0 || x > getWidth()) {
				x += getWidth();
				x = x % getWidth();
			}
			double y = birds[i].getY();
			if (y < 0 || y > getHeight()) {
				y += getHeight();
				y = y % getHeight();
			}
			birds[i].setLocation(x, y);
		}
	}

	private void getKinteticEnergy() {
		double energy = 0;
		for (int i = 0; i < NR_OF_BIRDS; i++) {
			birds[i].vx *= DAMPENING_FACTOR;
			birds[i].vy *= DAMPENING_FACTOR;
			energy += birds[i].vx * birds[i].vx + birds[i].vy * birds[i].vy;
		}
		System.out.println(energy);
	}

	public void mouseClicked(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	private void applyAlignment() {
		double avgVx = 0;
		double avgVy = 0;
		for (int i = 0; i < NR_OF_BIRDS; i++) {
			avgVx += birds[i].vx;
			avgVy += birds[i].vy;
		}
		avgVx /= NR_OF_BIRDS;
		avgVy /= NR_OF_BIRDS;

		// alignment
		for (int i = 0; i < NR_OF_BIRDS; i++) {
			double dVx = (birds[i].vx - avgVx) / ALIGNMENT;
			double dVy = (birds[i].vy - avgVy) / ALIGNMENT;
			// System.out.println(dVx+","+dVy);
			birds[i].vx -= dVx;
			birds[i].vy -= dVy;
		}

	}

	private void applyCohesion() {
		int avgX = mouseX;
		int avgY = mouseY;
		for (int i = 0; i < NR_OF_BIRDS; i++) {
			avgX += birds[i].getX();
			avgY += birds[i].getY();
		}
		avgX /= (NR_OF_BIRDS + 1);
		avgY /= (NR_OF_BIRDS + 1);

		// cohesion
		for (int i = 0; i < NR_OF_BIRDS; i++) {
			double dx = (birds[i].getX() - avgX) / COHESION;
			double dy = (birds[i].getY() - avgY) / COHESION;
			birds[i].vx -= dx;
			birds[i].vy -= dy;
		}
	}

	private void applySeparation() {
		double vx = 0;
		double vy = 0;
		for (int i = 0; i < NR_OF_BIRDS; i++) {
			GBird cb = birds[i];
			for (int j = 0; j < NR_OF_BIRDS; j++) {
				if (cb != birds[j]) {
					double dx = birds[j].getX() - cb.getX();
					double dy = birds[j].getY() - cb.getY();
					// System.out.println(getDistance(dx,dy));
					if (getDistance(dx, dy) < SEPARATION) {
						vx -= dx / SEPARATION_FACTOR;
						vy -= dy / SEPARATION_FACTOR;
					}
				}
			}
			// apply separation
			// System.out.println(vx+","+vy);
			cb.vx += vx;
			cb.vy += vy;
		}
	}

	private double getDistance(double dx, double dy) {
		double r2 = dx * dx + dy * dy;
		return Math.sqrt(r2);
		// return r2;
	}

	private void setup() {
		birds = new GBird[NR_OF_BIRDS];
		for (int i = 0; i < NR_OF_BIRDS; i++) {
			birds[i] = new GBird(BIRD_SIZE);
			birds[i].vx = rgen.nextDouble(-BIRD_SPEED, +BIRD_SPEED);
			birds[i].vy = rgen.nextDouble(-BIRD_SPEED, +BIRD_SPEED);
			int x = SIZE
					/ 2
					+ rgen.nextInt(-BIRD_INITIAL_SEPERATION,
							BIRD_INITIAL_SEPERATION);
			int y = SIZE
					/ 2
					+ rgen.nextInt(-BIRD_INITIAL_SEPERATION,
							BIRD_INITIAL_SEPERATION);
			add(birds[i], x, y);
		}
		addMouseListeners();
	}
}

class GBird extends GOval {
	public double vx;
	public double vy;

	public GBird(int size) {
		super(size, size);
	}

	public void move() {
		move(vx, vy);
	}

	public void move(int avgX, int avgY, double avgVx, double avgVy) {
		// cohesion
		double dx = (getX() - avgX) / BirdFlocking.COHESION;
		double dy = (getY() - avgY) / BirdFlocking.COHESION;
		vx -= dx;
		vy -= dy;

		// alignment
		double dVx = (vx - avgVx) / BirdFlocking.ALIGNMENT;
		double dVy = (vy - avgVy) / BirdFlocking.ALIGNMENT;
		// System.out.println(dVx+","+dVy);
		vx -= dVx;
		vy -= dVy;

		move(vx, vy);
	}
}
