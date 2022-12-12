import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;

import acm.program.Program;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: WordGuess
 * 
 * Like hangman. You are shown empty spaces, and you can guess letters.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class WordGuess extends Program {
	private final int SIZE = 300;
	private final int WIDTH = SIZE;
	private final int HEIGHT = 120;

	private RandomGenerator rgen = new RandomGenerator();
	private JLabel wordLbl;

	private String wordToGuess;
	private String wordShown;

	public void init() {
		setSize(WIDTH, HEIGHT);

		initWord();

		wordLbl = new JLabel(wordShown);
		wordLbl.setFont(new Font("monospaced", Font.PLAIN, 60));
		add(wordLbl, NORTH);

		wordLbl.addKeyListener(this);
		wordLbl.requestFocus();
	}

	private void initWord() {
		wordToGuess = pickRandomWord();
		wordShown = "";
		for (int i = 0; i < wordToGuess.length(); i++) {
			wordShown += "-";
		}
	}

	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (wordToGuess.indexOf(c) > -1) {
			String wordShownNew = "";
			for (int i = 0; i < wordToGuess.length(); i++) {
				if (wordToGuess.charAt(i) == c) {
					wordShownNew += c;
				} else {
					wordShownNew += wordShown.charAt(i);
				}
			}
			wordShown = wordShownNew;
			wordLbl.setText(wordShown);
		}
	}

	private String pickRandomWord() {
		String[] words = { "dog", "fish", "chicken", "cat", "mother" };
		int index = rgen.nextInt(0, words.length - 1);
		return words[index];
	}
}
