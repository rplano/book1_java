import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: RandomGeneratorTester
 * 
 * This class tests the self-written RandomGenerator.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class RandomGeneratorTester extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		RandomGenerator rgen = new RandomGenerator();

		for (int i = 0; i < 10; i++) {
			print(rgen.nextInt(10) + ",");
		}
		println();

		for (int i = 0; i < 10; i++) {
			print(rgen.nextInt(1, 6) + ",");
		}
		println();

		for (int i = 0; i < 10; i++) {
			print(rgen.nextBoolean() + ",");
		}
		println();

		for (int i = 0; i < 10; i++) {
			println(rgen.nextColor());
		}

	}
}