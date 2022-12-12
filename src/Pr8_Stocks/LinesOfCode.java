import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.TreeSet;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: LinesOfCode
 * 
 * A console program that counts the Lines of Code (LoC) of a given program and
 * lists topics covered in program.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class LinesOfCode extends ConsoleProgram {

	private String[] searchWords = { "ConsoleProgram", "GraphicsProgram",
			"FileReader", "FileWriter", "javax.swing", "acm.graphics",
			"ActionEvent", "KeyEvent", "MouseEvent", "RandomGenerator",
			"ArrayList", "HashMap", "StringTokenizer", "Color", "AudioClip" };

	private TreeSet<String> classification;

	public void run() {
		setSize(400, 350);
		setFont("monospaced-18");

		File f = new File("LinesOfCode.java");
		File parent = f.getAbsoluteFile().getParentFile();
		File grandParent = parent.getAbsoluteFile().getParentFile();
		File[] filesInGrandParentFolder = grandParent.listFiles();
		for (File parnt : filesInGrandParentFolder) {
			File[] files = parnt.listFiles();
			for (File file : files) {
				if (file.getName().endsWith(".java")) {
					readFile(file);
				}
			}
		}
	}

	private void readFile(File file) {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(file));

			classification = new TreeSet<String>();
			int lineCount = 0;
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				lineCount++;
				if (line.startsWith("import ")) {
					checkImport(line);
				}
				if (line.contains("[]")) {
					classification.add("Array");
				}
			}
			print(file.getParentFile().getName() + "; "
					+ removeJavaEnding(file.getName()) + "; " + lineCount
					+ "; ");
			print(classification);
			println();
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void checkImport(String line) {
		for (String word : searchWords) {
			if (line.contains(word)) {
				classification.add(word);
			}
		}
	}

	private String removeJavaEnding(String word) {
		int l = word.length();
		return word.substring(0, l - 5);
	}
}
