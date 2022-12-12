import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: Quiz
 * 
 * A Swing program that creates a UI for multiple choice exams.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Quiz extends Program {

	public void init() {
		setSize(300, 200);

		String question = "Correct:  1 + 1 = 2 ?";
		String answer1 = "Yes";
		String answer2 = "No";
		String answer3 = "Maybe";

		JLabel lbl = new JLabel(question);
		add(lbl, NORTH);

		JPanel answersPnl = new JPanel();
		buildMultipleChoiceAnswers(answer1, answer2, answer3, answersPnl);
		add(answersPnl, CENTER);

		JButton btnPrevious = new JButton("< Previous");
		add(btnPrevious, SOUTH);
		JButton btnNext = new JButton("Next >");
		add(btnNext, SOUTH);
	}

	private void buildMultipleChoiceAnswers(String answer1, String answer2,
			String answer3, JPanel answersPnl) {
		answersPnl.setLayout(new GridLayout(3, 1));
		JRadioButton btn1 = new JRadioButton(answer1);
		answersPnl.add(btn1);
		JRadioButton btn2 = new JRadioButton(answer2);
		answersPnl.add(btn2);
		JRadioButton btn3 = new JRadioButton(answer3);
		answersPnl.add(btn3);
		ButtonGroup happyGrp = new ButtonGroup();
		happyGrp.add(btn1);
		happyGrp.add(btn2);
		happyGrp.add(btn3);
	}
}
