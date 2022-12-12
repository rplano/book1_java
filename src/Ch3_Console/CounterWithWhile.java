import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: 7. CounterWithWhile
 * 
 * A simple ConsoleProgram that prints the numbers from 0 to 9 using a while
 * loop.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class CounterWithWhile extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-24");

		int i = 0;
		while (i < 10) {
			print(i + ", ");
			i = i + 1;
		}
	}

}
