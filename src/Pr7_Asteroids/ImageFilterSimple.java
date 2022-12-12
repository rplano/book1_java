import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: ImageFilterSimple
 * 
 * A GraphicsProgram that does simple image manipulation. We learn how to use
 * filter to sharpen, blur or emboss images.
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
public class ImageFilterSimple extends GraphicsProgram {

	public void run() {
		setSize(800, 400 + 44);

		// GImage image = new GImage("Taj_Mahal_(Edited).jpeg");
		GImage image = new GImage("Mona_Lisa.jpg");
		// add(image, 0, 0);

		GImage grayImage = createGrayImage(image);
		add(grayImage, 0, 0);

		GImage sharpImage = createSharpImage(grayImage);
		add(sharpImage, 400, 0);
	}

	private GImage createSharpImage(GImage image) {
		int[][] array = image.getPixelArray();

		int height = array.length;
		int width = array[0].length;
		int[][] sharp = new int[height][width];

		for (int i = 1; i < height - 1; i++) {
			for (int j = 1; j < width - 1; j++) {

				int r00 = GImage.getRed(array[i - 1][j - 1]);
				int r01 = GImage.getRed(array[i][j - 1]);
				int r02 = GImage.getRed(array[i + 1][j - 1]);
				int r10 = GImage.getRed(array[i - 1][j]);
				int r11 = GImage.getRed(array[i][j]);
				int r12 = GImage.getRed(array[i + 1][j]);
				int r20 = GImage.getRed(array[i - 1][j + 1]);
				int r21 = GImage.getRed(array[i][j + 1]);
				int r22 = GImage.getRed(array[i + 1][j + 1]);

				// http://docs.gimp.org/en/plug-in-convmatrix.html
				// http://lodev.org/cgtutor/filtering.html
				// edge
				int xx = r11 - r01;
				// int xx = (+0*r00 +1*r01 +0*r02 +1*r10 -4*r11 +1*r12 +0*r20
				// +1*r21 +0*r22)/8;
				// sharpen
				// int xx = (+0*r00 -1*r01 +0*r02 -1*r10 +5*r11 -1*r12 +0*r20
				// -1*r21 +0*r22)/1;
				// blur
				// int xx = (r11 +r00 +r01 +r02 +r10 +r12 +r20 +r21 +r22)/9;
				// emboss
				// int xx = -2 * r00 - 1 * r01 - 0 * r02 - 1 * r10 + 1 * r11 + 1
				// * r12 + 0 * r20 + 1 * r21 + 2 * r22;

				// make sure color values are between 0 and 255
				xx *= 10;
				if (xx < 0) {
					xx = 0;
				} else if (xx > 255) {
					xx = 255;
				}
				sharp[i][j] = GImage.createRGBPixel(xx, xx, xx);
			}
		}
		return new GImage(sharp);

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

				int xx = r;
				array[i][j] = GImage.createRGBPixel(xx, xx, xx);
			}
		}
		return new GImage(array);
	}
}
