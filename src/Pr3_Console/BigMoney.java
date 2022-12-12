import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: BigMoney
 * 
 * A Console program that pretty prints numbers up to 100 million. Test it with
 * the following entries 100123345, 100123305, 05.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class BigMoney extends ConsoleProgram {
	private final int MAX_NUM = 10;

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		int money = readInt("Enter amount in cents: ");
		println("The amount is " + formatNumericString(money) + " Euro.");
	}

	private String formatNumericString(int money) {
		int cents = money % 100;
		int euros = money / 100;
		int millions = euros / 1000000;
		int thousands = (euros % 1000000) / 1000;
		int ones = (euros % 1000);

		String sMoney = "" + millions + "." + padWithZero("" + thousands, 3)
				+ "." + padWithZero("" + ones, 3) + ","
				+ padWithZero("" + cents, 2);
		return sMoney;
	}

	private String padWithZero(String s, int length) {
		while (s.length() < length) {
			s = '0' + s;
		}
		return s;
	}
}