import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * MindReader: Encrypt
 * 
 * Encrypts and decrypts a string using Caesar's cipher.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Encrypt extends ConsoleProgram {

	public void run() {
		setSize(400, 200);
		setFont("Times New Roman-bold-24");

		String str = readLine("Enter String: ");
		String enc = encryptCaesar(str.toLowerCase(), 3);
		println(enc);
		String dec = decryptCaesar(enc, 3);
		println(dec);
	}

	private String decryptCaesar(String str, int key) {
		String dec = "";
		for (int i = 0; i < str.length(); i++) {
			dec += decryptChar(str.charAt(i), key);
		}
		return dec;
	}

	private char decryptChar(char c, int key) {
		int d = c - 'a';
		int e = d - key;
		int f = e % 26;
		char g = (char) (f + 'a');
		return g;
	}

	private String encryptCaesar(String str, int key) {
		String enc = "";
		for (int i = 0; i < str.length(); i++) {
			enc += encryptChar(str.charAt(i), key);
		}
		return enc;
	}

	private char encryptChar(char c, int key) {
		int d = c - 'a';
		int e = d + key;
		int f = e % 26;
		char g = (char) (f + 'a');
		return g;
	}
}
