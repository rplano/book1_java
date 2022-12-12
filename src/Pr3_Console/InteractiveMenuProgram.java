import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: InteractiveMenuProgram
 * 
 * A Console program that demonstrates how to use an interactive menu in a
 * console program.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class InteractiveMenuProgram extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-20");
		println("0: Exit / 1: Print message / 2: Do nothing");
		while (true) {
			int choice = readInt("Your choice: ");
			if (choice == 0)
				break;
			switch (choice) {
			case 1:
				println("message");
				break;
			case 2:
				// do nothing
				break;
			}
		}
	}
}
