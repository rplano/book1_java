import java.awt.Color;

import acm.graphics.GArc;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: Smiley
 * 
 * Write a simple GraphicsProgram that uses GRect, GOval and GLine, maybe also
 * GArc. Use setFilled(), setColor() and setFillColor(). Draw a ’Smiley’ that
 * includes two eyes, a nose and a mouth.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Smiley extends GraphicsProgram {

	public void run() {
		setSize(300, 200);

		GOval face = new GOval(100, 100);
		face.setFilled(true);
		face.setFillColor(Color.YELLOW);
		add(face, 100, 30);

		GOval leftEye = new GOval(10, 10);
		leftEye.setColor(Color.GREEN);
		add(leftEye, 125, 55);
		GOval rightEye = new GOval(10, 10);
		rightEye.setColor(Color.RED);
		add(rightEye, 175, 55);

		GArc mouth = new GArc(50, 50, 225, 90);
		add(mouth, 130, 60);
	}
}
