import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: 6. DayOfTheWeek
 * 
 * A simple ConsoleProgram that prints the day of the week.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class DayOfTheWeek extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-24");

		int day = readInt("Enter day of week as int (0-6): ");
		if (day == 0) {
			println("Sunday");
		} else if (day <= 5) {
			println("Weekday");
		} else {
			println("Saturday");
		}
	}

}
