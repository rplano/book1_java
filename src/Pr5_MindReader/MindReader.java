import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: MindReader
 * 
 * The user needs to pick either heads or tails. Before the user makes his/her
 * pick the program will make a prediction as to whether the user is going to
 * pick head or tail. The programs prediction is hidden from the user until he
 * makes his actual pick. Once the user makes his pick the programs prediction
 * is revealed. If the program correctly predicted the users pick it gets a
 * point otherwise if the program misses the user gets a point. Who ever
 * (program or user) gets 25 points first is deemed the winner.
 * 
 * @see: http://nifty.stanford.edu/2007/raja-mindreader/
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class MindReader extends ConsoleProgram {
	private final int POINTS_TO_WIN = 25;

	private char computerGuess;
	private char humanGuess;
	private int computerScore = 0;
	private int humanScore = 0;
	private MindReaderPredictor predictor;

	public void run() {
		setup();
		gameLoop();
	}

	private void gameLoop() {
		while ((computerScore < POINTS_TO_WIN) && (humanScore < POINTS_TO_WIN)) {
			computerMakePrediction();
			humanMakePick();
			revealPrediction();
		}
		displayWinner();
	}

	private void displayWinner() {
		if (computerScore >= POINTS_TO_WIN) {
			println("I won!");
		} else {
			println("You won!");
		}
	}

	private void revealPrediction() {
		if (computerGuess == humanGuess) {
			println("Yes!. I too predicted " + computerGuess);
			computerScore++;
		} else {
			println("No. I predicted " + computerGuess);
			humanScore++;
		}
		println("Score: " + computerScore + " | " + humanScore + "");
	}

	private void humanMakePick() {
		while (true) {
			String guess = readLine("What is your guess [h/t] ? ");
			if (guess.toLowerCase().equals("h")) {
				humanGuess = 'h';
				break;
			} else if (guess.toLowerCase().equals("t")) {
				humanGuess = 't';
				break;
			} else {
				println("You must enter either h or t.  Please try again.");
			}
		}
		predictor.addNewGuess(humanGuess);
	}

	private void computerMakePrediction() {
		computerGuess = predictor.makePrediction();
	}

	private void setup() {
		setSize(400, 400);
		setFont("Times New Roman-bold-20");

		computerScore = 0;
		humanScore = 0;
		predictor = new MindReaderPredictor();
		println("Welcome to MindReader!");
	}
}
