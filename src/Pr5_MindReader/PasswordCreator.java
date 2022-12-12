import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: PasswordCreator
 * 
 * Creates a random password.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class PasswordCreator extends ConsoleProgram {
	
	private RandomGenerator rgen = new RandomGenerator();
	
	private String small = "abcdefghijklmnopqrstuvwxyz";
	private String big = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String numbers = "0123456789";
	private String symbols = "!#$%&'()*+,-./:;<=>?@[]^_{|}";
	
	public void run() {
		setSize(400, 200);
		setFont("monospaced-20");

		String password = generatePassword();
		println(password);
	}

	private String generatePassword() {
		String password = "";
		password += small.charAt(rgen.nextInt(small.length()));
		password += big.charAt(rgen.nextInt(big.length()));
		password += numbers.charAt(rgen.nextInt(numbers.length()));
		password += symbols.charAt(rgen.nextInt(symbols.length()));
		password += small.charAt(rgen.nextInt(small.length()));
		password += big.charAt(rgen.nextInt(big.length()));
		password += numbers.charAt(rgen.nextInt(numbers.length()));
		password += symbols.charAt(rgen.nextInt(symbols.length()));
		return password;
	}
}