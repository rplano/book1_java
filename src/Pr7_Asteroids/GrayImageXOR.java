import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: GrayImageXOR
 * 
 * A GraphicsProgram that takes two images and does an XOR operation twice.
 * 
 * Image: Taj_Mahal_(Edited).jpeg <br/>
 * Image Author: Yann; edited by Jim Carter <br/>
 * Image License: Creative Commons Attribution-Share Alike 4.0 <br/>
 * Link: https://en.wikipedia.org/wiki/File:Taj_Mahal_(Edited).jpeg <br/>
 * 
 * Image: Mona_Lisa.jpg <br/>
 * Link: https://en.wikipedia.org/wiki/File:Mona_Lisa,_by_Leonardo_da_Vinci,
 * _from_C2RMF_retouched.jpg <br/>
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class GrayImageXOR extends GraphicsProgram {
	public void run() {
		setSize(800, 800 + 44);

		GImage image1 = new GImage("Taj_Mahal_(Edited).jpeg");
		GImage grayImage1 = createGrayImage(image1);
		GImage image2 = new GImage("Mona_Lisa.jpg");
		GImage grayImage2 = createGrayImage(image2);

		add(grayImage1, 0, 0);
		add(grayImage2, 400, 0);

		GImage xorImage12 = doImage1XORImage2(grayImage1, grayImage2);
		add(xorImage12, 0, 400);

		GImage xorImage122 = doImage1XORImage2(xorImage12, grayImage1);
		add(xorImage122, 400, 400);
	}

	private GImage doImage1XORImage2(GImage grayImage1, GImage grayImage2) {

		int[][] array1 = grayImage1.getPixelArray();
		int[][] array2 = grayImage2.getPixelArray();

		int height = array1.length;
		int width = array1[0].length;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int pixel1 = array1[i][j];
				int r1 = GImage.getRed(pixel1);

				int pixel2 = array2[i][j];
				int r2 = GImage.getRed(pixel2);

				int xx = r1 ^ r2; // try |,&,+,...
				array1[i][j] = GImage.createRGBPixel(xx, xx, xx);
			}
		}
		return new GImage(array1);
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
