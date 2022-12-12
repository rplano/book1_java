import java.awt.event.ActionEvent;

import javax.swing.JButton;

import acm.program.ConsoleProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * Swing: 3. OKCancel
 * 
 * @see http://www.variationenzumthema.de/
 * @author Ralph P. Lano
 */
public class OKCancel extends ConsoleProgram {

	public void init() {
		setSize(300, 150);
		JButton btn = new JButton("OK");
		add(btn, SOUTH);

		addActionListeners();
	}

	public void actionPerformed(ActionEvent e) {
		println("hi:" + e.getActionCommand());
	}

}