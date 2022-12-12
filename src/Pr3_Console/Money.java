import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: Money
 * 
 * A Console program that takes an amount in cents, and outputs it in euros and
 * cents. Test it with the following entries: 120, 90, 100, 102, 002.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Money extends ConsoleProgram {
	private final int MAX_NUM = 10;

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		int money = readInt("Enter amount in cents: ");
		int cents = money % 100;
		int euros = money / 100;
		println("The amount is " + euros + "," + cents + " Euro.");
	}
}