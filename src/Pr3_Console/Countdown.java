import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: Countdown
 * 
 * A Console program that counts down from 10 to 0 and prints the values to the
 * console.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Countdown extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-24");

		for (int i = 5; i >= 0; i--) {
			println(i);
		}
	}
}
