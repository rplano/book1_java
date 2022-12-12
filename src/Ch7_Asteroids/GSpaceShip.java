import acm.graphics.GPolygon;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: 6b. GSpaceShip
 * 
 * A simulation of landing on the mars.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class GSpaceShip extends GPolygon {
	// constants
	private final int GRAVITY = 1;

	// instance variables
	public int vy = 0;
	public int vx = 0;

	public GSpaceShip(int SPACE_SHIP_SIZE) {
		super();

		addVertex(0, -SPACE_SHIP_SIZE);
		addVertex(-2 * SPACE_SHIP_SIZE / 3, SPACE_SHIP_SIZE);
		addVertex(0, SPACE_SHIP_SIZE / 2);
		addVertex(2 * SPACE_SHIP_SIZE / 3, SPACE_SHIP_SIZE);
	}
	
	public void move() {
		vy += GRAVITY;
		move(vx, vy);		
	}
}
