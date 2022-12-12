import acm.graphics.GOval;

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
public class GBullet extends GOval implements AsteroidConstants {

	public double vx = 0.0;
	public double vy = 0.0;

	public GBullet(double x, double y) {
		super(x, y, BULLET_SIZE, BULLET_SIZE);
		this.setFilled(true);
	}

	public void move() {
		this.move(vx, vy);
	}
}