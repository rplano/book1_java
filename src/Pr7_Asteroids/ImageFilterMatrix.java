import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: ImageFilterMatrix
 * 
 * A GraphicsProgram that matrices for image manipulation. We learn how to use
 * filter to sharpen, blur or emboss images.
 * 
 * @see http://docs.gimp.org/en/plug-in-convmatrix.html
 * @see http://lodev.org/cgtutor/filtering.html
 * 
 *      Image: Taj_Mahal_(Edited).jpeg <br/>
 *      Image Author: Yann; edited by Jim Carter <br/>
 *      Image License: Creative Commons Attribution-Share Alike 4.0 <br/>
 *      Link: https://en.wikipedia.org/wiki/File:Taj_Mahal_(Edited).jpeg <br/>
 * 
 *      Image: Mona_Lisa.jpg <br/>
 *      Link:
 *      https://en.wikipedia.org/wiki/File:Mona_Lisa,_by_Leonardo_da_Vinci,
 *      _from_C2RMF_retouched.jpg <br/>
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class ImageFilterMatrix extends GraphicsProgram {

	private int[][] identityFilter = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
	private double identityFactor = 1;

	private int[][] sharpenFilter = { { 0, -1, 0 }, { -1, 5, -1 }, { 0, -1, 0 } };
	private int sharpenFactor = 1;

	private int[][] blurFilter = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
	private int blurFactor = 9;

	private int[][] edgeEnhanceFilter = { { 1, 0, 0 }, { 0, 1, 0 },
			{ 0, 0, -1 } };
	private int edgeEnhanceFactor = 1;

	private int[][] edgeDetectFilter = { { 1, 2, 1 }, { 2, -12, 2 },
			{ 1, 2, 1 } };
	private int edgeDetectFactor = 1;

	private int[][] embossFilter = { { -2, -1, 0 }, { -1, 1, 1 }, { 0, 1, 2 } };
	private int embossFactor = 1;

	private GImage image;
	private int[][] array;
	private int[][] currentFilter;
	private int currentFactor;

	public void run() {
		setSize(800, 400 + 44);

		image = new GImage("Taj_Mahal_(Edited).jpeg");
		// image = new GImage("Mona_Lisa.jpg");
		add(image, 0, 0);

		array = image.getPixelArray();
		currentFilter = embossFilter;
		currentFactor = embossFactor;
		GImage filterImage = applyFilter();
		add(filterImage, 400, 0);
	}

	private GImage applyFilter() {
		int height = (int) image.getHeight();
		int width = (int) image.getWidth();
		int[][] sharp = new int[height][width];

		for (int i = 0; i < height - 2; i++) {
			for (int j = 0; j < width - 2; j++) {
				sharp[i][j] = applyFilterToPixel(i, j);
			}
		}
		return new GImage(sharp);
	}

	// int a = (color >> 32) & 0xFF;
	// int r = (color >> 16) & 0xFF;
	// int g = (color >> 8) & 0xFF;
	// int b = color & 0xFF;
	private int applyFilterToPixel(int x, int y) {
		int r = 0;
		int g = 0;
		int b = 0;
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j <= 2; j++) {
				r += ((array[x + i][y + j] >> 16) & 0xFF) * currentFilter[j][i];
				g += ((array[x + i][y + j] >> 8) & 0xFF) * currentFilter[j][i];
				b += ((array[x + i][y + j]) & 0xFF) * currentFilter[j][i];
			}
		}
		return GImage.createRGBPixel(checkBounds(r / currentFactor), checkBounds(g
				/ currentFactor), checkBounds(b / currentFactor));
	}

	// make sure value is between 0 and 255
	private int checkBounds(int xx) {
		if (xx < 0) {
			xx = 0;
		} else if (xx > 255) {
			xx = 255;
		}
		return xx;
	}
}
