import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: Editor
 * 
 * A Swing program that counts down second using a JLabel.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Editor extends Program {

	private JTextArea display;
	private JTextField tfFileName;

	public void init() {
		setSize(300, 300);

		display = new JTextArea();
		display.setFont(new Font("Courier", Font.BOLD, 18));
		add(display, CENTER);

		tfFileName = new JTextField(10);
		tfFileName.setText("test.txt");
		add(tfFileName, SOUTH);

		JButton btnOpen = new JButton("Open");
		add(btnOpen, SOUTH);
		JButton btnSave = new JButton("Save");
		add(btnSave, SOUTH);

		addActionListeners();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Open")) {
			openFile(tfFileName.getText());
		} else if (cmd.equals("Save")) {
			saveFile(tfFileName.getText());
		}
	}

	private void saveFile(String fileName) {
		println("Here we should save the text to the file named " +fileName);
	}

	private void openFile(String fileName) {
		println("Here we should read the text from the file named " +fileName);
	}
}
