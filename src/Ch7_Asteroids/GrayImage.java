import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: 4. GrayImage
 * 
 * A GraphicsProgram converting a color image to gray image.
 * 
 * Image: Taj_Mahal_(Edited).jpeg <br/>
 * Image Author: Yann; edited by Jim Carter <br/>
 * Image License: Creative Commons Attribution-Share Alike 4.0 <br/>
 * Link: https://en.wikipedia.org/wiki/File:Taj_Mahal_(Edited).jpeg <br/>
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class GrayImage extends GraphicsProgram {

	public void run() {
		setSize(800, 400 + 44);

		GImage image = new GImage("Taj_Mahal_(Edited).jpeg");
		image.scale(0.5);
		add(image, 0, 0);

		GImage grayImage = createGrayImage(image);
		grayImage.scale(0.5);
		add(grayImage, 400, 0);
	}

	private GImage createGrayImage(GImage image) {
		int[][] array = image.getPixelArray();

		int height = array.length;
		int width = array[0].length;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int pixel = array[i][j];

				int r = GImage.getRed(pixel);
				int g = GImage.getGreen(pixel);
				int b = GImage.getBlue(pixel);

				// Gimp uses: luminosity = 0.21 R + 0.72 G + 0.07 B.
				int lum = (int) (0.21 * r + 0.72 * g + 0.07 * b);

				array[i][j] = GImage.createRGBPixel(lum, lum, lum);
			}
		}
		return new GImage(array);
	}
}
