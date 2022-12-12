import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: EvenOdd
 * 
 * A Console program that prints the numbers 0 through 10, and prints if the
 * number is even or odd.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class EvenOdd extends ConsoleProgram {
	private final int MAX_NUM = 10;

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		println("i : i % 2 : even/odd");
		for (int i = 0; i < MAX_NUM; i++) {
			print(i + " : " + i % 2);
			if ((i % 2) == 0) {
				println(" : even");
			} else {
				println(" : odd");
			}
		}
	}
}