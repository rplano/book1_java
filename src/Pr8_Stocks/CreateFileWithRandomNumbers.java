import java.io.FileWriter;
import java.io.PrintWriter;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: CreateFileWithRandomNumbers
 * 
 * A program that creates random numbers and stores them in a file.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class CreateFileWithRandomNumbers extends ConsoleProgram {

	private RandomGenerator rgen = new RandomGenerator();

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		println("Create file with random numbers:");
		String fileName = readLine("Enter file name: ");
		int low = readInt("Enter lowest number: ");
		int high = readInt("Enter highest number: ");
		int count = readInt("How many numbers do you want: ");
		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(fileName));

			for (int i = 0; i < count; i++) {
				pw.println(rgen.nextInt(low, high));
			}
			pw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
