import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: Squares
 * 
 * A Console program that prints the squares of the numbers 1 through 10.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Squares extends ConsoleProgram {
	private final int MAX_NUM = 10;

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		for (int i = 1; i < MAX_NUM; i++) {
			println(i * i);
		}
	}
}