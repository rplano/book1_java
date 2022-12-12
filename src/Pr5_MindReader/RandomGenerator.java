import java.awt.Color;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: RandomGenerator
 * 
 * This class should behave similar to the ACM RandomGenerator.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class RandomGenerator {

	public int nextInt(int a, int b) {
		int difference = b - a + 1;
		int d = (int) (Math.random() * difference);
		return a + d;
	}

	public int nextInt(int b) {
		return nextInt(0, b);
	}

	public boolean nextBoolean() {
		if (Math.random() < 0.5) {
			return true;
		}
		return false;
	}

	public Color nextColor() {
		int r = (int) (Math.random() * 256);
		int g = (int) (Math.random() * 256);
		int b = (int) (Math.random() * 256);
		return new Color(r, g, b);
	}

}
