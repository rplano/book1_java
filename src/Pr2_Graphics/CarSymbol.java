import java.awt.Color;

import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: CarSymbol
 * 
 * For your favorite car, write a graphics program that draws the symbol of that
 * car. If that one would be to complicated, pick the symbol for your
 * next-to-favorite car. You will get extra credit, if it happens to be a German
 * car manufacturer.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class CarSymbol extends GraphicsProgram {
	private final int DIAMETER = 130;
	private final int THICKNESS = 10;

	public void run() {
		setSize(300, 200);

		int x = 20;
		int y = -30;

		// draw outer envelope
		GOval outerEnvelope = new GOval(DIAMETER, DIAMETER);
		outerEnvelope.setFilled(true);
		outerEnvelope.setFillColor(Color.BLACK);
		add(outerEnvelope, x + DIAMETER / 2, y + DIAMETER / 2 - 25);

		// draw inner envelope
		GOval innerEnvelope = new GOval(DIAMETER - THICKNESS, DIAMETER
				- THICKNESS);
		innerEnvelope.setFilled(true);
		innerEnvelope.setFillColor(Color.WHITE);
		add(innerEnvelope, x + (DIAMETER + THICKNESS) / 2, y
				+ (DIAMETER + THICKNESS) / 2 - 25);

		// draw trianlges
		GPolygon trianlge1 = new GPolygon();
		trianlge1.addVertex(-THICKNESS / 2, 0);
		trianlge1.addVertex(0, -(DIAMETER - THICKNESS) / 2);
		trianlge1.addVertex(THICKNESS / 2, 0);
		trianlge1.setFilled(true);
		trianlge1.setFillColor(Color.BLACK);
		add(trianlge1, x + DIAMETER, y + DIAMETER - 25);

		GPolygon trianlge2 = new GPolygon();
		trianlge2.addVertex(-THICKNESS / 2, 0);
		trianlge2.addVertex(0, -(DIAMETER - THICKNESS) / 2);
		trianlge2.addVertex(THICKNESS / 2, 0);
		trianlge2.setFilled(true);
		trianlge2.setFillColor(Color.BLACK);
		trianlge2.rotate(120);
		add(trianlge2, x + DIAMETER, y + DIAMETER - 25);

		GPolygon trianlge3 = new GPolygon();
		trianlge3.addVertex(-THICKNESS / 2, 0);
		trianlge3.addVertex(0, -(DIAMETER - THICKNESS) / 2);
		trianlge3.addVertex(THICKNESS / 2, 0);
		trianlge3.setFilled(true);
		trianlge3.setFillColor(Color.BLACK);
		trianlge3.rotate(240);
		add(trianlge3, x + DIAMETER, y + DIAMETER - 25);

	}
}
