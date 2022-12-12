import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: SimpleCraps
 * 
 * Craps is a dice game in which the players make wagers on the outcome of the
 * roll, or a series of rolls, of a pair of dice. In SimpleCraps we have the
 * following bets: <br/>
 * - (exact match (number)) <br/>
 * - odd <br/>
 * - even <br/>
 * - high (4,5,6) <br/>
 * - low (1,2,3) <br/>
 * 
 * @see https://en.wikipedia.org/wiki/Craps
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class SimpleCraps extends ConsoleProgram {
	// constants
	private final int STARTING_MONEY = 100;
	private final int WAGER_AMOUNT = 10;

	// instance variables
	private RandomGenerator rgen = new RandomGenerator();

	public void run() {
		setSize(400, 400);
		setFont("Times New Roman-bold-20");

		int money = STARTING_MONEY;
		while (money > 0) {
			println("You have €" + money + ".");

			String bet = readLine("Enter your bet: ");

			int outcome = roleTheDice();

			if (isResultWinning(outcome, bet)) {
				println("The number is " + bet + ", you win.");
				money += WAGER_AMOUNT;
				if (bet.equals("match")) {
					money += WAGER_AMOUNT;
				}
			} else {
				println("The number is not " + bet + ", you lose.");
				money -= WAGER_AMOUNT;
				if (bet.equals("match")) {
					money -= WAGER_AMOUNT;
				}
			}
		}
		println("You lost.");
	}

	private int roleTheDice() {
		int rnd = rgen.nextInt(1, 6);
		println("The dice shows " + rnd + ".");
		return rnd;
	}

	private boolean isResultWinning(int result, String bet) {
		if (bet.equals("odd")) {
			return (result % 2) == 1;
		} else if (bet.equals("even")) {
			return (result % 2) == 0;
		} else if (bet.equals("low")) {
			return (1 <= result) && (result <= 3);
		} else if (bet.equals("high")) {
			return (4 <= result) && (result <= 6);
		}
		return false;
	}
}
