import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: NumberGuessConsole
 * 
 * The computer generates a random number and the user has to guess it. The
 * important part about this example is that two developers can work
 * simultaneously on the code using the NumberGuessLogic interface. It is
 * demonstration of coding by contract.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class NumberGuessConsole extends ConsoleProgram {

	public void run() {
		setSize(400, 400);
		setFont("Times New Roman-bold-20");

		NumberGuessLogic logic = new NumberGuessLogicImpl();

		while (true) {
			int guess = readInt("Enter guess: ");
			if (logic.makeGuess(guess) == 0)
				break;
			if (logic.makeGuess(guess) == 1) {
				println("Number is smaller.");
			} else {
				println("Number is higher.");
			}

		}
		println("You won!");
	}
}
