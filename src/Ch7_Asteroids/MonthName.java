import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Asteroids: 1. MonthName
 * 
 * A simple ConsoleProgram that swaps two entries in an array of int.
 * 
 * @see Music and mathematics,
 *      en.wikipedia.org/wiki/Mathematics_of_musical_scales
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class MonthName extends ConsoleProgram {

	private String[] monthName = { "January", "February", "March", "April",
			"May", "June", "July", "August", "September", "October",
			"November", "December" };

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");
		
		int monthNr = readInt("Enter number of month (1=January): ");
		println(monthName[monthNr - 1]);
	}

}
