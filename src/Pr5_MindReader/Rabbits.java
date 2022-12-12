import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: Rabbits
 * 
 * "Fibonacci considers the growth of an idealized rabbit population, assuming
 * that: a newly born pair of rabbits, one male, one female, are put in a field;
 * rabbits are able to mate at the age of one month so that at the end of its
 * second month a female can produce another pair of rabbits; rabbits never die
 * and a mating pair always produces one new pair (one male, one female) every
 * month from the second month on." Source:
 * https://en.wikipedia.org/wiki/Fibonacci_number
 * 
 * The number count pairs of rabbits: 1,1,2,3,5,8,13,21,34,55,89,...
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Rabbits extends ConsoleProgram {

	private int maleRabbits = 0;
	private int femaleRabbits = 0;
	private int boyRabbits = 1;
	private int girlRabbits = 1;

	public void run() {
		setSize(400, 200);
		setFont("monospaced-18");

		for (int months = 0; months < 12; months++) {
			print(getTotalNrOfRabbits() + ",");
			reproduce();
		}
	}

	private void reproduce() {
		maleRabbits += boyRabbits;
		boyRabbits = femaleRabbits;
		int tmp = girlRabbits;
		girlRabbits = femaleRabbits;
		femaleRabbits += tmp;
	}

	private int getTotalNrOfRabbits() {
		return (maleRabbits + femaleRabbits + boyRabbits + girlRabbits) / 2;
	}

}
