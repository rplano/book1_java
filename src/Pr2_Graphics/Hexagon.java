import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: Hexagon
 * 
 * Draw a hexagon using a polygon.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Hexagon extends GraphicsProgram {

	public void run() {
		setSize(300, 200);
		GPolygon hexa = new GPolygon();
		int size = 30;
		int pos = 85;
		hexa.addVertex(0, 0);
		hexa.addVertex(size, size * 2);
		hexa.addVertex(size * 3, size * 2);
		hexa.addVertex(size * 4, 0);
		hexa.addVertex(size * 3, -size * 2);
		hexa.addVertex(size, -size * 2);
		add(hexa, pos, pos + size * 2 - 68);
	}

}
