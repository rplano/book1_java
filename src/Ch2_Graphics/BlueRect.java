import java.awt.Color;
import acm.graphics.*;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: 1. BlueRect
 * 
 * Draw a yellow and a blue rectangle.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class BlueRect extends GraphicsProgram {

	public void run() {
		setSize(300, 200);

		GRect fritz = new GRect(50, 40);
		fritz.setColor(Color.BLUE);
		fritz.setFilled(true);
		add(fritz, 100, 100);

		GOval lisa = new GOval(20, 20);
		add(lisa, 200, 100);
	}
}
