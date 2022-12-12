import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: Factorial
 * 
 * Calculate the factorial of a given number. Print all factorials from 1 to 20.
 * What is wrong?
 * 
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Factorial extends ConsoleProgram {

	public void run() {
		setSize(400, 500);
		setFont("monospaced-18");

		for (int i = 0; i < 20; i++) {
			println("Factorial " + i + " is: " + calculateFactorial(i));
		}
	}

	private int calculateFactorial(int n) {
		int factorial = 1;
		for (int i = 1; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}

}
