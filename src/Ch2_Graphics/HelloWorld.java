import java.awt.Color;

import acm.graphics.*;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: 5. HelloWorld
 * 
 * Write a simple GraphicsProgram that uses a GLabel to output a ’Hello World’
 * message. Change the color, the font and the font size of the label. Also
 * change the position.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class HelloWorld extends GraphicsProgram {

	public void run() {
		setSize(300, 200);
		// your code goes here:
		GLabel hans = new GLabel("Hello World!");
		hans.setFont("SansSerif-36");
		add(hans, 40, 85);
		// fritz.setColor( Color.RED );

		// GLabel lisa = new GLabel( "Whats up?" );
		// add( lisa, 150, 50 );
		//
		// GRect peter = new GRect( 23,46, 100,100 );
		// peter.setColor( Color.RED );
		// peter.setFilled(true);
		// peter.setFillColor( Color.CYAN );
		// add( peter );

	}
}
