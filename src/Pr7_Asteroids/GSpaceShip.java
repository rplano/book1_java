import acm.graphics.GPolygon;

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
public class GSpaceShip extends GPolygon implements AsteroidConstants {

	public double vx = 0.0;
	public double vy = 0.0;
	public double angle = 0.0;

	public GSpaceShip(double x, double y) {
		super(x, y);
		this.addVertex(0, -SPACE_SHIP_SIZE);
		this.addVertex(-2 * SPACE_SHIP_SIZE / 3, SPACE_SHIP_SIZE);
		this.addVertex(0, SPACE_SHIP_SIZE / 2);
		this.addVertex(2 * SPACE_SHIP_SIZE / 3, SPACE_SHIP_SIZE);
	}

	public void move() {
		this.move(vx, vy);
	}

	public void rotate(double theta) {
		super.rotate(theta);
		angle += theta;
	}

	public void startEngine() {
		vx -= Math.sin(Math.toRadians(angle)) * SPACE_SHIP_SPEED;
		vy -= Math.cos(Math.toRadians(angle)) * SPACE_SHIP_SPEED;
	}
}