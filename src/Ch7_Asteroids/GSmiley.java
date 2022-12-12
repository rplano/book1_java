import java.awt.Color;

import acm.graphics.GArc;
import acm.graphics.GCompound;
import acm.graphics.GOval;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: 7b. GSmiley
 * 
 * Draw a smiley using GObjects such as GOval (face, eyes) and GArc (mouth).
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class GSmiley extends GCompound {
	
	public GSmiley(int SIZE) {
		super();

		GOval face = new GOval(SIZE, SIZE);
		face.setFilled(true);
		face.setFillColor(Color.YELLOW);
		add(face);

		GOval leftEye = new GOval(SIZE/10, SIZE/10);
		leftEye.setColor(Color.GREEN);
		add(leftEye, SIZE/4, SIZE/4);
		GOval rightEye = new GOval(SIZE/10, SIZE/10);
		rightEye.setColor(Color.RED);
		add(rightEye, 3*SIZE/4, SIZE/4);

		GArc mouth = new GArc(SIZE/2, SIZE/2, 225, 90);
		add(mouth, 0.3*SIZE, 0.3*SIZE);
	}
}
