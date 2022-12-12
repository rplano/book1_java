import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: FlippedImage
 * 
 * A GraphicsProgram flips a given image upside down.
 * 
 * Image: Taj_Mahal_(Edited).jpeg <br/>
 * Image Author: Yann; edited by Jim Carter <br/>
 * Image License: Creative Commons Attribution-Share Alike 4.0 <br/>
 * Link: https://en.wikipedia.org/wiki/File:Taj_Mahal_(Edited).jpeg <br/>
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class FlippedImage extends GraphicsProgram {

	public void run() {
		setSize(800, 400 + 44);

		GImage image = new GImage("Taj_Mahal_(Edited).jpeg");
		add(image, 0, 0);

		GImage flippedImage = flipVertical(image);
		add(flippedImage, 400, 0);
	}

	private GImage flipVertical(GImage image) {
		int[][] array = image.getPixelArray();

		int height = array.length;
		int width = array[0].length;
		int[][] arrayFlipped = new int[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int pixel = array[i][j];
				// arrayFlipped[i][width - j - 1] = pixel;
				arrayFlipped[height - i - 1][j] = pixel;
			}
		}
		return new GImage(arrayFlipped);
	}

}
