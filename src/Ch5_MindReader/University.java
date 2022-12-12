import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: 4b. University
 * 
 * Demonstrates the use of the class Student.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class University extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-20");

		Student hansel = new Student("Hänschen", 12345, 0.0);
		println(hansel.getName());

		Student gretel = new Student("Gretel", 54321, 11.0);
		println(gretel.getName());
		gretel.setName("Gretchen");
		gretel.incrementCredits(5);

		println(gretel.toString());
	}
}
