import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: 8. CounterWithFor
 * 
 * A simple ConsoleProgram that prints the numbers from 0 to 9 using a for loop.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class CounterWithFor extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-24");

		for (int i = 0; i < 10; i++) {
			print(i + ", ");
		}
	}

}
