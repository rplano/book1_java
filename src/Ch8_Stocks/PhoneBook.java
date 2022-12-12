import java.util.HashMap;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: 5. PhoneBook
 * 
 * Shows the use of a HashMap.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class PhoneBook extends ConsoleProgram {

	private HashMap<String, Integer> phoneBook = new HashMap<String, Integer>();

	public void run() {
		setSize(400, 600);
		setFont("Times New Roman-bold-20");

		// add names and numbers
		println("Fill phone book with data");
		while (true) {
			String name = readLine("Enter name: ");
			if (name.length() == 0)
				break;
			int number = readInt("Enter number: ");
			phoneBook.put(name, number);
		}

		// search phone book
		println("\nSearch phone book");
		while (true) {
			String name = readLine("Enter name to search: ");
			if (name.length() == 0)
				break;
			if (phoneBook.containsKey(name)) {
				println(phoneBook.get(name));
			} else {
				println("no entry for this name");
			}
		}

		// print whole phone book
		println("\nAll phone book entries");
		for (String name : phoneBook.keySet()) {
			int number = phoneBook.get(name);
			println(name + ": " + number);
		}
	}
}
