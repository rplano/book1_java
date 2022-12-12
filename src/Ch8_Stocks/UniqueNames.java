import java.util.ArrayList;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: 4. UniqueNames
 * 
 * Shows the use of an ArrayList.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class UniqueNames extends ConsoleProgram {

	private ArrayList<String> names = new ArrayList<String>();

	public void run() {
		setSize(400, 400);
		setFont("Times New Roman-bold-20");

		// read names
		while (true) {
			String name = readLine("Enter new name: ");
			if (name.length() == 0)
				break;
			if (!names.contains(name)) {
				names.add(name);
			}
		}

		// print whole list
		println("\nUnique names:");
		for (int i = 0; i < names.size(); i++) {
			println(names.get(i));
		}
	}

}
