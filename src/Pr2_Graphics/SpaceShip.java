import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: SpaceShip
 * 
 * Draw a space ship using a polygon.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class SpaceShip extends GraphicsProgram {
	private final int SPACE_SHIP_SIZE = 40;

	public void run() {
		setSize(300, 200);
		GPolygon ship = new GPolygon();
		ship.addVertex(0, -SPACE_SHIP_SIZE);
		ship.addVertex(-2 * SPACE_SHIP_SIZE / 3, SPACE_SHIP_SIZE);
		ship.addVertex(0, SPACE_SHIP_SIZE / 2);
		ship.addVertex(2 * SPACE_SHIP_SIZE / 3, SPACE_SHIP_SIZE);
		add(ship, 150, 150 - 75);
	}
}
