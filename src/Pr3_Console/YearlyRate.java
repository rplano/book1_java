import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Console: YearlyRate
 * 
 * A Console program that calculates your yearly rate on a loan, given credit
 * amount, length of loan and interest rate.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class YearlyRate extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-24");

		double k = readDouble("Enter credit amount (5000): ");
		int n = readInt("Enter how many years (5): ");
		double z = readDouble("Enter interest rate (0.05): ");
		double q = 1.0 + z;
		double qn = Math.pow(q, n);
		double y = k * qn * (q - 1) / (qn - 1);
		println("Yearly rate is: " + y);
	}
}
