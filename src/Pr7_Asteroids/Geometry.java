import acm.graphics.GOval;

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
public class Geometry extends GOval implements GeometryConstants {

	public int vx = 0;
	public int vy = 0;

	public Geometry() {
		super(DASH_SIZE, DASH_SIZE);
	}

	public void move() {
		this.move(vx, vy);
	}
}
