import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: Palindrome
 * 
 * Checks if a given string is a palindrome.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Palindrome extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		String str = readLine("Enter String: ");
		if (isPalindrome(str)) {
			println("'" + str + "' is a palindrome.");
		} else {
			println("'" + str + "' is NOT a palindrome.");
		}
	}

	private boolean isPalindrome(String str) {
		if (str.equals(reverse(str))) {
			return true;
		} else {
			return false;
		}
	}

	private String reverse(String s) {
		String reverse = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reverse += s.charAt(i);
		}
		return reverse;
	}
}
