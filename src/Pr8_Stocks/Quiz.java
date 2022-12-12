import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: Quiz
 * 
 * A Swing program that creates a UI for multiple choice exams, loads questions
 * from a file and administers quiz.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Quiz extends Program {

	private JLabel lbl;
	private JPanel answersPnl;
	private JButton btnPrevious;
	private JButton btnNext;

	private ArrayList<Question> questions;
	private int currentQuestion = 0;

	public void init() {
		setSize(300, 200);

		loadQuestions();
		buildUI();
		setQuestion(currentQuestion);

		addActionListeners();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			currentQuestion++;
			currentQuestion = currentQuestion % questions.size();
			setQuestion(currentQuestion);
		} else {
			currentQuestion--;
			// needed because Java's modulo is actually remainder
			currentQuestion += questions.size();
			currentQuestion = currentQuestion % questions.size();
			setQuestion(currentQuestion);
		}
	}

	private void setQuestion(int index) {
		Question q = questions.get(index);
		lbl.setText(q.question);
		buildMultipleChoiceAnswers(q.answers);
	}

	private void buildUI() {
		lbl = new JLabel("hi");
		add(lbl, NORTH);

		answersPnl = new JPanel();
		add(answersPnl, CENTER);

		btnPrevious = new JButton("< Previous");
		add(btnPrevious, SOUTH);
		btnNext = new JButton("Next >");
		add(btnNext, SOUTH);
	}

	private void buildMultipleChoiceAnswers(String[] answers) {
		answersPnl.removeAll();
		answersPnl.setLayout(new GridLayout(answers.length, 1));
		ButtonGroup happyGrp = new ButtonGroup();
		for (int i = 1; i < answers.length; i++) {
			JRadioButton btn1 = new JRadioButton(answers[i]);
			answersPnl.add(btn1);
			happyGrp.add(btn1);
		}
	}

	private void loadQuestions() {
		questions = new ArrayList<Question>();
		BufferedReader rd;
		try {
			rd = new BufferedReader(new FileReader("Quiz.txt"));
			while (true) {
				String line = rd.readLine();
				if (line == null)
					break;
				String[] words = line.split(";");
				Question q = new Question(words);
				questions.add(q);
			}
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// a local class
	class Question {
		String question;
		String[] answers;

		public Question(String[] words) {
			question = words[0];
			answers = words;
		}
	}
}
