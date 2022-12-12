import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: CountDown
 * 
 * A Swing program that counts down second using a JLabel.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Calculator extends Program {

	private final String[] btnNames = { "7", "8", "9", "/", "4", "5", "6", "*",
			"1", "2", "3", "-", ".", "0", "=", "+" };

	private JTextField display;
	private double operand1 = 0;
	private char operation = '+';

	public void init() {
		setSize(300, 300);

		display = new JTextField(10);
		display.setEditable(false);
		display.setFont(new Font("Arial", Font.BOLD, 32));
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		add(display, NORTH);

		setLayout(new GridLayout(4, 4));
		for (int i = 0; i < btnNames.length; i++) {
			JButton btn = new JButton(btnNames[i]);
			add(btn);
		}

		addActionListeners();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		char cmd = e.getActionCommand().charAt(0);
		switch (cmd) {
		case '=':
			double operand2 = Double.parseDouble(display.getText());
			double result = calculate(operand1, operand2, operation);
			display.setText("" + result);
			break;
		case '+':
		case '-':
		case '*':
		case '/':
			operand1 = Double.parseDouble(display.getText());
			display.setText("");
			operation = cmd;
			break;
		case '.':
		default:
			display.setText(display.getText() + cmd);
			break;
		}
	}

	private double calculate(double operand1, double operand2, char operation) {
		double result = 0;
		switch (operation) {
		case '+':
			result = operand1 + operand2;
			break;
		case '-':
			result = operand1 - operand2;
			break;
		case '*':
			result = operand1 * operand2;
			break;
		case '/':
			result = operand1 / operand2;
			break;
		}
		return result;
	}
}
