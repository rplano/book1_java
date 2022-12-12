import java.awt.Color;

import acm.graphics.GArc;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: PieChart
 * 
 * Draw a pie chart using a arcs.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class PieChart extends GraphicsProgram {
	private int size = 150;
	private int pos = 75;

	public void run() {
		setSize(300, 200);
		GArc a1 = new GArc(size, size, 0, 45);
		a1.setFilled(true);
		a1.setFillColor(Color.RED);
		add(a1, pos, pos - 73);

		GArc a2 = new GArc(size, size, 45, 225);
		a2.setFilled(true);
		a2.setFillColor(Color.YELLOW);
		add(a2, pos, pos - 73);

		GArc a = new GArc(size, size, 270, 90);
		a.setFilled(true);
		a.setFillColor(Color.GREEN);
		add(a, pos, pos - 73);
	}

}
