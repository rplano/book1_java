import java.awt.Color;

import acm.graphics.*;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: 3. House
 * 
 * Write a simple GraphicsProgram that uses GRect, GOval and GLine. Use
 * setFilled(), setColor() and setFillColor(). Draw a ’Painting’ that includes a
 * house, a tree, and the sun.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class House extends GraphicsProgram {

	public void run() {
		setSize(300, 200);

		// sun
		GOval sun = new GOval(40, 40);
		sun.setColor(Color.YELLOW);
		sun.setFilled(true);
		add(sun, 220, 20);

		// tree
		GRect treeTrunk = new GRect(30, 60);
		treeTrunk.setColor(Color.BLACK);
		treeTrunk.setFilled(true);
		add(treeTrunk, 55, 100);
		GOval treeCrown = new GOval(80, 60);
		treeCrown.setColor(Color.GREEN);
		treeCrown.setFilled(true);
		add(treeCrown, 30, 50);

		// house
		GRect house = new GRect(70, 70);
		house.setColor(Color.PINK);
		house.setFilled(true);
		add(house, 130, 90);
		GLine leftRoof = new GLine(125, 95, 165, 65);
		add(leftRoof);
		GLine rightRoof = new GLine(165, 65, 205, 95);
		add(rightRoof);
	}
}
