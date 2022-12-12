/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: Counter
 * 
 * This class represents a counter.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Counter {
	private int count = 0;

	public Counter() {
		count = 0;
	}

	public void incrementCounter() {
		count++;
	}

	public int getValue() {
		return count;
	}
}
