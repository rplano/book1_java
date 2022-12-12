import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Graphics: 4. OhmLogo
 * 
 * Draw an image.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class OhmLogo extends GraphicsProgram {

	public void run() {
		setSize(300, 250);
		GImage om = new GImage("TH-Nuernberg-Logo.jpg");
		om.scale(1.7);
		add(om, 60, 10);
	}

}
