import acm.graphics.GRect;

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
public class GeometryObstacle extends GRect implements GeometryConstants {

	public int vx = 0;
	public int vy = 0;

	public GeometryObstacle() {
		super(OBSTACLES_SIZE, OBSTACLES_SIZE);
	}

	public void move() {
		this.move(vx, vy);
	}
}
