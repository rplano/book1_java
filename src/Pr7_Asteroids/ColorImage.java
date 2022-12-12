import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: FlippedImage
 * 
 * A GraphicsProgram that does color reduction using modulo.
 * 
 * Image: Mona_Lisa.jpg <br/>
 * Link: https://en.wikipedia.org/wiki/File:Mona_Lisa,_by_Leonardo_da_Vinci,
 * _from_C2RMF_retouched.jpg <br/>
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class ColorImage extends GraphicsProgram {
	private final int NR_OF_COLORS = 2; // actually 3*4
	private final int FACTOR = 256 / NR_OF_COLORS;

	public void run() {
		setSize(800, 400 + 44);

		GImage image = new GImage("Mona_Lisa.jpg");
		add(image, 0, 0);

		GImage colorImage = createReducedColorImage(image);
		add(colorImage, 400, 0);
	}

	private GImage createReducedColorImage(GImage image) {
		int[][] array = image.getPixelArray();

		int height = array.length;
		int width = array[0].length;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int pixel = array[i][j];

				int r = GImage.getRed(pixel);
				int g = GImage.getGreen(pixel);
				int b = GImage.getBlue(pixel);

				r = (r / FACTOR) * FACTOR;
				g = (g / FACTOR) * FACTOR;
				b = (b / FACTOR) * FACTOR;

				array[i][j] = GImage.createRGBPixel(r, g, b);
			}
		}
		return new GImage(array);
	}
}
