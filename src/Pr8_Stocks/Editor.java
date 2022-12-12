import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import acm.program.Program;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Stocks: Editor
 * 
 * A Swing program allowing you to load, edit and save text files.
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class Editor extends Program {

	private JTextArea display;
	private JTextField tfFileName;

	public void init() {
		setSize(400, 300);

		display = new JTextArea();
		display.setFont(new Font("Courier", Font.BOLD, 18));
		add(new JScrollPane(display), CENTER);

		tfFileName = new JTextField(10);
		tfFileName.setText("test.txt");
		add(tfFileName, SOUTH);

		JButton btnOpen = new JButton("Open");
		add(btnOpen, SOUTH);
		JButton btnSave = new JButton("Save");
		add(btnSave, SOUTH);

		addActionListeners();
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Open")) {
			openFile(tfFileName.getText());
		} else if (cmd.equals("Save")) {
			saveFile(tfFileName.getText());
		}
	}

	private void saveFile(String fileName) {
		try {
			FileWriter fw = new FileWriter(fileName);
			fw.write(display.getText());
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void openFile(String fileName) {
		try {
			String text = "";
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				text += line + "\n";
			}
			br.close();
			display.setText(text);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
