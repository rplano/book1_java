import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import acm.program.Program;
import acm.util.RandomGenerator;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: VocabularyTrainerSwing
 * 
 * A UI program that shows an English word and asks the user for the German
 * word.
 * 
 * ToDo: <br/>
 * - add more logic <br/>
 * - sounds would be cool <br/>
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class VocabularyTrainerSwing extends Program {
	private static final int SIZE = 300;
	private static final int WIDTH = SIZE;
	private static final int HEIGHT = 240;

	private JLabel englishLbl;
	private JTextField germanTf;

	private RandomGenerator rgen = new RandomGenerator();
	private HashMap<String, String> dictionary;

	public void init() {
		setSize(WIDTH, HEIGHT);

		initDictionary();

		englishLbl = new JLabel("english");
		englishLbl.setFont(new Font("SansSerif", Font.PLAIN, 60));
		add(englishLbl, NORTH);

		germanTf = new JTextField("german");
		germanTf.setFont(new Font("SansSerif", Font.PLAIN, 60));
		germanTf.setPreferredSize(new Dimension(SIZE - 10, 60));
		germanTf.addActionListener(this);
		add(germanTf, SOUTH);

		setRandomWord();
	}

	private void setRandomWord() {
		Set<String> keysSet = dictionary.keySet();
		ArrayList<String> keysAL = new ArrayList<String>(keysSet);
		String randomWord = keysAL.get(rgen.nextInt(dictionary.size()));
		englishLbl.setText(randomWord);
		germanTf.setText("");
		germanTf.requestFocus();
	}

	private void initDictionary() {
		dictionary = new HashMap<String, String>();
		dictionary.put("dog", "hund");
		dictionary.put("cat", "katze");
		dictionary.put("fish", "fisch");
	}

	public void actionPerformed(ActionEvent e) {
		String english = englishLbl.getText();
		String guess = germanTf.getText();
		if (guess.toLowerCase().equals(dictionary.get(english))) {
			JOptionPane.showMessageDialog(this, "Great job!",
					"Check", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Try again!",
					"Check", JOptionPane.INFORMATION_MESSAGE);
		}

		setRandomWord();
	}
}
